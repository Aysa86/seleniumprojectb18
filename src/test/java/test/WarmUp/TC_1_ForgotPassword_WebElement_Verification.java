package test.WarmUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class TC_1_ForgotPassword_WebElement_Verification {
    public static void main(String[] args) {
        // XPATH PRACTICES
        // DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        // TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        // 2. Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");
        // 3. Locate all the WebElements on the page using XPATH locator only (total of 6)
        // a. “Home” link
        WebElement HomeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));
        if (HomeLink.isDisplayed()){
            System.out.println("Home link verification passed");
        }else {
            System.out.println("Home link verification failed");
        }
        // b. “Forgot password” header
        WebElement forgotPassword = driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        if (forgotPassword.isDisplayed()){
            System.out.println("Forgot password verification passed");
        }else {
            System.out.println("Forgot password verification failed");
        }
        // c. “E-mail” text
       // WebElement emailInput = driver.findElement(By.xpath("//label[.='E-mail']"));
        WebElement emailInput = driver.findElement(By.xpath("//label[@for='email']"));
        if (emailInput.isDisplayed()){
            System.out.println("Email input verification passed");
        }else {
            System.out.println("Email input verification failed");
        }
        // d. E-mail input box
        WebElement emailInputBox = driver.findElement(By.xpath("//input[@type='text']"));
        if (emailInputBox.isDisplayed()){
            System.out.println("Email input box verification passed");
        }else {
            System.out.println("Email input box verification failed");
        }
        // e. “Retrieve password” button
        WebElement retrievePassword = driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));
        if (retrievePassword.isDisplayed()){
            System.out.println("Retrieve password verification passed");
        }else {
            System.out.println("Retrieve password verification failed");
        }
        // f. “Powered byCybertek School” text
        WebElement PoweredByCybertekSchool = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        if (PoweredByCybertekSchool.isDisplayed()){
            System.out.println("Powered by Cybertek School verification passed");
        }else {
            System.out.println("Powered by Cybertek School verification failed");
        }
        // 4. Verify all WebElements are displayed.





    }

}
