package showslinger_user;

import commons.BaseTest;
import commons.GlobalConstants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.user.UserForgotPasswordObject;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;
import pageObject.user.UserRegisterVenuePageObject;

import java.util.concurrent.TimeUnit;

public class User_05_Public_Kiosk extends BaseTest{
	private String existingEmail;
	
	private String osName = System.getProperty("os.name");
	private String projectPath = System.getProperty("user.dir");
	
	
	@Parameters({"browser", "portalURL"})
	@BeforeClass
	public void beforeClass(String browserName, String portalURL) {
		driver = getBrowserDriver(browserName, portalURL);
	}

	@Test
	public void Kiosk_01_Empty_Data() {
		

		
	}
	
	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }



}
