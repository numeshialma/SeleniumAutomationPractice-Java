package tests.blogspotPage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.blogspotPage.DatePickerPage;
import pages.blogspotPage.DropDownPage;
import utils.TestBase;

public class DatePickerTest extends TestBase {

    private DatePickerPage datePickerPage;

    @BeforeClass
    public void setUp() {
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        datePickerPage = new DatePickerPage(driver);
    }

    @Test(priority = 1, description = "Verify date picker 1 functionality - Using sendKeys")
    public void testDatePicker1Functionality() {
        datePickerPage.enterDatePicker1("10/15/2024");
        Assert.assertEquals(datePickerPage.getDatePicker1Value(), "10/15/2024", "Date Picker 1 should accept the input date.");
    }

    @Test(priority = 2, description = "Verify date picker 2 functionality")
    public void testDatePicker2Functionality() {
        datePickerPage.enterDatePicker2("11/20/2024");
        Assert.assertEquals(datePickerPage.getDatePicker2Value(), "11/20/2024", "Date Picker 2 should accept the input date.");
    }

    @Test(priority = 2, description = "Verify date range picker functionality")
    public void testDateRangePickerFunctionality() {
        datePickerPage.enterDateRange("10/01/2024", "10/15/2024");

        Assert.assertEquals(datePickerPage.getDatePicker1Value(), "10/01/2024", "Start Date should be set correctly.");
        Assert.assertEquals(datePickerPage.getDatePicker2Value(), "10/15/2024", "End Date should be set correctly.");
    }

    @AfterMethod
    public void resetForm(){
        driver.navigate().refresh();
    }
}
