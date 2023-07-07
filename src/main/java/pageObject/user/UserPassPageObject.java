package pageObject.user;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.apache.hc.core5.http2.frame.StreamIdGenerator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.user.ActionOfEventPageUI;
import pageUIs.user.BoxOfficePageUI;
import pageUIs.user.BuyOnlinePageUI;
import pageUIs.user.PassPageUI;
import pageUIs.user.HomePageUI;
import org.openqa.selenium.interactions.Actions;


public class UserPassPageObject extends BasePage{

	private WebDriver driver;

	public UserPassPageObject(WebDriver driver) {
		this.driver = driver;
	}

	
	@Step("Click to button Login")
	public void clickToLoginLink() {
		waitForElementClickable(driver,PassPageUI.LOGIN_LINK);
		clickToElement(driver, PassPageUI.LOGIN_LINK);		
	}

	@Step("Input to Textbox Login {0} {1}")
	public void inputToTextboxLogin(String field, String value) {
		waitForElementVisible(driver, PassPageUI.TEXTBOX_LOGIN, field);
		sendkeyToElement(driver, PassPageUI.TEXTBOX_LOGIN, value, field);		
	}

	@Step("Login Account {0} {1}")
	public void loginAccount(String email, String password) {
		inputToTextboxLogin("email", email);
		inputToTextboxLogin("password", password);

	}

	@Step("Click to button - Login")
	public void clickToLoginButton() {
		waitForElementClickable(driver,PassPageUI.LOGIN_BUTTON);
		clickToElement(driver, PassPageUI.LOGIN_BUTTON);	
	}

	@Step("Verify name of screen - {0}")
	public boolean isTextNameOfScreenDisplayed(String nameOfScreen) {
		waitForElementVisible(driver, PassPageUI.NAME_OF_SCREEN, nameOfScreen);
		return isElementDisplayed(driver, PassPageUI.NAME_OF_SCREEN, nameOfScreen);
	}
	
	@Step("Click open Left Menu")
	public void clickShowLeftMenu() {
		waitForElementClickable(driver,BoxOfficePageUI.LEFT_MENU_BUTTON);
		clickToElement(driver, BoxOfficePageUI.LEFT_MENU_BUTTON);	
	}

	@Step("Click to items of Left Menu - {0}")
	public void clickToItemOfLeftMenu(String items) {
		waitForElementClickable(driver,PassPageUI.ITEMS_LEFT_MENU, items);
		clickToElement(driver, PassPageUI.ITEMS_LEFT_MENU, items);	
	}
	
	@Step("Click to items of List Ticketing - {0}")
	public void clickToItemOfListTicketing(String items) {
		waitForElementClickable(driver,PassPageUI.ITEMS_OF_LIST_TICKETING, items);
		clickToElement(driver, PassPageUI.ITEMS_OF_LIST_TICKETING, items);	
	}

	@Step("Click to button - Add Coupon")
	public void clickToAddPassButton() {
		waitForElementClickable(driver,PassPageUI.ADD_PASS_BUTTON);
		clickToElement(driver, PassPageUI.ADD_PASS_BUTTON);	
	}
	
	@Step("Verify name of popup -  {0}")
	public boolean isTextNameOfPopupDisplayed(String nameOfPopup) {
		waitForElementVisible(driver, PassPageUI.NAME_OF_POPUP, nameOfPopup);
		return isElementDisplayed(driver, PassPageUI.NAME_OF_POPUP, nameOfPopup);
	}
	
	@Step("Click to button - Save Coupon")
	public void clickToSaveButton() {
		waitForElementClickable(driver,PassPageUI.SAVE_BUTTON);
		clickToElement(driver, PassPageUI.SAVE_BUTTON);	
	}

	@Step("Get Error Message Of Filed {0}")
	public String getErrorMessageOfFiled(String filed) {
		waitForElementVisible(driver, PassPageUI.ERROR_MESSAGE_FIELD, filed);
		return getElementText(driver, PassPageUI.ERROR_MESSAGE_FIELD, filed);
	}
	
