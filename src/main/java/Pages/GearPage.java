package Pages;
import org.openqa.selenium.WebDriver;

public class GearPage {

    private WebDriver driver;

    public GearPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getPageTitle() {
        return driver.getTitle();
    }
}
