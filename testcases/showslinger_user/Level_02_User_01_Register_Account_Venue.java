package showslinger_user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.GlobalConstants;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserRegisterVenuePageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_02_User_01_Register_Account_Venue extends BaseTest{

	private WebDriver driver;

	private String osName = System.getProperty("os.name");
	private String projectPath = System.getProperty("user.dir");
	private UserHomePageObject homePage  ;
	private UserRegisterVenuePageObject registerVenuePage;
    private String portalPageUrl;

    //portalUrl : homepage
    @Parameters({"browser", "portalURL"})
	@BeforeClass
	public void beforeClass(String browserName, String portalURL) {
		driver = getBrowserDriver(browserName, portalURL);
		homePage = new UserHomePageObject(driver);
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
