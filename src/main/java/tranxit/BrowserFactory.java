package tranxit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {

    public static WebDriver getBrowser(){

        System.setProperty("webdriver.chrome.driver","G:/driver/chromedriver");
        WebDriverManager.chromedriver().setup();

          final String USERNAME = "aravikumar7";
        final String ACCESS_KEY = "fba3dead-f784-4860-ae5a-5a9c54d44b84";
        final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com/wd/hub";
        WebDriver driver = null;
        String browserName = System.getProperty("BROWSER");
        System.out.println("browsername"+browserName);
        DesiredCapabilities capabilities;

        if(browserName.equalsIgnoreCase("chrome")){
            capabilities = DesiredCapabilities.chrome();
            //capabilities.setVersion("73.0");
        }
        else if(browserName.equalsIgnoreCase("Firefox")){
            capabilities = DesiredCapabilities.firefox();
        }
        else {
            capabilities = DesiredCapabilities.chrome();
        }
        try {
            driver = new RemoteWebDriver(new URL(URL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        capabilities.setCapability("platform","Linux");
        capabilities.setCapability("version","latest");
        capabilities.setCapability("name","Search Feature");
        return driver;
    }
}
