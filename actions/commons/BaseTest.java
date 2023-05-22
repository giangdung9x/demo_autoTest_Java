package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

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

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseTest {
    protected String portalURL;
    
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

}
