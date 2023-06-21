package pageObject.user;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.user.ActionOfEventPageUI;
import pageUIs.user.BoxOfficePageUI;
import pageUIs.user.BuyOnlinePageUI;
import pageUIs.user.HomePageUI;


public class UserActionOfEventPageObject extends BasePage{

	private WebDriver driver;

	public UserActionOfEventPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click to button Login")
	public void clickToLoginLink() {
		waitForElementClickable(driver,ActionOfEventPageUI.LOGIN_LINK);
		clickToElement(driver, ActionOfEventPageUI.LOGIN_LINK);		
	}

	@Step("Input to Textbox Login {0} {1}")
	public void inputToTextboxLogin(String field, String value) {
		waitForElementVisible(driver, ActionOfEventPageUI.TEXTBOX_LOGIN, field);
		sendkeyToElement(driver, ActionOfEventPageUI.TEXTBOX_LOGIN, value, field);		
	}

	@Step("Login Account {0} {1}")
	public void loginAccount(String email, String password) {
		inputToTextboxLogin("email", email);
		inputToTextboxLogin("password", password);

	}

	@Step("Click to button - Login")
	public void clickToLoginButton() {
		waitForElementClickable(driver,ActionOfEventPageUI.LOGIN_BUTTON);
		clickToElement(driver, ActionOfEventPageUI.LOGIN_BUTTON);	
	}

	@Step("Verify text - Ticketing")
	public boolean isTextTicketingDisplayed() {
		waitForElementVisible(driver, ActionOfEventPageUI.TEXT_TICKETING);
		return isElementDisplayed(driver, ActionOfEventPageUI.TEXT_TICKETING);
	}

	@Step("Click to items of Left Menu - {0}")
	public void clickToItemOfLeftMenu(String items) {
		waitForElementClickable(driver,ActionOfEventPageUI.ITEMS_LEFT_MENU, items);
		clickToElement(driver, ActionOfEventPageUI.ITEMS_LEFT_MENU, items);	
	}

	@Step("Click to button - Create Tickets")
	public void clickToCreateTicketButton() {
		waitForElementClickable(driver,ActionOfEventPageUI.CREATE_TICKET_BUTTON);
		clickToElement(driver, ActionOfEventPageUI.CREATE_TICKET_BUTTON);	
	}

	@Step("Verify text - Name of popup - {0}")
	public boolean isNameOfPopupDisplayed(String nameOfPopup) {
		waitForElementVisible(driver, ActionOfEventPageUI.NAME_OF_POPUP, nameOfPopup);
		return isElementDisplayed(driver, ActionOfEventPageUI.NAME_OF_POPUP, nameOfPopup);
	}

	@Step("Popup - Click to button - {0}")
	public void clickToCommitButton(String nameOfButton) {
		waitForElementClickable(driver,ActionOfEventPageUI.CREATE_SAVE_BUTTON_POPUP, nameOfButton);
		clickToElement(driver, ActionOfEventPageUI.CREATE_SAVE_BUTTON_POPUP, nameOfButton);	
	}
	
	@Step("Popup - Click to button - {0}")
	public void clickToUpdateButton(String nameOfButton) {
		waitForElementClickable(driver,ActionOfEventPageUI.BUTTON_UPDATE_POPUP, nameOfButton);
		clickToElement(driver, ActionOfEventPageUI.BUTTON_UPDATE_POPUP, nameOfButton);	
	}

	@Step("Verify text - Error Message At Footer Popup")
	public String getErrorMessageAtFooterPopup() {
		waitForElementVisible(driver, ActionOfEventPageUI.ERROR_MESSAGE_AT_FOOTER_POPUP);
		return getElementText(driver, ActionOfEventPageUI.ERROR_MESSAGE_AT_FOOTER_POPUP);
	}

	@Step("input value - {0} {1}")
	public void inputValueTimesDay(String field, String date) {
		waitForElementVisible(driver, ActionOfEventPageUI.SET_TIME_OF_DAY, field);
		sendkeyToElement(driver, ActionOfEventPageUI.SET_TIME_OF_DAY, date, field);		
	}

