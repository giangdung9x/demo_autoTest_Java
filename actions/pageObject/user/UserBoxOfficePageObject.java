package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import io.qameta.allure.Step;
import pageUIs.user.BoxOfficePageUI;
import pageUIs.user.LoginPageUI;
import pageUIs.user.PublicKioskPageUI;

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
		waitForElementClickable(driver,BoxOfficePageUI.LOGIN_BUTTON);
		clickToElement(driver, BoxOfficePageUI.LOGIN_BUTTON);	
	}
	

	//BOX OFFICE
	@Step("Verify text - Box Office")
	public boolean isBoxOfficeTextDisplayed() {
		waitForElementVisible(driver, BoxOfficePageUI.TEXT_BOX_OFFICE_SCREEN);
		return isElementDisplayed(driver, BoxOfficePageUI.TEXT_BOX_OFFICE_SCREEN);
	}
		///MORE MENU
	@Step("Click to button - More Menu")
	public void clickToMoreMenuButton() {
		waitForElementClickable(driver,BoxOfficePageUI.MORE_MENU_BUTTON);
		clickToElement(driver, BoxOfficePageUI.MORE_MENU_BUTTON);	
	}
	
	@Step("Click to value of More Menu - {0}")
	public void clickToValueOfMoreMennu(String value) {
		waitForElementClickable(driver,BoxOfficePageUI.VALUES_MORE_BUTTON, value);
		clickToElement(driver, BoxOfficePageUI.VALUES_MORE_BUTTON, value);	
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
		waitForElementVisible(driver, BoxOfficePageUI.TEXT_TITLE_INSTRUCTION_YOUTUBE);
		return isElementDisplayed(driver, BoxOfficePageUI.TEXT_TITLE_INSTRUCTION_YOUTUBE);
	}


	@Step("Verify text - Login button")
	public boolean isLoginButtonDisplayed() {
		waitForElementVisible(driver, BoxOfficePageUI.LOGIN_BUTTON_HOMEPAGE);
		return isElementDisplayed(driver, BoxOfficePageUI.LOGIN_BUTTON_HOMEPAGE);
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
		waitForElementVisible(driver, BoxOfficePageUI.TEXT_REGISTERED_READERS);
		return isElementDisplayed(driver, BoxOfficePageUI.TEXT_REGISTERED_READERS);
	}

	@Step("Verify text - Box Office Information")
	public boolean isTitleBoxOfficeInformationDisplayed() {
		waitForElementVisible(driver, BoxOfficePageUI.TEXT_BOX_OFFICE_INFORMATION);
		return isElementDisplayed(driver, BoxOfficePageUI.TEXT_BOX_OFFICE_INFORMATION);
	}

		///INFORMATION BOX OFFICE
	@Step("Click to dropdown Select Printer")
	public void clickToDropDownSelectPrinter() {
		waitForElementClickable(driver,BoxOfficePageUI.DROPDOWN_PRINTER);
		clickToElement(driver, BoxOfficePageUI.DROPDOWN_PRINTER);	
	}

	@Step("Click to value of dropdown select printer {0}")
	public void clickToValueOfDropdownSelectPrinter(String namePrinter) {
		waitForElementClickable(driver,BoxOfficePageUI.VALUE_OF_DROPDOWN_PRINTER, namePrinter);
		clickToElement(driver, BoxOfficePageUI.VALUE_OF_DROPDOWN_PRINTER, namePrinter);	
	}
	
	@Step("Verify text -  value of dropdown Select Paper")
	public boolean isTextSelectdefaultPaperDisplayed() {
		waitForElementVisible(driver, BoxOfficePageUI.TEXT_SELECT_DEFAULT_PAPER);
		return isElementDisplayed(driver, BoxOfficePageUI.TEXT_SELECT_DEFAULT_PAPER);
	}
	
	@Step("Click to dropdown Select Paper")
	public void clickToDropDownSelectPaper() {
		waitForElementClickable(driver,BoxOfficePageUI.DROPDOWN_PAPER);
		clickToElement(driver, BoxOfficePageUI.DROPDOWN_PAPER);	
	}

	@Step("Click to value of dropdown select paper  {0}")
	public void clickToValueOfDropdownSelectPaper(String namePaper) {
		waitForElementClickable(driver,BoxOfficePageUI.VALUE_OF_DROPDOWN_PAPER, namePaper);
		clickToElement(driver, BoxOfficePageUI.VALUE_OF_DROPDOWN_PAPER, namePaper);	
	}


	@Step("Verify text - value selected of dropdown select paper")
	public boolean isSelectedPaperValueDisplayed() {
		waitForElementVisible(driver, BoxOfficePageUI.VALUE_SELECTED_OF_DROPDOWN_PAPER);
		return isElementDisplayed(driver, BoxOfficePageUI.VALUE_SELECTED_OF_DROPDOWN_PAPER);
	}

	@Step("Click to button - Reset")
	public void clickToButtonReset() {
		waitForElementClickable(driver,BoxOfficePageUI.BUTTON_RESET_REPORT);
		clickToElement(driver, BoxOfficePageUI.BUTTON_RESET_REPORT);			
	}
	
	@Step("Verify value of report {0} {1}")
	public String getValueReport(String paymentType, String value) {
		waitForElementVisible(driver, BoxOfficePageUI.VALUE_TIX_SOLD, paymentType, value);
		return getElementText(driver, BoxOfficePageUI.VALUE_TIX_SOLD, paymentType, value);
	}

	@Step("Click to button Back to box office")
	public void clickToButtonBackToBoxOfficeFromInformationScreen() {
		waitForElementClickable(driver,BoxOfficePageUI.BUTTON_BACK_TO_BOX_OFFICE_FROM_SCREEN_INFORMATION);
		clickToElement(driver, BoxOfficePageUI.BUTTON_BACK_TO_BOX_OFFICE_FROM_SCREEN_INFORMATION);			
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
		waitForElementVisible(driver, BoxOfficePageUI.TEXT_ORDER_BOX_OFFICE_SCREEN);
		return isElementDisplayed(driver, BoxOfficePageUI.TEXT_ORDER_BOX_OFFICE_SCREEN);
	}

	@Step("Click to dropdown - Select Venue")
	public void clickToDropDownSelectVenue() {
		waitForElementClickable(driver,BoxOfficePageUI.DROPDOWN_VENUE);
		clickToElement(driver, BoxOfficePageUI.DROPDOWN_VENUE);	
	}
	
	@Step("Click to dropdown - Select Event")
	public void clickToDropDownSelectEvent() {
		waitForElementClickable(driver,BoxOfficePageUI.DROPDOWN_EVENT);
		clickToElement(driver, BoxOfficePageUI.DROPDOWN_EVENT);	
	}

	@Step("Click to value of dropdown - Select Venue")
	public void clickToValueOfDropdownSelectVenue(String venueName) {
		waitForElementClickable(driver,BoxOfficePageUI.VALUE_DROPDOWN_VENUE, venueName);
		clickToElement(driver, BoxOfficePageUI.VALUE_DROPDOWN_VENUE, venueName);	
	}

	@Step("Click to value of dropdown - Select Event")
	public void clickToValueOfDropdownSelectEvent(String eventName) {
		waitForElementClickable(driver,BoxOfficePageUI.VALUE_DROPDOWN_EVENT, eventName);
		clickToElement(driver, BoxOfficePageUI.VALUE_DROPDOWN_EVENT, eventName);	
	}

	//CHECKOUT
	
	@Step("Choose Confirmation Delivery")
	public void clickCheckboxConfirmationDelivery(String typeConfirm) {
		waitForElementClickable(driver,BoxOfficePageUI.CHECKBOX_CONFIRMATION_DELIVERY,typeConfirm );
		clickToElement(driver, BoxOfficePageUI.CHECKBOX_CONFIRMATION_DELIVERY, typeConfirm);	
	}
	
	@Step("Click to button - Checkout Now")
	public void clickButtonCheckout(String buttonName) {
		waitForElementClickable(driver,BoxOfficePageUI.BUTTON_CHECK_OUT_OR_ADD_CART, buttonName);
		clickToElement(driver, BoxOfficePageUI.BUTTON_CHECK_OUT_OR_ADD_CART, buttonName);	
	}
	
	@Step("Verify error message - when checkout empty data")
	public String getErrorMessageCheckoutEmptyData() {
		waitForElementVisible(driver, BoxOfficePageUI.ERROR_MESSAGE_EMPTY_DATA);
		return getElementText(driver, BoxOfficePageUI.ERROR_MESSAGE_EMPTY_DATA);
	}
	
	@Step("Click to dropdown select quantity ticket {0} {1}")
	public void clickToDropDownSelectQuantityTicket(String nameOfTicket,String textItem) {
		waitForElementClickable(driver,BoxOfficePageUI.DROPDOWN_QUANTITY_TICKET, nameOfTicket);
		selectItemInDefaultDropdown(driver, BoxOfficePageUI.DROPDOWN_QUANTITY_TICKET, textItem, nameOfTicket);	
	}

	@Step("Get text - Total Amount of Order")
	public String getTextTotalAmountOrder() {
		waitForElementVisible(driver, BoxOfficePageUI.TEXT_TOTAL_AMOUNT_ORDER_BOX_OFFICE);
		return getElementText(driver, BoxOfficePageUI.TEXT_TOTAL_AMOUNT_ORDER_BOX_OFFICE);
	}
	
	@Step("Click to radio button - Payment Checkout - {0}")
	public void clickToRadioButtonPaymentCheckout(String paymentType) {
		waitForElementClickable(driver,BoxOfficePageUI.RADIO_BUTTON_PAYMENT_CHECKOUT, paymentType);
		clickToElement(driver, BoxOfficePageUI.RADIO_BUTTON_PAYMENT_CHECKOUT, paymentType);	
	}

	@Step("Click to button - Place Order")
	public void clickButtonPlaceOrder() {
		waitForElementClickable(driver,BoxOfficePageUI.BUTTON_PLACE_ORDER);
		clickToElement(driver, BoxOfficePageUI.BUTTON_PLACE_ORDER);	
	}

	@Step("Verify text - Order Success")
	public boolean isSuccessOrderTextDisplayed() {
		waitForElementVisible(driver, BoxOfficePageUI.TEXT_SUCCESS_ORDER);
		return isElementDisplayed(driver, BoxOfficePageUI.TEXT_SUCCESS_ORDER);
	}
	
	//ORDER SUCCESS
	@Step("Click to button - View Order")
	public void clickViewOrderButton() {
		waitForElementClickable(driver,BoxOfficePageUI.BUTTON_VIEW_ORDER);
		clickToElement(driver, BoxOfficePageUI.BUTTON_VIEW_ORDER);	
	}

	@Step("Verify display - Page View Order")
	public boolean isPageViewOrderDisplayed() {
		waitForElementVisible(driver, BoxOfficePageUI.BLADE_VIEW_ORDER_PAGE);
		return isElementDisplayed(driver, BoxOfficePageUI.BLADE_VIEW_ORDER_PAGE);
	}

	@Step("Click to button - Print Order")
	public void clickPrintOrderButton() {
		waitForElementClickable(driver,BoxOfficePageUI.BUTTON_PRINT_ORDER);
		clickToElement(driver, BoxOfficePageUI.BUTTON_PRINT_ORDER);	
	}

	@Step("Verify text - Alert Box Office")
	public String getTextOfAlertBoxOffice() {
		waitForAlertPresence(driver);
		return getAlertText(driver);
	}

	@Step("Click to button - Back to box office")
	public void clickBackToBoxOfficeButton() {
		waitForElementClickable(driver,BoxOfficePageUI.BUTTON_BACK_TO_BOX_OFFICE_FROM_ORDER_SUCCESS);
		clickToElement(driver, BoxOfficePageUI.BUTTON_BACK_TO_BOX_OFFICE_FROM_ORDER_SUCCESS);	
	}

	@Step("Click to button - Authorize Test Payment")
	public void clickButtonAuthorizeTestPayment() {
		waitForElementClickable(driver,BoxOfficePageUI.BUTTON_AUTHORIZE_TEST_PAYMENT);
		clickToElement(driver, BoxOfficePageUI.BUTTON_AUTHORIZE_TEST_PAYMENT);	
	}

	@Step("Click to button - Fail Test Payment")
	public void clickButtonFailTestPayment() {
		waitForElementClickable(driver,BoxOfficePageUI.BUTTON_FAIL_TEST_PAYMENT);
		clickToElement(driver, BoxOfficePageUI.BUTTON_FAIL_TEST_PAYMENT);	
	}

	@Step("Click to button - Charge Card")
	public void clickButtonChargeCard() {
		waitForElementClickable(driver,BoxOfficePageUI.BUTTON_CHARGE_CARD);
		clickToElement(driver, BoxOfficePageUI.BUTTON_CHARGE_CARD);	
	}

	@Step("Verify text - Tap or insert")
	public boolean isTapOrInsertTextDisplayed() {
		waitForElementVisible(driver, BoxOfficePageUI.TAP_OR_INSERT_TEXT);
		return isElementDisplayed(driver, BoxOfficePageUI.TAP_OR_INSERT_TEXT);
	}

	@Step("Click to button -Cancel Charge Card")
	public void clickButtonCancelChargeCard() {
		waitForElementClickable(driver,BoxOfficePageUI.BUTTON_CANCEL_CHARGE_CARD);
		clickToElement(driver, BoxOfficePageUI.BUTTON_CANCEL_CHARGE_CARD);	
	}

	@Step("Input info of card manual - {0} {1}")
	public void inputInfoCardManual(String field, String value) {
		waitForElementVisible(driver, BoxOfficePageUI.CARD_INFO_TEXTBOX, field);
		sendkeyToElement(driver, BoxOfficePageUI.CARD_INFO_TEXTBOX, value, field);
	}
	
	@Step("Verify Error message chargae card")
	public String getErrorMessageChargeCard() {
		waitForElementVisible(driver, BoxOfficePageUI.ERROR_MESSAGE_CHARGE_CARD);
		return getElementText(driver, BoxOfficePageUI.ERROR_MESSAGE_CHARGE_CARD);
	}

	@Step("Verify name of reader")
	public String getTextNameOfReader() {
		waitForElementVisible(driver, BoxOfficePageUI.NAME_OF_READER);
		return getElementText(driver, BoxOfficePageUI.NAME_OF_READER);
	}

	@Step("Click to Card Number")
	public void clickToCardNumberTextbox() {
		waitForElementClickable(driver,BoxOfficePageUI.CARD_INFO_TEXTBOX);
		clickToElement(driver, BoxOfficePageUI.CARD_INFO_TEXTBOX);	
	}

	@Step("Verify text Card Info")
	public boolean isCardInfoTextDisplayed() {
		waitForElementVisible(driver, BoxOfficePageUI.CARD_INFO_TEXT);
		return isElementDisplayed(driver, BoxOfficePageUI.CARD_INFO_TEXT);
	}

	@Step("Switch to frame/iframe")
	public void switchToFrameIframe() {
		switchToFrameIframe(driver, BoxOfficePageUI.IFRAME_CARD_MANUALLY);
	}

	@Step("switch to default content")
	public void switchToDefaultContent() {
		switchToDefaultContent(driver, BoxOfficePageUI.IFRAME_CARD_MANUALLY);
	}
	
	@Step("Click to button - Back to tickets")
	public void clickBackToTickets() {
		waitForElementClickable(driver,BoxOfficePageUI.BUTTON_BACK_TO_TICKET);
		clickToElement(driver, BoxOfficePageUI.BUTTON_BACK_TO_TICKET);	
	}

	@Step("Verify text - error message of footer box office")
	public String getErrorMessageFooterBoxOffice() {
		waitForElementVisible(driver, BoxOfficePageUI.ERROR_MESSAGE_FOOTER_BOX_OFFICE);
		return getElementText(driver, BoxOfficePageUI.ERROR_MESSAGE_FOOTER_BOX_OFFICE);
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