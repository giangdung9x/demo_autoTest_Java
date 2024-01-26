package NopCommerceWeb.NopCommerce;

import NopCommerceWeb.NopCommercePO.RegisterPO;
import NopCommerceWeb.dataTest.dataTest_Register;
import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import static org.testng.Assert.assertEquals;

public class NopCommerce_01_Register extends BaseTest {

    private RegisterPO registerPage;
    @Parameters({ "envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName,
                            @Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String
                                    portNumber, @Optional("Windows") String osName, @Optional("10") String osVersion)
    {
        driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
        registerPage = new RegisterPO(driver);

    }

    @Description("TC_01: Register with empty data")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC_01_Register_Empty_Data() {

        //Switch to the Registration screen
        registerPage.clickToRegisterLink();
        registerPage.clickToRegisterButton();

        //verify error message in each field - verify text
        assertEquals(registerPage.getErrorMessage("FirstName-error"), "First name is required.");
        assertEquals(registerPage.getErrorMessage("LastName-error"), "Last name is required.");
        assertEquals(registerPage.getErrorMessage("Email-error"), "Email is required.");
        assertEquals(registerPage.getErrorMessage("Password-error"), "Password is required.");
        assertEquals(registerPage.getErrorMessage("ConfirmPassword-error"), "Password is required.");
    }

    @Description("TC_02: Register with invalid email")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC_02_Register_Invalid_Email() {
        registerPage.refreshToPage(driver);
        registerPage.chooseGender(dataTest_Register.genderFemale);
        registerPage.inputToTextboxRegister("First name:", dataTest_Register.firstName );
        registerPage.inputToTextboxRegister("Last name:", dataTest_Register.lastName);
        registerPage.inputToTextboxRegister("Email:", dataTest_Register.invalidEmail);
        registerPage.inputToTextboxRegister("Password:", dataTest_Register.password);
        registerPage.inputToTextboxRegister("Confirm password:", dataTest_Register.confirmPassword);
        registerPage.clickToRegisterButton();
        assertEquals(registerPage.getErrorMessageHeader(), "Wrong email");
    }

    @Description("TC_03: Register with valid information")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC_03_Register_Success() {
        registerPage.refreshToPage(driver);
        registerPage.chooseGender(dataTest_Register.genderFemale);
        registerPage.inputToTextboxRegister("First name:", dataTest_Register.firstName );
        registerPage.inputToTextboxRegister("Last name:", dataTest_Register.lastName);
        registerPage.selectItemInDayDropdown(dataTest_Register.dayBirthday);
        registerPage.selectItemInMonthDropdown(dataTest_Register.mothBirthday);
        registerPage.selectItemInYearDropdown(dataTest_Register.yearBirthday);
        registerPage.inputToTextboxRegister("Email:", dataTest_Register.validEmail);
        registerPage.inputToTextboxRegister("Company name:", dataTest_Register.companyName);
        registerPage.uncheckNewsletter();
        registerPage.inputToTextboxRegister("Password:", dataTest_Register.password);
        registerPage.inputToTextboxRegister("Confirm password:", dataTest_Register.confirmPassword);

        registerPage.clickToRegisterButton();
        assertEquals(registerPage.getSuccessMessage(), "Your registration completed");
        registerPage.clickToContinueButton();
    }

    @Description("TC_04: Register with an existing email")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC_04_Register_Existing_Email() {
        registerPage.refreshToPage(driver);
        registerPage.clickToRegisterLink();
        registerPage.inputToTextboxRegister("First name:", dataTest_Register.firstName );
        registerPage.inputToTextboxRegister("Last name:", dataTest_Register.lastName);
        registerPage.inputToTextboxRegister("Email:", dataTest_Register.validEmail);
        registerPage.inputToTextboxRegister("Password:", dataTest_Register.password);
        registerPage.inputToTextboxRegister("Confirm password:", dataTest_Register.confirmPassword);

        registerPage.clickToRegisterButton();
        assertEquals(registerPage.getErrorMessageHeader(), "The specified email already exists");
    }

    @Description("TC_05: Register with password < 6 characters")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC_05_Register_Password_Less_Than_6_Chars() {
        registerPage.refreshToPage(driver);
        registerPage.inputToTextboxRegister("First name:", dataTest_Register.firstName );
        registerPage.inputToTextboxRegister("Last name:", dataTest_Register.lastName);
        registerPage.inputToTextboxRegister("Email:", dataTest_Register.validEmail);
        registerPage.inputToTextboxRegister("Password:", dataTest_Register.invalidpassword);
        registerPage.inputToTextboxRegister("Confirm password:", dataTest_Register.confirmPassword);

        registerPage.clickToRegisterButton();
        assertEquals(registerPage.getErrorMessage("Password-error"), "Password must meet the following rules:\n" +
                "must have at least 6 characters");
    }

    @Description("TC_06: Register with confirm password does not match password")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC_06_Register_Invalid_Confirm_Password() {
        registerPage.refreshToPage(driver);
        registerPage.inputToTextboxRegister("First name:", dataTest_Register.firstName );
        registerPage.inputToTextboxRegister("Last name:", dataTest_Register.lastName);
        registerPage.inputToTextboxRegister("Email:", dataTest_Register.validEmailTest);
        registerPage.inputToTextboxRegister("Password:", dataTest_Register.password);
        registerPage.inputToTextboxRegister("Confirm password:", dataTest_Register.confirmPasswordInvalid);

        registerPage.clickToRegisterButton();
        assertEquals(registerPage.getErrorMessage("ConfirmPassword-error"), "The password and confirmation password do not match.");
    }


    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }

}
