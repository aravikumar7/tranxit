package tranxit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Search extends BasePage{

    @FindBy(how = How.ID,using = "small-searchterms")
    public WebElement searchBox;

    @FindBy(how = How.XPATH,using = "//input[@value='Search']")
    public WebElement searchButton;

    public Search(WebDriver driver){
        super(driver);
    }
    public WebElement searchOption(){
         return searchBox;
    }
    public WebElement clickSearchButton(){
        return searchButton;
    }
    public WebElement resultPage(String prodDescription){
        WebElement productDescription=driver.findElement(By.partialLinkText(prodDescription));
        return productDescription;
    }
}
