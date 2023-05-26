package showslinger_user;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.user.UserBuyOnlinePageObject;

public class User_07_Buy_Online extends BaseTest{

	private UserBuyOnlinePageObject buyOnlinePage;
	private String fullName, phone, email;
	private String cardNumberValid, cardNumberInvalid, cardNumberDeclined, monthYearValid, monthYearInvalid, cvc, zip;

	//portalURL: buyonline
	@Parameters({"browser", "portalURL"})
	@BeforeClass
	public void beforeClass(String browserName, String portalURL) {
		driver = getBrowserDriver(browserName, portalURL);
		buyOnlinePage = new UserBuyOnlinePageObject(driver);
		fullName = "Dang Thi Giang";
		phone = "+128379292999";
		email = "dangthigiang+2@mobilefolk.com";

		cardNumberValid = "4242424242424242";
		cardNumberDeclined ="4000000000000002";
		monthYearValid = "0424";
		cvc = "242";
		zip = "42424";
		cardNumberInvalid="2323232323232323";
		monthYearInvalid = "0420";
	}

	@Test
	public void Buy_Online_01_Buy_Ticket_Success_Checkout_Now() {
		System.out.println("Buy_Online_01 - Step 01: Verify Event Name");
		Assert.assertEquals(buyOnlinePage.getTextEventName(),"Giang Test auto");

		if (buyOnlinePage.isTextSelectTicketsDisplayed()) {
			System.out.println("Buy_Online_01 - Step 02: Select quantity ticket");
			buyOnlinePage.clickToDropDownSelectTicket();
			buyOnlinePage.clickToValueOfDropdownSelectTicket();
			
			System.out.println("Buy_Online_01 - Step 03: Click button Agree & Checkout");
			buyOnlinePage.clickToAgreeCheckoutButton();

			System.out.println("Buy_Online_01 - Step 04: Verify Checkout screen");
			Assert.assertTrue(buyOnlinePage.isCheckoutTextDisplayed());

			System.out.println("Buy_Online_01 - Step 05: Input info buyer");
			buyOnlinePage.inputToFullNameTextbox(fullName);
			buyOnlinePage.inputToPhoneTextbox(phone);
			buyOnlinePage.inputToEmailTextbox(email);
			buyOnlinePage.inputToConfirmEmailTextbox(email);

			System.out.println("Buy_Online_01 - Step 06: Input info card & Click checkbox accept the Terms of Service");
			if (buyOnlinePage.isCardInfoTextDisplayed()) {
				buyOnlinePage.switchToFrameIframe();
				buyOnlinePage.inputToCardNumberTextbox(cardNumberValid);
				buyOnlinePage.inputToMonthYearTextbox(monthYearValid);
				buyOnlinePage.inputToCVCTextbox(cvc);
				buyOnlinePage.inputToZipTextbox(zip);
				buyOnlinePage.switchToDefaultContent();

				buyOnlinePage.clickCheckboxAcceptTermsService();
			}else {
				buyOnlinePage.clickCheckboxAcceptTermsService();
			}		

			System.out.println("Buy_Online_01 - Step 07: Click Place Order button");
			buyOnlinePage.clickPlaceOrderButton();

			System.out.println("Buy_Online_01 - Step 08: Verify text order success");
			Assert.assertTrue(buyOnlinePage.isCheckoutSuccessTextDisplayed());

			System.out.println("Buy_Online_01 - Step 09: Click button Print Order");
			String buyOnlineSuccessWindowID = driver.getWindowHandle();
			buyOnlinePage.clickPrintOrderButton();
			buyOnlinePage.switchToWindowByID(buyOnlineSuccessWindowID);

			String printOrderWindowID = driver.getWindowHandle();
			driver.close();
			buyOnlinePage.switchToWindowByID(printOrderWindowID);
			
			System.out.println("Buy_Online_01 - Step 10: Click button Back To Event Page");
			buyOnlinePage.clickBackToEventPageButton();

			System.out.println("Buy_Online_01 - Step 11: Verify Event Name");
			Assert.assertEquals(buyOnlinePage.getTextEventName(),"Giang Test auto");
		} else {
			System.out.println("Event has no ticket");
		}
	}
	