	public String getValueTimesDay(String field, String date) {
		waitForElementVisible(driver, ActionOfEventPageUI.SET_TIME_OF_DAY, field);
		return getElementText(driver, ActionOfEventPageUI.SET_TIME_OF_DAY, date, field);	
	}

	public String compareDates(String startDateField, String endDateField, String startDate, String endDate) {
		String selectedStartDate = getValueTimesDay(startDateField, startDate);
		String selectedEndDate = getValueTimesDay(endDateField, endDate);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate parsedStartDate = LocalDate.parse(selectedStartDate, formatter);
		LocalDate parsedEndDate = LocalDate.parse(selectedEndDate, formatter);

		if (parsedEndDate.isBefore(parsedStartDate)) {
			return "Please choose end day than start day!";
		}
		return "";
	}
	
	@Step("Popup - Click to button - {0}")
	public void clickToAddButton(String nameOfButton) {
		waitForElementClickable(driver,ActionOfEventPageUI.ADD_BUTTON, nameOfButton);
		clickToElement(driver, ActionOfEventPageUI.ADD_BUTTON, nameOfButton);	
	}
	
	@Step("Input textbox Column {0} - Row {1} - Value {2}")
	public void enterToTextboxByRowNumberByColumnName(String coulmnName, String rowNumber, String value) {
		int coulmnIndex = getElementSize(driver, ActionOfEventPageUI.COULMN_INDEX_BY_NAME, coulmnName) +1;

		waitForElementVisible(driver, ActionOfEventPageUI.TEXTBOX_BY_COULMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(coulmnIndex));
		sendkeyToElement(driver, ActionOfEventPageUI.TEXTBOX_BY_COULMN_INDEX_AND_ROW_INDEX,value, rowNumber, String.valueOf(coulmnIndex));

	}
	
	@Step("Input textbox-  Row {0} - Value {1}")
	public void enterToTextboxByRowNumberByColumnNameTicket(String rowNumber, String value) {
		int coulmnIndex = getElementSize(driver, ActionOfEventPageUI.COULMN_INDEX_BY_NAME_TICKET) +1;

		waitForElementVisible(driver, ActionOfEventPageUI.TEXTBOX_BY_COULMN_INDEX_AND_ROW_INDEX_TICKET, rowNumber, String.valueOf(coulmnIndex));
		sendkeyToElement(driver, ActionOfEventPageUI.TEXTBOX_BY_COULMN_INDEX_AND_ROW_INDEX_TICKET,value, rowNumber, String.valueOf(coulmnIndex));

	}
	
	@Step("Input textbox Column {0} - Row {1} - Value {2}")
	public void enterToTextboxAmountByRowNumberByColumnName(String coulmnName, String rowNumber, String value) {
		int coulmnIndex = getElementSize(driver, ActionOfEventPageUI.COULMN_INDEX_BY_NAME, coulmnName) +1;

		waitForElementVisible(driver, ActionOfEventPageUI.TEXTBOX_AMOUNT_BY_COULMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(coulmnIndex));
		sendkeyToElement(driver, ActionOfEventPageUI.TEXTBOX_AMOUNT_BY_COULMN_INDEX_AND_ROW_INDEX,value, rowNumber, String.valueOf(coulmnIndex));

	}
	
	@Step("Input to Textbox -  {0} {1}")
	public void inputToTextboxMinMaxTicket(String field, String value) {
		waitForElementVisible(driver, ActionOfEventPageUI.TEXTBOX_MIN_MAX_TICKET, field);
		sendkeyToElement(driver, ActionOfEventPageUI.TEXTBOX_MIN_MAX_TICKET, value, field);		
	}

	@Step("Popup - Click to checkbox - Tickets go on sale immediately")
	public void clickToCheckboxOnSale() {
		waitForElementClickable(driver,ActionOfEventPageUI.CHECKBOX_ON_SALE);
		clickToElement(driver, ActionOfEventPageUI.CHECKBOX_ON_SALE);	
	}
	
	@Step("Verify text - Name of event at Calendar - {0}")
	public boolean isNameOfEventAtCalendarDisplayed(String nameOfEvent) {
		waitForElementVisible(driver, ActionOfEventPageUI.EVENT_OF_CALENDAR_ON_SALE, nameOfEvent);
		return isElementDisplayed(driver, ActionOfEventPageUI.EVENT_OF_CALENDAR_ON_SALE, nameOfEvent);
	}
	
