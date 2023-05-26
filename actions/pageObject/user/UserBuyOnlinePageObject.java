package pageObject.user;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.BuyOnlinePageUI;

public class UserBuyOnlinePageObject extends BasePage{

	private WebDriver driver;
	
	public UserBuyOnlinePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getTextEventName() {
		waitForElementVisible(driver, BuyOnlinePageUI.TEXT_EVENT_NAME);
		return getElementText(driver, BuyOnlinePageUI.TEXT_EVENT_NAME);
	}

	public boolean isTextSelectTicketsDisplayed() {
		waitForElementVisible(driver, BuyOnlinePageUI.TEXT_SELECT_TICKETS);
		return isElementDisplayed(driver, BuyOnlinePageUI.TEXT_SELECT_TICKETS);
	}
	
	public boolean isTextSelectAddOnsDisplayed() {
		waitForElementVisible(driver, BuyOnlinePageUI.TEXT_SELECT_ADD_ONS);
		return isElementDisplayed(driver, BuyOnlinePageUI.TEXT_SELECT_ADD_ONS);
	}
	
	public boolean isTextSelectPassesDisplayed() {
		waitForElementVisible(driver, BuyOnlinePageUI.TEXT_SELECT_PASSES);
		return isElementDisplayed(driver, BuyOnlinePageUI.TEXT_SELECT_PASSES);
	}
	
	public boolean isTextSelectGiftCardDisplayed() {
		waitForElementVisible(driver, BuyOnlinePageUI.TEXT_SELECT_GIFT_CARD);
		return isElementDisplayed(driver, BuyOnlinePageUI.TEXT_SELECT_GIFT_CARD);
	}

	public void clickToDropDownSelectTicket() {
		waitForElementClickable(driver,BuyOnlinePageUI.DROPDOWN_TICKET);
		clickToElement(driver, BuyOnlinePageUI.DROPDOWN_TICKET);	
	}

	public void clickToValueOfDropdownSelectTicket() {
		waitForElementClickable(driver,BuyOnlinePageUI.VALUE_DROPDOWN_TICKET);
		clickToElement(driver, BuyOnlinePageUI.VALUE_DROPDOWN_TICKET);	
	}
	
	public void clickToDropDownSelectAddOns() {
		waitForElementClickable(driver,BuyOnlinePageUI.DROPDOWN_ADD_ONS);
		clickToElement(driver, BuyOnlinePageUI.DROPDOWN_ADD_ONS);	
	}

	public void clickToValueOfDropdownSelectAddOns() {
		waitForElementClickable(driver,BuyOnlinePageUI.VALUE_DROPDOWN_ADD_ONS);
		clickToElement(driver, BuyOnlinePageUI.VALUE_DROPDOWN_ADD_ONS);	
	}
	
	public void clickToDropDownSelectPass() {
		waitForElementClickable(driver,BuyOnlinePageUI.DROPDOWN_PASSES);
		clickToElement(driver, BuyOnlinePageUI.DROPDOWN_PASSES);	
	}

	public void clickToValueOfDropdownSelectPass() {
		waitForElementClickable(driver,BuyOnlinePageUI.VALUE_DROPDOWN_PASSES);
		clickToElement(driver, BuyOnlinePageUI.VALUE_DROPDOWN_PASSES);	
	}
	
	public void clickToDropDownSelectGiftCard() {
		waitForElementClickable(driver,BuyOnlinePageUI.DROPDOWN_ADD_ONS);
		clickToElement(driver, BuyOnlinePageUI.DROPDOWN_ADD_ONS);	
	}

	public void clickToValueOfDropdownSelectGiftCard() {
		waitForElementClickable(driver,BuyOnlinePageUI.VALUE_DROPDOWN_PASSES);
		clickToElement(driver, BuyOnlinePageUI.VALUE_DROPDOWN_PASSES);	
	}

	public void clickToAgreeCheckoutButton() {
		waitForElementClickable(driver,BuyOnlinePageUI.BUTTON_AGREE_CHECKOUT);
		clickToElement(driver, BuyOnlinePageUI.BUTTON_AGREE_CHECKOUT);	
	}

	public boolean isCheckoutTextDisplayed() {
		waitForElementVisible(driver, BuyOnlinePageUI.CHECKOUT_TEXT);
		return isElementDisplayed(driver, BuyOnlinePageUI.CHECKOUT_TEXT);
	}

	public void inputToFullNameTextbox(String fullName) {
		waitForElementVisible(driver, BuyOnlinePageUI.FULL_NAME_TEXTBOX);
		sendkeyToElement(driver, BuyOnlinePageUI.FULL_NAME_TEXTBOX, fullName);
	}

