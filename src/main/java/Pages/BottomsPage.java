package Pages;

import org.openqa.selenium.WebDriver;

public class BottomsPage {
    private WebDriver driver;

    public BottomsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
