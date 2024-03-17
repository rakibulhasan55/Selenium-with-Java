package com.InterviewQuestion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class S7InputBox {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        // clear and input
        WebElement emailInputBox = driver.findElement(By.id("Email"));
        emailInputBox.clear();
        emailInputBox.sendKeys("rakibul@gmail.com");

        //Capturing txt from input Box
        System.out.println(emailInputBox.getAttribute("value"));

        // For Login Button
        WebElement login = driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
        System.out.println(login.getAttribute("class"));
        System.out.println(login.getAttribute("type"));

        System.out.println(login.getText());


    }
}
