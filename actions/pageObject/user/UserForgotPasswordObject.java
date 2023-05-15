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
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, validEmail);		
	}
	
	public boolean isCalendarLinkDisplayed() {
		waitForElementVisible(driver, ForgotPasswordPageUI.SIGN_IN_LINK);
		return isElementDisplayed(driver, ForgotPasswordPageUI.SIGN_IN_LINK);
	}
	


	/*public UserCustomerInfoPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}*/

}
