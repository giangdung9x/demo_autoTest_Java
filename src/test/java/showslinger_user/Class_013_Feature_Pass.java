package showslinger_user;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.user.UserPassPageObject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.Random;
import static org.testng.Assert.assertFalse;

//Actions of tickets Create/ Edit/Transfer Ticket
public class Class_013_Feature_Pass extends BaseTest{
	private UserPassPageObject passPage;
	private String emailManager, passwordManager,startDate, endDate, accessCode;
	private String passMulti, passSingleQR, passAccessCode, passDelete, eventNameQR, eventNameMulti, eventNameAccess;
	private String ticketName, quantityTicket, quantityPass;
	private String numberLimitPurchase, negativeLimit;
	private String fullName, phone, validEmail;
	private String cardNumberValid, monthYearValid,  cvc, zip;
	public String passCode;



	@Parameters({ "envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName,
	@Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String
	portNumber,@Optional("Windows") String osName, @Optional("10") String osVersion) {
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
		passPage = new UserPassPageObject(driver);

		emailManager ="paulv@showslinger.com";
		passwordManager = "12345";
		startDate = "06-13-2023";
		endDate  = "06-30-2024";
		
		passSingleQR =  "Pass Single QR" + " "+ generateFakeNumber();
		passMulti =  "Pass Multi" + " "+ generateFakeNumber();
		passAccessCode =  "Pass Access Code" + " "+ generateFakeNumber();
		passDelete =  "Pass Delete" + " "+ generateFakeNumber();

		eventNameQR = "Giang Test 06";
		eventNameMulti = "Giang Test 07";
		eventNameAccess = "Giang Test auto";
		
		ticketName ="vip3";
		quantityTicket ="1";
		
		negativeLimit = "-1";
		numberLimitPurchase = "1";
		quantityPass = "10";
		accessCode= "ABCDEF"+ generateFakeNumber();
		
		fullName = "Dang Thi Giang";
		phone = "+128379292999";
		validEmail = "dangthigiang" +  generateFakeNumber() + "@yopmail.com";
		cardNumberValid = "4242424242424242";
		monthYearValid = "0424";
		cvc = "242";
		zip = "42424";
	}

	@Description("Login Account")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_001_Pass_OpenUrlAndLogin() {
		
		passPage.clickToLoginLink();

		passPage.loginAccount(emailManager,passwordManager);

		passPage.clickToLoginButton();
		passPage.clickShowLeftMenu();

		passPage.clickToItemOfLeftMenu("Ticketing");
		
		passPage.clickToItemOfListTicketing("Passes");
		
		verifyTrue(passPage.isTextNameOfScreenDisplayed("Passes"));
	}
	
	
	
	@Description("Create Pass - Fail")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_002_Pass_001_CreatePassFail() {
		passPage.clickToAddPassButton();

		verifyTrue(passPage.isTextNameOfPopupDisplayed("Create Pass"));

		passPage.clickToSaveButton();
		verifyEquals(passPage.getErrorMessageOfFiled("total tickets"), "This field is required.");
		verifyEquals(passPage.getErrorMessageOfFiled("shows"), "This field is required.");
		verifyEquals(passPage.getErrorMessageOfFiled("tickets per show"), "This field is required.");

		passPage.inputToTextboxLimitPurchasePopup("total tickets", negativeLimit);
		passPage.inputToTextboxLimitPurchasePopup("shows", negativeLimit);
		passPage.inputToTextboxLimitPurchasePopup("tickets per show", negativeLimit);
		verifyEquals(passPage.getErrorMessageOfFiled("total tickets"), "Please enter a value greater than or equal to 0.");
		verifyEquals(passPage.getErrorMessageOfFiled("shows"), "Please enter a value greater than or equal to 0.");
		verifyEquals(passPage.getErrorMessageOfFiled("tickets per show"), "Please enter a value greater than or equal to 0.");

		passPage.inputToTextboxLimitPurchasePopup("total tickets", numberLimitPurchase);
		passPage.inputToTextboxLimitPurchasePopup("shows", numberLimitPurchase);
		passPage.inputToTextboxLimitPurchasePopup("tickets per show", numberLimitPurchase);
		passPage.clickToSaveButton();
		verifyEquals(passPage.getTextOfAlert(), "You need to set both an on sale and off sale date for this pass to display to the public.");
		passPage.clickToCloseAlertButton();
		passPage.clickToClosePopupButton();
	}



	@Description("Create Pass QR - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_003_Pass_002_CreatePassSuccessSingleQR() {
		passPage.clickToAddPassButton();

		verifyTrue(passPage.isTextNameOfPopupDisplayed("Create Pass"));

		passPage.inputToTextboxNamePopup("Name",passSingleQR);
		passPage.inputToTextboxPrice("10");
		passPage.inputToTextboxPlaceholderDescriptionPopup("This description", passSingleQR);
		passPage.clickToValueOfDropdownOfPopup("Select pass type", "Single QR");
		passPage.clickToValueOfDropdownOfPopup("Select events", eventNameQR);
		passPage.clickToSelectAllTicketButton();
		passPage.inputToTextboxNamePopup("Quantity",quantityPass);
		passPage.inputToTextboxLimitPurchasePopup("total tickets", numberLimitPurchase);
		passPage.inputToTextboxLimitPurchasePopup("shows", numberLimitPurchase);
		passPage.inputToTextboxLimitPurchasePopup("tickets per show", numberLimitPurchase);
		passPage.inputToTextboxPlaceholderPopup("Start date", startDate);
		passPage.inputToTextboxPlaceholderPopup("End date", endDate);

		passPage.clickToSaveButton();
		verifyEquals(passPage.getTextOfAlert(), "Pass '"+passSingleQR+"' was created successfully");
		passPage.clickToCloseAlertButton();
	}

	@Description("Create Pass Multi - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_004_Pass_003_CreatePassuccessMultiTicket() {
		passPage.clickToAddPassButton();

		verifyTrue(passPage.isTextNameOfPopupDisplayed("Create Pass"));

		passPage.inputToTextboxNamePopup("Name",passMulti);
		passPage.inputToTextboxPrice("10");
		passPage.inputToTextboxPlaceholderDescriptionPopup("This description", passMulti);
		passPage.clickToValueOfDropdownOfPopup("Select pass type", "Multi-ticket");
		passPage.clickToValueOfDropdownOfPopup("Select events", eventNameMulti);
		passPage.clickToSelectAllTicketButton();
		passPage.inputToTextboxNamePopup("Quantity",quantityPass);
		passPage.inputToTextboxLimitPurchasePopup("total tickets", numberLimitPurchase);
		passPage.inputToTextboxLimitPurchasePopup("shows", numberLimitPurchase);
		passPage.inputToTextboxLimitPurchasePopup("tickets per show", numberLimitPurchase);
		passPage.inputToTextboxPlaceholderPopup("Start date", startDate);
		passPage.inputToTextboxPlaceholderPopup("End date", endDate);

		passPage.clickToSaveButton();
		verifyEquals(passPage.getTextOfAlert(), "Pass '"+passMulti+"' was created successfully");
		passPage.clickToCloseAlertButton();
	}

	@Description("Create Pass QR has AccessCode - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_005_Pass_004_CreatePassuccessAccessCode() {
		passPage.clickToAddPassButton();

		verifyTrue(passPage.isTextNameOfPopupDisplayed("Create Pass"));

		passPage.inputToTextboxNamePopup("Name",passAccessCode);
		passPage.inputToTextboxPrice("10");
		passPage.inputToTextboxPlaceholderDescriptionPopup("This description", passAccessCode);
		passPage.clickToValueOfDropdownOfPopup("Select pass type", "Multi-ticket");
		passPage.clickToValueOfDropdownOfPopup("Select events", eventNameAccess);
		passPage.clickToSelectAllTicketButton();
		passPage.inputToTextboxNamePopup("Quantity",quantityPass);
		passPage.inputToTextboxLimitPurchasePopup("total tickets", numberLimitPurchase);
		passPage.inputToTextboxLimitPurchasePopup("shows", numberLimitPurchase);
		passPage.inputToTextboxLimitPurchasePopup("tickets per show", numberLimitPurchase);
		passPage.inputToTextboxPlaceholderPopup("Start date", startDate);
		passPage.inputToTextboxPlaceholderPopup("End date", endDate);
		passPage.inputToTextboxNamePopup("Access code","ABCD");

		passPage.clickToSaveButton();
		verifyEquals(passPage.getTextOfAlert(), "Pass '"+passAccessCode+"' was created successfully");
		passPage.clickToCloseAlertButton();
	}

	@Description("Change Satus Pass - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_006_Pass_005_SwitchStatusPass() {
		passPage.clickToActionButton(passSingleQR,"Inactive");
		verifyEquals(passPage.getTextOfAlert(), "Deactivated the pass '"+passSingleQR+"' successfully.");
		passPage.clickToActionButton(passSingleQR,"Active");
		verifyEquals(passPage.getTextOfAlert(), "Activated the pass '"+passSingleQR+"' successfully.");

		passPage.clickToActionButton(passMulti,"Inactive");
		verifyEquals(passPage.getTextOfAlert(), "Deactivated the pass '"+passMulti+"' successfully.");
		passPage.clickToActionButton(passMulti,"Active");
		verifyEquals(passPage.getTextOfAlert(), "Activated the pass '"+passMulti+"' successfully.");

		passPage.clickToActionButton(passAccessCode,"Inactive");
		verifyEquals(passPage.getTextOfAlert(), "Deactivated the pass '"+passAccessCode+"' successfully.");
		passPage.clickToActionButton(passAccessCode,"Active");
		verifyEquals(passPage.getTextOfAlert(), "Activated the pass '"+passAccessCode+"' successfully.");
		passPage.clickToCloseAlertButton();

	}


	@Description("Edit Pass - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_007_Pass_006_EditPassSuccess() {
		passPage.clickToActionButton(passAccessCode,"Edit");
		passPage.inputToTextboxNamePopup("Access code",accessCode);
		passPage.clickToSaveButton();
		verifyEquals(passPage.getTextOfAlert(), "Pass '"+passAccessCode+"' was updated successfully.");
		passPage.clickToCloseAlertButton();
	}

	@Description("Create Pass QR has AccessCode - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_008_Pass_007_DeletePassSuccess() {
		passPage.clickToAddPassButton();
		
		verifyTrue(passPage.isTextNameOfPopupDisplayed("Create Pass"));
		
		passPage.inputToTextboxNamePopup("Name",passDelete);
		passPage.inputToTextboxPrice("10");
		passPage.inputToTextboxPlaceholderDescriptionPopup("This description", passDelete);
		passPage.clickToValueOfDropdownOfPopup("Select pass type", "Single QR");
		passPage.clickToValueOfDropdownOfPopup("Select events", eventNameAccess);
		passPage.clickToSelectAllTicketButton();
		passPage.inputToTextboxNamePopup("Quantity",quantityPass);
		passPage.inputToTextboxLimitPurchasePopup("total tickets", numberLimitPurchase);
		passPage.inputToTextboxLimitPurchasePopup("shows", numberLimitPurchase);
		passPage.inputToTextboxLimitPurchasePopup("tickets per show", numberLimitPurchase);
		passPage.inputToTextboxPlaceholderPopup("Start date", startDate);
		passPage.inputToTextboxPlaceholderPopup("End date", endDate);
		passPage.inputToTextboxNamePopup("Access code","ABCD");

		passPage.clickToSaveButton();
		verifyEquals(passPage.getTextOfAlert(), "Pass '"+passDelete+"' was created successfully");
		passPage.clickToCloseAlertButton();
		passPage.sleepInSecond(2);
		passPage.clickToActionButton(passDelete,"Delete");
		passPage.acceptAlert(driver);
		verifyEquals(passPage.getTextOfAlert(), "Pass '"+passDelete+"' was deleted successfully.");
		passPage.clickToCloseAlertButton();
	}
	
	@Description("Buy Pass has Access Code")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_009_BuyPass_BuyPassAccessCode() {

		passPage.clickToItemOfLeftMenu("Calendar");
		passPage.clickToPrevButton();
		passPage.clickToEvent(eventNameAccess);
		String managerPage = driver.getWindowHandle();	
		passPage.clickToLink("Preview");	
		passPage.switchToWindowByID(managerPage);
		
		passPage.inputToTextboxCouponBuyOnline(accessCode);
		passPage.clickToSendCouponButton();
		assertEquals(passPage.getSuccessMessage(),"Retrieved a secret pass.");

		passPage.clickToDropDownSelectQuantityTicket(passAccessCode, quantityTicket);
		passPage.sleepInSecond(1);
		passPage.clickToAgreeCheckoutButton();

		passPage.inputInfoBuyerTextbox("Full Name", fullName);
		passPage.inputInfoBuyerTextbox("Phone", phone);
		passPage.inputInfoBuyerTextbox("Email", validEmail);
		passPage.inputInfoBuyerTextbox("Confirm Email", validEmail);

		passPage.clickCheckboxAcceptTermsService();
		
		passPage.getTextTotalAmountOrder();
		passPage.sleepInSecond(3);
		
		if ((passPage.getTextTotalAmountOrder()).equals("0$")) {
			passPage.sleepInSecond(2);
			passPage.clickPlaceOrderButton();
			assertTrue(passPage.isCheckoutSuccessTextDisplayed());
		} else {
			passPage.switchToFrameIframe();
			passPage.inputInfoCardManual("Card number", cardNumberValid);
			passPage.inputInfoCardManual("MM / YY", monthYearValid);
			passPage.inputInfoCardManual("CVC", cvc);
			passPage.inputInfoCardManual("ZIP", zip);
			passPage.switchToDefaultContent();
			passPage.sleepInSecond(2);
			passPage.clickPlaceOrderButton();
			assertTrue(passPage.isCheckoutSuccessTextDisplayed());
		}
		
		String buyOnlineSuccessWindowID = driver.getWindowHandle();
		driver.close();
		passPage.switchToWindowByID(buyOnlineSuccessWindowID);
		
		passPage.openNewTab();
		passPage.inputToTextboxLogin(validEmail);
		passPage.clickToSwitchToEmail();
		passPage.sleepInSecond(10);
		passPage.refreshToPage(driver);
		
		passPage.switchToIframeInbox();
		passPage.clickToViewEmail();
		passPage.switchToDefaultInbox();

		passPage.switchToIframeEmail();
		passCode = passPage.getTextOfPassCode();
		passPage.switchToDefaultEmail();
		
		String yopMail = driver.getWindowHandle();
		driver.close();
		passPage.switchToWindowByID(yopMail);
		
		passPage.clickToLink("Cancel");
		
	}
	

	@Description("Open Box Office")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_010_ApplyPass_001_OpenUrlBoxOffice() {
		String boxOfficeWindowID = driver.getWindowHandle();		
		passPage.clickToItemOfLeftMenu("Box office");
		passPage.switchToWindowByID(boxOfficeWindowID);
		assertTrue(passPage.isBoxOfficeTextDisplayed());
	}
	
	@Description("Apply For Box Office - Multi Pass - Event Not Support")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_011_ApplyPass_002_ApplyForBoxMultiPassEventNotSupport() {
		passPage.clickToValueOfDropdown("venue", "City Theater");
		passPage.clickToValueOfDropdown("ticket", eventNameMulti);
		passPage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
		
		passPage.clickToValueOfDropdownCoupon("123343222");
		passPage.clickButtonCheckout("Checkout now");
		assertEquals(passPage.getErrorMessageCheckoutUseCoupon(),"Coupon/gift card/Pass code not found. Please note that coupon/gift card/Pass codes are case sensitive so make sure you type it in correctly.");

		passPage.clickToValueOfDropdownCoupon(passCode);
		passPage.clickButtonCheckout("Checkout now");
		passPage.clickButtonCheckout("Checkout now");
		assertEquals(passPage.getErrorMessageCheckoutUseCoupon(),"Sorry, you cannot use your pass for this purchase. See your email confirmation for details about ticket levels and events for which your pass is valid.");
	}
	
	@Description("Apply For Box Office - Multi Pass - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_012_ApplyPass_003_ApplyForBoxMultiPassOfficeSuccess() {
		passPage.clickToValueOfDropdown("venue", "City Theater");
		passPage.clickToValueOfDropdown("ticket", eventNameAccess);
		passPage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);		
		passPage.clickToValueOfDropdownCoupon(passCode);
		passPage.clickToRadioButtonPaymentCheckout("Cash");
		passPage.clickButtonCheckout("Checkout now");
		passPage.isTextCheckoutScreenDisplayed();
		passPage.isTextDiscountDisplayed("Pass code discount");
		passPage.clickButtonPlaceOrder();
		assertTrue(passPage.isSuccessOrderTextDisplayed());	

		passPage.refreshToPage(driver);
	}
	
