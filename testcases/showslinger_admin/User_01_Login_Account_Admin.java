package showslinger_admin;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.admin.AdminDashboardPageObject;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;
import pageObject.user.UserRegisterVenuePageObject;

public class User_01_Login_Account_Admin extends BaseTest{
	private WebDriver driver;
	private String existingEmail, validPassword;

	private String osName = System.getProperty("os.name");
	private String projectPath = System.getProperty("user.dir");
	private UserHomePageObject homePage  ;
	private UserRegisterVenuePageObject registerVenuePage;
	private UserLoginPageObject loginPage;
	private AdminDashboardPageObject adminDashboardPage;
	
	//portalUrl : admin
    @Parameters({"browser", "portalURL"})
	@BeforeClass
	public void beforeClass(String browserName, String portalURL) {
		driver = getBrowserDriver(browserName, portalURL);		

		existingEmail ="paulv@showslinger.com";
		validPassword = "12345";
	}
	

	@Test 
	public void Login_00_Alert_Authen() {
		driver.get(UsernameandPassword("https://showslinger-staging.herokuapp.com/admin", "SS15243", "12345"));
		Assert.assertTrue(driver.findElement(By.xpath("(//h3[@class='title-text'][normalize-space()='Log in'])[1]")).isDisplayed());
	}

	public String UsernameandPassword (String url, String username, String password){
		String [] arrayurl = url.split("//");
		return arrayurl[0] + "//" + username +":"+ password + "@" + arrayurl[1];
	}


	@Test
	public void Login_01_Login_Successfully() {
		loginPage = new UserLoginPageObject(driver);
		
		System.out.println("Login_01 - Step 02: Input Email Textbox & Password Textbox");
		loginPage.inputToTextboxLogin("email",existingEmail);
		loginPage.inputToTextboxLogin("password", validPassword);

		System.out.println("Login_01 - Step 03: Click to Login button");
		driver.findElement(By.xpath("(//input[@name='commit'])[1]")).click();
		
		adminDashboardPage= new AdminDashboardPageObject(driver);

		System.out.println("Login_01 - Step 04: Verify Dashboard Page");
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
	}
	
	@Test
	public void Login_02_Logout_Account() {

		System.out.println("Logout_02 - Step 02: Click Sign out");
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		
		System.out.println("Logout_02 - Step 03: Verify page");
		Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Artists']")).isDisplayed());


	}

	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }


}
