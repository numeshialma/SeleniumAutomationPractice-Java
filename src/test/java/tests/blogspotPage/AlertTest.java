package tests.blogspotPage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.blogspotPage.AlertsPage;
import utils.TestBase;

public class AlertTest extends TestBase {

    private AlertsPage alertsPage;

    @BeforeClass
    public void setUp() {
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        alertsPage = new AlertsPage(driver);
    }

    @Test(priority = 1, description = "Test Simple Alert Button")
    public void testAlertButton() {
        alertsPage = new AlertsPage(driver);
        alertsPage.clickSimpleAlert();

//        String alertResult = alertsPage.getAlertResultText();
//        Assert.assertEquals(alertResult, "You successfully handled the alert.", "Alert result text is not as expected");
    }

    @Test(priority = 2, description = "Test Confirm Alert OK Button")
    public void testConfirmButton() {
        alertsPage = new AlertsPage(driver);
        alertsPage.clickConfirmationAlertOk();

//        String confirmResult = alertsPage.getConfirmResultText();
//        Assert.assertEquals(confirmResult, "You pressed OK!", "Confirm alert result text is not as expected");
    }

    @Test(priority = 3, description = "Test Confirm Alert Cancel Button")
    public void testConfirmButtonCancel() {
        alertsPage = new AlertsPage(driver);
        alertsPage.clickConfirmationAlertCancel();

//        String confirmResult = alertsPage.getConfirmResultText();
//        Assert.assertEquals(confirmResult, "You pressed Cancel!", "Confirm alert cancel result text is not as expected");
    }

    @Test(priority = 4, description = "Test Prompt Alert with Input Text")
    public void testPromptAlert() {
        String inputText = "Test Input";
        alertsPage = new AlertsPage(driver);
        alertsPage.clickPromptAlert(inputText);

        String promptResult = alertsPage.getPromptResultText();
        Assert.assertEquals(promptResult, "Hello " + inputText+ "! How are you today?", "Prompt alert result text is not as expected");
    }

    @Test(priority = 5, description = "Test Prompt Alert Dismiss")
    public void testPromptAlertDismiss() {
        alertsPage = new AlertsPage(driver);
        alertsPage.clickPromptAlertCancel();

//        String promptResult = alertsPage.getPromptResultText();
//        Assert.assertEquals(promptResult, "You entered: null", "Prompt alert dismiss result text is not as expected");
    }

}
