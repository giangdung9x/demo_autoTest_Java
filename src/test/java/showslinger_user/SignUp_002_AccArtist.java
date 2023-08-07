package showslinger_user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserRegisterArtistPageObject;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

@Test(enabled = false)
public class SignUp_002_AccArtist extends BaseTest{
	private WebDriver driver;
	private UserHomePageObject homePage  ;
	private UserRegisterArtistPageObject registerArtistPage;
	
	private String nameOfArtist, validEmail, validPassword, existingEmail, invalidEmail;
	private String artistName, homeTown, postalCode;
	

	@Parameters({ "envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName,
	@Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String
	portNumber,@Optional("Windows") String osName, @Optional("10") String osVersion) {
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
		homePage = new UserHomePageObject(driver);
		
		nameOfArtist = "Dang Giang "+ generateFakeNumber();
		validEmail = "dangthigiang" +"+"+ generateFakeNumber() + "@mobilefolk.com";
		validPassword = "123456";
		existingEmail = "danggiangmf@gmail.com";
		invalidEmail = "dabc@aaaa";
		
		artistName = nameOfArtist; 
		homeTown="West Danville"; 
		postalCode="05862";
	}
    

    @Description("Call form register account Artist")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void AccArtist_001_FormRegister() {
		homePage.clickToRegisterLink();

		registerArtistPage = new UserRegisterArtistPageObject(driver);
		
		registerArtistPage.clickToCallFormResgiter();
		registerArtistPage.clickToRadioButtonArtist();
	}

    @Description("Call form register account Artist")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void AccArtist_002_RegisterEmptyData() {
		registerArtistPage.clickToRegisterButton();

		Assert.assertEquals(registerArtistPage.getErrorMessageAtEmailTextbox(),"Please enter your email");
		Assert.assertEquals(registerArtistPage.getErrorMessageAtPasswordTextbox(),"Please enter your password");
		Assert.assertEquals(registerArtistPage.getErrorMessageAtConfirmPasswordTextbox(),"You must agree to the terms of service to continue");
	}

    @Description("Register Account Artist - Not Verify ReCAPTCHA")
  	@Severity(SeverityLevel.NORMAL)
  	@Test
  	public void AccArtist_003_RegisterNotVerifyReCAPTCHA() { 
    	registerArtistPage.inputToTextbox("Name", nameOfArtist);
    	registerArtistPage.inputToTextbox("Email",validEmail);	
    	registerArtistPage.inputToTextbox("Password",validPassword);	
		
    	registerArtistPage.clickCheckboxAcceptTerms();
		
    	registerArtistPage.clickToRegisterButton();
	
		assertEquals(registerArtistPage.getErrorMessageAtHeader(),"Please verify that you are human");

	}

  
    
    @Description("Register Account Artist - Input Email Alredy Exists")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void AccArtist_004_RegisterEmailAlredyExists() {
    	registerArtistPage.clickToCallFormResgiter();
    	registerArtistPage.clickToRadioButtonArtist();
		
    	registerArtistPage.inputToTextbox("Name", nameOfArtist);
    	registerArtistPage.inputToTextbox("Email",existingEmail);	
    	registerArtistPage.inputToTextbox("Password",validPassword);	
				
//		registerArtistPage.switchToFrameIframe();
//		registerArtistPage.clickCheckboxNotRobot();
//		registerArtistPage.switchToSignInPage();

		//manual verify reCAPTCHA
    	registerArtistPage.sleepInSecond(10);

    	registerArtistPage.clickToRegisterButton();
		
		assertEquals(registerArtistPage.getErrorMessageAtHeader(),"Signup failed! Please check your info and try again.");

	}
    
    @Description("Register Account Artist - Input Email Wrong")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void AccArtist_005_RegisterEmailWrong() {
    	registerArtistPage.clickToCallFormResgiter();
    	registerArtistPage.clickToRadioButtonArtist();
		
    	registerArtistPage.inputToTextbox("Name", nameOfArtist);
    	registerArtistPage.inputToTextbox("Email",invalidEmail);	
    	registerArtistPage.inputToTextbox("Password",validPassword);	
		
//		registerArtistPage.clickCheckboxAcceptTerms();
		
//		registerArtistPage.switchToFrameIframe();
//		registerArtistPage.clickCheckboxNotRobot();
//		registerArtistPage.switchToSignInPage();

		//manual verify reCAPTCHA
    	registerArtistPage.sleepInSecond(10);
		
    	registerArtistPage.clickToRegisterButton();
		assertEquals(registerArtistPage.getErrorMessageAtHeader(),"Signup failed! Please check your info and try again.");

	}
	
	
    @Description("Register Account Artist - Artist Profile Empty")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void AccArtist_006_RegisterArtistProfileEmpty() {
    	registerArtistPage.clickToCallFormResgiter();
    	registerArtistPage.clickToRadioButtonArtist();
		
    	registerArtistPage.inputToTextbox("Name", nameOfArtist);
    	registerArtistPage.inputToTextbox("Email",validEmail);	
    	registerArtistPage.inputToTextbox("Password",validPassword);	
		
//		registerArtistPage.clickCheckboxAcceptTerms();
		
//		registerArtistPage.switchToFrameIframe();
//		registerArtistPage.clickCheckboxNotRobot();
//		registerArtistPage.switchToSignInPage();
		
		//manual verify reCAPTCHA
    	registerArtistPage.sleepInSecond(10);
		
    	registerArtistPage.clickToRegisterButton();
		
		assertTrue(registerArtistPage.isTextProfileInformation());	
		registerArtistPage.clickToButtonNext();
		
		assertEquals(registerArtistPage.getErrorMessageAtHeader(),"Please enter the required info");

	}
	
    @Description("Register Account Artist - Artist Phone Empty")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void AccArtist_007_RegisterArtistPhoneEmpty() {
    	registerArtistPage.inputToTextboxProfile("Name", artistName);
    	registerArtistPage.inputToTextboxProfile("Postal code",postalCode);	
    	registerArtistPage.inputToTextboxProfile("Hometown",homeTown);	
    	registerArtistPage.selectDropdownProfileType("Cover Music");
    	
    	registerArtistPage.clickToButtonNext();
    	
		assertTrue(registerArtistPage.isTextWeNeed());	
    	
    	registerArtistPage.clickToButtonSend();
    	
    	registerArtistPage.acceptAlert();
    	
	}
	
	
    @Description("Register Account Artist - Skip Input Phone")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void AccArtist_008_RegisterCompteledSkipInputPhone() {
    	registerArtistPage.clickToButtonSkip();

		assertTrue(registerArtistPage.isTextDashboard());	
	}
	

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);

	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
