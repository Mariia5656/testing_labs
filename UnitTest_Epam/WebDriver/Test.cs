using System;
using System.Threading;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using Microsoft.VisualStudio.TestTools.UnitTesting;


namespace TestApp
{
    [TestClass]
    public class ThreadSleep
    {
        [TestMethod]
        public void TestMethod()
        {
            WebDriver driver = new ChromeDriver();
            driver.Navigate().GoToUrl("https://www.aircanada.com/");
            Thread.Sleep(2000);
            WebElement element = driver.FindElement(By.XPath("//input[@type='text'])[2]"));
            element.SendKeys("Minsk");


            Thread.Sleep(2000);

            WebElement button_Find = driver.FindElement(By.Id("executeSingleCitySubmit_i"));
            button_Find.Click();
            String title = driver.Title;
            Assert.AreEqual(true, title.Contains(expectedTitle), "The information is incomplete. Please, check it again and send the correct form");
        }
    }
}