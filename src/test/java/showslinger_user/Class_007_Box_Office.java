package showslinger_user;

import commons.BaseTest;
import commons.ConfigOnOffTestcase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.*;
import pageObject.user.UserBoxOfficePageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class Class_007_Box_Office extends BaseTest{
	private UserBoxOfficePageObject boxOfficePage;
	private String emailManager, passwordManager, emailStaffAuto, passwordStaffAuto, emailStaffManual, passwordStaffManual;
	private String cardNumberValid, cardNumberInvalid, cardNumberDeclined, monthYearValid, monthYearInvalid, cvc, zip;

	private String eventName, printerName, paperName, ticketName, quantityTicket;

	@Parameters({ "envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName,
	@Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String
	portNumber,@Optional("Windows") String osName, @Optional("10") String osVersion) {
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
		boxOfficePage = new UserBoxOfficePageObject(driver);

		emailManager ="paulv@showslinger.com";
		passwordManager = "12345";
		emailStaffAuto ="dangthigiang+10@mobilefolk.com";
		passwordStaffAuto = "123456";
		emailStaffManual ="dangthigiang+15@mobilefolk.com";
		passwordStaffManual = "123456";

		cardNumberValid = "4242424242424242";
		cardNumberDeclined ="4000000000000002";
		monthYearValid = "0424";
		cvc = "242";
		zip = "42424";
		cardNumberInvalid="2323232323232323";
		monthYearInvalid = "0420";


		eventName ="Giang Test auto";
		printerName ="Canon LBP2900 (DESKTOP-VMJ4FSM)";
		paperName ="A4";
		ticketName ="vip3";
		quantityTicket ="1";

	}

	@Description("Login Account Manager and Open Box Office")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_001_Manager_001_OpenUrlLoginAccount() {
		boxOfficePage.clickToLoginLink();
		boxOfficePage.loginAccount(emailManager,passwordManager);
		boxOfficePage.clickToLoginButton();
		boxOfficePage.clickShowLeftMenu();
		String managerWindowID = driver.getWindowHandle();
		boxOfficePage.clickToItemOfLeftMenu("Box office");
		driver.close();
		boxOfficePage.switchToWindowByID(managerWindowID);
		assertTrue(boxOfficePage.isBoxOfficeTextDisplayed());
	}

	@Description("Verify More Menu")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_002_Manager_002_MoreMenu() {
		boxOfficePage.clickToMoreMenuButton();

		String boxOfficeWindowID = driver.getWindowHandle();
		boxOfficePage.clickToValueOfMoreMennu("Instruction");
		boxOfficePage.switchToWindowByID(boxOfficeWindowID);

		assertTrue(boxOfficePage.isTitleInstructionYoutubeDisplayed());
		String instructionYoutubeWindowID = driver.getWindowHandle();
		driver.close();
		boxOfficePage.switchToWindowByID(instructionYoutubeWindowID);

		boxOfficePage.clickToValueOfMoreMennu("Copy link");
		boxOfficePage.acceptAlert();

		boxOfficePage.clickToValueOfMoreMennu("Card readers");
		boxOfficePage.switchToWindowByID(boxOfficeWindowID);

		assertTrue(boxOfficePage.isTitleRegisteredReadersDisplayed());
		String registeredReadersWindowID = driver.getWindowHandle();
		driver.close();
		boxOfficePage.switchToWindowByID(registeredReadersWindowID);

		if (ConfigOnOffTestcase.isPublicKioskOn){
			boxOfficePage.clickToValueOfMoreMennu("Information");
			boxOfficePage.switchToWindowByID(boxOfficeWindowID);
			assertTrue(boxOfficePage.isTitleBoxOfficeInformationDisplayed());
		} else {
			System.out.println("Public Kiosk not use");
		}

	}


	@Ignore
	@Description("Verify - Information Box Office")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_003_Manager_003_ConfigInformationBoxOffice() {
		if (ConfigOnOffTestcase.isPublicKioskOn){
			boxOfficePage.clickToDropDownSelectPrinter();
			boxOfficePage.clickToValueOfDropdownSelectPrinter(printerName);

			assertTrue(boxOfficePage.isTextSelectdefaultPaperDisplayed());

			boxOfficePage.clickToDropDownSelectPaper();
			boxOfficePage.clickToValueOfDropdownSelectPaper(paperName);

			assertTrue(boxOfficePage.isSelectedPaperValueDisplayed());

			boxOfficePage.clickToButtonReset();
			boxOfficePage.acceptAlertReport();

			assertEquals(boxOfficePage.getValueReport("report-card_reader", "total_ticket"),"0");
			assertEquals(boxOfficePage.getValueReport("report-card_reader", "total_money"),"0");
			assertEquals(boxOfficePage.getValueReport("report-cash", "total_ticket"),"0");
			assertEquals(boxOfficePage.getValueReport("report-cash", "total_money"),"0");
			assertEquals(boxOfficePage.getValueReport("report-online", "total_ticket"),"0");
			assertEquals(boxOfficePage.getValueReport("report-online", "total_money"),"0");
			assertEquals(boxOfficePage.getValueReport("report-comp", "total_ticket"),"0");
			assertEquals(boxOfficePage.getValueReport("report-comp", "total_money"),"0");
			assertEquals(boxOfficePage.getValueReport("report-affirm", "total_ticket"),"0");
			assertEquals(boxOfficePage.getValueReport("report-affirm", "total_money"),"0");
			assertEquals(boxOfficePage.getValueReport("report-total", "total_ticket"),"0");
			assertEquals(boxOfficePage.getValueReport("report-total", "total_money"),"0");


			boxOfficePage.clickToButtonReset();
			boxOfficePage.cancelAlertReport();

			assertEquals(boxOfficePage.getValueReport("report-card_reader", "total_ticket"),"0");
			assertEquals(boxOfficePage.getValueReport("report-card_reader", "total_money"),"0");
			assertEquals(boxOfficePage.getValueReport("report-cash", "total_ticket"),"0");
			assertEquals(boxOfficePage.getValueReport("report-cash", "total_money"),"0");
			assertEquals(boxOfficePage.getValueReport("report-online", "total_ticket"),"0");
			assertEquals(boxOfficePage.getValueReport("report-online", "total_money"),"0");
			assertEquals(boxOfficePage.getValueReport("report-comp", "total_ticket"),"0");
			assertEquals(boxOfficePage.getValueReport("report-comp", "total_money"),"0");
			assertEquals(boxOfficePage.getValueReport("report-affirm", "total_ticket"),"0");
			assertEquals(boxOfficePage.getValueReport("report-affirm", "total_money"),"0");
			assertEquals(boxOfficePage.getValueReport("report-total", "total_ticket"),"0");
			assertEquals(boxOfficePage.getValueReport("report-total", "total_money"),"0");

			boxOfficePage.clickToButtonBackToBoxOfficeFromInformationScreen();

			assertTrue(boxOfficePage.isBoxOfficeTextDisplayed());

			String boxOfficeInformationWindowID = driver.getWindowHandle();
			driver.close();
			boxOfficePage.switchToWindowByID(boxOfficeInformationWindowID);
		} else {
			System.out.println("Public Kiosk not use");
		}

	}

	@Description("Select venue and event")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_004_Manager_004_SelectVenueAndEvent() {
		assertTrue(boxOfficePage.isBoxOfficeTextDisplayed());

		boxOfficePage.clickToDropDownSelectVenue();
		boxOfficePage.clickToValueOfDropdownSelectVenue("City Theater");

		boxOfficePage.clickToDropDownSelectEvent();
		boxOfficePage.clickToValueOfDropdownSelectEvent(eventName);

		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
	}

	@Description("Checkout - when empty data")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_005_Manager_005_CheckoutNowEmptyData() {
		boxOfficePage.clickButtonCheckout("Checkout now");
		boxOfficePage.sleepInSecond(3);
		assertEquals(boxOfficePage.getErrorMessageCheckoutEmptyData(),"Please select at least one ticket");

		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);

		boxOfficePage.clickCheckboxConfirmationDelivery("Email");
		boxOfficePage.clickButtonCheckout("Checkout now");
		boxOfficePage.sleepInSecond(3);
		assertEquals(boxOfficePage.getErrorMessageCheckoutEmptyData(),"Please enter attendee's email");

		boxOfficePage.clickCheckboxConfirmationDelivery("Text");

		boxOfficePage.clickButtonCheckout("Checkout now");
		boxOfficePage.sleepInSecond(3);
		assertEquals(boxOfficePage.getErrorMessageCheckoutEmptyData(),"Please enter attendee's phone number");

		boxOfficePage.clickCheckboxConfirmationDelivery("Email");
		boxOfficePage.clickCheckboxConfirmationDelivery("Text");

	}

	@Description("Checkout - Method: Cash - Status: Success")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_006_Manager_006_CheckoutNowMethodByCashSuccess() {
		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);

		boxOfficePage.clickToRadioButtonPaymentCheckout("Cash");

		boxOfficePage.clickButtonCheckout("Checkout now");

		boxOfficePage.clickButtonPlaceOrder();

		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());

		//Verify Button View Order
		String PageOrderSuccess = driver.getWindowHandle();
		boxOfficePage.clickViewOrderButton();
		boxOfficePage.switchToWindowByID(PageOrderSuccess);

		String PageViewOrder = driver.getWindowHandle();
		driver.close();
		boxOfficePage.switchToWindowByID(PageViewOrder);

		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());

		//Verify Button Print Order - Open when public kiosk reused
		if (ConfigOnOffTestcase.isPublicKioskOn){
			boxOfficePage.clickToMoreMenuButton();
			boxOfficePage.clickToValueOfMoreMennu("Information");
			boxOfficePage.switchToWindowByID(PageOrderSuccess);

			boxOfficePage.clickToDropDownSelectPrinter();
			boxOfficePage.clickToValueOfDropdownSelectPrinter("Please select your printer");

			String pageInformationBoxOffice  = driver.getWindowHandle();;
			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);

			boxOfficePage.clickPrintOrderButton();

			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your printer was not configured!");
			boxOfficePage.acceptAlert();

			boxOfficePage.switchToWindowByID(PageOrderSuccess);
			boxOfficePage.clickToDropDownSelectPrinter();
			boxOfficePage.clickToValueOfDropdownSelectPrinter(printerName);

			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);

			boxOfficePage.clickPrintOrderButton();

			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your paper was not configured!");
			boxOfficePage.acceptAlert();

			boxOfficePage.switchToWindowByID(PageOrderSuccess);
			boxOfficePage.clickToDropDownSelectPaper();
			boxOfficePage.clickToValueOfDropdownSelectPaper(paperName);

			driver.close();
			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);

			boxOfficePage.clickPrintOrderButton();

			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Printing tickets");
			boxOfficePage.acceptAlert();
		} else {
			System.out.println("Public Kiosk not use");
		}


		//Verify Button Back To Box Office
		boxOfficePage.clickBackToBoxOfficeButton();

		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
	}

	@Description("Checkout - Method: Comp - Status: Success")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_007_Manager_007_CheckoutNowMethodByCompSuccess() {
		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);

		boxOfficePage.clickToRadioButtonPaymentCheckout("Comp");

		boxOfficePage.clickButtonCheckout("Checkout now");

		boxOfficePage.clickButtonPlaceOrder();

		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());

		//Verify Button View Order
		String PageOrderSuccess = driver.getWindowHandle();
		boxOfficePage.clickViewOrderButton();
		boxOfficePage.switchToWindowByID(PageOrderSuccess);

		String PageViewOrder = driver.getWindowHandle();
		driver.close();
		boxOfficePage.switchToWindowByID(PageViewOrder);

		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());

		//Verify Button Print Order - Open when public kiosk reused
		if (ConfigOnOffTestcase.isPublicKioskOn) {
			boxOfficePage.clickToMoreMenuButton();

			boxOfficePage.clickToValueOfMoreMennu("Information");
			boxOfficePage.switchToWindowByID(PageOrderSuccess);

			boxOfficePage.clickToDropDownSelectPrinter();
			boxOfficePage.clickToValueOfDropdownSelectPrinter("Please select your printer");

			String pageInformationBoxOffice = driver.getWindowHandle();
			;
			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);

			boxOfficePage.clickPrintOrderButton();

			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(), "Your printer was not configured!");
			boxOfficePage.acceptAlert();

			boxOfficePage.switchToWindowByID(PageOrderSuccess);
			boxOfficePage.clickToDropDownSelectPrinter();
			boxOfficePage.clickToValueOfDropdownSelectPrinter(printerName);

			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);

			boxOfficePage.clickPrintOrderButton();

			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(), "Your paper was not configured!");
			boxOfficePage.acceptAlert();

			boxOfficePage.switchToWindowByID(PageOrderSuccess);
			boxOfficePage.clickToDropDownSelectPaper();
			boxOfficePage.clickToValueOfDropdownSelectPaper(paperName);

			driver.close();
			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);

			boxOfficePage.clickPrintOrderButton();

			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(), "Printing tickets");
			boxOfficePage.acceptAlert();
		} else {
			System.out.println("Public Kiosk not use");
		}

		//Verify Button Back To Box Office
		boxOfficePage.clickBackToBoxOfficeButton();

		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
	}

	@Description("Checkout - Method: Pay Later - Status: Success")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_008_Manager_008_CheckoutNowMethodByPayLaterSuccess() {
		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, "5");

		boxOfficePage.clickToRadioButtonPaymentCheckout("Buy now pay later");

		boxOfficePage.clickButtonCheckout("Checkout now");

		boxOfficePage.clickButtonPlaceOrder();

		boxOfficePage.clickButtonAuthorizeTestPayment();

		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());

		//Verify Button View Order
		String PageOrderSuccess = driver.getWindowHandle();
		boxOfficePage.clickViewOrderButton();
		boxOfficePage.switchToWindowByID(PageOrderSuccess);

		String PageViewOrder = driver.getWindowHandle();
		driver.close();
		boxOfficePage.switchToWindowByID(PageViewOrder);

		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());

		//Verify Button Print Order - Open when public kiosk reused
		if (ConfigOnOffTestcase.isPublicKioskOn) {
		boxOfficePage.clickToMoreMenuButton();

		boxOfficePage.clickToValueOfMoreMennu("Information");
		boxOfficePage.switchToWindowByID(PageOrderSuccess);

		boxOfficePage.clickToDropDownSelectPrinter();
		boxOfficePage.clickToValueOfDropdownSelectPrinter("Please select your printer");

		String pageInformationBoxOffice  = driver.getWindowHandle();;
		boxOfficePage.switchToWindowByID(pageInformationBoxOffice);

		boxOfficePage.clickPrintOrderButton();

		assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your printer was not configured!");
		boxOfficePage.acceptAlert();

		boxOfficePage.switchToWindowByID(PageOrderSuccess);
		boxOfficePage.clickToDropDownSelectPrinter();
		boxOfficePage.clickToValueOfDropdownSelectPrinter(printerName);

		boxOfficePage.switchToWindowByID(pageInformationBoxOffice);

		boxOfficePage.clickPrintOrderButton();

		assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your paper was not configured!");
		boxOfficePage.acceptAlert();

		boxOfficePage.switchToWindowByID(PageOrderSuccess);
		boxOfficePage.clickToDropDownSelectPaper();
		boxOfficePage.clickToValueOfDropdownSelectPaper(paperName);

		driver.close();
		boxOfficePage.switchToWindowByID(pageInformationBoxOffice);

		boxOfficePage.clickPrintOrderButton();

		assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Printing tickets");
		boxOfficePage.acceptAlert();
		} else {
			System.out.println("Public Kiosk not use");
		}


		//Verify Button Back To Box Office
		boxOfficePage.clickBackToBoxOfficeButton();

		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
	}

	@Description("Checkout - Method: Pay Later - Status: Fail reason - total amount <50$")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_009_Manager_009_CheckoutNowMethodByPayLaterFailTotalAmount() {
		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);

		boxOfficePage.clickToRadioButtonPaymentCheckout("Buy now pay later");

		boxOfficePage.clickButtonCheckout("Checkout now");

		assertEquals(boxOfficePage.getErrorMessageFooterBoxOffice(),"Buy now pay later is only available for orders totaling $50 or more.");

		boxOfficePage.clickBackToTickets();

		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
	}

	@Description("Checkout - Method: Pay Later - Status: Fail reason - payment")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_010_Manager_010_CheckoutNowMethodByPaylaterFailTestPayment() {
		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, "5");

		boxOfficePage.clickToRadioButtonPaymentCheckout("Buy now pay later");

		boxOfficePage.clickButtonCheckout("Checkout now");

		boxOfficePage.clickButtonPlaceOrder();

		boxOfficePage.clickButtonFailTestPayment();

		assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Checkout order failed! Please select your ticket and checkout again.");
		boxOfficePage.acceptAlert();

		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());

	}

	@Description("Checkout - Method: Card Swiper - Status: Success")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_011_Manager_011_CheckoutNowMethodByCardSwiperSuccess() {
		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);

		boxOfficePage.clickToRadioButtonPaymentCheckout("Card swiper");

		boxOfficePage.getTextTotalAmountOrder();

		boxOfficePage.clickButtonCheckout("Checkout now");

		if ((boxOfficePage.getTextTotalAmountOrder()).equals("0$")) {
			boxOfficePage.clickButtonPlaceOrder();
		} else {
			assertEquals(boxOfficePage.getTextNameOfReader(),"ss-reader");

			boxOfficePage.clickButtonChargeCard();

			assertTrue(boxOfficePage.isTapOrInsertTextDisplayed());
		}

		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());

		//Verify Button View Order
		String PageOrderSuccess = driver.getWindowHandle();
		boxOfficePage.clickViewOrderButton();
		boxOfficePage.switchToWindowByID(PageOrderSuccess);

		String PageViewOrder = driver.getWindowHandle();
		driver.close();
		boxOfficePage.switchToWindowByID(PageViewOrder);

		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());

		//Verify Button Print Order - Open when public kiosk reused
		if (ConfigOnOffTestcase.isPublicKioskOn) {
			boxOfficePage.clickToMoreMenuButton();

			boxOfficePage.clickToValueOfMoreMennu("Information");
			boxOfficePage.switchToWindowByID(PageOrderSuccess);

			boxOfficePage.clickToDropDownSelectPrinter();
			boxOfficePage.clickToValueOfDropdownSelectPrinter("Please select your printer");

			String pageInformationBoxOffice  = driver.getWindowHandle();;
			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);

			boxOfficePage.clickPrintOrderButton();

			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your printer was not configured!");
			boxOfficePage.acceptAlert();

			boxOfficePage.switchToWindowByID(PageOrderSuccess);
			boxOfficePage.clickToDropDownSelectPrinter();
			boxOfficePage.clickToValueOfDropdownSelectPrinter(printerName);

			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);

			boxOfficePage.clickPrintOrderButton();

			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your paper was not configured!");
			boxOfficePage.acceptAlert();

			boxOfficePage.switchToWindowByID(PageOrderSuccess);
			boxOfficePage.clickToDropDownSelectPaper();
			boxOfficePage.clickToValueOfDropdownSelectPaper(paperName);

			driver.close();
			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);

			boxOfficePage.clickPrintOrderButton();

			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Printing tickets");
			boxOfficePage.acceptAlert();
		} else {
			System.out.println("Public Kiosk not use");
		}


		//Verify Button Back To Box Office
		boxOfficePage.clickBackToBoxOfficeButton();

		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
	}

	@Description("Checkout - Method: Card Swiper - Status: Fail")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_012_Manager_012_CheckoutNowMethodByCardSwiperFail() {
		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);

		boxOfficePage.clickToRadioButtonPaymentCheckout("Card swiper");

		boxOfficePage.getTextTotalAmountOrder();

		boxOfficePage.clickButtonCheckout("Checkout now");

		if ((boxOfficePage.getTextTotalAmountOrder()).equals("0$")) {
			boxOfficePage.clickButtonPlaceOrder();

			assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());

			boxOfficePage.clickBackToBoxOfficeButton();
		} else {
			assertEquals(boxOfficePage.getTextNameOfReader(),"ss-reader");

			boxOfficePage.clickButtonChargeCard();

			boxOfficePage.clickButtonCancelChargeCard();
		}

		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
	}

	@Description("Checkout - Method: Card Manual - Status: Success")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_013_Manager_013_CheckoutNowMethodByCardManuallySuccess() {
		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);

		boxOfficePage.clickToRadioButtonPaymentCheckout("Enter card manually");

		boxOfficePage.getTextTotalAmountOrder();
		boxOfficePage.sleepInSecond(3);


		boxOfficePage.clickButtonCheckout("Checkout now");


		if ((boxOfficePage.getTextTotalAmountOrder()).equals("0$")) {
			boxOfficePage.clickButtonPlaceOrder();
		} else {
			boxOfficePage.switchToFrameIframe();

			boxOfficePage.inputInfoCardManual("Card number", cardNumberValid);
			boxOfficePage.inputInfoCardManual("MM / YY", monthYearValid);
			boxOfficePage.inputInfoCardManual("CVC", cvc);
			boxOfficePage.inputInfoCardManual("ZIP", zip);
			boxOfficePage.switchToDefaultContent();

			boxOfficePage.clickButtonChargeCard();

		}

		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());

		//Verify Button View Order
		String PageOrderSuccess = driver.getWindowHandle();
		boxOfficePage.clickViewOrderButton();
		boxOfficePage.switchToWindowByID(PageOrderSuccess);

		String PageViewOrder = driver.getWindowHandle();
		driver.close();
		boxOfficePage.switchToWindowByID(PageViewOrder);

		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());

		//Verify Button Print Order - Open when public kiosk reused
		if (ConfigOnOffTestcase.isPublicKioskOn) {
			boxOfficePage.clickToMoreMenuButton();

			boxOfficePage.clickToValueOfMoreMennu("Information");
			boxOfficePage.switchToWindowByID(PageOrderSuccess);

			boxOfficePage.clickToDropDownSelectPrinter();
			boxOfficePage.clickToValueOfDropdownSelectPrinter("Please select your printer");

			String pageInformationBoxOffice  = driver.getWindowHandle();;
			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);

			boxOfficePage.clickPrintOrderButton();

			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your printer was not configured!");
			boxOfficePage.acceptAlert();

			boxOfficePage.switchToWindowByID(PageOrderSuccess);
			boxOfficePage.clickToDropDownSelectPrinter();
			boxOfficePage.clickToValueOfDropdownSelectPrinter(printerName);

			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);

			boxOfficePage.clickPrintOrderButton();

			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your paper was not configured!");
			boxOfficePage.acceptAlert();

			boxOfficePage.switchToWindowByID(PageOrderSuccess);
			boxOfficePage.clickToDropDownSelectPaper();
			boxOfficePage.clickToValueOfDropdownSelectPaper(paperName);

			driver.close();
			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);

			boxOfficePage.clickPrintOrderButton();

			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Printing tickets");
			boxOfficePage.acceptAlert();
		} else {
			System.out.println("Public Kiosk not use");
		}


		//Verify Button Back To Box Office
		boxOfficePage.clickBackToBoxOfficeButton();

		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
	}

	@Description("Checkout - Method: Card Manual - Status: Fail")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_014_Manager_014_CheckoutNowMethodByCardManuallyFail() {
		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);

		boxOfficePage.clickToRadioButtonPaymentCheckout("Enter card manually");

		boxOfficePage.getTextTotalAmountOrder();

		boxOfficePage.clickButtonCheckout("Checkout now");

		if ((boxOfficePage.getTextTotalAmountOrder()).equals("0$")) {
			boxOfficePage.clickButtonPlaceOrder();

			assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());

			boxOfficePage.clickBackToBoxOfficeButton();
		} else {
			boxOfficePage.switchToFrameIframe();
			boxOfficePage.inputInfoCardManual("Card number",cardNumberInvalid);
			boxOfficePage.switchToDefaultContent();

			boxOfficePage.clickButtonPlaceOrder();

			assertEquals(boxOfficePage.getErrorMessageChargeCard(),"Your card number is invalid.");

			boxOfficePage.switchToFrameIframe();
			boxOfficePage.inputInfoCardManual("Card number", cardNumberDeclined);
			boxOfficePage.inputInfoCardManual("MM / YY", monthYearValid);
			boxOfficePage.inputInfoCardManual("CVC", cvc);
			boxOfficePage.inputInfoCardManual("ZIP", zip);

			boxOfficePage.switchToDefaultContent();

			boxOfficePage.clickButtonPlaceOrder();

			assertEquals(boxOfficePage.getErrorMessageChargeCard(),"Your card number is incomplete.");

			boxOfficePage.switchToFrameIframe();
			boxOfficePage.inputInfoCardManual("Card number", cardNumberValid);
			boxOfficePage.inputInfoCardManual("MM / YY", monthYearInvalid);

			boxOfficePage.switchToDefaultContent();

			boxOfficePage.clickButtonPlaceOrder();

			assertEquals(boxOfficePage.getErrorMessageChargeCard(),"Your card's expiration year is in the past.");

			boxOfficePage.clickButtonPlaceOrder();

			assertEquals(boxOfficePage.getErrorMessageChargeCard(),"Your card number is incomplete.");

			boxOfficePage.switchToFrameIframe();
			boxOfficePage.inputInfoCardManual("Card number", cardNumberValid);
			boxOfficePage.switchToDefaultContent();

			boxOfficePage.clickButtonPlaceOrder();

			assertEquals(boxOfficePage.getErrorMessageChargeCard(),"Your card's expiration date is incomplete.");

			boxOfficePage.switchToFrameIframe();
			boxOfficePage.inputInfoCardManual("Card number", cardNumberValid);
			boxOfficePage.inputInfoCardManual("MM / YY", monthYearValid);

			boxOfficePage.switchToDefaultContent();

			boxOfficePage.clickButtonPlaceOrder();

			assertEquals(boxOfficePage.getErrorMessageChargeCard(),"Your card's security code is incomplete.");

			boxOfficePage.switchToFrameIframe();
			boxOfficePage.inputInfoCardManual("Card number", cardNumberValid);
			boxOfficePage.inputInfoCardManual("MM / YY", monthYearValid);
			boxOfficePage.inputInfoCardManual("CVC", cvc);
			boxOfficePage.switchToDefaultContent();

			boxOfficePage.clickButtonPlaceOrder();

			assertEquals(boxOfficePage.getErrorMessageChargeCard(),"Your postal code is incomplete.");


			boxOfficePage.clickBackToTickets();
		}
		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
	}

	@Description("Add to cart")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_015_Manager_015_AddToCart() {
		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);

		boxOfficePage.clickButtonCheckout("Add to cart");

		boxOfficePage.clickToMoreMenuButton();
		boxOfficePage.clickToValueOfMoreMennu("Log out");

		assertTrue(boxOfficePage.isLoginButtonDisplayed());
	}

