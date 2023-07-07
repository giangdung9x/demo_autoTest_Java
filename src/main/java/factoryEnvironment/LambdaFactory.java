package factoryEnvironment;

import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class LambdaFactory  implements EnvironmentFactory{
    private WebDriver driver;
    private String osName;
    private String browserName;

    public LambdaFactory(String os, String browserName) {
        this.osName = os;
        this.browserName = browserName;
    }

    public WebDriver createDriver(){
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("platformName", osName);
        capability.setCapability("browserName", browserName);
        capability.setCapability("browserVersion", "latest");
        capability.setCapability("video", true);
        capability.setCapability("visual", true);
        capability.setCapability("name",  "Run on " + osName + " | " + browserName);

        if (osName.contains("Windows")) {
            capability.setCapability("screenResolution", "1920x1080");
        } else {
            capability.setCapability("screenResolution", "2560x1440");
        }

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.LAMBDA_URL), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}