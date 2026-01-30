package com.orhrm.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
 
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.orhrm.Base.BaseTest;
import com.orhrm.utilities.configreader;
import com.orhrm.utilities.extentmanager;
import com.orhrm.utilities.screenshotutil;
 
import SeleniumPac.Login_POM;
 
public class logintest extends BaseTest{
	
	ExtentReports extent=extentmanager.getreport();
	
	static String projectpath=System.getProperty("user.dir");
	@Test(dataProvider = "logindata")
	  public void verifylogin(String url,String username, String password) throws IOException {
		  
		  System.out.println("This is test");
		  Login_POM obj=new Login_POM(driver);
		  
		  		driver.get(url);
		  	  		
		  		ExtentTest test=extent.createTest("Verify the login");
		  		
		  		obj.enterusername(username);
		  		obj.enterpassword(password);
		  		obj.clickonsubmit();
		  		boolean dashboard=obj.dashboardisplayed();
		  		
		  		
				if(dashboard==true)
				{
					System.out.println("login successful");
					//Assert.assertEquals(dashboard, true);
					test.pass("login successful");
				}
				else
				
				{
					System.out.println("login unsuccessful");
					//Assert.assertEquals(dashboard, false);
					String screenshot=screenshotutil.capturescreenshot(driver);
					test.fail("login unsuccessful").addScreenCaptureFromPath(screenshot);
					
				}
				extent.flush();
		
	  }
	
	
	 @DataProvider
	  public Object[][] logindata() throws InvalidFormatException, IOException {
		  
		 	    return new Object[][] {
		 	    	{
		 	    	configreader.getproperty("url"),
		 	    	configreader.getproperty("uname"),
		 	    	configreader.getproperty("pword")
		 	    }	
		 	    };
	 }
 
}