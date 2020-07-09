package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SmartBearUtilities {

    public static void login(WebDriver driver){
        // 3.Enter username: “Tester”
        WebElement inputUserName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        inputUserName.sendKeys("Tester");
        // 4.Enter password: “test”
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        inputPassword.sendKeys("test");
        // 5.Click to Login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();

    }
/*
         •Method should verify if given name exists in orders.
         •This method should simply accepts a name(String),
          and assert whether given name is in the list or not.
         •Create a new TestNG test to test if the method is working as expected

 */
    public static void verifyOrder(WebDriver driver, String name){
    List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        for (WebElement each : namesList) {
            if (each.getText().equals(name)){
                Assert.assertTrue(true);
                return; // will exit whole method
            }
        }
        Assert.fail("The name does not exist in the list! Verification failed!");

    }
    //Practice #5: Method: printNamesAndCities
    // •Create a method named printNamesAndCitiesin SmartBearUtils class.
    // •Method takes WebDriver object.
    // •This method should simply print all the names in the List of All Orders.
    // •Create a new TestNG test to test if the method is working as expected.
    // •Output should be like:
    // •Name1: name , City1: city•Name2: name , City2: city

    public static void printNamesAndCities(WebDriver driver){
        // list where we store all names
        List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));
        // list where we store all cities
       List<WebElement> citiesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[7]"));

        // we will create regular for loop to use index i for names and cities
        for (int i = 0; i < namesList.size(); i++){
            System.out.println("Name: " + namesList.get(i).getText()+ ", Cities " + citiesList.get(i).getText());
        }


    }


}