	@Step("Verify text of Alert")
	public String getTextOfAlert() {
		waitForElementVisible(driver, PassPageUI.ALERT_OF_POPUP);
		return getElementText(driver, PassPageUI.ALERT_OF_POPUP);
	}
	
	@Step("Input value of textbox - Limit purchase to - {0} {1}")
	public void inputToTextboxLimitPurchasePopup(String field, String value) {
		waitForElementVisible(driver, PassPageUI.TEXTBOX_LIMIT_PURCHASE, field);
		sendkeyToElement(driver, PassPageUI.TEXTBOX_LIMIT_PURCHASE, value, field);		
	}
	
	@Step("Input value of popup coupon {0} {1}")
	public void inputToTextboxPlaceholderPopup(String field, String value) {
		waitForElementVisible(driver, PassPageUI.TEXTBOX_POPUP_PLACEHODER, field);
		sendkeyToElement(driver, PassPageUI.TEXTBOX_POPUP_PLACEHODER, value, field);		
	}
	
	@Step("Input value of popup coupon {0} {1}")
	public void inputToTextboxPlaceholderDescriptionPopup(String field, String value) {
		waitForElementVisible(driver, PassPageUI.TEXTBOX_DESCRIPTION, field);
		sendkeyToElement(driver, PassPageUI.TEXTBOX_DESCRIPTION, value, field);		
	}
	
	
	@Step("Input value of popup coupon {0} {1}")
	public void inputToTextboxNamePopup(String field, String value) {
		waitForElementVisible(driver, PassPageUI.TEXTBOX_POPUP_FIELD, field);
		sendkeyToElement(driver, PassPageUI.TEXTBOX_POPUP_FIELD, value, field);		
	}
	
	@Step("Input value of field Price of Popup")
	public void inputToTextboxPrice(String value) {
		waitForElementVisible(driver, PassPageUI.TEXTBOX_PRICE);
		sendkeyToElement(driver, PassPageUI.TEXTBOX_PRICE, value);		
	}
	
	
	//Dropdown of popup
	public void clickToDropDownOfPopup(String field) {
		waitForElementClickable(driver,PassPageUI.DROPDOWN_VALUE_PARENT, field);
		clickToElement(driver, PassPageUI.DROPDOWN_VALUE_PARENT, field);	
	}

	public void clickToValueOfPopup(String value) {
		waitForElementClickable(driver,PassPageUI.DROPDOWN_VALUE_CHILD, value);
		clickToElement(driver, PassPageUI.DROPDOWN_VALUE_CHILD, value);	
	}
	
	@Step("Choose value of dropdown {0} {1}")
	public void clickToValueOfDropdownOfPopup(String field, String value) {
		clickToDropDownOfPopup(field);
		clickToValueOfPopup(value);

	}
	
	@Step("Click to button - Select all ticket")
	public void clickToSelectAllTicketButton() {
		waitForElementClickable(driver,PassPageUI.SELECT_ALL_BUTTON);
		clickToElement(driver, PassPageUI.SELECT_ALL_BUTTON);	
	}
	
	@Step("Click to button - close popup")
	public void clickToClosePopupButton() {
		waitForElementClickable(driver,PassPageUI.CLOSE_POPUP_BUTTON);
		clickToElement(driver, PassPageUI.CLOSE_POPUP_BUTTON);	
	}
	
	
	@Step("Click to button - close popup")
	public void clickToCloseAlertButton() {
		waitForElementClickable(driver,PassPageUI.CLOSE_ALERT_BUTTON);
		clickToElement(driver, PassPageUI.CLOSE_ALERT_BUTTON);	
	}
	
	@Step("Click To toogle - Auto Apply Coupon")
	public void clickToAutoApplyCouponToogle() {
		waitForElementClickable(driver,PassPageUI.TOOGLE_AUTO_APPLY);
		clickToElement(driver, PassPageUI.TOOGLE_AUTO_APPLY);	
	}
	
//	@Step("Get text")
//	public WebElement getAutoApplyCouponToggle() {
//		waitForElementVisible(driver, PassPageUI.TOOGLE_AUTO_APPLY);
//		return getWebElement(driver, PassPageUI.TOOGLE_AUTO_APPLY);
//	}
	
