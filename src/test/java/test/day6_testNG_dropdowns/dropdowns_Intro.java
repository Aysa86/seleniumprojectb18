package test.day6_testNG_dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class dropdowns_Intro {

    WebDriver driver; // class level, can use it in the all methods of the class

    @BeforeMethod
    public void setUp(){
        //TC#1: Verifying “Simple dropdown” and “State selection” dropdown default values
        // 1.Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        // 2.Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void test1_default_value_verification(){

        // 3.Verify “Simple dropdown” default selected value is correct Expected: “Please select an option”
        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
                                                    // WebElement                // converts into String
        String actualDefaultOfSimpleDropDown = simpleDropdown.getFirstSelectedOption().getText();
        String expectedDefaultOfSimpleDropDown = "Please select an option";

        Assert.assertEquals(actualDefaultOfSimpleDropDown, expectedDefaultOfSimpleDropDown);
        // 4.Verify“State selection” default selected value is correct Expected: “Select a State”

        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        String actualDefaultOfStateSelection = stateDropdown.getFirstSelectedOption().getText();
        String expectedDefaultOfStateSelection = "Select a State";

        Assert.assertEquals(actualDefaultOfStateSelection, expectedDefaultOfStateSelection);







    }
    @Test
    public void test2_state_dropdown_verification() throws InterruptedException{
        //TC #2: Selecting state from State dropdown and verifyingresult
        // 1.Open Chrome browser
        // 2.Go to http://practice.cybertekschool.com/dropdown

        Select stateDropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        Thread.sleep(2000);
        // 3.Select Illinois
        stateDropDown.selectByValue("IL");

        Thread.sleep(2000);
        // 4.Select Virginia
        stateDropDown.selectByVisibleText("Virginia");

        Thread.sleep(2000);
        // 5.Select California
        stateDropDown.selectByIndex(5);
        // 6.Verify final selected option is California.
        // Use all Select options.(visible text, value, index)

        String actualSelectedOption = stateDropDown.getFirstSelectedOption().getText();
        String expectedOption = "California";

        Assert.assertEquals(actualSelectedOption, expectedOption);

    }
     @Test
    public void test3_date_ofDropDonw_verification(){
        //TC #3: Selecting date on dropdown and verifying
        // 1.Open Chrome browser
        // 2.Go to http://practice.cybertekschool.com/dropdown

        // 3.Select “December 1st, 1921” and verify it is selected.
         // Select year using: visible text
        Select year = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        year.selectByVisibleText("1921");

        String actualYear = year.getFirstSelectedOption().getText();
        String expectedYear = "1921";

        // Select month using : value attribute
         Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
         month.selectByValue("11");

         String actualMonth = month.getFirstSelectedOption().getText();
         String expectedMonth = "December";


        // Select day using: index number
         Select day = new Select(driver.findElement(By.xpath("//select[@id='day']")));
         day.selectByIndex(0);

         String actualDay = day.getFirstSelectedOption().getText();
         String expectedDay = "1";

         Assert.assertEquals(actualYear, expectedYear);
         Assert.assertEquals(actualMonth, expectedMonth);
         Assert.assertTrue(actualDay.equals(expectedDay));
    }
    @Test
    public void test4_select_value_fromMultiple_dropDown(){
        //TC #4: Selecting value from multiple select dropdown
        // 1.Open Chrome browser
        // 2.Go to http://practice.cybertekschool.com/dropdown
        // 3.Select all the options from multiple select dropdown.
        // 4.Print out all selected values.
        // 5.Deselect all values.

       //Locating select dropdown
        Select languagesDropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        //Getting all of the options from dropdown and storing them into list of web elements
        List<WebElement> allOptions = languagesDropdown.getOptions();
        //Looping through the options and selecting them
        for(WebElement option : allOptions) {
            option.click();
            System.out.println("Selected: " + option.getText());
            //Doing the assertion after selecting
            Assert.assertTrue(option.isSelected());
        }
        languagesDropdown.deselectAll();
        //Asserting they are de-selected
        for (WebElement option1 : allOptions) {
            Assert.assertFalse(option1.isSelected());
        }
        //driver.close();
        //Use all Select options.
    }

    @Test
    public void test5_non_select_dropdown(){
        //TC #5: Selecting value from non-select dropdown
        // 1.Open Chrome browser
        // 2.Go to http://practice.cybertekschool.com/dropdown
        // 3.Click to non-select dropdown
        // 4.Select Facebook from dropdown
        // 5.Verify title is “Facebook -Log In or Sign Up”
        
        //Locating the non-select dropdown
        WebElement webSiteDropdown = driver.findElement(By.xpath("//div[@class='dropdown']/a"));
        //Clicking to open the dropdown
        webSiteDropdown.click();
        //Locating Facebook link from the non-select dropdown
        WebElement facebookLink = driver.findElement(By.xpath("//a[.='Facebook']"));
        //Clicking to the Facebook link
        facebookLink.click();
        //Creating expected title
        String expectedFacebookTitle = "Facebook - Log In or Sign Up";
        //String getting the actual title
        String  actualTitle = driver.getTitle();


        //Asserting actual vs expected
        Assert.assertEquals(actualTitle, expectedFacebookTitle);
    }





}
