package tranxit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Register extends BasePage{

    public Register(WebDriver driver){
        super(driver);
    }

    public boolean confirmation(String arg0) {
        WebElement registrationConfirmation=driver.findElement(By.xpath("//div[@class='result']"));
        return registrationConfirmation.getText().contains(arg0);
    }

    public void register() {
        driver.findElement(By.name("register-button")).click();
    }

    public void registarionLink(){
        WebElement registrationLink=driver.findElement(By.className("ico-register"));
        registrationLink.click();
    }

    public void enterUserDetails(String gender, String dateOfBirth, String newsLetter, String firstName, String lastName, String email, String companyName, String userName, String Password, String confirmPassword){

        if(gender.equalsIgnoreCase("Male")) {
        driver.findElement(By.id("gender-male")).click();
        }
        else{
        driver.findElement(By.id("gender-female")).click();
        }

        driver.findElement(By.id("FirstName")).sendKeys(firstName);

        driver.findElement(By.id("LastName")).sendKeys(lastName);

        //String date=dateOfBirth.substring(0,2);
        String date=dateOfBirth.substring(0,dateOfBirth.indexOf("-"));
        System.out.println("date is"+date);
        //String month=dateOfBirth.substring(4,5);
        String month=dateOfBirth.substring(dateOfBirth.indexOf("-")+1,dateOfBirth.lastIndexOf("-"));
        String year=dateOfBirth.substring(dateOfBirth.lastIndexOf("-")+1,dateOfBirth.lastIndexOf("-")+5);
        Select dropDownDate=new Select(driver.findElement(By.name("DateOfBirthDay")));
        dropDownDate.selectByVisibleText(date);
        Select dropDownMonth=new Select(driver.findElement(By.name("DateOfBirthMonth")));
        dropDownMonth.selectByVisibleText(month);
        Select dropDownYear=new Select(driver.findElement(By.name("DateOfBirthYear")));
        dropDownYear.selectByVisibleText(year);

        driver.findElement(By.id("Email")).sendKeys(email);

        driver.findElement(By.id("Company")).sendKeys(companyName);

        if(newsLetter=="Yes"){
            if(!driver.findElement(By.id("Newsletter")).isSelected()){
                driver.findElement(By.id("Newsletter")).click();
            }
        }
        else{
            if(driver.findElement(By.id("Newsletter")).isSelected()){
                driver.findElement(By.id("Newsletter")).click();
            }
        }
        driver.findElement(By.id("Password")).sendKeys(Password);

        driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);
    }

}
