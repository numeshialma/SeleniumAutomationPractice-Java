package tests.blogspotPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.blogspotPage.GuiFormPage;
import pages.blogspotPage.SearchPage;
import utils.TestBase;

public class SearchTest extends TestBase {

    private SearchPage searchPage;

    @BeforeClass
    public void setUp() {
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        searchPage = new SearchPage(driver);
    }

    @Test(priority = 1, description = "Verify search functionality with valid input")
    public void testSearchFunctionality() {
        String text = "Selenium";
        searchPage.enterSearchText(text);
        searchPage.clickSearchButton();

        Assert.assertTrue(searchPage.isSearchResultDisplayed(), "Search results should be displayed for valid input.");
    }

    @Test(priority = 2, description = "Verify search functionality with empty input")
    public void testSearchWithEmptyInput() {
        searchPage.enterSearchText("");
        searchPage.clickSearchButton();

        Assert.assertTrue(searchPage.isValidateMessageDisplayed(), "Validation message should be displayed.");
    }


    @AfterMethod
    public void resetForm(){
        driver.navigate().refresh();
    }
}
