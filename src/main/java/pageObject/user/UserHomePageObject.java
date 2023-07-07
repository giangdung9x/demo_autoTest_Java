package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.user.BoxOfficePageUI;
import pageUIs.user.HomePageUI;
import pageUIs.user.RewardPageUI;

public class UserHomePageObject extends BasePage{

	private WebDriver driver;
	
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click to button Register")
	public UserRegisterVenuePageObject clickToRegisterLink() {
		waitForElementClickable(driver,HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterVenuePageObject(driver);
	}
	
	@Step("Click to button Login")
	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(driver,HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);		
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	@Step("Verify Calendar link is displayed")
	public boolean isCalendarLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.CALENDAR_LINK);
		return isElementDisplayed(driver, HomePageUI.CALENDAR_LINK);
	}
	
	@Step("Verify text Artist")
	public boolean isTextDisplayed() {
		waitForElementVisible(driver, HomePageUI.TEXT_ARTIST);
		return isElementDisplayed(driver, HomePageUI.TEXT_ARTIST);
	}

	@Step("Click to avatar user")
	public void clickToAvatarUser() {
		waitForElementClickable(driver,HomePageUI.AVATAR_USER);
		clickToElement(driver,HomePageUI.AVATAR_USER);
	}
	
	@Step("Click to button Log out")
	public void clickToButtonLogOut() {
		waitForElementClickable(driver,HomePageUI.LOGOUT_BUTTON);
		clickToElement(driver,HomePageUI.LOGOUT_BUTTON);
	}
	
	@Step("Verify text Box Office")
	public boolean isTextBoxOfficeDisplayed() {
		waitForElementVisible(driver, HomePageUI.TEXT_BOX_OFFICE);
		return isElementDisplayed(driver, HomePageUI.TEXT_BOX_OFFICE);
	}

	@Step("Click to button More Menu - Staff")
	public void clickMoreMenu() {
		waitForElementClickable(driver,HomePageUI.MORE_MENU_BUTTON);
		clickToElement(driver,HomePageUI.MORE_MENU_BUTTON);
	}
	
	@Step("Click to button Log Out - Staff")
	public void clickButtonLogOutStaff() {
		waitForElementClickable(driver,HomePageUI.LOGOUT_STAFF_BUTTON);
		clickToElement(driver,HomePageUI.LOGOUT_STAFF_BUTTON);
	}
	
	@Step("Verify text - Please choose an event that you want to work on:")
	public boolean isTextboxConcesssions() {
		waitForElementVisible(driver, HomePageUI.TEXT_CONCESSIONS);
		return isElementDisplayed(driver, HomePageUI.TEXT_CONCESSIONS);
	}

	@Step("Click to button Log Out - Concesssions")
	public void clickButtonLogOutConcesssions() {
		waitForElementClickable(driver,HomePageUI.LOGOUT_CONCESSIONS_BUTTON);
		clickToElement(driver,HomePageUI.LOGOUT_CONCESSIONS_BUTTON);
	}

	@Step("Alert Authen")
	public void authenAlert() {
		driver.get(UsernameandPassword(GlobalConstants.PORTAL_PAGE_URL, "SS15243", "12345"));
	}

	public String UsernameandPassword (String url, String username, String password){
		String [] arrayurl = url.split("//");
		return arrayurl[0] + "//" + username +":"+ password + "@" + arrayurl[1];
	}

	//LEFT MENU
	@Step("Click open Left Menu")
	public void clickShowLeftMenu() {
		waitForElementClickable(driver,BoxOfficePageUI.LEFT_MENU_BUTTON);
		clickToElement(driver, BoxOfficePageUI.LEFT_MENU_BUTTON);	
	}
	
	@Step("Click to items of Left Menu - {0}")
	public void clickToItemOfLeftMenu(String items) {
		waitForElementClickable(driver,HomePageUI.ITEMS_LEFT_MENU, items);
		clickToElement(driver, HomePageUI.ITEMS_LEFT_MENU, items);	
	}
	
	@Step("Click to items of List Ticketing - {0}")
	public void clickToItemOfListTicketing(String items) {
		waitForElementClickable(driver,HomePageUI.ITEMS_OF_LIST_TICKETING, items);
		clickToElement(driver, HomePageUI.ITEMS_OF_LIST_TICKETING, items);	
	}
}
