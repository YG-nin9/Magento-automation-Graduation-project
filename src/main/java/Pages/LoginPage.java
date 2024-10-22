package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By emailField = By.id("email");
    private By passwordField = By.id("pass");
    private By signInButton = By.xpath("//button[@class='action login primary']");
    private By headerErrorMessage = By.xpath("//div[@class='message-error error message']");
    private By emailFieldMsg = By.id("email-error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        send(emailField, email);
    }

    public void enterPassword(String password) {
        send(passwordField, password);
    }

    public HomePage clickSignIn() {
        click(signInButton);
        return new HomePage(driver);
    }

    public String getHeaderMessage() {
        return driver.findElement(headerErrorMessage).getText();
    }

    public String getEmailFieldMessage() {
        return driver.findElement(emailFieldMsg).getText();
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }

    private void send(By locator, String txt) {
        driver.findElement(locator).sendKeys(txt);
    }
}