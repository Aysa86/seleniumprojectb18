package test.day1_selenium_Intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariBrowser {
    public static void main(String[] args) {

        WebDriver safari = new SafariDriver();
        safari.get("https://www.google.com");



    }
}
