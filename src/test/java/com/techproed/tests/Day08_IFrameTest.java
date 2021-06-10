package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day08_IFrameTest extends TestBase {
    /*
Create a class: Day08_IFrameTest
Create a method: iframeTest
Go to https://the-internet.herokuapp.com/iframe
Verify the Bolded text contains “Editor”
Locate the text box
Delete the text in the text box
Type “This text box is inside the iframe”
Verify the text Elemental Selenium text is displayed on the page
     */

    @Test
    public void iFrameTest(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Verify the Bolded text contains “Editor”
        String headerText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(headerText.contains("Editor"));

        //iframe xpath for iframe******************

        //1. switching using id
        //driver.switchTo().frame("mce_0_ifr");

        //2.switching the first iframe using index
        //driver.switchTo().frame(0);


        //3.switching to iframe using the iframe Webelement
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeElement);

        //NOW WE ARE INSIDE THE FRAME



        //Locate the text box
        WebElement textBox = driver.findElement(By.xpath("//p"));

        //Delete the text in the text box
        textBox.clear();

        //Type “This text box is inside the iframe”
        textBox.sendKeys("This text box is inside the iframe");


        //Verify the text "Elemental Selenium" text is displayed on the page
        //NOTE: This element is outside of the iframe ,SO DRIVER MUST BE OUTSIDE
        driver.switchTo().parentFrame(); //takes 1 level up
        driver.switchTo().defaultContent(); //takes all level up
        WebElement elementSelenium = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementSelenium.isDisplayed());

    }





}
