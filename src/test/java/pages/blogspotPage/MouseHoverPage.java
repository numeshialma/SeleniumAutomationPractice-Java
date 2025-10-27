package pages.blogspotPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestBase;

public class MouseHoverPage extends TestBase {

    WebDriver driver;
    Actions actions;

    public MouseHoverPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    @FindBy(xpath = "//button[text()='Point Me']")
    private WebElement pointMeButton;

    @FindBy(xpath = "//a[text()='Mobiles']")
    private WebElement mobilesOption;

    @FindBy(xpath = "//a[text()='Laptops']")
    private WebElement laptopsOption;


    // Mouse Hover Functionality
    public void hoverOverPointMe(){
        scrollToElement(pointMeButton);
        actions.moveToElement(pointMeButton).perform();
    }

    public void clickMobilesOption(){
        scrollToElement(mobilesOption);
        actions.moveToElement(mobilesOption).click().perform();
    }

    public void clickLaptopsOption(){
        scrollToElement(laptopsOption);
        actions.moveToElement(laptopsOption).click().perform();
    }

    public boolean isMouseHoverOptionsDisplayed(){
        return mobilesOption.isDisplayed() && laptopsOption.isDisplayed();
    }

    public boolean isMoiblesOptionClicked(){
        return mobilesOption.isEnabled();
    }

    public boolean isLaptopsOptionClicked(){
        return laptopsOption.isEnabled();
    }




}
