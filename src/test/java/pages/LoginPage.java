package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

/*
We will store all login page related web elements and methods into this class
 */
public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
        // creates connection between our driver and instance of the class
    }
    // locating userName input box
    @FindBy(id = "prependedInput")
    public WebElement usernameInput;

    // locating password input box
    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    // locating loginButton input box
    @FindBy(id = "_submit")
    public WebElement loginButton;

    // locating errorMessage
    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage;

    // locating forgot password link
    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPasswordLink;

    public void login(String userName, String password){
      usernameInput.sendKeys(userName);
      passwordInput.sendKeys(password);
      loginButton.click();

    }

}