	@Test
	public void Buy_Online_02_Buy_Add_Ons_Success_Checkout_Now() {
		System.out.println("Buy_Online_01 - Step 01: Verify Event Name");
		Assert.assertEquals(buyOnlinePage.getTextEventName(),"Giang Test auto");

		if (buyOnlinePage.isTextSelectAddOnsDisplayed()) {
			System.out.println("Buy_Online_01 - Step 02: Select quantity ticket");
			buyOnlinePage.clickToDropDownSelectAddOns();
			buyOnlinePage.clickToValueOfDropdownSelectAddOns();
			
			System.out.println("Buy_Online_01 - Step 03: Click button Agree & Checkout");
			buyOnlinePage.clickToAgreeCheckoutButton();

			System.out.println("Buy_Online_01 - Step 04: Verify Checkout screen");
			Assert.assertTrue(buyOnlinePage.isCheckoutTextDisplayed());

			System.out.println("Buy_Online_01 - Step 05: Input info buyer");
			buyOnlinePage.inputToFullNameTextbox(fullName);
			buyOnlinePage.inputToPhoneTextbox(phone);
			buyOnlinePage.inputToEmailTextbox(email);
			buyOnlinePage.inputToConfirmEmailTextbox(email);

			System.out.println("Buy_Online_01 - Step 06: Input info card & Click checkbox accept the Terms of Service");
			if (buyOnlinePage.isCardInfoTextDisplayed()) {
				buyOnlinePage.switchToFrameIframe();
				buyOnlinePage.inputToCardNumberTextbox(cardNumberValid);
				buyOnlinePage.inputToMonthYearTextbox(monthYearValid);
				buyOnlinePage.inputToCVCTextbox(cvc);
				buyOnlinePage.inputToZipTextbox(zip);
				buyOnlinePage.switchToDefaultContent();

				buyOnlinePage.clickCheckboxAcceptTermsService();
			}else {
				buyOnlinePage.clickCheckboxAcceptTermsService();
			}		

			System.out.println("Buy_Online_01 - Step 07: Click Place Order button");
			buyOnlinePage.clickPlaceOrderButton();

			System.out.println("Buy_Online_01 - Step 08: Verify text order success");
			Assert.assertTrue(buyOnlinePage.isCheckoutSuccessTextDisplayed());

			System.out.println("Buy_Online_01 - Step 09: Click button Print Order");
			String buyOnlineSuccessWindowID = driver.getWindowHandle();
			buyOnlinePage.clickPrintOrderButton();
			buyOnlinePage.switchToWindowByID(buyOnlineSuccessWindowID);

			String printOrderWindowID = driver.getWindowHandle();
			driver.close();
			buyOnlinePage.switchToWindowByID(printOrderWindowID);
			
			System.out.println("Buy_Online_01 - Step 10: Click button Back To Event Page");
			buyOnlinePage.clickBackToEventPageButton();

			System.out.println("Buy_Online_01 - Step 11: Verify Event Name");
			Assert.assertEquals(buyOnlinePage.getTextEventName(),"Giang Test auto");
		} else {
			System.out.println("Event has no ticket");
		}
	}

	@Test
	public void Buy_Online_03_Buy_Passes_Success_Checkout_Now() {
		System.out.println("Buy_Online_01 - Step 01: Verify Event Name");
		Assert.assertEquals(buyOnlinePage.getTextEventName(),"Giang Test auto");

		if (buyOnlinePage.isTextSelectPassesDisplayed()) {
			System.out.println("Buy_Online_01 - Step 02: Select quantity ticket");
			buyOnlinePage.clickToDropDownSelectPass();
			buyOnlinePage.clickToValueOfDropdownSelectPass();
			
			System.out.println("Buy_Online_01 - Step 03: Click button Agree & Checkout");
			buyOnlinePage.clickToAgreeCheckoutButton();

			System.out.println("Buy_Online_01 - Step 04: Verify Checkout screen");
			Assert.assertTrue(buyOnlinePage.isCheckoutTextDisplayed());

			System.out.println("Buy_Online_01 - Step 05: Input info buyer");
			buyOnlinePage.inputToFullNameTextbox(fullName);
			buyOnlinePage.inputToPhoneTextbox(phone);
			buyOnlinePage.inputToEmailTextbox(email);
			buyOnlinePage.inputToConfirmEmailTextbox(email);

			System.out.println("Buy_Online_01 - Step 06: Input info card & Click checkbox accept the Terms of Service");
			if (buyOnlinePage.isCardInfoTextDisplayed()) {
				buyOnlinePage.switchToFrameIframe();
				buyOnlinePage.inputToCardNumberTextbox(cardNumberValid);
				buyOnlinePage.inputToMonthYearTextbox(monthYearValid);
				buyOnlinePage.inputToCVCTextbox(cvc);
				buyOnlinePage.inputToZipTextbox(zip);
				buyOnlinePage.switchToDefaultContent();

				buyOnlinePage.clickCheckboxAcceptTermsService();
			}else {
				buyOnlinePage.clickCheckboxAcceptTermsService();
			}		

			System.out.println("Buy_Online_01 - Step 07: Click Place Order button");
			buyOnlinePage.clickPlaceOrderButton();

			System.out.println("Buy_Online_01 - Step 08: Verify text order success");
			Assert.assertTrue(buyOnlinePage.isCheckoutSuccessTextDisplayed());

			System.out.println("Buy_Online_01 - Step 09: Click button Print Order");
			String buyOnlineSuccessWindowID = driver.getWindowHandle();
			buyOnlinePage.clickPrintOrderButton();
			buyOnlinePage.switchToWindowByID(buyOnlineSuccessWindowID);

			String printOrderWindowID = driver.getWindowHandle();
			driver.close();
			buyOnlinePage.switchToWindowByID(printOrderWindowID);
			
			System.out.println("Buy_Online_01 - Step 10: Click button Back To Event Page");
			buyOnlinePage.clickBackToEventPageButton();

			System.out.println("Buy_Online_01 - Step 11: Verify Event Name");
			Assert.assertEquals(buyOnlinePage.getTextEventName(),"Giang Test auto");
		} else {
			System.out.println("Event has no ticket");
		}
	}
	
