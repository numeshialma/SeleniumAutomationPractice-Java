package tests.blogspotPage;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.TestBase;

public class DatePicker1Test extends TestBase {

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
       String year = "2027";
       String month = "December";
       String day = "25";

       driver.findElement(By.id("datepicker")).click();

       while (true){
           String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
              String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

              if (currentMonth.equals(month) && currentYear.equals(year)){
                  break;
              } else {
                  driver.findElement(By.xpath("//span[text()='Next']")).click();
              }
       }
    }

    @Test
    public void dummyTest2() {
        String year = "2024";
        String month = "December";
        String day = "23";

        driver.findElement(By.id("datepicker")).click();

        while (true){
            String currentMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
            String currentYear = driver.findElement(By.className("ui-datepicker-year")).getText();

            if (currentMonth.equals(month) && currentYear.equals(year)){
                break;
            } else {
                driver.findElement(By.xpath("//span[text()='Prev']")).click();
            }
        }
    }

}
