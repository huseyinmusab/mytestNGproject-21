package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Day08_WindowHandleExample extends TestBase {
/*
Create a new Class Tests package: Day08_WindowHandleExample
Method name:windowHandle
Given user is on the https://the-internet.herokuapp.com/windows
Then user verifies the text : “Opening a new window”
Then user verifies the title of the page is “The Internet”
When user clicks on the “Click Here” button
Then user verifies the new window title is “New Window”
Then user verifies the text:  “New Window”
When user goes back to the previous window and then verifies the title : “The Internet”
 */
    @Test
    public void windowHandle() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/windows");

        //Then user verifies the text : “Opening a new window”
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

        //Then user verifies the title of the page is “The Internet”
        Assert.assertEquals(driver.getTitle(),"The Internet");

        //When user clicks on the “Click Here” button
        driver.findElement(By.linkText("Click Here")).click();


        //Driver is on the Window1
        //System.out.println(driver.getCurrentUrl());


        String window1 = driver.getWindowHandle();//returns the id of current window
        Set<String>allWindows = driver.getWindowHandles(); //returns all windows
        //allWindows has window1 and window2
        //How do you handle multiple windows?
        //switch to the windows
        for (String eachWindow:allWindows){

            //System.out.println("Window Handle:" + eachWindow);
            //If driver is already om window1,then DO NOT SWITCH
            //If driver is NOT on window1,then SWITCH TO THE OTHER WINDOW
            if (!eachWindow.equals(window1)){

                driver.switchTo().window(eachWindow);
                System.out.println(driver.getCurrentUrl());
            }

        }
        //Now driver is on the new window
        //Then user verifies the new window title is “New Window”
        Assert.assertEquals(driver.getTitle(),"New Window");


        //Then user verifies the text:  “New Window”
        //Print the heading text New Window
        System.out.println(driver.findElement(By.xpath("//h3")).getText());


        //When user goes back to the previous window and then verifies the title : “The Internet”
        //DRIVER IS ON WINDOW 2 NOW
        String window2 =driver.getWindowHandle(); //getting the window2 handle
        for (String eachWindow:allWindows){

            if (!eachWindow.equals(window2)){

                driver.switchTo().window(eachWindow);
                System.out.println(driver.getCurrentUrl());
            }

        }
        Assert.assertEquals(driver.getTitle(),"The Internet");



    }


}