	public void clickToMoreMenuButton(String field) {
		waitForElementClickable(driver,PassPageUI.MORE_MENU_BUTTON, field);
		clickToElement(driver, PassPageUI.MORE_MENU_BUTTON, field);	
	}
	
	public void clickToItemsMoreMenuButton(String field) {
		waitForElementClickable(driver,PassPageUI.ITEMS_OF_MORE_MENU, field);
		clickToElement(driver, PassPageUI.ITEMS_OF_MORE_MENU, field);	
	}
	
	@Step("Acton of {0} {1}")
	public void clickToActionButton(String couponName, String field) {
		clickToMoreMenuButton(couponName);
		clickToItemsMoreMenuButton(field);
	}
	
	@Step("Switch to tab {0}")
	public void switchToWindowByID(String windowID) {
		switchToWindowByID(driver, windowID);	
	}

	@Step("Verify text - Box Office")
	public boolean isBoxOfficeTextDisplayed() {
		waitForElementVisible(driver, BoxOfficePageUI.TEXT_BOX_OFFICE_SCREEN);
		return isElementDisplayed(driver, BoxOfficePageUI.TEXT_BOX_OFFICE_SCREEN);
	}
	
//	@Step("Click to dropdown select quantity ticket {0} {1}")
//	public void clickToDropDown(String nameOfField,String textItem) {
//		waitForElementClickable(driver,PassPageUI.DROPDOWN_FIELD, nameOfField);
//		selectItemInDefaultDropdown(driver, PassPageUI.DROPDOWN_FIELD, textItem, nameOfField);	
//	}
	
	//dropdown of box office
	public void clickToDropDownBox(String field) {
		waitForElementClickable(driver,PassPageUI.DROPDOWN_FIELD, field);
		clickToElement(driver, PassPageUI.DROPDOWN_FIELD, field);	
	}

	public void clickToValueOfDropdownBox(String value) {
		waitForElementClickable(driver,PassPageUI.VALUE_DROPDOWN, value);
		clickToElement(driver, PassPageUI.VALUE_DROPDOWN, value);	
	}
	
	@Step("Click to value of dropdown {0} {1}")
	public void clickToValueOfDropdown(String field, String value) {
		clickToDropDownBox(field);
		clickToValueOfDropdownBox(value);
	}
	
	@Step("Verify text - Order")
	public boolean isOrderBoxOfficeTextDisplayed() {
		waitForElementVisible(driver, BoxOfficePageUI.TEXT_ORDER_BOX_OFFICE_SCREEN);
		return isElementDisplayed(driver, BoxOfficePageUI.TEXT_ORDER_BOX_OFFICE_SCREEN);
	}
	
	@Step("Click to dropdown select quantity ticket {0} {1}")
	public void clickToDropDownSelectQuantityTicket(String nameOfTicket,String textItem) {
		waitForElementClickable(driver,BoxOfficePageUI.DROPDOWN_QUANTITY_TICKET, nameOfTicket);
		selectItemInDefaultDropdown(driver, BoxOfficePageUI.DROPDOWN_QUANTITY_TICKET, textItem, nameOfTicket);	
	}

	public void clickToDropdownCoupon() {
		waitForElementClickable(driver,PassPageUI.COUPON_DROPDOWN);
		clickToElement(driver, PassPageUI.COUPON_DROPDOWN);	
	}
	
	public void inputToTextboxCoupon(String value) {
		waitForElementVisible(driver, PassPageUI.COUPON_TEXTBOX);
		sendkeyToElement(driver, PassPageUI.COUPON_TEXTBOX, value);		
	}
	
	public void clickToValueDropdownCoupon(String value) {
		waitForElementClickable(driver,PassPageUI.COUPON_VALUE_SEARCH, value);
		clickToElement(driver, PassPageUI.COUPON_VALUE_SEARCH, value);	
	}
	
