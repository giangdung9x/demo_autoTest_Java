package showslinger_user;

import java.text.DecimalFormat;
import dataSource.dataClass16;
import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.*;
import pageObject.user.UserVerifyTotalAmountPageObject;

import java.util.Random;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

//Actions of tickets Create/ Edit/Transfer Ticket
public class Class_016_Verify_Amount_Order extends BaseTest{
	private UserVerifyTotalAmountPageObject verifyAmountPage;

	private static double orderTotalAmount, actualTotalAmount;
	private static double baseTicketPrice, overageFee, showSlingerFee, feesCreditEstimate, subtotal;
	private static int intPrice, intQuantity;
	DecimalFormat df = new DecimalFormat("#.##");


	@Parameters({ "envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName,
	@Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String
	portNumber,@Optional("Windows") String osName, @Optional("10") String osVersion) {
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
		verifyAmountPage = new UserVerifyTotalAmountPageObject(driver);

	}

	@Description("Login Account")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_001_Ticket_OpenUrlAndLoginAccount() {
		
		verifyAmountPage.clickToLoginLink();

		verifyAmountPage.loginAccount(dataClass16.emailManager,dataClass16.passwordManager);

		verifyAmountPage.clickToLoginButton();
	}
	
	@Description("Create Ticket")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_002_CreateTicket() {
		verifyAmountPage.clickToCreateTicketButton();
		assertTrue(verifyAmountPage.isNameOfPopupDisplayed("Create Ticket"));

		verifyAmountPage.inputValueTimesDay("Day start", dataClass16.dayStart);
		verifyAmountPage.inputValueTimesDay("Day end", dataClass16.dayEnd);
		verifyAmountPage.clickToAddButton("Add Ticket");
		verifyAmountPage.enterToTextboxByRowNumberByColumnNameTicket("1", dataClass16.ticketName);
		verifyAmountPage.enterToTextboxByRowNumberByColumnName("Quantity available", "1", dataClass16.totalTicket);
		verifyAmountPage.enterToTextboxAmountByRowNumberByColumnName("Online price", "1", dataClass16.price);
		verifyAmountPage.enterToTextboxAmountByRowNumberByColumnName("Cash price(at the door)", "1", dataClass16.price);
		verifyAmountPage.enterToTextboxAmountByRowNumberByColumnName("Day of price", "1", dataClass16.price);
		verifyAmountPage.inputToTextboxMinMaxTicket("Minimum ticket", dataClass16.minTicket);
		verifyAmountPage.inputToTextboxMinMaxTicket("Maximum ticket", dataClass16.maxTicket);
		verifyAmountPage.inputToTextboxMinMaxTicket("Event Name", dataClass16.eventName);
		verifyAmountPage.clickToCheckboxOnSale();

		verifyAmountPage.clickToCommitButton("Create Ticket");
		assertTrue(verifyAmountPage.isNameOfEventAtCalendarDisplayed(dataClass16.eventName));
	}

	@Description("Get data all fees of admin page")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_003_GetDataFees() {
		verifyAmountPage.openTabAdminPage();
		assertTrue(verifyAmountPage.isNameOfScreen("Dashboard"));
		verifyAmountPage.clickToButton("Venues");
		verifyAmountPage.inputValueVenueName("City Theater");
		verifyAmountPage.clickToButton("Edit");

		verifyAmountPage.inputValueTimesDay("Showslinger Base Fee (ex: $1)", dataClass16.baseFeeSS_input);
		verifyAmountPage.inputValueTimesDay("Showslinger Percentage Fee (ex: 0.03)", dataClass16.perFeeSS_input);
		verifyAmountPage.inputValueTimesDay("Showslinger Base Fee Cash (ex: $1)", dataClass16.baseFeeSSCash_input);
		verifyAmountPage.inputValueTimesDay("Showslinger Percentage Fee Cash (ex: 0.03)", dataClass16.perFeeSSCash_input);

		verifyAmountPage.clickToButtonUpdateVenue();

		dataClass16.baseFeeSS = parseDoubleWithComma(dataClass16.baseFeeSS_input);
		dataClass16.baseFeeSSCash = parseDoubleWithComma(dataClass16.baseFeeSSCash_input);
		dataClass16.perFeeSS = parseDoubleWithComma(dataClass16.perFeeSS_input);
		dataClass16.perFeeSSCash = parseDoubleWithComma(dataClass16.perFeeSSCash_input);

		String PageAdmin = driver.getWindowHandle();
		driver.close();
		verifyAmountPage.switchToWindowByID(PageAdmin);
	}


	@Description("Buy Online -Checkout now -verify total amount order ")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_004_BuyOnline_01_CheckoutNow() {
		verifyAmountPage.refreshToPage(driver);

		verifyAmountPage.clickToEvent(dataClass16.eventName);
		assertTrue(verifyAmountPage.isNameOfPopupDisplayed("Edit Ticket"));

		String PageEvent = driver.getWindowHandle();
		verifyAmountPage.clickToLink("Preview");
		verifyAmountPage.switchToWindowByID(PageEvent);

		verifyAmountPage.clickToDropDownSelectQuantityTicket(dataClass16.ticketName, dataClass16.quantity);

		//click button Agree & Checkout
		verifyAmountPage.clickToAgreeCheckoutButton();

		verifyAmountPage.inputInfoBuyerTextbox("Full Name", dataClass16.fullName);
		verifyAmountPage.inputInfoBuyerTextbox("Phone", dataClass16.phone);
		verifyAmountPage.inputInfoBuyerTextbox("Email", dataClass16.validEmail);
		verifyAmountPage.inputInfoBuyerTextbox("Confirm Email", dataClass16.validEmail);

		verifyAmountPage.clickCheckboxAcceptTermsService();

		//get Total Amount of screen
		verifyAmountPage.getTextTotalAmountOrder();

		verifyAmountPage.sleepInSecond(3);

		orderTotalAmount = Double.parseDouble(verifyAmountPage.getTextTotalAmountOrder().replace("$", ""));

		intPrice = Integer.parseInt(dataClass16.price);
		intQuantity = Integer.parseInt(dataClass16.quantity);

		//Caculation total amount of order - Exclude Overage fee
		baseTicketPrice = intQuantity*intPrice;
		overageFee = 0;
		showSlingerFee = ((intQuantity*dataClass16.baseFeeSS)+baseTicketPrice*dataClass16.perFeeSS);
		feesCreditEstimate = (dataClass16.onlineFixedFee + dataClass16.onlinePercentageFee*(baseTicketPrice+overageFee+showSlingerFee))/(1-dataClass16.onlinePercentageFee);

		actualTotalAmount = Double.parseDouble(df.format(baseTicketPrice + overageFee+ showSlingerFee+ feesCreditEstimate));

		if ((verifyAmountPage.getTextTotalAmountOrder()).equals("0$")) {
			verifyAmountPage.clickPlaceOrderButton();
			assertTrue(verifyAmountPage.isCheckoutSuccessTextDisplayed());

			String PageOrder = driver.getWindowHandle();
			driver.close();
			verifyAmountPage.switchToWindowByID(PageOrder);

		} else {
			if (orderTotalAmount == actualTotalAmount) {
				System.out.println("orderTotalAmount == actualTotalAmount");

				verifyAmountPage.switchToFrameIframe();
				verifyAmountPage.inputInfoCardManual("Card number", dataClass16.cardNumberValid);
				verifyAmountPage.inputInfoCardManual("MM / YY", dataClass16.monthYearValid);
				verifyAmountPage.inputInfoCardManual("CVC", dataClass16.cvc);
				verifyAmountPage.inputInfoCardManual("ZIP", dataClass16.zip);
				verifyAmountPage.switchToDefaultContent();
				verifyAmountPage.clickPlaceOrderButton();
				assertTrue(verifyAmountPage.isCheckoutSuccessTextDisplayed());

				String PageOrder = driver.getWindowHandle();
				driver.close();
				verifyAmountPage.switchToWindowByID(PageOrder);
			} else {
				System.out.println("Total amount is error");
				String PageOrder = driver.getWindowHandle();
				driver.close();
				verifyAmountPage.switchToWindowByID(PageOrder);
			}

		}

		verifyAmountPage.clickToLink("Cancel");
	}

	@Description("Buy Online - Buy now pay later -verify total amount order ")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_005_BuyOnline_02_BuyNowPayLater() {
		verifyAmountPage.refreshToPage(driver);

		verifyAmountPage.clickToEvent(dataClass16.eventName);
		assertTrue(verifyAmountPage.isNameOfPopupDisplayed("Edit Ticket"));

		String PageEvent = driver.getWindowHandle();
		verifyAmountPage.clickToLink("Preview");
		verifyAmountPage.switchToWindowByID(PageEvent);

		verifyAmountPage.clickToDropDownSelectQuantityTicket(dataClass16.ticketName, dataClass16.quantity);

		//click button Agree & Checkout
		verifyAmountPage.clickToAgreeCheckoutButton();

		verifyAmountPage.inputInfoBuyerTextbox("Full Name", dataClass16.fullName);
		verifyAmountPage.inputInfoBuyerTextbox("Phone", dataClass16.phone);
		verifyAmountPage.inputInfoBuyerTextbox("Email", dataClass16.validEmail);
		verifyAmountPage.inputInfoBuyerTextbox("Confirm Email", dataClass16.validEmail);
		verifyAmountPage.clickToRadioButtonCheckoutMethod(); //buy now pay later
		verifyAmountPage.clickCheckboxAcceptTermsService();

		//get Total Amount of screen
		verifyAmountPage.getTextTotalAmountOrder();

		verifyAmountPage.sleepInSecond(3);

		orderTotalAmount = Double.parseDouble(verifyAmountPage.getTextTotalAmountOrder().replace("$", ""));
		intPrice = Integer.parseInt(dataClass16.price);
		intQuantity = Integer.parseInt(dataClass16.quantity);
		//Caculation total amount of order - Exclude Overage fee
		baseTicketPrice = intQuantity*intPrice;
		overageFee = 0;
		showSlingerFee = ((intQuantity*dataClass16.baseFeeSS)+baseTicketPrice*dataClass16.perFeeSS);
		feesCreditEstimate = (dataClass16.payLaterFixedFee + dataClass16.payLaterPercentageFee*(baseTicketPrice+overageFee+showSlingerFee))/(1-dataClass16.payLaterPercentageFee);
		actualTotalAmount = Double.parseDouble(df.format(baseTicketPrice + overageFee+ showSlingerFee+ feesCreditEstimate));

		if ((verifyAmountPage.getTextTotalAmountOrder()).equals("0$")) {
			verifyAmountPage.clickPlaceOrderButton();
			assertTrue(verifyAmountPage.isCheckoutSuccessTextDisplayed());

			String PageOrder = driver.getWindowHandle();
			driver.close();
			verifyAmountPage.switchToWindowByID(PageOrder);

		} else {

			if (orderTotalAmount == actualTotalAmount) {
				System.out.println("orderTotalAmount == actualTotalAmount");
				verifyAmountPage.clickToBuyNowPayLaterButton();
				verifyAmountPage.clickButtonAuthorizeTestPayment();
				assertTrue(verifyAmountPage.isCheckoutSuccessTextDisplayed());

				String PageOrder = driver.getWindowHandle();
				driver.close();
				verifyAmountPage.switchToWindowByID(PageOrder);
			} else {
				System.out.println("Total amount is error");
				String PageOrder = driver.getWindowHandle();
				driver.close();
				verifyAmountPage.switchToWindowByID(PageOrder);
			}
		}
		verifyAmountPage.clickToLink("Cancel");
	}

	@Description("Box Office - Card swiper -verify total amount order ")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_006_BuyOnline_01_CardSwiper() {
		verifyAmountPage.clickShowLeftMenu();
		String managerWindowID = driver.getWindowHandle();
		verifyAmountPage.clickToItemOfLeftMenu("Box office");
//		driver.close();
		verifyAmountPage.switchToWindowByID(managerWindowID);
		assertTrue(verifyAmountPage.isBoxOfficeTextDisplayed());

		assertTrue(verifyAmountPage.isBoxOfficeTextDisplayed());
		verifyAmountPage.clickToDropDownSelectVenue();
		verifyAmountPage.clickToValueOfDropdownSelectVenue("City Theater");
		verifyAmountPage.clickToDropDownSelectEvent();
		verifyAmountPage.clickToValueOfDropdownSelectEvent(dataClass16.eventName);
		assertTrue(verifyAmountPage.isOrderBoxOfficeTextDisplayed());

		verifyAmountPage.clickToDropDownSelectQuantityTicket(dataClass16.ticketName, dataClass16.quantity);

		verifyAmountPage.clickToRadioButtonPaymentCheckout("Card swiper");
		verifyAmountPage.clickButtonCheckout("Checkout now");
		verifyAmountPage.getTextTotalAmountOrder();

		orderTotalAmount = Double.parseDouble(verifyAmountPage.getTextTotalAmountOrder().replace("$", ""));
		intPrice = Integer.parseInt(dataClass16.price);
		intQuantity = Integer.parseInt(dataClass16.quantity);
		//Caculation total amount of order - Exclude Overage fee
		baseTicketPrice = intQuantity*intPrice;
		overageFee = 0;
		showSlingerFee = ((intQuantity*dataClass16.baseFeeSS)+baseTicketPrice*dataClass16.perFeeSS);
		feesCreditEstimate = (dataClass16.cardReaderFixedFee + dataClass16.cardReaderPercentageFee*(baseTicketPrice+overageFee+showSlingerFee))/(1-dataClass16.cardReaderPercentageFee);
		actualTotalAmount = Double.parseDouble(df.format(baseTicketPrice + overageFee+ showSlingerFee+ feesCreditEstimate));

		if ((verifyAmountPage.getTextTotalAmountOrder()).equals("$0.00")) {
			verifyAmountPage.clickButtonPlaceOrder();
			assertTrue(verifyAmountPage.isSuccessOrderTextDisplayed());
			verifyAmountPage.clickBackToBoxOfficeButton();
		} else {

			if (orderTotalAmount == actualTotalAmount) {
				System.out.println("orderTotalAmount == actualTotalAmount");
				assertEquals(verifyAmountPage.getTextNameOfReader(),"ss-reader");
				verifyAmountPage.clickButtonChargeCard();
				assertTrue(verifyAmountPage.isTapOrInsertTextDisplayed());

				assertTrue(verifyAmountPage.isSuccessOrderTextDisplayed());
				verifyAmountPage.clickBackToBoxOfficeButton();

			} else {
				System.out.println("Total amount is error");
				verifyAmountPage.refreshToPage(driver);
			}
		}
		assertTrue(verifyAmountPage.isOrderBoxOfficeTextDisplayed());
		String boxOfficeWindowID = driver.getWindowHandle();
		driver.close();
		verifyAmountPage.switchToWindowByID(boxOfficeWindowID);
		verifyAmountPage.refreshToPage(driver);
	}

	@Description("Box Office - Card swiper -verify total amount order ")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_007_BuyOnline_02_EnterCardManually() {
//		verifyAmountPage.clickShowLeftMenu();
		String managerWindowID = driver.getWindowHandle();
		verifyAmountPage.clickToItemOfLeftMenu("Box office");
//		driver.close();
		verifyAmountPage.switchToWindowByID(managerWindowID);
		assertTrue(verifyAmountPage.isBoxOfficeTextDisplayed());

		assertTrue(verifyAmountPage.isBoxOfficeTextDisplayed());
		verifyAmountPage.clickToDropDownSelectVenue();
		verifyAmountPage.clickToValueOfDropdownSelectVenue("City Theater");
		verifyAmountPage.clickToDropDownSelectEvent();
		verifyAmountPage.clickToValueOfDropdownSelectEvent(dataClass16.eventName);
		assertTrue(verifyAmountPage.isOrderBoxOfficeTextDisplayed());

		verifyAmountPage.clickToDropDownSelectQuantityTicket(dataClass16.ticketName, dataClass16.quantity);

		verifyAmountPage.clickToRadioButtonPaymentCheckout("Enter card manually");
		verifyAmountPage.clickButtonCheckout("Checkout now");
		verifyAmountPage.getTextTotalAmountOrder();

		orderTotalAmount = Double.parseDouble(verifyAmountPage.getTextTotalAmountOrder().replace("$", ""));
		intPrice = Integer.parseInt(dataClass16.price);
		intQuantity = Integer.parseInt(dataClass16.quantity);
		//Caculation total amount of order - Exclude Overage fee
		baseTicketPrice = intQuantity*intPrice;
		overageFee = 0;
		showSlingerFee = ((intQuantity*dataClass16.baseFeeSS)+baseTicketPrice*dataClass16.perFeeSS);
		feesCreditEstimate = (dataClass16.onlineFixedFee + dataClass16.onlinePercentageFee*(baseTicketPrice+overageFee+showSlingerFee))/(1-dataClass16.onlinePercentageFee);

		actualTotalAmount = Double.parseDouble(df.format(baseTicketPrice + overageFee+ showSlingerFee+ feesCreditEstimate));
		if ((verifyAmountPage.getTextTotalAmountOrder()).equals("$0.00")) {
			verifyAmountPage.clickButtonPlaceOrder();
			assertTrue(verifyAmountPage.isSuccessOrderTextDisplayed());
			verifyAmountPage.clickBackToBoxOfficeButton();
		} else {
			if (orderTotalAmount == actualTotalAmount) {
				System.out.println("orderTotalAmount == actualTotalAmount");
				verifyAmountPage.switchToFrameIframe();
				verifyAmountPage.inputInfoCardManual("Card number", dataClass16.cardNumberValid);
				verifyAmountPage.inputInfoCardManual("MM / YY", dataClass16.monthYearValid);
				verifyAmountPage.inputInfoCardManual("CVC", dataClass16.cvc);
				verifyAmountPage.inputInfoCardManual("ZIP", dataClass16.zip);
				verifyAmountPage.switchToDefaultContent();
				verifyAmountPage.clickPlaceOrderButton();

				assertTrue(verifyAmountPage.isSuccessOrderTextDisplayed());
				verifyAmountPage.clickBackToBoxOfficeButton();
			} else {
				System.out.println("Total amount is error");
				verifyAmountPage.refreshToPage(driver);
			}
		}
		assertTrue(verifyAmountPage.isOrderBoxOfficeTextDisplayed());
		String boxOfficeWindowID = driver.getWindowHandle();
		driver.close();
		verifyAmountPage.switchToWindowByID(boxOfficeWindowID);
		verifyAmountPage.refreshToPage(driver);
	}

	@Description("Box Office - Card swiper -verify total amount order ")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_008_BuyOnline_03_BuyNowPayLater() {
//		verifyAmountPage.clickShowLeftMenu();
		String managerWindowID = driver.getWindowHandle();
		verifyAmountPage.clickToItemOfLeftMenu("Box office");
//		driver.close();
		verifyAmountPage.switchToWindowByID(managerWindowID);
		assertTrue(verifyAmountPage.isBoxOfficeTextDisplayed());

		assertTrue(verifyAmountPage.isBoxOfficeTextDisplayed());
		verifyAmountPage.clickToDropDownSelectVenue();
		verifyAmountPage.clickToValueOfDropdownSelectVenue("City Theater");
		verifyAmountPage.clickToDropDownSelectEvent();
		verifyAmountPage.clickToValueOfDropdownSelectEvent(dataClass16.eventName);
		assertTrue(verifyAmountPage.isOrderBoxOfficeTextDisplayed());

		verifyAmountPage.clickToDropDownSelectQuantityTicket(dataClass16.ticketName, dataClass16.quantity);

		verifyAmountPage.clickToRadioButtonPaymentCheckout("Buy now pay later");
		verifyAmountPage.clickButtonCheckout("Checkout now");
		verifyAmountPage.getTextTotalAmountOrder();

		orderTotalAmount = Double.parseDouble(verifyAmountPage.getTextTotalAmountOrder().replace("$", ""));
		intPrice = Integer.parseInt(dataClass16.price);
		intQuantity = Integer.parseInt(dataClass16.quantity);
		//Caculation total amount of order - Exclude Overage fee
		baseTicketPrice = intQuantity*intPrice;
		overageFee = 0;
		showSlingerFee = ((intQuantity*dataClass16.baseFeeSS)+baseTicketPrice*dataClass16.perFeeSS);
		feesCreditEstimate = (dataClass16.payLaterFixedFee + dataClass16.payLaterPercentageFee*(baseTicketPrice+overageFee+showSlingerFee))/(1-dataClass16.payLaterPercentageFee);
		actualTotalAmount = Double.parseDouble(df.format(baseTicketPrice + overageFee+ showSlingerFee+ feesCreditEstimate));

		if ((verifyAmountPage.getTextTotalAmountOrder()).equals("$0.00")) {
			verifyAmountPage.clickButtonPlaceOrder();
			assertTrue(verifyAmountPage.isSuccessOrderTextDisplayed());
			verifyAmountPage.clickBackToBoxOfficeButton();
		} else {
			if (orderTotalAmount == actualTotalAmount) {
				System.out.println("orderTotalAmount == actualTotalAmount");
				verifyAmountPage.clickButtonPlaceOrder();
				verifyAmountPage.clickButtonAuthorizeTestPayment();

				assertTrue(verifyAmountPage.isSuccessOrderTextDisplayed());
				verifyAmountPage.clickBackToBoxOfficeButton();
			} else {
				System.out.println("Total amount is error");
				verifyAmountPage.refreshToPage(driver);
			}
		}
		assertTrue(verifyAmountPage.isOrderBoxOfficeTextDisplayed());
		String boxOfficeWindowID = driver.getWindowHandle();
		driver.close();
		verifyAmountPage.switchToWindowByID(boxOfficeWindowID);
		verifyAmountPage.refreshToPage(driver);
	}

	@Description("Box Office - Cash -verify total amount order ")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_009_BuyOnline_04_Cash() {
//		verifyAmountPage.clickShowLeftMenu();
		String managerWindowID = driver.getWindowHandle();
		verifyAmountPage.clickToItemOfLeftMenu("Box office");
//		driver.close();
		verifyAmountPage.switchToWindowByID(managerWindowID);
		assertTrue(verifyAmountPage.isBoxOfficeTextDisplayed());

		assertTrue(verifyAmountPage.isBoxOfficeTextDisplayed());
		verifyAmountPage.clickToDropDownSelectVenue();
		verifyAmountPage.clickToValueOfDropdownSelectVenue("City Theater");
		verifyAmountPage.clickToDropDownSelectEvent();
		verifyAmountPage.clickToValueOfDropdownSelectEvent(dataClass16.eventName);
		assertTrue(verifyAmountPage.isOrderBoxOfficeTextDisplayed());

		verifyAmountPage.clickToDropDownSelectQuantityTicket(dataClass16.ticketName, dataClass16.quantity);

		verifyAmountPage.clickToRadioButtonPaymentCheckout("Cash");
		verifyAmountPage.clickButtonCheckout("Checkout now");
		verifyAmountPage.getTextTotalAmountOrder();

		orderTotalAmount = Double.parseDouble(verifyAmountPage.getTextTotalAmountOrder().replace("$", ""));
		intPrice = Integer.parseInt(dataClass16.price);
		intQuantity = Integer.parseInt(dataClass16.quantity);
		//Caculation total amount of order - Exclude Overage fee
		baseTicketPrice = intQuantity*intPrice;
		overageFee = 0;
		showSlingerFee = ((intQuantity*dataClass16.baseFeeSSCash)+baseTicketPrice*dataClass16.perFeeSSCash);
		feesCreditEstimate = (dataClass16.cashFixedFee + dataClass16.cashPercentageFee*(baseTicketPrice+overageFee+showSlingerFee))/(1-dataClass16.cashPercentageFee);
		actualTotalAmount = Double.parseDouble(df.format(baseTicketPrice + overageFee+ showSlingerFee+ feesCreditEstimate));

		if ((verifyAmountPage.getTextTotalAmountOrder()).equals("$0.00")) {
			verifyAmountPage.clickButtonPlaceOrder();
			assertTrue(verifyAmountPage.isSuccessOrderTextDisplayed());
			verifyAmountPage.clickBackToBoxOfficeButton();
		} else {
			if (orderTotalAmount == actualTotalAmount) {
				System.out.println("orderTotalAmount == actualTotalAmount");
				verifyAmountPage.clickButtonPlaceOrder();
				assertTrue(verifyAmountPage.isSuccessOrderTextDisplayed());
				verifyAmountPage.clickBackToBoxOfficeButton();
			} else {
				System.out.println("Total amount is error" + "actual is:" + actualTotalAmount + "orderTotalAmount: " + orderTotalAmount);
				verifyAmountPage.refreshToPage(driver);
			}
		}
		assertTrue(verifyAmountPage.isOrderBoxOfficeTextDisplayed());
		String boxOfficeWindowID = driver.getWindowHandle();
		driver.close();
		verifyAmountPage.switchToWindowByID(boxOfficeWindowID);
		verifyAmountPage.refreshToPage(driver);
	}

	@Description("Box Office - Comp -verify total amount order ")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_010_BuyOnline_05_Comp() {
//		verifyAmountPage.clickShowLeftMenu();
		String managerWindowID = driver.getWindowHandle();
		verifyAmountPage.clickToItemOfLeftMenu("Box office");
//		driver.close();
		verifyAmountPage.switchToWindowByID(managerWindowID);
		assertTrue(verifyAmountPage.isBoxOfficeTextDisplayed());

		assertTrue(verifyAmountPage.isBoxOfficeTextDisplayed());
		verifyAmountPage.clickToDropDownSelectVenue();
		verifyAmountPage.clickToValueOfDropdownSelectVenue("City Theater");
		verifyAmountPage.clickToDropDownSelectEvent();
		verifyAmountPage.clickToValueOfDropdownSelectEvent(dataClass16.eventName);
		assertTrue(verifyAmountPage.isOrderBoxOfficeTextDisplayed());

		verifyAmountPage.clickToDropDownSelectQuantityTicket(dataClass16.ticketName, dataClass16.quantity);

		verifyAmountPage.clickToRadioButtonPaymentCheckout("Comp");
		verifyAmountPage.clickButtonCheckout("Checkout now");
		verifyAmountPage.getTextTotalAmountOrder();

		orderTotalAmount = Double.parseDouble(verifyAmountPage.getTextTotalAmountOrder().replace("$", ""));

		intPrice = Integer.parseInt(dataClass16.price);
		intQuantity = Integer.parseInt(dataClass16.quantity);

		//Caculation total amount of order - Exclude Overage fee
		baseTicketPrice = intQuantity*intPrice;
		overageFee = 0;
		//showSlingerFee = ((intQuantity*dataClass16.baseFeeSS); //+baseTicketPrice*dataClass16.perFeeSS) -
		//creditCardProcessingFeeEstimate = (dataClass16.cashFixedFee + dataClass16.cashPercentageFee*(baseTicketPrice+overageFee+showSlingerFee))/(1-dataClass16.cashPercentageFee);

		actualTotalAmount = Double.parseDouble(df.format(baseTicketPrice - baseTicketPrice)); //+ overageFee+ showSlingerFee+creditCardProcessingFeeEstimate));

		if ((verifyAmountPage.getTextTotalAmountOrder()).equals("$0.00")) {
			System.out.println("orderTotalAmount == actualTotalAmount");
			verifyAmountPage.clickButtonPlaceOrder();
			assertTrue(verifyAmountPage.isSuccessOrderTextDisplayed());
			verifyAmountPage.clickBackToBoxOfficeButton();
		} else {

			if (orderTotalAmount == actualTotalAmount) {
				System.out.println("orderTotalAmount == actualTotalAmount");
				verifyAmountPage.clickButtonPlaceOrder();
				assertTrue(verifyAmountPage.isSuccessOrderTextDisplayed());
				verifyAmountPage.clickBackToBoxOfficeButton();
			} else {
				System.out.println("Total amount is error");
				verifyAmountPage.refreshToPage(driver);
			}
		}
		assertTrue(verifyAmountPage.isOrderBoxOfficeTextDisplayed());
		String boxOfficeWindowID = driver.getWindowHandle();
		driver.close();
		verifyAmountPage.switchToWindowByID(boxOfficeWindowID);
		verifyAmountPage.refreshToPage(driver);
	}
	
	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(999);
	}

	public static double parseDoubleWithComma(String input) {
		String sanitizedInput = input.replace(",", ".");
		double result = Double.parseDouble(sanitizedInput);
		return result;
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
//		driver.quit();
	}
}

