package factoryBrowsers;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface BrowsersFactory {
	WebDriver getBrowserDriver() throws MalformedURLException;
}
