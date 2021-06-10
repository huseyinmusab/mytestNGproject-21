package com.techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day07_DependsOnMethods {

    @Test
    public void logIn(){
        System.out.println("Login Test");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "logIn")//logIn runs before homePage,
                                     //homePage only runs if logIn PASS.
                                    //otherwise homePage will be skipped.
                                     //homePage depends on logIn method
    public void homePage(){
        System.out.println("homePage Test");
    }


    @Test(priority = 1)
    public void search(){
        System.out.println("search Test");
    }
    @Test(priority = 2)
    public void searchResult(){
        System.out.println("search Result Test");
    }

}
