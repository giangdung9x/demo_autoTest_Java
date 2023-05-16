package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.HomePageUI;
import pageUIs.user.RegisterPageUI;

public class UserHomePageObject extends BasePage{

	private WebDriver driver;
	
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterVenuePageObject clickToRegisterLink() {
		waitForElementClickable(driver,HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterVenuePageObject(driver);
	}
	
	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(driver,HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);		
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public boolean isCalendarLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.CALENDAR_LINK);
		return isElementDisplayed(driver, HomePageUI.CALENDAR_LINK);
	}
	
	public boolean isTextDisplayed() {
		waitForElementVisible(driver, HomePageUI.TEXT_ARTIST);
		return isElementDisplayed(driver, HomePageUI.TEXT_ARTIST);
	}

}
