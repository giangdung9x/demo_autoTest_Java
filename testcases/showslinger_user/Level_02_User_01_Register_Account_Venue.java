package showslinger_user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.GlobalConstants;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserRegisterVenuePageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_02_User_01_Register_Account_Venue extends BaseTest{
	private WebDriver driver;
	private	String firstName, lastName, emailAddress, password, confirmPassword;
	
	private String osName = System.getProperty("os.name");
	private String projectPath = System.getProperty("user.dir");
	private UserHomePageObject homePage  ;
	private UserRegisterVenuePageObject registerVenuePage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName){
		driver = getBrowserDriver(browserName);
		firstName ="Dang"; 
		lastName ="Giang"; 
		password ="123456"; 
		emailAddress = "dtg" + generateFakeNumber() + "@mail.com";

	}
	
	
	@Test
	public void TC_00_Authentication_Alert() {
		driver.get(UsernameandPassword("https://showslinger-staging.herokuapp.com/", "SS15243", "12345"));
		Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Artists']")).isDisplayed());
	}
	
	public String UsernameandPassword (String url, String username, String password){
		String [] arrayurl = url.split("//");
		return arrayurl[0] + "//" + username +":"+ password + "@" + arrayurl[1];
		}

	@Test
	public void Register_01_Register_Empty_Data() {
		System.out.println("Register_01 - Step 01: Click to Register link");
		driver.findElement(By.xpath("//li[@id='nav-menu-item-15651']//a")).click();

		//Click Register link -> nhảy qua trang Register
		registerVenuePage = new UserRegisterVenuePageObject(driver);
		
		//Call form register 
		WebElement element = driver.findElement(By.xpath("//a[@id='ss-logo']//img"));
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
		
		driver.findElement(By.xpath("//label[@for='radio-account_type-venue']")).click();


		System.out.println("Register_01 - Step 02: Click to Register button");
		registerVenuePage.clickToRegisterButton();
		
		System.out.println("Register_01 - Step 03: Verify error message displayed");
		Assert.assertEquals(registerVenuePage.getErrorMessageAtEmailTextbox(),"Please enter your email");
		Assert.assertEquals(registerVenuePage.getErrorMessageAtPasswordTextbox(),"Please enter your password");
		Assert.assertEquals(registerVenuePage.getErrorMessageAtConfirmPasswordTextbox(),"You must agree to the terms of service to continue");
	}


	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);

	}

	@AfterClass //Custom close browser/driver
	public void afterClass() {
		driver.quit();
	}
	
	

}
