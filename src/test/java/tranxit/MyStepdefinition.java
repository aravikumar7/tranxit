package tranxit;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class MyStepdefinition {
    WebDriver driver;
    Login login;
    HomePage home;
    Register register;
    AddToBasket addToBasket;
    Search srch;

    @Before
    public void testtetsetet() {
        driver = BrowserFactory.getBrowser();
        driver.get("http://demo.nopcommerce.com");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void afterTest(Scenario scenario){
        if(scenario.isFailed()) {
            scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
        }
    }


    @Given("user is in Home page")
    public void userIsInHomePage() throws InterruptedException {
        home = new HomePage(driver);
        Assert.assertTrue(home.userInHomePage());
    }

    @When("user opens the {string} link")
    public void userOpensTheLink(String arg0) {
        home.linkOpen(arg0);
    }

    @Then("the page should open in a new window with title as {string}")
    public void thePageShouldOpenWithText(String arg0) {
        home.pageCheck(arg0);
    }

    @When("user clicks Log in link")
    public void userClicksLogInLink() {
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
        register.registarionLink();
    }

    @Then("he should be taken to registration page")
    public void heShouldBeTakenToRegistrationPage() {
        Assert.assertTrue(home.registration());
    }

    @When("he selects {string},{string},{string} and inputs {string},{string},{string},{string},{string},{string},{string}")
    public void heSelectsAndInputs(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9) {
        register.enterUserDetails(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    }

    @And("Clicks Submit button")
    public void clicksSubmitButton() {
        register.register();
    }

    @Then("{string} message should appear")
    public void messageShouldAppear(String arg0) {
        register.confirmation(arg0);
    }


//#####ADD TO BASKET

    @When("user clicks on {string} link")
    public void userClicksOnLink(String arg0) throws InterruptedException {
        addToBasket=new AddToBasket(driver);
        addToBasket.userClicksLink();
    }

    @Then("the product should be added to Cart with proper {string}")
    public void theProductShouldBeAddedToCartWithProper(String arg0) throws InterruptedException {
        Assert.assertTrue(addToBasket.cartCheck(arg0));
    }

    @When("user clicks on {string} button and selects Remove")
    public void userClicksOnButtonAndSelectsRemove(String arg0) {
        addToBasket=new AddToBasket(driver);
        addToBasket.removeQuantity();
    }

    @And("Clicks on Update Shopping Cart")
    public void clicksOn() {
        addToBasket.UpdateCart();
    }

    @Then("the message {string} should appear")
    public void theMessageShouldAppear(String arg0) {
        Assert.assertTrue(addToBasket.confirmMessage(arg0));
    }

    @When("user clicks on {string} button and selects quantity")
    public void userClicksOnButtonAndSelectsQty(String arg0) {
        addToBasket=new AddToBasket(driver);
        addToBasket.updateQuantity();
    }

    @And("Updates product's {string} quantity {string}")
    public void updatesProductSQuantity(String arg0, String arg1) {
        addToBasket.updateProductQuantity(arg0,arg1);
    }

    @Then("Quantity for {string} should get updated as given in {string}")
    public void quantityForShouldGetUpdatedAsGivenIn(String arg0, String arg1) throws InterruptedException {
       addToBasket.updatedQuantityCheck(arg0,arg1);
        }


//##Search

    @When("user Search option is available")
    public void userSearchOptionIsAvailable() {
        srch=new Search(driver);
    }

    @And("user clicks on search Text box")
    public void userClicksOnSearchTextBox() {
        srch.searchOptionClick();
    }

    @And("enters {string}")
    public void enters(String arg0) {
        srch.searchText(arg0);
    }

    @When("user clicks on Search button")
    public void userClicksOnSearchButton() {
        srch.searchButtonClick();
    }

    @Then("user should be taken to the result page with the {string} and picture")
    public void userShouldBeTakenToTheResultPageWithTheAndPicture(String arg0) {
        Assert.assertTrue(srch.resultPage(arg0));
        }

    @Then("he should not be successfully logged in")
    public void heShouldNotBeSuccessfullyLoggedIn() {
       Assert.assertTrue(srch.isSuccesfullyLoggedIn());
    }
}