/*
package tranxit;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MyStepdefinition {

    static WebDriver driver;
    @Given("user is in the Home page")
    public void userIsInTheHomePage() throws InterruptedException {
        //driver=HomePage.launchBrowser("chrome","http://demo.nopcommerce.com/");

    }

    @When("user opens the {string} link")
    public void userOpensTheLink(String arg0) {
        WebElement link=driver.findElement(By.partialLinkText(arg0));
        link.click();
    }

    @Then("the page should open in a new window with title as {string}")
    public void thePageShouldOpenWithText(String arg0) {
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
    }

    @When("user opens the {string} link at the bottom of page")
    public void userOpensTheLinkAtTheBottomOfPage(String arg0) {
        //WebElement footerlink=driver.findElement(By.partialLinkText(arg0));
        //footerlink.click();
        
    }

}
*/
