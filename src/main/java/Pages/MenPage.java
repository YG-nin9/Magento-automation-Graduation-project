package Pages;

import org.openqa.selenium.WebDriver;

public class MenPage {

    private WebDriver driver;

    public MenPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
