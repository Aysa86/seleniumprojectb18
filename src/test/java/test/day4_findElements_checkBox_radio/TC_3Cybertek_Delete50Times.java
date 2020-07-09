package test.day4_findElements_checkBox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;


public class TC_3Cybertek_Delete50Times {
    public static void main(String[] args) {

       // TC #3 Practice Cybertek.com_AddRemoveElements Web Element verification
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //2. Go to http://practice.cybertek.com/add_remove_elements/
        driver.get("http://practice.cybertek.com/add_remove_elements/");
       //3.  Click to button 50 times
        WebElement addElement = driver.findElement(By.xpath("//button[.='Add Element']"));
        for(int a = 0; a < 50; a++) {
           addElement.click();
        }
        //4. Verify 50 button is displayed after clicking.
        List<WebElement> listOfDeleteButtons = driver.findElements(By.xpath("//button[.='Delete']"));
        WebElement deleteButton = driver.findElement(By.xpath("//button[.='Delete']"));
        System.out.println("Number of delete buttons on the page: " + listOfDeleteButtons.size());
        //5. Click to all "Delete" buttons to delete them
        for (WebElement button : listOfDeleteButtons) {
            button.click();
        }
            //6. Verify "Delete" button is not displayed after clicking

        try {           if (!deleteButton.isDisplayed()){
            System.out.println("Delete button is NOT displayedafter clicking. PASS!");
        }else{
            System.out.println("Delete button is displayed after clicking. FAILED!");
        }       }catch (StaleElementReferenceException exception){
            System.out.println("StaleElementException has been thrown.");
            System.out.println("It means element has been completely deleted from the HTML.");
            System.out.println("Delete button is not displayed. Verification PASSED!");
        }


    }
}