	@Step("Click to event - {0}")
	public void clickToEvent(String nameOfEvent) {
		waitForElementClickable(driver,ActionOfEventPageUI.EVENT_OF_CALENDAR_ON_SALE, nameOfEvent);
		clickToElement(driver, ActionOfEventPageUI.EVENT_OF_CALENDAR_ON_SALE, nameOfEvent);	
	}
	
	@Step("Click to event (copy)- {0}")
	public void clickToEventCopy(String nameOfEvent) {
		waitForElementClickable(driver,ActionOfEventPageUI.EVENT_OF_CALENDAR_OFF_SALE_COPY, nameOfEvent);
		clickToElement(driver, ActionOfEventPageUI.EVENT_OF_CALENDAR_OFF_SALE_COPY, nameOfEvent);	
	}
	
	@Step("Click to event - {0}")
	public void clickToLink(String nameOfLink) {
		waitForElementClickable(driver,ActionOfEventPageUI.LINK_CANCEL_PREVIEW, nameOfLink);
		clickToElement(driver, ActionOfEventPageUI.LINK_CANCEL_PREVIEW, nameOfLink);	
	}
	
	@Step("Click to event - {0}")
	public void clickToButtonFooter(String nameOfLink) {
		waitForElementClickable(driver,ActionOfEventPageUI.FOOTER_BUTTON, nameOfLink);
		clickToElement(driver, ActionOfEventPageUI.FOOTER_BUTTON, nameOfLink);	
	}
	
	@Step("Verify text - Name of event at Calendar - {0}")
	public boolean isNameOfEventCopyAtCalendarDisplayed(String nameOfEvent) {
		waitForElementVisible(driver, ActionOfEventPageUI.EVENT_OF_CALENDAR_OFF_SALE_COPY, nameOfEvent);
		return isElementDisplayed(driver, ActionOfEventPageUI.EVENT_OF_CALENDAR_OFF_SALE_COPY, nameOfEvent);
	}
	
	@Step("Verify text - Error Message At Footer Popup")
	public String getErrorMessageAtFooterPopupTransfer() {
		waitForElementVisible(driver, ActionOfEventPageUI.ERROR_MESSAGE_AT_FOOTER_POPUP_TRANSFER);
		return getElementText(driver, ActionOfEventPageUI.ERROR_MESSAGE_AT_FOOTER_POPUP_TRANSFER);
	}
	
	@Step("Switch to tab {0}")
	public void switchToWindowByID(String windowID) {
		switchToWindowByID(driver, windowID);	
	}
	
	@Step("Switch to tab by title {0}")
	public void switchToWindowByTitle(String windowID) {
		switchToWindowByTitle(driver, windowID);	
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

	@Step("Click to button - Agree Checkout")
	public void clickToAgreeCheckoutButton() {
		waitForElementClickable(driver,BuyOnlinePageUI.BUTTON_AGREE_CHECKOUT);
		clickToElement(driver, BuyOnlinePageUI.BUTTON_AGREE_CHECKOUT);	
	}
	
	@Step("Click to radio button {0}")
	public void clickToRadioButton(String nameOfRadio) {
		waitForElementClickable(driver,ActionOfEventPageUI.AUTO_MANUAL_RADIO_BUTTON, nameOfRadio);
		clickToElement(driver, ActionOfEventPageUI.AUTO_MANUAL_RADIO_BUTTON, nameOfRadio);	
	}
	
	@Step("Click to button Refund")
	public void clickToRefundButton(String field) {
		waitForElementClickable(driver,ActionOfEventPageUI.REFUND_TICKET_BUTTON, field);
		clickToElement(driver, ActionOfEventPageUI.REFUND_TICKET_BUTTON, field);	
	}
	
	@Step("Click to button Close Popup")
	public void clickClosePopupButton() {
		waitForElementClickable(driver,ActionOfEventPageUI.CLOSE_BUTTON);
		clickToElement(driver, ActionOfEventPageUI.CLOSE_BUTTON);	
	}
	
}