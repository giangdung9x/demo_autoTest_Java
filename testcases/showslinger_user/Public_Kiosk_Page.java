package showslinger_user;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.user.UserPublicKioskObject;
import java.util.Random;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class Public_Kiosk_Page extends BaseTest{
	private UserPublicKioskObject publicKioskPage;
	String accessCodeInvalid;
	String accessCodeValid;
	String nameOfBuyer;
	String phoneNumber;
	String textItem;

	@Description("Open Url Public Kiosk Page")
	@Parameters({"browser", "portalURL"})
	@BeforeClass
	public void beforeClass(String browserName, String portalURL) {
		driver = getBrowserDriver(browserName, portalURL);
		publicKioskPage = new UserPublicKioskObject(driver);
		
		accessCodeInvalid = "abcd";
		accessCodeValid ="city";
		nameOfBuyer = "Dang Giang";
		phoneNumber = "0" + generateFakeNumber();
	}
	

	
	@Description("Config Kiosk - Open 'Config Kiosk")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void ConfigKiosk_001_OpenConfigKiosk() {
		assertTrue(publicKioskPage.isButtonConfigKioskDisplayed());
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

		publicKioskPage.clickToDropDownSelectPrinter();
		publicKioskPage.clickToValueOfDropdownSelectPrinter("Canon LBP2900 (DESKTOP-VMJ4FSM)");

		assertTrue(publicKioskPage.isTextSelectdefaultPaperDisplayed());

		publicKioskPage.clickToDropDownSelectPaper();
		publicKioskPage.clickToValueOfDropdownSelectPaper("A4");

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
		String eventName = publicKioskPage.getNameOfEventFromScreenSelectEvent("Giang Test auto");

		publicKioskPage.clickToChooseEventName("Giang Test auto");

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
		publicKioskPage.clickToDropDownSelectQuantityTicket("vip3", "2");
		publicKioskPage.inputInfoBuyer("Name", nameOfBuyer);
		publicKioskPage.inputInfoBuyer("Phone", phoneNumber);
		//publicKioskPage.clickToDropDownSelectTicket();
		//publicKioskPage.clickToValueOfDropdownSelectTicket();
		
		publicKioskPage.clickToButtonCheckout();
		
		assertTrue(publicKioskPage.isTextCheckoutDisplayed());
	}
	
//	@Description("Checkout - Charge Card Other Internet")
//	@Severity(SeverityLevel.NORMAL)
//	@Test(priority = 12)
//	public void Checkout_006_ChargeCardOrtherInternet() {
//		
//	}
	
	@Description("Checkout - Charge Card As Like Internet")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 13)
	public void Checkout_007_ChargeCardAsLikeInternet() {
		publicKioskPage.clickToRadioButtonCardReader();
		
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
		
		publicKioskPage.clickToChooseEventName("Giang Test auto");

		publicKioskPage.inputInfoBuyer("Name", nameOfBuyer);
		publicKioskPage.inputInfoBuyer("Phone", phoneNumber);
		publicKioskPage.clickToDropDownSelectQuantityTicket("vip3", "1");

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
		publicKioskPage.clickToDropDownSelectQuantityTicket("vip3", "1");
		
		publicKioskPage.clickToButtonCheckout();
		
		assertTrue(publicKioskPage.isTextCheckoutDisplayed());

		publicKioskPage.clickToButtonCancelPayment();

		assertTrue(publicKioskPage.isTextPaymentMethodDeclined());
		
		assertTrue(publicKioskPage.isTextOrderDisplayed());
		
		publicKioskPage.inputInfoBuyer("Name", nameOfBuyer);
		publicKioskPage.inputInfoBuyer("Phone", phoneNumber);
		publicKioskPage.clickToDropDownSelectQuantityTicket("vip3", "1");
		
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
		publicKioskPage.clickToDropDownSelectQuantityTicket("vip3", "1");
		
		publicKioskPage.clickToButtonCheckout();
		
		assertTrue(publicKioskPage.isTextCheckoutDisplayed());
		
		assertTrue(publicKioskPage.isTextOrderDisplayed());

	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(999999999);

	}

}
