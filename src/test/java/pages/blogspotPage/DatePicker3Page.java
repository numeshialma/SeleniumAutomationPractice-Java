package pages.blogspotPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestBase;

public class DatePicker3Page extends TestBase {

    WebDriver driver;

    public DatePicker3Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "start-date")
    private WebElement startDateRange;

    @FindBy(id = "end-date")
    private WebElement endDateRange;

    @FindBy(xpath = "//button[text()='Submit'][@class='submit-btn']")
    private WebElement submitButton;

    public void enterDateRange(String startDate, String endDate) {
        scrollToElement(startDateRange);
        startDateRange.clear();
        startDateRange.sendKeys(startDate);
        endDateRange.clear();
        endDateRange.sendKeys(endDate);
    }

    // using JS to set date range
    public void setDateRange(String startDate, String endDate) {
        scrollToElement(startDateRange);

        jsSetValue(startDateRange, startDate);
        jsSetValue(endDateRange, endDate);
    }

    public void clickSubmit() {
        scrollToElement(submitButton);
        submitButton.click();
    }

    public void jsSetValue(WebElement element, String value) {
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].value = arguments[1];", element, value);
    }
}
