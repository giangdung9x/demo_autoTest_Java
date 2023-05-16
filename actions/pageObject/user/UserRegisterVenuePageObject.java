package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.HomePageUI;
import pageUIs.user.RegisterPageUI;

public class UserRegisterVenuePageObject extends BasePage {
	private WebDriver driver;

	public UserRegisterVenuePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickToRegisterButton() {
		waitForElementClickable(driver,RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver,RegisterPageUI.REGISTER_BUTTON);

	}
	
	public void clickToCallFormResgiter() {
		waitForElementClickable(driver,RegisterPageUI.IMAGE_CALL_FORM_REGISTER);
		clickdoubleToElement(driver,RegisterPageUI.IMAGE_CALL_FORM_REGISTER);

	}
	
	public void clickToRadioButtonVenue() {
		waitForElementClickable(driver,RegisterPageUI.RADIO_BUTTON_VENUE);
		clickToElement(driver,RegisterPageUI.RADIO_BUTTON_VENUE);

	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_TERMS_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRM_TERMS_ERROR_MESSAGE);
	}



}
