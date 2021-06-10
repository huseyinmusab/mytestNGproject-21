package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.security.Key;

public class Day07_TestBaseDemo extends TestBase {

    //    We are using TestBase
    //    BeforeMethod and AfterMethod automatically runs
    //    This test class is now cleaner

    @Test
    public void test01(){
        //        Create a class:TestBaseDemo
        //        Create two methods: test1, test2
        //        test1 search “porcelain teapot” on google
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("porcelain teapot"+ Keys.ENTER);

        //        Then verify page contains “porcelain teapot”
        Assert.assertTrue(driver.getPageSource().contains("porcelain teapot"));
        //pageSource gives all html elemets on the page

    }

        //        test2 search “porcelain teapot” on amazon
        //        Then verify page contains “porcelain teapot”
        @Test
        public void test2(){
            driver.get("https://www.amazon.com/");
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("porcelain teapot" + Keys.ENTER);
            Assert.assertTrue(driver.getPageSource().contains("porcelain teapot"));

        }



}
