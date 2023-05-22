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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;
import pageObject.user.UserRegisterVenuePageObject;

public class User_03_Login_Account_User extends BaseTest{
	private WebDriver driver;
	private String existingEmail, validPassword;

	private UserHomePageObject homePage  ;
	private UserRegisterVenuePageObject registerVenuePage;
	private UserLoginPageObject loginPage;
	
	
	
	//portalUrl : homepage
    @Parameters({"browser", "portalURL"})
	@BeforeClass
	public void beforeClass(String browserName, String portalURL) {
		driver = getBrowserDriver(browserName, portalURL);
		homePage = new UserHomePageObject(driver);

		existingEmail ="paulv@showslinger.com";
		validPassword = "12345";
	}


	@Test
	public void Login_01_Login_Successfully() {
		System.out.println("Login_01 - Step 01: Click to Login link");
		homePage.clickToLoginLink();

		loginPage = new UserLoginPageObject(driver);
		
		System.out.println("Login_01 - Step 02: Input Email Textbox & Password Textbox");
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(validPassword);

		System.out.println("Login_01 - Step 03: Click to Login button");
		loginPage.clickToLoginButton();
		
		homePage = new UserHomePageObject(driver);

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
		Assert.assertTrue(homePage.isTextDisplayed());

	}
	
	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }



}
