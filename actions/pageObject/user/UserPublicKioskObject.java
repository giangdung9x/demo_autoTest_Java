package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.user.PublicKioskUI;

public class UserPublicKioskObject extends BasePage{

	private WebDriver driver;
	
	public UserPublicKioskObject(WebDriver driver) {
		this.driver = driver;
	}
	
	//PAGE CHOOSE EVENT
	@Step("Verify text - Please Choose Event")
	public boolean isTextPleaseChooseEventDisplayed() {
		waitForElementVisible(driver, PublicKioskUI.PLEASE_CHOOSE_EVENT_TEXT);
		return isElementDisplayed(driver, PublicKioskUI.PLEASE_CHOOSE_EVENT_TEXT);
	}
	
	@Step("Verify button - Config Kiosk")
	public boolean isButtonConfigKioskDisplayed() {
		waitForElementVisible(driver, PublicKioskUI.CONFIG_KIOSK_BUTTON);
		return isElementDisplayed(driver, PublicKioskUI.CONFIG_KIOSK_BUTTON);
	}

	@Step("Click to button - Config Kiosk")
	public void clickToButtonConfigKiosk() {
		waitForElementClickable(driver,PublicKioskUI.CONFIG_KIOSK_BUTTON);
		clickToElement(driver, PublicKioskUI.CONFIG_KIOSK_BUTTON);	
	}
	

	//PAGE ACCESS CODE CONFIG KIOSK

