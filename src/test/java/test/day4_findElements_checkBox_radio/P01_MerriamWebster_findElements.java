package test.day4_findElements_checkBox_radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P01_MerriamWebster_findElements {
    public static void main(String[] args) {


        //TC #0: FINDELEMENTS
        // 1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        // 2.Go to https://www.merriam-webster.com/

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.merriam-webster.com/");
        // 3.Print out the texts of all links
      List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));


        int linkWithoutText = 0;
        int linksWithText = 0;
        for (WebElement eachLink : listOfLinks) {
            String textOfEachLink = eachLink.getText();
            // System.out.println(eachLink.getText()); prints all links
          if (textOfEachLink.isEmpty()){
              linkWithoutText++;
          }else{
              System.out.println(textOfEachLink);
              linksWithText++;
          }

        }
        // 4.Print out how many link is missing text
        System.out.println("The number of links that does not have text: "+linkWithoutText);

        // 5.Print out how many link has text
        System.out.println("The number of links that has text: "+linksWithText);
        // 6.Print out how many total link
        System.out.println("Total links on this page: "+listOfLinks.size());




    }

}
