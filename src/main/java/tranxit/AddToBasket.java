package tranxit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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

    //List<WebElement> updateshoppingCart=driver.findElements(By.className("qty-input"));
    @FindBy(how = How.CLASS_NAME, using = "qty-input")
    public List<WebElement> updateQuantity;

    @FindBy(how = How.CLASS_NAME, using = "product-name")
    public List<WebElement> productlabel;


    public void userClicksLink() throws InterruptedException {
        addToCart.click();
        Thread.sleep(5000);
    }

    public WebElement cartCheck() {
        return addToBasket;
    }

    public void removeQuantity() {
        shoppingCart.click();
        //return removeQuantity;
        //List<WebElement> removeQuantity=addToBasket.removeQuantity();
        for (WebElement i : removeQuantity) {
            i.click();
        }
    }

    public void UpdateCart() {
        updateCart.click();
    }

    public WebElement confirmMessage() {
        return confirmationMessage;
    }

    public void updateQuantity() {
        shoppingCart.click();
        //return updateshoppingCart;
        //updateQuantity = updateshoppingCart;
    }

    public void productlabel() {
        //return productlabel;
        //productlabel = productlabel;
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
        //productlabel = addToBasket.productlabel();
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