using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SeleniumAutomationProject.Pages
{
    public class HomePage
    {
        private readonly IWebDriver driver;
        private readonly WebDriverWait wait;

        public HomePage(IWebDriver driver)
        {
            this.driver = driver;
            wait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
        }

        // Locators
        private IWebElement nameInput => driver.FindElement(By.Name("name"));
        private IWebElement emailInput => driver.FindElement(By.Name("email"));
        private IWebElement passwordInput => driver.FindElement(By.Id("exampleInputPassword1"));
        private IWebElement iceCreameCheckBox => driver.FindElement(By.Id("exampleCheck1"));
        private IWebElement genderDropdown => driver.FindElement(By.Id("exampleFormControlSelect1"));
        private IWebElement employmentRadioButton => driver.FindElement(By.Id("inlineRadio2"));
        private IWebElement studentRadioButton => driver.FindElement(By.Id("inlineRadio1"));
        private IWebElement submitButton => driver.FindElement(By.CssSelector("input[type='submit']"));
        private IWebElement successMessage => driver.FindElement(By.CssSelector(".alert-success"));

        // Actions
        public void EnterName(string name)
        {
            nameInput.Clear();
            nameInput.SendKeys(name);
        }

        public void EnterEmail(string email)
        {
            emailInput.Clear();
            emailInput.SendKeys(email);
        }

        public void EnterPassword(string password)
        {
            passwordInput.Clear();
            passwordInput.SendKeys(password);
        }

        public void CheckIceCream(bool shouldCheck)
        {
            if (!iceCreameCheckBox.Selected != shouldCheck)
            {
                iceCreameCheckBox.Click();
            }
        }

        public void SelectGender(string gender)
        {
            var selectElement = new SelectElement(genderDropdown);
            selectElement.SelectByText(gender);
        }

        public void SelectEmploymentStatus(string status)
        {
            if (status.Equals("Employed", StringComparison.OrdinalIgnoreCase))
            {
                employmentRadioButton.Click();
            }
            else if (status.Equals("Student", StringComparison.OrdinalIgnoreCase))
            {
                studentRadioButton.Click();
            }
        }

        public void ClickSubmit()
        {
            waitForElementToBeClickable(submitButton);
            submitButton.Click();
        }

        // Verification
        public bool IsIceCreamChecked()
        {
            return iceCreameCheckBox.Selected;
        }

        public string GetSelectGender()
        {
            SelectElement selectElement = new SelectElement(genderDropdown);
            return selectElement.SelectedOption.Text;
        }

        public bool IsStudentSelected()
        {
            return studentRadioButton.Selected;
        }

        public bool IsEmployedSelected()
        {
            return employmentRadioButton.Selected;
        }

        // Wait Helpers
        private void waitForElementToBeClickable(IWebElement element)
        {
            wait.Until(d => element.Displayed && element.Enabled);
        }

        private void waitForElementToBeVisible(IWebElement element)
        {
            wait.Until(d => element.Displayed);
        }

        public string GetSuccessMessage()
        {
            waitForElementToBeVisible(successMessage);
            return successMessage.Text;
        }

    }
}
