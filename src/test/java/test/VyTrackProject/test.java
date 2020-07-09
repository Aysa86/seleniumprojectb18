package test.VyTrackProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;
import java.util.concurrent.TimeUnit;
public class test {
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa1.vytrack.com/user/login");
    }
    @Test(priority = 1)
    public void login() {
        WebElement username = driver.findElement(By.xpath("//input[@name='_username']"));
        username.sendKeys("user27");
        WebElement password = driver.findElement(By.xpath("//input[@name='_password']"));
        password.sendKeys("UserUser123");
        WebElement login = driver.findElement(By.xpath("//button[@name='_submit']"));
        login.click();
    }
    @Test(priority = 2)
    public void vehicleModelTab() throws InterruptedException {
        WebElement fleet = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleet.click();
        Thread.sleep(2000);
        WebElement VehicleModel = driver.findElement(By.linkText("Vehicles Model"));
        Thread.sleep(2000);
        VehicleModel.click();
    }
    @Test(priority = 3)
    public void vehicleModelPageVerification() {
        WebElement vehiclesModel = driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        // Assert.assertEquals(vehiclesModel.getText(), "Vehicle Model"); // first option
        Assert.assertTrue(vehiclesModel.isDisplayed()); // second option
    }
}

