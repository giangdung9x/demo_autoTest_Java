package pageObject.user;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.user.BuyOnlinePageUI;

public class UserBuyOnlinePageObject extends BasePage{

	private WebDriver driver;
	
	public UserBuyOnlinePageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Verify display text - Event Name")
	public String getTextEventName() {
		waitForElementVisible(driver, BuyOnlinePageUI.TEXT_EVENT_NAME);
		return getElementText(driver, BuyOnlinePageUI.TEXT_EVENT_NAME);
	}
	
	@Step("Click to button - Agree Checkout")
	public void clickToAgreeCheckoutButton() {
		waitForElementClickable(driver,BuyOnlinePageUI.BUTTON_AGREE_CHECKOUT);
		clickToElement(driver, BuyOnlinePageUI.BUTTON_AGREE_CHECKOUT);	
	}
	
	@Step("Verify error message at Event screem")
	public String getErrorMessage() {
		waitForElementVisible(driver, BuyOnlinePageUI.ERROR_MESSAGE);
		return getElementText(driver, BuyOnlinePageUI.ERROR_MESSAGE);
	}
	
	@Step("Click to dropdown select quantity ticket {0} {1}")
	public void clickToDropDownSelectQuantityTicket(String nameOfTicket,String textItem) {
		waitForElementClickable(driver,BuyOnlinePageUI.DROPDOWN_QUANTITY_TICKET, nameOfTicket);
		selectItemInDefaultDropdown(driver, BuyOnlinePageUI.DROPDOWN_QUANTITY_TICKET, textItem, nameOfTicket);	
	}
	
	@Step("Verify display text - Screen Name: Checkout")
	public boolean isCheckoutTextDisplayed() {
		waitForElementVisible(driver, BuyOnlinePageUI.CHECKOUT_TEXT);
		return isElementDisplayed(driver, BuyOnlinePageUI.CHECKOUT_TEXT);
	}

	@Step("Click to button - Place Order")
	public void clickPlaceOrderButton() {
		waitForElementClickable(driver,BuyOnlinePageUI.BUTTON_PLACE_ORDER);
		clickToElement(driver, BuyOnlinePageUI.BUTTON_PLACE_ORDER);	
	}
	

	
	@Step("Input info of buyer {0} {1}")
	public void inputInfoBuyerTextbox(String field, String fullName) {
		waitForElementVisible(driver, BuyOnlinePageUI.INFO_BUYER_TEXBOX, field);
		sendkeyToElement(driver, BuyOnlinePageUI.INFO_BUYER_TEXBOX, fullName, field);
	}
	
	@Step("Verify error message at Checkout screen")
	public String getErrorMessageAtCheckoutScreen() {
		waitForElementVisible(driver, BuyOnlinePageUI.ERROR_MESSAGE_AT_CHECKOUT_SCREEN);
		return getElementText(driver, BuyOnlinePageUI.ERROR_MESSAGE_AT_CHECKOUT_SCREEN);
	}
	
	@Step("Verify error message at Checkout screen")
	public String getErrorMessageAtFooter() {
		waitForElementVisible(driver, BuyOnlinePageUI.ERROR_MESSAGE_AT_FOOTER_CHECKOUT_SCREEN);
		return getElementText(driver, BuyOnlinePageUI.ERROR_MESSAGE_AT_FOOTER_CHECKOUT_SCREEN);
	}
	
	@Step("Verify error message - Purchase Failed")
	public String getErrorMessagePurchaseFailed() {
		waitForElementVisible(driver, BuyOnlinePageUI.ERROR_MESSAGE_PURCHASE_FAILED);
		return getElementText(driver, BuyOnlinePageUI.ERROR_MESSAGE_PURCHASE_FAILED);
	}

	@Step("Get text - Total Amount of Order")
	public String getTextTotalAmountOrder() {
		waitForElementVisible(driver, BuyOnlinePageUI.TEXT_TOTAL_AMOUNT_ORDER);
		return getElementText(driver, BuyOnlinePageUI.TEXT_TOTAL_AMOUNT_ORDER);
	}
	
	@Step("Accept Terms of Service")
	public void clickCheckboxAcceptTermsService() {
		waitForElementClickable(driver,BuyOnlinePageUI.CHECKBOX_ACCEPT_TERMS_SERVICE);
		clickToElement(driver, BuyOnlinePageUI.CHECKBOX_ACCEPT_TERMS_SERVICE);	
	}
	
