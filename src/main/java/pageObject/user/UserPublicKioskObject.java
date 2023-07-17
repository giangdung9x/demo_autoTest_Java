package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.user.AttendeePageUI;
import pageUIs.user.BoxOfficePageUI;
import pageUIs.user.LoginPageUI;
import pageUIs.user.PublicKioskPageUI;

public class UserPublicKioskObject extends BasePage{

	private WebDriver driver;

	public UserPublicKioskObject(WebDriver driver) {
		this.driver = driver;
	}
	//LOGIN
	@Step("Click to button Login")
	public void clickToLoginLink() {
		waitForElementClickable(driver,BoxOfficePageUI.LOGIN_LINK);
		clickToElement(driver, BoxOfficePageUI.LOGIN_LINK);		
	}

	@Step("Input to Textbox Login {0} {1}")
	public void inputToTextboxLogin(String field, String value) {
		waitForElementVisible(driver, LoginPageUI.TEXTBOX_LOGIN, field);
		sendkeyToElement(driver, LoginPageUI.TEXTBOX_LOGIN, value, field);		
	}

	@Step("Login Account {0} {1}")
	public void loginAccount(String email, String password) {
		inputToTextboxLogin("email", email);
		inputToTextboxLogin("password", password);

	}

	@Step("Click to button - Login")
	public void clickToLoginButton() {
		waitForElementClickable(driver,BoxOfficePageUI.LOGIN_BUTTON);
		clickToElement(driver, BoxOfficePageUI.LOGIN_BUTTON);	
	}

	@Step("Click open Left Menu")
	public void clickShowLeftMenu() {
		waitForElementClickable(driver,BoxOfficePageUI.LEFT_MENU_BUTTON);
		clickToElement(driver, BoxOfficePageUI.LEFT_MENU_BUTTON);	
	}


	@Step("Click to items of Left Menu - {0}")
	public void clickToItemOfLeftMenu(String items) {
		waitForElementClickable(driver,AttendeePageUI.ITEMS_LEFT_MENU, items);
		clickToElement(driver, AttendeePageUI.ITEMS_LEFT_MENU, items);	
	}

	//PAGE CHOOSE EVENT
	@Step("Verify text - Please Choose Event")
	public boolean isTextPleaseChooseEventDisplayed() {
		waitForElementVisible(driver, PublicKioskPageUI.PLEASE_CHOOSE_EVENT_TEXT);
		return isElementDisplayed(driver, PublicKioskPageUI.PLEASE_CHOOSE_EVENT_TEXT);
	}

	@Step("Verify button - Config Kiosk")
	public boolean isButtonConfigKioskDisplayed() {
		waitForElementVisible(driver, PublicKioskPageUI.CONFIG_KIOSK_BUTTON);
		return isElementDisplayed(driver, PublicKioskPageUI.CONFIG_KIOSK_BUTTON);
	}

	@Step("Click to button - Config Kiosk")
	public void clickToButtonConfigKiosk() {
		waitForElementClickable(driver,PublicKioskPageUI.CONFIG_KIOSK_BUTTON);
		clickToElement(driver, PublicKioskPageUI.CONFIG_KIOSK_BUTTON);	
	}

	@Step("Switch to tab {0}")
	public void switchToWindowByID(String windowID) {
		switchToWindowByID(driver, windowID);	
	}
	
	@Step("Switch to tab by title {0}")
	public void switchToWindowByTitle(String windowID) {
		switchToWindowByTitle(driver, windowID);	
	}

	//PAGE ACCESS CODE CONFIG KIOSK

	@Step("Verify text - Enter Code Access")
	public boolean isTextEnterCodeAccessDisplayed() {
		waitForElementVisible(driver, PublicKioskPageUI.TEXT_ENTER_CODE_ACCESS);
		return isElementDisplayed(driver, PublicKioskPageUI.TEXT_ENTER_CODE_ACCESS);
	}


	@Step("Input code access {0}")
	public void inputCodeAccessConfigKiosk(String accessCode) {
		waitForElementClickable(driver,PublicKioskPageUI.TEXTBOX_INPUT_CODE);
		sendkeyToElement(driver, PublicKioskPageUI.TEXTBOX_INPUT_CODE, accessCode);	
	}

