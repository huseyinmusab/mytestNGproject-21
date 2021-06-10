package com.techproed.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Day06_TestNGAnnotations {


    //    @BeforeMethod : Runs before each method. Same as @Before in JUnit
    @BeforeMethod
    public void setUp(){
        System.out.println("Set Up Method");
    }



    //    @Test : creates test case
    @Test
    public void test1(){
        System.out.println("Test 1");

    }
    //    Ignore : Skips test case
    @Ignore
    @Test
    public void test2(){
        System.out.println("Test 2");
    }
    @Test(priority = -5)
    public void test3(){
        System.out.println("Test 3");
    }

    @Test(priority = 2+1)
    public void test4(){
        System.out.println("Test 4");
    }

    //    @AfterMethod : Runs after each @Test annotation(after each method)***************
    //    Same as @After in JUnit
    @AfterMethod
    public void tearDown(){
        System.out.println("Tear Down");
    }
    //    By default, @Test runs in alphabetical order
    //    @Test(priority=1) -> priority prioritize test cases




}