	@Step("Input to coupon {0}")
	public void clickToValueOfDropdownCoupon(String couponName) {
		clickToDropdownCoupon();
		inputToTextboxCoupon(couponName);
		clickToValueDropdownCoupon(couponName);
	}
	
	@Step("Click to button - Checkout Now")
	public void clickButtonCheckout(String buttonName) {
		waitForElementClickable(driver,BoxOfficePageUI.BUTTON_CHECK_OUT_OR_ADD_CART, buttonName);
		clickToElement(driver, BoxOfficePageUI.BUTTON_CHECK_OUT_OR_ADD_CART, buttonName);	
	}
	
	@Step("Verify error message coupon- when checkout")
	public String getErrorMessageCheckoutUseCoupon() {
		waitForElementVisible(driver, PassPageUI.ERROR_MESSAGE_USE_COUPON);
		return getElementText(driver, PassPageUI.ERROR_MESSAGE_USE_COUPON);
	}
	
	@Step("Verify name of screen")
	public boolean isTextCheckoutScreenDisplayed() {
		waitForElementVisible(driver, PassPageUI.CHECKOUT_TEXT);
		return isElementDisplayed(driver, PassPageUI.CHECKOUT_TEXT);
	}
	
	@Step("Verify text discount")
	public boolean isTextDiscountDisplayed(String field) {
		waitForElementVisible(driver, PassPageUI.DISCOUNT_TEXT, field);
		return isElementDisplayed(driver, PassPageUI.DISCOUNT_TEXT, field);
	}
	
	@Step("Click to Prev Button")
	public void clickToPrevButton() {
		waitForElementClickable(driver,PassPageUI.PREV_BUTTON);
		clickToElement(driver, PassPageUI.PREV_BUTTON);	
	}

	@Step("Click to event - {0}")
	public void clickToEvent(String nameOfEvent) {
		waitForElementClickable(driver,ActionOfEventPageUI.EVENT_OF_CALENDAR_ON_SALE, nameOfEvent);
		clickToElement(driver, ActionOfEventPageUI.EVENT_OF_CALENDAR_ON_SALE, nameOfEvent);	
	}
	
	@Step("Click to event - {0}")
	public void clickToLink(String nameOfLink) {
		waitForElementClickable(driver,ActionOfEventPageUI.LINK_CANCEL_PREVIEW, nameOfLink);
		clickToElement(driver, ActionOfEventPageUI.LINK_CANCEL_PREVIEW, nameOfLink);	
	}
	//box office
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
	
	//buy online
	@Step("Click to button - Agree Checkout")
	public void clickToAgreeCheckoutButton() {
		waitForElementClickable(driver,BuyOnlinePageUI.BUTTON_AGREE_CHECKOUT);
		clickToElement(driver, BuyOnlinePageUI.BUTTON_AGREE_CHECKOUT);	
	}
	
	@Step("Input to Textbox Coupon - Buy Online {0}")
	public void inputToTextboxCouponBuyOnline(String value) {
		waitForElementVisible(driver, PassPageUI.COUPON_TEXTBOX_BUY_ONLINE);
		sendkeyToElement(driver, PassPageUI.COUPON_TEXTBOX_BUY_ONLINE, value);		
	}
	
	@Step("Click to button - Send Coupon")
	public void clickToSendCouponButton() {
		waitForElementClickable(driver,PassPageUI.SEND_COUPON_BUTTON);
		clickToElement(driver, PassPageUI.SEND_COUPON_BUTTON);	
	}
	
	@Step("Verify error message at Event screem")
	public String getErrorMessage() {
		waitForElementVisible(driver, BuyOnlinePageUI.ERROR_MESSAGE);
		return getElementText(driver, BuyOnlinePageUI.ERROR_MESSAGE);
	}
	
	@Step("Verify success message at Event screem")
	public String getSuccessMessage() {
		waitForElementVisible(driver, PassPageUI.SUCCESS_MESSAGE);
		return getElementText(driver, PassPageUI.SUCCESS_MESSAGE);
	}
	
