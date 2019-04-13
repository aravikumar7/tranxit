package tranxit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Search extends BasePage{
    public Search(WebDriver driver){
        super(driver);
    }

    String productDescription;

    @FindBy(how = How.ID,using = "small-searchterms")
    public WebElement searchBox;

    @FindBy(how = How.XPATH,using = "//input[@value='Search']")
    public WebElement searchButton;

    @FindBy(how = How.XPATH,using = "div[@class='message-error validation-summary-errors']")
    public WebElement errorMessage;

    public void searchOptionClick(){
        searchBox.click();
    }
    public void searchText(String arg0){
        searchBox.clear();
        searchBox.sendKeys(arg0);
    }

    public void searchButtonClick(){
        searchButton.click();
    }

    public WebElement clickSearchButton()
    {
        return searchButton;
    }

    public Boolean resultPage(String prodDescription){
        productDescription=driver.findElement(By.partialLinkText(prodDescription)).getText();
        return prodDescription.contains(prodDescription);
    }

public Boolean isSuccesfullyLoggedIn() {
    return errorMessage.getText().contains("Login was unsuccessful. Please correct the errors and try again.");
    }

}
