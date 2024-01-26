package NopCommerceWeb.NopCommercePO;

import NopCommerceWeb.NopCommercePUIs.MyAccountPUI;
import NopCommerceWeb.NopCommercePUIs.RegisterPUI;
import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
//import pageUIs.user.RegisterPageUI;

public class MyAccountPO extends BasePage {
	private WebDriver driver;

	public MyAccountPO(WebDriver driver) {
		this.driver = driver;
	}

	@Step("click to My Account link")
	public void clickToMyAccountLink() {
		waitForElementClickable(driver, MyAccountPUI.MY_ACCOUNT_LINK);
		clickToElement(driver,MyAccountPUI.MY_ACCOUNT_LINK);
	}

	@Step("click to Customer Info")
	public void clickToSubTab(String tabName) {
		waitForElementClickable(driver, MyAccountPUI.LEFTMENU_MYACCOUNT, tabName);
		clickToElement(driver,MyAccountPUI.LEFTMENU_MYACCOUNT, tabName);
	}

	//Customer Info
	@Step("click to radio button Gender {0}")
	public void chooseGender(String field) {
		waitForElementClickable(driver, MyAccountPUI.RADIO_GENDER, field);
		checkToDefaultCheckboxOrRadio(driver,MyAccountPUI.RADIO_GENDER, field);
	}

	@Step("Input to textbox - {0} {1}")
	public void inputToTextboxCustomerInfo(String field, String value) {
		waitForElementVisible(driver, MyAccountPUI.TEXTBOX_CUSTOMER_INFO, field);
		sendkeyToElement(driver, MyAccountPUI.TEXTBOX_CUSTOMER_INFO, value, field);
	}

	@Step("Select value to dropdown BirthDay - {0}")
	public void selectItemInDayDropdown(String birthDay) {
		waitForElementClickable(driver, MyAccountPUI.DROPDOWN_DAY);
		selectItemInDefaultDropdown(driver, MyAccountPUI.DROPDOWN_DAY, birthDay);
	}

	@Step("Select value to dropdown BirthMonth - {0}")
	public void selectItemInMonthDropdown(String birthMonth) {
		waitForElementClickable(driver, MyAccountPUI.DROPDOWN_MONTH);
		selectItemInDefaultDropdown(driver, MyAccountPUI.DROPDOWN_MONTH, birthMonth);
	}

	@Step("Select value to dropdown BirthYear - {0}")
	public void selectItemInYearDropdown(String birthYear) {
		waitForElementClickable(driver, MyAccountPUI.DROPDOWN_YEAR);
		selectItemInDefaultDropdown(driver, MyAccountPUI.DROPDOWN_YEAR, birthYear);
	}

	@Step("Uncheck checkbox Newsletter")
	public void uncheckNewsletter() {
		waitForElementClickable(driver, MyAccountPUI.CHECKBOX_NEWSLETTER);
		uncheckToDefaultCheckboxRadio(driver, MyAccountPUI.CHECKBOX_NEWSLETTER);
	}

	@Step("Verify update success message")
	public String getUpdateSuccessMessage() {
		waitForElementVisible(driver, MyAccountPUI.MESSAGE_UPDATE_SUCCESS);
		return getElementText(driver, MyAccountPUI.MESSAGE_UPDATE_SUCCESS);
	}

	@Step("click to buttton {0}")
	public void clickToButtonOfLeftMenu(String buttonName) {
		waitForElementClickable(driver, MyAccountPUI.BUTTON_OF_LEFT_MENU, buttonName);
		clickToElement(driver,MyAccountPUI.BUTTON_OF_LEFT_MENU, buttonName);
	}


	//ADD ADDRESS INFO
	@Step("Input to textbox - {0} {1}")
	public void inputToTextboxAddress(String field, String value) {
		waitForElementVisible(driver, MyAccountPUI.TEXTBOX_ADDRESSES, field);
		sendkeyToElement(driver, MyAccountPUI.TEXTBOX_ADDRESSES, value, field);
	}

	@Step("Select value to dropdown Country - {0}")
	public void selectItemInCountryDropdown(String country) {
		waitForElementClickable(driver, MyAccountPUI.DROPDOWN_COUNTRY);
		selectItemInDefaultDropdown(driver, MyAccountPUI.DROPDOWN_COUNTRY, country);
	}

	@Step("Select value to dropdown State - {0}")
	public void selectItemInStateDropdown(String state) {
		waitForElementClickable(driver, MyAccountPUI.DROPDOWN_STATE);
		selectItemInDefaultDropdown(driver, MyAccountPUI.DROPDOWN_STATE, state);
	}

	//CHANGE PASSWORD
	@Step("Input to textbox - {0} {1}")
	public void inputToTextboxChangePassword(String field, String value) {
		waitForElementVisible(driver, MyAccountPUI.TEXTBOX_CHANGE_PASSWORD, field);
		sendkeyToElement(driver, MyAccountPUI.TEXTBOX_CHANGE_PASSWORD, value, field);
	}
}


