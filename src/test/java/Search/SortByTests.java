package Search;
import Base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortByTests extends BaseTests {
    //Note: Products Sorted in Descending Order by Default
    @Test(priority = 2)
    public void testSortByPrice_Descending() throws InterruptedException {
        String txt="shirt";
        var resultsPage=homepage.search(txt);
        resultsPage.selectSortBy("Price");
        Long firstPrice=resultsPage.getResultPrice(1);
        System.out.println(firstPrice);
        Long secondPrice=resultsPage.getResultPrice(2);
        System.out.println(secondPrice);
        Assert.assertTrue(firstPrice>secondPrice);
    }
    @Test(priority = 1)
    public void testSortByPrice_Ascending() throws InterruptedException {
        String txt="shirt";
        var resultsPage=homepage.search(txt);
        resultsPage.selectSortBy("Price");
        resultsPage.selectAscending();
        Long firstPrice=resultsPage.getResultPrice(1);
        Long secondPrice=resultsPage.getResultPrice(2);
        Assert.assertTrue(firstPrice<secondPrice);
    }
    @Test(priority = 3)
    public void testSortByName_Ascending() throws InterruptedException {
        String txt = "shirt";
        var resultsPage = homepage.search(txt);
        resultsPage.selectSortBy("Product Name");
        resultsPage.selectAscending();
        int firstCharAsciiP1 = resultsPage.getFirstCharAscii(1);
        int firstCharAsciiP2 = resultsPage.getFirstCharAscii(2);
        Assert.assertTrue(firstCharAsciiP1 < firstCharAsciiP2);
    }
}
