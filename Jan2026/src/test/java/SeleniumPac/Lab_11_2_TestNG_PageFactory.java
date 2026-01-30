package SeleniumPac;
 
import java.time.Duration;
 
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class Lab_11_2_TestNG_PageFactory {
	 WebDriver driver;
//	  JavascriptExecutor js;
	  @Test
	  public void f() {
		  driver.get("https://tutorialsninja.com/demo/index.php?");
//		  Lab11_POM_2 obj = new Lab11_POM_2(driver);
		  Lab_11_2_PageFactory obj = PageFactory.initElements(driver, Lab_11_2_PageFactory.class);
		  driver.manage().window().setSize(new Dimension(550, 672));
		 obj.faBar();
		 obj.clickDesktop();
		 obj.clickMac();
		 obj.clickSort();
		 obj.clickSortSelect();
		 obj.clickChild();
		 obj.clickCart();
//		 js.executeScript("window.scrollTo(0,577.3333129882812)");
		 obj.clickSearch();
		 obj.clickInnerBox();
		 obj.forCursor();
		 obj.textEnter();
		 obj.descrip();
		 obj.ent();
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
{
  }
}