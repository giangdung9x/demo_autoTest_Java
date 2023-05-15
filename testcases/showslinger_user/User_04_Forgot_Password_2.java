package showslinger_user;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.user.UserForgotPasswordObject;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;
import pageObject.user.UserRegisterVenuePageObject;

import java.util.concurrent.TimeUnit;

public class User_04_Forgot_Password_2 extends BaseTest{
	private WebDriver driver;
	private String existingEmail;
	
	private String osName = System.getProperty("os.name");
	private String projectPath = System.getProperty("user.dir");
	private UserHomePageObject homePage  ;
	private UserRegisterVenuePageObject registerVenuePage;
	private UserLoginPageObject loginPage;
	private UserForgotPasswordObject forgotPasswordPage;
	
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac OS")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDriver/geckodriver");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		}
		//driver = new FirefoxDriver();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		existingEmail ="dangthigiang+82@gmail.com";
	}

	@Test 
	public void Forgot_00_Alert_Authen() {
		driver.get(UsernameandPassword("https://showslinger-staging.herokuapp.com/", "SS15243", "12345"));
		Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Artists']")).isDisplayed());
	}

	public String UsernameandPassword (String url, String username, String password){
		String [] arrayurl = url.split("//");
		return arrayurl[0] + "//" + username +":"+ password + "@" + arrayurl[1];
	}


	@Test
	public void Forgot_01_Fotgot_Password_Successfully() {
		System.out.println("Forgot_01 - Step 01: Click to Login link");
		driver.findElement(By.xpath("//li[@id='nav-menu-item-15650']//a")).click();

		loginPage = new UserLoginPageObject(driver);
		
		System.out.println("Forgot_01 - Step 02: Click to Forgot passwork link");
		driver.findElement(By.xpath("(//a[normalize-space()='Forgot password?'])[1]")).click();

		System.out.println("Login_01 - Step 03: Input Email Textbox");
		loginPage.inputToEmailTextbox(existingEmail);

		System.out.println("Login_01 - Step 04: Click to Send me reset password instructions button");
		driver.findElement(By.xpath("(//input[@name='commit'])[1]")).click();
		
		//Verify trang HomePage
		System.out.println("Login_01 - Step 05: Verify message");
		Assert.assertEquals(loginPage.isMessageSuccessDisplayed(), "You will receive an email with instructions about how to reset your password in a few minutes.");
		
		
	}
	
	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }



}
