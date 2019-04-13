package tranxit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage{
   // public static WebDriver driver;
    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(how = How.ID,using = "Email" )
    public WebElement email;

    @FindBy(how = How.ID,using = "Password" )
    public WebElement password;

    @FindBy(how = How.XPATH,using = "//input[@value='Log in']")
    public WebElement submit;
    @FindBy(how = How.XPATH,using = "//a[@class='ico-login']")
    public WebElement login;
    @FindBy(how = How.TAG_NAME,using = "h1")
    public WebElement welcomeMessage;


    public void login(String mail,String pword){
        email.clear();
        email.sendKeys(mail);
        password.clear();
        password.sendKeys(pword);
        submit.click();
    }
    public void clickLogin() {
        login.click();
    }
    public Boolean welcomeMessage() {
        String message = welcomeMessage.getText();
        return message.contains("Welcome, Please Sign In!");
    }
        public Boolean registration(){
            WebElement registrationPageHeading=driver.findElement(By.tagName("h1"));
            return registrationPageHeading.getText().contains("Register");
        }
}
