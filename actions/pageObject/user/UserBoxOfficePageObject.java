package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.BoxOfficeUI;
import pageUIs.user.ForgotPasswordPageUI;
import pageUIs.user.HomePageUI;
import pageUIs.user.LoginPageUI;
import pageUIs.user.PublicKioskUI;

public class UserBoxOfficePageObject extends BasePage{

	private WebDriver driver;
	
	public UserBoxOfficePageObject(WebDriver driver) {
		this.driver = driver;
	}

	//LOGIN
	public void inputToEmailTextbox(String validEmail) {
		waitForElementVisible(driver, BoxOfficeUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, BoxOfficeUI.EMAIL_TEXTBOX, validEmail);		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, BoxOfficeUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, BoxOfficeUI.PASSWORD_TEXTBOX, password);		
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver,BoxOfficeUI.LOGIN_BUTTON);
		clickToElement(driver, BoxOfficeUI.LOGIN_BUTTON);	
	}
	

	//BOX OFFICE
	public boolean isBoxOfficeTextDisplayed() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_BOX_OFFICE_SCREEN);
		return isElementDisplayed(driver, BoxOfficeUI.TEXT_BOX_OFFICE_SCREEN);
	}
		///MORE MENU
	public void clickToMoreMenuButton() {
		waitForElementClickable(driver,BoxOfficeUI.MORE_MENU_BUTTON);
		clickToElement(driver, BoxOfficeUI.MORE_MENU_BUTTON);	
	}
	
	public void clickToInstructionButton() {
		waitForElementClickable(driver,BoxOfficeUI.INSTRUCTION_BUTTON);
		clickToElement(driver, BoxOfficeUI.INSTRUCTION_BUTTON);	
	}
	
	public void clickToCopyLinkButton() {
		waitForElementClickable(driver,BoxOfficeUI.COPY_LINK_BUTTON);
		clickToElement(driver, BoxOfficeUI.COPY_LINK_BUTTON);			
	}
	
	public void acceptAlertBoxOffice() {
		acceptAlert(driver);
	}
	
	public void cancelAlertBoxOffice() {
		cancelAlert(driver);
	}

	public void clickToCardReadersButton() {
		waitForElementClickable(driver,BoxOfficeUI.CARD_READER_BUTTON);
		clickToElement(driver, BoxOfficeUI.CARD_READER_BUTTON);	
	}

	public void clickToInformationButton() {
		waitForElementClickable(driver,BoxOfficeUI.INFORMATION_BUTTON);
		clickToElement(driver, BoxOfficeUI.INFORMATION_BUTTON);	
	}
	
	public void clickToLogOutButton() {
		waitForElementClickable(driver,BoxOfficeUI.LOG_OUT_BUTTON);
		clickToElement(driver, BoxOfficeUI.LOG_OUT_BUTTON);	
	}

	public boolean isTitleInstructionYoutubeDisplayed() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_TITLE_INSTRUCTION_YOUTUBE);
		return isElementDisplayed(driver, BoxOfficeUI.TEXT_TITLE_INSTRUCTION_YOUTUBE);
	}



	public boolean isLoginButtonDisplayed() {
		waitForElementVisible(driver, BoxOfficeUI.LOGIN_BUTTON_HOMEPAGE);
		return isElementDisplayed(driver, BoxOfficeUI.LOGIN_BUTTON_HOMEPAGE);
	}

	
	public void switchToWindowByID(String windowID) {
		switchToWindowByID(driver, windowID);	
	}
	
	public void switchToWindowByTitle(String windowID) {
		switchToWindowByTitle(driver, windowID);	
	}

	public boolean isTitleRegisteredReadersDisplayed() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_REGISTERED_READERS);
		return isElementDisplayed(driver, BoxOfficeUI.TEXT_REGISTERED_READERS);
	}

	public boolean isTitleBoxOfficeInformationDisplayed() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_BOX_OFFICE_INFORMATION);
		return isElementDisplayed(driver, BoxOfficeUI.TEXT_BOX_OFFICE_INFORMATION);
	}

		///INFORMATION BOX OFFICE
	public void clickToDropDownSelectPrinter() {
		waitForElementClickable(driver,BoxOfficeUI.DROPDOWN_PRINTER);
		clickToElement(driver, BoxOfficeUI.DROPDOWN_PRINTER);	
	}
	
	public void clickToValueOfDropdownSelectPrinter() {
		waitForElementClickable(driver,BoxOfficeUI.VALUE_OF_DROPDOWN_PRINTER);
		clickToElement(driver, BoxOfficeUI.VALUE_OF_DROPDOWN_PRINTER);	
	}
	
	public boolean isSelectedPrinterValueDisplayed() {
		waitForElementVisible(driver, BoxOfficeUI.VALUE_SELECTED_OF_DROPDOWN_PRINTER);
		return isElementDisplayed(driver, BoxOfficeUI.VALUE_SELECTED_OF_DROPDOWN_PRINTER);
	}
	
	public boolean isTextSelectdefaultPaperDisplayed() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_SELECT_DEFAULT_PAPER);
		return isElementDisplayed(driver, BoxOfficeUI.TEXT_SELECT_DEFAULT_PAPER);
	}
	
	public void clickToDropDownSelectPaper() {
		waitForElementClickable(driver,BoxOfficeUI.DROPDOWN_PAPER);
		clickToElement(driver, BoxOfficeUI.DROPDOWN_PAPER);	
	}

	public void clickToValueOfDropdownSelectPaper() {
		waitForElementClickable(driver,BoxOfficeUI.VALUE_OF_DROPDOWN_PAPER);
		clickToElement(driver, BoxOfficeUI.VALUE_OF_DROPDOWN_PAPER);	
	}

	public boolean isSelectedPaperValueDisplayed() {
		waitForElementVisible(driver, BoxOfficeUI.VALUE_SELECTED_OF_DROPDOWN_PAPER);
		return isElementDisplayed(driver, BoxOfficeUI.VALUE_SELECTED_OF_DROPDOWN_PAPER);
	}

	public void clickToButtonReset() {
		waitForElementClickable(driver,BoxOfficeUI.BUTTON_RESET_REPORT);
		clickToElement(driver, BoxOfficeUI.BUTTON_RESET_REPORT);			
	}

	public String getValueTixSoldCardReader() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_VALUE_TIX_SOLD_CARD_READER);
		return getElementText(driver, BoxOfficeUI.TEXT_VALUE_TIX_SOLD_CARD_READER);
	}

	public String getValueTotalAmountCardReader() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_VALUE_TOTAL_AMOUNT_CARD_READER);
		return getElementText(driver, BoxOfficeUI.TEXT_VALUE_TOTAL_AMOUNT_CARD_READER);
	}
	
	public String getValueTixSoldCash() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_VALUE_TIX_SOLD_CASH);
		return getElementText(driver, BoxOfficeUI.TEXT_VALUE_TIX_SOLD_CASH);
	}

	public String getValueTotalAmountCash() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_VALUE_TOTAL_AMOUNT_CASH);
		return getElementText(driver, BoxOfficeUI.TEXT_VALUE_TOTAL_AMOUNT_CASH);
	}
	
	public String getValueTixSoldCard() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_VALUE_TIX_SOLD_CARD);
		return getElementText(driver, BoxOfficeUI.TEXT_VALUE_TIX_SOLD_CARD);
	}

	public String getValueTotalAmountCard() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_VALUE_TOTAL_AMOUNT_CARD);
		return getElementText(driver, BoxOfficeUI.TEXT_VALUE_TOTAL_AMOUNT_CARD);
	}
	
	public String getValueTixSoldComp() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_VALUE_TIX_SOLD_COMP);
		return getElementText(driver, BoxOfficeUI.TEXT_VALUE_TIX_SOLD_COMP);
	}

	public String getValueTotalAmountComp() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_VALUE_TOTAL_AMOUNT_COMP);
		return getElementText(driver, BoxOfficeUI.TEXT_VALUE_TOTAL_AMOUNT_COMP);
	}
	
	public String getValueTixSoldPayLater() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_VALUE_TIX_SOLD_PAY_LATER);
		return getElementText(driver, BoxOfficeUI.TEXT_VALUE_TIX_SOLD_PAY_LATER);
	}

	public String getValueTotalAmountPayLater() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_VALUE_TOTAL_AMOUNT_PAY_LATER);
		return getElementText(driver, BoxOfficeUI.TEXT_VALUE_TOTAL_AMOUNT_PAY_LATER);
	}
	
	public String getValueTixSoldTotal() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_VALUE_TIX_SOLD_TOTAL);
		return getElementText(driver, BoxOfficeUI.TEXT_VALUE_TIX_SOLD_TOTAL);
	}

	public String getValueTotalAmountTotal() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_VALUE_TOTAL_AMOUNT_TOTAL);
		return getElementText(driver, BoxOfficeUI.TEXT_VALUE_TOTAL_AMOUNT_TOTAL);
	}

	public void clickToButtonBackToBoxOfficeFromInformationScreen() {
		waitForElementClickable(driver,BoxOfficeUI.BUTTON_BACK_TO_BOX_OFFICE_FROM_SCREEN_INFORMATION);
		clickToElement(driver, BoxOfficeUI.BUTTON_BACK_TO_BOX_OFFICE_FROM_SCREEN_INFORMATION);			
	}

	public void acceptAlertReport() {
		acceptAlert(driver);
	}
	
	public void cancelAlertReport() {
		cancelAlert(driver);
	}
	
	//DROPDOWN - BOX OFFICE 
	public void clickToDropDownSelectVenueName(String textVenue) {
		waitForElementClickable(driver,BoxOfficeUI.DROPDOWN_VENUE);
		selectItemInDefaultDropdown(driver, BoxOfficeUI.DROPDOWN_VENUE, textVenue);	
	}
	
	public void clickToDropDownSelectEventName(String textEvent) {
		waitForElementClickable(driver,BoxOfficeUI.DROPDOWN_EVENT);
		selectItemInDefaultDropdown(driver, BoxOfficeUI.DROPDOWN_EVENT, textEvent);	
	}

	public boolean isOrderBoxOfficeTextDisplayed() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_ORDER_BOX_OFFICE_SCREEN);
		return isElementDisplayed(driver, BoxOfficeUI.TEXT_ORDER_BOX_OFFICE_SCREEN);
	}

	public void clickToDropDownSelectVenue() {
		waitForElementClickable(driver,BoxOfficeUI.DROPDOWN_VENUE);
		clickToElement(driver, BoxOfficeUI.DROPDOWN_VENUE);	
	}
	
	public void clickToDropDownSelectEvent() {
		waitForElementClickable(driver,BoxOfficeUI.DROPDOWN_EVENT);
		clickToElement(driver, BoxOfficeUI.DROPDOWN_EVENT);	
	}

	public void clickToValueOfDropdownSelectVenue() {
		waitForElementClickable(driver,BoxOfficeUI.VALUE_DROPDOWN_VENUE);
		clickToElement(driver, BoxOfficeUI.VALUE_DROPDOWN_VENUE);	
	}

	public void clickToValueOfDropdownSelectEvent() {
		waitForElementClickable(driver,BoxOfficeUI.VALUE_DROPDOWN_EVENT);
		clickToElement(driver, BoxOfficeUI.VALUE_DROPDOWN_EVENT);	
	}

	//CHECKOUT
	public void clickButtonCheckoutNow() {
		waitForElementClickable(driver,BoxOfficeUI.BUTTON_CHECK_OUT_NOW);
		clickToElement(driver, BoxOfficeUI.BUTTON_CHECK_OUT_NOW);	
	}
	
	public String getErrorMessageCheckoutEmptyData() {
		waitForElementVisible(driver, BoxOfficeUI.ERROR_MESSAGE_EMPTY_DATA);
		return getElementText(driver, BoxOfficeUI.ERROR_MESSAGE_EMPTY_DATA);
	}

	public void clickToDropDownSelectTicket() {
		waitForElementClickable(driver,BoxOfficeUI.DROPDOWN_TICKET);
		clickToElement(driver, BoxOfficeUI.DROPDOWN_TICKET);	
	}

	public void clickToValueOfDropdownSelectTicket() {
		waitForElementClickable(driver,BoxOfficeUI.VALUE_DROPDOWN_TICKET);
		clickToElement(driver, BoxOfficeUI.VALUE_DROPDOWN_TICKET);	
	}
	
	public void clickToValueOfDropdownSelectTicketComp() {
		waitForElementClickable(driver,BoxOfficeUI.VALUE_DROPDOWN_TICKET_COMP);
		clickToElement(driver, BoxOfficeUI.VALUE_DROPDOWN_TICKET_COMP);	
	}

	public void clickRadioButtonPayByCash() {
		waitForElementClickable(driver,BoxOfficeUI.RADIO_BUTTON_PAY_BY_CASH);
		clickToElement(driver, BoxOfficeUI.RADIO_BUTTON_PAY_BY_CASH);	
	}
	
	public void clickRadioButtonPayByComp() {
		waitForElementClickable(driver,BoxOfficeUI.RADIO_BUTTON_PAY_BY_COMP);
		clickToElement(driver, BoxOfficeUI.RADIO_BUTTON_PAY_BY_COMP);	
	}
	
	public void clickRadioButtonPayByCardSwiper() {
		waitForElementClickable(driver,BoxOfficeUI.RADIO_BUTTON_PAY_BY_CARD_SWIPER);
		clickToElement(driver, BoxOfficeUI.RADIO_BUTTON_PAY_BY_CARD_SWIPER);	
	}
	
	public void clickRadioButtonPayByCardManually() {
		waitForElementClickable(driver,BoxOfficeUI.RADIO_BUTTON_PAY_BY_CARD_MANUALLY);
		clickToElement(driver, BoxOfficeUI.RADIO_BUTTON_PAY_BY_CARD_MANUALLY);	
	}
	
	public void clickRadioButtonPayByPayLater() {
		waitForElementClickable(driver,BoxOfficeUI.RADIO_BUTTON_PAY_BY_PAY_LATER);
		clickToElement(driver, BoxOfficeUI.RADIO_BUTTON_PAY_BY_PAY_LATER);	
	}

	public void clickButtonPlaceOrder() {
		waitForElementClickable(driver,BoxOfficeUI.BUTTON_PLACE_ORDER);
		clickToElement(driver, BoxOfficeUI.BUTTON_PLACE_ORDER);	
	}

	public boolean isSuccessOrderTextDisplayed() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_SUCCESS_ORDER);
		return isElementDisplayed(driver, BoxOfficeUI.TEXT_SUCCESS_ORDER);
	}
	
	//ORDER SUCCESS

	public void clickViewOrderButton() {
		waitForElementClickable(driver,BoxOfficeUI.BUTTON_VIEW_ORDER);
		clickToElement(driver, BoxOfficeUI.BUTTON_VIEW_ORDER);	
	}

	public boolean isPageViewOrderDisplayed() {
		waitForElementVisible(driver, BoxOfficeUI.BLADE_VIEW_ORDER_PAGE);
		return isElementDisplayed(driver, BoxOfficeUI.BLADE_VIEW_ORDER_PAGE);
	}
	
	public void clickToValueOfDropdownSelectPrinterDefault() {
		waitForElementClickable(driver,BoxOfficeUI.VALUE_OF_DROPDOWN_PRINTER_DEFAULT);
		clickToElement(driver, BoxOfficeUI.VALUE_OF_DROPDOWN_PRINTER_DEFAULT);	
	}

	public void clickPrintOrderButton() {
		waitForElementClickable(driver,BoxOfficeUI.BUTTON_PRINT_ORDER);
		clickToElement(driver, BoxOfficeUI.BUTTON_PRINT_ORDER);	
	}

	public String getTextOfAlertBoxOffice() {
		waitForAlertPresence(driver);
		return getAlertText(driver);
	}

	public void clickBackToBoxOfficeButton() {
		waitForElementClickable(driver,BoxOfficeUI.BUTTON_BACK_TO_BOX_OFFICE_FROM_ORDER_SUCCESS);
		clickToElement(driver, BoxOfficeUI.BUTTON_BACK_TO_BOX_OFFICE_FROM_ORDER_SUCCESS);	
	}

	public void clickButtonAuthorizeTestPayment() {
		waitForElementClickable(driver,BoxOfficeUI.BUTTON_AUTHORIZE_TEST_PAYMENT);
		clickToElement(driver, BoxOfficeUI.BUTTON_AUTHORIZE_TEST_PAYMENT);	
	}

	public void clickButtonFailTestPayment() {
		waitForElementClickable(driver,BoxOfficeUI.BUTTON_FAIL_TEST_PAYMENT);
		clickToElement(driver, BoxOfficeUI.BUTTON_FAIL_TEST_PAYMENT);	
	}



	


	
}