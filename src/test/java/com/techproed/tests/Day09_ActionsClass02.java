package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

public class Day09_ActionsClass02 extends TestBase {
    /*
    Create a class: ActionClass2
Create test method : hoverOver() and test the following scenario:
Given user is on the https://www.amazon.com/
When use click on “Account” link
Then verify the page title contains “Your Account”
     */

    @Test
    public void hoverOver() throws InterruptedException {
        driver.get("https://www.amazon.com/");


        WebElement accountAndList=driver.findElement(By.id("nav-link-accountList"));

        Actions actions =new Actions(driver);

        Thread.sleep(1000);

        actions.moveToElement(accountAndList).perform();//move the mouse over accountAndList (DO ALSO  NOT FORGET PERFORM)

        Thread.sleep(1000);

        //        WE CAN GET ALL OF THE LINKS AS LIST<WEBELEMENT>
        //div[@id='nav-al-your-account']//span   => give me ALL span elements under div[@id='nav-al-your-account']

        List<WebElement>allElements =driver.findElements(By.xpath("//div[@id='nav-al-your-account']//span"));//===> we add span later to xpath,
                                                                                                             // it is important to get all elements
                                                                                                             // by usIng GOOD XPATH

        for (WebElement eachElement: allElements){
            System.out.println(eachElement.getText());

        }

        WebElement accountLink=driver.findElement(By.linkText("Account"));
        //        When use click on “Account” link
        accountLink.click();
        //        Then verify the page title contains “Your Account”
        Assert.assertTrue(driver.getTitle().contains("Your Account"));









    }
}
