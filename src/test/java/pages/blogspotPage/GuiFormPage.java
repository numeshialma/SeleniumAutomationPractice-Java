package pages.blogspotPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.TestBase;

import java.util.List;
import java.util.NoSuchElementException;

public class GuiFormPage extends TestBase {

    WebDriver driver;

    public GuiFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "phone")
    private WebElement phoneInput;

    @FindBy(id = "textarea")
    private WebElement addressInput;

    @FindBy(xpath = "//input[@class='form-check-input'][@type='radio']")
    private List<WebElement> genderOptions;

    @FindBy(xpath = "//input[@class='form-check-input'][@type='checkbox']")
    private List<WebElement> daysCheckboxes;

    @FindBy(id = "country")
    private WebElement countryDropdown;

//    @FindBy(xpath = "")
//    private WebElement nameInput;
//
//    @FindBy(xpath = "")
//    private WebElement nameInput;


/** -------Input Methods------- */
    public void enterName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPhone(String phone) {
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void enterAddress(String address) {
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    // Verify text field values
    public String getName() {
        return nameInput.getAttribute("value");
    }

    public String getEmail() {
        return emailInput.getAttribute("value");
    }

    public String getPhone() {
        return phoneInput.getAttribute("value");
    }

    public String getAddress() {
        return addressInput.getAttribute("value");
    }

    // Verify placeholders
    public boolean isNamePlaceholderPresent() {
        String placeholder = nameInput.getAttribute("placeholder");
        return placeholder != null && !placeholder.isEmpty();
    }

    public boolean isEmailPlaceholderPresent() {
        String placeholder = emailInput.getAttribute("placeholder");
        return placeholder != null && !placeholder.isEmpty();
    }

    public boolean isPhonePlaceholderPresent() {
        String placeholder = phoneInput.getAttribute("placeholder");
        return placeholder != null && !placeholder.isEmpty();
    }


/** -------Radio button Methods------- */
    // Select by text
    public void selectGender(String gender){
        scrollToElement(genderOptions.get(0));
        boolean clicked = false;
        for (WebElement genderOption : genderOptions){
            if(!genderOption.isSelected()){
                genderOption.click();
                clicked = true;
                break;
            }
        }
        if (!clicked) {
            throw new NoSuchElementException("No gender option found to select.");
        }
    }

    // Select by value
    public void selectGenderByIndex(int index){
        scrollToElement(genderOptions.get(0));
        if (index<0 || index>=genderOptions.size()){
            throw new IndexOutOfBoundsException("Invalid gender index: " + index);
        }
        WebElement gender = genderOptions.get(index);
        if (!gender.isSelected()){
            gender.click();
        }
    }

    // Verify selected gender
    public String getSelectedGender(){
        scrollToElement(genderOptions.get(0));
        for (WebElement genderOption : genderOptions){
            if (genderOption.isSelected()){
                return genderOption.getAttribute("value");
            }
        }
        return null;
    }


/** -------CheckBox Methods------- */

    // Select by text
    public void selectDayByText(String day){
        scrollToElement(daysCheckboxes.get(0));
        boolean clicked = false;
        for (WebElement dayCheckbox : daysCheckboxes){
            if (dayCheckbox.getAttribute("value").equalsIgnoreCase(day)){
                if(!dayCheckbox.isSelected()){
                    dayCheckbox.click();
                }
                clicked = true;
                break;
            }
        }
        if (!clicked) {
            throw new NoSuchElementException("Day checkbox with value '" + day + "' not found.");
        }
    }

    // Select by index
    public void selectDayByIndex(int index){
        scrollToElement(daysCheckboxes.get(0));
        if(index >= 0 && index < daysCheckboxes.size()){
            WebElement dayCheckbox = daysCheckboxes.get(index);
            if(!dayCheckbox.isSelected()){
                dayCheckbox.click();
            }
        } else {
            throw new IndexOutOfBoundsException("Invalid index for day checkbox selection.");
        }
    }

    // Verify selected days
    public List<String> getSelectedDays() {
        scrollToElement(daysCheckboxes.get(0));
        List<String> selectedDays = new java.util.ArrayList<>();
        for (WebElement dayCheckbox : daysCheckboxes) {
            if (dayCheckbox.isSelected()) {
                selectedDays.add(dayCheckbox.getAttribute("value"));
            }
        }
        return selectedDays;
    }

    // Verify none selected
    public boolean areNoDaysSelected() {
        scrollToElement(daysCheckboxes.get(0));
        for (WebElement dayCheckbox : daysCheckboxes) {
            if (dayCheckbox.isSelected()) {
                return false;
            }
        }
        return true;
    }

    // Select all checkboxes
    public void selectAllDays(){
        scrollToElement(daysCheckboxes.get(0));
        for (WebElement dayCheckbox : daysCheckboxes){
            if (!dayCheckbox.isSelected()){
                dayCheckbox.click();
            }
        }
    }

    // Select random checkboxes
    public void selectRandomDays(int numberOfDays){
        scrollToElement(daysCheckboxes.get(0));
        if (numberOfDays < 1 || numberOfDays > daysCheckboxes.size()){
            throw new IllegalArgumentException("Invalid number of days to select: " + numberOfDays);
        }
        java.util.Collections.shuffle(daysCheckboxes);
        for (int i = 0; i < numberOfDays; i++){
            WebElement dayCheckbox = daysCheckboxes.get(i);
            if (!dayCheckbox.isSelected()){
                dayCheckbox.click();
            }
        }
    }

    // Select first N checkboxes
    public void selectFirstNDays(int n){
        scrollToElement(daysCheckboxes.get(0));
        if (n < 1 || n > daysCheckboxes.size()){
            throw new IllegalArgumentException("Invalid number of days to select: " + n);
        }
        for (int i = 0; i < n; i++){
            WebElement dayCheckbox = daysCheckboxes.get(i);
            if (!dayCheckbox.isSelected()){
                dayCheckbox.click();
            }
        }
    }

    // Select last N checkboxes
    public void selectLastNDays(int n){
        scrollToElement(daysCheckboxes.get(0));
        if (n < 1 || n > daysCheckboxes.size()){
            throw new IllegalArgumentException("Invalid number of days to select: " + n);
        }
        for (int i = daysCheckboxes.size() - n; i < daysCheckboxes.size(); i++){
            WebElement dayCheckbox = daysCheckboxes.get(i);
            if (!dayCheckbox.isSelected()){
                dayCheckbox.click();
            }
        }
    }

    // Deselect all checkboxes
    public void deselectAllDays() {
        scrollToElement(daysCheckboxes.get(0));
        for (WebElement dayCheckbox : daysCheckboxes) {
            if (dayCheckbox.isSelected()) {
                dayCheckbox.click();
            }
        }
    }

    // Deselect by text
    public void deselectDayByText(String day) {
        scrollToElement(daysCheckboxes.get(0));
        boolean found = false;
        for (WebElement dayCheckbox : daysCheckboxes) {
            if (dayCheckbox.getAttribute("value").equalsIgnoreCase(day)) {
                if (dayCheckbox.isSelected()) {
                    dayCheckbox.click();
                }
                found = true;
                break;
            }
        }
        if (!found) {
            throw new NoSuchElementException("Day checkbox with value '" + day + "' not found.");
        }
    }

    // Deselect by index
    public void deselectDayByIndex(int index) {
        scrollToElement(daysCheckboxes.get(0));
        if (index >= 0 && index < daysCheckboxes.size()) {
            WebElement dayCheckbox = daysCheckboxes.get(index);
            if (dayCheckbox.isSelected()) {
                dayCheckbox.click();
            }
        } else {
            throw new IndexOutOfBoundsException("Invalid index for day checkbox deselection.");
        }
    }

    // select first and last checkboxes
    public void selectFirstAndLastDays() {
        scrollToElement(daysCheckboxes.get(0));
        if (daysCheckboxes.size() >= 1) {
            WebElement firstDay = daysCheckboxes.get(0);
            if (!firstDay.isSelected()) {
                firstDay.click();
            }
        }
        if (daysCheckboxes.size() >= 2) {
            WebElement lastDay = daysCheckboxes.get(daysCheckboxes.size() - 1);
            if (!lastDay.isSelected()) {
                lastDay.click();
            }
        }
    }


/** -------DropDown Methods------- */

    // country dropdown selection by visible text
    public void selectCountry(String countryName) {
        scrollToElement(countryDropdown);
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText(countryName);
    }

    // country dropdown selection by value
    public void selectCountryByValue(String countryValue) {
        scrollToElement(countryDropdown);
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByValue(countryValue);
    }

    // country dropdown selection by index
    public void selectCountryByIndex(int index) {
        scrollToElement(countryDropdown);
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByIndex(index);
    }

    // Verify selected country
    public String getSelectedCountry() {
        Select countrySelect = new Select(countryDropdown);
        return countrySelect.getFirstSelectedOption().getText();
    }






}
