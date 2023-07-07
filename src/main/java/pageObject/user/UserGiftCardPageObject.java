package pageObject.user;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.apache.hc.core5.http2.frame.StreamIdGenerator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import pageUIs.user.GiftCardPageUI;
import pageUIs.user.HomePageUI;
import org.openqa.selenium.interactions.Actions;


public class UserGiftCardPageObject extends BasePage{

	private WebDriver driver;

	public UserGiftCardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	
	@Step("Click to button Login")
	public void clickToLoginLink() {
		waitForElementClickable(driver,GiftCardPageUI.LOGIN_LINK);
		clickToElement(driver, GiftCardPageUI.LOGIN_LINK);		
	}

	@Step("Input to Textbox Login {0} {1}")
	public void inputToTextboxLogin(String field, String value) {
		waitForElementVisible(driver, GiftCardPageUI.TEXTBOX_LOGIN, field);
		sendkeyToElement(driver, GiftCardPageUI.TEXTBOX_LOGIN, value, field);		
	}

	@Step("Login Account {0} {1}")
	public void loginAccount(String email, String password) {
		inputToTextboxLogin("email", email);
		inputToTextboxLogin("password", password);

	}

	@Step("Click to button - Login")
	public void clickToLoginButton() {
		waitForElementClickable(driver,GiftCardPageUI.LOGIN_BUTTON);
		clickToElement(driver, GiftCardPageUI.LOGIN_BUTTON);	
	}

	@Step("Verify name of screen - {0}")
	public boolean isTextNameOfScreenDisplayed(String nameOfScreen) {
		waitForElementVisible(driver, GiftCardPageUI.NAME_OF_SCREEN, nameOfScreen);
		return isElementDisplayed(driver, GiftCardPageUI.NAME_OF_SCREEN, nameOfScreen);
	}
	
	@Step("Click open Left Menu")
	public void clickShowLeftMenu() {
		waitForElementClickable(driver,BoxOfficePageUI.LEFT_MENU_BUTTON);
		clickToElement(driver, BoxOfficePageUI.LEFT_MENU_BUTTON);	
	}

	@Step("Click to items of Left Menu - {0}")
	public void clickToItemOfLeftMenu(String items) {
		waitForElementClickable(driver,GiftCardPageUI.ITEMS_LEFT_MENU, items);
		clickToElement(driver, GiftCardPageUI.ITEMS_LEFT_MENU, items);	
	}
	
	@Step("Click to items of List Ticketing - {0}")
	public void clickToItemOfListTicketing(String items) {
		waitForElementClickable(driver,GiftCardPageUI.ITEMS_OF_LIST_TICKETING, items);
		clickToElement(driver, GiftCardPageUI.ITEMS_OF_LIST_TICKETING, items);	
	}

	@Step("Click to button - Add {0}")
	public void clickToAddButton(String field) {
		waitForElementClickable(driver,GiftCardPageUI.ADD_BUTTON, field);
		clickToElement(driver, GiftCardPageUI.ADD_BUTTON, field);	
	}
	
	@Step("Verify name of popup -  {0}")
	public boolean isTextNameOfPopupDisplayed(String nameOfPopup) {
		waitForElementVisible(driver, GiftCardPageUI.NAME_OF_POPUP, nameOfPopup);
		return isElementDisplayed(driver, GiftCardPageUI.NAME_OF_POPUP, nameOfPopup);
	}
	
	@Step("Click to button - SaveGift Card")
	public void clickToSaveButton() {
		waitForElementClickable(driver,GiftCardPageUI.SAVE_BUTTON);
		clickToElement(driver, GiftCardPageUI.SAVE_BUTTON);	
	}

	@Step("Get Error Message Of Filed {0}")
	public String getErrorMessageOfFiled(String filed) {
		waitForElementVisible(driver, GiftCardPageUI.ERROR_MESSAGE_FIELD, filed);
		return getElementText(driver, GiftCardPageUI.ERROR_MESSAGE_FIELD, filed);
	}
	
	@Step("Verify Gift Card Name")
	public boolean getNameOfGiftCard(String field) {
		waitForElementVisible(driver, GiftCardPageUI.GIFTCARD_NAME, field);
		return isElementDisplayed(driver, GiftCardPageUI.GIFTCARD_NAME, field);
	}
	
	@Step("Verify text of Alert")
	public String getTextOfAlert() {
		waitForElementVisible(driver, GiftCardPageUI.ALERT_OF_POPUP);
		return getElementText(driver, GiftCardPageUI.ALERT_OF_POPUP);
	}
	
	@Step("Input value of textbox - Limit purchase to - {0} {1}")
	public void inputToTextboxLimitPurchasePopup(String field, String value) {
		waitForElementVisible(driver, GiftCardPageUI.TEXTBOX_LIMIT_PURCHASE, field);
		sendkeyToElement(driver, GiftCardPageUI.TEXTBOX_LIMIT_PURCHASE, value, field);		
	}
	
