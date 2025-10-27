package tests.blogspotPage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.blogspotPage.AlertsPage;
import pages.blogspotPage.DynamicElementPage;
import utils.TestBase;

public class DynamicTest extends TestBase {

    private DynamicElementPage dynamicElementPage;

    @BeforeClass
    public void setUp() {
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        dynamicElementPage = new DynamicElementPage(driver);
    }

    @Test
    public void testDynamicStartButton() {
        dynamicElementPage.clickDynamicStart();
        Assert.assertEquals(dynamicElementPage.isDynamicStopButtonDisplayed(), true);

        dynamicElementPage.clickDynamicStop();
        Assert.assertEquals(dynamicElementPage.isDynamicStartButtonDisplayed(), true);

    }

    // Approach 2
    @Test
    public void testDynamicButton() {
        dynamicElementPage.clickDynamicButton();
        Assert.assertEquals(dynamicElementPage.getDynamicButtonText(), "STOP", "Dynamic button text is not as expected");

        dynamicElementPage.clickDynamicButton();
        Assert.assertEquals(dynamicElementPage.getDynamicButtonText(), "START", "Dynamic button text is not as expected");
    }




}
