package pageObject.user;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.user.BoxOfficePageUI;
import pageUIs.user.HomePageUI;
import pageUIs.user.RegisterPageUI;

public class UserRegisterVenuePageObject extends BasePage {
	private WebDriver driver;

	public UserRegisterVenuePageObject(WebDriver driver) {
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
	
	@Step("Click to radio button Venue")
	public void clickToRadioButtonVenue() {
		waitForElementClickable(driver,RegisterPageUI.RADIO_BUTTON_VENUE);
		clickToElement(driver,RegisterPageUI.RADIO_BUTTON_VENUE);

	}
	
	@Step("Get error message at Email Textbox")
	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	@Step("Get error message at Password Textbox")
	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	@Step("Get error message at Confirm Password Textbox")
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

	@Step("Verify display text - Create Your Venue Profile")
	public boolean isTextCreateYourVenueProfile() {
		waitForElementVisible(driver, RegisterPageUI.TEXT_CREATE_YOUR_VENUE_PROFILE);
		return isElementDisplayed(driver, RegisterPageUI.TEXT_CREATE_YOUR_VENUE_PROFILE);
	}

	@Step("Click to button Create Venue")
	public void clickToButtonCreateVenue() {
		waitForElementClickable(driver,RegisterPageUI.CREATE_VENUE_BUTTON);
		clickToElement(driver,RegisterPageUI.CREATE_VENUE_BUTTON);

	}
	
	@Step("Verify error message at {0}")
	public String getErrorMessageAtField(String errorMsgAt) {
		waitForElementVisible(driver, RegisterPageUI.ERROR_MESSAGE_AT_FIELD, errorMsgAt);
		return getElementText(driver, RegisterPageUI.ERROR_MESSAGE_AT_FIELD, errorMsgAt);
	}

	@Step("Input to TextBox {0} {1}")
	public void inputToTextboxProfile(String textBox, String value) {
		waitForElementVisible(driver, RegisterPageUI.TEXTBOX_PROFILE_VENUE, textBox);		
		sendkeyToElement(driver,RegisterPageUI.TEXTBOX_PROFILE_VENUE , value, textBox);
	}

	@Step("Verify text - Add a Photo")
	public boolean isTextAddPhoto() {
		waitForElementVisible(driver, RegisterPageUI.TEXT_ADD_PHOTO);
		return isElementDisplayed(driver, RegisterPageUI.TEXT_ADD_PHOTO);
	}

	@Step("Click to button Upload")
	public void clickToButtonUpload() {
		waitForElementClickable(driver,RegisterPageUI.UPLOAD_IMAGE_BUTTON);
		clickToElement(driver,RegisterPageUI.UPLOAD_IMAGE_BUTTON);
	}

	@Step("Verify error message when don't upload photo")
	public String getErrorMessageUploadPhoto() {
		waitForElementVisible(driver, RegisterPageUI.ERROR_MESSAGE_NOT_UPLOAD_PHOTO);
		return getElementText(driver, RegisterPageUI.ERROR_MESSAGE_NOT_UPLOAD_PHOTO);
	}

	@Step("Click to Button Skip")
	public void clickToButtonSkip() {
		waitForElementClickable(driver,RegisterPageUI.SKIP_UPLOAD_IMAGE_BUTTON);
		clickToElement(driver,RegisterPageUI.SKIP_UPLOAD_IMAGE_BUTTON);
	}

	@Step("Verify text Ticketing")
	public boolean isTextTicketing() {
		waitForElementVisible(driver, RegisterPageUI.TEXT_TICKETING);
		return isElementDisplayed(driver, RegisterPageUI.TEXT_TICKETING);
	}
}
