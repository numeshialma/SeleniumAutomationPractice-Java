package tests.blogspotPage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.blogspotPage.GuiFormPage;
import utils.TestBase;

import java.util.List;

public class GuiFormTest extends TestBase {

    private GuiFormPage guiFormPage;

    @BeforeClass
    public void setUp() {
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        guiFormPage = new GuiFormPage(driver);
    }

    @AfterClass
    public void tearDown(){
        if(driver!=null){
            driver.close();
        }
    }

    //
    @Test(priority = 1, description = "Verify Name field accepts input")
    public void testNameFieldInput() {
        guiFormPage.enterName("John Doe");
        Assert.assertEquals("John Doe", "John Doe", "Name field should accept input.");
        Assert.assertEquals("John Doe", guiFormPage.getName(), "Name field should accept input.");
    }

    @Test(priority = 2, description = "Verify Email field accepts input")
    public void testEmailFieldInput(){
        guiFormPage.enterEmail("John@example.com");
        Assert.assertEquals("John@example.com", guiFormPage.getEmail(), "Email field should accept input.");
    }

    @Test(priority = 3, description = "Verify Phone field accepts input")
    public void testPhoneFieldInput() {
        guiFormPage.enterPhone("1234567890");
        Assert.assertEquals("1234567890", guiFormPage.getPhone(), "Phone field should accept input.");
    }

    @Test(priority = 4, description = "Verify Address field accepts input")
    public void testAddressFieldInput() {
        guiFormPage.enterAddress("123 Main St, Anytown, USA");
        Assert.assertEquals("123 Main St, Anytown, USA", guiFormPage.getAddress(), "Address field should accept input.");
    }

    @Test(priority = 5, description = "Verify that placeholders exist in input fields (except address).")
    public void testPlaceholdersExist() {
        Assert.assertTrue(guiFormPage.isNamePlaceholderPresent(), "Name field should have a placeholder.");
        Assert.assertTrue(guiFormPage.isEmailPlaceholderPresent(), "Email field should have a placeholder.");
        Assert.assertTrue(guiFormPage.isPhonePlaceholderPresent(), "Phone field should have a placeholder.");
    }

    @Test(priority = 6, description = "Verify no gender is selected by default")
    public void testNoGenderSelectedyDefault(){
        Assert.assertNull(guiFormPage.getSelectedGender(),"No gender should be selected by default.");
    }

    @Test(priority = 7, description = "Verify gender selection by index")
    public void testGenderByIndex(){
        guiFormPage.selectGenderByIndex(1);
        Assert.assertEquals("female",guiFormPage.getSelectedGender());
    }

    @Test(priority = 8, description = "Verify gender selection by text")
    public void testSelectGenderByText(){
        guiFormPage.selectGender("Male");
        Assert.assertEquals("male",guiFormPage.getSelectedGender());
    }

    @Test(priority = 9, description = "Verify no days are selected by default")
    public void testNoDaysSelectedByDefault(){
        Assert.assertEquals(guiFormPage.getSelectedDays().size(),0,"No days should be selected by default.");
    }

    @Test(priority = 10, description = "Verify days selection by text")
    public void testSelectDaysByText(){
        guiFormPage.selectDayByText("Monday");
        List<String> selectedDays = guiFormPage.getSelectedDays();
        Assert.assertTrue(selectedDays.contains("monday"), "Monday should be selected.");
    }

    @Test(priority = 10, description = "Verify days selection by index")
    public void testSelectDaysByIndex() throws InterruptedException {
        guiFormPage.selectDayByIndex(2); // Select Tuesday
        List<String> selectedDays = guiFormPage.getSelectedDays();
        Thread.sleep(5000);
        Assert.assertTrue(selectedDays.contains("tuesday"), "Wednesday should be selected.");
    }

    @Test(priority = 11, description = "Verify select all checkoxes")
    public void testSelectAllCheckboxes(){
        guiFormPage.selectAllDays();
        List<String> selectedDays = guiFormPage.getSelectedDays();
        Assert.assertEquals(selectedDays.size(),7,"All 7 days should be selected.");
    }

    @Test(priority = 12, description = "Verify deselect all checkoxes")
    public void testDeselectAllCheckboxes(){
        guiFormPage.deselectAllDays();
        List<String> selectedDays = guiFormPage.getSelectedDays();
        Assert.assertEquals(selectedDays.size(),0,"No days should be selected after deselecting all.");
    }

