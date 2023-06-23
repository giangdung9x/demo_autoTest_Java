package showslinger_user;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.user.UserGiftCardPageObject;

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
public class Feature_Gift_Card extends BaseTest{
	private UserGiftCardPageObject giftCardPage;
	private String emailManager, passwordManager,startDate, endDate, accessCode;
	private String giftCard, giftCardAccessCode, eventName, eventNameAccess;
	private String ticketName, quantityTicket, quantityGiftCard;
	private String negativeLimit, giftCardCode;
	private String fullName, phone, validEmail;
	private String cardNumberValid, monthYearValid,  cvc, zip;

	//portalURL: homepage
	@Parameters({"browser", "portalURL"})
	@BeforeClass
	public void beforeClass(String browserName, String portalURL) {
		
		driver = getBrowserDriver(browserName, portalURL);
		giftCardPage = new UserGiftCardPageObject(driver);

		emailManager ="paulv@showslinger.com";
		passwordManager = "12345";
		startDate = "06-13-2023";
		endDate  = "06-13-2024";
		
		giftCard =  "Gift Card" + " "+ generateFakeNumber();
		giftCardAccessCode =  "Gift Card Access Code" + " "+ generateFakeNumber();

		eventName = "Giang Test auto";
		eventNameAccess = "Giang Test 07";
		
		ticketName ="vip3";
		quantityTicket ="2";
		quantityGiftCard ="1";

		negativeLimit = "-1";
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
	@Test(priority = 1)
	public void GiftCard_OpenUrlAndLogin() {
		
		giftCardPage.clickToLoginLink();

		giftCardPage.loginAccount(emailManager,passwordManager);

		giftCardPage.clickToLoginButton();
		
		giftCardPage.clickToItemOfLeftMenu("Ticketing");
		
		giftCardPage.clickToItemOfListTicketing("Gift cards");
		
		verifyTrue(giftCardPage.isTextNameOfScreenDisplayed("Gift Cards"));
	}
	
	
	
	@Description("Create Gift Card - Fail")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void GiftCard_001_CreateGiftCardFail() {
		giftCardPage.clickToAddButton("Gift Card");
		
		verifyTrue(giftCardPage.isTextNameOfPopupDisplayed("Create Gift Card"));
		
		giftCardPage.clickToClosePopupButton();	
	}
	

	@Description("Create Gift Card - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3)
	public void GiftCard_002_CreateGiftCardNotAccessSuccess() {
		giftCardPage.clickToAddButton("Gift Card");
		
		verifyTrue(giftCardPage.isTextNameOfPopupDisplayed("Create Gift Card"));
		
		giftCardPage.inputToTextboxNamePopup("Name",giftCard);
		giftCardPage.inputToTextboxPlaceholderDescriptionPopup("Description", giftCard);
		giftCardPage.inputToTextboxPlaceholderPopup("Start date", startDate);
		giftCardPage.inputToTextboxPlaceholderPopup("End date", endDate);
		giftCardPage.inputToTextboxPrice("10");
		giftCardPage.clickToValueOfDropdownOfPopup("Select event", eventNameAccess);	
		//giftCardPage.clickToToggle();
		giftCardPage.sleepInSecond(5); //open On Sale
		giftCardPage.clickToSaveButton();
		verifyTrue(giftCardPage.getNameOfGiftCard(giftCard));
	}	
	
	@Description("Create Gift Card Multi - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 4)
	public void GiftCard_003_CreateGiftCardAccessSuccess() {
	giftCardPage.clickToAddButton("Gift Card");
		
		verifyTrue(giftCardPage.isTextNameOfPopupDisplayed("Create Gift Card"));
		
		giftCardPage.inputToTextboxNamePopup("Name",giftCardAccessCode);
		giftCardPage.inputToTextboxPlaceholderDescriptionPopup("Description", giftCardAccessCode);
		giftCardPage.inputToTextboxPlaceholderPopup("Start date", startDate);
		giftCardPage.inputToTextboxPlaceholderPopup("End date", endDate);
		giftCardPage.inputToTextboxPrice("10");
		giftCardPage.clickToValueOfDropdownOfPopup("Select event", eventNameAccess);	
		giftCardPage.inputToTextboxNamePopup("Access code",accessCode);
		//giftCardPage.clickToToggle();
		giftCardPage.sleepInSecond(5); //open On Sale
		giftCardPage.clickToSaveButton();
		verifyTrue(giftCardPage.getNameOfGiftCard(giftCardAccessCode));
	}	
	
	@Description("Buy Gift Card has Access Code")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 5)
	public void BuyGiftCard_NeedAccessCode() {	

		giftCardPage.clickToItemOfLeftMenu("Calendar");
		giftCardPage.clickToPrevButton();
		giftCardPage.clickToEvent(eventNameAccess);
		String managerPage = driver.getWindowHandle();	
		giftCardPage.clickToLink("Preview");	
		giftCardPage.switchToWindowByID(managerPage);
		
		giftCardPage.inputToTextboxCouponBuyOnline(accessCode);
		giftCardPage.clickToSendCouponButton();
		assertEquals(giftCardPage.getSuccessMessage(),"Retrieved a secret gift card.");

		giftCardPage.clickToDropDownSelectQuantityGiftCard(giftCardAccessCode, quantityGiftCard);
		giftCardPage.clickToAgreeCheckoutButton();

		giftCardPage.inputInfoBuyerTextbox("Full Name", fullName);
		giftCardPage.inputInfoBuyerTextbox("Phone", phone);
		giftCardPage.inputInfoBuyerTextbox("Email", validEmail);
		giftCardPage.inputInfoBuyerTextbox("Confirm Email", validEmail);

		giftCardPage.clickCheckboxAcceptTermsService();
		
		giftCardPage.getTextTotalAmountOrder();
		giftCardPage.sleepInSecond(3);
		
		if ((giftCardPage.getTextTotalAmountOrder()).equals("0$")) {
			giftCardPage.clickPlaceOrderButton();
			assertTrue(giftCardPage.isCheckoutSuccessTextDisplayed());
		} else {

			giftCardPage.switchToFrameIframe();
			giftCardPage.inputInfoCardManual("Card number", cardNumberValid);
			giftCardPage.inputInfoCardManual("MM / YY", monthYearValid);
			giftCardPage.inputInfoCardManual("CVC", cvc);
			giftCardPage.inputInfoCardManual("ZIP", zip);
			giftCardPage.switchToDefaultContent();

			giftCardPage.clickPlaceOrderButton();
			assertTrue(giftCardPage.isCheckoutSuccessTextDisplayed());
		}
		
		String buyOnlineSuccessWindowID = driver.getWindowHandle();
		driver.close();
		giftCardPage.switchToWindowByID(buyOnlineSuccessWindowID);
		
		giftCardPage.openNewTab();
		giftCardPage.inputToTextboxLogin(validEmail);
		giftCardPage.clickToSwitchToEmail();
		giftCardPage.sleepInSecond(10);
		giftCardPage.refreshToPage(driver);
		
		giftCardPage.switchToIframeInbox();
		giftCardPage.clickToViewEmail();
		giftCardPage.switchToDefaultInbox();

		giftCardPage.switchToIframeEmail();
		giftCardCode = giftCardPage.getTextOfGiftCardCode("Gift card code:").substring("Gift card code: ".length());
		giftCardPage.switchToDefaultEmail();
		
		String yopMail = driver.getWindowHandle();
		driver.close();
		giftCardPage.switchToWindowByID(yopMail);
		
		giftCardPage.clickToLink("Cancel");
		
	}
	

	@Description("Open Box Office")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 6)
	public void ApplyGiftCard_001_OpenUrlBoxOffice() {
		String boxOfficeWindowID = driver.getWindowHandle();		
		giftCardPage.clickToItemOfLeftMenu("Box office");
		giftCardPage.switchToWindowByID(boxOfficeWindowID);
		assertTrue(giftCardPage.isBoxOfficeTextDisplayed());
	}
	
	@Description("Apply For Box Office - Gift Card - Event Not Support")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 7)
	public void ApplyGiftCard_002_ApplyForBoxMultiGiftCardEventNotSupport() {
		giftCardPage.clickToValueOfDropdown("venue", "City Theater");
		giftCardPage.clickToValueOfDropdown("ticket", eventName);
		giftCardPage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
		
		giftCardPage.clickToValueOfDropdownCoupon("123343222");
		giftCardPage.clickButtonCheckout("Checkout now");
		assertEquals(giftCardPage.getErrorMessageCheckoutUseCoupon(),"Coupon/gift card/Pass code not found. Please note that coupon/gift card/Pass codes are case sensitive so make sure you type it in correctly.");
	}
	
