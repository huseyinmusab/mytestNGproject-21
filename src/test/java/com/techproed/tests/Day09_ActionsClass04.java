package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.security.Key;

public class Day09_ActionsClass04 extends TestBase {
        //        Create a class: ActionClass4
        //        Create test method : scrollUpDown()
        //        Go to amazon
        //        Scroll the page down
        //        Scroll the page up

    @Test
    public void scrollUpDown() throws InterruptedException {
        driver.get("https://www.amazon.com/");


        Actions actions = new Actions(driver);
        //        PAGE_DOWN =>scrolling down
        //        PAGE_UP =>scrolling up
        //        ARROW_DOWN =>scrolling down
        //        ARROW_UP =>scrolling up
        Thread.sleep(3000);
        //scroll down
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);

        //        ARROW_DOWN scrolls a little bit. This is same as clicking down button once on keyboard
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        //        SCROLL UP
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);
//        SCROLL UP
        actions.sendKeys(Keys.PAGE_UP).perform();

//        ARROW_UP moves the page up a little bit
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_UP).perform();















    }
}