	@Step("Click to button - Confirm")
	public void clickToButtonConfirmCode() {
		waitForElementClickable(driver,PublicKioskPageUI.CONFIRM_BUTTON);
		clickToElement(driver, PublicKioskPageUI.CONFIRM_BUTTON);	
	}


	@Step("Click to button - Back to kiosk")
	public void clickToButtonBackToKiosk() {
		waitForElementClickable(driver,PublicKioskPageUI.BUTTON_BACK_TO_KIOSK);
		clickToElement(driver, PublicKioskPageUI.BUTTON_BACK_TO_KIOSK);	
	}


	@Step("Verify text - Error message at header")
	public String getErrorMessageAtHeader() {
		waitForElementVisible(driver, PublicKioskPageUI.ERROR_MESSAGE_AT_HEADER);
		return getElementText(driver, PublicKioskPageUI.ERROR_MESSAGE_AT_HEADER);
	}

	//PAGE CONFIG KIOSK

	@Step("Verify text - Config Kiosk")
	public boolean isTextConfigKioskDisplayed() {
		waitForElementVisible(driver, PublicKioskPageUI.TEXT_CONFIG_KIOSK);
		return isElementDisplayed(driver, PublicKioskPageUI.TEXT_CONFIG_KIOSK);
	}

	@Step("Verify text - Computer Printer")
	public boolean isTextComputerPrinterDisplayed() {
		waitForElementVisible(driver, PublicKioskPageUI.TEXT_COMPUTER_PRINTER);
		return isElementDisplayed(driver, PublicKioskPageUI.TEXT_COMPUTER_PRINTER);
	}

	@Step("Verify text - Select default printer")
	public boolean isTextSelectDefaultPrintersDisplayed() {
		waitForElementVisible(driver, PublicKioskPageUI.TEXT_SELECT_DEFAULT_PRINTER);
		return isElementDisplayed(driver, PublicKioskPageUI.TEXT_SELECT_DEFAULT_PRINTER);
	}

	@Step("Verify text - Select default paper")
	public boolean isTextSelectdefaultPaperDisplayed() {
		waitForElementVisible(driver, PublicKioskPageUI.TEXT_SELECT_DEFAULT_PAPER);
		return isElementDisplayed(driver, PublicKioskPageUI.TEXT_SELECT_DEFAULT_PAPER);
	}

	@Step("Verify text - Card Reader")
	public boolean isTextCardReaderDisplayed() {
		waitForElementVisible(driver, PublicKioskPageUI.TEXT_CARD_READER);
		return isElementDisplayed(driver, PublicKioskPageUI.TEXT_CARD_READER);
	}

	@Step("Verify text - Report")
	public boolean isTextReportDisplayed() {
		waitForElementVisible(driver, PublicKioskPageUI.TEXT_REPORT);
		return isElementDisplayed(driver, PublicKioskPageUI.TEXT_REPORT);
	}

	@Step("Click to Dropdown select printer")
	public void clickToDropDownSelectPrinter() {
		waitForElementClickable(driver,PublicKioskPageUI.DROPDOWN_PRINTER);
		clickToElement(driver, PublicKioskPageUI.DROPDOWN_PRINTER);	
	}

	@Step("Click to value of dropdown select printer {0}")
	public void clickToValueOfDropdownSelectPrinter(String namePrinter) {
		waitForElementClickable(driver,PublicKioskPageUI.VALUE_OF_DROPDOWN_PRINTER, namePrinter);
		clickToElement(driver, PublicKioskPageUI.VALUE_OF_DROPDOWN_PRINTER, namePrinter);	
	}

	@Step("Click to dropdown select paper")
	public void clickToDropDownSelectPaper() {
		waitForElementClickable(driver,PublicKioskPageUI.DROPDOWN_PAPER);
		clickToElement(driver, PublicKioskPageUI.DROPDOWN_PAPER);	
	}

	@Step("Click to value of dropdown select paper  {0}")
	public void clickToValueOfDropdownSelectPaper(String namePaper) {
		waitForElementClickable(driver,PublicKioskPageUI.VALUE_OF_DROPDOWN_PAPER, namePaper);
		clickToElement(driver, PublicKioskPageUI.VALUE_OF_DROPDOWN_PAPER, namePaper);	
	}

	@Step("Click to button Reset")
	public void clickToButtonReset() {
		waitForElementClickable(driver,PublicKioskPageUI.BUTTON_RESET_REPORT);
		clickToElement(driver, PublicKioskPageUI.BUTTON_RESET_REPORT);			
	}

