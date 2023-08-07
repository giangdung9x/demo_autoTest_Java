package showslinger_user;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.user.UserPublicKioskObject;
import java.util.Random;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import org.openqa.selenium.JavascriptExecutor;


@Test(enabled = false)
public class Public_Kiosk_Page extends BaseTest{
	private UserPublicKioskObject publicKioskPage;
	private String emailManager, passwordManager;
	private String accessCodeInvalid, accessCodeValid, nameOfBuyer, phoneNumber, textItem;
	private String eventName, printerName, paperName, ticketName, quantityTicket, eventNameSelected;


	@Parameters({ "envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName,
	@Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String
	portNumber,@Optional("Windows") String osName, @Optional("10") String osVersion) {
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
		publicKioskPage = new UserPublicKioskObject(driver);
		
		emailManager ="paulv@showslinger.com";
		passwordManager = "12345";
		
		accessCodeInvalid = "abcd";
		accessCodeValid ="city";
		nameOfBuyer = "Dang Giang";
		phoneNumber = "0" + generateFakeNumber();
		eventName ="Giang Test auto";
		eventNameSelected ="Giang Test auto";
		
		printerName ="Canon LBP2900 (DESKTOP-VMJ4FSM)";
		paperName ="A4";
		ticketName ="vip3";
		quantityTicket ="1";
	}
	

	
	@Description("Config Kiosk - Open 'Config Kiosk")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void ConfigKiosk_001_OpenConfigKiosk() {
		publicKioskPage.clickToLoginLink();
		publicKioskPage.loginAccount(emailManager,passwordManager);
		publicKioskPage.clickToLoginButton();
		publicKioskPage.clickShowLeftMenu();
		String managerWindowID = driver.getWindowHandle();
		publicKioskPage.clickToItemOfLeftMenu("Public kiosk");
		driver.close();
		publicKioskPage.switchToWindowByID(managerWindowID);
		assertTrue(publicKioskPage.isTextPleaseChooseEventDisplayed());
		publicKioskPage.clickToButtonConfigKiosk();
	}

	@Description("Config Kiosk - button 'Back to kiosk' ")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void ConfigKiosk_002_ButtonBackToKiosk() {
		publicKioskPage.clickToButtonBackToKiosk();

		assertTrue(publicKioskPage.isButtonConfigKioskDisplayed());
		assertTrue(publicKioskPage.isTextPleaseChooseEventDisplayed());
	}

	@Description("Config Kiosk - Enter code of Config Kiosk is empty")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3)
	public void ConfigKiosk_003_EnterCodeEmpty() {
		publicKioskPage.clickToButtonConfigKiosk();

		assertTrue(publicKioskPage.isTextEnterCodeAccessDisplayed());

		publicKioskPage.clickToButtonConfirmCode();

	}

