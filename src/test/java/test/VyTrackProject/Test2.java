package test.VyTrackProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test2 {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa2.vytrack.com/user/login");
        WebElement userName = driver.findElement(By.xpath("//input[@id = 'prependedInput']"));
        userName.sendKeys("user32");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'prependedInput2']"));
        password.sendKeys("UserUser123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        loginButton.click();
    }
    // @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }
    @Test
    public void userStoryOne_testCaseOne() throws InterruptedException{
        driver.findElement(By.xpath("(//span[@class = 'title title-level-1'])[1]")).click();
        WebElement vehicleModule = driver.findElement(By.xpath("(//span[@class = 'title title-level-2'])[1]"));
        Thread.sleep(2000);
        vehicleModule.click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WebElement carsInfo = driver.findElement(By.xpath("//tr[@class = 'grid-row row-click-action' ]"));
        Assert.assertTrue(carsInfo.isDisplayed());
        Thread.sleep(2000);
    }
    @Test
    public void userStoryOne_testCaseTwo() throws InterruptedException{
        driver.findElement(By.xpath("(//span[@class = 'title title-level-1'])[1]")).click();
        WebElement vehicleModule = driver.findElement(By.xpath("(//span[@class = 'title title-level-2'])[1]"));
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        vehicleModule.click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        int selectCarNum = driver.findElements(By.xpath("(//td[@class = 'string-cell grid-cell grid-body-cell grid-body-cell-LicensePlate' ])")).size();
        for (int i = 1; i < selectCarNum+1; i++){
            WebElement each = driver.findElement(By.xpath("(//td[@class = 'string-cell grid-cell grid-body-cell grid-body-cell-LicensePlate' ])["+i+"]"));
            each.click();
            Thread.sleep(2000);
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            WebElement generalInfo = driver.findElement(By.xpath("//span[.='General Information']"));
            Assert.assertTrue(generalInfo.isDisplayed());
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
        }
    }
}
