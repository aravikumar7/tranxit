package tranxit;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddToBasket extends BasePage {
    public AddToBasket(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//input[@value='Add to cart']")
    public WebElement addToCart;

    @FindBy(how = How.XPATH, using = "//span[@class='cart-qty']")
    public WebElement addToBasket;

    @FindBy(how = How.XPATH, using = "//span[@class='cart-label']")
    public WebElement shoppingCart;

    @FindBy(how = How.NAME, using = "removefromcart")
    public List<WebElement> removeQuantity;

    @FindBy(how = How.NAME, using = "updatecart")
    public WebElement updateCart;

    @FindBy(how = How.XPATH, using = "//div[@class='no-data']")
    public WebElement confirmationMessage;

    @FindBy(how = How.CLASS_NAME, using = "qty-input")
    public List<WebElement> updateQuantity;

    @FindBy(how = How.CLASS_NAME, using = "product-name")
    public List<WebElement> productlabel;


    public void userClicksLink() throws InterruptedException {
        addToCart.click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(By.xpath("//*[@id='bar-notification']/span")));
    }

    public Boolean cartCheck(String arg0) throws InterruptedException {
        //System.out.println(addToBasket.getText());
        WebDriverWait wait = new WebDriverWait(driver,30);
        //wait.until(ExpectedConditions.visibilityOf(addToBasket));
        wait.until(ExpectedConditions.elementToBeClickable(addToBasket));
        //Thread.sleep(5000);
        //System.out.println("After" + addToBasket.getText());
        return addToBasket.getText().contains(arg0);
    }

    public void removeQuantity() {
        shoppingCart.click();
        for (WebElement i : removeQuantity) {
            i.click();
        }
    }

    public void UpdateCart() {
        updateCart.click();
    }

    public Boolean confirmMessage(String arg0) {
        return confirmationMessage.getText().contains(arg0);
    }

    public void updateQuantity() {
        shoppingCart.click();
    }

    public void updateProductQuantity(String arg0, String arg1) {
        int k = 0;
        for (WebElement i : productlabel) {
            k++;
            int l = 0;
            for (WebElement j : updateQuantity) {
                l++;
                if ((i.getText().equals(arg0)) && k == l) {
                    j.clear();
                    j.sendKeys(arg1);
                }
            }
        }
    }

    public void updatedQuantityCheck(String arg0, String arg1) throws InterruptedException {
        driver.navigate().refresh();
        try
        {
            driver.switchTo().alert().dismiss();
        }
        catch (NoAlertPresentException Ex)
        {
        }
        updateQuantity = driver.findElements(By.className("qty-input"));
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
}