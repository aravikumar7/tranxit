package tranxit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login extends BasePage{

    public Login(WebDriver driver){
        super(driver);
    }

    @FindBy(how = How.XPATH,using = "//a[@class='ico-logout']")
    public WebElement logout;
    @FindBy(how = How.XPATH,using = "//a[@class='ico-account']")
    public WebElement myAccount;
    @FindBy(how = How.ID,using = "Company")
    public WebElement company;
    @FindBy(how = How.ID,using = "save-info-button")
    public WebElement save;
    @FindBy(how = How.XPATH,using = "//a[@class='ico-login']")
    public WebElement login;

    public Boolean successfulLogin(){
        String logoutTest=logout.getText();
        return logoutTest.contains("Log out");
    }
    public void MyAccount(){
        myAccount.click();
    }

    public void UpdateCompanyName(String arg0) {
        company.clear();
        company.sendKeys(arg0);
    }

    public void save() {
        save.click();
    }

    public boolean CompanyNameCheck(String arg0) {
        String companyName = company.getAttribute("value");
        return companyName.contains(arg0);
    }

    public void logout() {
        logout.click();
    }

    public boolean logoutCheck() {
        String loginButton=login.getText();
        return loginButton.contains("Log in");
    }
}
