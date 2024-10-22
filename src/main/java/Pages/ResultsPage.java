package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ResultsPage {
    private WebDriver driver;
    private By firstResult= By.xpath("//strong[@class='product name product-item-name'][1]/a[1]");
    private By resultsPrices =By.className("price");
    private By resultsNames=By.className("product-item-link");
    private By sortBy= By.ById.id("sorter");
    private By ascending=By.xpath("//a[@title='Set Ascending Direction']");
    private By descending=By.xpath("//a[@title='Set Descending Direction']");

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstResult() {
        return  driver.findElement(firstResult).getText();
    }

    public void selectSortBy(String VisibleTxt) throws InterruptedException {
        WebElement sorter = driver.findElement(sortBy);
        Select sortSelect = new Select(sorter);
        sortSelect.selectByVisibleText(VisibleTxt);
        Thread.sleep(3000);
    }
    public void selectAscending() throws InterruptedException {
        click(ascending);
        Thread.sleep(3000);
    }

    public void selectDescending() throws InterruptedException {
        click(descending);
        Thread.sleep(3000);
    }

    public Long getResultPrice(int ResultIndex) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        List<WebElement> elements =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(resultsPrices));
        String price=elements.get(ResultIndex-1).getText();
        price=price.replace("$","");
        Long lprice = Long.valueOf(price.substring(0,price.indexOf("."))).longValue();
        return lprice;
    }

    public int getFirstCharAscii(int ResultIndex) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        List<WebElement> elements =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(resultsNames));
        String name=elements.get(ResultIndex-1).getText();
        char character = name.charAt(0);
        int ascii = (int) character;
        return ascii;
    }
    private void click(By locator) {
        driver.findElement(locator).click();
    }

}
