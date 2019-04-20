package tranxitaction;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tranxit.BrowserFactory;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/"
        ,glue={"tranxit"},
        tags={"@AddToBasket"},
        plugin = {"pretty", "html:target/cucumber-htmlreport","json:target/cucumber-report.json"}
        )
public class cucumberFeaturefileTest {
    static WebDriver driver;

    @BeforeClass
    public static void beforeClassMethod(){
        driver = BrowserFactory.getBrowser();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void closeTheBrowser() {
        driver.close();
    }
    }
