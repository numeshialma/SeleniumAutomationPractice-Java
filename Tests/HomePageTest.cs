using SeleniumAutomationProject.TestData;
using SeleniumAutomationProject.Pages;

namespace SeleniumAutomationProject.Tests
{
    public class HomePageTest : BaseTest
    {
        private HomePage homePage;

        [SetUp]
        public void TestSetup()
        {
            // Call base setup first
            //base.Setup();

            // Initialize the HomePage object
            homePage = new HomePage(driver);
        }

        [TearDown]
        public void TestTearDown()
        {
            // Call base teardown
            base.TearDown();
        }

        [Test]
        [Category("Smoke")]
        [Description("Verify form submission on the home page")]
        public void TestFormSubmission()
        {
            // Arrange
            var testUser = TestUsers.GetValidUser();

            // Act
            homePage.EnterName(testUser.Name);
            homePage.EnterEmail(testUser.Email);
            homePage.EnterPassword(testUser.Password);
            homePage.CheckIceCream(true);
            homePage.SelectGender(testUser.Gender);
            homePage.SelectEmploymentStatus(testUser.EmploymentStatus);

            Assert.Multiple(() =>
            {
                // Assert
                Assert.That(homePage.IsIceCreamChecked(), Is.True,
                    "Ice cream checkbox should be checked");
                Assert.That(homePage.GetSelectGender(), Is.EqualTo(testUser.Gender),
                    "Gender should be selected correctly");
                Assert.That(homePage.IsStudentSelected(), Is.True,
                    "Student radio should be selected");
            });

            homePage.ClickSubmit();

            Assert.Multiple(() =>
            {
                // Assert
                homePage.ClickSubmit();
                string successMsg = homePage.GetSuccessMessage();
                Assert.That(successMsg.Contains("Success"), "Success message not displayed as expected.");
            });
        }

    }
}
