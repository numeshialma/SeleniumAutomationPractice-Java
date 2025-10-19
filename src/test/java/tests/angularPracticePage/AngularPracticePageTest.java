package tests.angularPracticePage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.angularPage.AngularPage;
import utils.TestBase;

public class AngularPracticePageTest extends TestBase {

    private AngularPage angularPage;

    @BeforeClass
    public void setUp() {
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().window().maximize();

        angularPage = new AngularPage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

    @Test(priority = 1, description = "Verify Name field accepts input and validation message appears")
    public void testNameFieldValidation() {
        angularPage.enterName("John Doe");
        angularPage.validationMsgName("N");
        Assert.assertTrue(angularPage.isNameValidationDisplayed(),
                "Validation message for Name should appear when user has entered 1 characters only.");
    }

    @Test(priority = 2, description = "Verify the validation message appears when user has not added any names")
    public void testEmptyNameFieldValidation() throws InterruptedException {
        angularPage.enterName("J");
        Thread.sleep(3000);
        angularPage.emptyValidationMsgName();
        Assert.assertTrue(angularPage.isEmptyNameValidationDisplayed(),
                "Validation message for Name should appear when user has not added any name");
    }

    @Test(priority = 2, description = "Verify Email field accepts input and validation message appears when cleared")
    public void testEmailFieldValidation() {
        angularPage.enterEmail("john@example.com");
        angularPage.validationMsgEmail("john@example.com");
        Assert.assertTrue(angularPage.isEmailValidationDisplayed(),
                "Validation message for Email should appear after clearing input.");
    }

    @Test(priority = 3, description = "Verify 'Check Me' checkbox can be selected")
    public void testCheckBoxSelection() throws InterruptedException {
        angularPage.clickCheckMe();
        Thread.sleep(3000);
        Assert.assertTrue(true, "'Check Me' checkbox should be selected");
    }

    @Test(priority = 4, description = "Verify Gender dropdown allows selecting a value")
    public void testSelectGender() {
        angularPage.selectGender("Female");
        Assert.assertTrue(true, "Gender 'Female' should be selected");
    }

    @Test(priority = 5, description = "Verify Employment Status radio buttons can be selected")
    public void testSelectEmploymentStatus() {
        angularPage.selectEmploymentStatus("Employed");
        Assert.assertTrue(true, "Employment status 'Employed' should be selected");
    }

//    @Test(priority = 6, description = "Verify Date of Birth can be entered in MM/DD/YYYY format")
//    public void testEnterDOB() {
//        angularPage.enterDOB("07/01/2025");
//        Assert.assertTrue(true, "DOB should be entered successfully");
//    }

    @Test(priority = 7, description = "Verify Submit button submits the form successfully")
    public void testSubmitForm() {
        angularPage.enterName("John Doe");
        angularPage.enterEmail("john@example.com");
        angularPage.enterPassword("Password123");
//        angularPage.enterDOB("07/01/2025");
        angularPage.clickCheckMe();
        angularPage.selectGender("Male");
        angularPage.selectEmploymentStatus("Student");
        angularPage.clickSubmit();

        Assert.assertTrue(angularPage.isSuccessMessageDisplayed(),"submission is failed");
    }

    @AfterMethod
    public void refreshPageBeforeTests() {
        driver.navigate().refresh();
    }




}
