package tranxit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddToBasket extends BasePage{
    public AddToBasket(WebDriver driver){
        super(driver);
    }

    public WebElement userClicksLink(){
        WebElement addToCart=driver.findElement(By.xpath("//input[@value='Add to cart']"));
        return addToCart;
    }
    public WebElement cartCheck(){
        WebElement addToBasket=driver.findElement(By.xpath("//span[@class='cart-qty']"));
        return addToBasket;
    }
    public List<WebElement> removeQuantity(){
        WebElement shoppingCart=driver.findElement(By.xpath("//span[@class='cart-label']"));
        shoppingCart.click();
        List<WebElement> removeQuantity=driver.findElements(By.name("removefromcart"));
        return removeQuantity;
    }
    public WebElement UpdateCart(){
        WebElement updateCart=driver.findElement(By.name("updatecart"));
        return updateCart;
    }
    public WebElement confirmMessage(){
        WebElement confirmationMessage=driver.findElement(By.xpath("//div[@class='no-data']"));
        return confirmationMessage;
    }
    public List<WebElement> updateQuantity(){
        WebElement shoppingCart=driver.findElement(By.xpath("//span[@class='cart-label']"));
        shoppingCart.click();
        List<WebElement> updateshoppingCart=driver.findElements(By.className("qty-input"));
        return updateshoppingCart;
    }
    public List<WebElement> productlabel(){
        List<WebElement> productlabel=driver.findElements(By.className("product-name"));
        return productlabel;
    }
}
