package showslinger_user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.user.UserForgotPasswordObject;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;


public class User_04_Forgot_Password extends BaseTest{
	private WebDriver driver;
	private String existingEmail;
	
	private UserHomePageObject homePage  ;
	private UserLoginPageObject loginPage;
	private UserForgotPasswordObject forgotPasswordPage;
	
	
	//portalUrl : homepage
    @Parameters({"browser", "portalURL"})
	@BeforeClass
	public void beforeClass(String browserName, String portalURL) {
		driver = getBrowserDriver(browserName, portalURL);
		homePage = new UserHomePageObject(driver);

		existingEmail ="dangthigiang+82@gmail.com";

	}
	


	@Test
	public void Forgot_01_Fotgot_Password_Successfully() {
		System.out.println("Forgot_01 - Step 01: Click to Login link");
		homePage.clickToLoginLink();

		loginPage = new UserLoginPageObject(driver);
		
		
		System.out.println("Forgot_01 - Step 02: Click to Forgot passwork link");
		loginPage.clickToForgotPasswordLink();
		
		forgotPasswordPage = new UserForgotPasswordObject(driver);
		
		System.out.println("Login_01 - Step 03: Input Email Textbox");
		forgotPasswordPage.inputToEmailTextbox(existingEmail);

		System.out.println("Login_01 - Step 04: Click to Send me reset password instructions button");
		forgotPasswordPage	.clickToResetPasswordButton();	
		
		loginPage = new UserLoginPageObject(driver);

		//System.out.println("Login_01 - Step 05: Verify message");
		//Assert.assertEquals(loginPage.getMessageSuccessDisplayed(), "You will receive an email with instructions about how to reset your password in a few minutes.");
		
		
	}
	
	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }



}
