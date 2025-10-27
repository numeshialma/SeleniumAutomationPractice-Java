package pages.blogspotPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestBase;

import java.util.List;

public class SearchPage extends TestBase {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Wikipedia1_wikipedia-search-input")
    private WebElement searchBox;

    @FindBy(xpath = "//input[@type='submit'][@class='wikipedia-search-button']")
    private WebElement searchButton;

    @FindBy(id = "Wikipedia1_wikipedia-search-results")
    private WebElement validateMessage;

    @FindBy(id = "Wikipedia1_wikipedia-search-results")
    private WebElement searchResults;

    // Search Functionality
    public void enterSearchText(String text){
        searchBox.clear();
        searchBox.sendKeys(text);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public boolean isSearchResultDisplayed(){
        return searchResults.isDisplayed();
    }

    public boolean isValidateMessageDisplayed(){
        return validateMessage.isDisplayed();
    }

}