	@Step("Verify text - Enter Code Access")
	public boolean isTextEnterCodeAccessDisplayed() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_ENTER_CODE_ACCESS);
		return isElementDisplayed(driver, PublicKioskUI.TEXT_ENTER_CODE_ACCESS);
	}


	@Step("Input code access {0}")
	public void inputCodeAccessConfigKiosk(String accessCode) {
		waitForElementClickable(driver,PublicKioskUI.TEXTBOX_INPUT_CODE);
		sendkeyToElement(driver, PublicKioskUI.TEXTBOX_INPUT_CODE, accessCode);	
	}

	@Step("Click to button - Confirm")
	public void clickToButtonConfirmCode() {
		waitForElementClickable(driver,PublicKioskUI.CONFIRM_BUTTON);
		clickToElement(driver, PublicKioskUI.CONFIRM_BUTTON);	
	}
	

	@Step("Click to button - Back to kiosk")
	public void clickToButtonBackToKiosk() {
		waitForElementClickable(driver,PublicKioskUI.BUTTON_BACK_TO_KIOSK);
		clickToElement(driver, PublicKioskUI.BUTTON_BACK_TO_KIOSK);	
	}
	

	@Step("Verify text - Error message at header")
	public String getErrorMessageAtHeader() {
		waitForElementVisible(driver, PublicKioskUI.ERROR_MESSAGE_AT_HEADER);
		return getElementText(driver, PublicKioskUI.ERROR_MESSAGE_AT_HEADER);
	}
	
	//PAGE CONFIG KIOSK

	@Step("Verify text - Config Kiosk")
	public boolean isTextConfigKioskDisplayed() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_CONFIG_KIOSK);
		return isElementDisplayed(driver, PublicKioskUI.TEXT_CONFIG_KIOSK);
	}
	
	@Step("Verify text - Computer Printer")
	public boolean isTextComputerPrinterDisplayed() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_COMPUTER_PRINTER);
		return isElementDisplayed(driver, PublicKioskUI.TEXT_COMPUTER_PRINTER);
	}

	@Step("Verify text - Select default printer")
	public boolean isTextSelectDefaultPrintersDisplayed() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_SELECT_DEFAULT_PRINTER);
		return isElementDisplayed(driver, PublicKioskUI.TEXT_SELECT_DEFAULT_PRINTER);
	}

	@Step("Verify text - Select default paper")
	public boolean isTextSelectdefaultPaperDisplayed() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_SELECT_DEFAULT_PAPER);
		return isElementDisplayed(driver, PublicKioskUI.TEXT_SELECT_DEFAULT_PAPER);
	}

	@Step("Verify text - Card Reader")
	public boolean isTextCardReaderDisplayed() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_CARD_READER);
		return isElementDisplayed(driver, PublicKioskUI.TEXT_CARD_READER);
	}

	@Step("Verify text - Report")
	public boolean isTextReportDisplayed() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_REPORT);
		return isElementDisplayed(driver, PublicKioskUI.TEXT_REPORT);
	}

	@Step("Click to Dropdown select printer")
	public void clickToDropDownSelectPrinter() {
		waitForElementClickable(driver,PublicKioskUI.DROPDOWN_PRINTER);
		clickToElement(driver, PublicKioskUI.DROPDOWN_PRINTER);	
	}

	@Step("Click to value of dropdown select printer {0}")
	public void clickToValueOfDropdownSelectPrinter(String namePrinter) {
		waitForElementClickable(driver,PublicKioskUI.VALUE_OF_DROPDOWN_PRINTER, namePrinter);
		clickToElement(driver, PublicKioskUI.VALUE_OF_DROPDOWN_PRINTER, namePrinter);	
	}

	@Step("Click to dropdown select paper")
	public void clickToDropDownSelectPaper() {
		waitForElementClickable(driver,PublicKioskUI.DROPDOWN_PAPER);
		clickToElement(driver, PublicKioskUI.DROPDOWN_PAPER);	
	}

	@Step("Click to value of dropdown select paper  {0}")
	public void clickToValueOfDropdownSelectPaper(String namePaper) {
		waitForElementClickable(driver,PublicKioskUI.VALUE_OF_DROPDOWN_PAPER, namePaper);
		clickToElement(driver, PublicKioskUI.VALUE_OF_DROPDOWN_PAPER, namePaper);	
	}

	@Step("Click to button Reset")
	public void clickToButtonReset() {
		waitForElementClickable(driver,PublicKioskUI.BUTTON_RESET_REPORT);
		clickToElement(driver, PublicKioskUI.BUTTON_RESET_REPORT);			
	}

	@Step("Verify text - value tix sold")
	public String getValueTixSold() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_VALUE_TIX_SOLD);
		return getElementText(driver, PublicKioskUI.TEXT_VALUE_TIX_SOLD);
	}

	@Step("Verify text - value total amount")
	public String getValueTotalAmount() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_VALUE_TOTAL_AMOUNT);
		return getElementText(driver, PublicKioskUI.TEXT_VALUE_TOTAL_AMOUNT);
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
		waitForElementClickable(driver,PublicKioskUI.NAME_OF_EVENT, eventName);
		clickToElement(driver, PublicKioskUI.NAME_OF_EVENT, eventName);	
	}

	@Step("Verify text - Name of event from select event screen {0}")
	public String getNameOfEventFromScreenSelectEvent(String eventName) {
		waitForElementVisible(driver, PublicKioskUI.NAME_OF_EVENT, eventName);
		return getElementText(driver, PublicKioskUI.NAME_OF_EVENT, eventName);
	}

	@Step("Verify text - Name of event from checkout screen")
	public String getNameOfEventFromCheckoutScreen() {
		waitForElementVisible(driver, PublicKioskUI.NAME_OF_EVENT_ORDER_SCREEN);
		return getElementText(driver, PublicKioskUI.NAME_OF_EVENT_ORDER_SCREEN);
	}

	@Step("Verify text - Order")
	public boolean isTextOrderDisplayed() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_ORDER);
		return isElementDisplayed(driver, PublicKioskUI.TEXT_ORDER);
	}

	@Step("Click to button - Checkout")
	public void clickToButtonCheckout() {
		waitForElementClickable(driver,PublicKioskUI.BUTTON_CHECKOUT_NOW);
		clickToElement(driver, PublicKioskUI.BUTTON_CHECKOUT_NOW);	
	}

	@Step("Verify text - Error message when checkout - empty data")
	public String getErrorMessageCheckoutEmptyData() {
		waitForElementVisible(driver, PublicKioskUI.ERROR_MESSAGE_EMPTY_DATA);
		return getElementText(driver, PublicKioskUI.ERROR_MESSAGE_EMPTY_DATA);
	}

	@Step("Input info of buyer {0} {1}")
	public void inputInfoBuyer(String field, String nameOfBuyer) {
		waitForElementVisible(driver, PublicKioskUI.INFO_OF_BUYER, field);
		sendkeyToElement(driver, PublicKioskUI.INFO_OF_BUYER, nameOfBuyer, field);		
	}

	@Step("Click to dropdown select quantity ticket {0} {1}")
	public void clickToDropDownSelectQuantityTicket(String nameOfTicket,String textItem) {
		waitForElementClickable(driver,PublicKioskUI.DROPDOWN_QUANTITY_TICKET, nameOfTicket);
		selectItemInDefaultDropdown(driver, PublicKioskUI.DROPDOWN_QUANTITY_TICKET, textItem, nameOfTicket);	
	}

	@Step("Verify text - Checkout")
	public boolean isTextCheckoutDisplayed() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_CHECKOUT);
		return isElementDisplayed(driver, PublicKioskUI.TEXT_CHECKOUT);
	}

	@Step("Click to button Kiosk- ")
	public void clickToKiosk() {
		waitForElementClickable(driver,PublicKioskUI.BUTTON_KIOSK);
		clickToElement(driver, PublicKioskUI.BUTTON_KIOSK);	
	}

	@Step("Choose Card Reader")
	public void clickToRadioButtonCardReader() {
		waitForElementClickable(driver,PublicKioskUI.CARD_READER_NAME);
		clickToElement(driver, PublicKioskUI.CARD_READER_NAME);	
		
	}

	@Step("Click to button - Charge Card")
	public void clickToButtonChargeCard() {
		waitForElementClickable(driver,PublicKioskUI.BUTTON_CHARGE_CARD);
		clickToElement(driver, PublicKioskUI.BUTTON_CHARGE_CARD);	
		
	}

	@Step("Verify text - Tap to insert payment")
	public boolean isTextTapToInsertPayment() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_TAP_TO_INSERT_PAYMENT);
		return isElementDisplayed(driver, PublicKioskUI.TEXT_TAP_TO_INSERT_PAYMENT);
	}

	@Step("Verify text - Order Success")
	public boolean isTextSuccessPleaseWait() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_SUCCESS_PLEASE_WAIT);
		return isElementDisplayed(driver, PublicKioskUI.TEXT_SUCCESS_PLEASE_WAIT);
	}

	@Step("Verify text - Please take your tickets")
	public boolean isTextPleaseTakeYourTickets() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_PLEASE_TAKE_YOUR_TICKETS);
		return isElementDisplayed(driver, PublicKioskUI.TEXT_PLEASE_TAKE_YOUR_TICKETS);
	}

	@Step("Choose Card Reader of Config screen")
	public void clickToRadioButtonCardReaderFromConfig() {
		waitForElementClickable(driver,PublicKioskUI.RADIO_BUTTON_CARD_READER);
		clickToElement(driver, PublicKioskUI.RADIO_BUTTON_CARD_READER);	
	}

	@Step("Click to button - Cancel Payment")
	public void clickToButtonCancelPayment() {
		waitForElementClickable(driver,PublicKioskUI.BUTTON_CANCEL_PAYMENT);
		clickToElement(driver, PublicKioskUI.BUTTON_CANCEL_PAYMENT);	
	}

	@Step("Verify text - Payment method declined")
	public boolean isTextPaymentMethodDeclined() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_PAYMENT_METHOD_DECLINED);
		return isElementDisplayed(driver, PublicKioskUI.TEXT_PAYMENT_METHOD_DECLINED);
	}

	@Step("Click to button - Back")
	public void clickToButtonBack() {
		waitForElementClickable(driver,PublicKioskUI.BUTTON_BACK_FROM_PAYMENT_METHOD_DECLINED);
		clickToElement(driver, PublicKioskUI.BUTTON_BACK_FROM_PAYMENT_METHOD_DECLINED);	
	}

	@Step("Click to dropdown Select ticket")
	public void clickToDropDownSelectTicket() {
		waitForElementClickable(driver,PublicKioskUI.DROPDOWN_TICKET);
		clickToElement(driver, PublicKioskUI.DROPDOWN_TICKET);	
	}

	@Step("Click to value of dropdown Select ticket")
	public void clickToValueOfDropdownSelectTicket() {
		waitForElementClickable(driver,PublicKioskUI.VALUE_DROPDOWN_TICKET);
		clickToElement(driver, PublicKioskUI.VALUE_DROPDOWN_TICKET);	
	}
	
}
