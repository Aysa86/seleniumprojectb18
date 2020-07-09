package test.WarmUp;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;

public class TC_6_cybertek_registration_form {
    @Test
    public void registrationForm(){
//TC#6: Cybertek registration form confirmationNote: Use JavaFaker when possible.
        // 1.Open browser
        // 2.Go to website: http://practice.cybertekschool.com/registration_form
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/registration_form");
        driver.manage().window().maximize();
        // 3.Enter first name
        WebElement firstNameInput = driver.findElement(By.xpath("//input[@name='firstname']"));
        Faker faker = new Faker();
        firstNameInput.sendKeys(faker.name().firstName());

        // 4.Enter last name
        WebElement lastNameInput = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastNameInput.sendKeys(faker.name().lastName());

        // 5.Enter username
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='username']"));
        String name = faker.name().username().replace(".","");
        usernameInput.sendKeys(name);

        // 6.Enter email address
        WebElement emailAddressInput = driver.findElement(By.xpath("//input[@name='email']"));
        emailAddressInput.sendKeys(faker.internet().emailAddress());

        // 7.Enter password
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(faker.internet().password());

        // 8.Enter phone number
        WebElement phoneNumberInput = driver.findElement(By.xpath("//input[@name='phone']"));
        //phoneNumberInput.sendKeys(faker.phoneNumber().cellPhone());
        phoneNumberInput.sendKeys(Keys.BACK_SPACE + "123-456-789");
        // 9.Select a gender from radio buttons



        // 10.Enter date of birth
        // 11.Select Department/Office
        // 12.Select Job Title
        // 13.Select programming language from checkboxes
        // 14.Clickto sign up button
        // 15.Verify success message “You’ve successfully completed registration.”is displayed.
    }


}