	@Step("Input value of popup coupon {0} {1}")
	public void inputToTextboxPlaceholderPopup(String field, String value) {
		waitForElementVisible(driver, GiftCardPageUI.TEXTBOX_POPUP_PLACEHODER, field);
		sendkeyToElement(driver, GiftCardPageUI.TEXTBOX_POPUP_PLACEHODER, value, field);		
	}
	
	@Step("Input value of popup coupon {0} {1}")
	public void inputToTextboxPlaceholderDescriptionPopup(String field, String value) {
		waitForElementVisible(driver, GiftCardPageUI.TEXTBOX_DESCRIPTION, field);
		sendkeyToElement(driver, GiftCardPageUI.TEXTBOX_DESCRIPTION, value, field);		
	}
	
	
	@Step("Input value of popup coupon {0} {1}")
	public void inputToTextboxNamePopup(String field, String value) {
		waitForElementVisible(driver, GiftCardPageUI.TEXTBOX_POPUP_FIELD, field);
		sendkeyToElement(driver, GiftCardPageUI.TEXTBOX_POPUP_FIELD, value, field);		
	}
	
	@Step("Input value of field Price of Popup")
	public void inputToTextboxPrice(String value) {
	    waitForElementVisible(driver, GiftCardPageUI.TEXTBOX_PRICE);
	    sendkeyToElement(driver, GiftCardPageUI.TEXTBOX_PRICE, value + Keys.ENTER);
	}
	
	
	//Dropdown of popup
	public void clickToDropDownOfPopup(String field) {
		waitForElementClickable(driver,GiftCardPageUI.DROPDOWN_VALUE_PARENT, field);
		clickToElement(driver, GiftCardPageUI.DROPDOWN_VALUE_PARENT, field);	
	}

	public void clickToValueOfPopup(String value) {
		waitForElementClickable(driver,GiftCardPageUI.DROPDOWN_VALUE_CHILD, value);
		clickToElement(driver, GiftCardPageUI.DROPDOWN_VALUE_CHILD, value);	
	}
	
	@Step("Choose value of dropdown {0} {1}")
	public void clickToValueOfDropdownOfPopup(String field, String value) {
		clickToDropDownOfPopup(field);
		clickToValueOfPopup(value);

	}
	
	@Step("Click to button - Select all ticket")
	public void clickToSelectAllTicketButton() {
		waitForElementClickable(driver,GiftCardPageUI.SELECT_ALL_BUTTON);
		clickToElement(driver, GiftCardPageUI.SELECT_ALL_BUTTON);	
	}
	
	@Step("Click to button - close popup")
	public void clickToClosePopupButton() {
		waitForElementClickable(driver,GiftCardPageUI.CLOSE_POPUP_BUTTON);
		clickToElement(driver, GiftCardPageUI.CLOSE_POPUP_BUTTON);	
	}
	
	
	@Step("Click to button - close popup")
	public void clickToCloseAlertButton() {
		waitForElementClickable(driver,GiftCardPageUI.CLOSE_ALERT_BUTTON);
		clickToElement(driver, GiftCardPageUI.CLOSE_ALERT_BUTTON);	
	}
	
	@Step("Click To toogle - Auto ApplyGift Card")
	public void clickToAutoApplyCouponToogle() {
		waitForElementClickable(driver,GiftCardPageUI.TOOGLE_AUTO_APPLY);
		clickToElement(driver, GiftCardPageUI.TOOGLE_AUTO_APPLY);	
	}
	
//	@Step("Get text")
//	public WebElement getAutoApplyCouponToggle() {
//		waitForElementVisible(driver, GiftCardPageUI.TOOGLE_AUTO_APPLY);
//		return getWebElement(driver, GiftCardPageUI.TOOGLE_AUTO_APPLY);
//	}
	
	public void clickToMoreMenuButton(String field) {
		waitForElementClickable(driver,GiftCardPageUI.MORE_MENU_BUTTON, field);
		clickToElement(driver, GiftCardPageUI.MORE_MENU_BUTTON, field);	
	}
	
