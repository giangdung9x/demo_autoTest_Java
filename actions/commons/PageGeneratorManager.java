package commons;

import org.openqa.selenium.WebDriver;
import pageObject.user.UserActionOfEventPageObject;
import pageObject.user.UserBoxOfficePageObject;
import pageObject.user.UserBuyOnlinePageObject;
import pageObject.user.UserCouponPageObject;
import pageObject.user.UserForgotPasswordObject;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;
import pageObject.user.UserPublicKioskObject;
import pageObject.user.UserRegisterVenuePageObject;

public class PageGeneratorManager {
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	
	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	
	public static UserRegisterVenuePageObject getUserRegisterVenuePageObject(WebDriver driver) {
		return new UserRegisterVenuePageObject(driver);
	}
	

	public static UserForgotPasswordObject getUserForgotPasswordPage(WebDriver driver) {
		return new UserForgotPasswordObject(driver);
	}

	public static UserPublicKioskObject getUserPublicKioskPage(WebDriver driver) {
		return new UserPublicKioskObject(driver);
	}
	
	public static UserBoxOfficePageObject getUserBoxOfficePage(WebDriver driver) {
		return new UserBoxOfficePageObject(driver);
	}
	
	public static UserBuyOnlinePageObject getUserBuyOnlinePageObject(WebDriver driver) {
		return new UserBuyOnlinePageObject(driver);
	}
	
	public static UserActionOfEventPageObject getUserActionOfEventPageObject(WebDriver driver) {
		return new UserActionOfEventPageObject(driver);
	}
	
	public static UserCouponPageObject getUserCouponPageObject(WebDriver driver) {
		return new UserCouponPageObject(driver);
	}
}

