package pageObject.user;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.BoxOfficeUI;
import pageUIs.user.ForgotPasswordPageUI;
import pageUIs.user.HomePageUI;
import pageUIs.user.LoginPageUI;
import pageUIs.user.PublicKioskUI;
import pageUIs.user.RegisterPageUI;

public class UserPublicKioskObject extends BasePage{

	private WebDriver driver;
	
	public UserPublicKioskObject(WebDriver driver) {
		this.driver = driver;
	}
	
	//PAGE CHOOSE EVENT
	public boolean isTextPleaseChooseEventDisplayed() {
		waitForElementVisible(driver, PublicKioskUI.PLEASE_CHOOSE_EVENT_TEXT);
		return isElementDisplayed(driver, PublicKioskUI.PLEASE_CHOOSE_EVENT_TEXT);
	}
	
	public boolean isButtonConfigKioskDisplayed() {
		waitForElementVisible(driver, PublicKioskUI.CONFIG_KIOSK_BUTTON);
		return isElementDisplayed(driver, PublicKioskUI.CONFIG_KIOSK_BUTTON);
	}
	
	public void clickToButtonConfigKiosk() {
		waitForElementClickable(driver,PublicKioskUI.CONFIG_KIOSK_BUTTON);
		clickToElement(driver, PublicKioskUI.CONFIG_KIOSK_BUTTON);	
	}
	
	public void clickToChooseEventName() {
		waitForElementClickable(driver,PublicKioskUI.NAME_OF_EVENT);
		clickToElement(driver, PublicKioskUI.NAME_OF_EVENT);	
	}
	

	
	
