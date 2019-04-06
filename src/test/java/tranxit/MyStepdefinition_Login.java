package tranxit;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class MyStepdefinition_Login {
    WebDriver driver;
    Login login;
    HomePage home;
    Register register;
    AddToBasket addToBasket;
    List<WebElement> updateQuantity;
    List<WebElement> productlabel;
    Search srch;

   // @Before
    //public void testtetsetet() {
      //  System.out.println("openBrowser");
       // System.setProperty("webdriver.chrome.driver","/G/chromedriver.exe");

//        WebDriverManager.chromedriver().setup();
//        browser = new ChromeDriver();
       // driver = BrowserFactory.getBrowser();
        //driver.manage().window().maximize();
        //driver.get("http://demo.nopcommerce.com");
    //}


    @Given("user is in Home page")
    public void userIsInHomePage() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        driver.get("http://demo.nopcommerce.com/");
        System.setProperty("webdriver.chrome.driver","G:/driver/chromedriver");
        driver = BrowserFactory.getBrowser();
        driver.manage().window().maximize();
        driver.get("http://demo.nopcommerce.com");
    }

    @When("user clicks Log in link")
    public void userClicksLogInLink() {
        home = new HomePage(driver);
        home.clickLogin();
    }

    @And("the {string} message appears")
    public void theMessageAppears(String arg0) {
        Assert.assertTrue(home.welcomeMessage());
    }

    @And("user enters {string} and {string} and clicks log in button")
    public void userEntersAndAndClicksButton(String arg0, String arg1) {
        home.login(arg0, arg1);
    }

    @Then("he should be successfully logged in")
    public void heShouldBeSuccessfullyLoggedIn() {
        login=new Login(driver);
        Assert.assertTrue(login.successfulLogin());
    }
    @When("user clicks on MY ACCOUNT link after logging in")
    public void userClicksOnLinkAfterLoggingIn() {
    // login=new Login(driver);
            login.MyAccount();
    }

    @And("updates Company Name to {string}")
    public void updatesCompanyNameTo(String arg0) {
      login.UpdateCompanyName(arg0);
    }

    @And("Clicks Save button")
    public void clicksSaveButton() {
        login.save();
    }

    @Then("Company name should get updated as {string}")
    public void companyNameShouldGetUpdatedAsCompanyName(String arg0) throws Throwable {    // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
        Assert.assertTrue(login.CompanyNameCheck(arg0));
    }

    @When("user clicks on Logout")
    public void userClicksOnLogout() {
        login=new Login(driver);
        login.logout();
    }

    @Then("he should be successfully logged out")
    public void heShouldBeSuccessfullyLoggedOut() {
    Assert.assertTrue(login.logoutCheck());
        driver.quit();
    }

//#########REGISTER

    @When("user clicks on the {string} link")
    public void userClicksOnTheLink(String arg0) {
        register=new Register(driver);
        WebElement registrationLink=register.registarionLink();
        registrationLink.click();
    }

    @Then("he should be taken to registration page")
    public void heShouldBeTakenToRegistrationPage() {
        WebElement registrationPageHeading=driver.findElement(By.tagName("h1"));
        Assert.assertEquals("Register",registrationPageHeading.getText());
    }


    @When("he selects {string},{string},{string} and inputs {string},{string},{string},{string},{string},{string},{string}")
    public void heSelectsAndInputs(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9) {
        register.enterUserDetails(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    }

    @And("Clicks Submit button")
    public void clicksSubmitButton() {
        driver.findElement(By.name("register-button")).click();
    }

    @Then("{string} message should appear")
    public void messageShouldAppear(String arg0) {
        WebElement registrationConfirmation=driver.findElement(By.xpath("//div[@class='result']"));
        Assert.assertEquals(arg0,registrationConfirmation.getText());
    }


//#####ADD TO BASKET


    @When("user clicks on {string} link")
    public void userClicksOnLink(String arg0) throws InterruptedException {
        addToBasket=new AddToBasket(driver);
        WebElement addToCart=addToBasket.userClicksLink();
        addToCart.click();
        Thread.sleep(5000);
    }

    @Then("the product should be added to Cart with proper {string}")
    public void theProductShouldBeAddedToCartWithProper(String arg0) {
        WebElement addToCart=addToBasket.cartCheck();
        Assert.assertEquals(arg0,addToCart.getText());
    }

    @When("user clicks on {string} button and selects Remove")
    public void userClicksOnButtonAndSelectsRemove(String arg0) {
        List<WebElement> removeQuantity=addToBasket.removeQuantity();
        for(WebElement i: removeQuantity)
        {
            i.click();
        }
    }

    @And("Clicks on {string}")
    public void clicksOn(String arg0) {
        WebElement updateCart=addToBasket.UpdateCart();
        updateCart.click();
    }

    @Then("the message {string} should appear")
    public void theMessageShouldAppear(String arg0) {
        WebElement confirmationMessage=addToBasket.confirmMessage();
        Assert.assertEquals(arg0,confirmationMessage.getText());
    }

    @When("user clicks on {string} button")
    public void userClicksOnButtonAndSelectsQty(String arg0) {

        updateQuantity=addToBasket.updateQuantity();
    }

    @And("selects qty")
    public void selectsQty() {
        productlabel=addToBasket.productlabel();
    }

    @And("Updates product's {string} quantity {string}")
    public void updatesProductSQuantity(String arg0, String arg1) {
        int k=0;
        for(WebElement i: productlabel) {
            k++;
            int l=0;
            for (WebElement j : updateQuantity) {
                l++;
                if ((i.getText().equals(arg0)) && k==l)
                {j.clear();
                    j.sendKeys(arg1);
                }
            }
        }

    }

    @Then("Quantity for {string} should get updated as given in {string}")
    public void quantityForShouldGetUpdatedAsGivenIn(String arg0, String arg1) throws InterruptedException {
        driver.navigate().refresh();
        productlabel=addToBasket.productlabel();
        updateQuantity=driver.findElements(By.className("qty-input"));
        Thread.sleep(5000);
        int k = 0;
        for (WebElement m : productlabel) {
            k++;
            int l = 0;
            for (WebElement n : updateQuantity) {
                l++;
                if ((m.getText().equals(arg0)) && k == l) {
                    Assert.assertEquals(arg1, n.getAttribute("value"));
                }
            }

        }
    }


//##Search

    WebElement searchBox;

    @When("user Search option is available")
    public void userSearchOptionIsAvailable() {
        srch=new Search(driver);
        searchBox=srch.searchOption();
    }

    @And("user clicks on search Text box")
    public void userClicksOnSearchTextBox() {
        searchBox.click();
    }

    @And("enters {string}")
    public void enters(String arg0) {
        searchBox.clear();
        searchBox.sendKeys(arg0);
    }

    @When("user clicks on Search button")
    public void userClicksOnSearchButton() {
        WebElement searchButton=srch.clickSearchButton();
        searchButton.click();
    }

    @Then("user should be taken to the result page with the {string} and picture")
    public void userShouldBeTakenToTheResultPageWithTheAndPicture(String arg0) {
        WebElement productDescription=srch.resultPage(arg0);
        Assert.assertEquals(arg0,productDescription.getText());
    }













}