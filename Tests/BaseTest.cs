using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using NUnit.Framework;
using System;


namespace SeleniumAutomationProject.Tests
{
    [TestFixture]
    public class BaseTest
    {
        protected IWebDriver driver;
        protected string baseUrl = "https://rahulshettyacademy.com/angularpractice/";

        [SetUp]
        public void Setup()
        {
            // Initialize the ChromeDriver
            driver = new ChromeDriver();

            // Configure browser settings
            driver.Manage().Window.Maximize();
            driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(10);
            driver.Manage().Timeouts().PageLoad = TimeSpan.FromSeconds(30);

            // Navigate to the base URL
            driver.Navigate().GoToUrl(baseUrl);
        }


        [TearDown]
        public void TearDown()
        {
            // Take screenshot on test failure
            if(TestContext.CurrentContext.Result.Outcome.Status == NUnit.Framework.Interfaces.TestStatus.Failed)
            {
                TakesScreenshot(TestContext.CurrentContext.Test.Name);
            }

            // Dispose the driver if not already disposed
            if (driver != null)
            {
                driver.Quit();
                driver.Dispose();
                driver = null;
            }
        }

        protected void TakesScreenshot(string testName)
        {
            try
            {
                Screenshot screenshot = ((ITakesScreenshot)driver).GetScreenshot();
                string filename = $"Screenshots/{testName}_{DateTime.Now:yyyyMMdd_HHmmss}.png";
                screenshot.SaveAsFile(filename);
                TestContext.WriteLine($"Screenshot saved: {filename}");
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error taking screenshot: " + ex.Message);
            }
        }


    }
}
