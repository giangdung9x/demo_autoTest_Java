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
	private static double baseTicketPrice, overageFee, showSlingerFee, creditCardProcessingFeeEstimate, subtotal;
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
		dataClass16.baseFeeSS = Integer.parseInt(verifyAmountPage.getValueFees("Showslinger Base Fee (ex: $1)"));
		dataClass16.perFeeSS= Integer.parseInt(verifyAmountPage.getValueFees("Showslinger Percentage Fee (ex: 0.03)"));
		dataClass16.baseFeeSSCash = Integer.parseInt(verifyAmountPage.getValueFees("Showslinger Base Fee Cash (ex: $1)"));
		dataClass16.perFeeSSCash = Integer.parseInt(verifyAmountPage.getValueFees("Showslinger Percentage Fee Cash (ex: 0.03)"));

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

		if ((verifyAmountPage.getTextTotalAmountOrder()).equals("0$")) {
			verifyAmountPage.clickPlaceOrderButton();
			assertTrue(verifyAmountPage.isCheckoutSuccessTextDisplayed());

			String PageOrder = driver.getWindowHandle();
			driver.close();
			verifyAmountPage.switchToWindowByID(PageOrder);

		} else {
			orderTotalAmount = Double.parseDouble(verifyAmountPage.getTextTotalAmountOrder().replace("$", ""));

			intPrice = Integer.parseInt(dataClass16.price);
			intQuantity = Integer.parseInt(dataClass16.quantity);

			//Caculation total amount of order - Exclude Overage fee
			baseTicketPrice = intQuantity*intPrice;
			overageFee = 0;
			showSlingerFee = ((intQuantity*dataClass16.baseFeeSS)+baseTicketPrice*dataClass16.perFeeSS);
			creditCardProcessingFeeEstimate = (dataClass16.onlineFixedFee + dataClass16.onlinePercentageFee*(baseTicketPrice+overageFee+showSlingerFee))/(1-dataClass16.onlinePercentageFee);

			actualTotalAmount = Double.parseDouble(df.format(baseTicketPrice + overageFee+ showSlingerFee+creditCardProcessingFeeEstimate));

			if (orderTotalAmount == actualTotalAmount) {
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


	
	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(999);
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
//		driver.quit();
	}
}

