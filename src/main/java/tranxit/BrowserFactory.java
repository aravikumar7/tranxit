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
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        return driver;

    }

}
