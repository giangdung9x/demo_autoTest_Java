package showslinger_user;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.user.UserReportPageObject;

import org.openqa.selenium.interactions.Actions;
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
public class Feature_Report extends BaseTest{
	private UserReportPageObject reportPage;
	private String emailManager, passwordManager;
	private String eventName;


	@Parameters({ "envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName,
	@Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String
	portNumber,@Optional("Windows") String osName, @Optional("10") String osVersion) {
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
		reportPage = new UserReportPageObject(driver);

		emailManager ="paulv@showslinger.com";
		passwordManager = "12345";

		eventName = "Giang Test auto";
	}

	@Description("Login Account")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void ListReport_001_OpenUrl() {
		reportPage.clickToLoginLink();
		reportPage.loginAccount(emailManager,passwordManager);
		reportPage.clickToLoginButton();
		reportPage.clickShowLeftMenu();
		reportPage.clickToItemOfLeftMenu("Ticketing");
		reportPage.clickToItemOfListTicketing("Reports");
		verifyTrue(reportPage.isTextNameOfScreenDisplayed("Event Reports"));
	}

	@Description("List Report- Search Event")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void ListReport_002_SearchEvent() {
		reportPage.searchEventName(eventName);
		reportPage.clickToActionMenuOfEvent(eventName, "Settlement report");
	}

	@Description("Settlement Report -Check Value Overview")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3)
	public void SettlementReport_001_CheckValueOverview() {
		reportPage.compareValues(
				reportPage.getValueOfTagOverview("Overview", "Online"), 
				reportPage.getValueOfTag("Volume", "Online sales", "2"));

		reportPage.compareValues(
				reportPage.getValueOfTagOverview("Overview", "Cash"), 
				reportPage.getValueOfTag("Volume", "Cash sales", "2"));

		reportPage.compareValues(
				reportPage.getValueOfTagOverview("Overview", "Coupons"), 
				reportPage.getValueOfTag("Summary", "Coupons", "2"));

		reportPage.compareValues(
				reportPage.getValueOfTagOverview("Overview", "Donations"), 
				reportPage.getValueOfTag("Volume", "Donations", "2"));

		reportPage.compareValues(
				reportPage.getValueOfTagOverview("Overview", "Overage"), 
				reportPage.getValueOfTag("Volume", "Overage", "2"));

		reportPage.compareValues(
				reportPage.getValueOfTagOverview("Overview", "Tax"), 
				reportPage.getValueOfTag("Volume", "Tax", "2"));

		reportPage.compareValues(
				reportPage.getValueOfTagOverview("Overview", "Tickets"), 
				reportPage.getValueTotalOfTag("Tickets", "Total", "2"));

		reportPage.compareValues(
				reportPage.getValueOfTagOverview("Overview", "Add-ons"), 
				reportPage.getValueTotalOfTag("Add-ons", "Total", "2"));

		double summaryScaned = 	reportPage.getValueOfTag("Summary", "Scanned tickets", "2") 
				+ reportPage.getValueOfTag("Summary", "Scanned add-ons", "2");
		reportPage.compareValues(reportPage.getValueOfTagOverview("Overview", "Scanned"), summaryScaned);

		reportPage.compareValues(
				reportPage.getValueOfTagOverview("Overview", "Total Sales"), 
				reportPage.getValueTotalOfTag("Volume", "TOTAL", "2"));
	}

	@Description("Settlement Report - Check Value Summary")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 4)
	public void SettlementReport_002_CheckValueSummary() {
		double totalTickets = reportPage.getValueOfTag("Summary", "Tickets", "3")
				+ reportPage.getValueOfTag("Summary", "Tickets", "4")
				+ reportPage.getValueOfTag("Summary", "Tickets", "5")
				+ reportPage.getValueOfTag("Summary", "Tickets", "6");
		reportPage.compareValues(reportPage.getValueOfTag("Summary", "Tickets", "2"), totalTickets);

		
		double totalAddOns = reportPage.getValueOfTag("Summary", "Add-ons", "3")
				+ reportPage.getValueOfTag("Summary", "Add-ons", "4")
				+ reportPage.getValueOfTag("Summary", "Add-ons", "5")
				+ reportPage.getValueOfTag("Summary", "Add-ons", "6");
		reportPage.compareValues(reportPage.getValueOfTag("Summary", "Add-ons", "2"), totalAddOns);

	}

	@Description("Settlement Report - Check Value Online Sales")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 5)
	public void SettlementReport_003_CheckValueOnlineSales() {
		double totalFaceValuePre = reportPage.getValueOfTag("Online Sales", "Total Tickets (Online)", "2")
				+ reportPage.getValueOfTag("Online Sales", "Total Add-Ons (Online)", "2")
				+ reportPage.getValueOfTag("Online Sales", "Total Passes (Online)", "2");	
		reportPage.compareValues(reportPage.getValueTotalOfTag("Online Sales", "Total Online Sales", "2"), totalFaceValuePre);

		double totalFaceValueDay = reportPage.getValueOfTag("Online Sales", "Total Tickets (Online)", "3")
				+ reportPage.getValueOfTag("Online Sales", "Total Add-Ons (Online)", "3")
				+ reportPage.getValueOfTag("Online Sales", "Total Passes (Online)", "3");	
		reportPage.compareValues(reportPage.getValueTotalOfTag("Online Sales", "Total Online Sales", "3"), totalFaceValueDay);
		
		double totalRefunds = reportPage.getValueOfTag("Online Sales", "Total Tickets (Online)", "4")
				+ reportPage.getValueOfTag("Online Sales", "Total Add-Ons (Online)", "4")
				+ reportPage.getValueOfTag("Online Sales", "Total Passes (Online)", "4");	
		reportPage.compareValues(reportPage.getValueTotalOfTag("Online Sales", "Total Online Sales", "4"), totalRefunds);
		
		double totalTax = reportPage.getValueOfTag("Online Sales", "Total Tickets (Online)", "5")
				+ reportPage.getValueOfTag("Online Sales", "Total Add-Ons (Online)", "5")
				+ reportPage.getValueOfTag("Online Sales", "Total Passes (Online)", "5");	
		reportPage.compareValues(reportPage.getValueTotalOfTag("Online Sales", "Total Online Sales", "5"), totalTax);
		
		double totalOverage = reportPage.getValueOfTag("Online Sales", "Total Tickets (Online)", "6")
				+ reportPage.getValueOfTag("Online Sales", "Total Add-Ons (Online)", "6")
				+ reportPage.getValueOfTag("Online Sales", "Total Passes (Online)", "6");	
		reportPage.compareValues(reportPage.getValueTotalOfTag("Online Sales", "Total Online Sales", "6"), totalOverage);
		
		double totalSales = reportPage.getValueOfTag("Online Sales", "Total Tickets (Online)", "7")
				+ reportPage.getValueOfTag("Online Sales", "Total Add-Ons (Online)", "7")
				+ reportPage.getValueOfTag("Online Sales", "Total Passes (Online)", "7");	
		reportPage.compareValues(reportPage.getValueTotalOfTag("Online Sales", "Total Online Sales", "7"), totalSales);
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