	@Description("Apply For Box Office - Gift Card - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 8)
	public void ApplyGiftCard_003_ApplyForBoxMultiGiftCardOfficeSuccess() {
		giftCardPage.clickToValueOfDropdown("venue", "City Theater");
		giftCardPage.clickToValueOfDropdown("ticket", eventNameAccess);
		giftCardPage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);		
		giftCardPage.clickToValueOfDropdownCoupon(giftCardCode);
		giftCardPage.clickToRadioButtonPaymentCheckout("Cash");
		giftCardPage.clickButtonCheckout("Checkout now");
		giftCardPage.isTextCheckoutScreenDisplayed();
		giftCardPage.isTextDiscountDisplayed("Gift card discount");
		giftCardPage.clickButtonPlaceOrder();
		assertTrue(giftCardPage.isSuccessOrderTextDisplayed());	
		giftCardPage.refreshToPage(driver);
	}
	
	@Description("Apply For Box Office - Gift Card - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 9)
	public void ApplyGiftCard_004_ApplyForBoxMultiGiftCardTicketInvalid() {
		giftCardPage.clickToValueOfDropdown("venue", "City Theater");
		giftCardPage.clickToValueOfDropdown("ticket", eventNameAccess);
		giftCardPage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);		
		giftCardPage.clickToValueOfDropdownCoupon(giftCardCode);
		giftCardPage.clickButtonCheckout("Checkout now");
		assertEquals(giftCardPage.getErrorMessageCheckoutUseCoupon(),"Gift card code was used! Please buy new gift code.");
		String managerPage = driver.getWindowHandle();	
		driver.close();
		giftCardPage.switchToWindowByID(managerPage);
	}
	
