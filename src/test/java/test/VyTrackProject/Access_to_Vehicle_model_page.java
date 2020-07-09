package test.VyTrackProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Access_to_Vehicle_model_page {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement inputUserName = driver.findElement(By.name("_username"));
        inputUserName.sendKeys("storemanager71");

        WebElement inputPassword = driver.findElement(By.name("_password"));
        inputPassword.sendKeys("UserUser123");

        WebElement loginButton = driver.findElement(By.name("_submit"));
        loginButton.click();

    }
    //@AfterMethod
    public void tearDown(){
        driver.close();
    }
    @Test
    public void store_manager_sales_manager_access() throws InterruptedException{
        WebElement fleet = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        Thread.sleep(2000);
        fleet.click();

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        WebElement vehicleModel = driver.findElement(By.xpath("(//span[@class='title title-level-2'])[10]"));
        Thread.sleep(2000);
        vehicleModel.click();

        WebElement VehicleModel = driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        Assert.assertTrue(VehicleModel.isDisplayed());

        WebElement newModel = driver.findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        Thread.sleep(1000);
        newModel.click();

    }

    
}