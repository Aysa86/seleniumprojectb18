package test.day2_FindElements_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_LinkTextLocator {
    public static void main(String[] args) {

        //TC #3: Back and forth navigation
       // 1-Open a chrome browser
       //2-Go to: https://google.com



        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        // 3-Click to Gmail from top right.
        driver.findElement(By.linkText("Gmail")).click();

        // 4-Verify title contains:Expected: Gmail
       String actualGmailTitle = driver.getTitle();
       String expectedInTitle = "Gmail";
       if(actualGmailTitle.contains(expectedInTitle)){
           System.out.println("Gmail title verification PASSED!");
       }else {
           System.out.println("Gmail title verification FAILED!");
       }
      // 5-Go back to Google by using the .back();
       driver.navigate().back();

       // 6-Verify title equals:Expected: Google
       String actualTitle = driver.getTitle();
       String expectedTitle = "Google";
        if (actualTitle.equals(expectedTitle)) {

            System.out.println("Google title verification passed!");
        }else{
            System.out.println("Google title verification failed!");
        }
    }
}
