package SeleniumPack;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
 
import static org.testng.Assert.*;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
 
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
 
public class TC_TestNG {
	
	WebDriver driver;
	
	String projectpath=System.getProperty("user.dir");
  @Test(dataProvider = "dp")
  public void f(String url,String username, String password) throws InterruptedException, IOException {
	  
	  System.out.println("This is test");
	  Login_POM obj=new Login_POM(driver);
	  
	  		driver.get(url);
	  	/*
	  		driver.findElement(By.name("username")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			boolean dashborad=driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed();
			*/
	  		ExtentReports extent=new ExtentReports();
	  		ExtentSparkReporter spark=new ExtentSparkReporter(projectpath+"\\jan28th_Report.html");
	  		extent.attachReporter(spark);
	  		ExtentTest test=extent.createTest("Verify the login");
	  		
	  		obj.enterusername(username);
	  		obj.enterpassword(password);
	  		obj.clickonsubmit();
	  		Thread.sleep(5000);
	  		boolean dashboard=obj.dashboarddisplayed();
	  		
	  		
			if(dashboard==false)
			{
				System.out.println("login successful");
				//Assert.assertEquals(dashboard, true);
				test.pass("login successful");
			}
			else
			
			{
				System.out.println("login unsuccessful");
				//Assert.assertEquals(dashboard, false);
				File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				String timestamp=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
				String dest="./Screenshots/"+"Screenshots"+"_"+timestamp+".png";
				File destfile=new File(dest);
				FileUtils.copyFile(src, destfile);
				test.fail("login unsuccessful").addScreenCaptureFromPath(dest);
			}
			extent.flush();
	
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This is Before Method");
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  }
 
  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is After Method");
	  driver.quit();
  }
 
 
  @DataProvider
  public Object[][] dp() throws InvalidFormatException, IOException {
	  
	  String[][] data1=new String[1][3];
	  
	  Properties prob=new Properties();
	  File f2=new File(projectpath+"\\input.properties");
	  FileInputStream fs=new FileInputStream(f2);
	  prob.load(fs);
	   data1[0][0]=prob.getProperty("url");
	  data1[0][1]=prob.getProperty("uname");
	  data1[0][2]=prob.getProperty("pword");
	 /* File f1=new File(projectpath+"\\data.xlsx");
	  XSSFWorkbook workbook=new XSSFWorkbook(f1);
	  XSSFSheet s1=workbook.getSheetAt(0);
	  int rowcount=s1.getPhysicalNumberOfRows();
	  System.out.println("row count:"+rowcount);
	  for(int i=0;i<rowcount;i++)
	  {
		  data1[i][0]=s1.getRow(i).getCell(0).getStringCellValue();
		  data1[i][1]=s1.getRow(i).getCell(1).getStringCellValue();
	  }
	  */
    return data1;
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