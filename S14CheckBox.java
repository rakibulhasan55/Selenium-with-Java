package com.InterviewQuestion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class S14CheckBox {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        // 1 select specific cheek Box
         driver.findElement(By.xpath(" //input[@id='profession-0']")).click();//Manual
        //2 Select All Cheek boxes
        List<WebElement> checkboxes = driver.findElements(By.xpath(" //input[@type='checkbox' and contains(@id,'profession-')]"));
        int count = checkboxes.size();
        System.out.println(count);
        //using normal for loop (Select All Cheek boxes)
        for (int i=0;i<=checkboxes.size();i++){
            checkboxes.get(i).click();
        }
        // using for each loop (Select All Cheek boxes)
        for ( WebElement chBox:checkboxes){
            chBox.click();
        }
        //3 select checkbox Based on my choice
        for(WebElement chBoxes:checkboxes){
           String checkBoxName= chBoxes.getAttribute("id");
           if(checkBoxName.equals("profession-0") || checkBoxName.equals("profession-1")){
               chBoxes.click();
           }
        }
        //4 Select last one check box [total number of box - no of checkbox want to select]
        for(int i = count-1;i<=count;i++){
            checkboxes.get(i).click();
        }
        //5 Select fist one check box
        for(int i = 0;i<=count;i++){
            if(i<1){                 //[1 = number of checkbox want to select]
                checkboxes.get(i).click();
            }
        }

    }
}
