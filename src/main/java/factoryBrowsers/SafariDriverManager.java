package factoryBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;

public class SafariDriverManager implements BrowsersFactory {

	@Override
	public WebDriver getBrowserDriver() {

		if (!IS_OS_MAC) {
		throw new BrowserNotSupportedException("Safari is not supported on " +System.getProperty("os.name"));
		}

		SafariOptions options = new SafariOptions();
		return new SafariDriver(options);
	}

}

