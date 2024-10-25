package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CreateAccount {

    WebDriver driver;
    public static String userFirstname = "Dani";
    public static String userLastName = "Phantom";
    public static String userValidEmail = "test_mai5l@gmail.com";
    public static String userValidPassword = "Admin@123";
    public static String userInvalidPassword = "Admin@@123";
    public static String fullName = "Dani Phantom";

    public CreateAccount(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement createAccountButton () {

        return driver.findElement(By.xpath("(//a[@ href=\"https://magento.softwaretestingboard.com/customer/account/create/\"])[1]"));
   }

   public void fillFirstName(String firstName){
        driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys(firstName);
   }

    public void fillLastName (String lastname){
        driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys(lastname);
    }

    public void fillEmail (String validEmail){
        driver.findElement(By.xpath("//*[@id=\"email_address\"]")).sendKeys(validEmail);
    }

    public void fillPassword (String validPassword){
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(validPassword);
    }

    public void fillConfirmPassword(String validConfirmPassword){
        driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]")).sendKeys(validConfirmPassword);
    }

    public void clickCreateAccountButton (){
        driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();
    }

    public String getTheEmptyConfirmPasswordMessage (){
        return driver.findElement(By.id("password-confirmation-error")).getText();
    }

    public String getTheSameValueMessage(){
        return driver.findElement(By.id("password-confirmation-error")).getText();
    }

    public String getTheAccountName(){
        return driver.findElement(By.cssSelector("#maincontent > div.columns > div.column.main > div.block.block-dashboard-info > div.block-content > div > div.box-content > p")).getText();
    }
}
