package test.day12_synchronization;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Loading1Page;
import pages.Loading7Page;
import utilities.Driver;

public class ExplicitWaitPractices {

    @Test
    public void tc40_dynamic_title_test() {

        //TC#40: Dynamically Loaded Page Elements 7
        // 1.Go to http://practice.cybertekschool.com/dynamic_loading/7
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/7");

        Loading7Page loading7page = new Loading7Page();

        // 2.Wait until title is “Dynamic Title”
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.titleIs("Dynamic title"));
        // 3.Assert : Message “Done” is displayed.
        Assert.assertTrue(loading7page.doneMessage.isDisplayed());

        // 4.Assert : Image is displayed.Note: Follow POM
        Assert.assertTrue(loading7page.spongeBobImage.isDisplayed());
    }


    @Test
    public void tc41_dynamic_form_test(){
       // TC#41: Dynamically Loaded Page Elements 1
        // 1.Go to http://practice.cybertekschool.com/dynamic_loading/1
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");

        Loading1Page loading1Page = new Loading1Page();
        // 2.Click to start
        loading1Page.startButton.click();
        // 3.Wait until loading bar disappears
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(loading1Page.loadingBar));
        // 4.Assert username inputbox is displayed
        Assert.assertTrue(loading1Page.usernameInput.isDisplayed());
        // 5.Enter username: tomsmith
        loading1Page.usernameInput.sendKeys("tomsmith");
        // 6.Enter password: incorrect password
        loading1Page.passwordInput.sendKeys("abc");
        // 7.Click to Submit button
        loading1Page.submitButton.click();
        // 8.Assert “Your username is invalid!” text is displayed.
        Assert.assertTrue(loading1Page.errorMessage.isDisplayed());
    }


}
