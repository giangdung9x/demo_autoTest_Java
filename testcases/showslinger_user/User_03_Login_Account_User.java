package showslinger_user;

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
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;
import pageObject.user.UserRegisterVenuePageObject;

public class User_03_Login_Account_User extends BaseTest{
	private WebDriver driver;
	private String existingEmail, validPassword;

	private String osName = System.getProperty("os.name");
	private String projectPath = System.getProperty("user.dir");
	private UserHomePageObject homePage  ;
	private UserRegisterVenuePageObject registerVenuePage;
	private UserLoginPageObject loginPage;
	
	
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac OS")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDriver/geckodriver");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		}
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		existingEmail ="paulv@showslinger.com";
		validPassword = "12345";
	}

	@Test 
	public void Login_00_Alert_Authen() {
		driver.get(UsernameandPassword("https://showslinger-staging.herokuapp.com/", "SS15243", "12345"));
		Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Artists']")).isDisplayed());
	}

	public String UsernameandPassword (String url, String username, String password){
		String [] arrayurl = url.split("//");
		return arrayurl[0] + "//" + username +":"+ password + "@" + arrayurl[1];
	}


	@Test
	public void Login_01_Login_Successfully() {
		System.out.println("Login_01 - Step 01: Click to Login link");
		driver.findElement(By.xpath("//li[@id='nav-menu-item-15650']//a")).click();

		loginPage = new UserLoginPageObject(driver);
		
		System.out.println("Login_01 - Step 02: Input Email Textbox & Password Textbox");
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(validPassword);

		System.out.println("Login_01 - Step 03: Click to Login button");
		driver.findElement(By.xpath("(//input[@name='commit'])[1]")).click();
		
		//Login thành công -> HomePage
		homePage = new UserHomePageObject(driver);

		//Verify trang HomePage
		System.out.println("Login_01 - Step 04: Verify HomePage");
		Assert.assertTrue(homePage.isCalendarLinkDisplayed());
	}
	
	@Test
	public void Logout_02_Logout_Account() {
		System.out.println("Logout_02 - Step 01: Click avatar user");
		driver.findElement(By.xpath("//a[@class='nav-item-toggle']//img[@class='rounded-circle']")).click();

		System.out.println("Logout_02 - Step 02: Click Sign out");
		driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();
		
		System.out.println("Logout_02 - Step 03: Verify page");
		Assert.assertTrue(homePage.isLinkTextDisplayed());

	}
	
	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }



}
