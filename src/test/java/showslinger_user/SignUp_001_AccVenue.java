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
import utilities.ExcelHelper;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class SignUp_001_AccVenue extends BaseTest{
	private WebDriver driver;
	private UserHomePageObject homePage  ;
	private UserRegisterVenuePageObject registerVenuePage;
	
	private String nameOfVenue, validEmail, validPassword, existingEmail, invalidEmail, invalidPasssword;
	private String venueName, streetAddress, townCity, validZipCode, invalidZipCode; 
	
	private ExcelHelper excelHelper;

	@Parameters({ "envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName,
	@Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String
	portNumber,@Optional("Windows") String osName, @Optional("10") String osVersion)  throws Exception {
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
		homePage = new UserHomePageObject(driver);
		excelHelper = new ExcelHelper();
		excelHelper.setExcelFile("src/test/resources/DataTest/SignUp.xlsx", "Data");

		//nameOfVenue = "Dang Giang "+ generateFakeNumberDateTime();
		nameOfVenue = excelHelper.getCellData("nameVenue", 6) + " " + generateFakeNumberDateTime();
		validEmail = excelHelper.getCellData("Email", 1) +"+"+ generateFakeNumberDateTime() + "@mobilefolk.com";
		validPassword = excelHelper.getCellData("Password", 1);
		existingEmail =  excelHelper.getCellData("Email", 2);
		invalidEmail =  excelHelper.getCellData("Email", 3);
		invalidPasssword =  excelHelper.getCellData("Password", 3);
		
		venueName = nameOfVenue; 
		streetAddress= excelHelper.getCellData("streetAddress", 4);
		townCity= excelHelper.getCellData("townCity", 4);
		validZipCode= excelHelper.getCellData("ZipCode", 4);
		invalidZipCode = excelHelper.getCellData("ZipCode", 5);
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
	public void AccVenue_002_RegisterEmptyData() throws Exception{
		excelHelper.setExcelFile("src/test/resources/DataTest/SignUp.xlsx", "Message");
		registerVenuePage.clickToRegisterButton();
		assertEquals(registerVenuePage.getErrorMessageAtEmailTextbox(),excelHelper.getCellData("Message", 2));
		assertEquals(registerVenuePage.getErrorMessageAtPasswordTextbox(),excelHelper.getCellData("Message", 3));
		assertEquals(registerVenuePage.getErrorMessageAtConfirmPasswordTextbox(),excelHelper.getCellData("Message", 4));
	}
	
	
	@Description("Register account Venue - Don't verify ReCAPTCHA")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void AccVenue_003_RegisterNotVerifyReCAPTCHA() throws Exception{
		excelHelper.setExcelFile("src/test/resources/DataTest/SignUp.xlsx", "Message");
		registerVenuePage.inputToTextbox("Name", nameOfVenue);
		registerVenuePage.inputToTextbox("Email",validEmail);	
		registerVenuePage.inputToTextbox("Password",validPassword);
		registerVenuePage.clickCheckboxAcceptTerms();
		registerVenuePage.clickToRegisterButton();
		assertEquals(registerVenuePage.getErrorMessageAtHeader(),excelHelper.getCellData("Message", 5));
	}
	
	@Description("Register account Venue - input email already exists")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void AccVenue_004_RegisterEmailAlredyExists() throws Exception{
		excelHelper.setExcelFile("src/test/resources/DataTest/SignUp.xlsx", "Message");
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
		
		assertEquals(registerVenuePage.getErrorMessageAtHeader(),excelHelper.getCellData("Message", 6));

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
		assertEquals(registerVenuePage.getErrorMessageAtHeader(),excelHelper.getCellData("Message", 7));
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
		
		assertEquals(registerVenuePage.getErrorMessageAtField("Venue Name"),excelHelper.getCellData("Message", 8));
		assertEquals(registerVenuePage.getErrorMessageAtField("Street Address 1"),excelHelper.getCellData("Message", 9));
		assertEquals(registerVenuePage.getErrorMessageAtField("Town/City"),excelHelper.getCellData("Message", 10));
		assertEquals(registerVenuePage.getErrorMessageAtField("Zip/Postal Code"),excelHelper.getCellData("Message", 11));
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
		
		assertEquals(registerVenuePage.getErrorMessageAtField("Zip/Postal Code"),excelHelper.getCellData("Message", 12));
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
		
		assertEquals(registerVenuePage.getErrorMessageUploadPhoto(),excelHelper.getCellData("Message", 13));
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
