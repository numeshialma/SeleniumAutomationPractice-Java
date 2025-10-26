package tests.blogspotPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.blogspotPage.DatePicker2Page;
import utils.TestBase;

public class DatePicker2Test extends TestBase {

    @BeforeClass
    public void setUp() {
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        if(driver!=null){
            driver.close();
        }
    }

    @Test
    public void dummyTest() {
        DatePicker2Page datePicker2Page = new DatePicker2Page(driver);
        String year = "2027";
        String month = "Dec";
        String day = "25";
        datePicker2Page.openDatePicker2();
        datePicker2Page.selectDate(month, year, day);

    }

}
