package showslinger_user;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.user.UserActionOfEventPageObject;
import pageObject.user.UserCouponPageObject;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;

import static org.testng.Assert.assertFalse;

//Actions of tickets Create/ Edit/Transfer Ticket
public class Feature_Coupons extends BaseTest{
	private UserCouponPageObject couponPage;
	private String emailManager, passwordManager,expirationDateInvalid, expirationDateValid;
	private String couponName, couponNameInavlid, couponNameExist,couponNameAuto, eventName, eventNameAuto;
	private String ticketName, quantityTicket;
	private String descriptionAuto, descriptionManual;


	//portalURL: homepage
	@Parameters({"browser", "portalURL"})
	@BeforeClass
	public void beforeClass(String browserName, String portalURL) {
		
		driver = getBrowserDriver(browserName, portalURL);
		couponPage = new UserCouponPageObject(driver);
		
		emailManager ="paulv@showslinger.com";
		passwordManager = "12345";
		expirationDateInvalid = "06-13-2023";
		expirationDateValid  = "06-30-2024";
		
		couponNameExist = "Coupon" + generateFakeNumber();
		couponNameInavlid = "Coupon" + " "+ generateFakeNumber();
		couponName="Coupon" + generateFakeNumber();
		couponNameAuto="Coupon1" + generateFakeNumber();
		eventName = "Giang Test auto";
		eventNameAuto = "Giang Test 06";
		
		ticketName ="vip3";
		quantityTicket ="2";
		descriptionAuto="Auto Apply";
		descriptionManual="Manual Apply";
		
	}

	@Description("Login Account")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void Coupons_OpenUrlAndLogin() {
		
		couponPage.clickToLoginLink();

		couponPage.loginAccount(emailManager,passwordManager);

		couponPage.clickToLoginButton();
		
		couponPage.clickToItemOfLeftMenu("Ticketing");
		
		couponPage.clickToItemOfListTicketing("Coupons");
		
		verifyTrue(couponPage.isTextNameOfScreenDisplayed("Coupons"));
	}
	
	
	
	@Description("Create Coupons - Fail")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void Coupons_001_CreateCouponFail() {

		//Pre-conditions: 
		couponPage.clickToAddCouponButton();
		
		verifyTrue(couponPage.isTextNameOfPopupDisplayed("Create Coupon"));
		
		couponPage.inputToTextboxPlaceholderCouponPopup("Code", couponNameExist);
		couponPage.inputToTextboxPlaceholderCouponPopup("Tell the buyer", couponNameExist);
		couponPage.clickToValueOfDropdownOfPopup("Discount", "%");
		couponPage.inputToTextboxPlaceholderCouponPopup("0", "10");
		couponPage.inputToTextboxPlaceholderCouponPopup("Date", expirationDateValid);

		couponPage.clickToSaveCouponButton();
		verifyEquals(couponPage.getTextOfAlert(), "Coupon '"+couponNameExist+"' was created successfully");
		couponPage.clickToCloseAlertButton();
		
		//TCs
		couponPage.clickToAddCouponButton();
		verifyTrue(couponPage.isTextNameOfPopupDisplayed("Create Coupon"));
		
		couponPage.clickToSaveCouponButton();
		verifyEquals(couponPage.getTextOfAlert(), "invalid date");
		couponPage.clickToCloseAlertButton();

		couponPage.inputToTextboxPlaceholderCouponPopup("Code", couponNameInavlid);
		couponPage.inputToTextboxPlaceholderCouponPopup("Tell the buyer", "Test");
		couponPage.inputToTextboxPlaceholderCouponPopup("Date", expirationDateValid);
		couponPage.clickToSaveCouponButton();
		verifyEquals(couponPage.getTextOfAlert(), "Discount amount is invalid");
		couponPage.clickToCloseAlertButton();
		
		couponPage.inputToTextboxPlaceholderCouponPopup("0", "10");
		couponPage.clickToSaveCouponButton();
		verifyEquals(couponPage.getTextOfAlert(), "The coupon code should not contain any space characters. Please remove it.");
		couponPage.clickToCloseAlertButton();

		couponPage.inputToTextboxPlaceholderCouponPopup("Code", couponNameExist);
		couponPage.clickToSaveCouponButton();
		verifyEquals(couponPage.getTextOfAlert(), "This coupon code already exists. Please create a different code");
		couponPage.clickToCloseAlertButton();

		couponPage.inputToTextboxPlaceholderCouponPopup("Code", couponName);
		couponPage.inputToTextboxPlaceholderCouponPopup("Date", expirationDateInvalid);
		couponPage.clickToSaveCouponButton();
		verifyEquals(couponPage.getTextOfAlert(),"The expiration date has already passed. To make this coupon active, change the expiration to a future date.");
		couponPage.clickToCloseAlertButton();

		couponPage.inputToTextboxPlaceholderCouponPopup("Date", expirationDateValid);
		couponPage.inputToTextboxNameCouponPopup("Code uses limit", "0");
		couponPage.clickToSaveCouponButton();
		verifyEquals(couponPage.getTextOfAlert(),"Code uses limit is invalid");
		couponPage.clickToCloseAlertButton();

		couponPage.clickToClosePopupButton();
	}
	
	

