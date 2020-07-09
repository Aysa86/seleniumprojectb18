package test.day4_findElements_checkBox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class P05_SeleniumEasyCheckBox {
    public static void main(String[] args) {
        //TC	#2:	SeleniumEasy	CheckboxVerification–Section	1
        // 1.Open	Chrome	browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        // 2.Go	to	https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        // 3.Verify	“Success	–Check	box	is	checked”	message	is	NOTdisplayed.
     WebElement successCheckBox = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
     WebElement successMessage = driver.findElement(By.xpath("//div[@id='txtAge']"));
     if (! successCheckBox.isSelected() &&  ! successMessage.isDisplayed()){
         System.out.println("Default value verification Passed");
     }else {
         System.out.println(" Default value verification Failed");
     }
        // 4.Click	to	checkbox	under	“Single	Checkbox	Demo”	section
       successCheckBox.click();
        // 5.Verify	“Success	–Check	box	is	checked”	message	isdisplayed.
        if (successCheckBox.isDisplayed()){
            System.out.println("Success message is displayed. Passed");
        }else {
            System.out.println("Success message is not displayed. Failed");
        }
    }
}
