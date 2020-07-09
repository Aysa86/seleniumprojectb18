package test.VyTrackProject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class AccessToVehicleContractPage {
    LoginPage loginPage;
    @Test (priority = 1)
    public void authorized_users_access() throws InterruptedException{
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        loginPage = new LoginPage();

        String userName = ConfigurationReader.getProperty("storemanager_username");
        String password = ConfigurationReader.getProperty("storemanager_password");
        loginPage.login(userName, password);

        WebElement fleet = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        WebElement vehicleContract = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-2'])[7]"));

        Actions actions = new Actions(Driver.getDriver());
        Thread.sleep(2000);
        actions.moveToElement(fleet).perform();

        Thread.sleep(2000);

        actions.moveToElement(vehicleContract).click().perform();

        WebElement VehicleContractPage = Driver.getDriver().findElement(By.xpath("//h1[@class='oro-subtitle']"));
        Assert.assertTrue(VehicleContractPage.isDisplayed());

        Driver.closeDriver();
    }
    @Test (priority = 2)
    public void unauthorized_users_access() throws InterruptedException{
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        loginPage = new LoginPage();

        String userName = ConfigurationReader.getProperty("truck_driver_username");
        String password = ConfigurationReader.getProperty("truck_driver_password");
        loginPage.login(userName, password);

        WebElement fleet = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        WebElement vehicleContract = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-2'])[4]"));

        Actions actions = new Actions(Driver.getDriver());

        Thread.sleep(2000);

        actions.moveToElement(fleet).perform();

        Thread.sleep(2000);

        actions.moveToElement(vehicleContract).click().perform();

        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("//div[@class='message']"));
        Assert.assertTrue(errorMessage.isDisplayed());

        Driver.closeDriver();

    }
}
