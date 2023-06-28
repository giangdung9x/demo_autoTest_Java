package pageObject.user;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.hc.core5.http2.frame.StreamIdGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.user.BoxOfficePageUI;
import pageUIs.user.RewardPageUI;
import pageUIs.user.SellConcessionPageUI;


public class UserSellConcessionPageObject extends BasePage{

	private WebDriver driver;

	public UserSellConcessionPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	//LOGIN
	@Step("Click to button Login")
	public void clickToLoginLink() {
		waitForElementClickable(driver,SellConcessionPageUI.LOGIN_LINK);
		clickToElement(driver, SellConcessionPageUI.LOGIN_LINK);		
	}

	@Step("Input to Textbox Login {0} {1}")
	public void inputToTextboxLogin(String field, String value) {
		waitForElementVisible(driver, SellConcessionPageUI.TEXTBOX_LOGIN, field);
		sendkeyToElement(driver, SellConcessionPageUI.TEXTBOX_LOGIN, value, field);		
	}

	@Step("Login Account {0} {1}")
	public void loginAccount(String email, String password) {
		inputToTextboxLogin("email", email);
		inputToTextboxLogin("password", password);
	}

	@Step("Click to button - Login")
	public void clickToLoginButton() {
		waitForElementClickable(driver,SellConcessionPageUI.LOGIN_BUTTON);
		clickToElement(driver, SellConcessionPageUI.LOGIN_BUTTON);	
	}


	//HOMEPAGE CONCESSION
	public boolean isTextSelectEventWantToWorkDisplayed() {
		waitForElementVisible(driver, SellConcessionPageUI.TEXT_OF_HOMEPAGE_CONCESSION);
		return isElementDisplayed(driver, SellConcessionPageUI.TEXT_OF_HOMEPAGE_CONCESSION);
	}

	public void clickToChooseEventButton(String eventName) {
		waitForElementClickable(driver,SellConcessionPageUI.EVENT_NAME, eventName);
		clickToElement(driver, SellConcessionPageUI.EVENT_NAME, eventName);	
	}
	
	public void clickToButtonLogout() {
		waitForElementClickable(driver,SellConcessionPageUI.LOGOUT_BUTTON);
		clickToElement(driver, SellConcessionPageUI.LOGOUT_BUTTON);	
	}
	
	//SELL OF EVENT SCREEN
	public void clickToPlusAddOnsButton() {
		waitForElementClickable(driver,SellConcessionPageUI.PLUS_ADD_ONS_BUTTON);
		clickToElement(driver, SellConcessionPageUI.PLUS_ADD_ONS_BUTTON);	
	}
	
	public void clickToMinusAddOnsButton() {
		waitForElementClickable(driver,SellConcessionPageUI.MINUS_ADD_ONS_BUTTON);
		clickToElement(driver, SellConcessionPageUI.MINUS_ADD_ONS_BUTTON);	
	}
	
	public void clickToCheckoutButton() {
		waitForElementClickable(driver,SellConcessionPageUI.CHECKOUT_BUTTON);
		clickToElement(driver, SellConcessionPageUI.CHECKOUT_BUTTON);	
	}
	
	public void plusAddOnsCheckout() {
		clickToPlusAddOnsButton();
		clickToCheckoutButton();
	}
	
	//CHECKOUT SCREEN
	@Step("Click to radio button - Payment Checkout - {0}")
	public void clickToRadioButtonPaymentCheckout(String paymentType) {
		waitForElementClickable(driver,BoxOfficePageUI.RADIO_BUTTON_PAYMENT_CHECKOUT, paymentType);
		clickToElement(driver, BoxOfficePageUI.RADIO_BUTTON_PAYMENT_CHECKOUT, paymentType);	
	}
	
	public void clickCheckboxConfirmationDelivery(String typeConfirm) {
		waitForElementClickable(driver,BoxOfficePageUI.CHECKBOX_CONFIRMATION_DELIVERY,typeConfirm );
		checkToDefaultCheckboxOrRadio(driver, BoxOfficePageUI.CHECKBOX_CONFIRMATION_DELIVERY, typeConfirm);	
	}
	
	@Step("Choose Confirmation Delivery")
	public void clickCheckboxConfirmationDeliveryAll(String email, String text) {
		clickCheckboxConfirmationDelivery(email);
		clickCheckboxConfirmationDelivery(text);

	}
	
