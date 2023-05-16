package commons;

import org.openqa.selenium.WebDriver;

import pageObject.admin.AdminDashboardPageObject;
import pageObject.admin.AdminLoginPageObject;
import pageObject.user.UserForgotPasswordObject;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;
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
	
	/*public static UserCustomerInfoPageObject getUserCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPageObject(driver);
	}

	public static UserAddressPageObject getUserAddressPage(WebDriver driver) {
		return new UserAddressPageObject(driver);
	}

	public static UserRewardPointPageObject getUserRewardPointPage(WebDriver driver) {
		return new UserRewardPointPageObject(driver);
	}

	public static UserMyProductReviewPageObject getUserMyProductReviewPage(WebDriver driver) {
		return new UserMyProductReviewPageObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}*/
	
	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}

	public static UserForgotPasswordObject getUserForgotPasswordPage(WebDriver driver) {
		return new UserForgotPasswordObject(driver);
	}

}
