package factoryEnvironment;

import org.openqa.selenium.WebDriver;

import factoryBrowsers.BrowserList;
import factoryBrowsers.BrowserNotSupportedException;
import factoryBrowsers.ChromeDriverManager;
import factoryBrowsers.EdgeDriverManager;
import factoryBrowsers.FirefoxDriverManager;
import factoryBrowsers.HeadlessChromeDriverManager;
import factoryBrowsers.HeadlessFirefoxDriverManager;
import factoryBrowsers.IEDriverManager;
import factoryBrowsers.OperaDriverManager;
import factoryBrowsers.SafariDriverManager;

public class LocalFactory  implements EnvironmentFactory{
	public WebDriver driver;
	private String browserName;

	public LocalFactory(String browserName) {
		this.browserName = browserName;
	}

	public WebDriver createDriver() {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		switch (browser) {
		case FIREFOX :
			driver = new FirefoxDriverManager().getBrowserDriver();
			break;
		case CHROME :
			driver = new ChromeDriverManager().getBrowserDriver();
			break;
		case OPERA :
			driver = new OperaDriverManager().getBrowserDriver();
			break;
		case EDGE_CHROMIUM :
			driver = new EdgeDriverManager().getBrowserDriver();
			break;
		case IE :
			driver = new IEDriverManager().getBrowserDriver();
			break;
		case SAFARI :
			driver = new SafariDriverManager().getBrowserDriver();
			break;
		case H_CHROME :
			driver = new HeadlessChromeDriverManager().getBrowserDriver();
			break;
		case H_FIREFOX :
			driver = new HeadlessFirefoxDriverManager().getBrowserDriver();
			break;
		default :
			throw new BrowserNotSupportedException(browserName);
		}
		return driver;
	}
}
