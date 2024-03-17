package com.InterviewQuestion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.List;
public class S16BrokenLinks {
    public static void main(String[] args) throws MalformedURLException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.deadlinkcity.com/");
        //Capture all the links
        List<WebElement> links = driver.findElements(By.tagName("a"));
        int brokenLinks = 0;
        for(WebElement element:links){
            String url = element.getAttribute("href");
            if(url==null || url.isEmpty()){
                System.out.println("URL is Empty");
                continue;
            }
            URL link = new URL(url);
            try{
                HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
                httpConn.connect();
                if(httpConn.getResponseCode()>=400){
                    System.out.println(httpConn.getResponseCode() +url+" is"+ " Broken link");
                    brokenLinks++;
                }
                else{
                    System.out.println(httpConn.getResponseCode() +url+" is"+ " Valid Link");
                }
            } catch (Exception e) {

            }
        }
        System.out.println("Number of Broken Links is "+brokenLinks);
    }
}
