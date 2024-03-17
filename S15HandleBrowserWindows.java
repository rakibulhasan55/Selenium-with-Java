package com.InterviewQuestion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class S15HandleBrowserWindows {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        // 1 getWindowHandle() -->return the id of single browser window
        /* String windowId = driver.getWindowHandle();
        System.out.println(windowId);*/
        // 2 getWindowHandles()--->//
        // Open another browser window bellow Exp
        driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
        Set<String> windowIDs = driver.getWindowHandles();// return id's of multiple browser
        //2.1 iterator() method for get window ID
        Iterator<String> it = windowIDs.iterator();
        String parentWindowID = it.next();
        String childWindowId = it.next();
        System.out.println("ParentID : "+ parentWindowID);
        System.out.println("ChildID : " + childWindowId);
        //2.3 Using list/Array List for get window ID
        List<String> windowIdsList = new ArrayList<>(windowIDs);//convert set to list
        String ParentWindowID = windowIdsList.get(0);// parent
        String ChildWindowID = windowIdsList.get(1);//child
        System.out.println(ParentWindowID);
        System.out.println(ChildWindowID);
        // 3 How to use windowId's for switching
        driver.switchTo().window(ParentWindowID);
        System.out.println(driver.getTitle()); //parent
        driver.switchTo().window(ChildWindowID);
        System.out.println(driver.getTitle()); //Child
        // 3.1 using for each loop for get window ID
        for(String winId:windowIdsList){
            //System.out.println(winId);
            String title = driver.switchTo().window("winId").getTitle();
            System.out.println(title);
        }
        // 4 pit comment
        driver.close();//close single window
        driver.quit();//quit the browser
        //5 particular page close chose bt page tittle
        for(String winId:windowIdsList){
            String title = driver.switchTo().window("winId").getTitle();
            if(title.equals("OrangeHRM") || title.equals("Another title")){
                driver.close();
            }
        }

    }
}
