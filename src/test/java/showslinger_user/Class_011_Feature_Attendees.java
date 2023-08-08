package showslinger_user;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.user.UserAttendeePageObject;

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
public class Class_011_Feature_Attendees extends BaseTest{
	private UserAttendeePageObject attendeePage;
	private String emailManager, passwordManager;
	private String eventName;


	@Parameters({ "envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName,
	@Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String
	portNumber,@Optional("Windows") String osName, @Optional("10") String osVersion) {
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
		attendeePage = new UserAttendeePageObject(driver);

		emailManager ="paulv@showslinger.com";
		passwordManager = "12345";

		eventName = "Giang Test auto-Mon,Jul  3,1 PM";
	}

	@Description("Open url and open Attendee page")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void Attendee_001_OpenUrl() {
		attendeePage.clickToLoginLink();
		attendeePage.loginAccount(emailManager,passwordManager);
		attendeePage.clickToLoginButton();
		attendeePage.clickShowLeftMenu();
		attendeePage.clickToItemOfLeftMenu("Ticketing");
		attendeePage.clickToItemOfListTicketing("Attendees");
		verifyTrue(attendeePage.isTextNameOfScreenDisplayed("Attendees"));
		
		attendeePage.clickToActionButton();
		verifyEquals(attendeePage.getAlertText(driver),"Please select at least one item before submitting action");
		attendeePage.acceptAlert(driver);
		verifyEquals(attendeePage.getAlertText(driver),"Please select at least one order");
		attendeePage.acceptAlert(driver);
	}

	@Description("Transfer Order has status Complete is Fail")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void Transfer_001_TransferOrderComplete_Fail() {
		attendeePage.selectTextItemFiterByStatusDropdown("Complete");
		attendeePage.selectOrderFirstCheckbox("1");
		attendeePage.selectOrderFirstCheckbox("2");
		attendeePage.selectTextItemActionDropdown("Transfer order");
		attendeePage.clickToActionButton();
		verifyEquals(attendeePage.getAlertText(driver),"You can only transfer ticket from ONE order at a time.");
		attendeePage.acceptAlert(driver);
	}

	@Description("Transfer Order has status Pending is Fail")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3)
	public void Transfer_002_TransferOrderPending_Fail() {


	}