	@Step("Verify text - value tix sold")
	public String getValueTixSold() {
		waitForElementVisible(driver, PublicKioskPageUI.TEXT_VALUE_TIX_SOLD);
		return getElementText(driver, PublicKioskPageUI.TEXT_VALUE_TIX_SOLD);
	}

	@Step("Verify text - value total amount")
	public String getValueTotalAmount() {
		waitForElementVisible(driver, PublicKioskPageUI.TEXT_VALUE_TOTAL_AMOUNT);
		return getElementText(driver, PublicKioskPageUI.TEXT_VALUE_TOTAL_AMOUNT);
	}

	@Step("Alert - accept alert")
	public void acceptAlertReport() {
		acceptAlert(driver);
	}

	@Step("Alert - cancel alert")
	public void cancelAlertReport() {
		cancelAlert(driver);
	}

	//PAGE CHECKOUT

	@Step("Click to event name {0}")
	public void clickToChooseEventName(String eventName) {
		waitForElementClickable(driver,PublicKioskPageUI.NAME_OF_EVENT, eventName);
		clickToElement(driver, PublicKioskPageUI.NAME_OF_EVENT, eventName);	
	}

	@Step("Verify text - Name of event from select event screen {0}")
	public String getNameOfEventFromScreenSelectEvent(String eventName) {
		waitForElementVisible(driver, PublicKioskPageUI.NAME_OF_EVENT, eventName);
		return getElementText(driver, PublicKioskPageUI.NAME_OF_EVENT, eventName);
	}

	@Step("Verify text - Name of event from checkout screen")
	public String getNameOfEventFromCheckoutScreen() {
		waitForElementVisible(driver, PublicKioskPageUI.NAME_OF_EVENT_ORDER_SCREEN);
		return getElementText(driver, PublicKioskPageUI.NAME_OF_EVENT_ORDER_SCREEN);
	}

	@Step("Verify text - Order")
	public boolean isTextOrderDisplayed() {
		waitForElementVisible(driver, PublicKioskPageUI.TEXT_ORDER);
		return isElementDisplayed(driver, PublicKioskPageUI.TEXT_ORDER);
	}

	@Step("Click to button - Checkout")
	public void clickToButtonCheckout() {
		waitForElementClickable(driver,PublicKioskPageUI.BUTTON_CHECKOUT_NOW);
		clickToElement(driver, PublicKioskPageUI.BUTTON_CHECKOUT_NOW);	
	}

	@Step("Verify text - Error message when checkout - empty data")
	public String getErrorMessageCheckoutEmptyData() {
		waitForElementVisible(driver, PublicKioskPageUI.ERROR_MESSAGE_EMPTY_DATA);
		return getElementText(driver, PublicKioskPageUI.ERROR_MESSAGE_EMPTY_DATA);
	}

	@Step("Input info of buyer {0} {1}")
	public void inputInfoBuyer(String field, String nameOfBuyer) {
		waitForElementVisible(driver, PublicKioskPageUI.INFO_OF_BUYER, field);
		sendkeyToElement(driver, PublicKioskPageUI.INFO_OF_BUYER, nameOfBuyer, field);		
	}

	@Step("Click to dropdown select quantity ticket {0} {1}")
	public void clickToDropDownSelectQuantityTicket(String nameOfTicket,String textItem) {
		waitForElementClickable(driver,PublicKioskPageUI.DROPDOWN_QUANTITY_TICKET, nameOfTicket);
		selectItemInDefaultDropdown(driver, PublicKioskPageUI.DROPDOWN_QUANTITY_TICKET, textItem, nameOfTicket);	
	}

	@Step("Verify text - Checkout")
	public boolean isTextCheckoutDisplayed() {
		waitForElementVisible(driver, PublicKioskPageUI.TEXT_CHECKOUT);
		return isElementDisplayed(driver, PublicKioskPageUI.TEXT_CHECKOUT);
	}

	@Step("Click to button Kiosk- ")
	public void clickToKiosk() {
		waitForElementClickable(driver,PublicKioskPageUI.BUTTON_KIOSK);
		clickToElement(driver, PublicKioskPageUI.BUTTON_KIOSK);	
	}

