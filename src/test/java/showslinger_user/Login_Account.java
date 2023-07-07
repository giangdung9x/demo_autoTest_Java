package showslinger_user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class Login_Account extends BaseTest{
	private WebDriver driver;
	private String invalidEmail, invalidPassword, notExistingEmail;
	private String emailManager, validPasswordManager;
	private String emailStaffAuto, passwordStaffAuto;
	private String emailStaffManual, passwordStaffManual;
	private String emailConcession, passwordConcession;

	private UserHomePageObject homePage  ;
	private UserLoginPageObject loginPage;




	@Parameters({ "envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName,
	@Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String
	portNumber,@Optional("Windows") String osName, @Optional("10") String osVersion) {
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
		homePage = new UserHomePageObject(driver);

		invalidEmail = "abc@xyz";
		invalidPassword = "12";
		notExistingEmail = "abc@xyz.comm";

		emailStaffAuto = "dangthigiang+15@mobilefolk.com";
		passwordStaffAuto = "123456";

		emailStaffManual = "dangthigiang+10@mobilefolk.com";
		passwordStaffManual = "123456";

		emailManager ="paulv@showslinger.com";
		validPasswordManager = "12345";

		emailConcession ="dangthigiang+20@mobilefolk.com";
		passwordConcession = "123456";

	}

	@Description("Open form Log In")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Login_001_FormLogin() {
		homePage.clickToLoginLink();

		loginPage = new UserLoginPageObject(driver);

		assertTrue(loginPage.isTextLogInDisplayed());
	}


	@Description("Log In Account - Empty Data")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Login_002_EmptyData() {
		loginPage.clickToLoginButton();

		assertTrue(loginPage.isTextLogInDisplayed());

	}

	@Description("Log In Account - Invalid Email")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Login_003_InvalidEmail() {
		loginPage.loginAccount(invalidEmail, "");


		loginPage.clickToLoginButton();

		assertTrue(loginPage.isTextLogInDisplayed());
	}

	@Description("Log In Account - Account Not Found")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Login_004_AccNotFound() {
		loginPage.loginAccount(notExistingEmail, "");


		loginPage.clickToLoginButton();

		assertTrue(loginPage.isTextLogInDisplayed());
	}

	@Description("Log In Account - Empty Password")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Login_005_AccRegisteredEmptyPassword() {
		loginPage.loginAccount(emailManager, "");

		loginPage.clickToLoginButton();

		assertTrue(loginPage.isTextLogInDisplayed());
	}

	@Description("Log In Account - Invalid Password")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void Login_006_AccRegisteredInvalidPassword() {

		loginPage.loginAccount(emailManager, invalidPassword);

		loginPage.clickToLoginButton();

		assertTrue(loginPage.isTextLogInDisplayed());
	}

	@Description("Log In Account - Login Account Manager Success")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void Login_007_AccManagerCompleted() {

		loginPage.loginAccount(emailManager, validPasswordManager);


		loginPage.clickToLoginButton();

		homePage = new UserHomePageObject(driver);

		assertTrue(homePage.isCalendarLinkDisplayed());

		homePage.clickShowLeftMenu();

		homePage.clickToItemOfLeftMenu("Account");
		
		homePage.clickToItemOfListTicketing("Sign out");

		assertTrue(homePage.isTextDisplayed());
		
	}

	@Description("Log In Account - Login Account Staff Manual Success")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void Login_008_AccStaffManualCompleted() {
		homePage.authenAlert();
		
		homePage.clickToLoginLink();

		loginPage = new UserLoginPageObject(driver);

		assertTrue(loginPage.isTextLogInDisplayed());

		
		loginPage.loginAccount(emailStaffManual, passwordStaffManual);


		loginPage.clickToLoginButton();

		homePage = new UserHomePageObject(driver);

		assertTrue(homePage.isTextBoxOfficeDisplayed());

		homePage.clickMoreMenu();

		homePage.clickButtonLogOutStaff();

		assertTrue(homePage.isTextDisplayed());
		
	}

	@Description("Log In Account - Login Account Staff Auto Success")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void Login_009_AccStaffAutoCompleted() {
		homePage.authenAlert();

		
		homePage.clickToLoginLink();

		loginPage = new UserLoginPageObject(driver);

		assertTrue(loginPage.isTextLogInDisplayed());

		loginPage.loginAccount(emailStaffAuto, passwordStaffAuto);

		loginPage.clickToLoginButton();

		homePage = new UserHomePageObject(driver);

		assertTrue(homePage.isTextBoxOfficeDisplayed());

		homePage.clickMoreMenu();

		homePage.clickButtonLogOutStaff();

		assertTrue(homePage.isTextDisplayed());
		
	}

	@Description("Log In Account - Login Account Concession Success")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void Login_010_AccConcessionsCompleted() {
		homePage.authenAlert();


		homePage.clickToLoginLink();

		loginPage = new UserLoginPageObject(driver);

		assertTrue(loginPage.isTextLogInDisplayed());

		loginPage.loginAccount(emailConcession, passwordConcession);
		
		loginPage.clickToLoginButton();

		homePage = new UserHomePageObject(driver);
		
		assertTrue(homePage.isTextboxConcesssions());

		homePage.clickButtonLogOutConcesssions();

		assertTrue(homePage.isTextDisplayed());
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
	



}