	//IFAME
	public void switchToFrameIframe() {
		switchToFrameIframe(driver, BuyOnlinePageUI.IFRAME_CARD_MANUALLY);
	}
	
	public void switchToDefaultContent() {
		switchToDefaultContent(driver, BuyOnlinePageUI.IFRAME_CARD_MANUALLY);
	}
	
	@Step("Input info of card manual - {0} {1}")
	public void inputInfoCardManual(String field, String value) {
		waitForElementVisible(driver, BuyOnlinePageUI.CARD_INFO_TEXTBOX, field);
		sendkeyToElement(driver, BuyOnlinePageUI.CARD_INFO_TEXTBOX, value, field);
	}
	
	
	@Step("Click to button - Place Order")
	public void clickToBackToTicket() {
		waitForElementClickable(driver,BuyOnlinePageUI.BUTTON_BACK_TO_TICKET);
		clickToElement(driver, BuyOnlinePageUI.BUTTON_BACK_TO_TICKET);	
	}

	@Step("Verify text display - Checkout success")
	public boolean isCheckoutSuccessTextDisplayed() {
		waitForElementVisible(driver, BuyOnlinePageUI.CHECKOUT_SUCCESS_TEXT);
		return isElementDisplayed(driver, BuyOnlinePageUI.CHECKOUT_SUCCESS_TEXT);
	}

	@Step("Click to button - Print Order")
	public void clickPrintOrderButton() {
		waitForElementClickable(driver,BuyOnlinePageUI.BUTTON_PRINT_ORDER);
		clickToElement(driver, BuyOnlinePageUI.BUTTON_PRINT_ORDER);	
	}
	
	@Step("switch To Window By ID {0}")
	public void switchToWindowByID(String windowID) {
		switchToWindowByID(driver, windowID);	
	}

	@Step("Click to button - Back to Event")
	public void clickBackToEventPageButton() {
		waitForElementClickable(driver,BuyOnlinePageUI.BUTTON_BACK_TO_EVENT_PAGE);
		clickToElement(driver, BuyOnlinePageUI.BUTTON_BACK_TO_EVENT_PAGE);	
	}

	@Step("Click to radio button - Buy now pay later")
	public void clickToRadioButtonCheckoutMethod() {
		waitForElementClickable(driver,BuyOnlinePageUI.RADIO_BUTTON_BNPL);
		clickToElement(driver, BuyOnlinePageUI.RADIO_BUTTON_BNPL);	
	}

	@Step("Verify error message when choose method is BNPL, total amount order < 50$")
	public String getErrorMessageBNPL() {
		waitForElementVisible(driver, BuyOnlinePageUI.ERROR_MESSAGE_BNPL);
		return getElementText(driver, BuyOnlinePageUI.ERROR_MESSAGE_BNPL);
	}

	@Step("Click to button - Buy now pay later")
	public void clickToBuyNowPayLaterButton() {
		waitForElementClickable(driver,BuyOnlinePageUI.BUTTON_BNPL);
		clickToElement(driver, BuyOnlinePageUI.BUTTON_BNPL);	
	}
	
	@Step("Click to button - Authorize Test Payment")
	public void clickButtonAuthorizeTestPayment() {
		waitForElementClickable(driver,BuyOnlinePageUI.BUTTON_AUTHORIZE_TEST_PAYMENT);
		clickToElement(driver, BuyOnlinePageUI.BUTTON_AUTHORIZE_TEST_PAYMENT);	
	}

	@Step("Click to button - Fail Test Payment")
	public void clickButtonFailTestPayment() {
		waitForElementClickable(driver,BuyOnlinePageUI.BUTTON_FAIL_TEST_PAYMENT);
		clickToElement(driver, BuyOnlinePageUI.BUTTON_FAIL_TEST_PAYMENT);	
	}

	@Step("Verify text - Alert checkout fail")
	public String getTextOfAlertCheckoutFail() {
		waitForAlertPresence(driver);
		return getAlertText(driver);
	}
	
	@Step("Alert - accept alert")
	public void acceptAlert() {
		acceptAlert(driver);
	}
	
	@Step("Alert - cancel alert")
	public void cancelAlert() {
		cancelAlert(driver);
	}
	
	@Step("Convert Total Amoint To Int")
	public int convertTotalAmountToInt() {
		String amountString = getTextTotalAmountOrder();
		String amountStringWithoutSymbol = amountString.replace("$", "").trim();
		String[] amountParts = amountStringWithoutSymbol.split("\\.");
		return  Integer.parseInt(amountParts[0]);
	}
}
