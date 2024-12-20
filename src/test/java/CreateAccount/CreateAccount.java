package CreateAccount;

import com.aventstack.extentreports.Status;
import com.nopcommerce.base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static Pages.CreateAccount.*;

public class CreateAccount extends BaseTest {

    @Test
    public void TC01() {

        Pages.CreateAccount register = new Pages.CreateAccount(driver);
        SoftAssert softAssert = new SoftAssert();

        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "Your Test Case");
        test.log(Status.INFO, "starting");
        test.assignCategory("P0");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        register.createAccountButton().click();
        String currentURL = driver.getCurrentUrl();
        softAssert.assertEquals(currentURL,"https://magento.softwaretestingboard.com/customer/account/create/","Not the right page");

        register.fillFirstName(userFirstname);
        register.fillLastName(userLastName);
        register.fillEmail(userValidEmail);
        register.fillPassword(userValidPassword);

        register.clickCreateAccountButton();
        softAssert.assertEquals(register.getTheEmptyConfirmPasswordMessage(),"This is a required field.","not the same message");

        softAssert.assertAll();
    }

    @Test
    public void TC02() {

        Pages.CreateAccount register = new Pages.CreateAccount(driver);
        SoftAssert softAssert = new SoftAssert();

        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "Your Test Case");
        test.log(Status.INFO, "starting");
        test.assignCategory("P0");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        register.createAccountButton().click();

        String currentURL = driver.getCurrentUrl();
        softAssert.assertEquals(currentURL,"https://magento.softwaretestingboard.com/customer/account/create/","Not the right page");

        register.fillFirstName(userFirstname);
        register.fillLastName(userLastName);
        register.fillEmail(userValidEmail);
        register.fillPassword(userValidPassword);
        register.fillConfirmPassword(userInvalidPassword);

        register.clickCreateAccountButton();
        softAssert.assertEquals(register.getTheSameValueMessage(),"Please enter the same value again.","Not the same error message");

        softAssert.assertAll();
    }

    @Test
    public void TC03() throws InterruptedException {

        Pages.CreateAccount register = new Pages.CreateAccount(driver);
        SoftAssert softAssert = new SoftAssert();

        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "Your Test Case");
        test.log(Status.INFO, "starting");
        test.assignCategory("P0");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        register.createAccountButton().click();

        register.fillFirstName(userFirstname);
        register.fillLastName(userLastName);
        register.fillEmail(userValidEmail);
        register.fillPassword(userValidPassword);
        register.fillConfirmPassword(userValidPassword);

        register.clickCreateAccountButton();
        Thread.sleep(2000);
        String currentURL = driver.getCurrentUrl();
        softAssert.assertEquals(currentURL,"https://magento.softwaretestingboard.com/customer/account/","Not the right page");
        //softAssert.assertEquals(register.getTheAccountName(),"Dani Phantom","Not the same account name!");

        softAssert.assertAll();
    }
}
