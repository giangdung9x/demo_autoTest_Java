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
		String boxOfficeWindowID_1 = driver.getWindowHandle();
		boxOfficePage.clickToInstructionButton();
		boxOfficePage.switchToWindowByID(boxOfficeWindowID_1);

		System.out.println("Role_Manager_Box_02 - Step 03: Verify Instruction");
		Assert.assertTrue(boxOfficePage.isTitleInstructionYoutubeDisplayed());
		String instructionYoutubeWindowID = driver.getWindowHandle();
		driver.close();
		boxOfficePage.switchToWindowByID(instructionYoutubeWindowID);
		
		System.out.println("Role_Manager_Box_02 - Step 04: Click Copy Link");
		boxOfficePage.clickToCopyLinkButton();
		boxOfficePage.acceptAlertCopyLink();

		System.out.println("Role_Manager_Box_02 - Step 05: Click Card Reader");
		String boxOfficeWindowID_2 = driver.getWindowHandle();
		boxOfficePage.clickToCardReadersButton();
		boxOfficePage.switchToWindowByID(boxOfficeWindowID_2);

		System.out.println("Role_Manager_Box_02 - Step 06: Verify Card Reader");
		Assert.assertTrue(boxOfficePage.isTitleRegisteredReadersDisplayed());
		String registeredReadersWindowID = driver.getWindowHandle();
		driver.close();
		boxOfficePage.switchToWindowByID(registeredReadersWindowID);

		System.out.println("Role_Manager_Box_02 - Step 07: Click Information");
		String boxOfficeWindowID_3 = driver.getWindowHandle();;
		boxOfficePage.clickToInformationButton();
		boxOfficePage.switchToWindowByID(boxOfficeWindowID_3);

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
	}
	
	//@Test
	public void Role_Manager_Box_Log_Out() {
		/*
		System.out.println("Role_Manager_Box_02 - Step 02: Click Log Out");
		boxOfficePage.clickToLogOutButton();
		
		System.out.println("Role_Manager_Box_02 - Step 03: Verify Log Out");
		Assert.assertTrue(boxOfficePage.isLoginButtonDisplayed());*/
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
