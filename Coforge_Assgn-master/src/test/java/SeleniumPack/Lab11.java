package SeleniumPack;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
 
import java.time.Duration;
 
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
 
public class Lab11 {
  WebDriver driver;
  JavascriptExecutor js;
  @Test
  public void f() {
	  driver.get("https://tutorialsninja.com/demo/index.php?");
	  Lab11_Pom obj = new Lab11_Pom(driver);
	  
	  driver.manage().window().setSize(new Dimension(550, 672));
	  
	 obj.faBar();
	 obj.clickDesktop();
	 obj.clickMac();
	 obj.clickSort();
	 obj.clickSortSelect();
	 obj.clickChild();
	 obj.clickCart();
	
  }
  @BeforeMethod
  public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  }
 
  @AfterMethod
  public void afterMethod() {
  }
 
  @BeforeClass
  public void beforeClass() {
  }
 
  @AfterClass
  public void afterClass() {
  }
 
  @BeforeTest
  public void beforeTest() {
  }
 
  @AfterTest
  public void afterTest() {
  }
 
  @BeforeSuite
  public void beforeSuite() {
  }
 
  @AfterSuite
  public void afterSuite() {
  }
 
}