package tests.blogspotPage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.blogspotPage.MouseHoverPage;
import pages.blogspotPage.SearchPage;
import utils.TestBase;

public class MouseHoverTest extends TestBase {


    private MouseHoverPage mouseHoverPage;

    @BeforeClass
    public void setUp() {
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        mouseHoverPage = new MouseHoverPage(driver);
    }

    @Test(priority = 1, description = "Test Mouse Hover Functionality")
    public void testMouseHover() {
        mouseHoverPage.hoverOverPointMe();
        Assert.assertEquals(mouseHoverPage.isMouseHoverOptionsDisplayed(), true, "Mouse hover options should be displayed.");
    }

    @Test(priority = 2, description = "Test Click on Mouse Hover Option - Mobiles")
    public void testClickMouseHoverOption() {
        mouseHoverPage.hoverOverPointMe();
        mouseHoverPage.clickMobilesOption();
        Assert.assertTrue(mouseHoverPage.isMoiblesOptionClicked(), " Mobiles option should be clicked successfully.");
    }

    @Test(priority = 3, description = "Test Click on Mouse Hover Option - Laptops")
    public void testClickMouseHoverOptionLaptops() {
        mouseHoverPage.hoverOverPointMe();
        mouseHoverPage.clickLaptopsOption();
        Assert.assertTrue(mouseHoverPage.isLaptopsOptionClicked(), " Laptops option should be clicked successfully.");
    }



}
