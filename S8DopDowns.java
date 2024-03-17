package com.InterviewQuestion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class S8DopDowns {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.opencart.com/index.php?route=account/register");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebElement drpCountryEle =  driver.findElement(By.id("input-country"));
        Select drpCountry = new Select(drpCountryEle);

        //step1 using method
        drpCountry.selectByVisibleText("Denmark");
        drpCountry.selectByValue("10"); // Argentina
        drpCountry.deselectByIndex(13);//Australia

        //Using For each loop
        List<WebElement> AllOptions = drpCountry.getOptions();
            for(WebElement option : AllOptions){
                if(option.getText().equals("Cuba")){
                    option.click();
                    break;
                }
            }

    }
}
