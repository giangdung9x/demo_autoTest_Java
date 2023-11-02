package pageObject.user;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//import org.apache.hc.core5.http2.frame.StreamIdGenerator;
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
import pageUIs.user.AttendeePageUI;
import pageUIs.user.SellConcessionPageUI;
import pageUIs.user.HomePageUI;


public class UserAttendeePageObject extends BasePage{

	private WebDriver driver;

	public UserAttendeePageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click to button Login")
	public void clickToLoginLink() {
		waitForElementClickable(driver,AttendeePageUI.LOGIN_LINK);
		clickToElement(driver, AttendeePageUI.LOGIN_LINK);
	}

	@Step("Input to Textbox Login {0} {1}")
	public void inputToTextboxLogin(String field, String value) {
		waitForElementVisible(driver, AttendeePageUI.TEXTBOX_LOGIN, field);
		sendkeyToElement(driver, AttendeePageUI.TEXTBOX_LOGIN, value, field);
	}

	@Step("Login Account {0} {1}")
	public void loginAccount(String email, String password) {
		inputToTextboxLogin("email", email);
		inputToTextboxLogin("password", password);
	}

	@Step("Click to button - Login")
	public void clickToLoginButton() {
		waitForElementClickable(driver,AttendeePageUI.LOGIN_BUTTON);
		clickToElement(driver, AttendeePageUI.LOGIN_BUTTON);
	}

	@Step("Verify name of screen - {0}")
	public boolean isTextNameOfScreenDisplayed(String nameOfScreen) {
		waitForElementVisible(driver, AttendeePageUI.NAME_OF_SCREEN, nameOfScreen);
		return isElementDisplayed(driver, AttendeePageUI.NAME_OF_SCREEN, nameOfScreen);
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

	@Step("Click to items of List Ticketing - {0}")
	public void clickToItemOfListTicketing(String items) {
		waitForElementClickable(driver,AttendeePageUI.ITEMS_OF_LIST_TICKETING, items);
		clickToElement(driver, AttendeePageUI.ITEMS_OF_LIST_TICKETING, items);
	}

	@Step("Input value search bar {0}")
	public void searchOrder(String value) {
		waitForElementVisible(driver, AttendeePageUI.SEARCH_REPORT_BAR);
		sendkeyToElement(driver, AttendeePageUI.SEARCH_REPORT_BAR, value+ Keys.ENTER);
	}

	@Step("Select Action {0} item in dropdown")
	public void selectTextItemActionDropdown(String dropdownItem) {
		waitForElementClickable(driver, AttendeePageUI.ACTION_DROPDOWN);
		selectItemInDefaultDropdown(driver, AttendeePageUI.ACTION_DROPDOWN, dropdownItem);
	}

	@Step("Click to Action Button")
	public void clickToActionButton() {
		waitForElementClickable(driver,AttendeePageUI.ACTION_BUTTON);
		clickToElement(driver, AttendeePageUI.ACTION_BUTTON);
	}

	@Step("Select Action {0} item in dropdown")
	public void selectTextItemFiterByStatusDropdown(String dropdownItem) {
		waitForElementClickable(driver, AttendeePageUI.FITER_ORDER_BY_STATUS_DROPDOWN);
		selectItemInDefaultDropdown(driver, AttendeePageUI.FITER_ORDER_BY_STATUS_DROPDOWN, dropdownItem);
	}

	@Step("Select Order checkbox")
	public void selectOrderFirstCheckbox(String rowNumber) {
		waitForElementClickable(driver,AttendeePageUI.CHECKBOX_OF_ORDER_BY_NUMERICAL, rowNumber);
		checkToDefaultCheckboxOrRadio(driver,AttendeePageUI.CHECKBOX_OF_ORDER_BY_NUMERICAL, rowNumber);
	}

	@Step("Verify name of popup {0}")
	public String getNameOfPopup(String namePopup) {
		waitForElementVisible(driver, AttendeePageUI.NAME_OF_POPUP,namePopup );
		return getElementText(driver,AttendeePageUI.NAME_OF_POPUP,namePopup );
	}

	@Step("Select quantity ticket {0} of current event")
	public void selectQuantityTicketOfCurrentEventDropdown(String dropdownItem) {
		waitForElementClickable(driver, AttendeePageUI.DROPDOWN_TICKET_OF_CURRENT_EVENT);
		selectItemInDefaultDropdown(driver, AttendeePageUI.DROPDOWN_TICKET_OF_CURRENT_EVENT, dropdownItem);
	}

	@Step("Select event transfer {0}")
	public void selectEventTransferToDropdown(String eventName) {
		clickToDropdownEventOfPopupTransfer();
		clickToEventTransferTo(eventName);
	}

	@Step("Click to Dropdown Event")
	public void clickToDropdownEventOfPopupTransfer() {
		waitForElementClickable(driver,AttendeePageUI.DROPDOWN_EVENT_TRANSFER_TO);
		clickToElement(driver, AttendeePageUI.DROPDOWN_EVENT_TRANSFER_TO);
	}

	@Step("Click to Dropdown Event")
	public void clickToEventTransferTo(String eventName) {
		waitForElementClickable(driver,AttendeePageUI.EVENT_NAME_OF_DROPDOWN, eventName);
		clickToElement(driver, AttendeePageUI.EVENT_NAME_OF_DROPDOWN, eventName);
	}

	@Step("Select quantity ticket {0} of transfer to event")
	public void selectQuantityTicketOfTransferEventDropdown(String dropdownItem) {
		waitForElementClickable(driver, AttendeePageUI.DROPDOWN_TICKET_OF_TRANSFER_EVENT_TO);
		selectItemInDefaultDropdown(driver, AttendeePageUI.DROPDOWN_TICKET_OF_TRANSFER_EVENT_TO, dropdownItem);
	}

	@Step("Click to Transfer Button")
	public void clickToTransferButton() {
		waitForElementClickable(driver,AttendeePageUI.BUTTON_TRANSFER);
		clickToElement(driver, AttendeePageUI.BUTTON_TRANSFER);
	}

	@Step("Verify message transfer order")
	public String getMessageTranferRessult() {
		waitForElementVisible(driver, AttendeePageUI.MESSAGE_RESULT);
		return getElementText(driver,AttendeePageUI.MESSAGE_RESULT);
	}

	@Step("Verify message refund order")
	public String getMessageRefundRessult() {
		waitForElementVisible(driver, AttendeePageUI.MESSAGE_RESULT_REFUND);
		return getElementText(driver,AttendeePageUI.MESSAGE_RESULT_REFUND);
	}

	@Step("Click to Button {0}")
	public void clickToTransferButton(String buttonPopup) {
		waitForElementClickable(driver,AttendeePageUI.BUTTON_REFUND, buttonPopup);
		clickToElement(driver, AttendeePageUI.BUTTON_REFUND, buttonPopup);
	}

	@Step("Verify error message of popup")
	public String getMessageOfPopup() {
		waitForElementVisible(driver, AttendeePageUI.MESSAGE_POPUP);
		return getElementText(driver,AttendeePageUI.MESSAGE_POPUP);
	}

	@Step("Select quantity ticket {0} Partial Refund(")
	public void selectQuantityTicketPartialRefund(String dropdownItem) {
		waitForElementClickable(driver, AttendeePageUI.QUANTITY_TICKET_PARTIAL_REFUND);
		selectItemInDefaultDropdown(driver, AttendeePageUI.QUANTITY_TICKET_PARTIAL_REFUND, dropdownItem);
	}
}