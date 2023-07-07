package pageObject.user;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.hc.core5.http2.frame.StreamIdGenerator;
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
import pageUIs.user.ReportPageUI;
import pageUIs.user.SellConcessionPageUI;
import pageUIs.user.HomePageUI;


public class UserReportPageObject extends BasePage{

	private WebDriver driver;

	public UserReportPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click to button Login")
	public void clickToLoginLink() {
		waitForElementClickable(driver,ReportPageUI.LOGIN_LINK);
		clickToElement(driver, ReportPageUI.LOGIN_LINK);		
	}

	@Step("Input to Textbox Login {0} {1}")
	public void inputToTextboxLogin(String field, String value) {
		waitForElementVisible(driver, ReportPageUI.TEXTBOX_LOGIN, field);
		sendkeyToElement(driver, ReportPageUI.TEXTBOX_LOGIN, value, field);		
	}

	@Step("Login Account {0} {1}")
	public void loginAccount(String email, String password) {
		inputToTextboxLogin("email", email);
		inputToTextboxLogin("password", password);
	}

	@Step("Click to button - Login")
	public void clickToLoginButton() {
		waitForElementClickable(driver,ReportPageUI.LOGIN_BUTTON);
		clickToElement(driver, ReportPageUI.LOGIN_BUTTON);	
	}

	@Step("Verify name of screen - {0}")
	public boolean isTextNameOfScreenDisplayed(String nameOfScreen) {
		waitForElementVisible(driver, ReportPageUI.NAME_OF_SCREEN, nameOfScreen);
		return isElementDisplayed(driver, ReportPageUI.NAME_OF_SCREEN, nameOfScreen);
	}
	
	@Step("Click open Left Menu")
	public void clickShowLeftMenu() {
		waitForElementClickable(driver,BoxOfficePageUI.LEFT_MENU_BUTTON);
		clickToElement(driver, BoxOfficePageUI.LEFT_MENU_BUTTON);	
	}

	@Step("Click to items of Left Menu - {0}")
	public void clickToItemOfLeftMenu(String items) {
		waitForElementClickable(driver,ReportPageUI.ITEMS_LEFT_MENU, items);
		clickToElement(driver, ReportPageUI.ITEMS_LEFT_MENU, items);	
	}
	
	@Step("Click to items of List Ticketing - {0}")
	public void clickToItemOfListTicketing(String items) {
		waitForElementClickable(driver,ReportPageUI.ITEMS_OF_LIST_TICKETING, items);
		clickToElement(driver, ReportPageUI.ITEMS_OF_LIST_TICKETING, items);	
	}
	
	@Step("Input value search bar {0}")
	public void searchEventName(String value) {
		waitForElementVisible(driver, ReportPageUI.SEARCH_REPORT_BAR);
		sendkeyToElement(driver, ReportPageUI.SEARCH_REPORT_BAR, value+ Keys.ENTER);		
	}
	
	@Step("Click to items of event - {0} {1}")
	public void clickToActionMenuOfEvent(String eventName, String action) {
		waitForElementClickable(driver,ReportPageUI.ACTION_DROPDOWN_BUTTON, eventName);
		clickToElement(driver, ReportPageUI.ACTION_DROPDOWN_BUTTON, eventName);	
		
		waitForElementClickable(driver,ReportPageUI.ITEMS_OF_DROPDOWN, action);
		clickToElement(driver, ReportPageUI.ITEMS_OF_DROPDOWN, action);	
	}
	
	//CHECK VALUE REPORT
	@Step("Get value of tag Overview {0} {1} {0}")
	public double getValueOfTagOverview(String tagName, String rowName) {
	    waitForElementVisible(driver, ReportPageUI.VALUE_OF_OVERVIEW_TAG, tagName, rowName);
	    String amountTotalAfter = getElementText(driver, ReportPageUI.VALUE_OF_OVERVIEW_TAG, tagName, rowName);
	    String amountText = amountTotalAfter.replace("$", "").replace(",", "");

	    if (amountText.isEmpty() || amountText.equals("--")) {
	        return 0;
	    }

	    return Double.parseDouble(amountText);
	}

	
	@Step("Get value of tag Overview {0} {1} {0}")
	public double getValueOfTag(String tagName, String valueOfTag, String valueRowColumn) {
	    waitForElementVisible(driver, ReportPageUI.VALUE_OF_TAG, tagName, valueOfTag, valueRowColumn);
	    String amountTotalAfter = getElementText(driver, ReportPageUI.VALUE_OF_TAG, tagName, valueOfTag, valueRowColumn);
	    String amountText = amountTotalAfter.replace("$", "").replace(",", "");

	    if (amountText.isEmpty() || amountText.equals("--")) {
	        return 0;
	    }

	    return Double.parseDouble(amountText);
	}
	
	@Step("Get value of tag Overview {0} {1} {0}")
	public double getValueTotalOfTag(String tagName, String valueOfTag, String valueRowColumn) {
	    waitForElementVisible(driver, ReportPageUI.TOTAL_VALUE_OF_TAG, tagName, valueOfTag, valueRowColumn);
	    String amountTotalAfter = getElementText(driver, ReportPageUI.TOTAL_VALUE_OF_TAG, tagName, valueOfTag, valueRowColumn);
	    String amountText = amountTotalAfter.replace("$", "").replace(",", "");

	    if (amountText.isEmpty() || amountText.equals("--")) {
	        return 0;
	    }

	    return Double.parseDouble(amountText);
	}
	
	@Step("Compare Value {0} {1}")
	public boolean compareValues(double value1, double value2) {
	    return Double.compare(value1, value2) == 0;
	}
	
}