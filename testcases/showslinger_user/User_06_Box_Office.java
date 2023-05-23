package showslinger_user;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObject.user.UserBoxOfficePageObject;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;
import pageObject.user.UserPublicKioskObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class User_06_Box_Office extends BaseTest{
	private UserBoxOfficePageObject boxOfficePage;
	private String existingEmail, validPassword;
	String currentWindowHandle;
	String textVenue;
	String textEvent;

	//portalURL: boxoffice
	@Parameters({"browser", "portalURL"})
	@BeforeClass
	public void beforeClass(String browserName, String portalURL) {
		driver = getBrowserDriver(browserName, portalURL);
		boxOfficePage = new UserBoxOfficePageObject(driver);
		
		existingEmail ="paulv@showslinger.com";
		validPassword = "12345";
		
		textVenue = "City Theater";
		textVenue = "Giang Test auto";

	}
	
	@Test
	public void Role_Manager_Box_01_Open_URL_and_Login_Account() {
		System.out.println("Role_Manager_Box_01 - Step 01: Input Email & Password Textbox");
		boxOfficePage.inputToEmailTextbox(existingEmail);
		boxOfficePage.inputToPasswordTextbox(validPassword);

		System.out.println("Role_Manager_Box_01 - Step 02: Click to Login button");
		boxOfficePage.clickToLoginButton();
		
		System.out.println("Role_Manager_Box_01 - Step 03: Verify Box Office Page");
		Assert.assertTrue(boxOfficePage.isBoxOfficeTextDisplayed());
	}

	//@Test
	public void Role_Manager_Box_02_More_Menu() {
		System.out.println("Role_Manager_Box_02 - Step 01: Click button More Menu");
		boxOfficePage.clickToMoreMenuButton();
		
		System.out.println("Role_Manager_Box_02 - Step 02: Click Instruction");
		String boxOfficeWindowID = driver.getWindowHandle();
		boxOfficePage.clickToInstructionButton();
		boxOfficePage.switchToWindowByID(boxOfficeWindowID);

		System.out.println("Role_Manager_Box_02 - Step 03: Verify Instruction");
		Assert.assertTrue(boxOfficePage.isTitleInstructionYoutubeDisplayed());
		String instructionYoutubeWindowID = driver.getWindowHandle();
		driver.close();
		boxOfficePage.switchToWindowByID(instructionYoutubeWindowID);
		
		System.out.println("Role_Manager_Box_02 - Step 04: Click Copy Link");
		boxOfficePage.clickToCopyLinkButton();
		boxOfficePage.acceptAlertBoxOffice();

		System.out.println("Role_Manager_Box_02 - Step 05: Click Card Reader");
		boxOfficePage.clickToCardReadersButton();
		boxOfficePage.switchToWindowByID(boxOfficeWindowID);

		System.out.println("Role_Manager_Box_02 - Step 06: Verify Card Reader");
		Assert.assertTrue(boxOfficePage.isTitleRegisteredReadersDisplayed());
		String registeredReadersWindowID = driver.getWindowHandle();
		driver.close();
		boxOfficePage.switchToWindowByID(registeredReadersWindowID);

		System.out.println("Role_Manager_Box_02 - Step 07: Click Information");
		boxOfficePage.clickToInformationButton();
		boxOfficePage.switchToWindowByID(boxOfficeWindowID);

		System.out.println("Role_Manager_Box_02 - Step 08: Verify Information");
		Assert.assertTrue(boxOfficePage.isTitleBoxOfficeInformationDisplayed());
	}
	
	//@Test
	public void Role_Manager_Box_03_Config_Information() {
		System.out.println("Role_Manager_Box_03 - Step 01: Click dropdown Select default printer");
		boxOfficePage.clickToDropDownSelectPrinter();

		System.out.println("Role_Manager_Box_03 - Step 02: Selected valued of dropdown");
		boxOfficePage.clickToValueOfDropdownSelectPrinter();

		System.out.println("Role_Manager_Box_03 - Step 03: Verify value of dropdown & displayed dropdown paper");
		Assert.assertTrue(boxOfficePage.isSelectedPrinterValueDisplayed());
		Assert.assertTrue(boxOfficePage.isTextSelectdefaultPaperDisplayed());

		System.out.println("Role_Manager_Box_03 - Step 04: Selected value of Dropdown Selected Paper");
		boxOfficePage.clickToDropDownSelectPaper();

		System.out.println("Role_Manager_Box_03 - Step 05: Selected valued of dropdown");
		boxOfficePage.clickToValueOfDropdownSelectPaper();

		System.out.println("Role_Manager_Box_03 - Step 06: Verify value of dropdown");
		Assert.assertTrue(boxOfficePage.isSelectedPaperValueDisplayed());
		
		System.out.println("Role_Manager_Box_03 - Step 07: Click button Reset");
		boxOfficePage.clickToButtonReset();

		System.out.println("Role_Manager_Box_03 - Step 08: Accept alert");
		boxOfficePage.acceptAlertReport();

		System.out.println("Role_Manager_Box_03 - Step 09: Verify value of column Tix Sold & Total Amout");
		Assert.assertEquals(boxOfficePage.getValueTixSoldCardReader(),"0");
		Assert.assertEquals(boxOfficePage.getValueTotalAmountCardReader(),"0");
		
		Assert.assertEquals(boxOfficePage.getValueTixSoldCash(),"0");
		Assert.assertEquals(boxOfficePage.getValueTotalAmountCash(),"0");
		
		Assert.assertEquals(boxOfficePage.getValueTixSoldCard(),"0");
		Assert.assertEquals(boxOfficePage.getValueTotalAmountCard(),"0");
		
		Assert.assertEquals(boxOfficePage.getValueTixSoldComp(),"0");
		Assert.assertEquals(boxOfficePage.getValueTotalAmountComp(),"0");
		
		Assert.assertEquals(boxOfficePage.getValueTixSoldPayLater(),"0");
		Assert.assertEquals(boxOfficePage.getValueTotalAmountPayLater(),"0");
		
		Assert.assertEquals(boxOfficePage.getValueTixSoldTotal(),"0");
		Assert.assertEquals(boxOfficePage.getValueTotalAmountTotal(),"0");
		
		System.out.println("Role_Manager_Box_03 - Step 10: Click button Reset");
		boxOfficePage.clickToButtonReset();

		System.out.println("Role_Manager_Box_03 - Step 11: Accept alert");
		boxOfficePage.cancelAlertReport();

		System.out.println("Role_Manager_Box_03 - Step 12: Verify value of column Tix Sold & Total Amout");
		Assert.assertEquals(boxOfficePage.getValueTixSoldCardReader(),"0");
		Assert.assertEquals(boxOfficePage.getValueTotalAmountCardReader(),"0");
		
		Assert.assertEquals(boxOfficePage.getValueTixSoldCash(),"0");
		Assert.assertEquals(boxOfficePage.getValueTotalAmountCash(),"0");
		
		Assert.assertEquals(boxOfficePage.getValueTixSoldCard(),"0");
		Assert.assertEquals(boxOfficePage.getValueTotalAmountCard(),"0");
		
		Assert.assertEquals(boxOfficePage.getValueTixSoldComp(),"0");
		Assert.assertEquals(boxOfficePage.getValueTotalAmountComp(),"0");
		
		Assert.assertEquals(boxOfficePage.getValueTixSoldPayLater(),"0");
		Assert.assertEquals(boxOfficePage.getValueTotalAmountPayLater(),"0");
		
		Assert.assertEquals(boxOfficePage.getValueTixSoldTotal(),"0");
		Assert.assertEquals(boxOfficePage.getValueTotalAmountTotal(),"0");
		
		System.out.println("Role_Manager_Box_03 - Step 13: Click button Back to kiosk");
		boxOfficePage.clickToButtonBackToBoxOfficeFromInformationScreen();
		
		System.out.println("Role_Manager_Box_03 - Step 14: Verify Box Office Page");
		Assert.assertTrue(boxOfficePage.isBoxOfficeTextDisplayed());
		
		String boxOfficeInformationWindowID = driver.getWindowHandle();
		driver.close();
		boxOfficePage.switchToWindowByID(boxOfficeInformationWindowID);	
	}
	
	@Test
	public void Role_Manager_Box_04_Select_DropDown_Venue_Event() {
		System.out.println("Role_Manager_Box_04 - Step 01: Verify Box Office Page");
		Assert.assertTrue(boxOfficePage.isBoxOfficeTextDisplayed());
		
		System.out.println("Role_Manager_Box_04 - Step 02: Select venue");
		boxOfficePage.clickToDropDownSelectVenue();
		boxOfficePage.clickToValueOfDropdownSelectVenue();

		
		System.out.println("Role_Manager_Box_04 - Step 03: Select event");
		boxOfficePage.clickToDropDownSelectEvent();
		boxOfficePage.clickToValueOfDropdownSelectEvent();

		System.out.println("Role_Manager_Box_04 - Step 04: Verify screen Order");
		Assert.assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
	}
	
	@Test
	public void Role_Manager_Box_05_Check_Out_Empty_Data() {
		System.out.println("Role_Manager_Box_05 - Step 01: Click button Checkout");
		boxOfficePage.clickButtonCheckoutNow();
		
		System.out.println("Role_Manager_Box_05 - Step 02: Verify error msg");		
		Assert.assertEquals(boxOfficePage.getErrorMessageCheckoutEmptyData(),"Please select at least one ticket");
	}
	
	@Test
	public void Role_Manager_Box_06_Check_Out_Success_Cash() {
		System.out.println("Role_Manager_Box_06 - Step 01: Select quantity ticket");
		boxOfficePage.clickToDropDownSelectTicket();
		boxOfficePage.clickToValueOfDropdownSelectTicket();
		
		System.out.println("Role_Manager_Box_06 - Step 02: Click radio button Cash");
		boxOfficePage.clickRadioButtonPayByCash();
		
		System.out.println("Role_Manager_Box_06 - Step 03: Click button Checkout");
		boxOfficePage.clickButtonCheckoutNow();
		
		System.out.println("Role_Manager_Box_06 - Step 04: Click button Place Order");
		boxOfficePage.clickButtonPlaceOrder();
		
		System.out.println("Role_Manager_Box_06 - Step 05: Verify text success");
		Assert.assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());	
		
		//Verify Button View Order
		String PageOrderSuccess = driver.getWindowHandle();
		System.out.println("Role_Manager_Box_06 - Step 06: Click button View Order");
		boxOfficePage.clickViewOrderButton();
		boxOfficePage.switchToWindowByID(PageOrderSuccess);

		System.out.println("Role_Manager_Box_06 - Step 07: Close tab View Order, back tab Order Success");
		String PageViewOrder = driver.getWindowHandle();
		driver.close();
		boxOfficePage.switchToWindowByID(PageViewOrder);
		
		System.out.println("Role_Manager_Box_06 - Step 08: Verify text success");
		Assert.assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());	
		
		//Verify Button Print Order
		System.out.println("Role_Manager_Box_06 - Step 09: Click button More Menu");
		boxOfficePage.clickToMoreMenuButton();
		
		System.out.println("Role_Manager_Box_06 - Step 10: Click Information");
		boxOfficePage.clickToInformationButton();
		boxOfficePage.switchToWindowByID(PageOrderSuccess);
		
		System.out.println("Role_Manager_Box_06 - Step 11: Click dropdown Select default printer");
		boxOfficePage.clickToDropDownSelectPrinter();
		boxOfficePage.clickToValueOfDropdownSelectPrinterDefault();
		
		String pageInformationBoxOffice  = driver.getWindowHandle();;
		boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
		
		System.out.println("Role_Manager_Box_06 - Step 12: Click button print order");
		boxOfficePage.clickPrintOrderButton();
		
		System.out.println("Role_Manager_Box_06 - Step 13: Verify text of alert");
		Assert.assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your printer was not configured!");
		boxOfficePage.acceptAlertBoxOffice();
		
		System.out.println("Role_Manager_Box_06 - Step 14: Select value printer valid");
		boxOfficePage.switchToWindowByID(PageOrderSuccess);
		boxOfficePage.clickToDropDownSelectPrinter();
		boxOfficePage.clickToValueOfDropdownSelectPrinter();
		
		boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
		
		System.out.println("Role_Manager_Box_06 - Step 15: Click button print order");
		boxOfficePage.clickPrintOrderButton();
		
		System.out.println("Role_Manager_Box_06 - Step 16: Verify text of alert");
		Assert.assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your paper was not configured!");
		boxOfficePage.acceptAlertBoxOffice();
		
		System.out.println("Role_Manager_Box_06 - Step 17: Select value printer valid");
		boxOfficePage.switchToWindowByID(PageOrderSuccess);
		boxOfficePage.clickToDropDownSelectPaper();
		boxOfficePage.clickToValueOfDropdownSelectPaper();
		
		driver.close();
		boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
		
		System.out.println("Role_Manager_Box_06 - Step 18: Click button print order");
		boxOfficePage.clickPrintOrderButton();
		
		System.out.println("Role_Manager_Box_06 - Step 19: Verify text of alert");
		Assert.assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Printing tickets");
		boxOfficePage.acceptAlertBoxOffice();
		
		//Verify Button Back To Box Office
		System.out.println("Role_Manager_Box_06 - Step 20: Click button Back to box office");
		boxOfficePage.clickBackToBoxOfficeButton();

		System.out.println("Role_Manager_Box_06 - Step 21: Verify screen Order");
		Assert.assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
	}
	
	
	
	@Test
	public void Role_Manager_Box_07_Check_Out_Success_Comp() {
		System.out.println("Role_Manager_Box_07 - Step 01: Select quantity ticket");
		boxOfficePage.clickToDropDownSelectTicket();
		boxOfficePage.clickToValueOfDropdownSelectTicket();
		
		System.out.println("Role_Manager_Box_07 - Step 02: Click radio button Cash");
		boxOfficePage.clickRadioButtonPayByComp();
		
		System.out.println("Role_Manager_Box_07 - Step 03: Click button Checkout");
		boxOfficePage.clickButtonCheckoutNow();
		
		System.out.println("Role_Manager_Box_07 - Step 04: Click button Place Order");
		boxOfficePage.clickButtonPlaceOrder();
		
		System.out.println("Role_Manager_Box_07 - Step 05: Verify text success");
		Assert.assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());	
		
		//Verify Button View Order
		String PageOrderSuccess = driver.getWindowHandle();
		System.out.println("Role_Manager_Box_07 - Step 06: Click button View Order");
		boxOfficePage.clickViewOrderButton();
		boxOfficePage.switchToWindowByID(PageOrderSuccess);

		System.out.println("Role_Manager_Box_07 - Step 07: Close tab View Order, back tab Order Success");
		String PageViewOrder = driver.getWindowHandle();
		driver.close();
		boxOfficePage.switchToWindowByID(PageViewOrder);
		
		System.out.println("Role_Manager_Box_07 - Step 08: Verify text success");
		Assert.assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());	
		
		//Verify Button Print Order
		System.out.println("Role_Manager_Box_07 - Step 09: Click button More Menu");
		boxOfficePage.clickToMoreMenuButton();
		
		System.out.println("Role_Manager_Box_07 - Step 10: Click Information");
		boxOfficePage.clickToInformationButton();
		boxOfficePage.switchToWindowByID(PageOrderSuccess);
		
		System.out.println("Role_Manager_Box_07 - Step 11: Click dropdown Select default printer");
		boxOfficePage.clickToDropDownSelectPrinter();
		boxOfficePage.clickToValueOfDropdownSelectPrinterDefault();
		
		String pageInformationBoxOffice  = driver.getWindowHandle();;
		boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
		
		System.out.println("Role_Manager_Box_07 - Step 12: Click button print order");
		boxOfficePage.clickPrintOrderButton();
		
		System.out.println("Role_Manager_Box_07 - Step 13: Verify text of alert");
		Assert.assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your printer was not configured!");
		boxOfficePage.acceptAlertBoxOffice();
		
		System.out.println("Role_Manager_Box_07 - Step 14: Select value printer valid");
		boxOfficePage.switchToWindowByID(PageOrderSuccess);
		boxOfficePage.clickToDropDownSelectPrinter();
		boxOfficePage.clickToValueOfDropdownSelectPrinter();
		
		boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
		
		System.out.println("Role_Manager_Box_07 - Step 15: Click button print order");
		boxOfficePage.clickPrintOrderButton();
		
		System.out.println("Role_Manager_Box_07 - Step 16: Verify text of alert");
		Assert.assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your paper was not configured!");
		boxOfficePage.acceptAlertBoxOffice();
		
		System.out.println("Role_Manager_Box_07 - Step 17: Select value printer valid");
		boxOfficePage.switchToWindowByID(PageOrderSuccess);
		boxOfficePage.clickToDropDownSelectPaper();
		boxOfficePage.clickToValueOfDropdownSelectPaper();
		
		driver.close();
		boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
		
		System.out.println("Role_Manager_Box_07 - Step 18: Click button print order");
		boxOfficePage.clickPrintOrderButton();
		
		System.out.println("Role_Manager_Box_07 - Step 19: Verify text of alert");
		Assert.assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Printing tickets");
		boxOfficePage.acceptAlertBoxOffice();
		
		//Verify Button Back To Box Office
		System.out.println("Role_Manager_Box_07 - Step 20: Click button Back to box office");
		boxOfficePage.clickBackToBoxOfficeButton();

		System.out.println("Role_Manager_Box_07 - Step 21: Verify screen Order");
		Assert.assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
	}
	
	@Test
	public void Role_Manager_Box_08_Check_Out_Success_Pay_Later() {
		System.out.println("Role_Manager_Box_08 - Step 01: Select quantity ticket");
		boxOfficePage.clickToDropDownSelectTicket();
		boxOfficePage.clickToValueOfDropdownSelectTicketComp();
		
		System.out.println("Role_Manager_Box_08 - Step 02: Click radio button Cash");
		boxOfficePage.clickRadioButtonPayByPayLater();
		
		System.out.println("Role_Manager_Box_08 - Step 03: Click button Checkout");
		boxOfficePage.clickButtonCheckoutNow();
		
		System.out.println("Role_Manager_Box_08 - Step 04: Click button Place Order");
		boxOfficePage.clickButtonPlaceOrder();
		
		System.out.println("Role_Manager_Box_08 - Step 05: Click button Authorize Test Payment - Striper");
		boxOfficePage.clickButtonAuthorizeTestPayment();
		
		System.out.println("Role_Manager_Box_08 - Step 05: Verify text success");
		Assert.assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());	
		
		//Verify Button View Order
		String PageOrderSuccess = driver.getWindowHandle();
		System.out.println("Role_Manager_Box_08 - Step 06: Click button View Order");
		boxOfficePage.clickViewOrderButton();
		boxOfficePage.switchToWindowByID(PageOrderSuccess);

		System.out.println("Role_Manager_Box_08 - Step 07: Close tab View Order, back tab Order Success");
		String PageViewOrder = driver.getWindowHandle();
		driver.close();
		boxOfficePage.switchToWindowByID(PageViewOrder);
		
		System.out.println("Role_Manager_Box_08 - Step 08: Verify text success");
		Assert.assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());	
		
		//Verify Button Print Order
		System.out.println("Role_Manager_Box_08 - Step 09: Click button More Menu");
		boxOfficePage.clickToMoreMenuButton();
		
		System.out.println("Role_Manager_Box_08 - Step 10: Click Information");
		boxOfficePage.clickToInformationButton();
		boxOfficePage.switchToWindowByID(PageOrderSuccess);
		
		System.out.println("Role_Manager_Box_08 - Step 11: Click dropdown Select default printer");
		boxOfficePage.clickToDropDownSelectPrinter();
		boxOfficePage.clickToValueOfDropdownSelectPrinterDefault();
		
		String pageInformationBoxOffice  = driver.getWindowHandle();;
		boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
		
		System.out.println("Role_Manager_Box_08 - Step 12: Click button print order");
		boxOfficePage.clickPrintOrderButton();
		
		System.out.println("Role_Manager_Box_08 - Step 13: Verify text of alert");
		Assert.assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your printer was not configured!");
		boxOfficePage.acceptAlertBoxOffice();
		
		System.out.println("Role_Manager_Box_08 - Step 14: Select value printer valid");
		boxOfficePage.switchToWindowByID(PageOrderSuccess);
		boxOfficePage.clickToDropDownSelectPrinter();
		boxOfficePage.clickToValueOfDropdownSelectPrinter();
		
		boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
		
		System.out.println("Role_Manager_Box_08 - Step 15: Click button print order");
		boxOfficePage.clickPrintOrderButton();
		
		System.out.println("Role_Manager_Box_08 - Step 16: Verify text of alert");
		Assert.assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your paper was not configured!");
		boxOfficePage.acceptAlertBoxOffice();
		
		System.out.println("Role_Manager_Box_08 - Step 17: Select value printer valid");
		boxOfficePage.switchToWindowByID(PageOrderSuccess);
		boxOfficePage.clickToDropDownSelectPaper();
		boxOfficePage.clickToValueOfDropdownSelectPaper();
		
		driver.close();
		boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
		
		System.out.println("Role_Manager_Box_08 - Step 18: Click button print order");
		boxOfficePage.clickPrintOrderButton();
		
		System.out.println("Role_Manager_Box_08 - Step 19: Verify text of alert");
		Assert.assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Printing tickets");
		boxOfficePage.acceptAlertBoxOffice();
		
		//Verify Button Back To Box Office
		System.out.println("Role_Manager_Box_08 - Step 20: Click button Back to box office");
		boxOfficePage.clickBackToBoxOfficeButton();

		System.out.println("Role_Manager_Box_08 - Step 21: Verify screen Order");
		Assert.assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
	}
	
	@Test
	public void Role_Manager_Box_09_Check_Out_Fail_Pay_Later() {
		System.out.println("Role_Manager_Box_09 - Step 01: Select quantity ticket");
		boxOfficePage.clickToDropDownSelectTicket();
		boxOfficePage.clickToValueOfDropdownSelectTicketComp();
		
		System.out.println("Role_Manager_Box_09 - Step 02: Click radio button Cash");
		boxOfficePage.clickRadioButtonPayByPayLater();
		
		System.out.println("Role_Manager_Box_09 - Step 03: Click button Checkout");
		boxOfficePage.clickButtonCheckoutNow();
		
		System.out.println("Role_Manager_Box_09 - Step 04: Click button Place Order");
		boxOfficePage.clickButtonPlaceOrder();
		
		System.out.println("Role_Manager_Box_09 - Step 05: Click button Authorize Test Payment - Striper");
		boxOfficePage.clickButtonFailTestPayment();
		
		System.out.println("Role_Manager_Box_08 - Step 06: Verify text of alert fail");
		Assert.assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Checkout order failed! Please select your ticket and checkout again.");
		boxOfficePage.acceptAlertBoxOffice();
		
		System.out.println("Role_Manager_Box_09 - Step 07: Verify screen Order");
		Assert.assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
		
	}
	
	@Test
	public void Role_Manager_Box_14_Check_Out_Success_Card_Swiper() {
		
	}
	
	@Test
	public void Role_Manager_Box_14_Check_Out_Fail_Card_Swiper() {
		
	}
	
	
	@Test
	public void Role_Manager_Box_18_Check_Out_Success_Card_Manually() {
		
	}
	
	@Test
	public void Role_Manager_Box_18_Check_Out_Fail_Card_Manually() {
		
	}
	
	
	
	//@Test
	public void Role_Manager_Box_Log_Out() {
		System.out.println("Role_Manager_Box_02 - Step 02: Click Log Out");
		boxOfficePage.clickToLogOutButton();
		
		System.out.println("Role_Manager_Box_02 - Step 03: Verify Log Out");
		Assert.assertTrue(boxOfficePage.isLoginButtonDisplayed());
	}
	
	
	//@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(999999999);

	}



}
