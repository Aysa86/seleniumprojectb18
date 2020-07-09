package test.day6_testNG_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class TestNG_SeleniumPractice {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        //GOAL is to open new browser for each test.
        //What annotation I should be using for this? BeforeMethod or BeforeClass?
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }

    @Test(priority = 2)
    public void google_title_test(){
        //1. Go to https://www.google.com

        //2. Verify title : Google
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        // The line where we do assertion
        Assert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle));// return true or false, boolean expression

        Assert.assertEquals(actualTitle, actualTitle);// pass 2 arguments of the same type
    }

    @Test (priority = 1)
    public void google_search_title_verification(){
        // 1.Open browser
        //2. go to https://www.google.com

        //3.search "apple"
       WebElement appleSearchBox = driver.findElement(By.name("q"));
       appleSearchBox.sendKeys("apple"+ Keys.ENTER);
        //4.verify title contains "apple"
        String actualTitle = driver.getTitle();
        String expectedInTitle = "apple";

        Assert.assertTrue (actualTitle.contains(expectedInTitle));
        //5.close browser



    }
}
