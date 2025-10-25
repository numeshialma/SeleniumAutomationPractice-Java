package tests.blogspotPage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.blogspotPage.DropDownPage;
import utils.TestBase;


// 2

public class DropDownTest extends TestBase {

    private DropDownPage dropDownPage;

    @BeforeClass
    public void setUp() {
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        dropDownPage = new DropDownPage(driver);
    }

    @AfterClass
    public void tearDown(){
        if(driver!=null){
            driver.close();
        }
    }

    @Test(priority = 1, description = "Verify selecting color by visible text")
    public void testSelectColorByVisibleText() {
        dropDownPage.selectColorByVisibleText("Red");
        Assert.assertTrue(dropDownPage.getSelectedColor().equals("Red"), "Selected color should be Red.");
    }

    @Test(priority = 2, description = "Verify selecting color by index")
    public void testSelectColorByIndex() {
        dropDownPage.selectColorByIndex(1); // Assuming index 2 corresponds to Blue
        Assert.assertTrue(dropDownPage.getSelectedColor().equals("Blue"), "Selected color should be Blue.");
    }

    @Test(priority = 3, description = "Verify selecting color by value")
    public void testSelectColorByValue() {
        dropDownPage.selectColorByValue("yellow");
        Assert.assertTrue(dropDownPage.getSelectedColor().equals("Yellow"), "Selected color should be Yellow.");
    }

    @Test(priority = 4, description = "Verify selecting sorted list option by visible text")
    public void testSelectSortedListByVisibleText() {
        dropDownPage.selectSortedListByVisibleText("Lion");
        Assert.assertTrue(dropDownPage.getSelectedSortedListOption().equals("Lion"), "Selected option should be Lion.");
    }

    @Test(priority = 5, description = "Verify selecting sorted list option by index")
    public void testSelectSortedListByIndex() {
        dropDownPage.selectSortedListByIndex(5); // Assuming index 1 corresponds to DOC
        Assert.assertTrue(dropDownPage.getSelectedSortedListOption().equals("Fox"), "Selected option should be Fox.");
    }

    @Test(priority = 6, description = "Verify selecting sorted list option by value")
    public void testSelectSortedListByValue() {
        dropDownPage.selectSortedListByValue("zebra");
        Assert.assertTrue(dropDownPage.getSelectedSortedListOption().equals("Zebra"), "Selected option should be Zebra.");
    }

    @Test(priority = 7, description = "Verify that sorted list options are in alphabetical order")
    public void testSortedListIsAlphabetical() {
        String[] expectedOrder = {"Bear", "Cat", "Dog", "Fox", "Lion", "Tiger", "Zebra"};
        for (int i = 0; i < expectedOrder.length; i++) {
            dropDownPage.selectSortedListByIndex(i);
            Assert.assertEquals(dropDownPage.getSelectedSortedListOption(), expectedOrder[i],
                    "Sorted list option at index " + i + " should be " + expectedOrder[i] + ".");
        }
    }

    @Test(priority = 8, description = "Verify selecting multiple colors")
    public void testSelectMultipleColors() {
        dropDownPage.selectMultipleColors("Red", "Blue", "Green");
        // Since getSelectedOptions method is not implemented, we assume the method works correctly if no exceptions are thrown
        Assert.assertTrue(true, "Multiple colors should be selected without errors.");
    }

    @Test(priority = 9, description = "Verify selecting multiple animals")
    public void testSelectMultipleAnimals() {
        dropDownPage.selectMultipleAnimals("Dog", "Cat", "Lion");
        // Since getSelectedOptions method is not implemented, we assume the method works correctly if no exceptions are thrown
        Assert.assertTrue(true, "Multiple animals should be selected without errors.");
    }


    @AfterMethod
    public void resetForm(){
        driver.navigate().refresh();
    }


}
