package NopCommerceWeb.NopCommercePO;

import NopCommerceWeb.NopCommercePUIs.RegisterPUI;
import NopCommerceWeb.dataTest.dataTest_Register;
import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

import static org.testng.Assert.assertEquals;
//import pageUIs.user.RegisterPageUI;

public class RegisterPO extends BasePage {
	private WebDriver driver;

	public RegisterPO(WebDriver driver) {
		this.driver = driver;
	}

	@Step("click to Register link")
	public void clickToRegisterLink() {
		waitForElementClickable(driver, RegisterPUI.REGISTER_LINK);
		clickToElement(driver,RegisterPUI.REGISTER_LINK);
	}

	@Step("click to Register buttton")
	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPUI.REGISTER_BUTTON);
		clickToElement(driver,RegisterPUI.REGISTER_BUTTON);
	}

	@Step("Verify error message {0}")
	public String getErrorMessage(String field) {
		waitForElementVisible(driver, RegisterPUI.ERROR_MESSAGE, field);
		return getElementText(driver, RegisterPUI.ERROR_MESSAGE, field);
	}

	@Step("click to radio button Gender {0}")
	public void chooseGender(String field) {
		waitForElementClickable(driver, RegisterPUI.RADIO_GENDER, field);
		checkToDefaultCheckboxOrRadio(driver,RegisterPUI.RADIO_GENDER, field);
	}

	@Step("Input to textbox - {0} {1}")
	public void inputToTextboxRegister(String field, String value) {
		waitForElementVisible(driver, RegisterPUI.TEXTBOX_REGISTER, field);
		sendkeyToElement(driver, RegisterPUI.TEXTBOX_REGISTER, value, field);
	}

	@Step("Select value to dropdown BirthDay - {0}")
	public void selectItemInDayDropdown(String birthDay) {
		waitForElementClickable(driver, RegisterPUI.DROPDOWN_DAY);
		selectItemInDefaultDropdown(driver, RegisterPUI.DROPDOWN_DAY, birthDay);
	}

	@Step("Select value to dropdown BirthMonth - {0}")
	public void selectItemInMonthDropdown(String birthMonth) {
		waitForElementClickable(driver, RegisterPUI.DROPDOWN_MONTH);
		selectItemInDefaultDropdown(driver, RegisterPUI.DROPDOWN_MONTH, birthMonth);
	}

	@Step("Select value to dropdown BirthYear - {0}")
	public void selectItemInYearDropdown(String birthYear) {
		waitForElementClickable(driver, RegisterPUI.DROPDOWN_YEAR);
		selectItemInDefaultDropdown(driver, RegisterPUI.DROPDOWN_YEAR, birthYear);
	}

	@Step("Uncheck checkbox Newsletter")
	public void uncheckNewsletter() {
		waitForElementClickable(driver, RegisterPUI.CHECKBOX_NEWSLETTER);
		uncheckToDefaultCheckboxRadio(driver, RegisterPUI.CHECKBOX_NEWSLETTER);
	}

	@Step("Verify register success message")
	public String getSuccessMessage() {
		waitForElementVisible(driver, RegisterPUI.MESSAGE_REGISTER_SUCCESS);
		return getElementText(driver, RegisterPUI.MESSAGE_REGISTER_SUCCESS);
	}

	@Step("click to Continue buttton")
	public void clickToContinueButton() {
		waitForElementClickable(driver, RegisterPUI.CONTINUE_BUTTON);
		clickToElement(driver,RegisterPUI.CONTINUE_BUTTON);
	}

	@Step("Verify error message - email exist")
	public String getErrorMessageHeader() {
		waitForElementVisible(driver, RegisterPUI.ERROR_MESSAGE_EMAIL_EXISTS);
		return getElementText(driver, RegisterPUI.ERROR_MESSAGE_EMAIL_EXISTS);
	}

	@Step("Register Account {0} {1} {2} {3}")
	public void registerAccount(String firstName, String lastName, String email, String password, String confirmPass) {
		clickToRegisterLink();
		clickToRegisterButton();
		inputToTextboxRegister("First name:", firstName );
		inputToTextboxRegister("Last name:", lastName);
		inputToTextboxRegister("Email:", email);
		inputToTextboxRegister("Password:", password);
		inputToTextboxRegister("Confirm password:", confirmPass);
		clickToRegisterButton();
		assertEquals(getSuccessMessage(), "Your registration completed");
		clickToContinueButton();
	}

}