	@Description("Create Coupons - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3)
	public void Coupons_002_CreateCouponSuccess() {
		couponPage.clickToAddCouponButton();
		
		verifyTrue(couponPage.isTextNameOfPopupDisplayed("Create Coupon"));
		
		couponPage.inputToTextboxPlaceholderCouponPopup("Code", couponName);
		couponPage.inputToTextboxPlaceholderCouponPopup("Tell the buyer", descriptionManual);
		couponPage.clickToValueOfDropdownOfPopup("Discount", "%");
		couponPage.inputToTextboxPlaceholderCouponPopup("0", "10");
		couponPage.inputToTextboxNameCouponPopup("Min tix per order", "2");
		couponPage.inputToTextboxNameCouponPopup("Max tix per order", "3");
		couponPage.clickToValueOfDropdownOfPopup("Select event(s)", eventName);
		couponPage.inputToTextboxPlaceholderCouponPopup("Date", expirationDateValid);

		couponPage.clickToSaveCouponButton();
		verifyEquals(couponPage.getTextOfAlert(), "Coupon '"+couponName+"' was created successfully");
		couponPage.clickToCloseAlertButton();
	}	
	
	@Description("Create Coupon - Success: Auto Apply")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 4)
	public void Coupons_004_CreateCouponSuccessAutoApply() {

		couponPage.clickToAddCouponButton();
		
		verifyTrue(couponPage.isTextNameOfPopupDisplayed("Create Coupon"));
		
		couponPage.inputToTextboxPlaceholderCouponPopup("Code", couponNameAuto);
		couponPage.inputToTextboxPlaceholderCouponPopup("Tell the buyer", descriptionAuto);
		couponPage.clickToValueOfDropdownOfPopup("Discount", "%");
		couponPage.inputToTextboxPlaceholderCouponPopup("0", "10");
		couponPage.sleepInSecond(3);
		couponPage.inputToTextboxPlaceholderCouponPopup("Date", expirationDateValid);
		couponPage.clickToValueOfDropdownOfPopup("Select event(s)", eventNameAuto);

		couponPage.clickToSaveCouponButton();
		verifyEquals(couponPage.getTextOfAlert(), "Coupon '"+couponNameAuto+"' was created successfully");
		couponPage.clickToCloseAlertButton();
	}
	
	
	
