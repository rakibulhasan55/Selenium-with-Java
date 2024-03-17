    /*1) What is Java Script Alert?
        2) How To Handle Java Script Alerts?
        3) How To Handle Authentication Popup?
        4) How To Handle Permission Pop-ups? */
package com.InterviewQuestion;

    import io.github.bonigarcia.wdm.WebDriverManager;
    import org.openqa.selenium.Alert;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.firefox.FirefoxDriver;

    public class S16JSAlert {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //2 Alert window with "OK" / single button
        driver.findElement(By.xpath(" //button[normalize-space()='Click for JS Alert']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept(); // accept() uses for single 'OK' button and close alert

        //2.1 Alert window with "OK" and "Cancel" Button
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
        Thread.sleep(3000);
         driver.switchTo().alert().accept(); // Close alert using "OK" button
        driver.switchTo().alert().dismiss(); // Close alert using "cancel" button

        //2.2 Alert window "Input Box and Capture Text" from alert
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
        Thread.sleep(3000);
         Alert alertWindow = driver.switchTo().alert();
         alertWindow.sendKeys("Welcome");
         System.out.println(alertWindow.getText());
         alertWindow.accept();
    }
}
