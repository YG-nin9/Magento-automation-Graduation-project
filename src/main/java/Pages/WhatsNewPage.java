package Pages;

import org.openqa.selenium.WebDriver;

public class WhatsNewPage {
    private WebDriver driver;

    public WhatsNewPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