	@Description("Edit Coupon - Fail")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 5)
	public void Coupons_005_EditCouponFail() {
		couponPage.clickToActionButton(couponName,"Edit");
		couponPage.inputToTextboxPlaceholderCouponPopup("Code", couponNameExist);
		couponPage.clickToSaveCouponButton();
		verifyEquals(couponPage.getTextOfAlert(),"This code already exists. Please use a different code");
		couponPage.clickToCloseAlertButton();
		couponPage.clickToClosePopupButton();
	}
	
	
	
	@Description("Edit Coupon - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 6)
	public void Coupons_006_ActiveCouponFail() {
		couponPage.clickToActionButton("testmin","Activate");
		verifyEquals(couponPage.getTextOfAlert(),"The expiration date has already passed. To make this coupon active, change the expiration to a future date.");
		couponPage.clickToCloseAlertButton();
	}
	
	
	
	@Description("Change Satus Coupon - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 7)
	public void Coupons_007_ChangeSatusCouponSuccess() {
		couponPage.clickToActionButton(couponName,"Deactivate");
		verifyEquals(couponPage.getTextOfAlert(), "Deactivated the coupon '"+couponName+"' successfully.");
		couponPage.clickToActionButton(couponName,"Activate");
		verifyEquals(couponPage.getTextOfAlert(), "Activated the coupon '"+couponName+"' successfully.");
	}
	
//	@Description("Open Box Office")
//	@Severity(SeverityLevel.NORMAL)
//	@Test(priority = 8)
//	public void ApplyCoupon_001_OpenUrlBoxOffice() {
//		String boxOfficeWindowID = driver.getWindowHandle();		
//		couponPage.clickToItemOfLeftMenu("Box office");
//		couponPage.switchToWindowByID(boxOfficeWindowID);
//		assertTrue(couponPage.isBoxOfficeTextDisplayed());
//		
//	}
//	
//	@Description("Apply For Box Office - Manual Coupon - Event Not Support")
//	@Severity(SeverityLevel.NORMAL)
//	@Test(priority = 9)
//	public void ApplyCoupon_002_ApplyForBoxManualCouponEventNotSupport() {
//		couponPage.clickToValueOfDropdown("venue", "City Theater");
//		couponPage.clickToValueOfDropdown("ticket", "Giang Test Transfer");
//		couponPage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
//		
//		couponPage.clickToValueOfDropdownCoupon("128379082");
//		couponPage.clickButtonCheckout("Checkout now");
//		assertEquals(couponPage.getErrorMessageCheckoutUseCoupon(),"Coupon/gift card/Pass code not found. Please note that coupon/gift card/Pass codes are case sensitive so make sure you type it in correctly.");
//
//		couponPage.clickToValueOfDropdownCoupon(couponName);
//		couponPage.clickButtonCheckout("Checkout now");
//		couponPage.clickButtonCheckout("Checkout now");
//		assertEquals(couponPage.getErrorMessageCheckoutUseCoupon(),"Coupon code not found.");
//
//	}
//	
//	
//	@Description("Apply For Box Office - Manual Coupon - Deactivate")
//	@Severity(SeverityLevel.NORMAL)
//	@Test(priority = 10)
//	public void ApplyCoupon_003_ApplyForBoxManualCouponDeactivate() {
//		String boxOfficeWindowID = driver.getWindowHandle();	
//		couponPage.switchToWindowByID(boxOfficeWindowID);
//		couponPage.clickToActionButton(couponName,"Deactivate");
//		verifyEquals(couponPage.getTextOfAlert(), "Deactivated the coupon '"+couponName+"' successfully.");
//		
//		String managerPage = driver.getWindowHandle();	
//		couponPage.switchToWindowByID(managerPage);
//		couponPage.clickToValueOfDropdown("ticket",eventName);
//		couponPage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
//		couponPage.clickToValueOfDropdownCoupon(couponName);
//		couponPage.clickButtonCheckout("Checkout now");
//		assertEquals(couponPage.getErrorMessageCheckoutUseCoupon(),"The event organizer has deactivated this code.");
//
//	}
//	
//	@Description("Apply For Box Office - Manual Coupon - Ticket Invalid")
//	@Severity(SeverityLevel.NORMAL)
//	@Test(priority = 11)
//	public void ApplyCoupon_004_ApplyForBoxManualCouponTicketInvalid() {
//		String managerPage = driver.getWindowHandle();	
//		couponPage.switchToWindowByID(managerPage);
//		
//		couponPage.clickToActionButton(couponName,"Activate");
//		verifyEquals(couponPage.getTextOfAlert(), "Activated the coupon '"+couponName+"' successfully.");
//		
//		String boxOfficeWindowID = driver.getWindowHandle();		
//		couponPage.switchToWindowByID(boxOfficeWindowID);
//		couponPage.clickToDropDownSelectQuantityTicket(ticketName, "4");
//		couponPage.clickToValueOfDropdownCoupon(couponName);
//		couponPage.clickButtonCheckout("Checkout now");
//		couponPage.clickButtonCheckout("Checkout now");
//		
//		couponPage.clickToDropDownSelectQuantityTicket(ticketName, "1");
//		couponPage.clickToValueOfDropdownCoupon(couponName);
//		couponPage.clickButtonCheckout("Checkout now");
//		couponPage.clickButtonCheckout("Checkout now");
//
//	}
//	
//	
//	@Description("Apply For Box Office - Manual Coupon - Success")
//	@Severity(SeverityLevel.NORMAL)
//	@Test(priority = 12)
//	public void ApplyCoupon_005_ApplyForBoxManualCouponOfficeSuccess() {
//		couponPage.clickToDropDownSelectQuantityTicket(ticketName, "2");
//		couponPage.clickButtonCheckout("Checkout now");
//		couponPage.isTextCheckoutScreenDisplayed();
//		couponPage.refreshToPage(driver);
//	}
//	
//	@Description("Apply For Box Office - Auto Coupon - Success")
//	@Severity(SeverityLevel.NORMAL)
//	@Test(priority = 13)
//	public void ApplyCoupon_006_ApplyForBoxAutoCouponOfficeSuccess() {
//		couponPage.clickToValueOfDropdown("venue", "City Theater");
//		couponPage.clickToValueOfDropdown("ticket",eventNameAuto);
//		couponPage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
//		couponPage.clickButtonCheckout("Checkout now");
//		couponPage.isTextDiscountDisplayed();
//		couponPage.refreshToPage(driver);
//	}
//	
//	@Description("Apply For Box Office - Auto Coupon - Fail")
//	@Severity(SeverityLevel.NORMAL)
//	@Test(priority = 14)
//	public void ApplyCoupon_007_ApplyForBoxAutoCouponOfficeSuccess() {
//		couponPage.clickToValueOfDropdown("venue", "City Theater");
//		couponPage.clickToValueOfDropdown("ticket",eventNameAuto);
//		couponPage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
//		couponPage.clickButtonCheckout("Checkout now");
//		couponPage.isTextDiscountDisplayed();
//		String managerPage = driver.getWindowHandle();	
//		driver.close();
//		couponPage.switchToWindowByID(managerPage);
//	}
	
	@Description("Apply For Buy Online - Manual Coupon - Deactivate")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 15)
	public void ApplyCoupon_008_ApplyForBuyOnlineManualCouponDeactivate() {
		couponPage.clickToActionButton(couponName,"Deactivate");
		verifyEquals(couponPage.getTextOfAlert(), "Deactivated the coupon '"+couponName+"' successfully.");
		
		couponPage.clickToItemOfLeftMenu("Calendar");
		couponPage.clickToPrevButton();
		couponPage.clickToEvent(eventName);
		String managerPage = driver.getWindowHandle();	
		couponPage.clickToLink("Preview");	
		couponPage.switchToWindowByID(managerPage);
		
		couponPage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
		couponPage.inputToTextboxCouponBuyOnline(couponName);
		couponPage.clickToSendCouponButton();
		assertEquals(couponPage.getErrorMessage(),"The event organizer has deactivated this code.");
	}
	
	
	@Description("Apply For Buy Online - Manual Coupon - Ticket Invalid")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 16)
	public void ApplyCoupon_009_ApplyForBuyOnlineManualCouponTicketInvalid() {
		couponPage.inputToTextboxCouponBuyOnline(couponNameAuto);
		couponPage.clickToSendCouponButton();
		assertEquals(couponPage.getErrorMessage(),"Coupon code not found.");
		
	}
	
	@Description("Apply For Buy Online - Manual Coupon - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 17)
	public void ApplyCoupon_010_ApplyForBuyOnlineManualCouponSuccess() {
		String boxOfficeWindowID = driver.getWindowHandle();		
		couponPage.switchToWindowByID(boxOfficeWindowID);
		couponPage.clickToLink("Cancel");
		couponPage.clickToItemOfLeftMenu("Ticketing");
		couponPage.clickToItemOfListTicketing("Coupons");
		
		couponPage.clickToActionButton(couponName,"Activate");
		verifyEquals(couponPage.getTextOfAlert(), "Activated the coupon '"+couponName+"' successfully.");
		
		String managerPage = driver.getWindowHandle();	
		couponPage.switchToWindowByID(managerPage);
		
		couponPage.inputToTextboxCouponBuyOnline(couponName);
		couponPage.clickToSendCouponButton();
		assertEquals(couponPage.getSuccessMessage(),descriptionManual);
		couponPage.clickToAgreeCheckoutButton();
		couponPage.isTextDiscountDisplayed();
		driver.close();
		couponPage.switchToWindowByID(boxOfficeWindowID);
	}
	
	
	@Description("Apply For Buy Online - Auto Coupon - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 18)
	public void ApplyCoupon_011_ApplyForBuyOnlineAutoCouponSuccess() {
		couponPage.clickToItemOfLeftMenu("Calendar");
		couponPage.clickToPrevButton();
		couponPage.clickToEvent(eventNameAuto);
		String managerPage = driver.getWindowHandle();	
		couponPage.clickToLink("Preview");	
		couponPage.switchToWindowByID(managerPage);
		
		couponPage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
		couponPage.clickToAgreeCheckoutButton();
		couponPage.isTextDiscountDisplayed();
	}
	

	
	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(999);
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}

