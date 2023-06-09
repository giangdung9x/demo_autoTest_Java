package commons;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseTest {
    protected String portalURL;
    
    protected final Log log;
	
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	
	@BeforeSuite
	public void initBeforeSuite() {
		deleteAllReport();
	}
	public WebDriver getDriverInstance() {
		return this.driver;
	}
	
	public WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	
	public WebDriver getBrowserDriver(String browserName, String portalURL) {
		switch (browserName){
		case "firefox": 
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDriver/geckodriver");
			driver = new FirefoxDriver();
			break;
		case "chrome": 
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDriver/chromedriver");
			driver = new ChromeDriver();			
			break;
		case "edge": 
			System.setProperty("webdriver.edge.driver", projectPath + "/browserDriver/msedgedriver");
			driver = new EdgeDriver();
			break;
		default:
			throw new IllegalArgumentException("Please enter the correct Browser name!");
		}
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		switch (portalURL) {
		case "homepage": 
			portalURL = GlobalConstants.PORTAL_PAGE_URL;
			break;
		case "publickiosk": 
			portalURL = GlobalConstants.PUBLIC_KIOSK_PAGE_URL;
			break;
		case "boxoffice": 
			portalURL = GlobalConstants.BOX_OFFICE_PAGE_URL;
			break;
		case "buyonline": 
			portalURL = GlobalConstants.BUY_ONLINE_URL;
			break;
		default:
			throw new RuntimeException("Invalid portal Url");
		}
		driver.get(UsernameandPassword(portalURL, "SS15243", "12345"));
		return driver;
	}
	
	public String UsernameandPassword (String url, String username, String password){
		String [] arrayurl = url.split("//");
		return arrayurl[0] + "//" + username +":"+ password + "@" + arrayurl[1];
	}
	
	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);

	}


	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}


	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
	public void deleteAllReport() {
		try {
			String pathFolderDownload = GlobalConstants.PROJECT_PATH + "/allure-json";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

}