	public void inputToPhoneTextbox(String phone) {
		waitForElementVisible(driver, BuyOnlinePageUI.PHONE_TEXTBOX);
		sendkeyToElement(driver, BuyOnlinePageUI.PHONE_TEXTBOX, phone);
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, BuyOnlinePageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, BuyOnlinePageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToConfirmEmailTextbox(String email) {
		waitForElementVisible(driver, BuyOnlinePageUI.CONFIRM_EMAIL_TEXTBOX);
		sendkeyToElement(driver, BuyOnlinePageUI.CONFIRM_EMAIL_TEXTBOX, email);
	}

	public boolean isTextCheckoutTimeExpiredDisplayed() {
		waitForElementVisible(driver, BuyOnlinePageUI.CHECKOUT_EXPRIE_TIME_TEXT);
		return isElementDisplayed(driver, BuyOnlinePageUI.CHECKOUT_EXPRIE_TIME_TEXT);
	}
	
	//IFAME
	public void switchToFrameIframe() {
		switchToFrameIframe(driver, BuyOnlinePageUI.IFRAME_CARD_MANUALLY);
	}
	
	public void switchToDefaultContent() {
		switchToDefaultContent(driver, BuyOnlinePageUI.IFRAME_CARD_MANUALLY);
	}
	
	public void inputToCardNumberTextbox(String cardNumber) {
		waitForElementVisible(driver, BuyOnlinePageUI.CARD_NUMBER_TEXTBOX);
		sendkeyToElement(driver, BuyOnlinePageUI.CARD_NUMBER_TEXTBOX, cardNumber);
	}

	public void inputToMonthYearTextbox(String monthYear) {
		waitForElementVisible(driver, BuyOnlinePageUI.MONTH_YEAR_TEXTBOX);
		sendkeyToElement(driver, BuyOnlinePageUI.MONTH_YEAR_TEXTBOX, monthYear);
	}

	public void inputToCVCTextbox(String cvc) {
		waitForElementVisible(driver, BuyOnlinePageUI.CVC_TEXTBOX);
		sendkeyToElement(driver, BuyOnlinePageUI.CVC_TEXTBOX, cvc);
	}

	public void inputToZipTextbox(String zip) {
		waitForElementVisible(driver, BuyOnlinePageUI.ZIP_TEXTBOX);
		sendkeyToElement(driver, BuyOnlinePageUI.ZIP_TEXTBOX, zip);
	}
	
	//ALERT 
	public Alert waitForAlertPresence() {
		return waitForAlertPresence(driver);
	}
	
	public void acceptAlert() {
		acceptAlert(driver);
	}
	
	public void cancelAlertBoxOffice() {
		cancelAlert(driver);
	}

	public void clickBackToTicketLink() {
		waitForElementClickable(driver,BuyOnlinePageUI.BACK_TO_TICKET_LINK);
		clickToElement(driver, BuyOnlinePageUI.BACK_TO_TICKET_LINK);	
	}

	public void clickCheckboxAcceptTermsService() {
		waitForElementClickable(driver,BuyOnlinePageUI.CHECKBOX_ACCEPT_TERMS_SERVICE);
		clickToElement(driver, BuyOnlinePageUI.CHECKBOX_ACCEPT_TERMS_SERVICE);	
	}

	public void clickPlaceOrderButton() {
		waitForElementClickable(driver,BuyOnlinePageUI.BUTTON_PLACE_ORDER);
		clickToElement(driver, BuyOnlinePageUI.BUTTON_PLACE_ORDER);	
	}

	public boolean isCheckoutSuccessTextDisplayed() {
		waitForElementVisible(driver, BuyOnlinePageUI.CHECKOUT_SUCCESS_TEXT);
		return isElementDisplayed(driver, BuyOnlinePageUI.CHECKOUT_SUCCESS_TEXT);
	}

	public void clickPrintOrderButton() {
		waitForElementClickable(driver,BuyOnlinePageUI.BUTTON_PRINT_ORDER);
		clickToElement(driver, BuyOnlinePageUI.BUTTON_PRINT_ORDER);	
	}
	
	public void switchToWindowByID(String windowID) {
		switchToWindowByID(driver, windowID);	
	}

	public void clickBackToEventPageButton() {
		waitForElementClickable(driver,BuyOnlinePageUI.BUTTON_BACK_TO_EVENT_PAGE);
		clickToElement(driver, BuyOnlinePageUI.BUTTON_BACK_TO_EVENT_PAGE);	
	}

	public boolean isCardInfoTextDisplayed() {
		waitForElementVisible(driver, BuyOnlinePageUI.CARD_INFO_TEXT);
		return isElementDisplayed(driver, BuyOnlinePageUI.CARD_INFO_TEXT);
	}
}
