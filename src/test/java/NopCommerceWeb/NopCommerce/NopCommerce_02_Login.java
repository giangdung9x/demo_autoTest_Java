package NopCommerceWeb.NopCommerce;
import NopCommerceWeb.NopCommercePO.LoginPO;
import NopCommerceWeb.NopCommercePO.RegisterPO;
import NopCommerceWeb.dataTest.dataTest_Login;
import NopCommerceWeb.dataTest.dataTest_Register;
import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NopCommerce_02_Login extends BaseTest {
    private RegisterPO registerPage;
    private LoginPO loginPage;

    private String email = dataTest_Register.validEmail;
    private String password = dataTest_Register.password;

    @Parameters({ "envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName,
                            @Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String
                                    portNumber, @Optional("Windows") String osName, @Optional("10") String osVersion)
    {
        driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
        registerPage = new RegisterPO(driver);

        registerPage.registerAccount(dataTest_Register.firstName, dataTest_Register.lastName, email, password, password);

        loginPage = new LoginPO(driver);

    }

    @Description("TC_01: Login with empty data")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC_01_Login_Empty_Data() {
        loginPage.clickToLogInLink();
        loginPage.clickToLogInButton();
        assertEquals(loginPage.getErrorMessageAtField("Email"), "Please enter your email");
    }

    @Description("TC_02: Login with invalid email")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC_02_Login_Invalid_Email() {
        loginPage.refreshToPage(driver);
        loginPage.loginAccount(dataTest_Login.invalidEmail,"");
        loginPage.sleepInSecond(3);
        loginPage.clickToLogInButton();
        assertEquals(loginPage.getErrorMessageAtField("Email"), "Wrong email");
    }

    @Description("TC_03: Login with email has not register")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC_03_Login_Email_Not_Register() {
        loginPage.refreshToPage(driver);
        loginPage.loginAccount(dataTest_Login.notRegisterEmail,"");
        loginPage.clickToLogInButton();
        assertEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found");
    }

    @Description("TC_04: Login with email register and not input password")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC_04_Login_Empty_Password() {
        loginPage.refreshToPage(driver);
        loginPage.loginAccount(email,"");
        loginPage.clickToLogInButton();
        assertEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Description("TC_05: Login with email register and input invalid password")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC_05_Login_Invalid_Password() {
        loginPage.refreshToPage(driver);
        loginPage.loginAccount(email,dataTest_Login.invalidPassword);
        loginPage.clickToLogInButton();
        assertEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }

    @Description("TC_06: Login with email register and input valid password")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC_06_Login_Success() {
        loginPage.refreshToPage(driver);
        loginPage.loginAccount(email,password);
        loginPage.clickToLogInButton();
        assertTrue(loginPage.isMyAccountLinkDisplayed());

    }

    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }
}
