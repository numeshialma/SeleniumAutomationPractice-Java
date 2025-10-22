using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Edge;
using OpenQA.Selenium.Firefox;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SeleniumAutomationProject.Drivers
{
    public enum BrowserType
    {
        Chrome
    }

    public static class WebDriverFactory
    {
        public static IWebDriver CreateDriver(BrowserType browserType = BrowserType.Chrome)
        {
            IWebDriver driver;

            switch (browserType)
            {
                case BrowserType.Chrome:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.AddArgument("--start-maximized");
                    // chromeOptions.AddArgument("--headless"); // Uncomment for headless mode
                    driver = new ChromeDriver(chromeOptions);
                    break;

                default:
                    throw new ArgumentException($"Browser type {browserType} is not supported");
            }

            driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(5);
            driver.Manage().Timeouts().PageLoad = TimeSpan.FromSeconds(30);

            return driver;
        }
    }
}
