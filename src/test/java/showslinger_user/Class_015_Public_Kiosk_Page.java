package showslinger_user;

import commons.BaseTest;
import commons.ConfigOnOffTestcase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

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


public class Class_015_Public_Kiosk_Page extends BaseTest{
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
	@Test
	public void TCs_001_ConfigKiosk_001_OpenConfigKiosk() {
		if(ConfigOnOffTestcase.isPublicKioskOn){
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
		} else {
			System.out.println("Public Kiosk not use");
		}

	}

	@Description("Config Kiosk - button 'Back to kiosk' ")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_002_ConfigKiosk_002_ButtonBackToKiosk() {
		if(ConfigOnOffTestcase.isPublicKioskOn){
			publicKioskPage.clickToButtonBackToKiosk();

			assertTrue(publicKioskPage.isButtonConfigKioskDisplayed());
			assertTrue(publicKioskPage.isTextPleaseChooseEventDisplayed());
		} else {
			System.out.println("Public Kiosk not use");
		}

	}

	@Description("Config Kiosk - Enter code of Config Kiosk is empty")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_003_ConfigKiosk_003_EnterCodeEmpty() {
		if(ConfigOnOffTestcase.isPublicKioskOn){
			publicKioskPage.clickToButtonConfigKiosk();

			assertTrue(publicKioskPage.isTextEnterCodeAccessDisplayed());

			publicKioskPage.clickToButtonConfirmCode();
		} else {
			System.out.println("Public Kiosk not use");
		}


	}

	@Description("Config Kiosk - Enter code of Config Kiosk is incorrect")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_004_ConfigKiosk_004_EnterCodeIncorrect() {
		if(ConfigOnOffTestcase.isPublicKioskOn){
			publicKioskPage.inputCodeAccessConfigKiosk(accessCodeInvalid);

			publicKioskPage.clickToButtonConfirmCode();

			assertEquals(publicKioskPage.getErrorMessageAtHeader(),"Config code incorrect!");
		} else {
			System.out.println("Public Kiosk not use");
		}

	}

	@Description("Config Kiosk - Enter code of Config Kiosk is correct")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_005_ConfigKiosk_005_EnterCodeCorrect() {
		if(ConfigOnOffTestcase.isPublicKioskOn){
			publicKioskPage.inputCodeAccessConfigKiosk(accessCodeValid);

			publicKioskPage.clickToButtonConfirmCode();

			assertTrue(publicKioskPage.isTextConfigKioskDisplayed());

		} else {
			System.out.println("Public Kiosk not use");
		}

	}

	@Description("Config Kiosk - Config to Kiosk")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_006_ConfigKiosk_006_ConfigToKiosk() {
		if(ConfigOnOffTestcase.isPublicKioskOn){
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
		} else {
			System.out.println("Public Kiosk not use");
		}

	}


	@Description("Checkout - Select Event of Public Kiosk")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_007_Checkout_001_SelectEvent() {
		if(ConfigOnOffTestcase.isPublicKioskOn){
			String eventName = publicKioskPage.getNameOfEventFromScreenSelectEvent(eventNameSelected);

			publicKioskPage.clickToChooseEventName(eventNameSelected);

			assertTrue(publicKioskPage.isTextOrderDisplayed());
			assertEquals(publicKioskPage.getNameOfEventFromCheckoutScreen(),eventName);
		} else {
			System.out.println("Public Kiosk not use");
		}

	}

	@Description("Checkout - Checkout when empty data - Name")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_008_Checkout_002_CheckoutEmptyDataName() {
		if(ConfigOnOffTestcase.isPublicKioskOn){
			publicKioskPage.clickToButtonCheckout();

			assertEquals(publicKioskPage.getErrorMessageCheckoutEmptyData(),"Please enter your name");
		} else {
			System.out.println("Public Kiosk not use");
		}

	}


	@Description("Checkout - Checkout when empty data - Phone")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_009_Checkout_003_CheckoutEmptyDataPhone() {
		if(ConfigOnOffTestcase.isPublicKioskOn){
			publicKioskPage.inputInfoBuyer("Name", nameOfBuyer);

			publicKioskPage.clickToButtonCheckout();

			assertEquals(publicKioskPage.getErrorMessageCheckoutEmptyData(),"Please enter your phone number");
		} else {
			System.out.println("Public Kiosk not use");
		}

	}

	@Description("Checkout - Checkout when empty data - Quantity")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_010_Checkout_004_CheckoutEmptyDataQuantity() {
		if(ConfigOnOffTestcase.isPublicKioskOn){
			publicKioskPage.inputInfoBuyer("Name", nameOfBuyer);
			publicKioskPage.inputInfoBuyer("Phone", phoneNumber);

			publicKioskPage.clickToButtonCheckout();

			assertEquals(publicKioskPage.getErrorMessageCheckoutEmptyData(),"Please select at least one ticket");
		} else {
			System.out.println("Public Kiosk not use");
		}


	}
	
	@Description("Checkout - Checkout when input valid data")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_011_Checkout_005_CheckoutInputValidData() {
		if(ConfigOnOffTestcase.isPublicKioskOn){
			publicKioskPage.clickToDropDownSelectQuantityTicket(ticketName, "2");
			publicKioskPage.inputInfoBuyer("Name", nameOfBuyer);
			publicKioskPage.inputInfoBuyer("Phone", phoneNumber);

			publicKioskPage.clickToButtonCheckout();

			assertTrue(publicKioskPage.isTextCheckoutDisplayed());
		} else {
			System.out.println("Public Kiosk not use");
		}

	}
	
	@Description("Checkout - Charge Card Other Internet")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_012_Checkout_006_ChargeCardOrtherInternet() {


	}
	
	@Description("Checkout - Charge Card As Like Internet")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_013_TCs_001_Checkout_007_ChargeCardAsLikeInternet() {
		if(ConfigOnOffTestcase.isPublicKioskOn){
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
		} else {
			System.out.println("Public Kiosk not use");
		}

	}
	
	@Description("Checkout - Payment Method Declined")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_014_TCs_001_Checkout_008_PaymentMethodDeclined() {
		if(ConfigOnOffTestcase.isPublicKioskOn){
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
		} else {
			System.out.println("Public Kiosk not use");
		}

	}
	
	@Description("Checkout - Check button Kiosk of Payment screen")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_015_TCs_001_Checkout_009_CheckButtonKiosk() {
		if(ConfigOnOffTestcase.isPublicKioskOn){
			publicKioskPage.inputInfoBuyer("Name", nameOfBuyer);
			publicKioskPage.inputInfoBuyer("Phone", phoneNumber);
			publicKioskPage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
			publicKioskPage.clickToButtonCheckout();
			publicKioskPage.clickToKioskButtonPaymentScreen();
		} else {
			System.out.println("Public Kiosk not use");
		}

	}
	

	@AfterClass
	public void afterClass() {
//		driver.quit();
		closeBrowserDriver();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(999999999);

	}

}