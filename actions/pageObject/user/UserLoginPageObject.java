package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.user.ForgotPasswordPageUI;
import pageUIs.user.HomePageUI;
import pageUIs.user.LoginPageUI;
import pageUIs.user.RegisterPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;
	
	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click to button Log In")
	public void clickToLoginButton() {
		waitForElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
//		return PageGeneratorManager.getUserHomePage(driver);
	}

	@Step("Input to Textbox Login {0} {1}")
	public void inputToTextboxLogin(String field, String value) {
		waitForElementVisible(driver, LoginPageUI.TEXTBOX_LOGIN, field);
		sendkeyToElement(driver, LoginPageUI.TEXTBOX_LOGIN, value, field);		
	}
	
	@Step("Verify text Log In")
	public boolean isTextLogInDisplayed() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_TEXTBOX);
		return isElementDisplayed(driver, LoginPageUI.LOGIN_TEXTBOX);
	}

	@Step("Click to Forgot Password Link")
	public void clickToForgotPasswordLink() {
		waitForElementClickable(driver,LoginPageUI.FOTGOT_PASSWORD_BUTTON);
		clickToElement(driver,LoginPageUI.FOTGOT_PASSWORD_BUTTON);
	}
	
	@Step("Login Account")
	public void loginAccount(String email, String password) {
		inputToTextboxLogin("email", email);
		inputToTextboxLogin("password", password);

	}
	
	
}
