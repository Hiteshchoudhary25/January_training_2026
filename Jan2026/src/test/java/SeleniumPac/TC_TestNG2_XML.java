package SeleniumPac;
 
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
 
import static org.testng.Assert.*;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
 
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
 
public class TC_TestNG2_XML {
	
	WebDriver driver;
	
	String projectpath=System.getProperty("user.dir");
  @Test(dataProvider = "dp")
  public void f(String url,String username, String password) {
	  
	  System.out.println("This is test");
	  Login_POM obj=new Login_POM(driver);
	  
	  		driver.get(url);
	  	/*
	  		driver.findElement(By.name("username")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			boolean dashborad=driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed();
			*/
	  		obj.enterusername(username);
	  		obj.enterpassword(password);
	  		obj.clickonsubmit();
	  		boolean dashboard=obj.dashboarddisplayed();
	  		
	  		
			if(dashboard==true)
			{
				System.out.println("login successful");
				Assert.assertEquals(dashboard, true);
			}
			else
			
			{
				System.out.println("login unsuccessful");
				Assert.assertEquals(dashboard, false);
			}
			
	
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
  public Object[][] dp() throws InvalidFormatException, IOException, ParserConfigurationException, SAXException {
	  
	  String[][] data1=new String[1][3];
	  File xmlfile=new File(projectpath+"\\data.xml");
	  DocumentBuilderFactory dbfactory=DocumentBuilderFactory.newInstance();
	  DocumentBuilder dbuilder=dbfactory.newDocumentBuilder();
	  Document doc=dbuilder.parse(xmlfile);
	  NodeList nl=doc.getChildNodes();
	  Node n=nl.item(0);
	  Element ele=(Element)n;
	  
	  String ohrm_url=ele.getElementsByTagName("url").item(0).getTextContent();
	  String ohrm_username=ele.getElementsByTagName("username").item(0).getTextContent();
	  String ohrm_password=ele.getElementsByTagName("password").item(0).getTextContent();
	  data1[0][0]=ohrm_url;
	  data1[0][1]=ohrm_username;
	  data1[0][2]=ohrm_password;
	 /* Properties prob=new Properties();
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