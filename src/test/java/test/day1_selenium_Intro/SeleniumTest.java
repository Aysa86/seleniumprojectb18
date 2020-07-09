package test.day1_selenium_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException{

        // 1 - set up the web driver(creates the connection between driver and selenium)
        WebDriverManager.chromedriver().setup();
        // 2 - create the instance of the chromeDriver to be able to do action in Chrome browser
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize(); // maximize the browser page after opening
       // driver.manage().window().fullscreen();// maximize the browser page after opening

        // 3 - test if driver is working
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());

        //Browser navigations

        Thread.sleep(2000); // this line adds 2 seconds of wait
        driver.navigate().back(); // line will take user to the previous page

        Thread.sleep(2000); // added 2 second to be able to see selenium movements
        driver.navigate().forward();// this line will go to next page

        Thread.sleep(2000); // adds 2 seconds to see selenium movements
        driver.navigate().refresh(); // this line refresh the page

        driver.navigate().to("https://www.facebook.com");

        System.out.println("driver.getTitle() --> "+ driver.getTitle());
        System.out.println("driver.getCurrentUrl() -->"+driver.getCurrentUrl());

        System.out.println(driver.getPageSource());

        driver.close();// will close the current browser tab
        driver.quit(); // will close all tabs and end the session




    }
}