	@Test
	public void Buy_Online_04_Buy_Gift_Card_Success_Checkout_Now() {
		System.out.println("Buy_Online_01 - Step 01: Verify Event Name");
		Assert.assertEquals(buyOnlinePage.getTextEventName(),"Giang Test auto");

		if (buyOnlinePage.isTextSelectGiftCardDisplayed()) {
			System.out.println("Buy_Online_01 - Step 02: Select quantity ticket");
			buyOnlinePage.clickToDropDownSelectGiftCard();
			buyOnlinePage.clickToValueOfDropdownSelectGiftCard();
			
			System.out.println("Buy_Online_01 - Step 03: Click button Agree & Checkout");
			buyOnlinePage.clickToAgreeCheckoutButton();

			System.out.println("Buy_Online_01 - Step 04: Verify Checkout screen");
			Assert.assertTrue(buyOnlinePage.isCheckoutTextDisplayed());

			System.out.println("Buy_Online_01 - Step 05: Input info buyer");
			buyOnlinePage.inputToFullNameTextbox(fullName);
			buyOnlinePage.inputToPhoneTextbox(phone);
			buyOnlinePage.inputToEmailTextbox(email);
			buyOnlinePage.inputToConfirmEmailTextbox(email);

			System.out.println("Buy_Online_01 - Step 06: Input info card & Click checkbox accept the Terms of Service");
			if (buyOnlinePage.isCardInfoTextDisplayed()) {
				buyOnlinePage.switchToFrameIframe();
				buyOnlinePage.inputToCardNumberTextbox(cardNumberValid);
				buyOnlinePage.inputToMonthYearTextbox(monthYearValid);
				buyOnlinePage.inputToCVCTextbox(cvc);
				buyOnlinePage.inputToZipTextbox(zip);
				buyOnlinePage.switchToDefaultContent();

				buyOnlinePage.clickCheckboxAcceptTermsService();
			}else {
				buyOnlinePage.clickCheckboxAcceptTermsService();
			}		

			System.out.println("Buy_Online_01 - Step 07: Click Place Order button");
			buyOnlinePage.clickPlaceOrderButton();

			System.out.println("Buy_Online_01 - Step 08: Verify text order success");
			Assert.assertTrue(buyOnlinePage.isCheckoutSuccessTextDisplayed());

			System.out.println("Buy_Online_01 - Step 09: Click button Print Order");
			String buyOnlineSuccessWindowID = driver.getWindowHandle();
			buyOnlinePage.clickPrintOrderButton();
			buyOnlinePage.switchToWindowByID(buyOnlineSuccessWindowID);

			String printOrderWindowID = driver.getWindowHandle();
			driver.close();
			buyOnlinePage.switchToWindowByID(printOrderWindowID);
			
			System.out.println("Buy_Online_01 - Step 10: Click button Back To Event Page");
			buyOnlinePage.clickBackToEventPageButton();

			System.out.println("Buy_Online_01 - Step 11: Verify Event Name");
			Assert.assertEquals(buyOnlinePage.getTextEventName(),"Giang Test auto");
		} else {
			System.out.println("Event has no ticket");
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
