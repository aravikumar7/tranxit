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
    //Jenkins - http://localhost:8084/
    //java -jar selenium-server-standalone-3.141.59.jar -role hub
    //java -jar selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.0.3:4444/grid/register -browser browserName=chrome

        System.setProperty("webdriver.chrome.driver","G:/driver/chromedriver");
        WebDriverManager.chromedriver().setup();

          final String USERNAME = "aravikumar7";
        final String ACCESS_KEY = "fba3dead-f784-4860-ae5a-5a9c54d44b84";
        final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com/wd/hub";
        WebDriver driver = null;
        //String browserName = System.getProperty("BROWSER");
        String browserName="chrome";
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
        return driver;
    }
}