	@Step("Input to info buyer {0} {1}")
	public void inputToTextboxInfo(String field, String value) {
		waitForElementVisible(driver, SellConcessionPageUI.INFOR_BUYER_CHECKOUT, field);
		sendkeyToElement(driver, SellConcessionPageUI.INFOR_BUYER_CHECKOUT, value, field);		
	}
	
	@Step("Input to info buyer {0} {1} {2} {3}")
	public void inputToTextboxInfoBuyer(String fullName, String phone, String email, String notes) {
		inputToTextboxInfo("Full Name", fullName);
		inputToTextboxInfo("Phone", phone);
		inputToTextboxInfo("Email", email);
		inputToTextboxInfo("Notes", notes);
	}
	
	@Step("Click to button - Place Order")
	public void clickToButtonPlaceOrder() {
		waitForElementClickable(driver,SellConcessionPageUI.PLACE_ORDER_BUTTON );
		clickToElement(driver, SellConcessionPageUI.PLACE_ORDER_BUTTON);	
	}
	
	@Step("Get text - Total amount before order")
	public double getAmountBeforeOder() {
	    waitForElementVisible(driver, SellConcessionPageUI.AMOUT_OF_ORDER_BEFORE);
	    String amountTotalBefore = getElementText(driver, SellConcessionPageUI.AMOUT_OF_ORDER_BEFORE);
	    return Double.parseDouble(amountTotalBefore);
	}
	
	@Step("Get text - Total amount before order")
	public double getAmountBeforeOderMisc() {
		  waitForElementVisible(driver, SellConcessionPageUI.AMOUT_OF_ORDER_BEFORE_MISC);
		    String amountTotalAfter = getElementText(driver, SellConcessionPageUI.AMOUT_OF_ORDER_BEFORE_MISC);
		    String amountText = amountTotalAfter.replace("$", "");
		    return Double.parseDouble(amountText);
	}
	
	@Step("Get text - Total amount after order")
	public double getAmountAfterOrder() {
	    waitForElementVisible(driver, SellConcessionPageUI.AMOUT_OF_ORDER_BEFORE);
	    String amountTotalAfter = getElementText(driver, SellConcessionPageUI.AMOUT_OF_ORDER_BEFORE);
	    String amountText = amountTotalAfter.replace("$", "");
	    return Double.parseDouble(amountText);
	}
	
	@Step("Compare Total Amount")
	public String compareAmounts() {
	    double amountBefore = getAmountBeforeOder();
	    double amountAfter = getAmountAfterOrder();

	    if (amountBefore == amountAfter) {
	        return "Đúng - Hai giá trị bằng nhau.";
	    } else {
	        return "Sai - Hai giá trị khác nhau.";
	    }
	}
	
	@Step("Compare Total Amount Misc")
	public String compareAmountsMisc() {
	    double amountBefore = getAmountBeforeOderMisc();
	    double amountAfter = getAmountAfterOrder();

	    if (amountBefore == amountAfter) {
	        return "Đúng - Hai giá trị bằng nhau.";
	    } else {
	        return "Sai - Hai giá trị khác nhau.";
	    }
	}
	
	@Step("Verify text - Order Success")
	public boolean isSuccessOrderTextDisplayed() {
		waitForElementVisible(driver, BoxOfficePageUI.TEXT_SUCCESS_ORDER);
		return isElementDisplayed(driver, BoxOfficePageUI.TEXT_SUCCESS_ORDER);
	}
	
	@Step("Click to button - Close")
	public void clickToClosePopupCheckout() {
		waitForElementClickable(driver,SellConcessionPageUI.CLOSE_POPUP_BUTTON );
		clickToElement(driver, SellConcessionPageUI.CLOSE_POPUP_BUTTON);	
	}
	
	@Step("Input info Card {0} {1}")
	public void inputInfoCardManual(String field, String value) {
		waitForElementVisible(driver, BoxOfficePageUI.CARD_INFO_TEXTBOX, field);
		sendkeyToElement(driver, BoxOfficePageUI.CARD_INFO_TEXTBOX, value, field);
	}
	
	@Step("Switch to frame/iframe")
	public void switchToFrameIframe() {
		switchToFrameIframe(driver, BoxOfficePageUI.IFRAME_CARD_MANUALLY);
	}

	@Step("switch to default content")
	public void switchToDefaultContent() {
		switchToDefaultContent(driver, BoxOfficePageUI.IFRAME_CARD_MANUALLY);
	}
	
