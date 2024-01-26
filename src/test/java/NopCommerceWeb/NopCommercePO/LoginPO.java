package NopCommerceWeb.NopCommercePO;

import NopCommerceWeb.NopCommercePUIs.LoginPUI;
import NopCommerceWeb.NopCommercePUIs.RegisterPUI;
import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;
//import pageUIs.user.RegisterPageUI;

public class LoginPO extends BasePage {
	private WebDriver driver;

	public LoginPO(WebDriver driver) {
		this.driver = driver;
	}

	@Step("click to Login link")
	public void clickToLogInLink() {
		waitForElementClickable(driver, LoginPUI.LOGIN_LINK);
		clickToElement(driver,LoginPUI.LOGIN_LINK);
	}

	@Step("click to Log In buttton")
	public void clickToLogInButton() {
		waitForElementClickable(driver, LoginPUI.LOGIN_BUTTON);
		clickToElement(driver,LoginPUI.LOGIN_BUTTON);
	}

	@Step("Verify error message {0}")
	public String getErrorMessageAtField(String field) {
		waitForElementVisible(driver, LoginPUI.ERROR_MESSSAGE_AT_FIELD, field);
		return getElementText(driver, LoginPUI.ERROR_MESSSAGE_AT_FIELD, field);
	}

	@Step("Input to textbox - {0} {1}")
	public void inputToText(String field, String value) {
		waitForElementVisible(driver, LoginPUI.TEXTBOX_LOGIN, field);
		sendkeyToElement(driver, LoginPUI.TEXTBOX_LOGIN, value, field);
	}

	@Step("Login Account {0} {1}")
	public void loginAccount(String email, String password) {
		inputToText("Email", email);
		inputToText("Password", password);
	}

	@Step("Login Account {0} {1}")
	public void loginAccountFull(String email, String password) {
		refreshToPage(driver);
		clickToLogInLink();
		inputToText("Email", email);
		inputToText("Password", password);
		clickToLogInButton();
		assertTrue(isMyAccountLinkDisplayed());
	}


	@Step("Verify error message - email exist")
	public String getErrorMessage() {
		waitForElementVisible(driver, LoginPUI.ERROR_MESSSAGE);
		return getElementText(driver, LoginPUI.ERROR_MESSSAGE);
	}

	@Step("Verify text - MY ACCOUNT")
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, LoginPUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, LoginPUI.MY_ACCOUNT_LINK);
	}

}


