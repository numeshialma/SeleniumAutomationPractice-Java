package pages.blogspotPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestBase;

public class AlertsPage extends TestBase {

    WebDriver driver;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "alertBtn")
    private WebElement simpleAlertButton;

    @FindBy(id = "confirmBtn")
    private WebElement confirmationAlertButton;

    @FindBy(id = "promptBtn")
    private WebElement promptAlertButton;

    @FindBy(id = "demo")
    private WebElement alertResult;



    // Simple Alert
    public void clickSimpleAlert(){
//        scrollToElement(simpleAlertButton);
        simpleAlertButton.click();
        driver.switchTo().alert().accept();
    }

    // Confirmation Alert
    public void clickConfirmationAlertOk() {
//        scrollToElement(confirmationAlertButton);
        confirmationAlertButton.click();
        driver.switchTo().alert().accept();
    }

    public void clickConfirmationAlertCancel() {
//        scrollToElement(confirmationAlertButton);
        confirmationAlertButton.click();
        driver.switchTo().alert().dismiss();
    }

    // Prompt Alert
    public void clickPromptAlert(String text) {
//        scrollToElement(promptAlertButton);
        promptAlertButton.click();
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
    }

    public void clickPromptAlertCancel() {
//        scrollToElement(promptAlertButton);
        promptAlertButton.click();
        driver.switchTo().alert().dismiss();
    }

    public String getPromptResultText() {
        scrollToElement(alertResult);
        return alertResult.getText();
    }


    // for toaster messages and alert text
    @FindBy(id = "alertMessage")
    private WebElement alertMessage;
    public String getAlertMessageText() {
        return alertMessage.getText();
    }


}
