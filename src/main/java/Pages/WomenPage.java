package Pages;

import org.openqa.selenium.WebDriver;

public class WomenPage {
    private WebDriver driver;

    public WomenPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
