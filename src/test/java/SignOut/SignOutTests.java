package SignOut;

import Base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignOutTests extends BaseTests {
    @Test
    public void testSignOut() throws InterruptedException {
        var logInPage = homepage.clickSignIn();
        logInPage.enterEmail("testauto123@test.com");
        logInPage.enterPassword("Test123!");
        homepage=logInPage.clickSignIn();
        Thread.sleep(3000);
        homepage.clickExpandButton();
        homepage.ClickSignOut();
       Assert.assertTrue(homepage.isSignInTxtDisplayed());
    }
}