	@Step("Input to info Card {0} {1} {2} {3}")
	public void inputInfoCardManualAll(String card, String month, String cvc, String zip) {
		switchToFrameIframe();
		inputInfoCardManual("Card number", card);
		inputInfoCardManual("MM / YY", month);
		inputInfoCardManual("CVC", cvc);
		inputInfoCardManual("ZIP", zip);
		switchToDefaultContent();
	}
	
	@Step("Click to button - Misc Charge")
	public void clickToButtonMiscCharge() {
		waitForElementClickable(driver,SellConcessionPageUI.ADD_MISC_CHARGE_BUTTON );
		clickToElement(driver, SellConcessionPageUI.ADD_MISC_CHARGE_BUTTON);	
	}
	
	@Step("Input info of poup - Misc Charge - {0} {1}")
	public void inputInfoOfMiscCharge(String field, String value) {
		waitForElementVisible(driver, SellConcessionPageUI.INFO__MISC_CHARGE_TEXTBOX, field);
		sendkeyToElement(driver, SellConcessionPageUI.INFO__MISC_CHARGE_TEXTBOX, value, field);
	}
	
	@Step("Input info of poup - Misc Charge - {0} {1}")
	public void inputInfoNoteOfMiscCharge(String field, String value) {
		waitForElementVisible(driver, SellConcessionPageUI.INFOR_NOTES, field);
		sendkeyToElement(driver, SellConcessionPageUI.INFOR_NOTES, value, field);
	}
	
	
	@Step("Click to button of popup - Misc Charge - {0}")
	public void clickToButtonOfMiscChargePopup(String field) {
		waitForElementClickable(driver,SellConcessionPageUI.CHECKOUT_OF_POPUP_BUTTON, field);
		clickToElement(driver, SellConcessionPageUI.CHECKOUT_OF_POPUP_BUTTON, field);	
	}
	
	@Step("Action order Misc charge - save - checkout- {0} {1}")
	public void clickToButtonOfMiscChargePopup(String amount, String notes) {
		clickToButtonMiscCharge();
		inputInfoOfMiscCharge("Amount", amount);
		inputInfoNoteOfMiscCharge("Notes", notes);
		clickToButtonOfMiscChargePopup("Save & Close");
		clickToCheckoutButton();
	}
	
	@Step("Action order Misc charge - save - checkout - {0} {1}")
	public void clickToButtonOfMiscChargeSavePopup(String amount, String notes) {
		clickToButtonMiscCharge();
		inputInfoOfMiscCharge("Amount", amount);
		inputInfoNoteOfMiscCharge("Notes", notes);
		clickToButtonOfMiscChargePopup("Checkout Now");
	}
	
	@Step("Switch to Tab")
	public void clickSwitchToTab(String field) {
		waitForElementClickable(driver,SellConcessionPageUI.NAME_OF_TAB, field);
		clickToElement(driver, SellConcessionPageUI.NAME_OF_TAB, field);	
	}
	
	//REFUND
	@Step("Click To Dropdown Button")
	public void clickToDropdownButton() {
		waitForElementClickable(driver,SellConcessionPageUI.DROPDOWN_BUTTON_OF_ADD_ONS_FIRST);
		clickToElement(driver, SellConcessionPageUI.DROPDOWN_BUTTON_OF_ADD_ONS_FIRST);	
	}

	@Step("Click to value of Dropdown Button {0}")
	public void clickToValueOfDropdown(String value) {
		waitForElementClickable(driver,SellConcessionPageUI.VALUE_OF_DROPDOWN, value);
		clickToElement(driver, SellConcessionPageUI.VALUE_OF_DROPDOWN, value);	
	}
	
	@Step("Choose action of dropdown")
	public void chooseActionOfDropdown(String value) {
		clickToDropdownButton();
		clickToValueOfDropdown(value);
	}
	

	@Step("Click to Select All Refund")
	public void clickToSelectAllRefund() {
		waitForElementClickable(driver,SellConcessionPageUI.SELECT_ALL_REFUND);
		clickToElement(driver, SellConcessionPageUI.SELECT_ALL_REFUND);	
	}

	public boolean isRefundTagDisplay() {
		waitForElementVisible(driver, SellConcessionPageUI.STATUS_OF_ADD_ONS);
		return isElementDisplayed(driver, SellConcessionPageUI.STATUS_OF_ADD_ONS);
	}

	
	
}