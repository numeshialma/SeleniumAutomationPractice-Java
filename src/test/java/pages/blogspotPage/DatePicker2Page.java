package pages.blogspotPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.TestBase;

public class DatePicker2Page extends TestBase {

    WebDriver driver;

    public DatePicker2Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "txtDate")
    private WebElement datePicker2;

    @FindBy(xpath = "//select[@aria-label='Select month']")
    private WebElement monthDropDown;

    @FindBy(xpath = "//select[@aria-label='Select year']")
    private WebElement yearDropDown;

    // Open DatePicker 2
    public void openDatePicker2() {
        scrollToElement(datePicker2);
        datePicker2.click();
    }

    public void selectMonth(String month) {
        Select monthSelect = new Select(monthDropDown);
        monthSelect.selectByVisibleText(month);
    }

    public void selectYear(String year) {
        Select yearSelect = new Select(yearDropDown);
        yearSelect.selectByVisibleText(year);
    }

    public void selectDay(String day) {
        WebElement dayElement = driver.findElement(By.xpath("//a[text()='" + day + "']"));
        dayElement.click();
    }

    public void selectDate(String month, String year, String day) {
        selectMonth(month);
        selectYear(year);
        selectDay(day);
    }

}