//	@Description("Login Account Staff - Auto and Open Box Office")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_016_StaffAuto_001_OpenUrlLoginAccount() {
//		boxOfficePage.authenAlert();
//		boxOfficePage.loginAccount(emailStaffAuto,passwordStaffAuto);
//
//		boxOfficePage.clickToLoginButton();
//
//		assertTrue(boxOfficePage.isBoxOfficeTextDisplayed());
//	}
//
//	@Description("Verify More Menu")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_017_StaffAuto_002_MoreMenu() {
//		boxOfficePage.clickToMoreMenuButton();
//
//		String boxOfficeWindowID = driver.getWindowHandle();
//		boxOfficePage.clickToValueOfMoreMennu("Instruction");
//		boxOfficePage.switchToWindowByID(boxOfficeWindowID);
//
//		assertTrue(boxOfficePage.isTitleInstructionYoutubeDisplayed());
//		String instructionYoutubeWindowID = driver.getWindowHandle();
//		driver.close();
//		boxOfficePage.switchToWindowByID(instructionYoutubeWindowID);
//
//		boxOfficePage.clickToValueOfMoreMennu("Copy link");
//		boxOfficePage.acceptAlert();
//
//		boxOfficePage.clickToValueOfMoreMennu("Card readers");
//		boxOfficePage.switchToWindowByID(boxOfficeWindowID);
//
//		assertTrue(boxOfficePage.isTitleRegisteredReadersDisplayed());
//		String registeredReadersWindowID = driver.getWindowHandle();
//		driver.close();
//		boxOfficePage.switchToWindowByID(registeredReadersWindowID);
//
//		if (ConfigOnOffTestcase.isPublicKioskOn){
//			boxOfficePage.clickToValueOfMoreMennu("Information");
//			boxOfficePage.switchToWindowByID(boxOfficeWindowID);
//			assertTrue(boxOfficePage.isTitleBoxOfficeInformationDisplayed());
//		} else {
//			System.out.println("Public Kiosk not use");
//		}
//
//	}
//
//	@Ignore
//	@Description("Verify - Information Box Office")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_018_StaffAuto_003_ConfigInformationBoxOffice() {
//		if(ConfigOnOffTestcase.isPublicKioskOn){
//			boxOfficePage.clickToDropDownSelectPrinter();
//			boxOfficePage.clickToValueOfDropdownSelectPrinter(printerName);
//
//			assertTrue(boxOfficePage.isTextSelectdefaultPaperDisplayed());
//
//			boxOfficePage.clickToDropDownSelectPaper();
//			boxOfficePage.clickToValueOfDropdownSelectPaper(paperName);
//
//			assertTrue(boxOfficePage.isSelectedPaperValueDisplayed());
//
//			boxOfficePage.clickToButtonReset();
//			boxOfficePage.acceptAlertReport();
//
//			assertEquals(boxOfficePage.getValueReport("report-card_reader", "total_ticket"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-card_reader", "total_money"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-cash", "total_ticket"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-cash", "total_money"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-online", "total_ticket"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-online", "total_money"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-comp", "total_ticket"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-comp", "total_money"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-affirm", "total_ticket"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-affirm", "total_money"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-total", "total_ticket"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-total", "total_money"),"0");
//
//
//			boxOfficePage.clickToButtonReset();
//			boxOfficePage.cancelAlertReport();
//
//			assertEquals(boxOfficePage.getValueReport("report-card_reader", "total_ticket"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-card_reader", "total_money"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-cash", "total_ticket"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-cash", "total_money"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-online", "total_ticket"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-online", "total_money"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-comp", "total_ticket"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-comp", "total_money"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-affirm", "total_ticket"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-affirm", "total_money"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-total", "total_ticket"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-total", "total_money"),"0");
//
//			boxOfficePage.clickToButtonBackToBoxOfficeFromInformationScreen();
//
//			assertTrue(boxOfficePage.isBoxOfficeTextDisplayed());
//
//			String boxOfficeInformationWindowID = driver.getWindowHandle();
//			driver.close();
//			boxOfficePage.switchToWindowByID(boxOfficeInformationWindowID);
//		} else {
//			System.out.println("Public Kiosk not use");
//		}
//	}
//
//	@Description("Select venue and event")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_019_StaffAuto_004_SelectVenueAndEvent() {
//		assertTrue(boxOfficePage.isBoxOfficeTextDisplayed());
//
//		boxOfficePage.clickToDropDownSelectVenue();
//		boxOfficePage.clickToValueOfDropdownSelectVenue("City Theater");
//
//		boxOfficePage.clickToDropDownSelectEvent();
//		boxOfficePage.clickToValueOfDropdownSelectEvent(eventName);
//
//		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
//	}
//
//	@Description("Checkout - when empty data")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_020_StaffAuto_005_CheckoutNowEmptyData() {
//		boxOfficePage.clickButtonCheckout("Checkout now");
//
//		assertEquals(boxOfficePage.getErrorMessageCheckoutEmptyData(),"Please select at least one ticket");
//
//		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
//
//		boxOfficePage.clickCheckboxConfirmationDelivery("Email");
//		boxOfficePage.clickButtonCheckout("Checkout now");
//
//		assertEquals(boxOfficePage.getErrorMessageCheckoutEmptyData(),"Please enter attendee's email");
//
//		boxOfficePage.clickCheckboxConfirmationDelivery("Text");
//
//		boxOfficePage.clickButtonCheckout("Checkout now");
//
//		assertEquals(boxOfficePage.getErrorMessageCheckoutEmptyData(),"Please enter attendee's phone number");
//
//		boxOfficePage.clickCheckboxConfirmationDelivery("Email");
//		boxOfficePage.clickCheckboxConfirmationDelivery("Text");
//
//	}
//
//	@Description("Checkout - Method: Cash - Status: Success")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_021_StaffAuto_006_CheckoutNowMethodByCashSuccess() {
//		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
//
//		boxOfficePage.clickToRadioButtonPaymentCheckout("Cash");
//
//		boxOfficePage.clickButtonCheckout("Checkout now");
//
//		boxOfficePage.clickButtonPlaceOrder();
//
//		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());
//
//		//Verify Button View Order
//		String PageOrderSuccess = driver.getWindowHandle();
//		boxOfficePage.clickViewOrderButton();
//		boxOfficePage.switchToWindowByID(PageOrderSuccess);
//
//		String PageViewOrder = driver.getWindowHandle();
//		driver.close();
//		boxOfficePage.switchToWindowByID(PageViewOrder);
//
//		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());
//
//		//Verify Button Print Order - Open when public kiosk reused
//		if (ConfigOnOffTestcase.isPublicKioskOn) {
//			boxOfficePage.clickToMoreMenuButton();
//
//			boxOfficePage.clickToValueOfMoreMennu("Information");
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//
//			boxOfficePage.clickToDropDownSelectPrinter();
//			boxOfficePage.clickToValueOfDropdownSelectPrinter("Please select your printer");
//
//			String pageInformationBoxOffice  = driver.getWindowHandle();;
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your printer was not configured!");
//			boxOfficePage.acceptAlert();
//
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//			boxOfficePage.clickToDropDownSelectPrinter();
//			boxOfficePage.clickToValueOfDropdownSelectPrinter(printerName);
//
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your paper was not configured!");
//			boxOfficePage.acceptAlert();
//
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//			boxOfficePage.clickToDropDownSelectPaper();
//			boxOfficePage.clickToValueOfDropdownSelectPaper(paperName);
//
//			driver.close();
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Printing tickets");
//			boxOfficePage.acceptAlert();
//		} else {
//			System.out.println("Public Kiosk not use");
//		}
//
//
//		//Verify Button Back To Box Office
//		boxOfficePage.clickBackToBoxOfficeButton();
//
//		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
//	}
//
//	@Description("Checkout - Method: Comp - Status: Success")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_22_StaffAuto_007_CheckoutNowMethodByCompSuccess() {
//		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
//
//		boxOfficePage.clickToRadioButtonPaymentCheckout("Comp");
//
//		boxOfficePage.clickButtonCheckout("Checkout now");
//
//		boxOfficePage.clickButtonPlaceOrder();
//
//		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());
//
//		//Verify Button View Order
//		String PageOrderSuccess = driver.getWindowHandle();
//		boxOfficePage.clickViewOrderButton();
//		boxOfficePage.switchToWindowByID(PageOrderSuccess);
//
//		String PageViewOrder = driver.getWindowHandle();
//		driver.close();
//		boxOfficePage.switchToWindowByID(PageViewOrder);
//
//		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());
//
//		//Verify Button Print Order - Open when public kiosk reused
//		if (ConfigOnOffTestcase.isPublicKioskOn) {
//			boxOfficePage.clickToMoreMenuButton();
//
//			boxOfficePage.clickToValueOfMoreMennu("Information");
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//
//			boxOfficePage.clickToDropDownSelectPrinter();
//			boxOfficePage.clickToValueOfDropdownSelectPrinter("Please select your printer");
//
//			String pageInformationBoxOffice  = driver.getWindowHandle();;
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your printer was not configured!");
//			boxOfficePage.acceptAlert();
//
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//			boxOfficePage.clickToDropDownSelectPrinter();
//			boxOfficePage.clickToValueOfDropdownSelectPrinter(printerName);
//
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your paper was not configured!");
//			boxOfficePage.acceptAlert();
//
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//			boxOfficePage.clickToDropDownSelectPaper();
//			boxOfficePage.clickToValueOfDropdownSelectPaper(paperName);
//
//			driver.close();
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Printing tickets");
//			boxOfficePage.acceptAlert();
//		} else {
//			System.out.println("Public Kiosk not use");
//		}
//
//
//		//Verify Button Back To Box Office
//		boxOfficePage.clickBackToBoxOfficeButton();
//
//		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
//	}
//
//	@Description("Checkout - Method: Pay Later - Status: Success")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_023_StaffAuto_008_CheckoutNowMethodByPayLaterSuccess() {
//		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, "5");
//
//		boxOfficePage.clickToRadioButtonPaymentCheckout("Buy now pay later");
//
//		boxOfficePage.clickButtonCheckout("Checkout now");
//
//		boxOfficePage.clickButtonPlaceOrder();
//
//		boxOfficePage.clickButtonAuthorizeTestPayment();
//
//		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());
//
//		//Verify Button View Order
//		String PageOrderSuccess = driver.getWindowHandle();
//		boxOfficePage.clickViewOrderButton();
//		boxOfficePage.switchToWindowByID(PageOrderSuccess);
//
//		String PageViewOrder = driver.getWindowHandle();
//		driver.close();
//		boxOfficePage.switchToWindowByID(PageViewOrder);
//
//		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());
//
//		//Verify Button Print Order - Open when public kiosk reused
//		if (ConfigOnOffTestcase.isPublicKioskOn) {
//			boxOfficePage.clickToMoreMenuButton();
//
//			boxOfficePage.clickToValueOfMoreMennu("Information");
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//
//			boxOfficePage.clickToDropDownSelectPrinter();
//			boxOfficePage.clickToValueOfDropdownSelectPrinter("Please select your printer");
//
//			String pageInformationBoxOffice  = driver.getWindowHandle();;
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your printer was not configured!");
//			boxOfficePage.acceptAlert();
//
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//			boxOfficePage.clickToDropDownSelectPrinter();
//			boxOfficePage.clickToValueOfDropdownSelectPrinter(printerName);
//
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your paper was not configured!");
//			boxOfficePage.acceptAlert();
//
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//			boxOfficePage.clickToDropDownSelectPaper();
//			boxOfficePage.clickToValueOfDropdownSelectPaper(paperName);
//
//			driver.close();
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Printing tickets");
//			boxOfficePage.acceptAlert();
//		} else {
//			System.out.println("Public Kiosk not use");
//		}
//
//
//		//Verify Button Back To Box Office
//		boxOfficePage.clickBackToBoxOfficeButton();
//
//		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
//	}
//
//	@Description("Checkout - Method: Pay Later - Status: Fail reason - total amount <50$")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_024_StaffAuto_009_CheckoutNowMethodByPayLaterFailTotalAmount() {
//		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
//
//		boxOfficePage.clickToRadioButtonPaymentCheckout("Buy now pay later");
//
//		boxOfficePage.clickButtonCheckout("Checkout now");
//
//		assertEquals(boxOfficePage.getErrorMessageFooterBoxOffice(),"Buy now pay later is only available for orders totaling $50 or more.");
//
//		boxOfficePage.clickBackToTickets();
//
//		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
//	}
//
//	@Description("Checkout - Method: Pay Later - Status: Fail reason - payment")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_025_StaffAuto_010_CheckoutNowMethodByPaylaterFailTestPayment() {
//		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, "5");
//
//		boxOfficePage.clickToRadioButtonPaymentCheckout("Buy now pay later");
//
//		boxOfficePage.clickButtonCheckout("Checkout now");
//
//		boxOfficePage.clickButtonPlaceOrder();
//
//		boxOfficePage.clickButtonFailTestPayment();
//
//		assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Checkout order failed! Please select your ticket and checkout again.");
//		boxOfficePage.acceptAlert();
//
//		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
//
//	}
//
//	@Description("Checkout - Method: Card Swiper - Status: Success")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_026_StaffAuto_011_CheckoutNowMethodByCardSwiperSuccess() {
//		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName,quantityTicket);
//
//		boxOfficePage.clickToRadioButtonPaymentCheckout("Card swiper");
//
//		boxOfficePage.getTextTotalAmountOrder();
//
//		boxOfficePage.clickButtonCheckout("Checkout now");
//
//		if ((boxOfficePage.getTextTotalAmountOrder()).equals("0$")) {
//			boxOfficePage.clickButtonPlaceOrder();
//		} else {
//			assertEquals(boxOfficePage.getTextNameOfReader(),"ss-reader");
//
//			boxOfficePage.clickButtonChargeCard();
//
//			assertTrue(boxOfficePage.isTapOrInsertTextDisplayed());
//		}
//
//		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());
//
//		//Verify Button View Order
//		String PageOrderSuccess = driver.getWindowHandle();
//		boxOfficePage.clickViewOrderButton();
//		boxOfficePage.switchToWindowByID(PageOrderSuccess);
//
//		String PageViewOrder = driver.getWindowHandle();
//		driver.close();
//		boxOfficePage.switchToWindowByID(PageViewOrder);
//
//		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());
//
//		//Verify Button Print Order - Open when public kiosk reused
//		if (ConfigOnOffTestcase.isPublicKioskOn) {
//			boxOfficePage.clickToMoreMenuButton();
//
//			boxOfficePage.clickToValueOfMoreMennu("Information");
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//
//			boxOfficePage.clickToDropDownSelectPrinter();
//			boxOfficePage.clickToValueOfDropdownSelectPrinter("Please select your printer");
//
//			String pageInformationBoxOffice  = driver.getWindowHandle();;
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your printer was not configured!");
//			boxOfficePage.acceptAlert();
//
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//			boxOfficePage.clickToDropDownSelectPrinter();
//			boxOfficePage.clickToValueOfDropdownSelectPrinter(printerName);
//
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your paper was not configured!");
//			boxOfficePage.acceptAlert();
//
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//			boxOfficePage.clickToDropDownSelectPaper();
//			boxOfficePage.clickToValueOfDropdownSelectPaper(paperName);
//
//			driver.close();
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Printing tickets");
//			boxOfficePage.acceptAlert();
//		} else {
//			System.out.println("Public Kiosk not use");
//		}
//
//
//		//Verify Button Back To Box Office
//		boxOfficePage.clickBackToBoxOfficeButton();
//
//		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
//	}
//
//	@Description("Checkout - Method: Card Swiper - Status: Fail")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_027_StaffAuto_012_CheckoutNowMethodByCardSwiperFail() {
//		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
//
//		boxOfficePage.clickToRadioButtonPaymentCheckout("Card swiper");
//
//		boxOfficePage.getTextTotalAmountOrder();
//
//		boxOfficePage.clickButtonCheckout("Checkout now");
//
//		if ((boxOfficePage.getTextTotalAmountOrder()).equals("0$")) {
//			boxOfficePage.clickButtonPlaceOrder();
//
//			assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());
//
//			boxOfficePage.clickBackToBoxOfficeButton();
//		} else {
//			assertEquals(boxOfficePage.getTextNameOfReader(),"ss-reader");
//
//			boxOfficePage.clickButtonChargeCard();
//
//			boxOfficePage.clickButtonCancelChargeCard();
//		}
//
//		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
//	}
//
//	@Description("Checkout - Method: Card Manual - Status: Success")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_028_StaffAuto_013_CheckoutNowMethodByCardManuallySuccess() {
//		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
//
//		boxOfficePage.clickToRadioButtonPaymentCheckout("Enter card manually");
//
//		boxOfficePage.getTextTotalAmountOrder();
//		boxOfficePage.sleepInSecond(3);
//
//		boxOfficePage.clickButtonCheckout("Checkout now");
//
//		if ((boxOfficePage.getTextTotalAmountOrder()).equals("0$")) {
//			boxOfficePage.clickButtonPlaceOrder();
//		} else {
//			boxOfficePage.switchToFrameIframe();
//
//			boxOfficePage.inputInfoCardManual("Card number", cardNumberValid);
//			boxOfficePage.inputInfoCardManual("MM / YY", monthYearValid);
//			boxOfficePage.inputInfoCardManual("CVC", cvc);
//			boxOfficePage.inputInfoCardManual("ZIP", zip);
//			boxOfficePage.switchToDefaultContent();
//
//			boxOfficePage.clickButtonChargeCard();
//		}
//
//		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());
//
//		//Verify Button View Order
//		String PageOrderSuccess = driver.getWindowHandle();
//		boxOfficePage.clickViewOrderButton();
//		boxOfficePage.switchToWindowByID(PageOrderSuccess);
//
//		String PageViewOrder = driver.getWindowHandle();
//		driver.close();
//		boxOfficePage.switchToWindowByID(PageViewOrder);
//
//		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());
//
//		//Verify Button Print Order - Open when public kiosk reused
//		if (ConfigOnOffTestcase.isPublicKioskOn) {
//			boxOfficePage.clickToMoreMenuButton();
//
//			boxOfficePage.clickToValueOfMoreMennu("Information");
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//
//			boxOfficePage.clickToDropDownSelectPrinter();
//			boxOfficePage.clickToValueOfDropdownSelectPrinter("Please select your printer");
//
//			String pageInformationBoxOffice  = driver.getWindowHandle();;
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your printer was not configured!");
//			boxOfficePage.acceptAlert();
//
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//			boxOfficePage.clickToDropDownSelectPrinter();
//			boxOfficePage.clickToValueOfDropdownSelectPrinter(printerName);
//
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your paper was not configured!");
//			boxOfficePage.acceptAlert();
//
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//			boxOfficePage.clickToDropDownSelectPaper();
//			boxOfficePage.clickToValueOfDropdownSelectPaper(paperName);
//
//			driver.close();
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Printing tickets");
//			boxOfficePage.acceptAlert();
//		} else {
//			System.out.println("Public Kiosk not use");
//		}
//
//
//		//Verify Button Back To Box Office
//		boxOfficePage.clickBackToBoxOfficeButton();
//
//		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
//	}
//
//	@Description("Checkout - Method: Card Manual - Status: Fail")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_029_StaffAuto_014_CheckoutNowMethodByCardManuallyFail() {
//		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
//
//		boxOfficePage.clickToRadioButtonPaymentCheckout("Enter card manually");
//
//		boxOfficePage.getTextTotalAmountOrder();
//
//		boxOfficePage.clickButtonCheckout("Checkout now");
//
//		if ((boxOfficePage.getTextTotalAmountOrder()).equals("0$")) {
//			boxOfficePage.clickButtonPlaceOrder();
//
//			assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());
//
//			boxOfficePage.clickBackToBoxOfficeButton();
//		} else {
//			boxOfficePage.switchToFrameIframe();
//			boxOfficePage.inputInfoCardManual("Card number",cardNumberInvalid);
//			boxOfficePage.switchToDefaultContent();
//
//			boxOfficePage.clickButtonPlaceOrder();
//
//			assertEquals(boxOfficePage.getErrorMessageChargeCard(),"Your card number is invalid.");
//
//			boxOfficePage.switchToFrameIframe();
//			boxOfficePage.inputInfoCardManual("Card number", cardNumberDeclined);
//			boxOfficePage.inputInfoCardManual("MM / YY", monthYearValid);
//			boxOfficePage.inputInfoCardManual("CVC", cvc);
//			boxOfficePage.inputInfoCardManual("ZIP", zip);
//
//			boxOfficePage.switchToDefaultContent();
//
//			boxOfficePage.clickButtonPlaceOrder();
//
//			assertEquals(boxOfficePage.getErrorMessageChargeCard(),"Your card number is incomplete.");
//
//			boxOfficePage.switchToFrameIframe();
//			boxOfficePage.inputInfoCardManual("Card number", cardNumberValid);
//			boxOfficePage.inputInfoCardManual("MM / YY", monthYearInvalid);
//
//			boxOfficePage.switchToDefaultContent();
//
//			boxOfficePage.clickButtonPlaceOrder();
//
//			assertEquals(boxOfficePage.getErrorMessageChargeCard(),"Your card's expiration year is in the past.");
//
//			boxOfficePage.clickButtonPlaceOrder();
//
//			assertEquals(boxOfficePage.getErrorMessageChargeCard(),"Your card number is incomplete.");
//
//			boxOfficePage.switchToFrameIframe();
//			boxOfficePage.inputInfoCardManual("Card number", cardNumberValid);
//			boxOfficePage.switchToDefaultContent();
//
//			boxOfficePage.clickButtonPlaceOrder();
//
//			assertEquals(boxOfficePage.getErrorMessageChargeCard(),"Your card's expiration date is incomplete.");
//
//			boxOfficePage.switchToFrameIframe();
//			boxOfficePage.inputInfoCardManual("Card number", cardNumberValid);
//			boxOfficePage.inputInfoCardManual("MM / YY", monthYearValid);
//
//			boxOfficePage.switchToDefaultContent();
//
//			boxOfficePage.clickButtonPlaceOrder();
//
//			assertEquals(boxOfficePage.getErrorMessageChargeCard(),"Your card's security code is incomplete.");
//
//			boxOfficePage.switchToFrameIframe();
//			boxOfficePage.inputInfoCardManual("Card number", cardNumberValid);
//			boxOfficePage.inputInfoCardManual("MM / YY", monthYearValid);
//			boxOfficePage.inputInfoCardManual("CVC", cvc);
//			boxOfficePage.switchToDefaultContent();
//
//			boxOfficePage.clickButtonPlaceOrder();
//
//			assertEquals(boxOfficePage.getErrorMessageChargeCard(),"Your postal code is incomplete.");
//
//
//			boxOfficePage.clickBackToTickets();
//		}
//		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
//	}
//
//	@Description("Add to cart")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_030_StaffAuto_015_AddToCart() {
//		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
//
//		boxOfficePage.clickButtonCheckout("Add to cart");
//
//		boxOfficePage.clickToMoreMenuButton();
//		boxOfficePage.clickToValueOfMoreMennu("Log out");
//
//		assertTrue(boxOfficePage.isLoginButtonDisplayed());
//	}
//
//	@Description("Login Account Staff - Auto and Open Box Office")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_031_StaffManual_001_OpenUrlLoginAccount() {
//		boxOfficePage.authenAlert();
//
//		boxOfficePage.loginAccount(emailStaffAuto,passwordStaffAuto);
//
//		boxOfficePage.clickToLoginButton();
//
//		assertTrue(boxOfficePage.isBoxOfficeTextDisplayed());
//	}
//
//	@Description("Verify More Menu")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_032_StaffManual_002_MoreMenu() {
//		boxOfficePage.clickToMoreMenuButton();
//
//		String boxOfficeWindowID = driver.getWindowHandle();
//		boxOfficePage.clickToValueOfMoreMennu("Instruction");
//		boxOfficePage.switchToWindowByID(boxOfficeWindowID);
//
//		assertTrue(boxOfficePage.isTitleInstructionYoutubeDisplayed());
//		String instructionYoutubeWindowID = driver.getWindowHandle();
//		driver.close();
//		boxOfficePage.switchToWindowByID(instructionYoutubeWindowID);
//
//		boxOfficePage.clickToValueOfMoreMennu("Copy link");
//		boxOfficePage.acceptAlert();
//
//		boxOfficePage.clickToValueOfMoreMennu("Card readers");
//		boxOfficePage.switchToWindowByID(boxOfficeWindowID);
//
//		assertTrue(boxOfficePage.isTitleRegisteredReadersDisplayed());
//		String registeredReadersWindowID = driver.getWindowHandle();
//		driver.close();
//		boxOfficePage.switchToWindowByID(registeredReadersWindowID);
//
//		if (ConfigOnOffTestcase.isPublicKioskOn){
//			boxOfficePage.clickToValueOfMoreMennu("Information");
//			boxOfficePage.switchToWindowByID(boxOfficeWindowID);
//			assertTrue(boxOfficePage.isTitleBoxOfficeInformationDisplayed());
//		} else {
//			System.out.println("Public Kiosk not use");
//		}
//	}
//
//	@Ignore
//	@Description("Verify - Information Box Office")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_033_StaffManual_003_ConfigInformationBoxOffice() {
//		if (ConfigOnOffTestcase.isPublicKioskOn){
//			boxOfficePage.clickToDropDownSelectPrinter();
//			boxOfficePage.clickToValueOfDropdownSelectPrinter(printerName);
//
//			assertTrue(boxOfficePage.isTextSelectdefaultPaperDisplayed());
//
//			boxOfficePage.clickToDropDownSelectPaper();
//			boxOfficePage.clickToValueOfDropdownSelectPaper(paperName);
//
//			assertTrue(boxOfficePage.isSelectedPaperValueDisplayed());
//
//			boxOfficePage.clickToButtonReset();
//			boxOfficePage.acceptAlertReport();
//
//			assertEquals(boxOfficePage.getValueReport("report-card_reader", "total_ticket"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-card_reader", "total_money"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-cash", "total_ticket"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-cash", "total_money"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-online", "total_ticket"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-online", "total_money"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-comp", "total_ticket"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-comp", "total_money"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-affirm", "total_ticket"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-affirm", "total_money"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-total", "total_ticket"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-total", "total_money"),"0");
//
//
//			boxOfficePage.clickToButtonReset();
//			boxOfficePage.cancelAlertReport();
//
//			assertEquals(boxOfficePage.getValueReport("report-card_reader", "total_ticket"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-card_reader", "total_money"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-cash", "total_ticket"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-cash", "total_money"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-online", "total_ticket"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-online", "total_money"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-comp", "total_ticket"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-comp", "total_money"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-affirm", "total_ticket"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-affirm", "total_money"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-total", "total_ticket"),"0");
//			assertEquals(boxOfficePage.getValueReport("report-total", "total_money"),"0");
//
//			boxOfficePage.clickToButtonBackToBoxOfficeFromInformationScreen();
//
//			assertTrue(boxOfficePage.isBoxOfficeTextDisplayed());
//
//			String boxOfficeInformationWindowID = driver.getWindowHandle();
//			driver.close();
//			boxOfficePage.switchToWindowByID(boxOfficeInformationWindowID);
//		} else {
//			System.out.println("Public Kiosk not use");
//		}
//
//	}
//
//	@Description("Select venue and event")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_034_StaffManual_004_SelectVenueAndEvent() {
//		assertTrue(boxOfficePage.isBoxOfficeTextDisplayed());
//
//		boxOfficePage.clickToDropDownSelectVenue();
//		boxOfficePage.clickToValueOfDropdownSelectVenue("City Theater");
//
//		boxOfficePage.clickToDropDownSelectEvent();
//		boxOfficePage.clickToValueOfDropdownSelectEvent(eventName);
//
//		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
//	}
//
//	@Description("Checkout - when empty data")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_035_StaffManual_005_CheckoutNowEmptyData() {
//		boxOfficePage.clickButtonCheckout("Checkout now");
//
//		assertEquals(boxOfficePage.getErrorMessageCheckoutEmptyData(),"Please select at least one ticket");
//
//		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
//
//		boxOfficePage.clickCheckboxConfirmationDelivery("Email");
//		boxOfficePage.clickButtonCheckout("Checkout now");
//
//		assertEquals(boxOfficePage.getErrorMessageCheckoutEmptyData(),"Please enter attendee's email");
//
//		boxOfficePage.clickCheckboxConfirmationDelivery("Text");
//
//		boxOfficePage.clickButtonCheckout("Checkout now");
//
//		assertEquals(boxOfficePage.getErrorMessageCheckoutEmptyData(),"Please enter attendee's phone number");
//
//		boxOfficePage.clickCheckboxConfirmationDelivery("Email");
//		boxOfficePage.clickCheckboxConfirmationDelivery("Text");
//
//	}
//
//	@Description("Checkout - Method: Cash - Status: Success")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_036_StaffManual_006_CheckoutNowMethodByCashSuccess() {
//		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
//
//		boxOfficePage.clickToRadioButtonPaymentCheckout("Cash");
//
//		boxOfficePage.clickButtonCheckout("Checkout now");
//
//		boxOfficePage.clickButtonPlaceOrder();
//
//		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());
//
//		//Verify Button View Order
//		String PageOrderSuccess = driver.getWindowHandle();
//		boxOfficePage.clickViewOrderButton();
//		boxOfficePage.switchToWindowByID(PageOrderSuccess);
//
//		String PageViewOrder = driver.getWindowHandle();
//		driver.close();
//		boxOfficePage.switchToWindowByID(PageViewOrder);
//
//		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());
//
//		//Verify Button Print Order- Open when public kiosk reused
//		if(ConfigOnOffTestcase.isPublicKioskOn){
//			boxOfficePage.clickToMoreMenuButton();
//
//			boxOfficePage.clickToValueOfMoreMennu("Information");
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//
//			boxOfficePage.clickToDropDownSelectPrinter();
//			boxOfficePage.clickToValueOfDropdownSelectPrinter("Please select your printer");
//
//			String pageInformationBoxOffice  = driver.getWindowHandle();;
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your printer was not configured!");
//			boxOfficePage.acceptAlert();
//
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//			boxOfficePage.clickToDropDownSelectPrinter();
//			boxOfficePage.clickToValueOfDropdownSelectPrinter(printerName);
//
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your paper was not configured!");
//			boxOfficePage.acceptAlert();
//
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//			boxOfficePage.clickToDropDownSelectPaper();
//			boxOfficePage.clickToValueOfDropdownSelectPaper(paperName);
//
//			driver.close();
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Printing tickets");
//			boxOfficePage.acceptAlert();
//		} else {
//		System.out.println("Public Kiosk not use");
//	}
//
//
//		//Verify Button Back To Box Office
//		boxOfficePage.clickBackToBoxOfficeButton();
//
//		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
//	}
//
//	@Description("Checkout - Method: Comp - Status: Success")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_037_StaffManual_007_CheckoutNowMethodByCompSuccess() {
//		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
//
//		boxOfficePage.clickToRadioButtonPaymentCheckout("Comp");
//
//		boxOfficePage.clickButtonCheckout("Checkout now");
//
//		boxOfficePage.clickButtonPlaceOrder();
//
//		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());
//
//		//Verify Button View Order
//		String PageOrderSuccess = driver.getWindowHandle();
//		boxOfficePage.clickViewOrderButton();
//		boxOfficePage.switchToWindowByID(PageOrderSuccess);
//
//		String PageViewOrder = driver.getWindowHandle();
//		driver.close();
//		boxOfficePage.switchToWindowByID(PageViewOrder);
//
//		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());
//
//		//Verify Button Print Order - Open when public kiosk reused
//		if (ConfigOnOffTestcase.isPublicKioskOn) {
//			boxOfficePage.clickToMoreMenuButton();
//
//			boxOfficePage.clickToValueOfMoreMennu("Information");
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//
//			boxOfficePage.clickToDropDownSelectPrinter();
//			boxOfficePage.clickToValueOfDropdownSelectPrinter("Please select your printer");
//
//			String pageInformationBoxOffice  = driver.getWindowHandle();;
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your printer was not configured!");
//			boxOfficePage.acceptAlert();
//
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//			boxOfficePage.clickToDropDownSelectPrinter();
//			boxOfficePage.clickToValueOfDropdownSelectPrinter(printerName);
//
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your paper was not configured!");
//			boxOfficePage.acceptAlert();
//
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//			boxOfficePage.clickToDropDownSelectPaper();
//			boxOfficePage.clickToValueOfDropdownSelectPaper(paperName);
//
//			driver.close();
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Printing tickets");
//			boxOfficePage.acceptAlert();
//		} else {
//			System.out.println("Public Kiosk not use");
//		}
//
//
//		//Verify Button Back To Box Office
//		boxOfficePage.clickBackToBoxOfficeButton();
//
//		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
//	}
//
//	@Description("Checkout - Method: Pay Later - Status: Success")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_038_StaffManual_008_CheckoutNowMethodByPayLaterSuccess() {
//		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, "5");
//
//		boxOfficePage.clickToRadioButtonPaymentCheckout("Buy now pay later");
//
//		boxOfficePage.clickButtonCheckout("Checkout now");
//
//		boxOfficePage.clickButtonPlaceOrder();
//
//		boxOfficePage.clickButtonAuthorizeTestPayment();
//
//		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());
//
//		//Verify Button View Order
//		String PageOrderSuccess = driver.getWindowHandle();
//		boxOfficePage.clickViewOrderButton();
//		boxOfficePage.switchToWindowByID(PageOrderSuccess);
//
//		String PageViewOrder = driver.getWindowHandle();
//		driver.close();
//		boxOfficePage.switchToWindowByID(PageViewOrder);
//
//		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());
//
//		//Verify Button Print Order - Open when public kiosk reused
//		if (ConfigOnOffTestcase.isPublicKioskOn) {
//			boxOfficePage.clickToMoreMenuButton();
//
//			boxOfficePage.clickToValueOfMoreMennu("Information");
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//
//			boxOfficePage.clickToDropDownSelectPrinter();
//			boxOfficePage.clickToValueOfDropdownSelectPrinter("Please select your printer");
//
//			String pageInformationBoxOffice  = driver.getWindowHandle();;
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your printer was not configured!");
//			boxOfficePage.acceptAlert();
//
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//			boxOfficePage.clickToDropDownSelectPrinter();
//			boxOfficePage.clickToValueOfDropdownSelectPrinter(printerName);
//
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your paper was not configured!");
//			boxOfficePage.acceptAlert();
//
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//			boxOfficePage.clickToDropDownSelectPaper();
//			boxOfficePage.clickToValueOfDropdownSelectPaper(paperName);
//
//			driver.close();
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Printing tickets");
//			boxOfficePage.acceptAlert();
//		} else {
//			System.out.println("Public Kiosk not use");
//		}
//
//
//		//Verify Button Back To Box Office
//		boxOfficePage.clickBackToBoxOfficeButton();
//
//		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
//	}
//
//	@Description("Checkout - Method: Pay Later - Status: Fail reason - total amount <50$")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_039_StaffManual_009_CheckoutNowMethodByPayLaterFailTotalAmount() {
//		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
//
//		boxOfficePage.clickToRadioButtonPaymentCheckout("Buy now pay later");
//
//		boxOfficePage.clickButtonCheckout("Checkout now");
//
//		assertEquals(boxOfficePage.getErrorMessageFooterBoxOffice(),"Buy now pay later is only available for orders totaling $50 or more.");
//
//		boxOfficePage.clickBackToTickets();
//
//		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
//	}
//
//	@Description("Checkout - Method: Pay Later - Status: Fail reason - payment")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_040_StaffManual_010_CheckoutNowMethodByPaylaterFailTestPayment() {
//		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, "5");
//
//		boxOfficePage.clickToRadioButtonPaymentCheckout("Buy now pay later");
//
//		boxOfficePage.clickButtonCheckout("Checkout now");
//
//		boxOfficePage.clickButtonPlaceOrder();
//
//		boxOfficePage.clickButtonFailTestPayment();
//
//		assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Checkout order failed! Please select your ticket and checkout again.");
//		boxOfficePage.acceptAlert();
//
//		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
//
//	}
//
//	@Description("Checkout - Method: Card Swiper - Status: Success")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_041_StaffManual_011_CheckoutNowMethodByCardSwiperSuccess() {
//		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, "5");
//
//		boxOfficePage.clickToRadioButtonPaymentCheckout("Card swiper");
//
//		boxOfficePage.getTextTotalAmountOrder();
//
//		boxOfficePage.clickButtonCheckout("Checkout now");
//
//		if ((boxOfficePage.getTextTotalAmountOrder()).equals("0$")) {
//			boxOfficePage.clickButtonPlaceOrder();
//		} else {
//			assertEquals(boxOfficePage.getTextNameOfReader(),"ss-reader");
//
//			boxOfficePage.clickButtonChargeCard();
//
//			assertTrue(boxOfficePage.isTapOrInsertTextDisplayed());
//		}
//
//		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());
//
//		//Verify Button View Order
//		String PageOrderSuccess = driver.getWindowHandle();
//		boxOfficePage.clickViewOrderButton();
//		boxOfficePage.switchToWindowByID(PageOrderSuccess);
//
//		String PageViewOrder = driver.getWindowHandle();
//		driver.close();
//		boxOfficePage.switchToWindowByID(PageViewOrder);
//
//		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());
//
//		//Verify Button Print Order - Open when public kiosk reused
//		if (ConfigOnOffTestcase.isPublicKioskOn) {
//			boxOfficePage.clickToMoreMenuButton();
//
//			boxOfficePage.clickToValueOfMoreMennu("Information");
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//
//			boxOfficePage.clickToDropDownSelectPrinter();
//			boxOfficePage.clickToValueOfDropdownSelectPrinter("Please select your printer");
//
//			String pageInformationBoxOffice  = driver.getWindowHandle();;
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your printer was not configured!");
//			boxOfficePage.acceptAlert();
//
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//			boxOfficePage.clickToDropDownSelectPrinter();
//			boxOfficePage.clickToValueOfDropdownSelectPrinter(printerName);
//
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your paper was not configured!");
//			boxOfficePage.acceptAlert();
//
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//			boxOfficePage.clickToDropDownSelectPaper();
//			boxOfficePage.clickToValueOfDropdownSelectPaper(paperName);
//
//			driver.close();
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Printing tickets");
//			boxOfficePage.acceptAlert();
//		} else {
//			System.out.println("Public Kiosk not use");
//		}
//
//
//		//Verify Button Back To Box Office
//		boxOfficePage.clickBackToBoxOfficeButton();
//
//		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
//	}
//
//	@Description("Checkout - Method: Card Swiper - Status: Fail")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_042_StaffManual_012_CheckoutNowMethodByCardSwiperFail() {
//		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
//
//		boxOfficePage.clickToRadioButtonPaymentCheckout("Card swiper");
//
//		boxOfficePage.getTextTotalAmountOrder();
//
//		boxOfficePage.clickButtonCheckout("Checkout now");
//
//		if ((boxOfficePage.getTextTotalAmountOrder()).equals("0$")) {
//			boxOfficePage.clickButtonPlaceOrder();
//
//			assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());
//
//			boxOfficePage.clickBackToBoxOfficeButton();
//		} else {
//			assertEquals(boxOfficePage.getTextNameOfReader(),"ss-reader");
//
//			boxOfficePage.clickButtonChargeCard();
//
//			boxOfficePage.clickButtonCancelChargeCard();
//		}
//
//		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
//	}
//
//	@Description("Checkout - Method: Card Manual - Status: Success")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_043_StaffManual_013_CheckoutNowMethodByCardManuallySuccess() {
//		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
//
//		boxOfficePage.clickToRadioButtonPaymentCheckout("Enter card manually");
//
//		boxOfficePage.getTextTotalAmountOrder();
//		boxOfficePage.sleepInSecond(3);
//
//
//		boxOfficePage.clickButtonCheckout("Checkout now");
//
//		if ((boxOfficePage.getTextTotalAmountOrder()).equals("0$")) {
//			boxOfficePage.clickButtonPlaceOrder();
//		} else {
//			boxOfficePage.switchToFrameIframe();
//
//			boxOfficePage.inputInfoCardManual("Card number", cardNumberValid);
//			boxOfficePage.inputInfoCardManual("MM / YY", monthYearValid);
//			boxOfficePage.inputInfoCardManual("CVC", cvc);
//			boxOfficePage.inputInfoCardManual("ZIP", zip);
//			boxOfficePage.switchToDefaultContent();
//
//			boxOfficePage.clickButtonPlaceOrder();
//		}
//
//		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());
//
//		//Verify Button View Order
//		String PageOrderSuccess = driver.getWindowHandle();
//		boxOfficePage.clickViewOrderButton();
//		boxOfficePage.switchToWindowByID(PageOrderSuccess);
//
//		String PageViewOrder = driver.getWindowHandle();
//		driver.close();
//		boxOfficePage.switchToWindowByID(PageViewOrder);
//
//		assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());
//
//		//Verify Button Print Order - Open when public kiosk reused
//		if (ConfigOnOffTestcase.isPublicKioskOn) {
//			boxOfficePage.clickToMoreMenuButton();
//
//			boxOfficePage.clickToValueOfMoreMennu("Information");
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//
//			boxOfficePage.clickToDropDownSelectPrinter();
//			boxOfficePage.clickToValueOfDropdownSelectPrinter("Please select your printer");
//
//			String pageInformationBoxOffice  = driver.getWindowHandle();;
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your printer was not configured!");
//			boxOfficePage.acceptAlert();
//
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//			boxOfficePage.clickToDropDownSelectPrinter();
//			boxOfficePage.clickToValueOfDropdownSelectPrinter(printerName);
//
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Your paper was not configured!");
//			boxOfficePage.acceptAlert();
//
//			boxOfficePage.switchToWindowByID(PageOrderSuccess);
//			boxOfficePage.clickToDropDownSelectPaper();
//			boxOfficePage.clickToValueOfDropdownSelectPaper(paperName);
//
//			driver.close();
//			boxOfficePage.switchToWindowByID(pageInformationBoxOffice);
//
//			boxOfficePage.clickPrintOrderButton();
//
//			assertEquals(boxOfficePage.getTextOfAlertBoxOffice(),"Printing tickets");
//			boxOfficePage.acceptAlert();
//		} else {
//			System.out.println("Public Kiosk not use");
//		}
//
//
//		//Verify Button Back To Box Office
//		boxOfficePage.clickBackToBoxOfficeButton();
//
//		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
//	}
//
//	@Description("Checkout - Method: Card Manual - Status: Fail")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_044_StaffManual_014_CheckoutNowMethodByCardManuallyFail() {
//		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
//
//		boxOfficePage.clickToRadioButtonPaymentCheckout("Enter card manually");
//
//		boxOfficePage.getTextTotalAmountOrder();
//
//		boxOfficePage.clickButtonCheckout("Checkout now");
//
//		if ((boxOfficePage.getTextTotalAmountOrder()).equals("0$")) {
//			boxOfficePage.clickButtonPlaceOrder();
//
//			assertTrue(boxOfficePage.isSuccessOrderTextDisplayed());
//
//			boxOfficePage.clickBackToBoxOfficeButton();
//		} else {
//			boxOfficePage.switchToFrameIframe();
//			boxOfficePage.inputInfoCardManual("Card number",cardNumberInvalid);
//			boxOfficePage.switchToDefaultContent();
//
//			boxOfficePage.clickButtonPlaceOrder();
//
//			assertEquals(boxOfficePage.getErrorMessageChargeCard(),"Your card number is invalid.");
//
//			boxOfficePage.switchToFrameIframe();
//			boxOfficePage.inputInfoCardManual("Card number", cardNumberDeclined);
//			boxOfficePage.inputInfoCardManual("MM / YY", monthYearValid);
//			boxOfficePage.inputInfoCardManual("CVC", cvc);
//			boxOfficePage.inputInfoCardManual("ZIP", zip);
//
//			boxOfficePage.switchToDefaultContent();
//
//			boxOfficePage.clickButtonPlaceOrder();
//
//			assertEquals(boxOfficePage.getErrorMessageChargeCard(),"Your card number is incomplete.");
//
//			boxOfficePage.switchToFrameIframe();
//			boxOfficePage.inputInfoCardManual("Card number", cardNumberValid);
//			boxOfficePage.inputInfoCardManual("MM / YY", monthYearInvalid);
//
//			boxOfficePage.switchToDefaultContent();
//
//			boxOfficePage.clickButtonPlaceOrder();
//
//			assertEquals(boxOfficePage.getErrorMessageChargeCard(),"Your card's expiration year is in the past.");
//
//			boxOfficePage.clickButtonPlaceOrder();
//
//			assertEquals(boxOfficePage.getErrorMessageChargeCard(),"Your card number is incomplete.");
//
//			boxOfficePage.switchToFrameIframe();
//			boxOfficePage.inputInfoCardManual("Card number", cardNumberValid);
//			boxOfficePage.switchToDefaultContent();
//
//			boxOfficePage.clickButtonPlaceOrder();
//
//			assertEquals(boxOfficePage.getErrorMessageChargeCard(),"Your card's expiration date is incomplete.");
//
//			boxOfficePage.switchToFrameIframe();
//			boxOfficePage.inputInfoCardManual("Card number", cardNumberValid);
//			boxOfficePage.inputInfoCardManual("MM / YY", monthYearValid);
//
//			boxOfficePage.switchToDefaultContent();
//
//			boxOfficePage.clickButtonPlaceOrder();
//
//			assertEquals(boxOfficePage.getErrorMessageChargeCard(),"Your card's security code is incomplete.");
//
//			boxOfficePage.switchToFrameIframe();
//			boxOfficePage.inputInfoCardManual("Card number", cardNumberValid);
//			boxOfficePage.inputInfoCardManual("MM / YY", monthYearValid);
//			boxOfficePage.inputInfoCardManual("CVC", cvc);
//			boxOfficePage.switchToDefaultContent();
//
//			boxOfficePage.clickButtonPlaceOrder();
//
//			assertEquals(boxOfficePage.getErrorMessageChargeCard(),"Your postal code is incomplete.");
//
//
//			boxOfficePage.clickBackToTickets();
//		}
//		assertTrue(boxOfficePage.isOrderBoxOfficeTextDisplayed());
//	}
//
//	@Description("Add to cart")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TCs_045_StaffManual_015_AddToCart() {
//		boxOfficePage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
//
//		boxOfficePage.clickButtonCheckout("Add to cart");
//
//		boxOfficePage.clickToMoreMenuButton();
//		boxOfficePage.clickToValueOfMoreMennu("Log out");
//
//		assertTrue(boxOfficePage.isLoginButtonDisplayed());
//	}


	@AfterClass
	public void afterClass() {
//		driver.quit();
		closeBrowserDriver();
	}




}
