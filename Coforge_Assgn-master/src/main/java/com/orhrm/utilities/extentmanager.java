package com.orhrm.utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
 
public class extentmanager {
	
	static ExtentReports extent;
	static String projectpath=System.getProperty("user.dir");
	public static ExtentReports getreport()
	{
		if(extent==null)
		{
			 extent=new ExtentReports();
	  		ExtentSparkReporter spark=new ExtentSparkReporter(projectpath+"\\jan28th_Report.html");
	  		extent.attachReporter(spark);
		}
		return extent;
	}
	
 
}
 