package tests.blogspotPage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.blogspotPage.AlertsPage;
import pages.blogspotPage.WindowsPage;
import utils.TestBase;

public class WindowsTest extends TestBase {

    private WindowsPage windowsPage;

    @BeforeClass
    public void setUp() {
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        windowsPage = new WindowsPage(driver);
    }

    @Test(priority = 1, description = "Test Open New Ta Button")
    public void testOpenNewTabButton() {
        windowsPage.clickNewTabButton();
        Assert.assertTrue(windowsPage.isNewTabOpened(), "New window should be opened.");
    }

    @Test(priority = 2, dependsOnMethods = "testOpenNewTabButton", description = "Test Close & Switch Back to Original Tab")
    public void testSwitchBackToOriginalTab() {
        windowsPage.closeTabAndSwitchBack();
        Assert.assertTrue(windowsPage.isOriginalTabActive(), "Should switch back to the original tab.");
    }

    @Test(priority = 3, description = "Test Open New Window Button")
    public void testOpenNewWindowButton() {
        windowsPage.clickNewWindowButton();
        Assert.assertTrue(windowsPage.isNewWindowOpened(), "New window should be opened.");
    }

    @Test(priority = 4, dependsOnMethods = "testOpenNewWindowButton", description = "Close only Selenium window and return to main page")
    public void testCloseSeleniumWindow() {
        windowsPage.closeSpecificWindow("selenium.dev");
        Assert.assertTrue(windowsPage.isOriginalWindowActive(), "Should switch back to the original window.");
    }

    @Test(priority = 4, dependsOnMethods = "testOpenNewWindowButton", description = "Test Close & Switch Back to Original Window")
    public void testSwitchBackToOriginalWindow() {
        windowsPage.closeWindowAndSwitchBack();
        Assert.assertTrue(windowsPage.isOriginalWindowActive(), "Should switch back to the original window.");
    }


}