	//Check out screen 
	@Step("Input info of buyer {0} {1}")
	public void inputInfoBuyerTextbox(String field, String fullName) {
		waitForElementVisible(driver, BuyOnlinePageUI.INFO_BUYER_TEXBOX, field);
		sendkeyToElement(driver, BuyOnlinePageUI.INFO_BUYER_TEXBOX, fullName, field);
	}
	
	@Step("Accept Terms of Service")
	public void clickCheckboxAcceptTermsService() {
		waitForElementClickable(driver,BuyOnlinePageUI.CHECKBOX_ACCEPT_TERMS_SERVICE);
		clickToElement(driver, BuyOnlinePageUI.CHECKBOX_ACCEPT_TERMS_SERVICE);	
	}
	
	@Step("Get text - Total Amount of Order")
	public String getTextTotalAmountOrder() {
		waitForElementVisible(driver, BuyOnlinePageUI.TEXT_TOTAL_AMOUNT_ORDER);
		return getElementText(driver, BuyOnlinePageUI.TEXT_TOTAL_AMOUNT_ORDER);
	}
	

	@Step("Click to button - Place Order")
	public void clickPlaceOrderButton() {
		waitForElementClickable(driver,BuyOnlinePageUI.BUTTON_PLACE_ORDER);
		clickToElement(driver, BuyOnlinePageUI.BUTTON_PLACE_ORDER);	
	}
	
	@Step("Input info of card manual - {0} {1}")
	public void inputInfoCardManual(String field, String value) {
		waitForElementVisible(driver, BuyOnlinePageUI.CARD_INFO_TEXTBOX, field);
		sendkeyToElement(driver, BuyOnlinePageUI.CARD_INFO_TEXTBOX, value, field);
	}
	
	public void switchToFrameIframe() {
		switchToFrameIframe(driver, BuyOnlinePageUI.IFRAME_CARD_MANUALLY);
	}
	
	public void switchToDefaultContent() {
		switchToDefaultContent(driver, BuyOnlinePageUI.IFRAME_CARD_MANUALLY);
	}
	
	@Step("Verify text display - Checkout success")
	public boolean isCheckoutSuccessTextDisplayed() {
		waitForElementVisible(driver, BuyOnlinePageUI.CHECKOUT_SUCCESS_TEXT);
		return isElementDisplayed(driver, BuyOnlinePageUI.CHECKOUT_SUCCESS_TEXT);
	}
	
	
	
	//YOPMAIL
	public void openNewTab() {
		((JavascriptExecutor)driver).executeScript("window.open('about:blank', '-blank')");
		 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(tabs.get(1));
		 driver.get(GlobalConstants.YOPMAIL);

	}

	@Step("Input to textbox - Email of YOPMAIL")
	public void inputToTextboxLogin(String value) {
		waitForElementVisible(driver, PassPageUI.INPUT_EMAIL);
		sendkeyToElement(driver, PassPageUI.INPUT_EMAIL, value);		
	}
	
	@Step("Click switch to email")
	public void clickToSwitchToEmail() {
		waitForElementClickable(driver,PassPageUI.SEND_EMAIL_ICON);
		clickToElement(driver, PassPageUI.SEND_EMAIL_ICON);	
	}
	
	public void switchToIframeInbox() {
		switchToFrameIframe(driver, PassPageUI.IFRAME_INFO);
	}
	
	public void switchToDefaultInbox() {
		switchToDefaultContent(driver, PassPageUI.IFRAME_INFO);
	}
	
	@Step("Click view Email")
	public void clickToViewEmail() {
		waitForElementClickable(driver,PassPageUI.EMAIL_INFO);
		clickToElement(driver, PassPageUI.EMAIL_INFO);	
	}
	

	public void switchToIframeEmail() {
		switchToFrameIframe(driver, PassPageUI.IFRAME_EMAIL);
	}
	
	public void switchToDefaultEmail() {
		switchToDefaultContent(driver, PassPageUI.IFRAME_EMAIL);
	}
	
	@Step("Get text - PASS CODE")
	public String getTextOfPassCode() {
		waitForElementVisible(driver, PassPageUI.PASS_CODE);
		return getElementText(driver, PassPageUI.PASS_CODE);
	}
	
}