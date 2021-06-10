package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day09_Synchronization2 extends TestBase {
    /*
 Create a class:Day09_Synchronization2. Create a method: isEnabled
Go to https://the-internet.herokuapp.com/dynamic_controls
Click enable Button
And verify the message is equal to “It's enabled!”
And verify the textbox is enabled (I can type in the box)
And click on Disable button
And verify the message is equal to “It's disabled!”
And verify the textbox is disabled (I cannot type in the box)
     */

    @Test
    public void synchronization2(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Click enable Button
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();

        //And verify the message is equal to “It's enabled!”  //p[@id='message']
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement enabledMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        String enabledMessageText =enabledMessage.getText();
        Assert.assertEquals(enabledMessageText,"It's enabled!");

        // And verify the textbox is enabled (I can type in the box)  //input[@type='text']
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(textBox.isEnabled());//Checks if element is enable,Returns true if disabled

        //HOMEWORK(I DID)
        //And click on Disable button
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();

        //And verify the message is equal to “It's disabled!”
        WebElement disabledMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        String disabledMessageText= disabledMessage.getText();
        Assert.assertEquals(disabledMessageText,"It's disabled!");

        //And verify the textbox is disabled (I cannot type in the box)
        //WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textBox.isEnabled());


















    }

}
