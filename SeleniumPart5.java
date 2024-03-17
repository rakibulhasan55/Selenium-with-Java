package com.InterviewQuestion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.DriverManager;
import java.time.Duration;

public class SeleniumPart5 {
    //1. How to Navigate Back & Forward?
    // 2. How to Refresh Page?
    //3. What is the difference between get() & navigate.to()?

    public static void main(String[] args) {

        WebDriverManager.firefoxdriver();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.get("https://www.amazon.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.navigate().back(); // back and go to orangeHrm
        driver.navigate().forward(); // after orange hrm then go amazon
        driver.navigate().refresh();// refesh/relode instance page

        driver.navigate().to(""); // same as driver.get method


    }

}
