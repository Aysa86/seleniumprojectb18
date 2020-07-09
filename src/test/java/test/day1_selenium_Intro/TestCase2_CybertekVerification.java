package test.day1_selenium_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2_CybertekVerification {
    public static void main(String[] args) {

       // TC#2:	Cybertek verifications
        // 1.Open Chrome browser
        // 2.Go	to	http://practice.cybertekschool.com
        // 3.Verify	URL	containsExpected: cybertekschool
        // 4.Verify	title:	Expected:	Practice

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com");
        String currentURL =  driver.getCurrentUrl();
        String expectedURL = "cybertekschool";

        if(currentURL.equals(expectedURL)){
            System.out.println("Current URL is different");
        }else{
            System.out.println("Current URL expected");
        }

        String actualTitle = driver.getTitle();
        String expectedTitle = "Practice";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification passed");
        }else{
            System.out.println("Title verification failed");
        }

    }
}
