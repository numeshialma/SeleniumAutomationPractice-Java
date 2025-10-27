package tests.blogspotPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.blogspotPage.DatePicker3Page;
import utils.TestBase;

public class DatePicker3Test extends TestBase {

    private DatePicker3Page datePicker3Page;

    @BeforeClass
    public void setUp() {
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        datePicker3Page = new DatePicker3Page(driver);
    }

    @Test
    public void dummyTest() {
        datePicker3Page.enterDateRange("10/25/2025", "10/30/2025");
    }

    @Test
    public void dummyTest2() {
        datePicker3Page.setDateRange("12/01/2024", "12/15/2024");
    }
}