	@Step("Choose Card Reader")
	public void clickToRadioButtonCardReader() {
		waitForElementClickable(driver,PublicKioskPageUI.CARD_READER_NAME);
		clickToElement(driver, PublicKioskPageUI.CARD_READER_NAME);	

	}

	@Step("Click to button - Charge Card")
	public void clickToButtonChargeCard() {
		waitForElementClickable(driver,PublicKioskPageUI.BUTTON_CHARGE_CARD);
		clickToElement(driver, PublicKioskPageUI.BUTTON_CHARGE_CARD);	

	}

	@Step("Verify text - Tap to insert payment")
	public boolean isTextTapToInsertPayment() {
		waitForElementVisible(driver, PublicKioskPageUI.TEXT_TAP_TO_INSERT_PAYMENT);
		return isElementDisplayed(driver, PublicKioskPageUI.TEXT_TAP_TO_INSERT_PAYMENT);
	}

	@Step("Verify text - Order Success")
	public boolean isTextSuccessPleaseWait() {
		waitForElementVisible(driver, PublicKioskPageUI.TEXT_SUCCESS_PLEASE_WAIT);
		return isElementDisplayed(driver, PublicKioskPageUI.TEXT_SUCCESS_PLEASE_WAIT);
	}

	@Step("Verify text - Please take your tickets")
	public boolean isTextPleaseTakeYourTickets() {
		waitForElementVisible(driver, PublicKioskPageUI.TEXT_PLEASE_TAKE_YOUR_TICKETS);
		return isElementDisplayed(driver, PublicKioskPageUI.TEXT_PLEASE_TAKE_YOUR_TICKETS);
	}

	@Step("Choose Card Reader of Config screen")
	public void clickToRadioButtonCardReaderFromConfig() {
		waitForElementClickable(driver,PublicKioskPageUI.RADIO_BUTTON_CARD_READER);
		clickToElement(driver, PublicKioskPageUI.RADIO_BUTTON_CARD_READER);	
	}

	@Step("Click to button - Cancel Payment")
	public void clickToButtonCancelPayment() {
		waitForElementClickable(driver,PublicKioskPageUI.BUTTON_CANCEL_PAYMENT);
		clickToElement(driver, PublicKioskPageUI.BUTTON_CANCEL_PAYMENT);	
	}

	@Step("Verify text - Payment method declined")
	public boolean isTextPaymentMethodDeclined() {
		waitForElementVisible(driver, PublicKioskPageUI.TEXT_PAYMENT_METHOD_DECLINED);
		return isElementDisplayed(driver, PublicKioskPageUI.TEXT_PAYMENT_METHOD_DECLINED);
	}

	@Step("Click to button - Back")
	public void clickToButtonBack() {
		waitForElementClickable(driver,PublicKioskPageUI.BUTTON_BACK_FROM_PAYMENT_METHOD_DECLINED);
		clickToElement(driver, PublicKioskPageUI.BUTTON_BACK_FROM_PAYMENT_METHOD_DECLINED);	
	}

	@Step("Click to dropdown Select ticket")
	public void clickToDropDownSelectTicket() {
		waitForElementClickable(driver,PublicKioskPageUI.DROPDOWN_TICKET);
		clickToElement(driver, PublicKioskPageUI.DROPDOWN_TICKET);	
	}

	@Step("Click to value of dropdown Select ticket")
	public void clickToValueOfDropdownSelectTicket() {
		waitForElementClickable(driver,PublicKioskPageUI.VALUE_DROPDOWN_TICKET);
		clickToElement(driver, PublicKioskPageUI.VALUE_DROPDOWN_TICKET);	
	}
	@Step("Choose card reader {0}")
	public void clickToChooseCardReader(String readerName) {
		waitForElementClickable(driver,PublicKioskPageUI.READER_NAME_CHECKOUT_SCREEN, readerName);
		checkToDefaultCheckboxOrRadio(driver, PublicKioskPageUI.READER_NAME_CHECKOUT_SCREEN, readerName);
	}

	@Step("Click to button - Kiosk - of Payment screen")
	public void clickToKioskButtonPaymentScreen() {
		waitForElementClickable(driver,PublicKioskPageUI.KIOSK_BUTTON_PAYMENT_SCREEN);
		clickToElement(driver, PublicKioskPageUI.KIOSK_BUTTON_PAYMENT_SCREEN);
	}
}
