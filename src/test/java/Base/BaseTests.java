package Base;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homepage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        goHome();
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://magento.softwaretestingboard.com/");
        // driver.get("https://magento2-demo.magebit.com/");
        driver.manage().window().maximize();
        homepage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
