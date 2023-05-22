package showslinger_user;

import commons.BaseTest;
import commons.GlobalConstants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.user.UserForgotPasswordObject;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;
import pageObject.user.UserPublicKioskObject;
import pageObject.user.UserRegisterVenuePageObject;
import pageUIs.user.PublicKioskUI;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class User_05_Public_Kiosk extends BaseTest{
	private String existingEmail;
	private UserPublicKioskObject publicKioskPage;
	String accessCodeInvalid;
	String accessCodeValid;
	String nameOfBuyer;
	String phoneNumber;
	String textItem;


	@Parameters({"browser", "portalURL"})
	@BeforeClass
	public void beforeClass(String browserName, String portalURL) {
		driver = getBrowserDriver(browserName, portalURL);
		publicKioskPage = new UserPublicKioskObject(driver);
		accessCodeInvalid = "abcd";
		accessCodeValid ="city";
		nameOfBuyer = "Dang Giang";
		phoneNumber = "0" + generateFakeNumber();
		textItem = "1";
	}

	@Test
	public void Kiosk_01_Page_List_Event_Check_Displayed() {
		System.out.println("Kiosk_01 - Step: Verify display of button & text");
		Assert.assertTrue(publicKioskPage.isButtonConfigKioskDisplayed());
		Assert.assertTrue(publicKioskPage.isTextPleaseChooseEventDisplayed());
	}

	
	@Test
	public void Kiosk_02_Access_Code_Check_Button_Back_To_Kiosk_From()	{
		System.out.println("Kiosk_02 - Step 01: Click to button Config Kiosk");
		publicKioskPage.clickToButtonConfigKiosk();

		System.out.println("Kiosk_02 - Step 02: Click to button Back to Kiosk");
		publicKioskPage.clickToButtonBackToKioskFromAccessCode();

		System.out.println("Kiosk_02 - Step 03: Verify display of button & text");
		Assert.assertTrue(publicKioskPage.isButtonConfigKioskDisplayed());
		Assert.assertTrue(publicKioskPage.isTextPleaseChooseEventDisplayed());

	}

	@Test
	public void Kiosk_03_Check_Access_Code_Input_Invalid_Code() {

		System.out.println("Kiosk_03 - Step 01: Click to button Config Kiosk");
		publicKioskPage.clickToButtonConfigKiosk();

		System.out.println("Kiosk_03 - Step 02: Verify display screen Enter Code To Access");
		Assert.assertTrue(publicKioskPage.isTextEnterCodeAccessDisplayed());

		System.out.println("Kiosk_03 - Step 03: Input Code");
		publicKioskPage.inputCodeAccessConfigKiosk(accessCodeInvalid);

		System.out.println("Kiosk_03 - Step 04: Click button Confirm");
		publicKioskPage.clickToButtonConfirmCode();

		System.out.println("Kiosk_03 - Step 05: Verify message error");
		Assert.assertEquals(publicKioskPage.getErrorMessageCodeAccessConfigKiosk(),"Config code incorrect!");
	}

	@Test
	public void Kiosk_04_Check_Access_Code_Input_Valid_Code() {
		System.out.println("Kiosk_04 - Step 01: Input Code");
		publicKioskPage.inputCodeAccessConfigKiosk(accessCodeValid);

		System.out.println("Kiosk_04 - Step 02: Click button Confirm");
		publicKioskPage.clickToButtonConfirmCode();

		System.out.println("Kiosk_04 - Step 03: Verify display screen Config Kiosk");
		Assert.assertTrue(publicKioskPage.isTextConfigKioskDisplayed());
		Assert.assertTrue(publicKioskPage.isTextComputerPrinterDisplayed());
		Assert.assertTrue(publicKioskPage.isTextSelectDefaultPrintersDisplayed());
		Assert.assertTrue(publicKioskPage.isTextCardReaderDisplayed());
		Assert.assertTrue(publicKioskPage.isTextReportDisplayed());
	}

	@Test
	public void Kiosk_05_Config_Kiosk_Setting_Printer_and_Paper() {
		System.out.println("Kiosk_05 - Step 01: Click dropdown Select default printer");
		publicKioskPage.clickToDropDownSelectPrinter();

		System.out.println("Kiosk_05 - Step 02: Selected valued of dropdown");
		publicKioskPage.clickToValueOfDropdownSelectPrinter();

		System.out.println("Kiosk_05 - Step 03: Verify value of dropdown & displayed dropdown paper");
		Assert.assertTrue(publicKioskPage.isSelectedPrinterValueDisplayed());
		Assert.assertTrue(publicKioskPage.isTextSelectdefaultPaperDisplayed());

		System.out.println("Kiosk_05 - Step 04: Selected value of Dropdown Selected Paper");
		publicKioskPage.clickToDropDownSelectPaper();

		System.out.println("Kiosk_05 - Step 05: Selected valued of dropdown");
		publicKioskPage.clickToValueOfDropdownSelectPaper();

		System.out.println("Kiosk_05 - Step 06: Verify value of dropdown");
		Assert.assertTrue(publicKioskPage.isSelectedPaperValueDisplayed());
	}

	@Test
	public void Kiosk_06_Config_Kiosk_Button_Reset_Report_Alert_Accept(){
		System.out.println("Kiosk_06 - Step 01: Click button Reset");
		publicKioskPage.clickToButtonReset();

		System.out.println("Kiosk_06 - Step 02: Accept alert");
		publicKioskPage.acceptAlertReport();

		System.out.println("Kiosk_06 - Step 02: Verify value of column Tix Sold & Total Amout");
		Assert.assertEquals(publicKioskPage.getValueTixSold(),"N/A");
		Assert.assertEquals(publicKioskPage.getValueTotalAmount(),"N/A");
	}

	@Test
	public void Kiosk_07_Config_Kiosk_Button_Reset_Report_Alert_Cancel_and_Button_Back(){
		System.out.println("Kiosk_07 - Step 01: Click button Reset");
		publicKioskPage.clickToButtonReset();

		System.out.println("Kiosk_07 - Step 02: Accept alert");
		publicKioskPage.cancelAlertReport();

		System.out.println("Kiosk_07 - Step 03: Verify value of column Tix Sold & Total Amout");
		Assert.assertEquals(publicKioskPage.getValueTixSold(),"N/A");
		Assert.assertEquals(publicKioskPage.getValueTotalAmount(),"N/A");


		System.out.println("Kiosk_07 - Step 04: Click button Back to kiosk");
		publicKioskPage.clickToButtonBackToKioskFromConfigKiosk();

		System.out.println("Kiosk_07 - Step 05: Verify display text Please choose an event");
		Assert.assertTrue(publicKioskPage.isTextPleaseChooseEventDisplayed());
		
	}


	@Test
	public void Kiosk_08_Check_Out_Name_Empty() {
		String eventName = publicKioskPage.getNameOfEventFromScreenSelectEvent();

		System.out.println("Kiosk_08 - Step 01: Selectd Event");
		publicKioskPage.clickToChooseEventName();

		System.out.println("Kiosk_08 - Step 02: Verify display Checkout screen");
		Assert.assertTrue(publicKioskPage.isTextOrderDisplayed());
		Assert.assertEquals(publicKioskPage.getNameOfEventFromCheckoutScreen(),eventName);

		System.out.println("Kiosk_08 - Step 03: Click button");
		publicKioskPage.clickToButtonCheckout();

		System.out.println("Kiosk_08 - Step 04: Verify error message");
		Assert.assertEquals(publicKioskPage.getErrorMessageCheckoutEmptyData(),"Please enter your name");
	}

	@Test
	public void Kiosk_09_Check_Out_Phone_Number_Empty() {
		System.out.println("Kiosk_09 - Step 01: Input Name of Buyer");
		publicKioskPage.inputNameOfBuyer(nameOfBuyer);

		System.out.println("Kiosk_09 - Step 02: Click button");
		publicKioskPage.clickToButtonCheckout();

		System.out.println("Kiosk_09 - Step 03: Verify error message");
		Assert.assertEquals(publicKioskPage.getErrorMessageCheckoutEmptyData(),"Please enter your phone number");
	}

	@Test
	public void Kiosk_10_Check_Out_Quantity_Empty() {
		System.out.println("Kiosk_10 - Step 01: Input Name & Phone Number of Buyer");
		publicKioskPage.inputNameOfBuyer(nameOfBuyer);
		publicKioskPage.inputPhoneNumberOfBuyer(phoneNumber);

		System.out.println("Kiosk_10 - Step 02: Click button");
		publicKioskPage.clickToButtonCheckout();

		System.out.println("Kiosk_10 - Step 03: Verify error message");
		Assert.assertEquals(publicKioskPage.getErrorMessageCheckoutEmptyData(),"Please select at least one ticket");
	}
	
	@Test
	public void Kiosk_11_Check_Out_Sucess_Choose_Card_From_Checkout_Screen() {
		System.out.println("Kiosk_11 - Step 01: Select quantity ticket");
		publicKioskPage.clickToDropDownSelectQuantityTicket(textItem);
		
		System.out.println("Kiosk_11 - Step 02: Click button");
		publicKioskPage.clickToButtonCheckout();
		
		System.out.println("Kiosk_11 - Step 03: Verify Text Checkout");
		Assert.assertTrue(publicKioskPage.isTextCheckoutDisplayed());
		
		System.out.println("Kiosk_11 - Step 04: Selected card reader");
		publicKioskPage.clickToRadioButtonCardReader();
		
		System.out.println("Kiosk_11 - Step 05: Click button Charge Card");
		publicKioskPage.clickToButtonChargeCard();
		
		System.out.println("Kiosk_11 - Step 06: Verify success");
		Assert.assertTrue(publicKioskPage.isTextTapToInsertPayment());
		Assert.assertTrue(publicKioskPage.isTextSuccessPleaseWait());
		Assert.assertTrue(publicKioskPage.isTextPleaseTakeYourTickets());
		
		System.out.println("Kiosk_11 - Step 07: Verify back to Kiosk screen");
		Assert.assertTrue(publicKioskPage.isTextOrderDisplayed());
	}

	@Test
	public void Kiosk_12_Check_Out_Sucess_Choose_Card_From_Config_Screen() {
		System.out.println("Kiosk_12 - Step 01: Click href link Kiosk");
		publicKioskPage.clickToKiosk();
		
		System.out.println("Kiosk_12 - Step 02: Verify screen Please choose event");
		Assert.assertTrue(publicKioskPage.isTextPleaseChooseEventDisplayed());

		System.out.println("Kiosk_12 - Step 03: Open Config Kiosk screen");
		publicKioskPage.clickToButtonConfigKiosk();
		publicKioskPage.inputCodeAccessConfigKiosk(accessCodeValid);
		publicKioskPage.clickToButtonConfirmCode();

		System.out.println("Kiosk_12 - Step 04: Open Config Kiosk screen");
		publicKioskPage.clickToRadioButtonCardReaderFromConfig();
		
		System.out.println("Kiosk_12 - Step 05: Back to Kiosk");
		publicKioskPage.clickToButtonBackToKioskFromConfigKiosk();
		
		System.out.println("Kiosk_12 - Step 06: Choose Event");
		publicKioskPage.clickToChooseEventName();

		System.out.println("Kiosk_12 - Step 07: Checkout");
		publicKioskPage.inputNameOfBuyer(nameOfBuyer);
		publicKioskPage.inputPhoneNumberOfBuyer(phoneNumber);
		publicKioskPage.clickToDropDownSelectQuantityTicket(textItem);

		System.out.println("Kiosk_12 - Step 08: Verify success");
		Assert.assertTrue(publicKioskPage.isTextTapToInsertPayment());
		Assert.assertTrue(publicKioskPage.isTextSuccessPleaseWait());
		Assert.assertTrue(publicKioskPage.isTextPleaseTakeYourTickets());
		
		System.out.println("Kiosk_12 - Step 08: Verify back to Kiosk screen");
		Assert.assertTrue(publicKioskPage.isTextOrderDisplayed());
	}
	
	@Test
	public void Kiosk_13_Check_Out_Payment_Method_Declined() {
		System.out.println("Kiosk_13 - Step 01: Checkout");
		publicKioskPage.inputNameOfBuyer(nameOfBuyer);
		publicKioskPage.inputPhoneNumberOfBuyer(phoneNumber);
		publicKioskPage.clickToDropDownSelectQuantityTicket(textItem);

		System.out.println("Kiosk_13 - Step 02: Click button Cancel tap insert card");
		publicKioskPage.clickToButtonCancelPayment();

		System.out.println("Kiosk_13 - Step 03: Verify screen Payment Method Declined");
		Assert.assertTrue(publicKioskPage.isTextPaymentMethodDeclined());
		
		System.out.println("Kiosk_11 - Step 04: Verify back to Kiosk screen");
		Assert.assertTrue(publicKioskPage.isTextOrderDisplayed());
		
		System.out.println("Kiosk_13 - Step 05: Checkout");
		publicKioskPage.inputNameOfBuyer(nameOfBuyer);
		publicKioskPage.inputPhoneNumberOfBuyer(phoneNumber);
		publicKioskPage.clickToDropDownSelectQuantityTicket(textItem);
		
		System.out.println("Kiosk_13 - Step 06: Click button Cancel tap insert card");
		publicKioskPage.clickToButtonCancelPayment();

		System.out.println("Kiosk_13 - Step 07: Verify screen Payment Method Declined");
		Assert.assertTrue(publicKioskPage.isTextPaymentMethodDeclined());
		
		System.out.println("Kiosk_13 - Step 08: Click button Back");
		publicKioskPage.clickToButtonBack();
		
		System.out.println("Kiosk_11 - Step 04: Verify back to Kiosk screen");
		Assert.assertTrue(publicKioskPage.isTextOrderDisplayed());
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
