package test.day8_alerts_Iframes_windows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import javax.xml.transform.TransformerException;
import java.util.concurrent.TimeUnit;

public class AlertsPractices {
    // TC #1: Information alert practice
    // 1.Open browser
    // 2.Go to website: http://practice.cybertekschool.com/javascript_alerts
    // 3.Click to “Click for JS Alert”button
    // 4.Click to OK button from the alert
    // 5.Verify “You successfulyclicked an alert”text is displayed

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void p1_information_alert_test() {
        // 3.Click to “Click for JS Alert”button
        WebElement infoAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        infoAlertButton.click();

        // 4.Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        // 5.Verify “You successfuly clicked an alert” text is displayed
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']")); // By.id("result")
        Assert.assertTrue(resultText.isDisplayed());
    }
    @Test
    public void p2_confirmation_alert_test() {
        //TC #2: Confirmationalert practice
        // 1.Open browser
        // 2.Go to website: http://practice.cybertekschool.com/javascript_alerts
        // 3.Click to “Click for JS Confirm” button
        WebElement confirmationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));

        // 4.Click to OK button from the alert
        confirmationAlertButton.click();
        // 5.Verify “You clicked: Ok” text is displayed
        Alert alert = driver.switchTo().alert();
       //  alert.dismiss(); clicked on "cancel"
        alert.accept(); // clicked on "ok"

        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']")); // By.id("result")
        Assert.assertTrue(resultText.isDisplayed());
    }
    @Test
    public void information_alert_test(){
        //TC #3: Information alert practice
        // 1.Open browser
        // 2.Go to website: http://practice.cybertekschool.com/javascript_alerts
        // 3.Click to “Click for JS Prompt” button
        WebElement informationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        informationAlertButton.click();
        // 4.Send “hello”text to alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        // 5.Click to OK button from the alert
        alert.accept();
        // 6.Verify “You entered:  hello” text is displayed.
        String actual=driver.findElement(By.id("result")).getText();
        String expected="You entered: hello";
        Assert.assertEquals(actual,expected);
    }
}

