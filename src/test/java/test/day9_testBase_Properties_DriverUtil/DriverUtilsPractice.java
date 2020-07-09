package test.day9_testBase_Properties_DriverUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

public class DriverUtilsPractice {
   @Ignore
    @Test
    public void driver_practice(){
        Driver.getDriver().get("https://www.google.com");

        WebElement googleSearch = Driver.getDriver().findElement(By.name("q"));

        googleSearch.sendKeys(ConfigurationReader.getProperty("testdata") + Keys.ENTER);

        
    }
    @Test
    public void singleton_practice(){
        String str1 = Singleton.getWord();
        System.out.println("str1 = " + str1); // First call. Word object is null Assigning value to word right now
                                             // str1 = something

        String str2 = Singleton.getWord();
        System.out.println("str2 = " + str2); // Word already has value
                                              // str2 = something
        String str3 = Singleton.getWord();
        System.out.println("str3 = " + str3); // Word already has value
                                              // str3 = something
    }

    @Test
    public void singleton_practice2(){
        String str4 = Singleton.getWord();
        System.out.println("str4 = " + str4); // Word already has value
                                              // str4 = something

        // this result will be if we run 2 Tests at the same time, if we run just this one, it would say:
        //First call. Word object is null Assigning value to word right now
        //str4 = something
    }

}
