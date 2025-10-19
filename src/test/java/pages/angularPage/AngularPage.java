package pages.angularPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.TestBase;
import utils.elements.angularPageElements.AngularPageElements;

import java.util.List;

public class AngularPage extends TestBase {

    WebDriver driver;

    public AngularPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = AngularPageElements.nameElement)
    private WebElement nameInput;

    @FindBy(xpath = AngularPageElements.nameValidationElement)
    private WebElement nameValidation;

    @FindBy(xpath = AngularPageElements.nameValidationElement2)
    private WebElement nameValidation2;

    @FindBy(xpath = AngularPageElements.emailElement)
    private WebElement emailInput;

    @FindBy(xpath = AngularPageElements.emailValidationElement)
    private WebElement emailValidation;

    @FindBy(xpath = AngularPageElements.passwordElement)
    private WebElement passwordInput;

    @FindBy(xpath = AngularPageElements.checkMeCheckBoxElement)
    private WebElement checkMeCheckBox;

    @FindBy(id = AngularPageElements.genderElement)
    private WebElement genderDropdown;

    @FindBy(xpath = AngularPageElements.genderOptionElements)
    private WebElement genderOptions;

    @FindBy(xpath = AngularPageElements.employmentStatusElement)
    private List<WebElement> employmentStatusOptions;

    @FindBy(xpath = AngularPageElements.dOBElement)
    private WebElement dobInput;

    @FindBy(xpath = AngularPageElements.submitButtonElement)
    private WebElement submitButton;

    @FindBy(xpath = AngularPageElements.shopElement)
    private WebElement shopButton;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement successfullySubmitMessage;


    public void enterName(String name){
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterEmail(String email){
        emailInput.clear(); emailInput.sendKeys(email);
    }

    public void enterPassword(String password){
        passwordInput.clear(); passwordInput.sendKeys(password);
    }

    public void clickCheckMe(){
        if(!checkMeCheckBox.isSelected()){
            checkMeCheckBox.click(); }
    }

    public void selectGender(String gender){
        scrollToElement(genderDropdown);
        Select genderOption = new Select(genderOptions);
        genderOption.selectByVisibleText(gender);
    }

    public void selectEmploymentStatus(String statusText){
        scrollDown();
        for(WebElement option : employmentStatusOptions){
            if(option.isEnabled() && option.getText().equalsIgnoreCase(statusText)){
                option.click(); break; }
        }
    }

    /** RECOMMENDED METHOD: Direct input (Most reliable for interviews)
     * Enter date directly in MM/DD/YYYY format
     * @param date - Format: "07/01/2025"
     */
    public void enterDOB(String date) {
        dobInput.sendKeys(date);
    }

    /** Overloaded method: Build date from components
     * @param month - "07" (two digits)
     * @param day - "01" (two digits)
     * @param year - "2025"
     */ public void enterDOB(String month, String day, String year) {
        String dateString = month + "/" + day + "/" + year;
        dobInput.clear();
        dobInput.sendKeys(dateString);
    }

    public AngularPage clickSubmit(){
        waitForElementClickable(submitButton);
        submitButton.click();
        return new AngularPage(driver);
    }

    public void validationMsgName(String name){
        nameInput.clear();
        nameInput.sendKeys(name);
        waitForElementVisible(nameValidation2);
    }

    public void emptyValidationMsgName(){
//        nameInput.clear();
        nameInput.sendKeys(Keys.BACK_SPACE);
        waitForElementVisible(nameValidation);
    }

    public void validationMsgEmail(String email){
        emailInput.sendKeys(email);
        emailInput.clear();
        waitForElementVisible(emailValidation);
    }

    public boolean isNameValidationDisplayed(){
         waitForElementVisible(nameValidation2);
        return nameValidation2.isDisplayed();
    }

    public boolean isEmptyNameValidationDisplayed(){
        waitForElementVisible(nameValidation);
        return nameValidation.isDisplayed();
    }

    public boolean isEmailValidationDisplayed(){
         waitForElementVisible(emailValidation);
         return emailValidation.isDisplayed();
    }

    public boolean isSuccessMessageDisplayed(){
         waitForElementVisible(successfullySubmitMessage);
         return successfullySubmitMessage.isDisplayed();
    }
}
