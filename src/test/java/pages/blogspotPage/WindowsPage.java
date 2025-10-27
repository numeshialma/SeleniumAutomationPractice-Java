package pages.blogspotPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestBase;

import java.util.Set;

public class WindowsPage extends TestBase {

    WebDriver driver;

    public WindowsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='New Tab']")
    private WebElement newTabButton;

    @FindBy(id = "PopUp")
    private WebElement newWindowButton;


    // New Tab
    public void clickNewTabButton(){
        String originalWindow = driver.getWindowHandle();
        newTabButton.click();

        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void closeTabAndSwitchBack(){
        String originalWindow = driver.getWindowHandles().iterator().next();
        driver.close();
        driver.switchTo().window(originalWindow);
    }

    public boolean isNewTabOpened(){
//        return driver.getTitle().contains("Google");
        return driver.getCurrentUrl().equals("https://www.pavantestingtools.com/");
    }

    public boolean isOriginalTabActive(){
        return driver.getCurrentUrl().equals("https://testautomationpractice.blogspot.com/");
    }


    // New Window
    public void clickNewWindowButton(){
        String originalWindow = driver.getWindowHandle();
        newWindowButton.click();

        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public boolean isNewWindowOpened(){
//        return driver.getTitle().contains("Google");
//        return driver.getCurrentUrl().equals("https://www.selenium.dev/") || driver.getCurrentUrl().equals("https://playwright.dev/");
        String url = driver.getCurrentUrl();
        return url.equals("https://www.selenium.dev/") || url.equals("https://playwright.dev/");
    }

    public void closeWindowAndSwitchBack(){
        String originalWindow = driver.getWindowHandles().iterator().next();
        driver.close();
        driver.switchTo().window(originalWindow);
    }

    public boolean isOriginalWindowActive(){
        return driver.getCurrentUrl().equals("https://testautomationpractice.blogspot.com/");
    }

    public void closeSpecificWindow(String urlToClose) {
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String windowHandle : allWindows) {
            driver.switchTo().window(windowHandle);
            if (driver.getCurrentUrl().equals(urlToClose)) {
                driver.close();
                break;
            }
        }

//        driver.switchTo().window(originalWindow);

        Set<String> remainingWindows = driver.getWindowHandles();
        for (String handle : remainingWindows) {
            driver.switchTo().window(handle);
            if (driver.getCurrentUrl().contains("testautomationpractice.blogspot.com")) {
                break;
            }
        }
    }

}
