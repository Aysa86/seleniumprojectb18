package test.day6_testNG_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGPractice {

    @AfterClass
    public void afterClass(){
        System.out.println("After CLASS is running=======");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before CLASS is running=======");
    }
    @BeforeMethod
    public void setUp(){
        System.out.println("Before method is running...");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After method is running...");
    }
    @Test
    public void test1(){
        System.out.println("Test 1 is running...");

        String actualTitle = "Homepage"; // driver.getTitle();
        String expectedTitle = "Homepage";

        Assert.assertEquals(actualTitle, expectedTitle);

        /*if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification passed");
        }else{
            System.out.println("Title verification failed");
        }*/
    }
    @Ignore // ignore specific test, it's not gonna run
    @Test
    public void test2(){
        System.out.println("Test 2 is running...");

        Assert.assertEquals("string1", "string2","string verification on string2 failed");
    }
    @Test
    public void test3(){
        System.out.println("Test 3 is running...");

        String actualTitle = "Amazon prime";
        String expectedInTitle = "prime";
       // System.out.println(actualTitle.contains(expectedInTitle)); true
        Assert.assertTrue(actualTitle.contains(expectedInTitle));

        String testString = "Hello";
        Assert.assertFalse(actualTitle.contains(testString));
    }
}
