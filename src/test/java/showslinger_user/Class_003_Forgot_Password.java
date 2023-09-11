package showslinger_user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.user.UserForgotPasswordObject;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;


public class Class_003_Forgot_Password extends BaseTest{
	private WebDriver driver;
	private String existingEmail, invalidEmail, notExistingEmail;

	private UserHomePageObject homePage  ;
	private UserLoginPageObject loginPage;
	private UserForgotPasswordObject forgotPasswordPage;



	@Parameters({ "envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("localhost") String ipAddress,
							@Optional("4444") String portNumber, @Optional("Windows") String osName, @Optional("10") String osVersion) {
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
		homePage = new UserHomePageObject(driver);

		existingEmail ="dangthigiang+82@gmail.com";
		invalidEmail ="abc@xyz";
		notExistingEmail = "abc@xyz.com";
	}




	@Description("Open Form Forgot Password")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void ForgotPassword_001_FormForgotPassword() {
		homePage.clickToLoginLink();

		loginPage = new UserLoginPageObject(driver);

		loginPage.clickToForgotPasswordLink();
	}

	@Description("Forgot Password- Empty Data")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void ForgotPassword_002_EmptyData() {
		forgotPasswordPage = new UserForgotPasswordObject(driver);
		
		assertTrue(forgotPasswordPage.isTextForgotPassword());		
		
		forgotPasswordPage.clickToResetPasswordButton();
	}


	@Description("Forgot Password - Invalid Email")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void ForgotPassword_003_InvalidEmail() {
		forgotPasswordPage.inputToEmailTextbox(invalidEmail);

		forgotPasswordPage.clickToResetPasswordButton();
	}

	@Description("Forgot Password - Not Existing Email")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void ForgotPassword_004_NotExistingEmail() {
		forgotPasswordPage.inputToEmailTextbox(notExistingEmail);

		forgotPasswordPage.clickToResetPasswordButton();
	}


	@Description("Forgot Password - Existing Email - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void ForgotPassword_005_ExistingEmail() {

		forgotPasswordPage.inputToEmailTextbox(existingEmail);

		forgotPasswordPage.clickToResetPasswordButton();
	}


	@AfterClass
	public void afterClass() {
//		driver.quit();
		closeBrowserDriver();
	}



}