	//PAGE ACCESS CODE CONFIG KIOSK
	public boolean isTextEnterCodeAccessDisplayed() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_ENTER_CODE_ACCESS);
		return isElementDisplayed(driver, PublicKioskUI.TEXT_ENTER_CODE_ACCESS);
	}

	public void inputCodeAccessConfigKiosk(String accessCode) {
		waitForElementClickable(driver,PublicKioskUI.TEXTBOX_INPUT_CODE);
		sendkeyToElement(driver, PublicKioskUI.TEXTBOX_INPUT_CODE, accessCode);	
	}

	public void clickToButtonConfirmCode() {
		waitForElementClickable(driver,PublicKioskUI.CONFIRM_BUTTON);
		clickToElement(driver, PublicKioskUI.CONFIRM_BUTTON);	
	}
	
	public void clickToButtonBackToKioskFromAccessCode() {
		waitForElementClickable(driver,PublicKioskUI.BUTTON_BACK_TO_KIOSK_FROM_SCREEN_ACCESS);
		clickToElement(driver, PublicKioskUI.BUTTON_BACK_TO_KIOSK_FROM_SCREEN_ACCESS);	
	}

	public String getErrorMessageCodeAccessConfigKiosk() {
		waitForElementVisible(driver, PublicKioskUI.ERROR_MESSAGE_CODE_ACCESS_CONFIG_KIOSK);
		return getElementText(driver, PublicKioskUI.ERROR_MESSAGE_CODE_ACCESS_CONFIG_KIOSK);
	}
	
	//PAGE CONFIG KIOSK
	public boolean isTextConfigKioskDisplayed() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_CONFIG_KIOSK);
		return isElementDisplayed(driver, PublicKioskUI.TEXT_CONFIG_KIOSK);
	}
	
	public boolean isTextComputerPrinterDisplayed() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_COMPUTER_PRINTER);
		return isElementDisplayed(driver, PublicKioskUI.TEXT_COMPUTER_PRINTER);
	}
	
	public boolean isTextSelectDefaultPrintersDisplayed() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_SELECT_DEFAULT_PRINTER);
		return isElementDisplayed(driver, PublicKioskUI.TEXT_SELECT_DEFAULT_PRINTER);
	}
	
	public boolean isTextSelectdefaultPaperDisplayed() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_SELECT_DEFAULT_PAPER);
		return isElementDisplayed(driver, PublicKioskUI.TEXT_SELECT_DEFAULT_PAPER);
	}
	
	public boolean isTextCardReaderDisplayed() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_CARD_READER);
		return isElementDisplayed(driver, PublicKioskUI.TEXT_CARD_READER);
	}
	
	public boolean isTextReportDisplayed() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_REPORT);
		return isElementDisplayed(driver, PublicKioskUI.TEXT_REPORT);
	}

	public void clickToDropDownSelectPrinter() {
		waitForElementClickable(driver,PublicKioskUI.DROPDOWN_PRINTER);
		clickToElement(driver, PublicKioskUI.DROPDOWN_PRINTER);	
	}

	public void clickToValueOfDropdownSelectPrinter() {
		waitForElementClickable(driver,PublicKioskUI.VALUE_OF_DROPDOWN_PRINTER);
		clickToElement(driver, PublicKioskUI.VALUE_OF_DROPDOWN_PRINTER);	
	}

	public boolean isSelectedPrinterValueDisplayed() {
		waitForElementVisible(driver, PublicKioskUI.VALUE_SELECTED_OF_DROPDOWN_PRINTER);
		return isElementDisplayed(driver, PublicKioskUI.VALUE_SELECTED_OF_DROPDOWN_PRINTER);
	}

	public void clickToDropDownSelectPaper() {
		waitForElementClickable(driver,PublicKioskUI.DROPDOWN_PAPER);
		clickToElement(driver, PublicKioskUI.DROPDOWN_PAPER);	
	}

	public void clickToValueOfDropdownSelectPaper() {
		waitForElementClickable(driver,PublicKioskUI.VALUE_OF_DROPDOWN_PAPER);
		clickToElement(driver, PublicKioskUI.VALUE_OF_DROPDOWN_PAPER);	
	}

	public boolean isSelectedPaperValueDisplayed() {
		waitForElementVisible(driver, PublicKioskUI.VALUE_SELECTED_OF_DROPDOWN_PAPER);
		return isElementDisplayed(driver, PublicKioskUI.VALUE_SELECTED_OF_DROPDOWN_PAPER);
	}

	public void clickToButtonReset() {
		waitForElementClickable(driver,PublicKioskUI.BUTTON_RESET_REPORT);
		clickToElement(driver, PublicKioskUI.BUTTON_RESET_REPORT);			
	}

	public String getValueTixSold() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_VALUE_TIX_SOLD);
		return getElementText(driver, PublicKioskUI.TEXT_VALUE_TIX_SOLD);
	}

	public String getValueTotalAmount() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_VALUE_TOTAL_AMOUNT);
		return getElementText(driver, PublicKioskUI.TEXT_VALUE_TOTAL_AMOUNT);
	}

	public void clickToButtonBackToKioskFromConfigKiosk() {
		waitForElementClickable(driver,PublicKioskUI.BUTTON_BACK_TO_KIOSK_FROM_SCREEN_CONFIG);
		clickToElement(driver, PublicKioskUI.BUTTON_BACK_TO_KIOSK_FROM_SCREEN_CONFIG);			
	}

	public void acceptAlertReport() {
		acceptAlert(driver);
	}
	
	public void cancelAlertReport() {
		cancelAlert(driver);
	}

	//PAGE CHECKOUT
	public String getNameOfEventFromScreenSelectEvent() {
		waitForElementVisible(driver, PublicKioskUI.NAME_OF_EVENT);
		return getElementText(driver, PublicKioskUI.NAME_OF_EVENT);
	}

	public String getNameOfEventFromCheckoutScreen() {
		waitForElementVisible(driver, PublicKioskUI.NAME_OF_EVENT_ORDER_SCREEN);
		return getElementText(driver, PublicKioskUI.NAME_OF_EVENT_ORDER_SCREEN);
	}

	public boolean isTextOrderDisplayed() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_ORDER);
		return isElementDisplayed(driver, PublicKioskUI.TEXT_ORDER);
	}

	public void clickToButtonCheckout() {
		waitForElementClickable(driver,PublicKioskUI.BUTTON_CHECKOUT_NOW);
		clickToElement(driver, PublicKioskUI.BUTTON_CHECKOUT_NOW);	
	}

	public String getErrorMessageCheckoutEmptyData() {
		waitForElementVisible(driver, PublicKioskUI.ERROR_MESSAGE_EMPTY_DATA);
		return getElementText(driver, PublicKioskUI.ERROR_MESSAGE_EMPTY_DATA);
	}
	
	public void inputToEmailTextbox(String invalidEmail) {
		waitForElementVisible(driver, LoginPageUI.TEXTBOX_LOGIN);
		sendkeyToElement(driver, LoginPageUI.TEXTBOX_LOGIN, invalidEmail);		
	}

	public void inputNameOfBuyer(String nameOfBuyer) {
		waitForElementVisible(driver, LoginPageUI.NAME_OF_BUYER);
		sendkeyToElement(driver, LoginPageUI.NAME_OF_BUYER, nameOfBuyer);		
	}

	public void inputPhoneNumberOfBuyer(String phoneNumber) {
		waitForElementVisible(driver, LoginPageUI.PHONE_NUMBER_OF_BUYER);
		sendkeyToElement(driver, LoginPageUI.PHONE_NUMBER_OF_BUYER, phoneNumber);		
	}

	public void clickToDropDownSelectQuantityTicket(String textItem) {
		waitForElementClickable(driver,PublicKioskUI.DROPDOWN_QUANTITY_TICKET);
		selectItemInDefaultDropdown(driver, PublicKioskUI.DROPDOWN_QUANTITY_TICKET, textItem);	
		
	}

	public boolean isTextCheckoutDisplayed() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_CHECKOUT);
		return isElementDisplayed(driver, PublicKioskUI.TEXT_CHECKOUT);
	}

	public void clickToKiosk() {
		waitForElementClickable(driver,PublicKioskUI.BUTTON_KIOSK);
		clickToElement(driver, PublicKioskUI.BUTTON_KIOSK);	
	}

	public void clickToRadioButtonCardReader() {
		waitForElementClickable(driver,PublicKioskUI.CARD_READER_NAME);
		clickToElement(driver, PublicKioskUI.CARD_READER_NAME);	
		
	}

	public void clickToButtonChargeCard() {
		waitForElementClickable(driver,PublicKioskUI.BUTTON_CHARGE_CARD);
		clickToElement(driver, PublicKioskUI.BUTTON_CHARGE_CARD);	
		
	}

	public boolean isTextTapToInsertPayment() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_TAP_TO_INSERT_PAYMENT);
		return isElementDisplayed(driver, PublicKioskUI.TEXT_TAP_TO_INSERT_PAYMENT);
	}

	public boolean isTextSuccessPleaseWait() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_SUCCESS_PLEASE_WAIT);
		return isElementDisplayed(driver, PublicKioskUI.TEXT_SUCCESS_PLEASE_WAIT);
	}

	public boolean isTextPleaseTakeYourTickets() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_PLEASE_TAKE_YOUR_TICKETS);
		return isElementDisplayed(driver, PublicKioskUI.TEXT_PLEASE_TAKE_YOUR_TICKETS);
	}

	public void clickToRadioButtonCardReaderFromConfig() {
		waitForElementClickable(driver,PublicKioskUI.RADIO_BUTTON_CARD_READER);
		clickToElement(driver, PublicKioskUI.RADIO_BUTTON_CARD_READER);	
	}

	public void clickToButtonCancelPayment() {
		waitForElementClickable(driver,PublicKioskUI.BUTTON_CANCEL_PAYMENT);
		clickToElement(driver, PublicKioskUI.BUTTON_CANCEL_PAYMENT);	
	}

	public boolean isTextPaymentMethodDeclined() {
		waitForElementVisible(driver, PublicKioskUI.TEXT_PAYMENT_METHOD_DECLINED);
		return isElementDisplayed(driver, PublicKioskUI.TEXT_PAYMENT_METHOD_DECLINED);
	}
	
	public void clickToButtonBack() {
		waitForElementClickable(driver,PublicKioskUI.BUTTON_BACK_FROM_PAYMENT_METHOD_DECLINED);
		clickToElement(driver, PublicKioskUI.BUTTON_BACK_FROM_PAYMENT_METHOD_DECLINED);	
	}

	public void clickToDropDownSelectTicket() {
		waitForElementClickable(driver,PublicKioskUI.DROPDOWN_TICKET);
		clickToElement(driver, PublicKioskUI.DROPDOWN_TICKET);	
	}

	public void clickToValueOfDropdownSelectTicket() {
		waitForElementClickable(driver,PublicKioskUI.VALUE_DROPDOWN_TICKET);
		clickToElement(driver, PublicKioskUI.VALUE_DROPDOWN_TICKET);	
	}
	
}
