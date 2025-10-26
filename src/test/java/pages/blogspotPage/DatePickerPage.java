package pages.blogspotPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestBase;

public class DatePickerPage extends TestBase {

    WebDriver driver;

    public DatePickerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "datepicker")
    private WebElement datePicker1;

    @FindBy(id = "txtDate")
    private WebElement datePicker2;

    @FindBy(id = "start-date")
    private WebElement startDateRange;

    @FindBy(id = "end-date")
    private WebElement endDateRange;

    @FindBy(xpath = "//button[text()='Submit'][@class='submit-btn']")
    private WebElement submitButton;

    public void enterDatePicker1(String date) {
        scrollToElement(datePicker1);
        datePicker1.clear();
        datePicker1.sendKeys(date);
    }

    public void enterDatePicker2(String date) {
        scrollToElement(datePicker2);
//        datePicker2.clear();
        datePicker2.sendKeys(date);
    }

    public void enterDateRange(String startDate, String endDate) {
        scrollToElement(startDateRange);
        startDateRange.clear();
        startDateRange.sendKeys(startDate);
        endDateRange.clear();
        endDateRange.sendKeys(endDate);
    }

    public void clickSubmit() {
        scrollToElement(submitButton);
        submitButton.click();
    }

    public String getDatePicker1Value() {
        return datePicker1.getAttribute("value");
    }

    public String getDatePicker2Value() {
        return datePicker2.getAttribute("value");
    }

    public String getStartDateRangeValue() {
        return startDateRange.getAttribute("value");
    }

    public String getEndDateRangeValue() {
        return endDateRange.getAttribute("value");
    }

}
