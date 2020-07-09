package test.day8_alerts_Iframes_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowsTabsPractice {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/windows");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

@Test
    public void p5_window_handle_practice() {
    // TC	#	:	Window	Handlepractice
    // 1.Create	a	new	class	called:	WindowHandlePractice
    // 2.Create	new	test	and	make	set	ups
    // 3.Go	to	:	http://practice.cybertekschool.com/windows

    // 4.Assert:	Title	is	“Practice”
    String currentWindowHandle = driver.getWindowHandle();
    System.out.println("currentWindowHandle = " + currentWindowHandle);

    // 5.Click	to:	“Click	Here”text
    WebElement clickHereLink = driver.findElement(By.xpath("//a[.='Click Here']"));
    clickHereLink.click();
    // 6.Switch	to	new	Window.

    // 7.Assert:	Title	is	“New	Window
    Set<String> windowHandles = driver.getWindowHandles();
    for (String each : windowHandles){
        driver.switchTo().window(each);                       // loop is used for print all windows that are open
        if (driver.getTitle().equals("New Window")){
            Assert.assertTrue(driver.getTitle().equals("New Window"));
            break;
        }
       // System.out.println(driver.getTitle());
    }

}

}
