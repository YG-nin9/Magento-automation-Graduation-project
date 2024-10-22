package Search;
import Base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTests{
        @Test(priority = 1)
        public void testSearch() {
            String txt="Bag";
            var resultsPage=homepage.search(txt);
            String ActualResult=resultsPage.getFirstResult();
            Assert.assertTrue(ActualResult.contains(txt));
        }
    }


