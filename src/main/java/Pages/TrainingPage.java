package Pages;

import org.openqa.selenium.WebDriver;

public class TrainingPage {
    private WebDriver driver;

    public TrainingPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
