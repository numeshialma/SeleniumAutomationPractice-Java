//using OpenQA.Selenium;
//using OpenQA.Selenium.Chrome;

//namespace SeleniumAutomationProject
//{
//    public class Tests
//    {
//        [SetUp]
//        public void Setup()
//        {
//        }
           
//        [Test]
//        public void LaunchChrome()
//        {
//            IWebDriver driver = new ChromeDriver();
//            driver.Navigate().GoToUrl("https://www.google.com");

//            // capture the title of the page
//            var title = driver.Title;
//            Console.WriteLine("Page Title is: " + title);

//            var url = driver.Url;
//            Console.WriteLine("Page URL is: " + url);   

//            var pageSource = driver.PageSource;
//            Console.WriteLine("Page Source length is: " + pageSource.Length);   

//            Thread.Sleep(2000); // wait for 2 seconds to see the browser    

//            //driver.Close();

//        }


//        [Test]
//        public void NavigationMethods()
//        {
//            IWebDriver driver = new ChromeDriver();
//            driver.Navigate().GoToUrl("https://www.google.com");
//            driver.Navigate().GoToUrl("https://rahulshettyacademy.com/angularpractice/");  

//            driver.Navigate().Back();
//            driver.Navigate().Forward();
//            driver.Navigate().Refresh();   
//        }
//    }
//}