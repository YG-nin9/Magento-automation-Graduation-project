package Category;
import Base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CategoriesTest extends BaseTests {
    @Test
    public void testWhatNewCategory(){
        var whatsNewPage = homepage.clickWhatNewCategory();
        String ActualTitle=whatsNewPage.getPageTitle();
        String ExpectedTitle="What's New";
        Assert.assertEquals(ActualTitle,ExpectedTitle);
    }
    @Test
    public void testMenCategory(){
        var MenPage = homepage.clickMenCategory();
        MenPage.getPageTitle();
        String ActualTitle=MenPage.getPageTitle();
        String ExpectedTitle="Men";
        Assert.assertEquals(ActualTitle,ExpectedTitle);
    }
    @Test
    public void testSubCategories_MenTops(){
        homepage.hoverMen();
        var menTopsPage =homepage.clickMenTops();
        String ActualTitle=menTopsPage.getPageTitle();
        String ExpectedTitle="Tops - Men";
        Assert.assertEquals(ActualTitle,ExpectedTitle);
    }
    @Test
    public void testSubCategories_MenBottoms(){
        homepage.hoverMen();
        var menBottomsPage =homepage.clickMenBottoms();
        String ActualTitle=menBottomsPage.getPageTitle();
        String ExpectedTitle="Bottoms - Men";
        Assert.assertEquals(ActualTitle,ExpectedTitle);
    }
    @Test
    public void testWomenCategory(){
        var womenPage = homepage.clickWomenCategory();
        String ActualTitle=womenPage.getPageTitle();
        String ExpectedTitle="Women";
        Assert.assertEquals(ActualTitle,ExpectedTitle);
    }
    @Test
    public void testGearCategory(){
        var gearPage = homepage.clickGearCategory();
        String ActualTitle=gearPage.getPageTitle();
        String ExpectedTitle="Gear";
        Assert.assertEquals(ActualTitle,ExpectedTitle);
    }
    @Test
    public void testTrainingCategory(){
        var trainingPage = homepage.clickTrainingCategory();
        String ActualTitle=trainingPage.getPageTitle();
        String ExpectedTitle="Training";
        Assert.assertEquals(ActualTitle,ExpectedTitle);
    }
    @Test
    public void testSaleCategory(){
        var salePage = homepage.clickSaleCategory();
        String ActualTitle=salePage.getPageTitle();
        String ExpectedTitle="Sale";
        Assert.assertEquals(ActualTitle,ExpectedTitle);
    }
}

