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

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage{
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


    public void linkOpen(String arg0){
        WebElement link=driver.findElement(By.partialLinkText(arg0));
        link.click();
    }
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
public void pageCheck(String arg0){
    String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
    String subWindowHandler = null;
    Set<String> handles = driver.getWindowHandles(); // get all window handles
    for(String child:handles) {
        if (!parentWindowHandler.equals(child))
            driver.switchTo().window(child);
    }
    driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
    String pageURL=driver.getCurrentUrl();
    System.out.println("URL is "+ pageURL);
    Assert.assertEquals(arg0,pageURL);
    //driver.close();
}

    public boolean userInHomePage() {
    return driver.getCurrentUrl().contains("http://demo.nopcommerce.com");
    }
}
