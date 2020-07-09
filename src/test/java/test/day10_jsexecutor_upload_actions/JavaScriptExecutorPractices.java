package test.day10_jsexecutor_upload_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class JavaScriptExecutorPractices {

    @Test
    public void jsexecutor_test() throws InterruptedException{
        Driver.getDriver().get("http://practice.cybertekschool.com/");

        WebElement cybertekSchoolLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));

      JavascriptExecutor javascriptExecutor = (JavascriptExecutor)Driver.getDriver(); // casted to JavaScriptExecutor
        Thread.sleep(4000);
                                         // javaScript method                // link where do we need to scroll
      javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", cybertekSchoolLink);
      // scroll down to the bottom of the page




    }
}
