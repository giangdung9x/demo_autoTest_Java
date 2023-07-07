package factoryEnvironment;

import org.openqa.selenium.WebDriver;

import factoryBrowsers.BrowsersFactory;



public class CrossbrowserFactory implements EnvironmentFactory {
	public WebDriver driver;
	private String browserName;

	public CrossbrowserFactory(String browserName, String osName) {
		this.browserName = browserName;
	}

	public WebDriver createDriver() {
		
		return driver;
	}
}
