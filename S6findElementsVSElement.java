package com.InterviewQuestion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class S6findElementsVSElement {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // findElement() ----> Single WebElement Return.
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]"));
        searchBox.sendKeys("XYZ");

        //findElements()------> return multiple webElement5s
        //1
       List<WebElement> links = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
       int a = links.size();
        System.out.println(a); // output = 22

        //printing every element using loop // webElements print a text
        for(WebElement ele: links){
            System.out.println(ele.getText());
        }

        //2 print single elements
       List<WebElement> logo = driver.findElements(By.xpath("//img[@alt='nopCommerce demo store']"));
       int b = logo.size();
        System.out.println(b); // output = 1

        //3 not match the xpath then return  o
        List<WebElement> notMatch = driver.findElements(By.xpath("//img[@alt='nopCommerce Electronices "));
        int c = notMatch.size();
        System.out.println(c); // output = 0


    }
}
