package test.day8_alerts_Iframes_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownPracticies {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
   // TC#7: Cybertek “month”dropdown default value
   // 1.Open browser
   // 2.Go to website: http://practice.cybertekschool.com/dropdown
   // 3.Verify default value is always showing the current month
   // Expected: If currently in June, should show June selected
    @Test
    public void p7_month_dropdown_default_value_test(){
        // locating the dropdown
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        // creating our actual and expected values
        String actualDropdown = monthDropdown.getFirstSelectedOption().getText();
        System.out.println("Actual drop down: "+actualDropdown);

        String expectedDropdown = LocalDateTime.now().getMonth().name();
        System.out.println("Expected drop down: "+expectedDropdown);
//1 :
        Assert.assertEquals(actualDropdown.toLowerCase(), expectedDropdown.toLowerCase());
//2 :
        Assert.assertTrue(actualDropdown.equalsIgnoreCase(expectedDropdown));



        //Practice #8
       // Cybertek “month”dropdown list of default values verification
        // 1.Do both verifications in the same test
        // 2.Verify list of months are correct as expected.
        // Expected: Options should contain all 12 months of the year.
        List<WebElement> actualDropdownOptions = monthDropdown.getOptions();

        List<String> expectedDropdownOptions = Arrays.asList("January","February","March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

        // list of strings to use it as a container to the texts of actual dropdown values
        List<String> actualMonthText = new ArrayList<>();

        for (WebElement each : actualDropdownOptions){
            actualMonthText.add(each.getText());
        }

         Assert.assertEquals(actualMonthText, expectedDropdownOptions);






    }
}
