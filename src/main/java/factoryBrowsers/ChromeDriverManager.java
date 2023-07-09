package factoryBrowsers;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;

public class ChromeDriverManager implements BrowsersFactory{
    @Override
    public WebDriver getBrowserDriver() {
//        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.addArguments("--disable-notifications");
        options.addArguments("--disbale-geolocation");

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popup", 0);
        chromePrefs.put("download.default_directory", GlobalConstants.DOWNLOAD_FILE_FOLDER);
        options.setExperimentalOption("prefs", chromePrefs);
        try {
            new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"),options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return new ChromeDriver(options);
    }
}