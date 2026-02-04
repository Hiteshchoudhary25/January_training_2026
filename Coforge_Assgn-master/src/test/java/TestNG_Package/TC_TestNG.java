package TestNG_Package;


import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.DataProvider;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeSuite;

import org.testng.annotations.AfterSuite;
 
public class TC_TestNG {

  @Test(dataProvider = "dp")

  public void f(Integer n, String s) {

	  System.out.println("This is test");

  }

  @BeforeMethod

  public void beforeMethod() {

	  System.out.println("This is Before Method");

  }
 
  @AfterMethod

  public void afterMethod() {

	  System.out.println("This is After Method");

  }
 
 
  @DataProvider

  public Object[][] dp() {

    return new Object[][] {

      new Object[] { 1, "a" },

      new Object[] { 2, "b" },

    };

  }

  @BeforeClass

  public void beforeClass() {

	  System.out.println("This is Before Class");

  }
 
  @AfterClass

  public void afterClass() {

	  System.out.println("This is After Class");

  }
 
  @BeforeTest

  public void beforeTest() {

	  System.out.println("This is Before test");

  }
 
  @AfterTest

  public void afterTest() {

	  System.out.println("This is after test");

  }
 
  @BeforeSuite

  public void beforeSuite() {

	  System.out.println("This is Before suite");

  }
 
  @AfterSuite

  public void afterSuite() {

	  System.out.println("This is after suite");

  }
 
}

 