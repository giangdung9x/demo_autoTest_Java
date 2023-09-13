package showslinger_user;

import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.user.UserRewardPageObject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.Random;
import static org.testng.Assert.assertFalse;

public class Class_010_Feature_Reward extends BaseTest{
	
	private UserRewardPageObject rewardPage;
	int randomNumber = generateFakeNumber();
	private String emailManager, passwordManager;	
	private String rewardName, startDate, endDate, longText, points, qty, negativeNumber, endDateInvalid, editRewardName;
	private String eventName, ticketName, quantityTicket, ticketNameValue, quantityTicketValue;
	private String fullName, phone, validEmail, cardNumberValid, monthYearValid,  cvc, zip;;
	

	@Parameters({ "envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName,
	@Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String
	portNumber,@Optional("Windows") String osName, @Optional("10") String osVersion) {
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
		rewardPage = new UserRewardPageObject(driver);
		
		emailManager ="paulv@showslinger.com";
		passwordManager = "12345";
		
		rewardName =  "Reward" + " "+ randomNumber;
		longText = generateLongText(201);
		points= "10";
		qty = "10";
		negativeNumber = "-1";
		startDate = "06-13-2023";
		endDate  = "06-13-2024";
		endDateInvalid = "06-12-2023";
		editRewardName = "Edit Reward" + " "+ randomNumber;
		
		eventName = "Giang Test 07";
		ticketName ="vip2";
		quantityTicket ="1";
		ticketNameValue ="vip3";
		quantityTicketValue ="2";
		
		fullName = "Dang Thi Giang";
		phone = "+12837929"+randomNumber;
		validEmail = "dangthigiang" +  randomNumber + "@yopmail.com";
		cardNumberValid = "4242424242424242";
		monthYearValid = "0424";
		cvc = "242";
		zip = "42424";
	}

	@Description("Login Account")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_001_Reward_OpenUrlAndLogin() {
		
		rewardPage.clickToLoginLink();

		rewardPage.loginAccount(emailManager,passwordManager);

		rewardPage.clickToLoginButton();
		rewardPage.clickShowLeftMenu();

		rewardPage.clickToItemOfLeftMenu("Marketing");

		rewardPage.clickToItemOfListTicketing("Rewards");
	}
	
	
	
	@Description("Create Reward - Fail")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_002_RewardList_001_CreateRewardFail() {
		rewardPage.clickToAddButton("Reward");
		verifyTrue(rewardPage.isTextNameOfPopupDisplayed("Create Reward"));

		rewardPage.clickToSaveButton();
		verifyEquals(rewardPage.getTextOfAlert(), "Validation failed: Title name can't be blank, Points must be a number, Quantity must be a number, Points can't be blank, " +
				"Quantity can't be blank, Points is not a number, Quantity is not a number, Start sales date can't be blank, End sales date can't be blank");
		rewardPage.clickToCloseAlertButton();


		rewardPage.inputToTextboxNamePopup("Name",rewardName);
		rewardPage.inputToTextboxPlaceholderPopup("Start date", startDate);
		rewardPage.inputToTextboxPlaceholderPopup("End date", endDateInvalid);
		rewardPage.sleepInSecond(1);
		rewardPage.inputToTextboxPlaceholderDescriptionPopup("Description",longText);
		rewardPage.inputToTextboxPlaceholderDescriptionPopup("How to redeem reward",longText);
		rewardPage.inputToTextboxNamePopup("Points",negativeNumber);
		rewardPage.inputToTextboxNamePopup("Qty",negativeNumber);
		rewardPage.clickToSaveButton();
		verifyEquals(rewardPage.getTextOfAlert(), "Validation failed: Points must be greater than or equal to 0, "
				+ "Quantity must be greater than or equal to 0, Description is too long (maximum is 200 characters), "
				+ "Redeem notes is too long (maximum is 200 characters), The end date can not before the start date, "
				+ "The end date can not before the current time");
		rewardPage.clickToCloseAlertButton();

		rewardPage.clickToClosePopupButton();


	}


	@Description("Create Reward - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_003_RewardList_002_CreateRewardSuccess() {
		rewardPage.refreshToPage(driver);
		rewardPage.clickToAddButton("Reward");
		verifyTrue(rewardPage.isTextNameOfPopupDisplayed("Create Reward"));

		rewardPage.inputToTextboxNamePopup("Name",rewardName);
		rewardPage.inputToTextboxPlaceholderPopup("Start date", startDate);
		rewardPage.inputToTextboxPlaceholderPopup("End date", endDate);
		rewardPage.sleepInSecond(1);
		rewardPage.inputToTextboxPlaceholderDescriptionPopup("Description",rewardName);
		rewardPage.inputToTextboxPlaceholderDescriptionPopup("How to redeem reward",rewardName);
		rewardPage.inputToTextboxNamePopup("Points",points);
		rewardPage.inputToTextboxNamePopup("Qty",qty);
		rewardPage.clickToSaveButton();
		verifyEquals(rewardPage.getTextOfAlert(), "1 Reward '" + rewardName + "' was created successfully"); ////div[@role='alert']
		verifyTrue(rewardPage.getNameOfGiftCard(rewardName));
		rewardPage.clickToCloseAlertButton();
		rewardPage.refreshToPage(driver);
	}

	@Description("Edit Reward - Fail")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_004_RewardList_003_EditRewardFail() {
		rewardPage.clickToActionButton(rewardName,"Edit");
		verifyTrue(rewardPage.isTextNameOfPopupDisplayed("Edit Reward"));

		rewardPage.inputToTextboxNamePopup("Name",editRewardName);
		rewardPage.inputToTextboxPlaceholderPopup("Start date", startDate);
		rewardPage.inputToTextboxPlaceholderPopup("End date", endDateInvalid);
		rewardPage.sleepInSecond(1);
		rewardPage.inputToTextboxPlaceholderDescriptionPopup("Description",longText);
		rewardPage.inputToTextboxPlaceholderDescriptionPopup("How to redeem reward",longText);
		rewardPage.inputToTextboxNamePopup("Points",negativeNumber);
		rewardPage.inputToTextboxNamePopup("Qty",negativeNumber);
		rewardPage.clickToSaveButton();
		verifyEquals(rewardPage.getTextOfAlert(), "Reward can not be update when run out of redeems.");
		rewardPage.clickToClosePopupButton();
		rewardPage.refreshToPage(driver);

	}

	@Description("Edit Reward - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_005_RewardList_004_EditRewardSuccess() {
		rewardPage.clickToActionButton(rewardName,"Edit");
		verifyTrue(rewardPage.isTextNameOfPopupDisplayed("Edit Reward"));
		rewardPage.inputToTextboxNamePopup("Name",editRewardName);
		rewardPage.inputToTextboxPlaceholderPopup("Start date", startDate);
		rewardPage.inputToTextboxPlaceholderPopup("End date", endDate);
		rewardPage.sleepInSecond(1);
		rewardPage.inputToTextboxPlaceholderDescriptionPopup("Description",rewardName);
		rewardPage.inputToTextboxPlaceholderDescriptionPopup("How to redeem reward",rewardName);
		rewardPage.inputToTextboxNamePopup("Points",points);
		rewardPage.inputToTextboxNamePopup("Qty",qty);
		rewardPage.clickToSaveButton();
		verifyTrue(rewardPage.getNameOfGiftCard(editRewardName));
		verifyEquals(rewardPage.getTextOfAlert(), "Reward '" + editRewardName + "' was updated successfully.");
		rewardPage.clickToCloseAlertButton();

		rewardPage.clickToActionButton(editRewardName,"Edit");
		rewardPage.inputToTextboxNamePopup("Name",rewardName);
		rewardPage.clickToSaveButton();
//		verifyTrue(rewardPage.getNameOfGiftCard(rewardName));
		verifyEquals(rewardPage.getTextOfAlert(), "Reward '" + rewardName + "' was updated successfully.");
		rewardPage.clickToCloseAlertButton();
		rewardPage.refreshToPage(driver);


	}


	@Description("Switch Status Reward - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_006_RewardList_006_SwitchStatusRewardSuccess() {
		rewardPage.clickToActionButton(rewardName,"Inactive");
		verifyEquals(rewardPage.getTextOfAlert(), "Deactivated the reward '" + rewardName + "' successfully.");
		rewardPage.refreshToPage(driver);
		rewardPage.clickToActionButton(rewardName,"Active");
		verifyEquals(rewardPage.getTextOfAlert(), "Activated the reward '" + rewardName + "' successfully.");
		rewardPage.refreshToPage(driver);

	}

	@Description("See Reward Page")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_007_RewardList_007_SeeRewardPage() {
		String rewardManagerPage = driver.getWindowHandle();
		rewardPage.clickToActionButton(rewardName,"See Rewards Page");
		rewardPage.switchToWindowByID(rewardManagerPage);

		rewardPage.clickToViewButtonOfReward(rewardName, "View");

		verifyEquals(rewardPage.getNameRewardOfPopup(rewardName), rewardName);

		String redeemRewardPage = driver.getWindowHandle();
		driver.close();
		rewardPage.switchToWindowByID(redeemRewardPage);
	}

	@Description("Switch Status Reward - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_008_RedeemReward_001_RedeemFail() {
		rewardPage.clickToItemOfLeftMenu("Calendar");
		rewardPage.clickToPrevButton();
		rewardPage.clickToEvent(eventName);
		String managerPage = driver.getWindowHandle();
		rewardPage.clickToLink("Preview");
		rewardPage.switchToWindowByID(managerPage);

		rewardPage.clickToDropDownSelectQuantityTicket(ticketName, quantityTicket);
		rewardPage.clickToAgreeCheckoutButton();

		rewardPage.inputInfoBuyerTextbox("Full Name", fullName);
		rewardPage.inputInfoBuyerTextbox("Phone", phone);
		rewardPage.inputInfoBuyerTextbox("Email", validEmail);
		rewardPage.inputInfoBuyerTextbox("Confirm Email", validEmail);

		rewardPage.clickCheckboxAcceptTermsService();

		rewardPage.getTextTotalAmountOrder();
		rewardPage.sleepInSecond(3);

		if ((rewardPage.getTextTotalAmountOrder()).equals("$0.00")) {
			rewardPage.clickPlaceOrderButton();
			assertTrue(rewardPage.isCheckoutSuccessTextDisplayed());
		} else {
			rewardPage.switchToFrameIframe();
			rewardPage.inputInfoCardManual("Card number", cardNumberValid);
			rewardPage.inputInfoCardManual("MM / YY", monthYearValid);
			rewardPage.inputInfoCardManual("CVC", cvc);
			rewardPage.inputInfoCardManual("ZIP", zip);
			rewardPage.switchToDefaultContent();

			rewardPage.clickPlaceOrderButton();
			assertTrue(rewardPage.isCheckoutSuccessTextDisplayed());
		}
		String buyOnlineSuccessWindowID = driver.getWindowHandle();
		rewardPage.clickRedeemRewardLink();
		driver.close();
		rewardPage.switchToWindowByID(buyOnlineSuccessWindowID);

		if (rewardPage.getPointOfUser()<rewardPage.getPointOfReward(rewardName)) {
			rewardPage.clickToViewButtonOfReward(rewardName, "Redeem");
		} else {
			rewardPage.clickToViewButtonOfReward(rewardName, "Redeem");
			rewardPage.clickToButtonRedeemReward(rewardName);
			verifyEquals(rewardPage.getTextOfSuccessMesaageRedeem(), "Redeemed the Reward '" + rewardName + "' successfully");
		}
		String redeemRewardPage = driver.getWindowHandle();
		driver.close();
		rewardPage.switchToWindowByID(redeemRewardPage);
	}


	@Description("Switch Status Reward - Success")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_009_RedeemReward_002_RedeemSuccess() {
		rewardPage.refreshToPage(driver);
		rewardPage.clickToItemOfLeftMenu("Calendar");
		rewardPage.clickToPrevButton();
		rewardPage.clickToEvent(eventName);
		String managerPage = driver.getWindowHandle();
		rewardPage.clickToLink("Preview");
		rewardPage.switchToWindowByID(managerPage);

		rewardPage.clickToDropDownSelectQuantityTicket(ticketNameValue, quantityTicketValue);
		rewardPage.clickToAgreeCheckoutButton();

		rewardPage.inputInfoBuyerTextbox("Full Name", fullName);
		rewardPage.inputInfoBuyerTextbox("Phone", phone);
		rewardPage.inputInfoBuyerTextbox("Email", validEmail);
		rewardPage.inputInfoBuyerTextbox("Confirm Email", validEmail);

		rewardPage.clickCheckboxAcceptTermsService();

		rewardPage.getTextTotalAmountOrder();
		rewardPage.sleepInSecond(3);

		if ((rewardPage.getTextTotalAmountOrder()).equals("$0.00")) {
			rewardPage.clickPlaceOrderButton();
			assertTrue(rewardPage.isCheckoutSuccessTextDisplayed());
		} else {
			rewardPage.switchToFrameIframe();
			rewardPage.inputInfoCardManual("Card number", cardNumberValid);
			rewardPage.inputInfoCardManual("MM / YY", monthYearValid);
			rewardPage.inputInfoCardManual("CVC", cvc);
			rewardPage.inputInfoCardManual("ZIP", zip);
			rewardPage.switchToDefaultContent();

			rewardPage.clickPlaceOrderButton();
			assertTrue(rewardPage.isCheckoutSuccessTextDisplayed());
		}
		rewardPage.sleepInSecond(3);
		String buyOnlineSuccessWindowID = driver.getWindowHandle();
		rewardPage.clickRedeemRewardLink();
		driver.close();
		rewardPage.switchToWindowByID(buyOnlineSuccessWindowID);
		if (rewardPage.getPointOfUser()<rewardPage.getPointOfReward(rewardName)) {
			rewardPage.clickToViewButtonOfReward(rewardName, "Redeem");
			rewardPage.getTextOfButtonRedeemDisable();
		} else {
			rewardPage.clickToViewButtonOfReward(rewardName, "Redeem");
			rewardPage.clickToButtonRedeemReward(rewardName);
			verifyEquals(rewardPage.getTextOfSuccessMesaageRedeem(), "Redeemed the Reward '" + rewardName + "' successfully");
		}
		String redeemRewardPage = driver.getWindowHandle();
		driver.close();
		rewardPage.switchToWindowByID(redeemRewardPage);
	}
	
	@Description("Open Tab Redeem List")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_010_RedeemList_001_OpenTabRedeemList() {
		rewardPage.refreshToPage(driver);
		//rewardPage.clickShowLeftMenu();
		rewardPage.clickToItemOfLeftMenu("Marketing");
		rewardPage.clickToItemOfListTicketing("Rewards");
		
		rewardPage.clickToSwitchTabOfReward("redeem_list");
	}
	
	@Description("Switch Status From Waiting")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_011_RedeemList_002_SwitchStatusFromWaiting() {
		rewardPage.selectRedeemCheckboxByTitle(rewardName);
		rewardPage.selectTextItemActionDropdown("Mark unredeemed");
		rewardPage.clickToRequestButton();
		verifyEquals(rewardPage.getAlertText(driver),"Make to unredeemed. Are you sure?");
		rewardPage.acceptAlert(driver);
		rewardPage.refreshToPage(driver);
		rewardPage.clickToSwitchTabOfReward("redeem_list");
		verifyEquals(rewardPage.getTextOfStatusRedeemItem(rewardName), "Unredeemed");
	}
	
	@Description("Switch Status From Unredeemed")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_012_RedeemList_003_SwitchStatusFromUnredeemed() {
		rewardPage.selectRedeemCheckboxByTitle(rewardName);
		rewardPage.selectTextItemActionDropdown("Mark redeemed");
		rewardPage.clickToRequestButton();
		verifyEquals(rewardPage.getAlertText(driver),"Make to redeemed. Are you sure?");
		rewardPage.acceptAlert(driver);
		rewardPage.refreshToPage(driver);
		rewardPage.clickToSwitchTabOfReward("redeem_list");
		verifyEquals(rewardPage.getTextOfStatusRedeemItem(rewardName), "Redeemed");
	}
	
	@Description("Switch Status From Redeemed")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_013_RedeemList_004_SwitchStatusFromRedeemed() {
		rewardPage.selectRedeemCheckboxByTitle(rewardName);
		rewardPage.selectTextItemActionDropdown("Refund points");
		rewardPage.clickToRequestButton();
		rewardPage.clickToActionButton("Refund");
		rewardPage.sleepInSecond(3);
		rewardPage.refreshToPage(driver);
		rewardPage.clickToSwitchTabOfReward("redeem_list");
		verifyEquals(rewardPage.getTextOfStatusRedeemItem(rewardName), "Refunded");
	}
	
	@Description("Switch Status From Refunded")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_014_RedeemList_005_SwitchStatusFromRefunded() {
		rewardPage.selectRedeemCheckboxByTitle(rewardName);
		rewardPage.selectTextItemActionDropdown("Void reward");
		rewardPage.clickToRequestButton();
		verifyEquals(rewardPage.getAlertText(driver),"Make to voided. Are you sure?");
		rewardPage.acceptAlert(driver);
		rewardPage.refreshToPage(driver);
		rewardPage.clickToSwitchTabOfReward("redeem_list");
		verifyEquals(rewardPage.getTextOfStatusRedeemItem(rewardName), "Voided");
	}
	
	@Description("Delete Reward From Void")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_015_RedeemList_006_SwitchStatusFromVoided() {
		rewardPage.selectRedeemCheckboxByTitle(rewardName);
		
		rewardPage.selectTextItemActionDropdown("Mark redeemed");
		rewardPage.clickToRequestButton();
		verifyEquals(rewardPage.getAlertText(driver),"You can not redeemed reward that have been voided.");
		rewardPage.acceptAlert(driver);
		verifyEquals(rewardPage.getTextOfStatusRedeemItem(rewardName), "Voided");
		
		rewardPage.selectTextItemActionDropdown("Mark unredeemed");
		rewardPage.clickToRequestButton();
		verifyEquals(rewardPage.getAlertText(driver),"You can not unredeemed reward that have been voided.");
		rewardPage.acceptAlert(driver);
		verifyEquals(rewardPage.getTextOfStatusRedeemItem(rewardName), "Voided");
		
		rewardPage.selectTextItemActionDropdown("Refund points");
		rewardPage.clickToRequestButton();
		verifyEquals(rewardPage.getAlertText(driver),"You can not refund reward that have been voided.");
		rewardPage.acceptAlert(driver);
		verifyEquals(rewardPage.getTextOfStatusRedeemItem(rewardName), "Voided");
	}
	
	@Description("Delete Reward")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_016_RedeemList_007_SwitchStatusFail() {
		rewardPage.refreshToPage(driver);
		rewardPage.clickToSwitchTabOfReward("redeem_list");
		
		rewardPage.selectTextItemActionDropdown("Mark redeemed");
		rewardPage.clickToRequestButton();
		verifyEquals(rewardPage.getAlertText(driver),"Please select at least one item before submitting action");
		rewardPage.acceptAlert(driver);
		
		rewardPage.selectTextItemActionDropdown("Mark unredeemed");
		rewardPage.clickToRequestButton();
		verifyEquals(rewardPage.getAlertText(driver),"Please select at least one item before submitting action");
		rewardPage.acceptAlert(driver);
		
		rewardPage.selectTextItemActionDropdown("Refund points");
		rewardPage.clickToRequestButton();
		verifyEquals(rewardPage.getAlertText(driver),"Please select at least one item before submitting action");
		rewardPage.acceptAlert(driver);
		
		rewardPage.selectTextItemActionDropdown("Void reward");
		rewardPage.clickToRequestButton();
		verifyEquals(rewardPage.getAlertText(driver),"Please select at least one item before submitting action");
		rewardPage.acceptAlert(driver);
	}
	
	@Description("Delete Reward")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TCs_017_RewardList_007_DeleteReward() {
		rewardPage.refreshToPage(driver);
		
		rewardPage.clickToActionButton(rewardName,"Delete");
		rewardPage.acceptAlert(driver);
		verifyEquals(rewardPage.getTextOfAlert(), "Reward '" + rewardName + "' was deleted successfully.");
	}
	
	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	
	public static String generateLongText(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        return sb.toString();
    }
	
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}

