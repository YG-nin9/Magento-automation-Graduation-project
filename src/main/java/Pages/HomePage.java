package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private By register= By.linkText("Create an Account");
    private By signIn= By.linkText("Sign In");
    private By welcomeMsg=By.xpath("//span[@class='logged-in']");
    private By addToCartBtn=By.xpath("//button[class='action tocart primary']");
    private By myCart=By.xpath("//a[@class='action showcart']");
    private By viewAndEditCart=By.linkText("View and Edit Cart");
    private By whatNewCategpry=By.linkText("What's New");
    private By womenCategory=By.linkText("Women");
    private By menCategory=By.linkText("Men");
    private By  menTops=By.id("ui-id-17");
    private By menBottoms=By.id("ui-id-18");
    private By trainingCategory=By.linkText("Training");
    private By gearCategory=By.linkText("Gear");
    private By saleCategory=By.linkText("Sale");
    private By searchField=By.id("search");
    private By expandWelcomeBtn=By.xpath("//button[@class='action switch']");
    private By signOutBtn=By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a");
    private By signInTxt=By.xpath("//li[@class=\"authorization-link\"]/a");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public ResultsPage search(String text){
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys(text+"\n");
        return new ResultsPage(driver);
    }

    public void ClickSignOut() {
        click(signOutBtn);
    }

    public void clickExpandButton() {
        click(expandWelcomeBtn);
    }

    public Boolean isSignInTxtDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(signInTxt)).isDisplayed();
    }
    public LoginPage clickSignIn() {
        click(signIn);
        return new LoginPage(driver);
    }
    public void clickMyCart() throws InterruptedException {
        Thread.sleep(3000);
        click(myCart);
    }

    public String getWelcomeMsg() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      return   wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMsg)).getText();
    }



    public WhatsNewPage clickWhatNewCategory() {
        click(whatNewCategpry);
        return new WhatsNewPage(driver);
    }
    public WomenPage clickWomenCategory() {
        click(womenCategory);
        return new WomenPage(driver);
    }
    public MenPage clickMenCategory(){
        click(menCategory);
        return new MenPage(driver);
    }
    public void hoverMen(){
        moveTo(menCategory);
    }
    public TopsPage clickMenTops() {
        click(menTops);
        return new TopsPage(driver);
    }
    public BottomsPage clickMenBottoms() {
        click(menBottoms);
        return new BottomsPage(driver);
    }
    public GearPage clickGearCategory() {
        click(gearCategory);
        return new GearPage(driver);
    }
    public TrainingPage clickTrainingCategory() {
        click(trainingCategory);
        return new TrainingPage(driver);
    }
    public SalePage clickSaleCategory() {
        click(saleCategory);
        return new SalePage(driver);
    }

    private void click(By locator) {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }
    private void scrollToElement(By locator) {
        String script="arguments[0].scrollIntoView();";
        WebElement element=driver.findElement(locator);
        ((JavascriptExecutor)driver).executeScript(script,element);
    }
    private void moveTo(By locator) {
        WebElement element=driver.findElement(locator);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }


}