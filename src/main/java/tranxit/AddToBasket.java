package tranxit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class AddToBasket extends BasePage{

    @FindBy(how = How.XPATH,using = "//input[@value='Add to cart']")
    public WebElement addToCart;

    @FindBy(how = How.XPATH,using = "//span[@class='cart-qty']")
    public WebElement addToBasket;

    @FindBy(how = How.XPATH,using = "//span[@class='cart-label']")
    public WebElement shoppingCart;

    @FindBy(how = How.NAME,using = "removefromcart")
    public List<WebElement> removeQuantity;

    @FindBy(how = How.NAME,using = "updatecart")
    public WebElement updateCart;

    @FindBy(how = How.XPATH,using = "//div[@class='no-data']")
    public WebElement confirmationMessage;

    //List<WebElement> updateshoppingCart=driver.findElements(By.className("qty-input"));
    @FindBy(how = How.CLASS_NAME,using = "qty-input")
    public List<WebElement> updateshoppingCart;

    @FindBy(how = How.CLASS_NAME,using = "product-name")
    public List<WebElement> productlabel;

    public AddToBasket(WebDriver driver)
    {
        super(driver);
    }

    public WebElement userClicksLink(){
        return addToCart;
    }
    public WebElement cartCheck(){
        return addToBasket;
    }
    public List<WebElement> removeQuantity(){
        shoppingCart.click();
        return removeQuantity;
    }
    public WebElement UpdateCart(){
        return updateCart;
    }
    public WebElement confirmMessage(){
        return confirmationMessage;
    }
    public List<WebElement> updateQuantity(){
        shoppingCart.click();
        return updateshoppingCart;
    }
    public List<WebElement> productlabel(){
        return productlabel;
    }
}