	@Description("Buy Gift Card has Access Code for use buy online")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 10)
	public void BuyGiftCard_NeedAccessCode_ForUseBuyOnline() {	
		giftCardPage.clickToEvent(eventNameAccess);
		String managerPage = driver.getWindowHandle();	
		giftCardPage.clickToLink("Preview");	
		giftCardPage.switchToWindowByID(managerPage);
		
		giftCardPage.inputToTextboxCouponBuyOnline(accessCode);
		giftCardPage.clickToSendCouponButton();
		assertEquals(giftCardPage.getSuccessMessage(),"Retrieved a secret gift card.");

		giftCardPage.clickToDropDownSelectQuantityGiftCard(giftCardAccessCode, quantityGiftCard);
		giftCardPage.clickToAgreeCheckoutButton();

		giftCardPage.inputInfoBuyerTextbox("Full Name", fullName);
		giftCardPage.inputInfoBuyerTextbox("Phone", phone);
		giftCardPage.inputInfoBuyerTextbox("Email", validEmail);
		giftCardPage.inputInfoBuyerTextbox("Confirm Email", validEmail);

		giftCardPage.clickCheckboxAcceptTermsService();
		
		giftCardPage.getTextTotalAmountOrder();
		giftCardPage.sleepInSecond(3);
		
		if ((giftCardPage.getTextTotalAmountOrder()).equals("0$")) {
			giftCardPage.clickPlaceOrderButton();
			assertTrue(giftCardPage.isCheckoutSuccessTextDisplayed());
		} else {

			giftCardPage.switchToFrameIframe();
			giftCardPage.inputInfoCardManual("Card number", cardNumberValid);
			giftCardPage.inputInfoCardManual("MM / YY", monthYearValid);
			giftCardPage.inputInfoCardManual("CVC", cvc);
			giftCardPage.inputInfoCardManual("ZIP", zip);
			giftCardPage.switchToDefaultContent();

			giftCardPage.clickPlaceOrderButton();
			assertTrue(giftCardPage.isCheckoutSuccessTextDisplayed());
		}
		
		String buyOnlineSuccessWindowID = driver.getWindowHandle();
		driver.close();
		giftCardPage.switchToWindowByID(buyOnlineSuccessWindowID);
		giftCardPage.sleepInSecond(10);
		
		giftCardPage.openNewTab();
		giftCardPage.inputToTextboxLogin(validEmail);
		giftCardPage.clickToSwitchToEmail();
		giftCardPage.sleepInSecond(10);
		giftCardPage.refreshToPage(driver);
		
		giftCardPage.switchToIframeInbox();
		giftCardPage.clickToViewEmail();
		giftCardPage.switchToDefaultInbox();

		giftCardPage.switchToIframeEmail();
		giftCardCode = giftCardPage.getTextOfGiftCardCode("Gift card code:").substring("Gift card code: ".length());
		giftCardPage.switchToDefaultEmail();
		
		String yopMail = driver.getWindowHandle();
		driver.close();
		giftCardPage.switchToWindowByID(yopMail);
		
		giftCardPage.clickToLink("Cancel");
	}
	
	@Description("Apply For Buy Online - Gift Card - Fail")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 11)
	public void ApplyGiftCard_005_ApplyForBuyOnlineMultiGiftCardEventNotSupport() {
		giftCardPage.clickToItemOfLeftMenu("Calendar");
		giftCardPage.clickToPrevButton();
		giftCardPage.clickToEvent(eventName);
		String managerPage = driver.getWindowHandle();	
		giftCardPage.clickToLink("Preview");	
		giftCardPage.switchToWindowByID(managerPage);
		
		giftCardPage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
		giftCardPage.inputToTextboxCouponBuyOnline("2323123");
		giftCardPage.clickToSendCouponButton();
		assertEquals(giftCardPage.getErrorMessage(),"Coupon/gift card/Pass code not found. Please note that coupon/gift card/Pass codes are case sensitive so make sure you type it in correctly.");
	
		String buyOnlineSuccessWindowID = driver.getWindowHandle();
		driver.close();
		giftCardPage.switchToWindowByID(buyOnlineSuccessWindowID);
		giftCardPage.clickToLink("Cancel");
	}
	
	@Description("Apply For Buy Online - Gift Card  - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 12)
	public void ApplyGiftCard_006_ApplyForBuyOnlineMultiGiftCardOfficeSuccess() {
		String boxOfficeWindowID = driver.getWindowHandle();		
		giftCardPage.switchToWindowByID(boxOfficeWindowID);
		giftCardPage.clickToEvent(eventNameAccess);
		String managerPage = driver.getWindowHandle();	
		giftCardPage.clickToLink("Preview");	
		giftCardPage.switchToWindowByID(managerPage);
		
		giftCardPage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
		giftCardPage.inputToTextboxCouponBuyOnline(giftCardCode);
		giftCardPage.clickToSendCouponButton();
//		assertEquals(giftCardPage.getSuccessMessage(),"Success! You can use this pass to reserve seats for these ticket levels");
		giftCardPage.clickToAgreeCheckoutButton();

		giftCardPage.inputInfoBuyerTextbox("Full Name", fullName);
		giftCardPage.inputInfoBuyerTextbox("Phone", phone);
		giftCardPage.inputInfoBuyerTextbox("Email", validEmail);
		giftCardPage.inputInfoBuyerTextbox("Confirm Email", validEmail);

		giftCardPage.clickCheckboxAcceptTermsService();
		giftCardPage.isTextDiscountDisplayed("Gift card discount");

		giftCardPage.getTextTotalAmountOrder();
		giftCardPage.sleepInSecond(3);
		
		if ((giftCardPage.getTextTotalAmountOrder()).equals("0$")) {
			giftCardPage.clickPlaceOrderButton();
			assertTrue(giftCardPage.isCheckoutSuccessTextDisplayed());
		} else {

			giftCardPage.switchToFrameIframe();
			giftCardPage.inputInfoCardManual("Card number", cardNumberValid);
			giftCardPage.inputInfoCardManual("MM / YY", monthYearValid);
			giftCardPage.inputInfoCardManual("CVC", cvc);
			giftCardPage.inputInfoCardManual("ZIP", zip);
			giftCardPage.switchToDefaultContent();

			giftCardPage.clickPlaceOrderButton();
			assertTrue(giftCardPage.isCheckoutSuccessTextDisplayed());
		}
		
		giftCardPage.refreshToPage(driver);
		
	}
	

	@Description("Apply For Buy Online - Gift Card - Fail ( Invalid)")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 17)
	public void ApplyGiftCard_007_ApplyForBuyOnlineMultiGiftCardTicketInvalid() {
		giftCardPage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
		giftCardPage.inputToTextboxCouponBuyOnline(giftCardCode);
		giftCardPage.clickToSendCouponButton();
		assertEquals(giftCardPage.getErrorMessageCheckoutUseCoupon(),"Gift card code was used! Please buy new gift code.");
	}


	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(999);
	}
	
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}

