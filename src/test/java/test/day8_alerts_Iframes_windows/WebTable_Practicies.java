package test.day8_alerts_Iframes_windows;
import javafx.scene.control.TreeCellBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.awt.windows.ThemeReader;
import utilities.SmartBearUtilities;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class WebTable_Practicies {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //TC #1: Smartbear software link verification
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void p4_verify_order_test() throws Exception{
       // PRACTICE #4: Method: verifyOrder•
        // Create a method named verifyOrder in SmartBearUtils class.
        // •Method takes WebDriver object and String(name).
        // •Method should verify if given name exists in orders.
        // •This method should simply accepts a name(String),
        // and assert whether given name is in the list or not.
        // •Create a new TestNG test to test if the method is working as expected

        SmartBearUtilities.login(driver);

        Thread.sleep(2000);

        SmartBearUtilities.verifyOrder(driver, "Paul Brown");
    }


   @Test
    public void p5_print_names_cities_test() {
        SmartBearUtilities.login(driver);

        SmartBearUtilities.printNamesAndCities(driver);

   }

}
