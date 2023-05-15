package showslinger_user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserRegisterVenuePageObject;

public class User_01_Register_Account_Venue extends BaseTest{
	private WebDriver driver;

	private String osName = System.getProperty("os.name");
	private String projectPath = System.getProperty("user.dir");
	private UserHomePageObject homePage  ;
	private UserRegisterVenuePageObject registerVenuePage;
	
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac OS")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDriver/geckodriver");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		}
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test 
	public void Register_00_Alert_Authen() {
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

		registerVenuePage = new UserRegisterVenuePageObject(driver);

		System.out.println("Register_01 - Step 02: Call form Register");
		WebElement element = driver.findElement(By.xpath("//a[@id='ss-logo']//img"));
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
		driver.findElement(By.xpath("//label[@for='radio-account_type-venue']")).click();

		System.out.println("Register_01 - Step 03: Click to Register button");
		registerVenuePage.clickToRegisterButton();

		System.out.println("Register_01 - Step 04: Verify error message displayed");
		Assert.assertEquals(registerVenuePage.getErrorMessageAtEmailTextbox(),"Please enter your email");
		Assert.assertEquals(registerVenuePage.getErrorMessageAtPasswordTextbox(),"Please enter your password");
		Assert.assertEquals(registerVenuePage.getErrorMessageAtConfirmPasswordTextbox(),"You must agree to the terms of service to continue");
	}

	@Test
	public void Register_02_Register_Invalid_Email() {
	}

	@Test
	public void Register_03_Register_Success() {

	}

	@Test
	public void Register_04_Register_Existing_Email() {

	}

	@Test
	public void Register_05_Register_Password_Less_Than_6_Chars() {

	}

	@Test
	public void Register_06_Register_Invalid_Confirm_Password() {


	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
