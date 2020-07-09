package test.day7_javaFaker_webTables;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.security.Key;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTests {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        //TC #1: Smartbear software link verification
        // 1.Open browser
        // 2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        SmartBearUtilities.login(driver);
    }
    @Test
    public void p1SmartBear_login_test(){

        // 6.Print out count of all the links on landing page
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));
        //System.out.println("Number of links: "+allLinks.size());
        int expectedNumberOfLinks = 6;
        int actualNumberOfLinks = allLinks.size();
        Assert.assertEquals(expectedNumberOfLinks, actualNumberOfLinks);

        // 7.Print out each link text on this page
        for (WebElement link : allLinks){
            System.out.println(link.getText());
        }
    }
    @Test
    public void p2_smartBear_order_placing(){
        //TC#2: Smartbearsoftware order placing

        // 6.Click on Order
        WebElement orderLink = driver.findElement(By.xpath("//a[.='Order']"));
        orderLink.click();
        // 7.Select familyAlbum from product, set quantity to 2
        Select productDropDown = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        productDropDown.selectByVisibleText("FamilyAlbum");
        WebElement quantityInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        //quantityInput.clear(); // deletes if there is any existing input in input box
        quantityInput.sendKeys(Keys.BACK_SPACE);
        quantityInput.sendKeys("2" );

        // 8.Click to “Calculate” button
        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();
        // 9.Fill address Info with JavaFaker
        WebElement inputCustomerName = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement inputStreet = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement inputCity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement inputState = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        WebElement inputZip = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        //•Generate: name, street, city, state, zip code
        Faker faker = new Faker();

        inputCustomerName.sendKeys(faker.name().fullName());
        inputStreet.sendKeys(faker.address().streetAddress());
        inputCity.sendKeys(faker.address().city());
        inputState.sendKeys(faker.address().state());
       String zip = faker.address().zipCode().replaceAll("-", "");
         inputZip.sendKeys(zip);
        // 10.Click on “visa” radio button
        WebElement visaCard = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visaCard.click();
        // 11.Generate card number using JavaFaker
        WebElement inputCardNumber = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        inputCardNumber.sendKeys( faker.finance().creditCard().replaceAll("-", ""));

        WebElement expirationDate = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        expirationDate.sendKeys("12/25");

        // 12.Click on “Process”
        WebElement processButton = driver.findElement(By.xpath("//a[.='Process']"));
       processButton.click();
        // 13.Verify success message “New order has been successfully added.”
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));
        Assert.assertTrue(successMessage.isDisplayed());
    }

    @Test
    public void p3_smart_bear_order_verification(){
        //TC#3: Smartbear software order verification
        // 1.Open browser and login to Smartbear software
        // 2.Click on View all orders
        WebElement AllOrdersLink = driver.findElement(By.xpath("//a[.='View all orders']"));
        // 3.Verify Susan McLaren has order on date “01/05/2010”
        WebElement ActualOrderVerification = driver.findElement(By.xpath("//td[.='Susan McLaren']/../td[5]"));

        String expectedDate = "01/05/2010";
        String actualDate = ActualOrderVerification.getText();

        System.out.println(ActualOrderVerification.getText());
        Assert.assertEquals(actualDate, expectedDate);



    }



}
