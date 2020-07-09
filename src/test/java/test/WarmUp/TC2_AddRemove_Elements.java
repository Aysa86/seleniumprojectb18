package test.WarmUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

public class TC2_AddRemove_Elements {
    public static void main(String[] args) throws Exception{

        //XPATH PRACTICESDO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #2: PracticeCybertek.com_AddRemoveElements WebElement verification
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //2. Go to http://practice.cybertekschool.com/add_remove_elements
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        Thread.sleep(2000);
        //3. Click to “Add Element” button
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();

        Thread.sleep(2000);
        //4. Verify “Delete” button is displayed after clicking.
       WebElement deleteButton = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        if(deleteButton.isDisplayed()){
            System.out.println("Delete button verification PASSED");
        }else {
            System.out.println("Delete button verification FAILED");
        }
       // 5. Click to “Delete” button.
        Thread.sleep(2000);
        deleteButton.click();
        //6. Verify “Delete” button is NOT displayed after clicking.
         //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
        WebElement deleteIsNotDisplayed = driver.findElement(By.xpath("//div[@id='elements']"));
        if (deleteIsNotDisplayed.isDisplayed()){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        Thread.sleep(1000);
        driver.close();
    }
}
