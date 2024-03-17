package com.InterviewQuestion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.facebook.login.driver;

public class S8MultiDropDowns {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
        /*
        s1
        Select productsDrp = new Select(driver.findElement(By.id("first")));
        productsDrp.selectByVisibleText("Google");
        Select animal = new Select(driver.findElement(By.id("animals"))) ;
        animal.selectByVisibleText("Avatar");*/

        //S2
        WebElement productDrp= driver.findElement(By.id("first"));
        selectOptionFromDropDown(productDrp,"Google");
        WebElement animal=  driver.findElement(By.id("animals"));
        selectOptionFromDropDown(animal,"Avatar");
    }
    public static void selectOptionFromDropDown(WebElement ele,String value){
        Select drp = new Select(ele);
        List<WebElement>allOptions = drp.getOptions();
        for(WebElement option:allOptions){
            if(option.getText().equals("value")){
                option.click();
                break;
            }
        }
    }

}
