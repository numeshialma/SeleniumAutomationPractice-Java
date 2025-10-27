package pages.blogspotPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestBase;

public class DynamicElementPage extends TestBase {

    WebDriver driver;

    public DynamicElementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='START']")
    private WebElement dynamicStartButton;

    @FindBy(xpath = "//button[text()='STOP']")
    private WebElement dynamicStopButton;


    // Dynamic Button
    public void clickDynamicStart(){
        scrollToElement(dynamicStartButton);
        dynamicStartButton.click();
    }

    public void clickDynamicStop(){
        scrollToElement(dynamicStopButton);
        dynamicStopButton.click();
    }

    public boolean isDynamicStopButtonDisplayed(){
        scrollToElement(dynamicStopButton);
        return dynamicStopButton.isDisplayed();
    }

    public boolean isDynamicStartButtonDisplayed(){
        scrollToElement(dynamicStartButton);
        return dynamicStartButton.isDisplayed();
    }


    // Approach 2

    @FindBy(xpath = "//button[@onclick='toggleButton(this)']")
    private WebElement dynamicButton;

    public void clickDynamicButton(){
        scrollToElement(dynamicButton);
        dynamicButton.click();
    }

    public String getDynamicButtonText(){
        scrollToElement(dynamicButton);
        return dynamicButton.getText();
    }


}
