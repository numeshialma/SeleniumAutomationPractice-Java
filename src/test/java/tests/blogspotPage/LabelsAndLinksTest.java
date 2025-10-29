package tests.blogspotPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.blogspotPage.GuiFormPage;
import pages.blogspotPage.LabelsAndLinksPage;
import utils.TestBase;

public class LabelsAndLinksTest extends TestBase {

    private LabelsAndLinksPage labelsAndLinksPage;

    @BeforeClass
    public void setUp() {
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        labelsAndLinksPage = new LabelsAndLinksPage(driver);
    }

    @Test(priority = 1, description = "Verify Mobile Labels are present")
    public void testMobileLabelsPresence() {
        assert labelsAndLinksPage.areMobileLabelsPresent() : "Not all mobile labels are present.";
    }

    @Test(priority = 2, description = "Verify Laptop Links are present")
    public void testLaptopLinksPresence() {
        assert labelsAndLinksPage.areLaptopLinksPresent() : "Not all laptop links are present.";
    }

    @Test(priority = 3, description = "Verify there are no broken links")
    public void testBrokenLinks() {
        assert labelsAndLinksPage.checkAllBrokenLinks() : "There are broken links present.";
    }


}
