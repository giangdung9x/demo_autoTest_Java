package pageObject.user;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.hc.core5.http2.frame.StreamIdGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.user.ActionOfEventPageUI;
import pageUIs.user.BoxOfficeUI;
import pageUIs.user.BuyOnlinePageUI;
import pageUIs.user.CouponPageUI;
import pageUIs.user.HomePageUI;


public class UserCouponPageObject extends BasePage{

	private WebDriver driver;

	public UserCouponPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click to button Login")
	public void clickToLoginLink() {
		waitForElementClickable(driver,CouponPageUI.LOGIN_LINK);
		clickToElement(driver, CouponPageUI.LOGIN_LINK);		
	}

	@Step("Input to Textbox Login {0} {1}")
	public void inputToTextboxLogin(String field, String value) {
		waitForElementVisible(driver, CouponPageUI.TEXTBOX_LOGIN, field);
		sendkeyToElement(driver, CouponPageUI.TEXTBOX_LOGIN, value, field);		
	}

	@Step("Login Account {0} {1}")
	public void loginAccount(String email, String password) {
		inputToTextboxLogin("email", email);
		inputToTextboxLogin("password", password);

	}

	@Step("Click to button - Login")
	public void clickToLoginButton() {
		waitForElementClickable(driver,CouponPageUI.LOGIN_BUTTON);
		clickToElement(driver, CouponPageUI.LOGIN_BUTTON);	
	}

	@Step("Verify name of screen - {0}")
	public boolean isTextNameOfScreenDisplayed(String nameOfScreen) {
		waitForElementVisible(driver, CouponPageUI.NAME_OF_SCREEN, nameOfScreen);
		return isElementDisplayed(driver, CouponPageUI.NAME_OF_SCREEN, nameOfScreen);
	}

	@Step("Click to items of Left Menu - {0}")
	public void clickToItemOfLeftMenu(String items) {
		waitForElementClickable(driver,CouponPageUI.ITEMS_LEFT_MENU, items);
		clickToElement(driver, CouponPageUI.ITEMS_LEFT_MENU, items);	
	}
	
	@Step("Click to items of List Ticketing - {0}")
	public void clickToItemOfListTicketing(String items) {
		waitForElementClickable(driver,CouponPageUI.ITEMS_OF_LIST_TICKETING, items);
		clickToElement(driver, CouponPageUI.ITEMS_OF_LIST_TICKETING, items);	
	}

	@Step("Click to button - Add Coupon")
	public void clickToAddCouponButton() {
		waitForElementClickable(driver,CouponPageUI.ADD_COUPON_BUTTON);
		clickToElement(driver, CouponPageUI.ADD_COUPON_BUTTON);	
	}
	
	@Step("Verify name of popup -  {0}")
	public boolean isTextNameOfPopupDisplayed(String nameOfPopup) {
		waitForElementVisible(driver, CouponPageUI.NAME_OF_POPUP, nameOfPopup);
		return isElementDisplayed(driver, CouponPageUI.NAME_OF_POPUP, nameOfPopup);
	}
	
	@Step("Click to button - Save Coupon")
	public void clickToSaveCouponButton() {
		waitForElementClickable(driver,CouponPageUI.SAVE_BUTTON);
		clickToElement(driver, CouponPageUI.SAVE_BUTTON);	
	}

	@Step("Verify text of Alert")
	public String getTextOfAlert() {
		waitForElementVisible(driver, CouponPageUI.ALERT_OF_POPUP);
		return getElementText(driver, CouponPageUI.ALERT_OF_POPUP);
	}
	
	@Step("Input value of popup coupon {0} {1}")
	public void inputToTextboxPlaceholderCouponPopup(String field, String value) {
		waitForElementVisible(driver, CouponPageUI.TEXTBOX_POPUP_PLACEHODER, field);
		sendkeyToElement(driver, CouponPageUI.TEXTBOX_POPUP_PLACEHODER, value, field);		
	}
	
	
	@Step("Input value of popup coupon {0} {1}")
	public void inputToTextboxNameCouponPopup(String field, String value) {
		waitForElementVisible(driver, CouponPageUI.TEXTBOX_POPUP_FIELD, field);
		sendkeyToElement(driver, CouponPageUI.TEXTBOX_POPUP_FIELD, value, field);		
	}
	
	
	
	public void clickToDropDown(String field) {
		waitForElementClickable(driver,CouponPageUI.DROPDOWN_VALUE_PARENT, field);
		clickToElement(driver, CouponPageUI.DROPDOWN_VALUE_PARENT, field);	
	}

