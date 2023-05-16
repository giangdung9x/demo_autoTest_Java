package showslinger_user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
import pageObject.user.UserRegisterVenuePageObject;

public class User_01_Register_Account_Venue extends BaseTest{
	private WebDriver driver;

	private String osName = System.getProperty("os.name");
	private String projectPath = System.getProperty("user.dir");
	private UserHomePageObject homePage  ;
	private UserRegisterVenuePageObject registerVenuePage;
	
	
	//portalUrl : homepage
    @Parameters({"browser", "portalURL"})
	@BeforeClass
	public void beforeClass(String browserName, String portalURL) {
		driver = getBrowserDriver(browserName, portalURL);
		homePage = new UserHomePageObject(driver);
	}

	@Test 
	public void Register_00_Alert_Authen() {
		driver.get(UsernameandPassword(GlobalConstants.PORTAL_PAGE_URL, "SS15243", "12345"));
		Assert.assertTrue(homePage.isTextDisplayed());
	}

	public String UsernameandPassword (String url, String username, String password){
		String [] arrayurl = url.split("//");
		return arrayurl[0] + "//" + username +":"+ password + "@" + arrayurl[1];
	}


	@Test
	public void Register_01_Register_Empty_Data() {
		System.out.println("Register_01 - Step 01: Click to Register link");
		homePage.clickToRegisterLink();

		registerVenuePage = new UserRegisterVenuePageObject(driver);
		System.out.println("Register_01 - Step 02: Call form Register"); //double click image
		registerVenuePage.clickToCallFormResgiter();
		registerVenuePage.clickToRadioButtonVenue();
		
		System.out.println("Register_01 - Step 03: Click to Register button");
		registerVenuePage.clickToRegisterButton();

		System.out.println("Register_01 - Step 04: Verify error message displayed");
		Assert.assertEquals(registerVenuePage.getErrorMessageAtEmailTextbox(),"Please enter your email");
		Assert.assertEquals(registerVenuePage.getErrorMessageAtPasswordTextbox(),"Please enter your password");
		Assert.assertEquals(registerVenuePage.getErrorMessageAtConfirmPasswordTextbox(),"You must agree to the terms of service to continue");
	}

	
	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
