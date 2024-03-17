package com.InterviewQuestion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class S17JsAuthenticatedPopup {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver();
        WebDriver driver  = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/basic_auth");

        //Authenticated Popup = Skip popup and direct login
        // Syntax = ("https://Username:Password@URL")
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        // Permission Popup for Notification
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-notifications");
        driver.get("https://www.redbus.in/");

    }
}
