package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class Day09_ActionsClass03 extends TestBase {
/*
Create a class: ActionsClass3
Create test method : keysUpDown()
Go to google
Send iPhone X prices => convert small letter capital vice versa.
Highlight the search box by double clicking
 */

    @Test
    public void keysUp() throws InterruptedException {
        //        Go to google
        //        Send 'iPhone X prices' => convert small letter capital vice versa.
        //        Highlight the search box by double clicking

        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        //searchBox.sendKeys("iPhone X prices");



        Actions actions = new Actions(driver);
        //        actions.keyDown("WEBELEMENT==>(where to type) ","COMMAND LIKE KeysUp or KeysDown or KeysShift")

        Thread.sleep(3000);
        actions.
                keyDown(searchBox, Keys.SHIFT).//Pressing SHIFT on keyboard
                sendKeys("iphone x prices").   //sending small letter and expecting capitol letters being typed
                keyUp(searchBox,Keys.SHIFT).   //Unpressing SHIFT on keyboard
                sendKeys("  too expensive").     //sending normal letters because no longer pressing shift
                perform();                     //performing the task
        Thread.sleep(3000 );


        //        INPUT             OUTPUT
//        iPhone X prices => IPHONE X PRICES  because I am testing if capital letter search works


//        keyDown     (       searchBox,       Keys.SHIFT      ).
//        PRESS               ELEMENT          SHIFT on keyboard





    }
}
