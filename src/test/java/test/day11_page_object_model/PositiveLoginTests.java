package test.day11_page_object_model;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class PositiveLoginTests {
    LoginPage loginPage;
    @Test
    public void tc32_store_manager_login_test(){
       // TC#32 : Vytrack positive login testàSales Manager
        // 1. Go to https://qa3.vytrack.com
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        loginPage = new LoginPage();
        //2. Enter correct username
        //3. Enter correct password
        String userName = ConfigurationReader.getProperty("storemanager_username");
        String password = ConfigurationReader.getProperty("storemanager_password");
        loginPage.login(userName, password);
       // 4. Verify title changed Expected: “Dashboard”
        //Note: Follow Page Object Model design pattern

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(actualTitle, expectedTitle);

    }
}
