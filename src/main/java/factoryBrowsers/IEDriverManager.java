
package factoryBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.json.StaticInitializerCoercer;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.Architecture;

import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;
public class IEDriverManager implements BrowsersFactory {

	@Override
	public WebDriver getBrowserDriver() {

		if (!IS_OS_WINDOWS) {
			throw new BrowserNotSupportedException("lE is not supported on " +
			System.getProperty("os.name"));
		}
		WebDriverManager.iedriver().architecture(Architecture.X32).setup();
		InternetExplorerOptions options = new InternetExplorerOptions();
		return new InternetExplorerDriver(options);
	}

}
