package test.day11_page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class NegativeLoginTests {
    LoginPage loginPage;
    @Ignore
    @Test
    public void negative_login_test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

        WebElement userNameInput = Driver.getDriver().findElement(By.id("prependedInput"));
        WebElement passwordInput = Driver.getDriver().findElement(By.id("prependedInput2"));
        WebElement loginButton = Driver.getDriver().findElement(By.id("_submit"));

        String userName = ConfigurationReader.getProperty("storemanager_username");
        userNameInput.sendKeys(userName);

       // String password = ConfigurationReader.getProperty("storemanager_password");
       // passwordInput.sendKeys(password);

        passwordInput.sendKeys("UserUser12"); // passed invalid password

        loginButton.click();

        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-error']"));

        Assert.assertTrue(errorMessage.isDisplayed(), "Assert message is not displayed");
    }

    @Test
    public void negative_login_test_with_page_object(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

        LoginPage loginPage = new LoginPage();

        // sending userName
        String userName = ConfigurationReader.getProperty("storemanager_username");

        loginPage.usernameInput.sendKeys(userName);

        // sending incorrect password
        loginPage.passwordInput.sendKeys("UserUser12");

        // click using our loginPage object
        loginPage.loginButton.click();

        // asserting error message is displayed
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        // asserting the text value of the error message
        String actualText = loginPage.errorMessage.getText();
        String expectedText = "Invalid user name or password.";
        Assert.assertEquals(actualText, expectedText);
    }
    @Test
    public void tc31_wrong_userName_test(){
       // TC#31 : Vytrack negative login testàWrong Username Test
        // 1. Go to https://qa3.vytrack.com
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        loginPage = new LoginPage();

        //2. Enter incorrect username
        //3. Enter correct password

        String userName = "storemanager2"; // invalid userName
        String password = ConfigurationReader.getProperty("storemanager_password");
        loginPage.login(userName, password);

       // 4. Verify error message text is as expected Expected: “Invalid user name or password.”
        //Note: Follow Page Object Model design pattern

        // asserting error message is displayed
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        // asserting the text value of the error message
        String actualText = loginPage.errorMessage.getText();
        String expectedText = "Invalid user name or password.";
        Assert.assertEquals(actualText, expectedText);
    }


}
