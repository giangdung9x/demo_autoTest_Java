package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.user.ForgotPasswordPageUI;
import pageUIs.user.HomePageUI;
import pageUIs.user.LoginPageUI;
import pageUIs.user.RegisterPageUI;

public class UserForgotPasswordObject extends BasePage{

	private WebDriver driver;
	
	public UserForgotPasswordObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click to Login button")
	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(driver,HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);		
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	@Step("Input Email Textbox {0}")
	public void inputToEmailTextbox(String validEmail) {
		waitForElementVisible(driver, ForgotPasswordPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, ForgotPasswordPageUI.EMAIL_TEXTBOX, validEmail);		
	}
	
	@Step("Click to Reset Password button")
	public void clickToResetPasswordButton() {
		waitForElementClickable(driver,ForgotPasswordPageUI.RESET_PASSWORD_BUTTON);
		clickToElement(driver, ForgotPasswordPageUI.RESET_PASSWORD_BUTTON);		
	}

	@Step("Verify text - Forgot Password")
	public boolean isTextForgotPassword() {
		waitForElementVisible(driver, ForgotPasswordPageUI.TEXT_FORGOT_PASSWORD);
		return isElementDisplayed(driver, ForgotPasswordPageUI.TEXT_FORGOT_PASSWORD);
	}

	@Step("Verify text - Forgot Password Success")
	public String getErrorMessageAtHeader() {
		waitForElementVisible(driver, ForgotPasswordPageUI.MESSAGE_AT_HEADER);
		return getElementText(driver, ForgotPasswordPageUI.MESSAGE_AT_HEADER);
	}
	

	
	


}
