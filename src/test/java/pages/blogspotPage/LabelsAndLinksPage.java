package pages.blogspotPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestBase;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class LabelsAndLinksPage extends TestBase {

    WebDriver driver;

    public LabelsAndLinksPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[text()='Labels and Links']")
    private List<WebElement> mobileLabels;

    @FindBy(xpath = "//a[text()='Blogger']")
    private List<WebElement> laptopLink;

    @FindBy(xpath = "//a[text()='Blogspot']")
    private List<WebElement> brokenLinks;

    public boolean areMobileLabelsPresent() {
        for(WebElement label : mobileLabels) {
            if(!label.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean areLaptopLinksPresent() {
        for(WebElement link : laptopLink) {
            if(!link.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean checkAllBrokenLinks() {
        boolean allLinksValid = true;
        for(WebElement link : brokenLinks) {
            String url = link.getAttribute("href");
            if(url == null || url.isEmpty() ){
                allLinksValid = false;
                continue;
            }
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();
                int responseCode = connection.getResponseCode();
                if(responseCode >= 400) {
                    allLinksValid = false;
                }
            } catch (IOException e) {
                allLinksValid = false;
            }
        }
        return allLinksValid;
    }

}