	@Description("Apply For Box Office - Multi Pass - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_013_ApplyPass_004_ApplyForBoxMultiPassTicketInvalid() {
		passPage.clickToValueOfDropdown("venue", "City Theater");
		passPage.clickToValueOfDropdown("ticket", eventNameAccess);
		passPage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);		
		passPage.clickToValueOfDropdownCoupon(passCode);
		passPage.clickButtonCheckout("Checkout now");
		assertEquals(passPage.getErrorMessageCheckoutUseCoupon(),"You've exceeded the amount of tickets you can get with your pass.");
		String managerPage = driver.getWindowHandle();	
		driver.close();
		passPage.switchToWindowByID(managerPage);
	}
	
	@Description("Buy Pass has Access Code for use buy online")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_014_BuyPass_BuyPassAccessCode_ForUseBuyOnline() {
		passPage.clickToEvent(eventNameAccess);
		String managerPage = driver.getWindowHandle();	
		passPage.clickToLink("Preview");	
		passPage.switchToWindowByID(managerPage);
		
		passPage.inputToTextboxCouponBuyOnline(accessCode);
		passPage.clickToSendCouponButton();
		assertEquals(passPage.getSuccessMessage(),"Retrieved a secret pass.");
		passPage.sleepInSecond(2);
		passPage.clickToDropDownSelectQuantityTicket(passAccessCode, quantityTicket);
		passPage.sleepInSecond(1);
		passPage.clickToAgreeCheckoutButton();

		passPage.inputInfoBuyerTextbox("Full Name", fullName);
		passPage.inputInfoBuyerTextbox("Phone", phone);
		passPage.inputInfoBuyerTextbox("Email", validEmail);
		passPage.inputInfoBuyerTextbox("Confirm Email", validEmail);

		passPage.clickCheckboxAcceptTermsService();
		
		passPage.getTextTotalAmountOrder();
		passPage.sleepInSecond(3);
		
		if ((passPage.getTextTotalAmountOrder()).equals("$0.00")) {
			passPage.sleepInSecond(2);
			passPage.clickPlaceOrderButton();
			assertTrue(passPage.isCheckoutSuccessTextDisplayed());
		} else {
			passPage.switchToFrameIframe();
			passPage.inputInfoCardManual("Card number", cardNumberValid);
			passPage.inputInfoCardManual("MM / YY", monthYearValid);
			passPage.inputInfoCardManual("CVC", cvc);
			passPage.inputInfoCardManual("ZIP", zip);
			passPage.switchToDefaultContent();
			passPage.sleepInSecond(2);
			passPage.clickPlaceOrderButton();
			assertTrue(passPage.isCheckoutSuccessTextDisplayed());
		}
		
		String buyOnlineSuccessWindowID = driver.getWindowHandle();
		driver.close();
		passPage.switchToWindowByID(buyOnlineSuccessWindowID);
		passPage.sleepInSecond(10);
		
		passPage.openNewTab();
		passPage.inputToTextboxLogin(validEmail);
		passPage.clickToSwitchToEmail();
		passPage.sleepInSecond(10);
		passPage.refreshToPage(driver);
		
		passPage.switchToIframeInbox();
		passPage.clickToViewEmail();
		passPage.switchToDefaultInbox();

		passPage.switchToIframeEmail();
		passCode = passPage.getTextOfPassCode();
		passPage.switchToDefaultEmail();
		
		String yopMail = driver.getWindowHandle();
		driver.close();
		passPage.switchToWindowByID(yopMail);
		
		passPage.clickToLink("Cancel");



	}
	
	@Description("Apply For Buy Online - Multi Pass - Fail")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_015_ApplyPass_002_ApplyForBuyOnlineMultiPassEventNotSupport() {
		passPage.clickToItemOfLeftMenu("Calendar");
		passPage.clickToPrevButton();
		passPage.clickToEvent(eventNameMulti);
		String managerPage = driver.getWindowHandle();	
		passPage.clickToLink("Preview");	
		passPage.switchToWindowByID(managerPage);
		
		passPage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
		passPage.inputToTextboxCouponBuyOnline("2323123");
		passPage.clickToSendCouponButton();
		assertEquals(passPage.getErrorMessage(),"Coupon/gift card/Pass code not found. Please note that coupon/gift card/Pass codes are case sensitive so make sure you type it in correctly.");
	
		passPage.inputToTextboxCouponBuyOnline(passCode);
		passPage.clickToSendCouponButton();
		assertEquals(passPage.getErrorMessage(),"Sorry, you cannot use your pass for this purchase. See your email confirmation for details about ticket levels and events for which your pass is valid.");

		String buyOnlineSuccessWindowID = driver.getWindowHandle();
		driver.close();
		passPage.switchToWindowByID(buyOnlineSuccessWindowID);
		passPage.clickToLink("Cancel");
	}
	
	@Description("Apply For Buy Online - Multi Pass - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_016_ApplyPass_002_ApplyForBuyOnlineMultiPassOfficeSuccess() {
		String boxOfficeWindowID = driver.getWindowHandle();		
		passPage.switchToWindowByID(boxOfficeWindowID);
		passPage.clickToEvent(eventNameAccess);
		String managerPage = driver.getWindowHandle();	
		passPage.clickToLink("Preview");	
		passPage.switchToWindowByID(managerPage);
		
		passPage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
		passPage.inputToTextboxCouponBuyOnline(passCode);
		passPage.clickToSendCouponButton();
		passPage.sleepInSecond(3);
//		assertEquals(passPage.getSuccessMessage(),"Success! You can use this pass to reserve seats for these ticket levels");
		passPage.clickToAgreeCheckoutButton();

		passPage.inputInfoBuyerTextbox("Full Name", fullName);
		passPage.inputInfoBuyerTextbox("Phone", phone);
		passPage.inputInfoBuyerTextbox("Email", validEmail);
		passPage.inputInfoBuyerTextbox("Confirm Email", validEmail);
		passPage.clickCheckboxAcceptTermsService();
		passPage.isTextDiscountDisplayed("Pass code discount");
		passPage.getTextTotalAmountOrder();
		passPage.sleepInSecond(3);
		
		if ((passPage.getTextTotalAmountOrder()).equals("$0.00")) {
			passPage.sleepInSecond(2);
			passPage.clickPlaceOrderButton();
		} else {
			passPage.switchToFrameIframe();
			passPage.sleepInSecond(2);
			passPage.inputInfoCardManual("Card number", cardNumberValid);
			passPage.inputInfoCardManual("MM / YY", monthYearValid);
			passPage.inputInfoCardManual("CVC", cvc);
			passPage.inputInfoCardManual("ZIP", zip);
			passPage.switchToDefaultContent();
			passPage.sleepInSecond(3);
			passPage.clickPlaceOrderButton();
		}

		assertTrue(passPage.isCheckoutSuccessTextDisplayed());
		
	}
	

	@Description("Apply For Buy Online - Multi Pass - Fail ( Invalid)")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_017_ApplyPass_003_ApplyForBuyOnlineMultiPassTicketInvalid() {
		String boxOfficeWindowID = driver.getWindowHandle();		
		passPage.switchToWindowByID(boxOfficeWindowID);
		passPage.refreshToPage(driver);
		passPage.clickToEvent(eventNameAccess);
		String managerPage = driver.getWindowHandle();	
		passPage.clickToLink("Preview");	
		passPage.switchToWindowByID(managerPage);
		
		passPage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
		passPage.inputToTextboxCouponBuyOnline(passCode);
		passPage.clickToSendCouponButton();
		assertEquals(passPage.getErrorMessage(),"You've exceeded the amount of tickets you can get with your pass.");
	}


	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(999);
	}
	
	
	@AfterClass
	public void afterClass() {
//		driver.quit();
		closeBrowserDriver();
	}
}

