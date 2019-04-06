package tranxit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Search extends BasePage{
    WebElement searchBox;
    WebElement searchButton;
    public Search(WebDriver driver){
        super(driver);
    }
    public WebElement searchOption(){
        searchBox = driver.findElement(By.id("small-searchterms"));
        return searchBox;
    }
    public WebElement clickSearchButton(){
        searchButton=driver.findElement(By.xpath("//input[@value='Search']"));
        return searchButton;
    }
    public WebElement resultPage(String prodDescription){
        WebElement productDescription=driver.findElement(By.partialLinkText(prodDescription));
        return productDescription;
    }
}
