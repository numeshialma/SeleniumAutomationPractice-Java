package pages.blogspotPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestBase;

public class DatePicker1Page extends TestBase {

    WebDriver driver;

    public DatePicker1Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "datepicker")
    private WebElement datePicker1;

    @FindBy(xpath = "//span[@class='ui-datepicker-month']")
    private WebElement month;

    @FindBy(xpath = "//span[@class='ui-datepicker-year']")
    private WebElement year;

    @FindBy(xpath = "//span[text()='Next']")
    private WebElement nextButton;

    @FindBy(xpath = "//span[text()='Prev']")
    private WebElement prevButton;

    // Open DatePicker 1
    public void openDatePicker1() {
        scrollToElement(datePicker1);
        datePicker1.click();
    }

    public void selectMonthYear(String targetMonth, String targetYear, boolean isNext) {
        while (true) {
            String currentMonth = month.getText();
            String currentYear = year.getText();

            if (currentMonth.equals(targetMonth) && currentYear.equals(targetYear)) {
                break;
            } else {
                if (isNext) {
                    nextButton.click();
                } else {
                    prevButton.click();
                }
            }
        }
    }

    public void selectDay(String day) {
        WebElement dayElement = driver.findElement(By.xpath("//a[text()='" + day + "']"));
        dayElement.click();
    }

    public void selectDate(String targetMonth, String targetYear, String day, boolean isNext) {
        openDatePicker1();
        selectMonthYear(targetMonth, targetYear, isNext);
        selectDay(day);
    }

}