	@Description("Config Kiosk - Enter code of Config Kiosk is incorrect")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 4)
	public void ConfigKiosk_004_EnterCodeIncorrect() {
		publicKioskPage.inputCodeAccessConfigKiosk(accessCodeInvalid);

		publicKioskPage.clickToButtonConfirmCode();

		assertEquals(publicKioskPage.getErrorMessageAtHeader(),"Config code incorrect!");
	}

	@Description("Config Kiosk - Enter code of Config Kiosk is correct")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 5)
	public void ConfigKiosk_005_EnterCodeCorrect() {
		publicKioskPage.inputCodeAccessConfigKiosk(accessCodeValid);

		publicKioskPage.clickToButtonConfirmCode();

		assertTrue(publicKioskPage.isTextConfigKioskDisplayed());

	}

	@Description("Config Kiosk - Config to Kiosk")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 6)
	public void ConfigKiosk_006_ConfigToKiosk() {
		assertTrue(publicKioskPage.isTextComputerPrinterDisplayed());
		assertTrue(publicKioskPage.isTextSelectDefaultPrintersDisplayed());
		assertTrue(publicKioskPage.isTextCardReaderDisplayed());
		assertTrue(publicKioskPage.isTextReportDisplayed());

		publicKioskPage.sleepInSecond(5);
		publicKioskPage.clickToDropDownSelectPrinter();
		publicKioskPage.clickToValueOfDropdownSelectPrinter(printerName);

		assertTrue(publicKioskPage.isTextSelectdefaultPaperDisplayed());

		publicKioskPage.clickToDropDownSelectPaper();
		publicKioskPage.clickToValueOfDropdownSelectPaper(paperName);

		publicKioskPage.clickToButtonReset();
		publicKioskPage.acceptAlertReport();

		assertEquals(publicKioskPage.getValueTixSold(),"N/A");
		assertEquals(publicKioskPage.getValueTotalAmount(),"N/A");

		publicKioskPage.clickToButtonReset();
		publicKioskPage.cancelAlertReport();

		assertEquals(publicKioskPage.getValueTixSold(),"N/A");
		assertEquals(publicKioskPage.getValueTotalAmount(),"N/A");

		publicKioskPage.clickToButtonBackToKiosk();

		assertTrue(publicKioskPage.isTextPleaseChooseEventDisplayed());
	}


	@Description("Checkout - Select Event of Public Kiosk")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 7)
	public void Checkout_001_SelectEvent() {
		String eventName = publicKioskPage.getNameOfEventFromScreenSelectEvent(eventNameSelected);

		publicKioskPage.clickToChooseEventName(eventNameSelected);

		assertTrue(publicKioskPage.isTextOrderDisplayed());
		assertEquals(publicKioskPage.getNameOfEventFromCheckoutScreen(),eventName);
	}

	@Description("Checkout - Checkout when empty data - Name")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 8)
	public void Checkout_002_CheckoutEmptyDataName() {
		publicKioskPage.clickToButtonCheckout();

		assertEquals(publicKioskPage.getErrorMessageCheckoutEmptyData(),"Please enter your name");
	}


	@Description("Checkout - Checkout when empty data - Phone")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 9)
	public void Checkout_003_CheckoutEmptyDataPhone() {
		publicKioskPage.inputInfoBuyer("Name", nameOfBuyer);

		publicKioskPage.clickToButtonCheckout();

		assertEquals(publicKioskPage.getErrorMessageCheckoutEmptyData(),"Please enter your phone number");
	}

	@Description("Checkout - Checkout when empty data - Quantity")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 10)
	public void Checkout_004_CheckoutEmptyDataQuantity() {
		publicKioskPage.inputInfoBuyer("Name", nameOfBuyer);
		publicKioskPage.inputInfoBuyer("Phone", phoneNumber);

		publicKioskPage.clickToButtonCheckout();

		assertEquals(publicKioskPage.getErrorMessageCheckoutEmptyData(),"Please select at least one ticket");

	}
	
	@Description("Checkout - Checkout when input valid data")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 11)
	public void Checkout_005_CheckoutInputValidData() {
		publicKioskPage.clickToDropDownSelectQuantityTicket(ticketName, "2");
		publicKioskPage.inputInfoBuyer("Name", nameOfBuyer);
		publicKioskPage.inputInfoBuyer("Phone", phoneNumber);

		publicKioskPage.clickToButtonCheckout();

		assertTrue(publicKioskPage.isTextCheckoutDisplayed());
	}
	
	@Description("Checkout - Charge Card Other Internet")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 12)
	public void Checkout_006_ChargeCardOrtherInternet() {

	}
	
	@Description("Checkout - Charge Card As Like Internet")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 13)
	public void Checkout_007_ChargeCardAsLikeInternet() {
		publicKioskPage.clickToChooseCardReader("ss-reader");
		//publicKioskPage.clickToRadioButtonCardReader();
		publicKioskPage.clickToButtonChargeCard();
		
		assertTrue(publicKioskPage.isTextTapToInsertPayment());
		assertTrue(publicKioskPage.isTextSuccessPleaseWait());
		assertTrue(publicKioskPage.isTextPleaseTakeYourTickets());
		
		assertTrue(publicKioskPage.isTextOrderDisplayed());

		publicKioskPage.clickToKiosk();
		
		assertTrue(publicKioskPage.isTextPleaseChooseEventDisplayed());

		publicKioskPage.clickToButtonConfigKiosk();
		publicKioskPage.inputCodeAccessConfigKiosk(accessCodeValid);
		publicKioskPage.clickToButtonConfirmCode();

		publicKioskPage.clickToRadioButtonCardReaderFromConfig();
		
		publicKioskPage.clickToButtonBackToKiosk();
		
		publicKioskPage.clickToChooseEventName(eventNameSelected);

		publicKioskPage.inputInfoBuyer("Name", nameOfBuyer);
		publicKioskPage.inputInfoBuyer("Phone", phoneNumber);
		publicKioskPage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
		publicKioskPage.clickToButtonCheckout();
		assertTrue(publicKioskPage.isTextTapToInsertPayment());
		assertTrue(publicKioskPage.isTextSuccessPleaseWait());
		assertTrue(publicKioskPage.isTextPleaseTakeYourTickets());
		
		assertTrue(publicKioskPage.isTextOrderDisplayed());
	}
	
	@Description("Checkout - Payment Method Declined")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 14)
	public void Checkout_008_PaymentMethodDeclined() {
		publicKioskPage.inputInfoBuyer("Name", nameOfBuyer);
		publicKioskPage.inputInfoBuyer("Phone", phoneNumber);
		publicKioskPage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
		
		publicKioskPage.clickToButtonCheckout();
		
		assertTrue(publicKioskPage.isTextCheckoutDisplayed());

		publicKioskPage.clickToButtonCancelPayment();

		assertTrue(publicKioskPage.isTextPaymentMethodDeclined());
		
		assertTrue(publicKioskPage.isTextOrderDisplayed());
		
		publicKioskPage.inputInfoBuyer("Name", nameOfBuyer);
		publicKioskPage.inputInfoBuyer("Phone", phoneNumber);
		publicKioskPage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
		publicKioskPage.clickToButtonCheckout();

		publicKioskPage.clickToButtonCancelPayment();

		assertTrue(publicKioskPage.isTextPaymentMethodDeclined());
		
		publicKioskPage.clickToButtonBack();
		
		assertTrue(publicKioskPage.isTextOrderDisplayed());
	}
	
	@Description("Checkout - Check button Kiosk of Payment screen")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 15)
	public void Checkout_009_CheckButtonKiosk() {
		publicKioskPage.inputInfoBuyer("Name", nameOfBuyer);
		publicKioskPage.inputInfoBuyer("Phone", phoneNumber);
		publicKioskPage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
		publicKioskPage.clickToButtonCheckout();
		publicKioskPage.clickToKioskButtonPaymentScreen();
	}
	

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(999999999);

	}

}
