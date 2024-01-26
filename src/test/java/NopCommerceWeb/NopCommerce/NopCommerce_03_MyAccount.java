package NopCommerceWeb.NopCommerce;

import NopCommerceWeb.NopCommercePO.LoginPO;
import NopCommerceWeb.NopCommercePO.MyAccountPO;
import NopCommerceWeb.NopCommercePO.RegisterPO;
import NopCommerceWeb.dataTest.dataTest_MyAccount;
import NopCommerceWeb.dataTest.dataTest_Register;
import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NopCommerce_03_MyAccount extends BaseTest {
    private LoginPO loginPage;
    private RegisterPO registerPage;
    private MyAccountPO myAccountPage;

    private String email = dataTest_Register.validEmail;
    private String password = dataTest_Register.password;

    @Parameters({ "envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName,
                            @Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String
                                    portNumber, @Optional("Windows") String osName, @Optional("10") String osVersion) {
        driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
        //Register account
        registerPage = new RegisterPO(driver);
        registerPage.registerAccount(dataTest_Register.firstName, dataTest_Register.lastName, email, password, password);

        //Login acccount
        loginPage = new LoginPO(driver);
        loginPage.loginAccountFull(email,password);

        myAccountPage = new MyAccountPO(driver);
    }

    @Description("TC_01: Update Customer Info")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC_01_Update_Customer_Info() {
        myAccountPage.clickToMyAccountLink();
        myAccountPage.clickToSubTab("Customer info");
        myAccountPage.chooseGender(dataTest_MyAccount.genderFemale);
        myAccountPage.inputToTextboxCustomerInfo("First name:", dataTest_MyAccount.firstName );
        myAccountPage.inputToTextboxCustomerInfo("Last name:", dataTest_MyAccount.lastName);
        myAccountPage.selectItemInDayDropdown(dataTest_MyAccount.dayBirthday);
        myAccountPage.selectItemInMonthDropdown(dataTest_MyAccount.mothBirthday);
        myAccountPage.selectItemInYearDropdown(dataTest_MyAccount.yearBirthday);
        myAccountPage.inputToTextboxCustomerInfo("Email:", dataTest_MyAccount.validEmail);
        myAccountPage.inputToTextboxCustomerInfo("Company name:", dataTest_MyAccount.companyName);
        myAccountPage.uncheckNewsletter();

        myAccountPage.clickToButtonOfLeftMenu("Save");

        //verify message update success
        assertEquals(myAccountPage.getUpdateSuccessMessage(), "The customer info has been updated successfully.");
        myAccountPage.refreshToPage(driver);
    }

    @Description("TC_02: Add Address Info")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC_02_Add_Address_Info() {
        myAccountPage.clickToSubTab("Addresses");
        myAccountPage.clickToButtonOfLeftMenu("Add new");

        myAccountPage.inputToTextboxAddress("First name:", "Giang");
        myAccountPage.inputToTextboxAddress("Last name:", "Dang");
        myAccountPage.inputToTextboxAddress("Email:", "dangthigiang@mobilefolk.com");
        myAccountPage.inputToTextboxAddress("Company:", "MF");
        myAccountPage.selectItemInCountryDropdown("Canada");
        myAccountPage.sleepInSecond(3);
        myAccountPage.selectItemInStateDropdown("Alberta");
        myAccountPage.inputToTextboxAddress("City:", "ABC");
        myAccountPage.inputToTextboxAddress("Address 1:", "DEF");
        myAccountPage.inputToTextboxAddress("Address 2:", "XYZ");
        myAccountPage.inputToTextboxAddress("Zip / postal code:", "123456");
        myAccountPage.inputToTextboxAddress("Phone number:", "+10123456789");
        myAccountPage.inputToTextboxAddress("Fax number:", "234213324124");

        myAccountPage.clickToButtonOfLeftMenu("Save");

        //verify message update success
        assertEquals(myAccountPage.getUpdateSuccessMessage(), "The new address has been added successfully.");
        myAccountPage.refreshToPage(driver);

    }

    @Description("TC_03: Change Password")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC_03_Change_Password() {
        myAccountPage.clickToSubTab("Change password");
        myAccountPage.inputToTextboxChangePassword("Old password:", dataTest_Register.password);
        myAccountPage.inputToTextboxChangePassword("New password:", dataTest_MyAccount.newPassword);
        myAccountPage.inputToTextboxChangePassword("Confirm password:", dataTest_MyAccount.newPassword);

        myAccountPage.clickToButtonOfLeftMenu("Change password");
        //verify message update success
        assertEquals(myAccountPage.getUpdateSuccessMessage(), "Password was changed");
        myAccountPage.refreshToPage(driver);

        loginPage = new LoginPO(driver);
        loginPage.loginAccount(dataTest_MyAccount.validEmail,password);
        loginPage.clickToLogInButton();
        assertEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");


        loginPage.loginAccountFull(dataTest_MyAccount.validEmail,dataTest_MyAccount.newPassword);
    }



    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
