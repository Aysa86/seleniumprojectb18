package test.day12_synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class ForgotPasswordTests {
    LoginPage login;

    @Test
    public void tc35_vytrack_Forgot_password_page() {
        // TC#35 : Vytrack forgot password page verificationsà TITLE and URL
        // 1. Go to https://qa3.vytrack.com
        Driver.getDriver().get("https://qa3.vytrack.com");

        //2. Click to “Forgot your password?” link
        WebElement forgotPasswordLink = Driver.getDriver().findElement(By.xpath("//a[.='Forgot your password?']"));

        Actions actions = new Actions(Driver.getDriver());
        actions.click(forgotPasswordLink).perform();
        //3. Verify title changed to expected
        //Expected: “Forgot Password”

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Forgot Password";
        Assert.assertTrue(actualTitle.equals(expectedTitle));
        // 4. Verify url is as expected:
        // Expected: “https://qa3.vytrack.com/user/reset-request”
        // Note: Follow Page Object Model design pattern
        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedURL = "https://qa3.vytrack.com/user/reset-request";
        Assert.assertTrue(actualURL.equals(expectedURL));
    }

    @Test
    public void tc35_title_url_verification(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));

        LoginPage loginPage = new LoginPage();
        loginPage.forgotPasswordLink.click();

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Forgot Password";

        Assert.assertTrue(actualTitle.equals(expectedTitle));

        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedURL = "https://qa2.vytrack.com/user/reset-request";

        Assert.assertTrue(actualURL.equals(expectedURL));
    }



    @Test
    public void tc_36_vytrack_forgot_password_page_verification(){
        //TC#36 : Vytrack forgot password page verificationà ERROR MESSAGE
        // 1. Go to https://qa3.vytrack.com/user/reset-request
        Driver.getDriver().get("https://qa3.vytrack.com/user/reset-request");
        //2. Enter random username
        login = new LoginPage();
        login.usernameInput.sendKeys("abcd");
        //3. Click to request button
        WebElement requestButton = Driver.getDriver().findElement(By.xpath("//button[@class='btn extra-submit btn-uppercase btn-primary']"));
        Actions actions = new Actions(Driver.getDriver());
        actions.click(requestButton).perform();
        //4. Verify error message is displayed
        WebElement errorMessage = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-error']"));
        Assert.assertTrue(errorMessage.isDisplayed());
        //5. Verify error message text is as expected.
        // Expected: There is no active user with username or email address “given text”.
        // Note: Follow Page Object Model design pattern
        Assert.assertTrue(errorMessage.getText().equals("There is no active user with username or email address \"abcd\"."));
    }

    @Test
    public void tc36_error_message_verification(){
        Driver.getDriver().get(ConfigurationReader.getProperty("forgotpasswordurl"));

        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

        String randomInput = "aysa";
        forgotPasswordPage.inputBox.sendKeys(randomInput);

        forgotPasswordPage.requestButton.click();

        Assert.assertTrue(forgotPasswordPage.errorMessage.isDisplayed());

        String expectedMessage = "There is no active user with username or email address \""+randomInput+"\".";
        String actualMessage = forgotPasswordPage.errorMessage.getText();

        Assert.assertEquals(actualMessage, expectedMessage);

    }


}
