package showslinger_user;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import pageObject.user.UserRegisterVenuePageObject;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class SignUp_001_AccVenue extends BaseTest{
	private WebDriver driver;
	private UserHomePageObject homePage  ;
	private UserRegisterVenuePageObject registerVenuePage;
	
	private String nameOfVenue, validEmail, validPassword, existingEmail, invalidEmail, invalidPasssword;
	private String venueName, streetAddress, townCity, validZipCode, invalidZipCode; 
	
	

	@Parameters({ "envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName,
	@Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String
	portNumber,@Optional("Windows") String osName, @Optional("10") String osVersion) {
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
		homePage = new UserHomePageObject(driver);
		
		
		nameOfVenue = "Dang Giang "+ generateFakeNumberDateTime();
		validEmail = "dangthigiang" +"+"+ generateFakeNumberDateTime() + "@mobilefolk.com";
		validPassword = "123456";
		existingEmail = "paulv@showslinger.com";
		invalidEmail = "dabc@aaaa";
		invalidPasssword = "1";
		
		venueName = nameOfVenue; 
		streetAddress="Hapenny Road"; 
		townCity="West Danville"; 
		validZipCode="05862";
		invalidZipCode ="1";
	}
    
	@Description("Call form register account Venue")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void AccVenue_001_FormRegister() {
		homePage.clickToRegisterLink();

		registerVenuePage = new UserRegisterVenuePageObject(driver);
		
		registerVenuePage.clickToCallFormResgiter();
		registerVenuePage.clickToRadioButtonVenue();
	}

	@Description("Register account Venue -  when empty data")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void AccVenue_002_RegisterEmptyData() {
		registerVenuePage.clickToRegisterButton();

		assertEquals(registerVenuePage.getErrorMessageAtEmailTextbox(),"Please enter your email");
		assertEquals(registerVenuePage.getErrorMessageAtPasswordTextbox(),"Please enter your password");
		assertEquals(registerVenuePage.getErrorMessageAtConfirmPasswordTextbox(),"You must agree to the terms of service to continue");
	}
	
	
	@Description("Register account Venue - Don't verify ReCAPTCHA")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void AccVenue_003_RegisterNotVerifyReCAPTCHA() {
		registerVenuePage.inputToTextbox("Name", nameOfVenue);
		registerVenuePage.inputToTextbox("Email",validEmail);	
		registerVenuePage.inputToTextbox("Password",validPassword);	
		
		registerVenuePage.clickCheckboxAcceptTerms();
		
		registerVenuePage.clickToRegisterButton();
		 
		assertEquals(registerVenuePage.getErrorMessageAtHeader(),"Please verify that you are human");
	}
	
	@Description("Register account Venue - input email already exists")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void AccVenue_004_RegisterEmailAlredyExists() {
		registerVenuePage.clickToCallFormResgiter();
		registerVenuePage.clickToRadioButtonVenue();
		
		registerVenuePage.inputToTextbox("Name", nameOfVenue);
		registerVenuePage.inputToTextbox("Email",existingEmail);	
		registerVenuePage.inputToTextbox("Password",validPassword);	
				
//		registerVenuePage.switchToFrameIframe();
//		registerVenuePage.clickCheckboxNotRobot();
//		registerVenuePage.switchToSignInPage();

		//manual verify reCAPTCHA
		registerVenuePage.sleepInSecond(10);

		registerVenuePage.clickToRegisterButton();
		
		assertEquals(registerVenuePage.getErrorMessageAtHeader(),"Signup failed! Please check your info and try again.");

	}
	
	@Description("Register account Venue - input email is wrong")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void AccVenue_005_RegisterEmailWrong() {
		registerVenuePage.clickToCallFormResgiter();
		registerVenuePage.clickToRadioButtonVenue();
		
		registerVenuePage.inputToTextbox("Name", nameOfVenue);
		registerVenuePage.inputToTextbox("Email",invalidEmail);	
		registerVenuePage.inputToTextbox("Password",validPassword);	
		
//		registerVenuePage.clickCheckboxAcceptTerms();
		
//		registerVenuePage.switchToFrameIframe();
//		registerVenuePage.clickCheckboxNotRobot();
//		registerVenuePage.switchToSignInPage();

		//manual verify reCAPTCHA
		registerVenuePage.sleepInSecond(10);
		
		registerVenuePage.clickToRegisterButton();
		assertEquals(registerVenuePage.getErrorMessageAtHeader(),"Signup failed! Please check your info and try again.");

	}
	
	
	@Description("Register account Venue Profile - Empty data")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void AccVenue_006_RegisterVenueProfileEmpty() {
		registerVenuePage.clickToCallFormResgiter();
		registerVenuePage.clickToRadioButtonVenue();
		
		registerVenuePage.inputToTextbox("Name", nameOfVenue);
		registerVenuePage.inputToTextbox("Email",validEmail);	
		registerVenuePage.inputToTextbox("Password",validPassword);	
		
//		registerVenuePage.clickCheckboxAcceptTerms();
		
//		registerVenuePage.switchToFrameIframe();
//		registerVenuePage.clickCheckboxNotRobot();
//		registerVenuePage.switchToSignInPage();
		
		//manual verify reCAPTCHA
		registerVenuePage.sleepInSecond(10);
		
		registerVenuePage.clickToRegisterButton();
		
		assertTrue(registerVenuePage.isTextCreateYourVenueProfile());	
		registerVenuePage.clickToButtonCreateVenue();
		
		assertEquals(registerVenuePage.getErrorMessageAtField("Venue Name"),"can't be blank");
		assertEquals(registerVenuePage.getErrorMessageAtField("Street Address 1"),"can't be blank");
		assertEquals(registerVenuePage.getErrorMessageAtField("Town/City"),"can't be blank");
		assertEquals(registerVenuePage.getErrorMessageAtField("Zip/Postal Code"),"Your zipcode should be in the form 12345 or 12345-1234.");
	}
	
	@Description("Register account Venue Profile - zip code is wrong")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void AccVenue_007_RegisterVenueProfileZipCodeWrong() {
		registerVenuePage.inputToTextboxProfile("Venue Name", venueName);
		registerVenuePage.inputToTextboxProfile("Street Address 1",streetAddress);	
		registerVenuePage.inputToTextboxProfile("Town/City",townCity);	
		registerVenuePage.inputToTextboxProfile("Zip/Postal Code",invalidZipCode);	
		
		registerVenuePage.clickToButtonCreateVenue();
		
		assertEquals(registerVenuePage.getErrorMessageAtField("Zip/Postal Code"),"Your zipcode should be in the form 12345 or 12345-1234.");
	}
	
	@Description("Register account Venue Profile - Photo empty data")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void AccVenue_008_RegisterVenueAddPhotoEmpty() {
		registerVenuePage.inputToTextboxProfile("Venue Name", venueName);
		registerVenuePage.inputToTextboxProfile("Street Address 1",streetAddress);	
		registerVenuePage.inputToTextboxProfile("Town/City",townCity);	
		registerVenuePage.inputToTextboxProfile("Zip/Postal Code",validZipCode);	
		
		registerVenuePage.clickToButtonCreateVenue();
		
		assertTrue(registerVenuePage.isTextAddPhoto());	
		registerVenuePage.clickToButtonUpload();
		
		assertEquals(registerVenuePage.getErrorMessageUploadPhoto(),"You must choose a photo to be uploaded");
	}
	
	
	@Description("Register account Venue Profile - register complelet - Skip upload photo")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void AccVenue_009_RegisterCompteledSkipUploadImage() {
		registerVenuePage.clickToButtonSkip();
		registerVenuePage.clickShowLeftMenu();
		assertTrue(registerVenuePage.isTextTicketing());	
	}
	
	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	public static long generateFakeNumberDateTime() {
		LocalDateTime now = LocalDateTime.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		String formattedDateTime = now.format(formatter);

		return Long.parseLong(formattedDateTime);
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