    @Test(priority = 13, description = "Verify selection of multiple checkboxes by text")
    public void testSelectMultipleCheckboxesByText(){
        guiFormPage.selectDayByText("Tuesday");
        guiFormPage.selectDayByText("Thursday");
        List<String> selectedDays = guiFormPage.getSelectedDays();
        Assert.assertTrue(selectedDays.contains("tuesday"), "Tuesday should be selected.");
        Assert.assertTrue(selectedDays.contains("thursday"), "Thursday should be selected.");
    }

    @Test(priority = 14, description = "Verify selection of multiple checkboxes by index")
    public void testSelectMultipleCheckboxesByIndex(){
        guiFormPage.selectDayByIndex(0); // Sunday
        guiFormPage.selectDayByIndex(6); // Saturday
        List<String> selectedDays = guiFormPage.getSelectedDays();
        Assert.assertTrue(selectedDays.contains("sunday"), "Sunday should be selected.");
        Assert.assertTrue(selectedDays.contains("saturday"), "Saturday should be selected.");
    }

    @Test(priority = 15, description = "Select first N days of the week and verify selection")
    public void testSelectFirstNDays(){
        int n = 3; // First 3 days: Sunday, Monday, Tuesday
        guiFormPage.selectFirstNDays(n);
        List<String> selectedDays = guiFormPage.getSelectedDays();
        Assert.assertEquals(selectedDays.size(),n,"First " + n + " days should be selected.");
        Assert.assertTrue(selectedDays.contains("sunday"), "Sunday should be selected.");
        Assert.assertTrue(selectedDays.contains("monday"), "Monday should be selected.");
        Assert.assertTrue(selectedDays.contains("tuesday"), "Tuesday should be selected.");
    }

    @Test(priority = 16, description = "Select last N days of the week and verify selection")
    public void testSelectLastNDays(){
        int n = 2; // Last 2 days: Friday, Saturday
        guiFormPage.selectLastNDays(n);
        List<String> selectedDays = guiFormPage.getSelectedDays();
        Assert.assertEquals(selectedDays.size(),n,"Last " + n + " days should be selected.");
        Assert.assertTrue(selectedDays.contains("friday"), "Friday should be selected.");
        Assert.assertTrue(selectedDays.contains("saturday"), "Saturday should be selected.");
    }

    @Test(priority = 17, description = "Select random N days of the week and verify selection")
    public void testSelectRandomNDays(){
        int n = 4; // Select 4 random days
        guiFormPage.selectRandomDays(n);
        List<String> selectedDays = guiFormPage.getSelectedDays();
        Assert.assertEquals(selectedDays.size(),n,"Exactly " + n + " random days should be selected.");
    }

    @Test(priority = 18, description = "Verify selecting first and last checkboxes")
    public void testSelectFirstAndLastDays(){
        guiFormPage.selectFirstAndLastDays();
        List<String> selectedDays = guiFormPage.getSelectedDays();
        Assert.assertEquals(selectedDays.size(),2,"First and last days should be selected.");
        Assert.assertTrue(selectedDays.contains("sunday"), "Sunday should be selected.");
        Assert.assertTrue(selectedDays.contains("saturday"), "Saturday should be selected.");
    }

    @Test(priority = 19, description = "Verify deselect by text")
    public void testDeselectDayByText(){
        guiFormPage.selectAllDays();
        guiFormPage.deselectDayByText("Friday");
        List<String> selectedDays = guiFormPage.getSelectedDays();
        Assert.assertFalse(selectedDays.contains("friday"), "Friday should be deselected.");
    }


    @Test(priority = 20, description = "Verify deselect by index")
    public void testDeselectDayByIndex(){
        guiFormPage.selectAllDays();
        guiFormPage.deselectDayByIndex(3); // Deselect Wednesday
        List<String> selectedDays = guiFormPage.getSelectedDays();
        Assert.assertFalse(selectedDays.contains("wednesday"), "Wednesday should be deselected.");
    }

    @Test(priority = 21, description = "Verify country selection by text")
    public void testCountrySelection(){
        guiFormPage.selectCountry("Canada");
        Assert.assertEquals("Canada",guiFormPage.getSelectedCountry(),"Selected country should be Canada.");
    }

    @Test(priority = 22, description = "Verify country selection by index")
    public void testCountrySelectionByIndex(){
        guiFormPage.selectCountryByIndex(4); // Select country at index 5
        Assert.assertEquals("France",guiFormPage.getSelectedCountry(),"Selected country should be France.");
    }

    @Test(priority = 23, description = "Verify country selection by value")
    public void testCountrySelectionByValue(){
        guiFormPage.selectCountryByValue("germany");
        Assert.assertEquals("Germany",guiFormPage.getSelectedCountry(),"Selected country should be Germany.");
    }

    @AfterMethod
    public void resetForm(){
        driver.navigate().refresh();
    }



}
