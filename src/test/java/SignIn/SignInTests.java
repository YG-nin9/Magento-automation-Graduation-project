package SignIn;
import Base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SignInTests extends BaseTests {
    @Test(priority = 3)
    public void testValidSignIn() throws InterruptedException {
        var logInPage = homepage.clickSignIn();
        logInPage.enterEmail("testauto123@test.com");
        logInPage.enterPassword("Test123!");
        logInPage.clickSignIn();
        Thread.sleep(3000);
        String actualMessage=homepage.getWelcomeMsg();
        String expectMessage="Welcome";
        Assert.assertTrue(actualMessage.contains(expectMessage));
    }
    @Test(priority = 1)
    public void testInValidPassword() {
        var logInPage = homepage.clickSignIn();
        logInPage.enterEmail("testauto123@test.com");
        logInPage.enterPassword("Test12!");
        logInPage.clickSignIn();
        String actualMsg= logInPage.getHeaderMessage();
        String expectedMsg="The account sign-in was incorrect";
        Assert.assertTrue(actualMsg.contains(expectedMsg),"Unsuccessful login");
    }

    @DataProvider(name ="invalidMailForms")
    public Object[] mails(){
        return new Object[][] {{"test@gmail"}, {"test@.com"},{"testgmail.com"},{"test@"}};
    }

    @Test(priority = 2,dataProvider = "invalidMailForms")
    public void testInValidMail(String invalidMail)
    {   var logInPage = homepage.clickSignIn();
        logInPage.enterEmail(invalidMail);
        logInPage.enterPassword("Test12!");
        logInPage.clickSignIn();
        String actualMessage= logInPage.getEmailFieldMessage();
        String expectMessage="Please enter a valid email address";
        Assert.assertTrue(actualMessage.contains(expectMessage),"Successful Login");
    }
}
