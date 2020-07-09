package test.WarmUp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P_3_ZeroBankAuth {
    public static void main(String[] args) {
       // TC #5: Basic authentication Zero Bank
        //1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // 2.Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");
        // 3.Enter username: username
        driver.findElement(By.id("user_login")).sendKeys();
        // 4.Enter password: password
        // 5.Click sign in button
        // 6.Verify username is displayed on the page
        // 7.Verify the title Zero –Account Summary
        // 8.Verify the link Account Summary’s href value contains: “account-summary”Print
        // out results in validation formats
    }
}
