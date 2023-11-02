package factoryBrowsers;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager implements BrowsersFactory{
    @Override
    public WebDriver getBrowserDriver() {
//        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();

        options.addPreference("browser.download.useDownloadDir", true);
        options.addPreference("browser.helperApps.neverAsk.saveToDisk",
                "multipart/x-zip,application/zip,application/x-zip-compressed,application/x-compressed,application/msword,application/csv,text/csv,image/png,image/jpeg, application/pdf, text/html, text/plain, application/excel, application/vnd.ms-excel, application/x-excel, application/x-msexcel, application/octet-stream");
        options.addPreference("pdfjs.disabled", true);

        options.setAcceptInsecureCerts(false);

        return new FirefoxDriver(options);

    }
}