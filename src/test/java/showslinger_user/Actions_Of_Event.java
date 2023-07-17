package showslinger_user;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.user.UserActionOfEventPageObject;

import org.testng.Assert;
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
public class Actions_Of_Event extends BaseTest{
	private UserActionOfEventPageObject eventPage;
	private String emailManager, passwordManager;
	private String dayStart, dayEnd, dayEndInValid,eventName,eventNameNew, dayStartAfter, dayEndAfter;
	private String fullName, phone, validEmail;
	private String cardNumberValid, monthYearValid, cvc, zip;
	private String ticketName, quantity;
	
	@Parameters({ "envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName,
	@Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String
	portNumber,@Optional("Windows") String osName, @Optional("10") String osVersion) {
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
		eventPage = new UserActionOfEventPageObject(driver);
		
		emailManager ="paulv@showslinger.com";
		passwordManager = "12345";
		dayStart = "16/06/2023";
		dayEnd = "30/06/2023";
		dayEndInValid = "12/06/2023";
		eventName = "Test" + " "+ dayStart +" "+generateFakeNumber();
		eventNameNew = "Test"+ " " +generateFakeNumber();

		dayStartAfter ="15/06/2023";
		dayEndAfter = "30/06/2023";
		
		fullName = "Dang Thi Giang";
		phone = "+128379292999";
		validEmail = "dangthigiang+2@mobilefolk.com";

		ticketName ="Vip 1";
		quantity ="1";
		
		cardNumberValid = "4242424242424242";
		monthYearValid = "0424";
		cvc = "242";
		zip = "42424";
	}

	@Description("Login Account")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void Ticket_OpenUrlAndLoginAccount() {
		
		eventPage.clickToLoginLink();

		eventPage.loginAccount(emailManager,passwordManager);

		eventPage.clickToLoginButton();
	}
	
	@Description("Create Ticket - Fail")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void CreateTicket_001_CreateTicketFail() {
		eventPage.clickToCreateTicketButton();
		
		assertTrue(eventPage.isNameOfPopupDisplayed("Create Ticket"));
		
		eventPage.clickToCommitButton("Create Ticket");
		assertEquals(eventPage.getErrorMessageAtFooterPopup(), "You must select a date and time before adding an act!");
		
		eventPage.inputValueTimesDay("Day start", dayStart);
		eventPage.inputValueTimesDay("Day end", dayEndInValid);
		eventPage.clickToCommitButton("Create Ticket");
		eventPage.clickToLink("Cancel");
		
		eventPage.clickToCreateTicketButton();
		eventPage.inputValueTimesDay("Day start", dayStart);
		eventPage.inputValueTimesDay("Day end", dayEnd);
	
		eventPage.clickToCommitButton("Create Ticket");
		assertEquals(eventPage.getErrorMessageAtFooterPopup(), "You must create at least 1 ticket level. Click the blue \"Add ticket\" button.");
		
		eventPage.clickToAddButton("Add Ticket");
		eventPage.clickToCommitButton("Create Ticket");
		eventPage.sleepInSecond(5);
		assertEquals(eventPage.getErrorMessageAtFooterPopup(), "Please create a ticket level by clicking \"Add ticket\". Add a name, quantity and price.");
		
		eventPage.enterToTextboxByRowNumberByColumnNameTicket("1", "Vip 1");
		eventPage.enterToTextboxByRowNumberByColumnName("Quantity available", "1", "100");
		eventPage.enterToTextboxAmountByRowNumberByColumnName("Online price", "1", "10");
		eventPage.enterToTextboxAmountByRowNumberByColumnName("Cash price(at the door)", "1", "10");
		eventPage.enterToTextboxAmountByRowNumberByColumnName("Day of price", "1", "10");
		
		eventPage.inputToTextboxMinMaxTicket("Minimum ticket", "0");
		eventPage.clickToCommitButton("Create Ticket");
		eventPage.sleepInSecond(5);
		assertEquals(eventPage.getErrorMessageAtFooterPopup(), "Minimum ticket should be greater than 0.");
		
		eventPage.inputToTextboxMinMaxTicket("Minimum ticket", "2");
		eventPage.inputToTextboxMinMaxTicket("Maximum ticket", "0");
		eventPage.clickToCommitButton("Create Ticket");
		eventPage.sleepInSecond(5);
		assertEquals(eventPage.getErrorMessageAtFooterPopup(), "Maximum ticket should be greater than 0.");
		
		eventPage.inputToTextboxMinMaxTicket("Maximum ticket", "1");
		eventPage.clickToCommitButton("Create Ticket");
		eventPage.sleepInSecond(5);
		assertEquals(eventPage.getErrorMessageAtFooterPopup(), "Maximum ticket should be equal or greater than Minimum ticket.");

	}
	
	
	@Description("Create Ticket - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3)
	public void CreateTicket_002_CreateTicketSuccess() {
		eventPage.inputToTextboxMinMaxTicket("Minimum ticket", "1");
		eventPage.inputToTextboxMinMaxTicket("Maximum ticket", "10");
		
		eventPage.inputToTextboxMinMaxTicket("Event Name", eventName);
		
		eventPage.clickToCheckboxOnSale();
		
		eventPage.clickToCommitButton("Create Ticket");
		
		assertTrue(eventPage.isNameOfEventAtCalendarDisplayed(eventName));


	}
	
	
	@Description("Edit Ticket - Fail")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 4)
	public void EditTicket_001_EditTicketFail() {
		eventPage.clickToEvent(eventName);
		
		assertTrue(eventPage.isNameOfPopupDisplayed("Edit Ticket"));

		eventPage.enterToTextboxByRowNumberByColumnNameTicket("1", " ");
		eventPage.enterToTextboxByRowNumberByColumnName("Quantity available", "1", " ");
		
		eventPage.clickToCommitButton("Save Ticket");

		assertEquals(eventPage.getErrorMessageAtFooterPopup(), "Please create a ticket level by clicking \"Add ticket\". Add a name, quantity and price.");

		eventPage.clickToLink("Cancel");
	}
	
	
	
	@Description("Edit Ticket - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 5)
	public void EditTicket_002_EditTicketSuccess() {
		eventPage.clickToEvent(eventName);

		assertTrue(eventPage.isNameOfPopupDisplayed("Edit Ticket"));
		eventPage.clickToAddButton("Add Ticket");
		
		eventPage.enterToTextboxByRowNumberByColumnNameTicket("2", "Vip 2");
		eventPage.enterToTextboxByRowNumberByColumnName("Quantity available", "1", "100");
		
		eventPage.clickToCommitButton("Save Ticket");
		
		assertTrue(eventPage.isNameOfEventAtCalendarDisplayed(eventName));
		
	}
	
	
	
	@Description("Copy Ticket - Fail")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 6)
	public void CopyTicket_001_CopyTicketFail() {
		eventPage.refreshToPage(driver);
		eventPage.clickToEvent(eventName);
		assertTrue(eventPage.isNameOfPopupDisplayed("Edit Ticket"));
		
		eventPage.clickToButtonFooter("Copy ticket");
		assertTrue(eventPage.isNameOfPopupDisplayed("Copy Ticket"));

		eventPage.clickToButtonFooter("cancel");

	}
	
	
	
	@Description("Copy Ticket - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 7)
	public void CopyTicket_002_CopyTicketSuccess() {
		eventPage.refreshToPage(driver);

		eventPage.clickToEvent(eventName);
		assertTrue(eventPage.isNameOfPopupDisplayed("Edit Ticket"));
		
		eventPage.clickToButtonFooter("Copy ticket");
		assertTrue(eventPage.isNameOfPopupDisplayed("Copy Ticket"));
		
		eventPage.inputValueTimesDay("Choose new day:", dayStart);
		
		eventPage.clickToUpdateButton("Copy");

		assertTrue(eventPage.isNameOfEventCopyAtCalendarDisplayed(eventName));

	}
	
	
	
	@Description("Transfer Ticket - Fail")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 8)
	public void TransferTicket_001_TransferTicketFail() {
		eventPage.refreshToPage(driver);

		eventPage.clickToEvent(eventName);
		assertTrue(eventPage.isNameOfPopupDisplayed("Edit Ticket"));
		
		eventPage.clickToButtonFooter("Transfer ticket");
		assertTrue(eventPage.isNameOfPopupDisplayed("Transfer Ticket"));
		
		eventPage.inputValueTimesDay("Day start", dayStart);
		eventPage.inputValueTimesDay("Day end", dayEndInValid);
		eventPage.clickToCommitButton("Transfer Ticket");
		
		eventPage.acceptAlert(driver);
		assertEquals(eventPage.getErrorMessageAtFooterPopupTransfer(), "Please choose an end date that is after the start date.");
		
		eventPage.clickToButtonFooter("cancel");

		
	}
	
	@Description("Transfer Ticket - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 9)
	public void TransferTicket_002_TransferTicketSuccess() {
		eventPage.refreshToPage(driver);
		eventPage.clickToEvent(eventName);
		assertTrue(eventPage.isNameOfPopupDisplayed("Edit Ticket"));
		
		eventPage.clickToButtonFooter("Transfer ticket");
		assertTrue(eventPage.isNameOfPopupDisplayed("Transfer Ticket"));
		
		eventPage.inputValueTimesDay("Day start", dayStartAfter);
		eventPage.inputValueTimesDay("Day end", dayEndAfter);
		
		eventPage.clickToCommitButton("Transfer Ticket");
		
		eventPage.acceptAlert(driver);
	}
	
	@Description("DeleteTicket - Fail")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 10)
	public void DeleteTicket_001_DeleteTicketFail() {
		eventPage.refreshToPage(driver);

		eventPage.clickToEventCopy(eventName);
		assertTrue(eventPage.isNameOfPopupDisplayed("Edit Ticket"));
		
		eventPage.clickToButtonFooter("Delete");
		assertTrue(eventPage.isNameOfPopupDisplayed("Delete Ticket?"));

		eventPage.clickClosePopupButton();
	}
	
	
	@Description("DeleteTicket - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 11)
	public void DeleteTicke_002_DeleteTicketSuccess() {
		eventPage.refreshToPage(driver);

		eventPage.clickToEventCopy(eventName);
		assertTrue(eventPage.isNameOfPopupDisplayed("Edit Ticket"));
		
		eventPage.clickToButtonFooter("Delete");
		assertTrue(eventPage.isNameOfPopupDisplayed("Delete Ticket?"));
		
		eventPage.clickToLink("Yes");
	}
	
	
	@Description("Cancel Refund Ticket - Refund Auto")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 12)
	public void CancelRefundTicket_001_CancelRefundAuto() {
		eventPage.refreshToPage(driver);

		eventPage.clickToEvent(eventName);
		assertTrue(eventPage.isNameOfPopupDisplayed("Edit Ticket"));
		
		String PageEvent = driver.getWindowHandle();
		eventPage.clickToLink("Preview");		
		eventPage.switchToWindowByID(PageEvent);

		eventPage.clickToDropDownSelectQuantityTicket(ticketName, quantity);
		eventPage.clickToAgreeCheckoutButton();
		
		eventPage.inputInfoBuyerTextbox("Full Name", fullName);
		eventPage.inputInfoBuyerTextbox("Phone", phone);
		eventPage.inputInfoBuyerTextbox("Email", validEmail);
		eventPage.inputInfoBuyerTextbox("Confirm Email", validEmail);

		eventPage.clickCheckboxAcceptTermsService();
		
		eventPage.getTextTotalAmountOrder();
		eventPage.sleepInSecond(3);
		
		if ((eventPage.getTextTotalAmountOrder()).equals("0$")) {
			eventPage.clickPlaceOrderButton();
			assertTrue(eventPage.isCheckoutSuccessTextDisplayed());

			String PageOrder = driver.getWindowHandle();
			driver.close();
			eventPage.switchToWindowByID(PageOrder);
			
		} else {

			eventPage.switchToFrameIframe();
			eventPage.inputInfoCardManual("Card number", cardNumberValid);
			eventPage.inputInfoCardManual("MM / YY", monthYearValid);
			eventPage.inputInfoCardManual("CVC", cvc);
			eventPage.inputInfoCardManual("ZIP", zip);
			eventPage.switchToDefaultContent();

			eventPage.clickPlaceOrderButton();
			
			assertTrue(eventPage.isCheckoutSuccessTextDisplayed());
						
			String PageOrder = driver.getWindowHandle();
			driver.close();
			eventPage.switchToWindowByID(PageOrder);
			
		}
		
		eventPage.clickToLink("Cancel");		

		eventPage.clickToEvent(eventName);
		
		eventPage.clickToButtonFooter("Cancel event/Refund tickets");

		eventPage.acceptAlert(driver);
		
		
		eventPage.clickToRadioButton("auto");
		
		eventPage.clickToRefundButton("Refund Tickets");
		
		eventPage.clickToRefundButton("Refund");
		
		eventPage.clickClosePopupButton();

	}
	
	
	
	@Description("Cancel Refund Ticket - Manual Auto")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 13)
	public void CancelRefundTicket_002_CancelRefundManual() {
		eventPage.refreshToPage(driver);

		
		eventPage.clickToCreateTicketButton();
		eventPage.inputValueTimesDay("Day start", dayStart);
		eventPage.inputValueTimesDay("Day end", dayEnd);
		eventPage.inputToTextboxMinMaxTicket("Event Name", eventNameNew);
		eventPage.clickToAddButton("Add Ticket");				
		eventPage.enterToTextboxByRowNumberByColumnNameTicket("1", "Vip 1");
		eventPage.enterToTextboxByRowNumberByColumnName("Quantity available", "1", "100");
		eventPage.enterToTextboxAmountByRowNumberByColumnName("Online price", "1", "10");
		eventPage.enterToTextboxAmountByRowNumberByColumnName("Cash price(at the door)", "1", "10");
		eventPage.enterToTextboxAmountByRowNumberByColumnName("Day of price", "1", "10");
		eventPage.clickToCheckboxOnSale();
		eventPage.clickToCommitButton("Create Ticket");
		eventPage.sleepInSecond(5);
		eventPage.refreshToPage(driver);

		eventPage.clickToEvent(eventNameNew);
		assertTrue(eventPage.isNameOfPopupDisplayed("Edit Ticket"));
		
		String PageEvent = driver.getWindowHandle();
		eventPage.clickToLink("Preview");		
		eventPage.switchToWindowByID(PageEvent);

		eventPage.clickToDropDownSelectQuantityTicket(ticketName, quantity);
		eventPage.clickToAgreeCheckoutButton();
		
		eventPage.inputInfoBuyerTextbox("Full Name", fullName);
		eventPage.inputInfoBuyerTextbox("Phone", phone);
		eventPage.inputInfoBuyerTextbox("Email", validEmail);
		eventPage.inputInfoBuyerTextbox("Confirm Email", validEmail);

		eventPage.clickCheckboxAcceptTermsService();
		
		eventPage.getTextTotalAmountOrder();
		eventPage.sleepInSecond(3);
		
		if ((eventPage.getTextTotalAmountOrder()).equals("0$")) {
			eventPage.clickPlaceOrderButton();
			assertTrue(eventPage.isCheckoutSuccessTextDisplayed());

			String PageOrder = driver.getWindowHandle();
			driver.close();
			eventPage.switchToWindowByID(PageOrder);
			
		} else {

			eventPage.switchToFrameIframe();
			eventPage.inputInfoCardManual("Card number", cardNumberValid);
			eventPage.inputInfoCardManual("MM / YY", monthYearValid);
			eventPage.inputInfoCardManual("CVC", cvc);
			eventPage.inputInfoCardManual("ZIP", zip);
			eventPage.switchToDefaultContent();

			eventPage.clickPlaceOrderButton();
			
			assertTrue(eventPage.isCheckoutSuccessTextDisplayed());
						
			String PageOrder = driver.getWindowHandle();
			driver.close();
			eventPage.switchToWindowByID(PageOrder);
			
		}
		
		eventPage.clickToLink("Cancel");		

		eventPage.clickToEvent(eventNameNew);
		
		eventPage.clickToButtonFooter("Cancel event/Refund tickets");

		eventPage.acceptAlert(driver);
		
		
		eventPage.clickToRadioButton("manual");
		
		eventPage.clickToRefundButton("Refund Tickets");
		
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

