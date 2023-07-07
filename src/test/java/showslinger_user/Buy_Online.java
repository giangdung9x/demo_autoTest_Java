package showslinger_user;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.user.UserBuyOnlinePageObject;

public class Buy_Online extends BaseTest{

	private UserBuyOnlinePageObject buyOnlinePage;
	private String fullName, phone, validEmail, invalidEmail, confirmEmail;
	private String cardNumberValid, cardNumberInvalid, cardNumberDeclined, monthYearValid, monthYearInvalid, cvc, zip, errorMessageInfoCard;
	private String eventName, ticketName, quantity, addOnsName, passName, giftCardName;
	private int shortTime;
	
	@Parameters({ "envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName,
	@Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String
	portNumber,@Optional("Windows") String osName, @Optional("10") String osVersion) {
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
		buyOnlinePage = new UserBuyOnlinePageObject(driver);
		fullName = "Dang Thi Giang";
		phone = "+128379292999";
		validEmail = "dangthigiang+2@mobilefolk.com";
		invalidEmail = "dangthigiang+2@";
		confirmEmail= "dangthigiang+3@mobilefolk.com";
				
		eventName = "Giang Test auto";
		ticketName ="vip3";
		quantity ="1";
		addOnsName = "coca";
		passName = "giang test pass"; 
		giftCardName = "Gift Card";
		shortTime =3;
		
		cardNumberValid = "4242424242424242";
		cardNumberDeclined ="4000000000000002";
		monthYearValid = "0424";
		cvc = "242";
		zip = "42424";
		cardNumberInvalid="2323232323232323";
		monthYearInvalid = "0420";
		
		
	}

	
	@Description("Buy Ticket - Checkout when empty data")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void BuyOnline_001_CheckoutEmptyQuantityTicket() {
		
		assertEquals(buyOnlinePage.getTextEventName(),eventName);
		
		buyOnlinePage.clickToAgreeCheckoutButton();
		
		assertEquals(buyOnlinePage.getErrorMessage(),"Please select tickets and add-ons you would like to buy!");
		
		buyOnlinePage.refreshToPage(driver);
	}
	
	@Description("Buy Ticket - Checkout when empty info of buyer")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void BuyOnline_002_CheckoutEmptyInfoBuyer() {
		buyOnlinePage.clickToDropDownSelectQuantityTicket(ticketName, quantity);
		
		buyOnlinePage.clickToAgreeCheckoutButton();
		
		buyOnlinePage.clickPlaceOrderButton();
		assertEquals(buyOnlinePage.getErrorMessageAtCheckoutScreen(), "Please input your full name!");
		buyOnlinePage.sleepInSecond(shortTime);

		buyOnlinePage.inputInfoBuyerTextbox("Full Name", fullName);
		buyOnlinePage.clickPlaceOrderButton();
		assertEquals(buyOnlinePage.getErrorMessageAtCheckoutScreen(), "Please input your phone!");
		
		buyOnlinePage.inputInfoBuyerTextbox("Phone", phone);
		buyOnlinePage.clickPlaceOrderButton();
		assertEquals(buyOnlinePage.getErrorMessageAtCheckoutScreen(), "Please input your email!");
		buyOnlinePage.sleepInSecond(shortTime);

		buyOnlinePage.inputInfoBuyerTextbox("Email", invalidEmail);
		buyOnlinePage.clickPlaceOrderButton();
		assertEquals(buyOnlinePage.getErrorMessageAtCheckoutScreen(), "Please input your verify email!");
		buyOnlinePage.sleepInSecond(shortTime);

		buyOnlinePage.inputInfoBuyerTextbox("Confirm Email", invalidEmail);
		buyOnlinePage.clickPlaceOrderButton();
		buyOnlinePage.clickPlaceOrderButton();
		assertEquals(buyOnlinePage.getErrorMessageAtCheckoutScreen(), "Your email is not valid. Please enter it again!");
		buyOnlinePage.sleepInSecond(shortTime);

		buyOnlinePage.inputInfoBuyerTextbox("Email", validEmail);
		buyOnlinePage.clickPlaceOrderButton();
		assertEquals(buyOnlinePage.getErrorMessageAtCheckoutScreen(), "Your email is not valid. Please enter it again!");
		buyOnlinePage.sleepInSecond(shortTime);

		buyOnlinePage.inputInfoBuyerTextbox("Confirm Email", confirmEmail);
		buyOnlinePage.clickPlaceOrderButton();
		buyOnlinePage.clickPlaceOrderButton();
		assertEquals(buyOnlinePage.getErrorMessageAtCheckoutScreen(), "Make sure your emails match. Please try again.");
		buyOnlinePage.sleepInSecond(shortTime);

		buyOnlinePage.inputInfoBuyerTextbox("Email", validEmail);
		buyOnlinePage.inputInfoBuyerTextbox("Confirm Email", validEmail);
	}

	@Description("Buy Ticket - checkout when not accecpt terms of service")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void BuyOnline_003_CheckoutNowNotAcceptTerms() {
		buyOnlinePage.clickPlaceOrderButton();
		
		assertEquals(buyOnlinePage.getErrorMessageAtFooter(), "Please accept the Terms of Service before placing your order.");
	}

	@Description("Buy Ticket - Checkout method: Checkout now  - when empty info of card")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void BuyOnline_004_CheckoutNowNotInputCard() {
		buyOnlinePage.clickCheckboxAcceptTermsService();

		buyOnlinePage.getTextTotalAmountOrder();
		buyOnlinePage.sleepInSecond(3);
		
		if ((buyOnlinePage.getTextTotalAmountOrder()).equals("0$")) {
			buyOnlinePage.clickPlaceOrderButton();
		} else {
			buyOnlinePage.clickPlaceOrderButton();
			buyOnlinePage.clickPlaceOrderButton();

			assertEquals(buyOnlinePage.getErrorMessagePurchaseFailed(),"Purchase Failed");
			buyOnlinePage.sleepInSecond(shortTime);

			buyOnlinePage.switchToFrameIframe();
			buyOnlinePage.inputInfoCardManual("Card number",cardNumberInvalid);
			buyOnlinePage.switchToDefaultContent();

			assertEquals(buyOnlinePage.getErrorMessageAtCheckoutScreen(),"Your card number is invalid.");
			buyOnlinePage.sleepInSecond(shortTime);

			buyOnlinePage.switchToFrameIframe();
			buyOnlinePage.inputInfoCardManual("Card number", cardNumberDeclined);
			buyOnlinePage.inputInfoCardManual("MM / YY", monthYearValid);
			buyOnlinePage.inputInfoCardManual("CVC", cvc);
			buyOnlinePage.inputInfoCardManual("ZIP", zip);

			buyOnlinePage.switchToDefaultContent();

			buyOnlinePage.clickPlaceOrderButton();

			assertEquals(buyOnlinePage.getErrorMessagePurchaseFailed(),"Purchase Failed");
			buyOnlinePage.sleepInSecond(shortTime);

			buyOnlinePage.switchToFrameIframe();
			buyOnlinePage.inputInfoCardManual("Card number", cardNumberValid);
			buyOnlinePage.inputInfoCardManual("MM / YY", monthYearInvalid);

			buyOnlinePage.switchToDefaultContent();

			assertEquals(buyOnlinePage.getErrorMessageAtCheckoutScreen(),"Your card's expiration year is in the past.");
			buyOnlinePage.sleepInSecond(shortTime);

			buyOnlinePage.clickPlaceOrderButton();

			assertEquals(buyOnlinePage.getErrorMessagePurchaseFailed(),"Purchase Failed");
			buyOnlinePage.sleepInSecond(shortTime);

			buyOnlinePage.switchToFrameIframe();
			buyOnlinePage.inputInfoCardManual("Card number", cardNumberValid);
			buyOnlinePage.switchToDefaultContent();

			buyOnlinePage.clickPlaceOrderButton();

			assertEquals(buyOnlinePage.getErrorMessagePurchaseFailed(),"Purchase Failed");
			buyOnlinePage.sleepInSecond(shortTime);

			buyOnlinePage.switchToFrameIframe();
			buyOnlinePage.inputInfoCardManual("Card number", cardNumberValid);
			buyOnlinePage.inputInfoCardManual("MM / YY", monthYearValid);

			buyOnlinePage.switchToDefaultContent();

			buyOnlinePage.clickPlaceOrderButton();

			assertEquals(buyOnlinePage.getErrorMessagePurchaseFailed(),"Purchase Failed");
			buyOnlinePage.sleepInSecond(shortTime);

			buyOnlinePage.switchToFrameIframe();
			buyOnlinePage.inputInfoCardManual("Card number", cardNumberValid);
			buyOnlinePage.inputInfoCardManual("MM / YY", monthYearValid);
			buyOnlinePage.inputInfoCardManual("CVC", cvc);
			buyOnlinePage.switchToDefaultContent();

			buyOnlinePage.clickPlaceOrderButton();

			assertEquals(buyOnlinePage.getErrorMessagePurchaseFailed(),"Purchase Failed");
			buyOnlinePage.sleepInSecond(shortTime);

			buyOnlinePage.refreshToPage(driver);
			
		}
	}

	@Description("Buy Ticket - Checkout method: Checkout now  - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void BuyOnline_005_CheckoutNowSuccess() {
		buyOnlinePage.clickToDropDownSelectQuantityTicket(ticketName, quantity);
		buyOnlinePage.clickToAgreeCheckoutButton();
		
		buyOnlinePage.inputInfoBuyerTextbox("Full Name", fullName);
		buyOnlinePage.inputInfoBuyerTextbox("Phone", phone);
		buyOnlinePage.inputInfoBuyerTextbox("Email", validEmail);
		buyOnlinePage.inputInfoBuyerTextbox("Confirm Email", validEmail);

		buyOnlinePage.clickCheckboxAcceptTermsService();
		
		buyOnlinePage.getTextTotalAmountOrder();
		buyOnlinePage.sleepInSecond(3);
		
		if ((buyOnlinePage.getTextTotalAmountOrder()).equals("0$")) {
			buyOnlinePage.clickPlaceOrderButton();
		} else {

			buyOnlinePage.switchToFrameIframe();
			buyOnlinePage.inputInfoCardManual("Card number", cardNumberValid);
			buyOnlinePage.inputInfoCardManual("MM / YY", monthYearValid);
			buyOnlinePage.inputInfoCardManual("CVC", cvc);
			buyOnlinePage.inputInfoCardManual("ZIP", zip);
			buyOnlinePage.switchToDefaultContent();

			buyOnlinePage.clickPlaceOrderButton();
			
			assertTrue(buyOnlinePage.isCheckoutSuccessTextDisplayed());

			String buyOnlineSuccessWindowID = driver.getWindowHandle();
			buyOnlinePage.clickPrintOrderButton();
			buyOnlinePage.switchToWindowByID(buyOnlineSuccessWindowID);

			String printOrderWindowID = driver.getWindowHandle();
			driver.close();
			buyOnlinePage.switchToWindowByID(printOrderWindowID);
			
			buyOnlinePage.clickBackToEventPageButton();

			assertEquals(buyOnlinePage.getTextEventName(),eventName);
		}
	}

	@Description("Buy Ticket - Checkout method: Buy now pay later - Fail")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void BuyOnline_006_CheckoutPayLaterFail() {
		buyOnlinePage.clickToDropDownSelectQuantityTicket(ticketName, quantity);
		buyOnlinePage.clickToAgreeCheckoutButton();
		
		buyOnlinePage.inputInfoBuyerTextbox("Full Name", fullName);
		buyOnlinePage.inputInfoBuyerTextbox("Phone", phone);
		buyOnlinePage.inputInfoBuyerTextbox("Email", validEmail);
		buyOnlinePage.inputInfoBuyerTextbox("Confirm Email", validEmail);

		buyOnlinePage.clickCheckboxAcceptTermsService();
		
		buyOnlinePage.getTextTotalAmountOrder();
		buyOnlinePage.sleepInSecond(3);
		
		if ((buyOnlinePage.getTextTotalAmountOrder()).equals("0$")) {
			buyOnlinePage.clickPlaceOrderButton();
			
			assertTrue(buyOnlinePage.isCheckoutSuccessTextDisplayed());

			String buyOnlineSuccessWindowID = driver.getWindowHandle();
			buyOnlinePage.clickPrintOrderButton();
			buyOnlinePage.switchToWindowByID(buyOnlineSuccessWindowID);

			String printOrderWindowID = driver.getWindowHandle();
			driver.close();
			buyOnlinePage.switchToWindowByID(printOrderWindowID);
			
			buyOnlinePage.clickBackToEventPageButton();

			assertEquals(buyOnlinePage.getTextEventName(),eventName);
		} else {
			int amount = buyOnlinePage.convertTotalAmountToInt();

			if(amount < 50) {
				buyOnlinePage.clickToRadioButtonCheckoutMethod();
				
				assertEquals(buyOnlinePage.getErrorMessageBNPL(),"Buy now pay later is only available for orders totaling $50 or more.");
				
				buyOnlinePage.clickCheckboxAcceptTermsService();

				buyOnlinePage.clickToBackToTicket();
				
			}else {
				buyOnlinePage.clickToRadioButtonCheckoutMethod();

				buyOnlinePage.clickToBuyNowPayLaterButton();
				
				buyOnlinePage.clickButtonFailTestPayment();
				
				assertEquals(buyOnlinePage.getTextOfAlertCheckoutFail(),"Checkout order failed! Please select your ticket and checkout again.");
				buyOnlinePage.acceptAlert();

				assertEquals(buyOnlinePage.getTextEventName(),eventName);
			}
			
		}
	}


	@Description("Buy Ticket - Checkout method: Buy now pay later - Fail")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void BuyTicket_007_CheckoutPayLaterSuccess() {
		buyOnlinePage.clickToDropDownSelectQuantityTicket(ticketName, "5");
		buyOnlinePage.clickToAgreeCheckoutButton();
		
		buyOnlinePage.inputInfoBuyerTextbox("Full Name", fullName);
		buyOnlinePage.inputInfoBuyerTextbox("Phone", phone);
		buyOnlinePage.inputInfoBuyerTextbox("Email", validEmail);
		buyOnlinePage.inputInfoBuyerTextbox("Confirm Email", validEmail);

		buyOnlinePage.clickCheckboxAcceptTermsService();
		
		buyOnlinePage.getTextTotalAmountOrder();
		buyOnlinePage.sleepInSecond(3);
		
		if ((buyOnlinePage.getTextTotalAmountOrder()).equals("0$")) {
			buyOnlinePage.clickPlaceOrderButton();
			
			assertTrue(buyOnlinePage.isCheckoutSuccessTextDisplayed());

			String buyOnlineSuccessWindowID = driver.getWindowHandle();
			buyOnlinePage.clickPrintOrderButton();
			buyOnlinePage.switchToWindowByID(buyOnlineSuccessWindowID);

			String printOrderWindowID = driver.getWindowHandle();
			driver.close();
			buyOnlinePage.switchToWindowByID(printOrderWindowID);
			
			buyOnlinePage.clickBackToEventPageButton();

			assertEquals(buyOnlinePage.getTextEventName(),eventName);
		} else {
			int amount = buyOnlinePage.convertTotalAmountToInt();
			
			if(amount < 50) {
				buyOnlinePage.clickToRadioButtonCheckoutMethod();
				
				assertEquals(buyOnlinePage.getErrorMessageBNPL(),"Buy now pay later is only available for orders totaling $50 or more.");
				
				buyOnlinePage.clickToBackToTicket();
				
			}else {
				buyOnlinePage.clickToRadioButtonCheckoutMethod();

				buyOnlinePage.clickToBuyNowPayLaterButton();
				
				buyOnlinePage.clickButtonAuthorizeTestPayment();
				
				assertTrue(buyOnlinePage.isCheckoutSuccessTextDisplayed());

				String buyOnlineSuccessWindowID = driver.getWindowHandle();
				buyOnlinePage.clickPrintOrderButton();
				buyOnlinePage.switchToWindowByID(buyOnlineSuccessWindowID);

				String printOrderWindowID = driver.getWindowHandle();
				driver.close();
				buyOnlinePage.switchToWindowByID(printOrderWindowID);
				
				buyOnlinePage.clickBackToEventPageButton();

				assertEquals(buyOnlinePage.getTextEventName(),eventName);
			}
		}
	}


	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