	@Description("Transfer Order has status Refund is Fail")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 4)
	public void Transfer_003_TransferOrderRefund_Fail() {
		attendeePage.selectTextItemFiterByStatusDropdown("Refund");
		attendeePage.selectOrderFirstCheckbox("1");
		attendeePage.selectTextItemActionDropdown("Transfer order");
		attendeePage.clickToActionButton();
		verifyEquals(attendeePage.getAlertText(driver),"You can't transfer an order that has been refunded or transferred");
		attendeePage.acceptAlert(driver);
	}

	@Description("Transfer Order has status Partial Refund is Fail")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 5)
	public void Transfer_004_TransferOrderPartialRefund_Fail() {
		attendeePage.selectTextItemFiterByStatusDropdown("Partial refund");
		attendeePage.selectOrderFirstCheckbox("1");
		attendeePage.selectTextItemActionDropdown("Transfer order");
		attendeePage.clickToActionButton();
		verifyEquals(attendeePage.getAlertText(driver),"You can't transfer an order that has been refunded or transferred");
		attendeePage.acceptAlert(driver);
	}

	@Description("Transfer Order has status Void is Fail")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 6)
	public void Transfer_005_TransferOrderVoid_Fail() {
		attendeePage.selectTextItemFiterByStatusDropdown("Voided");
		attendeePage.selectOrderFirstCheckbox("1");
		attendeePage.selectTextItemActionDropdown("Transfer order");
		attendeePage.clickToActionButton();
		verifyEquals(attendeePage.getAlertText(driver),"You can't transfer an order that has been refunded or transferred");
		attendeePage.acceptAlert(driver);
	}

	@Description("Transfer Order has status Transferred is Fail")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 7)
	public void Transfer_006_TransferOrderTransferred_Fail() {
		attendeePage.selectTextItemFiterByStatusDropdown("Transferred");
		attendeePage.selectOrderFirstCheckbox("1");
		attendeePage.selectTextItemActionDropdown("Transfer order");
		attendeePage.clickToActionButton();
		verifyEquals(attendeePage.getAlertText(driver),"You can't transfer an order that has been refunded or transferred");
		attendeePage.acceptAlert(driver);
	}



	@Description("Transfer Order has status Complete is Success")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 8)
	public void Transfer_007_TransferOrderComplete_Success() {
		attendeePage.selectTextItemFiterByStatusDropdown("Complete");
		attendeePage.selectOrderFirstCheckbox("1");
		attendeePage.selectTextItemActionDropdown("Transfer order");
		attendeePage.clickToActionButton();
		verifyEquals(attendeePage.getNameOfPopup("Transfer"), "Transfer");

		attendeePage.selectQuantityTicketOfCurrentEventDropdown("1");
		attendeePage.selectEventTransferToDropdown(eventName);
		attendeePage.selectQuantityTicketOfTransferEventDropdown("1");
		attendeePage.clickToTransferButton();
		if (attendeePage.isAlertPresent(driver)) {
			attendeePage.acceptAlert(driver);
			verifyEquals(attendeePage.getMessageTranferRessult(), "Transfer successful!");
		} else {
			verifyEquals(attendeePage.getMessageTranferRessult(), "Transfer successful!");
		}

	}

	@Description("Refund Order is Success")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 9)
	public void Refund_001_RefundOrderSuccess() {
		attendeePage.refreshToPage(driver);
		attendeePage.selectTextItemFiterByStatusDropdown("Complete");
		attendeePage.searchOrder("Online");
		attendeePage.selectOrderFirstCheckbox("1");
		attendeePage.selectTextItemActionDropdown("Refund");
		attendeePage.clickToActionButton();
		verifyEquals(attendeePage.getNameOfPopup("Refund"), "Refund");
		attendeePage.clickToTransferButton("Refund");
		attendeePage.sleepInSecond(1);
		verifyEquals(attendeePage.getMessageRefundRessult(), "Refund ticket successfully!");
	}



	@Description("Refund Order is Fail")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 10)
	public void Refund_001_PartialRefundOrder_Fail() {
		attendeePage.refreshToPage(driver);
		attendeePage.selectTextItemFiterByStatusDropdown("Complete");
		attendeePage.searchOrder("Online");
		attendeePage.selectOrderFirstCheckbox("1");
		attendeePage.selectOrderFirstCheckbox("2");
		attendeePage.selectTextItemActionDropdown("Partial refund");
		attendeePage.clickToActionButton();
		attendeePage.sleepInSecond(1);
		verifyEquals(attendeePage.getAlertText(driver),"You can only partial refund from ONE order at a time.");
		attendeePage.acceptAlert(driver);
	}

	@Description("Partial Refund Order is Fail")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 11)
	public void Refund_002_PartialRefundOrderRefund_Fail() {
		attendeePage.refreshToPage(driver);
		attendeePage.selectTextItemFiterByStatusDropdown("Complete");
		attendeePage.searchOrder("Comp");
		attendeePage.selectOrderFirstCheckbox("1");
		attendeePage.selectTextItemActionDropdown("Partial refund");
		attendeePage.clickToActionButton();
		verifyEquals(attendeePage.getNameOfPopup("Partial Refund"), "Partial Refund");
		verifyEquals(attendeePage.getMessageOfPopup(), "This order is not valid to refund!");
	}



	@Description("Partial Refund Order is Success")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 12)
	public void Refund_003_PartialRefundOrder_Success() {
		attendeePage.refreshToPage(driver);
		attendeePage.selectTextItemFiterByStatusDropdown("Complete");
		attendeePage.searchOrder("Online");
		attendeePage.selectOrderFirstCheckbox("1");
		attendeePage.selectTextItemActionDropdown("Partial refund");
		attendeePage.clickToActionButton();
		verifyEquals(attendeePage.getNameOfPopup("Partial Refund"), "Partial Refund");
		//attendeePage.sleepInSecond(1);
		//verifyEquals(attendeePage.getMessageOfPopup(), "This order is not valid to refund!");
		attendeePage.selectQuantityTicketPartialRefund("1");
		attendeePage.clickToTransferButton("Refund");
		attendeePage.sleepInSecond(1);
		verifyEquals(attendeePage.getMessageRefundRessult(), "Partial refund ticket successfully!");

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

