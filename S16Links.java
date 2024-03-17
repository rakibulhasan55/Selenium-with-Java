/*1. How To Locate links in Selenium WebDriver?
2. What is the difference between LinkText() and PartialLinkText()?
3. How to capture all the links from Web Page?
4. What is Broken Link? How to check it? */

package com.InterviewQuestion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class S16Links {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();

        //1 Using LinkText()---> Pass the full Text
        driver.findElement(By.linkText("Today's Deals")).click();
        //2 Using partialLinkText()---> Pass anything of the Partial Text.
        driver.findElement(By.partialLinkText("Deals")).click();

        //3. How to capture all the links from Web Page?
       List<WebElement> links = driver.findElements(By.tagName("a"));
       //3.1 Count all the links
       int count = links.size();
        System.out.println("Total Number of Links : " + count); // 265 Links in this page

        // 3.2 Printing all the links in my console using normal "for loop"
        for(int i=0;i<=count;i++){
            String LinksName = links.get(i).getText(); //Get the name of the links(Link Text)
            System.out.println(LinksName);
            String AllLinks = links.get(i).getAttribute("href");
            System.out.println(AllLinks); // Get the target page's links (actual vale of 'href')
        }
        //3.3 Printing all the links in my console using  "for each loop"
        for(WebElement link : links){
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        }
    }
}
