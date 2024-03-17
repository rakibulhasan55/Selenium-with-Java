package com.InterviewQuestion;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
public class statusOfwebElement2 {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            //isDisplayed() //isEnabled()
        WebElement SearchStore= driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[2]/form/input"));
        System.out.println("Display : "+SearchStore.isDisplayed());
        System.out.println("Enable : "+SearchStore.isEnabled());
        // isSelected()
        WebElement male = driver.findElement(By.xpath("//*[@id=\"gender-male\"]"));
        WebElement female = driver.findElement(By.xpath("//*[@id=\"gender-female\"]"));
        System.out.println(male.isSelected()); //false
        System.out.println(female.isSelected()); //false
        male.click(); // clicked the button
        System.out.println(male.isSelected());// true
        System.out.println(female.isSelected());// false
        driver.quit();
    }
}
