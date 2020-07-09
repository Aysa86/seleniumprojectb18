package test.WarmUp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeCybertek {
    public static void main(String[] args) {
        //TC #3: PracticeCybertek/ForgotPassword URL verification
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // 2.Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");
        // 3.Enter any email into input box
        driver.findElement(By.name("email")).sendKeys("ad@gmail.com");

       // WebElement emailInput = driver.findElement(By.name("email"));
       // emailInput.sendKeys("ad@gmail.com");


        // 4.Click on Retrieve password
        driver.findElement(By.id("form_submit")).click();

       // WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
       // retrievePasswordButton.click();

        // 5.Verify URL contains: Expected: “email_sent”
       String actualURL =  driver.getCurrentUrl();
       String expectedInURL = "email_sent";
       if(actualURL.contains(expectedInURL)){
           System.out.println("URL verification Passed");
       }else{
           System.out.println("URL verification Failed");
       }

        // 6.Verify textbox displayed the content as expected.Expected: “Your e-mail’s been sent!”
      WebElement confirmationMessage = driver.findElement(By.name("confirmation_message"));
      String actualTextMessage = confirmationMessage.getText();
      String  expectedTextMessage = "Your e-mail's been sent!";
        //System.out.println("Actual text: "+actualText);
      if(actualTextMessage.equals(expectedTextMessage)){
          System.out.println("Text message verification passed");
      }else{
          System.out.println("Text message verification failed");
      }

      /*if (confirmationMessage.isDisplayed()){
          System.out.println("Message is displayed, Verification Passed");
      }
        System.out.println("Message is not displayed, Verification Failed");

         This done bc of if "text message" is failed, it happens bc of any symbol that is not matching
         for ex: '
       */


    }
}
