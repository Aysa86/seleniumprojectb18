package test.WarmUp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T_2_ZeroBankURLVerification {
    public static void main(String[] args) {
        // TC #4: Zero Bank URLverification
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        // 2.Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        // 3.Get attribute value of href from the “forgot your password”link

       String actual = driver.findElement(By.linkText("Forgot your password ?")).getAttribute("href");
        // 4.Verify attribute value containsExpected: “/forgot-password.html”
        System.out.println(actual);

        String expected = "/forgot-password.html";
        if(actual.contains(expected)){
            System.out.println("test passed");
        }else{
            System.out.println("Test failed");
        }


    }
}