package test.VyTrackProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class Access_to_Vehicle_contract_page {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDown(){
    driver.close();
    }
    @Test
    public void Vehicle_contract_page_access_authorized_user() throws InterruptedException{
        WebElement inputUserName = driver.findElement(By.name("_username"));
        inputUserName.sendKeys("storemanager71");

        WebElement inputPassword = driver.findElement(By.name("_password"));
        inputPassword.sendKeys("UserUser123");

        WebElement loginButton = driver.findElement(By.name("_submit"));
        loginButton.click();




        WebElement fleet = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        Thread.sleep(2000);
        fleet.click();

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        WebElement vehicleContracts = driver.findElement(By.xpath("(//span[@class='title title-level-2'])[7]"));
        Thread.sleep(2000);
        vehicleContracts.click();

        WebElement VehicleContracts = driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        Assert.assertTrue(VehicleContracts.isDisplayed());

    }
    @Test
    public void vehicle_contract_page_access_unauthorized_user(){
        WebElement inputUserName = driver.findElement(By.name("_username"));
        inputUserName.sendKeys("user30");

        WebElement inputPassword = driver.findElement(By.name("_password"));
        inputPassword.sendKeys("UserUser123");

        WebElement loginButton = driver.findElement(By.name("_submit"));
        loginButton.click();

        WebElement fleet = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleet.click();

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        WebElement VehicleContract = driver.findElement(By.xpath("(//span[@class='title title-level-2'])[4]"));
        VehicleContract.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[.='You do not have permission to perform this action.']"));
                                                                // //div[@class='message']
        Assert.assertTrue(errorMessage.isDisplayed());
    }
}
