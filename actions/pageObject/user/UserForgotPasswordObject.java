package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.ForgotPasswordPageUI;
import pageUIs.user.HomePageUI;
import pageUIs.user.LoginPageUI;

public class UserForgotPasswordObject extends BasePage{

	private WebDriver driver;
	
	public UserForgotPasswordObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(driver,HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);		
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public void inputToEmailTextbox(String validEmail) {
		waitForElementVisible(driver, ForgotPasswordPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, ForgotPasswordPageUI.EMAIL_TEXTBOX, validEmail);		
	}
	
	public void clickToResetPasswordButton() {
		waitForElementClickable(driver,ForgotPasswordPageUI.RESET_PASSWORD_BUTTON);
		clickToElement(driver, ForgotPasswordPageUI.RESET_PASSWORD_BUTTON);		
	}
	

	
	


}
