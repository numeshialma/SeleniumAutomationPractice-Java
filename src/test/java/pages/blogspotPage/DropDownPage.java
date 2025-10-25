package pages.blogspotPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.TestBase;

import java.util.List;
import java.util.stream.Collectors;

public class DropDownPage extends TestBase {

    WebDriver driver;

    public DropDownPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "colors")
    private WebElement colorDropDown;

    @FindBy(id = "animals")
    private WebElement sortedListDropDown;

    public void selectColorByVisibleText(String color) {
        Select select = new Select(colorDropDown);
        select.selectByVisibleText(color);
    }

    public void selectColorByIndex(int index) {
        Select select = new Select(colorDropDown);
        select.selectByIndex(index);
    }

    public void selectColorByValue(String value) {
        Select select = new Select(colorDropDown);
        select.selectByValue(value);
    }

    public String getSelectedColor() {
        Select select = new Select(colorDropDown);
        return select.getFirstSelectedOption().getText();
    }

    public void selectSortedListByVisibleText(String text) {
        Select select = new Select(sortedListDropDown);
        select.selectByVisibleText(text);
    }

    public void selectSortedListByIndex(int index) {
        Select select = new Select(sortedListDropDown);
        select.selectByIndex(index);
    }

    public void selectSortedListByValue(String value) {
        Select select = new Select(sortedListDropDown);
        select.selectByValue(value);
    }

    public String getSelectedSortedListOption() {
        Select select = new Select(sortedListDropDown);
        return select.getFirstSelectedOption().getText();
    }

    // multiple selection methods
    public void selectMultipleColors(String... colors) {
        Select select = new Select(sortedListDropDown);
        Actions actions = new Actions(driver);
        actions.keyDown(org.openqa.selenium.Keys.CONTROL);

        for (String color : colors) {
            select.selectByVisibleText(color);
        }

        actions.keyUp(Keys.CONTROL).build().perform();
    }

    public void selectMultipleAnimals(String... animals) {
        Select select = new Select(sortedListDropDown);
        Actions actions = new Actions(driver);
        actions.keyDown(org.openqa.selenium.Keys.CONTROL);

        for (String animal : animals) {
            select.selectByVisibleText(animal);
        }

        actions.keyUp(Keys.CONTROL).build().perform();
    }

    // to get selected items
    public List<String> getSelectedColors(){
        return new Select(colorDropDown).getAllSelectedOptions().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getSelectedAnimals(){
        return new Select(sortedListDropDown).getAllSelectedOptions().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

}
