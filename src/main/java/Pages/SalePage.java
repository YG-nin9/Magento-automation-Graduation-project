package Pages;

import org.openqa.selenium.WebDriver;

public class SalePage {

    private WebDriver driver;

    public SalePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