	public void clickToItemsMoreMenuButton(String field) {
		waitForElementClickable(driver,GiftCardPageUI.ITEMS_OF_MORE_MENU, field);
		clickToElement(driver, GiftCardPageUI.ITEMS_OF_MORE_MENU, field);	
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
//		waitForElementClickable(driver,GiftCardPageUI.DROPDOWN_FIELD, nameOfField);
//		selectItemInDefaultDropdown(driver, GiftCardPageUI.DROPDOWN_FIELD, textItem, nameOfField);	
//	}
	
	//dropdown of box office
	public void clickToDropDownBox(String field) {
		waitForElementClickable(driver,GiftCardPageUI.DROPDOWN_FIELD, field);
		clickToElement(driver, GiftCardPageUI.DROPDOWN_FIELD, field);	
	}

	public void clickToValueOfDropdownBox(String value) {
		waitForElementClickable(driver,GiftCardPageUI.VALUE_DROPDOWN, value);
		clickToElement(driver, GiftCardPageUI.VALUE_DROPDOWN, value);	
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
	
	@Step("Click to dropdown select quantity giftcard {0} {1}")
	public void clickToDropDownSelectQuantityGiftCard(String nameOfTicket,String textItem) {
		waitForElementClickable(driver,GiftCardPageUI.DROPDOWN_QUANTITY_TICKET_BUY_GIFTCARD, nameOfTicket);
		selectItemInDefaultDropdown(driver, GiftCardPageUI.DROPDOWN_QUANTITY_TICKET_BUY_GIFTCARD, textItem, nameOfTicket);	
	}

	public void clickToDropdownCoupon() {
		waitForElementClickable(driver,GiftCardPageUI.COUPON_DROPDOWN);
		clickToElement(driver, GiftCardPageUI.COUPON_DROPDOWN);	
	}
	
	public void inputToTextboxCoupon(String value) {
		waitForElementVisible(driver, GiftCardPageUI.COUPON_TEXTBOX);
		sendkeyToElement(driver, GiftCardPageUI.COUPON_TEXTBOX, value);		
	}
	
	public void clickToValueDropdownCoupon(String value) {
		waitForElementClickable(driver,GiftCardPageUI.COUPON_VALUE_SEARCH, value);
		clickToElement(driver, GiftCardPageUI.COUPON_VALUE_SEARCH, value);	
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
		waitForElementVisible(driver, GiftCardPageUI.ERROR_MESSAGE_USE_COUPON);
		return getElementText(driver, GiftCardPageUI.ERROR_MESSAGE_USE_COUPON);
	}
	
	@Step("Verify name of screen")
	public boolean isTextCheckoutScreenDisplayed() {
		waitForElementVisible(driver, GiftCardPageUI.CHECKOUT_TEXT);
		return isElementDisplayed(driver, GiftCardPageUI.CHECKOUT_TEXT);
	}
	
	@Step("Verify text discount")
	public boolean isTextDiscountDisplayed(String field) {
		waitForElementVisible(driver, GiftCardPageUI.DISCOUNT_TEXT, field);
		return isElementDisplayed(driver, GiftCardPageUI.DISCOUNT_TEXT, field);
	}
	
	@Step("Click to Prev Button")
	public void clickToPrevButton() {
		waitForElementClickable(driver,GiftCardPageUI.PREV_BUTTON);
		clickToElement(driver, GiftCardPageUI.PREV_BUTTON);	
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
	
	@Step("Input to TextboxGift Card - Buy Online {0}")
	public void inputToTextboxCouponBuyOnline(String value) {
		waitForElementVisible(driver, GiftCardPageUI.COUPON_TEXTBOX_BUY_ONLINE);
		sendkeyToElement(driver, GiftCardPageUI.COUPON_TEXTBOX_BUY_ONLINE, value);		
	}
	
	@Step("Click to button - SendGift Card")
	public void clickToSendCouponButton() {
		waitForElementClickable(driver,GiftCardPageUI.SEND_COUPON_BUTTON);
		clickToElement(driver, GiftCardPageUI.SEND_COUPON_BUTTON);	
	}
	
	@Step("Verify error message at Event screem")
	public String getErrorMessage() {
		waitForElementVisible(driver, BuyOnlinePageUI.ERROR_MESSAGE);
		return getElementText(driver, BuyOnlinePageUI.ERROR_MESSAGE);
	}
	
	@Step("Verify success message at Event screem")
	public String getSuccessMessage() {
		waitForElementVisible(driver, GiftCardPageUI.SUCCESS_MESSAGE);
		return getElementText(driver, GiftCardPageUI.SUCCESS_MESSAGE);
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
		waitForElementVisible(driver, GiftCardPageUI.INPUT_EMAIL);
		sendkeyToElement(driver, GiftCardPageUI.INPUT_EMAIL, value);		
	}
	
	@Step("Click switch to email")
	public void clickToSwitchToEmail() {
		waitForElementClickable(driver,GiftCardPageUI.SEND_EMAIL_ICON);
		clickToElement(driver, GiftCardPageUI.SEND_EMAIL_ICON);	
	}
	
	public void switchToIframeInbox() {
		switchToFrameIframe(driver, GiftCardPageUI.IFRAME_INFO);
	}
	
	public void switchToDefaultInbox() {
		switchToDefaultContent(driver, GiftCardPageUI.IFRAME_INFO);
	}
	
	@Step("Click view Email")
	public void clickToViewEmail() {
		waitForElementClickable(driver,GiftCardPageUI.EMAIL_INFO);
		clickToElement(driver, GiftCardPageUI.EMAIL_INFO);	
	}
	

	public void switchToIframeEmail() {
		switchToFrameIframe(driver, GiftCardPageUI.IFRAME_EMAIL);
	}
	
	public void switchToDefaultEmail() {
		switchToDefaultContent(driver, GiftCardPageUI.IFRAME_EMAIL);
	}
	
	@Step("Get text - Gift Card CODE")
	public String getTextOfGiftCardCode(String field) {
		waitForElementVisible(driver, GiftCardPageUI.GIFT_CARD_CODE, field);
		return getElementText(driver, GiftCardPageUI.GIFT_CARD_CODE, field);
	}
	
}