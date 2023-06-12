package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import io.qameta.allure.Step;
import pageUIs.user.BoxOfficeUI;
import pageUIs.user.LoginPageUI;
import pageUIs.user.PublicKioskUI;

public class UserBoxOfficePageObject extends BasePage{

	private WebDriver driver;
	
	public UserBoxOfficePageObject(WebDriver driver) {
		this.driver = driver;
	}

	//LOGIN
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
		waitForElementClickable(driver,BoxOfficeUI.LOGIN_BUTTON);
		clickToElement(driver, BoxOfficeUI.LOGIN_BUTTON);	
	}
	

	//BOX OFFICE
	@Step("Verify text - Box Office")
	public boolean isBoxOfficeTextDisplayed() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_BOX_OFFICE_SCREEN);
		return isElementDisplayed(driver, BoxOfficeUI.TEXT_BOX_OFFICE_SCREEN);
	}
		///MORE MENU
	@Step("Click to button - More Menu")
	public void clickToMoreMenuButton() {
		waitForElementClickable(driver,BoxOfficeUI.MORE_MENU_BUTTON);
		clickToElement(driver, BoxOfficeUI.MORE_MENU_BUTTON);	
	}
	
	@Step("Click to value of More Menu - {0}")
	public void clickToValueOfMoreMennu(String value) {
		waitForElementClickable(driver,BoxOfficeUI.VALUES_MORE_BUTTON, value);
		clickToElement(driver, BoxOfficeUI.VALUES_MORE_BUTTON, value);	
	}
	
	@Step("Alert - accept alert")
	public void acceptAlert() {
		acceptAlert(driver);
	}
	
	@Step("Alert - cancel alert")
	public void cancelAlert() {
		cancelAlert(driver);
	}

	@Step("Verify text - Instruction Youtube")
	public boolean isTitleInstructionYoutubeDisplayed() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_TITLE_INSTRUCTION_YOUTUBE);
		return isElementDisplayed(driver, BoxOfficeUI.TEXT_TITLE_INSTRUCTION_YOUTUBE);
	}


	@Step("Verify text - Login button")
	public boolean isLoginButtonDisplayed() {
		waitForElementVisible(driver, BoxOfficeUI.LOGIN_BUTTON_HOMEPAGE);
		return isElementDisplayed(driver, BoxOfficeUI.LOGIN_BUTTON_HOMEPAGE);
	}

	@Step("Switch to tab {0}")
	public void switchToWindowByID(String windowID) {
		switchToWindowByID(driver, windowID);	
	}
	
	@Step("Switch to tab by title {0}")
	public void switchToWindowByTitle(String windowID) {
		switchToWindowByTitle(driver, windowID);	
	}
	
	@Step("Verify text - Register Reader")
	public boolean isTitleRegisteredReadersDisplayed() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_REGISTERED_READERS);
		return isElementDisplayed(driver, BoxOfficeUI.TEXT_REGISTERED_READERS);
	}

	@Step("Verify text - Box Office Information")
	public boolean isTitleBoxOfficeInformationDisplayed() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_BOX_OFFICE_INFORMATION);
		return isElementDisplayed(driver, BoxOfficeUI.TEXT_BOX_OFFICE_INFORMATION);
	}

		///INFORMATION BOX OFFICE
	@Step("Click to dropdown Select Printer")
	public void clickToDropDownSelectPrinter() {
		waitForElementClickable(driver,BoxOfficeUI.DROPDOWN_PRINTER);
		clickToElement(driver, BoxOfficeUI.DROPDOWN_PRINTER);	
	}

	@Step("Click to value of dropdown select printer {0}")
	public void clickToValueOfDropdownSelectPrinter(String namePrinter) {
		waitForElementClickable(driver,BoxOfficeUI.VALUE_OF_DROPDOWN_PRINTER, namePrinter);
		clickToElement(driver, BoxOfficeUI.VALUE_OF_DROPDOWN_PRINTER, namePrinter);	
	}
	
	@Step("Verify text -  value of dropdown Select Paper")
	public boolean isTextSelectdefaultPaperDisplayed() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_SELECT_DEFAULT_PAPER);
		return isElementDisplayed(driver, BoxOfficeUI.TEXT_SELECT_DEFAULT_PAPER);
	}
	
	@Step("Click to dropdown Select Paper")
	public void clickToDropDownSelectPaper() {
		waitForElementClickable(driver,BoxOfficeUI.DROPDOWN_PAPER);
		clickToElement(driver, BoxOfficeUI.DROPDOWN_PAPER);	
	}

	@Step("Click to value of dropdown select paper  {0}")
	public void clickToValueOfDropdownSelectPaper(String namePaper) {
		waitForElementClickable(driver,BoxOfficeUI.VALUE_OF_DROPDOWN_PAPER, namePaper);
		clickToElement(driver, BoxOfficeUI.VALUE_OF_DROPDOWN_PAPER, namePaper);	
	}


	@Step("Verify text - value selected of dropdown select paper")
	public boolean isSelectedPaperValueDisplayed() {
		waitForElementVisible(driver, BoxOfficeUI.VALUE_SELECTED_OF_DROPDOWN_PAPER);
		return isElementDisplayed(driver, BoxOfficeUI.VALUE_SELECTED_OF_DROPDOWN_PAPER);
	}

	@Step("Click to button - Reset")
	public void clickToButtonReset() {
		waitForElementClickable(driver,BoxOfficeUI.BUTTON_RESET_REPORT);
		clickToElement(driver, BoxOfficeUI.BUTTON_RESET_REPORT);			
	}
	
	@Step("Verify value of report {0} {1}")
	public String getValueReport(String paymentType, String value) {
		waitForElementVisible(driver, BoxOfficeUI.VALUE_TIX_SOLD, paymentType, value);
		return getElementText(driver, BoxOfficeUI.VALUE_TIX_SOLD, paymentType, value);
	}

	@Step("Click to button Back to box office")
	public void clickToButtonBackToBoxOfficeFromInformationScreen() {
		waitForElementClickable(driver,BoxOfficeUI.BUTTON_BACK_TO_BOX_OFFICE_FROM_SCREEN_INFORMATION);
		clickToElement(driver, BoxOfficeUI.BUTTON_BACK_TO_BOX_OFFICE_FROM_SCREEN_INFORMATION);			
	}

	@Step("Alert - accept alert")
	public void acceptAlertReport() {
		acceptAlert(driver);
	}
	
	@Step("Alert - cancel alert")
	public void cancelAlertReport() {
		cancelAlert(driver);
	}
	
	//DROPDOWN - BOX OFFICE 
	@Step("Verify text - Order")
	public boolean isOrderBoxOfficeTextDisplayed() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_ORDER_BOX_OFFICE_SCREEN);
		return isElementDisplayed(driver, BoxOfficeUI.TEXT_ORDER_BOX_OFFICE_SCREEN);
	}

	@Step("Click to dropdown - Select Venue")
	public void clickToDropDownSelectVenue() {
		waitForElementClickable(driver,BoxOfficeUI.DROPDOWN_VENUE);
		clickToElement(driver, BoxOfficeUI.DROPDOWN_VENUE);	
	}
	
	@Step("Click to dropdown - Select Event")
	public void clickToDropDownSelectEvent() {
		waitForElementClickable(driver,BoxOfficeUI.DROPDOWN_EVENT);
		clickToElement(driver, BoxOfficeUI.DROPDOWN_EVENT);	
	}

	@Step("Click to value of dropdown - Select Venue")
	public void clickToValueOfDropdownSelectVenue(String venueName) {
		waitForElementClickable(driver,BoxOfficeUI.VALUE_DROPDOWN_VENUE, venueName);
		clickToElement(driver, BoxOfficeUI.VALUE_DROPDOWN_VENUE, venueName);	
	}

	@Step("Click to value of dropdown - Select Event")
	public void clickToValueOfDropdownSelectEvent(String eventName) {
		waitForElementClickable(driver,BoxOfficeUI.VALUE_DROPDOWN_EVENT, eventName);
		clickToElement(driver, BoxOfficeUI.VALUE_DROPDOWN_EVENT, eventName);	
	}

	//CHECKOUT
	
	@Step("Choose Confirmation Delivery")
	public void clickCheckboxConfirmationDelivery(String typeConfirm) {
		waitForElementClickable(driver,BoxOfficeUI.CHECKBOX_CONFIRMATION_DELIVERY,typeConfirm );
		clickToElement(driver, BoxOfficeUI.CHECKBOX_CONFIRMATION_DELIVERY, typeConfirm);	
	}
	
	@Step("Click to button - Checkout Now")
	public void clickButtonCheckout(String buttonName) {
		waitForElementClickable(driver,BoxOfficeUI.BUTTON_CHECK_OUT_OR_ADD_CART, buttonName);
		clickToElement(driver, BoxOfficeUI.BUTTON_CHECK_OUT_OR_ADD_CART, buttonName);	
	}
	
	@Step("Verify error message - when checkout empty data")
	public String getErrorMessageCheckoutEmptyData() {
		waitForElementVisible(driver, BoxOfficeUI.ERROR_MESSAGE_EMPTY_DATA);
		return getElementText(driver, BoxOfficeUI.ERROR_MESSAGE_EMPTY_DATA);
	}
	
	@Step("Click to dropdown select quantity ticket {0} {1}")
	public void clickToDropDownSelectQuantityTicket(String nameOfTicket,String textItem) {
		waitForElementClickable(driver,BoxOfficeUI.DROPDOWN_QUANTITY_TICKET, nameOfTicket);
		selectItemInDefaultDropdown(driver, BoxOfficeUI.DROPDOWN_QUANTITY_TICKET, textItem, nameOfTicket);	
	}

	@Step("Get text - Total Amount of Order")
	public String getTextTotalAmountOrder() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_TOTAL_AMOUNT_ORDER_BOX_OFFICE);
		return getElementText(driver, BoxOfficeUI.TEXT_TOTAL_AMOUNT_ORDER_BOX_OFFICE);
	}
	
	@Step("Click to radio button - Payment Checkout - {0}")
	public void clickToRadioButtonPaymentCheckout(String paymentType) {
		waitForElementClickable(driver,BoxOfficeUI.RADIO_BUTTON_PAYMENT_CHECKOUT, paymentType);
		clickToElement(driver, BoxOfficeUI.RADIO_BUTTON_PAYMENT_CHECKOUT, paymentType);	
	}

	@Step("Click to button - Place Order")
	public void clickButtonPlaceOrder() {
		waitForElementClickable(driver,BoxOfficeUI.BUTTON_PLACE_ORDER);
		clickToElement(driver, BoxOfficeUI.BUTTON_PLACE_ORDER);	
	}

	@Step("Verify text - Order Success")
	public boolean isSuccessOrderTextDisplayed() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_SUCCESS_ORDER);
		return isElementDisplayed(driver, BoxOfficeUI.TEXT_SUCCESS_ORDER);
	}
	
	//ORDER SUCCESS
	@Step("Click to button - View Order")
	public void clickViewOrderButton() {
		waitForElementClickable(driver,BoxOfficeUI.BUTTON_VIEW_ORDER);
		clickToElement(driver, BoxOfficeUI.BUTTON_VIEW_ORDER);	
	}

	@Step("Verify display - Page View Order")
	public boolean isPageViewOrderDisplayed() {
		waitForElementVisible(driver, BoxOfficeUI.BLADE_VIEW_ORDER_PAGE);
		return isElementDisplayed(driver, BoxOfficeUI.BLADE_VIEW_ORDER_PAGE);
	}

	@Step("Click to button - Print Order")
	public void clickPrintOrderButton() {
		waitForElementClickable(driver,BoxOfficeUI.BUTTON_PRINT_ORDER);
		clickToElement(driver, BoxOfficeUI.BUTTON_PRINT_ORDER);	
	}

	@Step("Verify text - Alert Box Office")
	public String getTextOfAlertBoxOffice() {
		waitForAlertPresence(driver);
		return getAlertText(driver);
	}

	@Step("Click to button - Back to box office")
	public void clickBackToBoxOfficeButton() {
		waitForElementClickable(driver,BoxOfficeUI.BUTTON_BACK_TO_BOX_OFFICE_FROM_ORDER_SUCCESS);
		clickToElement(driver, BoxOfficeUI.BUTTON_BACK_TO_BOX_OFFICE_FROM_ORDER_SUCCESS);	
	}

	@Step("Click to button - Authorize Test Payment")
	public void clickButtonAuthorizeTestPayment() {
		waitForElementClickable(driver,BoxOfficeUI.BUTTON_AUTHORIZE_TEST_PAYMENT);
		clickToElement(driver, BoxOfficeUI.BUTTON_AUTHORIZE_TEST_PAYMENT);	
	}

	@Step("Click to button - Fail Test Payment")
	public void clickButtonFailTestPayment() {
		waitForElementClickable(driver,BoxOfficeUI.BUTTON_FAIL_TEST_PAYMENT);
		clickToElement(driver, BoxOfficeUI.BUTTON_FAIL_TEST_PAYMENT);	
	}

	@Step("Click to button - Charge Card")
	public void clickButtonChargeCard() {
		waitForElementClickable(driver,BoxOfficeUI.BUTTON_CHARGE_CARD);
		clickToElement(driver, BoxOfficeUI.BUTTON_CHARGE_CARD);	
	}

	@Step("Verify text - Tap or insert")
	public boolean isTapOrInsertTextDisplayed() {
		waitForElementVisible(driver, BoxOfficeUI.TAP_OR_INSERT_TEXT);
		return isElementDisplayed(driver, BoxOfficeUI.TAP_OR_INSERT_TEXT);
	}

	@Step("Click to button -Cancel Charge Card")
	public void clickButtonCancelChargeCard() {
		waitForElementClickable(driver,BoxOfficeUI.BUTTON_CANCEL_CHARGE_CARD);
		clickToElement(driver, BoxOfficeUI.BUTTON_CANCEL_CHARGE_CARD);	
	}

	@Step("Input info of card manual - {0} {1}")
	public void inputInfoCardManual(String field, String value) {
		waitForElementVisible(driver, BoxOfficeUI.CARD_INFO_TEXTBOX, field);
		sendkeyToElement(driver, BoxOfficeUI.CARD_INFO_TEXTBOX, value, field);
	}
	
	@Step("Verify Error message chargae card")
	public String getErrorMessageChargeCard() {
		waitForElementVisible(driver, BoxOfficeUI.ERROR_MESSAGE_CHARGE_CARD);
		return getElementText(driver, BoxOfficeUI.ERROR_MESSAGE_CHARGE_CARD);
	}

	@Step("Verify name of reader")
	public String getTextNameOfReader() {
		waitForElementVisible(driver, BoxOfficeUI.NAME_OF_READER);
		return getElementText(driver, BoxOfficeUI.NAME_OF_READER);
	}

	@Step("Click to Card Number")
	public void clickToCardNumberTextbox() {
		waitForElementClickable(driver,BoxOfficeUI.CARD_INFO_TEXTBOX);
		clickToElement(driver, BoxOfficeUI.CARD_INFO_TEXTBOX);	
	}

	@Step("Verify text Card Info")
	public boolean isCardInfoTextDisplayed() {
		waitForElementVisible(driver, BoxOfficeUI.CARD_INFO_TEXT);
		return isElementDisplayed(driver, BoxOfficeUI.CARD_INFO_TEXT);
	}

	@Step("Switch to frame/iframe")
	public void switchToFrameIframe() {
		switchToFrameIframe(driver, BoxOfficeUI.IFRAME_CARD_MANUALLY);
	}

	@Step("switch to default content")
	public void switchToDefaultContent() {
		switchToDefaultContent(driver, BoxOfficeUI.IFRAME_CARD_MANUALLY);
	}
	
	@Step("Click to button - Back to tickets")
	public void clickBackToTickets() {
		waitForElementClickable(driver,BoxOfficeUI.BUTTON_BACK_TO_TICKET);
		clickToElement(driver, BoxOfficeUI.BUTTON_BACK_TO_TICKET);	
	}

	@Step("Verify text - error message of footer box office")
	public String getErrorMessageFooterBoxOffice() {
		waitForElementVisible(driver, BoxOfficeUI.ERROR_MESSAGE_FOOTER_BOX_OFFICE);
		return getElementText(driver, BoxOfficeUI.ERROR_MESSAGE_FOOTER_BOX_OFFICE);
	}
	
	@Step("Alert Authen")
	public void authenAlert() {
		driver.get(UsernameandPassword(GlobalConstants.BOX_OFFICE_PAGE_URL, "SS15243", "12345"));
	}

	public String UsernameandPassword (String url, String username, String password){
		String [] arrayurl = url.split("//");
		return arrayurl[0] + "//" + username +":"+ password + "@" + arrayurl[1];
	}

	



	


	


	
}