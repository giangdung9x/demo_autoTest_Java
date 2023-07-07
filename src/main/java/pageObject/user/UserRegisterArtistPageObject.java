package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.user.HomePageUI;
import pageUIs.user.RegisterPageUI;

public class UserRegisterArtistPageObject extends BasePage {
	private WebDriver driver;

	public UserRegisterArtistPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click to button Register")
	public void clickToRegisterButton() {
		waitForElementClickable(driver,RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver,RegisterPageUI.REGISTER_BUTTON);

	}
	
	@Step("Click to image SS  - action call form Register")
	public void clickToCallFormResgiter() {
		waitForElementClickable(driver,RegisterPageUI.IMAGE_CALL_FORM_REGISTER);
		clickdoubleToElement(driver,RegisterPageUI.IMAGE_CALL_FORM_REGISTER);

	}
	
	@Step("Click to radio button Artist")
	public void clickToRadioButtonArtist() {
		waitForElementClickable(driver,RegisterPageUI.RADIO_BUTTON_ARTIST);
		clickToElement(driver,RegisterPageUI.RADIO_BUTTON_ARTIST);

	}

	@Step("Verify Error Message At Email Textbox")
	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	@Step("Verify Error Message At Password Textbox")
	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	@Step("Verify Error Message At Confirm Password Textbox")
	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_TERMS_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRM_TERMS_ERROR_MESSAGE);
	}
	
	@Step("Input to textbox {0} {1}")
	public void inputToTextbox(String textBox, String value) {
		waitForElementVisible(driver, RegisterPageUI.TEXTBOX_REGISTER, textBox);		
		sendkeyToElement(driver,RegisterPageUI.TEXTBOX_REGISTER , value, textBox);
	}
	
	@Step("Click to checkbox - 'I have read and agree to the terms of service' ")
	public void clickCheckboxAcceptTerms() {
		waitForElementClickable(driver,RegisterPageUI.CHECKBOX_TERMS_SERVICE);
		clickToElement(driver,RegisterPageUI.CHECKBOX_TERMS_SERVICE);
	}

	@Step("Verify error message at header")
	public String getErrorMessageAtHeader() {
		waitForElementVisible(driver, RegisterPageUI.ERROR_MESSAGE_HEADER);
		return getElementText(driver, RegisterPageUI.ERROR_MESSAGE_HEADER);
	}
	
	@Step("Switch To Frame/Iframe")
	public void switchToFrameIframe() {
		switchToFrameIframe(driver, RegisterPageUI.IFRAME_RECAPTCHA);
	}
	
	
	@Step("Checkbox verify Human")
	public void clickCheckboxNotRobot() {
		waitForElementClickable(driver,RegisterPageUI.CHECKBOX_NOT_HUMAN);
		clickToElement(driver,RegisterPageUI.CHECKBOX_NOT_HUMAN);
	}
	
	@Step("Switch To Sign In Page")
	public void switchToSignInPage() {
		switchToDefaultContent(driver, RegisterPageUI.IFRAME_RECAPTCHA);
	}

	@Step("Verify text - Profile Information")
	public boolean isTextProfileInformation() {
		waitForElementVisible(driver, RegisterPageUI.TEXT_PROFILE_INFORMATION);
		return isElementDisplayed(driver, RegisterPageUI.TEXT_PROFILE_INFORMATION);
	}
	
	@Step("Click to button Next")
	public void clickToButtonNext() {
		waitForElementClickable(driver,RegisterPageUI.NEXT_BUTTON);
		clickToElement(driver,RegisterPageUI.NEXT_BUTTON);

	}
	
	@Step("Input to TextBox {0} {1}")
	public void inputToTextboxProfile(String textBox, String value) {
		waitForElementVisible(driver, RegisterPageUI.TEXTBOX_PROFILE_INFORMATION, textBox);		
		sendkeyToElement(driver,RegisterPageUI.TEXTBOX_PROFILE_INFORMATION , value, textBox);
	}
	
	@Step("Select value of dropdown Profile Type {0}")
	public void selectDropdownProfileType(String valueSelect) {
		waitForElementClickable(driver, RegisterPageUI.DROPDOWN_SELECT_PROFILE_TYPE);
		selectItemInDefaultDropdown(driver, RegisterPageUI.DROPDOWN_SELECT_PROFILE_TYPE, valueSelect);
	}
	
	@Step("Verify text - Profile Information")
	public boolean isTextWeNeed() {
		waitForElementVisible(driver, RegisterPageUI.TEXT_WE_NEED_VERIFY);
		return isElementDisplayed(driver, RegisterPageUI.TEXT_WE_NEED_VERIFY);
	}
	
	@Step("Click to button Send")
	public void clickToButtonSend() {
		waitForElementClickable(driver,RegisterPageUI.SEND_BUTTON);
		clickToElement(driver,RegisterPageUI.SEND_BUTTON);

	}
	
	@Step("Click to button Skip")
	public void clickToButtonSkip() {
		waitForElementClickable(driver,RegisterPageUI.SKIP_BUTTON);
		clickToElement(driver,RegisterPageUI.SKIP_BUTTON);

	}
	
	@Step("Alert - click accept Alert")
	public void acceptAlert() {
		acceptAlert(driver);
	}
	
	@Step("Alert - click cancel Alert")
	public void cancelAlert() {
		cancelAlert(driver);
	}

	@Step("Verify text - Dashboard")
	public boolean isTextDashboard() {
		waitForElementVisible(driver, RegisterPageUI.TEXT_DASHBOARD);
		return isElementDisplayed(driver, RegisterPageUI.TEXT_DASHBOARD);
	}

}
