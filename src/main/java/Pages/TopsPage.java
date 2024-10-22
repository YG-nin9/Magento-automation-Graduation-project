package Pages;

import org.openqa.selenium.WebDriver;

public class TopsPage{
    private WebDriver driver;

    public TopsPage(WebDriver driver){
        this.driver = driver;
    }

    public String getPageTitle(){
        return driver.getTitle();
    }
}
