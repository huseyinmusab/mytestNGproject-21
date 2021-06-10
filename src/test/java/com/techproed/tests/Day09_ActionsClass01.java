package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day09_ActionsClass01 extends TestBase {
    /*
    Create a class: ActionsClass1
Create a test method : contextClickMethod() and test the following scenario:
Given user is on the https://the-internet.herokuapp.com/context_menu
When use Right clicks on the box
Then verify the alert message is “You selected a context menu”
Then accept the alert
     */
    @Test
    public void contextClickMethod(){

        driver.get("https://the-internet.herokuapp.com/context_menu");

        //    When use Right clicks on the box
        WebElement box = driver.findElement(By.id("hot-spot"));

        //1. create Actions object, and use appropriate method of Actions
        Actions actions=new Actions(driver);
        actions.contextClick(box).perform(); //====> do not forget perform even if it seems to work

        //    Then verify the alert message is “You selected a context menu”
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText,"You selected a context menu");

        //Then accept the Alert
        driver.switchTo().alert().accept();













    }



}
