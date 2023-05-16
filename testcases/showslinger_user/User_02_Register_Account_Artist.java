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
import pageObject.user.UserRegisterArtistPageObject;
import pageObject.user.UserRegisterVenuePageObject;

public class User_02_Register_Account_Artist extends BaseTest{
	private WebDriver driver;

	private String osName = System.getProperty("os.name");
	private String projectPath = System.getProperty("user.dir");
	private UserHomePageObject homePage  ;
	private UserRegisterArtistPageObject registerArtistPage;
	
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

		registerArtistPage = new UserRegisterArtistPageObject(driver);
		System.out.println("Register_01 - Step 02: Call form Register"); //double click image
		registerArtistPage.clickToCallFormResgiter();
		registerArtistPage.clickToRadioButtonArtist();

		System.out.println("Register_01 - Step 03: Click to Register button");
		registerArtistPage.clickToRegisterButton();

		System.out.println("Register_01 - Step 04: Verify error message displayed");
		Assert.assertEquals(registerArtistPage.getErrorMessageAtEmailTextbox(),"Please enter your email");
		Assert.assertEquals(registerArtistPage.getErrorMessageAtPasswordTextbox(),"Please enter your password");
		Assert.assertEquals(registerArtistPage.getErrorMessageAtConfirmPasswordTextbox(),"You must agree to the terms of service to continue");
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
