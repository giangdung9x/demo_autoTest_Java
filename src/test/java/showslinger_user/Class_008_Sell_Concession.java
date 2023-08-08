package showslinger_user;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.user.UserSellConcessionPageObject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;

import static org.testng.Assert.assertFalse;


public class Class_008_Sell_Concession extends BaseTest{
	private  UserSellConcessionPageObject concessionPage;
	private String emailConcession, passwordConcession;
	int randomNumber = generateFakeNumber();
	private String fullName, phone,email, notes ;
	private String cardNumber, month,cvc, zip ;
	private String amount,noteMisc ;
	private String eventName;
	int shorTime;

	@Parameters({ "envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName,
	@Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String
	portNumber,@Optional("Windows") String osName, @Optional("10") String osVersion) {
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
		concessionPage = new UserSellConcessionPageObject(driver);
		
		emailConcession ="dangthigiang@mobilefolk.com";
		passwordConcession = "123456";
		eventName = "Giang Test auto";
		
		fullName= "Dang Thi Giang" + randomNumber;
		phone= "8127382" + randomNumber;
		email= "dangthigiang"+randomNumber+"@mobilefolk.com";
		notes= "Note" + randomNumber;

		cardNumber = "4242424242424242";
		month = "0442";
		cvc = "242";
		zip = "42424";
		
		amount= "10";
		noteMisc = "Test Misc";
		shorTime =2;
	}

	@Description("Login Account")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void Concessions_OpenUrlAndLogin() {
		concessionPage.clickToLoginLink();
		concessionPage.loginAccount(emailConcession,passwordConcession);
		concessionPage.clickToLoginButton();
		verifyTrue(concessionPage.isTextSelectEventWantToWorkDisplayed());
		concessionPage.clickToChooseEventButton(eventName);
		//concessionPage.clickToButtonLogout();
	}

	@Description("Concessions Sales - CheckoutAddOns - Card Swiper")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void ConcessionsSales_CheckoutAddOns_CardSwiper() {
		concessionPage.plusAddOnsCheckout();
		concessionPage.compareAmounts();
		concessionPage.clickToRadioButtonPaymentCheckout("Card swiper");
		concessionPage.clickCheckboxConfirmationDeliveryAll("Email", "Text");
		concessionPage.inputToTextboxInfoBuyer(fullName, phone, email, notes);
		concessionPage.clickToButtonPlaceOrder();
		concessionPage.isSuccessOrderTextDisplayed();
		concessionPage.clickToClosePopupCheckout();
		concessionPage.sleepInSecond(shorTime);
	}
	
	@Description("Concessions Sales - CheckoutAddOns - Enter Card Manually")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3)
	public void ConcessionsSales_CheckoutAddOns_EnterCardManually() {
		concessionPage.plusAddOnsCheckout();
		concessionPage.compareAmounts();
		concessionPage.clickToRadioButtonPaymentCheckout("Enter card manually");
		concessionPage.clickCheckboxConfirmationDeliveryAll("Email", "Text");
		concessionPage.inputToTextboxInfoBuyer(fullName, phone, email, notes);
		concessionPage.inputInfoCardManualAll(cardNumber, month, cvc, zip);
		concessionPage.clickToButtonPlaceOrder();
		concessionPage.isSuccessOrderTextDisplayed();
		concessionPage.clickToClosePopupCheckout();
		concessionPage.sleepInSecond(shorTime);

	}
		
	
	@Description("Concessions Sales - CheckoutAddOns - Cash")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 4)
	public void ConcessionsSales_CheckoutAddOns_Cash() {
		concessionPage.plusAddOnsCheckout();
		concessionPage.compareAmounts();
		concessionPage.clickToRadioButtonPaymentCheckout("Cash");
		concessionPage.clickCheckboxConfirmationDeliveryAll("Email", "Text");
		concessionPage.inputToTextboxInfoBuyer(fullName, phone, email, notes);
		concessionPage.clickToButtonPlaceOrder();
		concessionPage.isSuccessOrderTextDisplayed();
		concessionPage.clickToClosePopupCheckout();
		concessionPage.sleepInSecond(shorTime);

	}
	
	@Description("Concessions Sales - CheckoutAddOns - Comp")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 5)
	public void ConcessionsSales_CheckoutAddOns_Comp() {
		concessionPage.plusAddOnsCheckout();
		concessionPage.compareAmounts();
		concessionPage.clickToRadioButtonPaymentCheckout("Comp");
		concessionPage.clickCheckboxConfirmationDeliveryAll("Email", "Text");
		concessionPage.inputToTextboxInfoBuyer(fullName, phone, email, notes);
		concessionPage.clickToButtonPlaceOrder();
		concessionPage.isSuccessOrderTextDisplayed();
		concessionPage.clickToClosePopupCheckout();
		concessionPage.sleepInSecond(shorTime);

	}
	
	@Description("Concessions -  Checkout Misc Charge Save - Card Swiper")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 6)
	public void Concessions_CheckoutMiscChargeSave_CardSwiper() {
		concessionPage.clickToButtonOfMiscChargePopup(amount, notes);
		concessionPage.compareAmountsMisc();
		concessionPage.clickToRadioButtonPaymentCheckout("Card swiper");
		concessionPage.clickCheckboxConfirmationDeliveryAll("Email", "Text");
		concessionPage.inputToTextboxInfoBuyer(fullName, phone, email, notes);
		concessionPage.clickToButtonPlaceOrder();
		concessionPage.isSuccessOrderTextDisplayed();
		concessionPage.clickToClosePopupCheckout();
		concessionPage.sleepInSecond(shorTime);

	}
	
	@Description("Concessions -  Checkout Misc Charge Save - Enter Card Manually")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 7)
	public void Concessions_CheckoutMiscChargeSave_EnterCardManually() {
		concessionPage.clickToButtonOfMiscChargePopup(amount, notes);
		concessionPage.compareAmountsMisc();
		concessionPage.clickToRadioButtonPaymentCheckout("Enter card manually");
		concessionPage.clickCheckboxConfirmationDeliveryAll("Email", "Text");
		concessionPage.inputToTextboxInfoBuyer(fullName, phone, email, notes);
		concessionPage.inputInfoCardManualAll(cardNumber, month, cvc, zip);
		concessionPage.clickToButtonPlaceOrder();
		concessionPage.isSuccessOrderTextDisplayed();
		concessionPage.clickToClosePopupCheckout();
		concessionPage.sleepInSecond(shorTime);

	}
	
	@Description("Concessions -  Checkout Misc Charge Save - Cash")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 8)
	public void Concessions_CheckoutMiscChargeSave_Cash() {
		concessionPage.clickToButtonOfMiscChargePopup(amount, notes);
		concessionPage.compareAmountsMisc();
		concessionPage.clickToRadioButtonPaymentCheckout("Cash");
		concessionPage.clickCheckboxConfirmationDeliveryAll("Email", "Text");
		concessionPage.inputToTextboxInfoBuyer(fullName, phone, email, notes);
		concessionPage.clickToButtonPlaceOrder();
		concessionPage.isSuccessOrderTextDisplayed();
		concessionPage.clickToClosePopupCheckout();
		concessionPage.sleepInSecond(shorTime);

	}
	
	@Description("Concessions -  Checkout Misc Charge Save - Comp")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 9)
	public void Concessions_CheckoutMiscChargeSave_Comp() {
		concessionPage.clickToButtonOfMiscChargePopup(amount, notes);
		concessionPage.compareAmountsMisc();
		concessionPage.clickToRadioButtonPaymentCheckout("Comp");
		concessionPage.clickCheckboxConfirmationDeliveryAll("Email", "Text");
		concessionPage.inputToTextboxInfoBuyer(fullName, phone, email, notes);
		concessionPage.clickToButtonPlaceOrder();
		concessionPage.isSuccessOrderTextDisplayed();
		concessionPage.clickToClosePopupCheckout();
		concessionPage.sleepInSecond(shorTime);

	}

	
	@Description("Concessions -  Checkout Misc Charge - Card Swiper")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 10)
	public void Concessions_CheckoutMiscCharge_CardSwiper() {
		concessionPage.clickToButtonOfMiscChargeSavePopup(amount, notes);
		concessionPage.compareAmountsMisc();
		concessionPage.clickToRadioButtonPaymentCheckout("Card swiper");
		concessionPage.clickCheckboxConfirmationDeliveryAll("Email", "Text");
		concessionPage.inputToTextboxInfoBuyer(fullName, phone, email, notes);
		concessionPage.clickToButtonPlaceOrder();
		concessionPage.isSuccessOrderTextDisplayed();
		concessionPage.clickToClosePopupCheckout();
		concessionPage.sleepInSecond(shorTime);

	}
	
	@Description("Concessions -  Checkout Misc Charge - Enter Card Manually")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 11)
	public void Concessions_CheckoutMiscCharge_EnterCardManually() {
		concessionPage.clickToButtonOfMiscChargeSavePopup(amount, notes);
		concessionPage.compareAmountsMisc();
		concessionPage.clickToRadioButtonPaymentCheckout("Enter card manually");
		concessionPage.clickCheckboxConfirmationDeliveryAll("Email", "Text");
		concessionPage.inputToTextboxInfoBuyer(fullName, phone, email, notes);
		concessionPage.inputInfoCardManualAll(cardNumber, month, cvc, zip);
		concessionPage.clickToButtonPlaceOrder();
		concessionPage.isSuccessOrderTextDisplayed();
		concessionPage.clickToClosePopupCheckout();
		concessionPage.sleepInSecond(shorTime);

	}
	
	@Description("Concessions -  Checkout Misc Charge - Cash")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 12)
	public void Concessions_CheckoutMiscCharge_Cash() {
		concessionPage.clickToButtonOfMiscChargeSavePopup(amount, notes);
		concessionPage.compareAmountsMisc();
		concessionPage.clickToRadioButtonPaymentCheckout("Cash");
		concessionPage.clickCheckboxConfirmationDeliveryAll("Email", "Text");
		concessionPage.inputToTextboxInfoBuyer(fullName, phone, email, notes);
		concessionPage.clickToButtonPlaceOrder();
		concessionPage.isSuccessOrderTextDisplayed();
		concessionPage.clickToClosePopupCheckout();
		concessionPage.sleepInSecond(shorTime);
	}
	
	@Description("Concessions -  Checkout Misc Charge - Comp")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 13)
	public void Concessions_CheckoutMiscCharge_Comp() {
		concessionPage.clickToButtonOfMiscChargeSavePopup(amount, notes);
		concessionPage.compareAmountsMisc();
		concessionPage.clickToRadioButtonPaymentCheckout("Comp");
		concessionPage.clickCheckboxConfirmationDeliveryAll("Email", "Text");
		concessionPage.inputToTextboxInfoBuyer(fullName, phone, email, notes);
		concessionPage.clickToButtonPlaceOrder();
		concessionPage.isSuccessOrderTextDisplayed();
		concessionPage.clickToClosePopupCheckout();
		concessionPage.sleepInSecond(shorTime);
	}
	
	@Description("Concessions -  Checkout Add Ons - Card Swiper")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 14)
	public void ConcessionsInventory_CheckoutAddOns_CardSwiper() {
		concessionPage.clickSwitchToTab("Inventory");
		concessionPage.plusAddOnsCheckout();
		concessionPage.compareAmounts();
		concessionPage.clickToRadioButtonPaymentCheckout("Card swiper");
		concessionPage.clickCheckboxConfirmationDeliveryAll("Email", "Text");
		concessionPage.inputToTextboxInfoBuyer(fullName, phone, email, notes);
		concessionPage.clickToButtonPlaceOrder();
		concessionPage.isSuccessOrderTextDisplayed();
		concessionPage.clickToClosePopupCheckout();
		concessionPage.refreshToPage(driver);
	}
	
	@Description("Concessions -  Checkout Add Ons - Enter Card Manually")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 15)
	public void ConcessionsInventory_CheckoutAddOns_EnterCardManually() {
		concessionPage.clickSwitchToTab("Inventory");
		concessionPage.plusAddOnsCheckout();
		concessionPage.compareAmounts();
		concessionPage.clickToRadioButtonPaymentCheckout("Enter card manually");
		concessionPage.clickCheckboxConfirmationDeliveryAll("Email", "Text");
		concessionPage.inputToTextboxInfoBuyer(fullName, phone, email, notes);
		concessionPage.inputInfoCardManualAll(cardNumber, month, cvc, zip);
		concessionPage.clickToButtonPlaceOrder();
		concessionPage.isSuccessOrderTextDisplayed();
		concessionPage.clickToClosePopupCheckout();
		concessionPage.refreshToPage(driver);
	}
	@Description("Concessions -  Checkout Add Ons - Comp")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 16)
	public void ConcessionsInventory_CheckoutAddOns_Comp() {
		concessionPage.clickSwitchToTab("Inventory");
		concessionPage.plusAddOnsCheckout();
		concessionPage.compareAmounts();
		concessionPage.clickToRadioButtonPaymentCheckout("Comp");
		concessionPage.clickCheckboxConfirmationDeliveryAll("Email", "Text");
		concessionPage.inputToTextboxInfoBuyer(fullName, phone, email, notes);
		concessionPage.clickToButtonPlaceOrder();
		concessionPage.isSuccessOrderTextDisplayed();
		concessionPage.clickToClosePopupCheckout();
		concessionPage.refreshToPage(driver);
	}

	@Description("Concessions -  Checkout Add Ons - Cash")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 17)
	public void ConcessionsInventory_CheckoutAddOns_Cash() {
		concessionPage.clickSwitchToTab("Inventory");
		concessionPage.plusAddOnsCheckout();
		concessionPage.compareAmounts();
		concessionPage.clickToRadioButtonPaymentCheckout("Cash");
		concessionPage.clickCheckboxConfirmationDeliveryAll("Email", "Text");
		concessionPage.inputToTextboxInfoBuyer(fullName, phone, email, notes);
		concessionPage.clickToButtonPlaceOrder();
		concessionPage.isSuccessOrderTextDisplayed();
		concessionPage.clickToClosePopupCheckout();
		concessionPage.refreshToPage(driver);
	}
	
	@Description("Concessions Sales - Refund Order")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 18)
	public void ConcessionsSales_RefundOrder() {
		concessionPage.chooseActionOfDropdown("Refund");
		concessionPage.clickToSelectAllRefund();
		concessionPage.clickToButtonOfMiscChargePopup("Refund");
		verifyTrue(concessionPage.isRefundTagDisplay());
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