	public void clickToValue(String value) {
		waitForElementClickable(driver,CouponPageUI.DROPDOWN_VALUE_CHILD, value);
		clickToElement(driver, CouponPageUI.DROPDOWN_VALUE_CHILD, value);	
	}
	
	@Step("Choose value of dropdown {0} {1}")
	public void clickToValueOfDropdown(String field, String value) {
		clickToDropDown(field);
		clickToValue(value);

	}
	
	@Step("Click to button - close popup")
	public void clickToClosePopupButton() {
		waitForElementClickable(driver,CouponPageUI.CLOSE_POPUP_BUTTON);
		clickToElement(driver, CouponPageUI.CLOSE_POPUP_BUTTON);	
	}
	
	
	@Step("Click to button - close popup")
	public void clickToCloseAlertButton() {
		waitForElementClickable(driver,CouponPageUI.CLOSE_ALERT_BUTTON);
		clickToElement(driver, CouponPageUI.CLOSE_ALERT_BUTTON);	
	}
	
	@Step("Click tO toogle - Auto Apply Coupon")
	public void clickToAutoApplyCouponToogle() {
		waitForElementClickable(driver,CouponPageUI.TOOGLE_AUTO_APPLY);
		clickToElement(driver, CouponPageUI.TOOGLE_AUTO_APPLY);	
	}
	
	
	public void clickToMoreMenuButton(String field) {
		waitForElementClickable(driver,CouponPageUI.MORE_MENU_BUTTON, field);
		clickToElement(driver, CouponPageUI.MORE_MENU_BUTTON, field);	
	}
	
	public void clickToItemsMoreMenuButton(String field) {
		waitForElementClickable(driver,CouponPageUI.ITEMS_OF_MORE_MENU, field);
		clickToElement(driver, CouponPageUI.ITEMS_OF_MORE_MENU, field);	
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
		waitForElementVisible(driver, BoxOfficeUI.TEXT_BOX_OFFICE_SCREEN);
		return isElementDisplayed(driver, BoxOfficeUI.TEXT_BOX_OFFICE_SCREEN);
	}
	
	@Step("Click to dropdown select quantity ticket {0} {1}")
	public void clickToDropDown(String nameOfField,String textItem) {
		waitForElementClickable(driver,CouponPageUI.DROPDOWN_FIELD, nameOfField);
		selectItemInDefaultDropdown(driver, CouponPageUI.DROPDOWN_FIELD, textItem, nameOfField);	
	}
	
	@Step("Verify text - Order")
	public boolean isOrderBoxOfficeTextDisplayed() {
		waitForElementVisible(driver, BoxOfficeUI.TEXT_ORDER_BOX_OFFICE_SCREEN);
		return isElementDisplayed(driver, BoxOfficeUI.TEXT_ORDER_BOX_OFFICE_SCREEN);
	}
	
	@Step("Click to dropdown select quantity ticket {0} {1}")
	public void clickToDropDownSelectQuantityTicket(String nameOfTicket,String textItem) {
		waitForElementClickable(driver,BoxOfficeUI.DROPDOWN_QUANTITY_TICKET, nameOfTicket);
		selectItemInDefaultDropdown(driver, BoxOfficeUI.DROPDOWN_QUANTITY_TICKET, textItem, nameOfTicket);	
	}

	public void clickToDropdownCoupon() {
		waitForElementClickable(driver,CouponPageUI.COUPON_DROPDOWN);
		clickToElement(driver, CouponPageUI.COUPON_DROPDOWN);	
	}
	
	public void inputToTextboxCoupon(String value) {
		waitForElementVisible(driver, CouponPageUI.COUPON_TEXTBOX);
		sendkeyToElement(driver, CouponPageUI.COUPON_TEXTBOX, value);		
	}
	
	public void clickToValueDropdownCoupon(String value) {
		waitForElementClickable(driver,CouponPageUI.COUPON_VALUE_SEARCH, value);
		clickToElement(driver, CouponPageUI.COUPON_VALUE_SEARCH, value);	
	}
	
	@Step("Input to coupon {0}")
	public void clickToActionButton(String couponName) {
		clickToDropdownCoupon();
		inputToTextboxCoupon(couponName);
		clickToValueDropdownCoupon(couponName);
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
	
	@Step("Verify name of screen")
	public boolean isTextCheckoutScreenDisplayed() {
		waitForElementVisible(driver, CouponPageUI.CHECKOUT_TEXT);
		return isElementDisplayed(driver, CouponPageUI.CHECKOUT_TEXT);
	}
	
	@Step("Verify text discount")
	public boolean isTextDiscountDisplayed() {
		waitForElementVisible(driver, CouponPageUI.DISCOUNT_TEXT);
		return isElementDisplayed(driver, CouponPageUI.DISCOUNT_TEXT);
	}
}