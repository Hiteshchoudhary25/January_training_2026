package TestNG_Package;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class ParallelTest {
	WebDriver driver;
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
		
		 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
	}
		else if(browser.equalsIgnoreCase("firefox"))
		{
		
			WebDriverManager.firefoxdriver().setup();;
			driver=new FirefoxDriver();
	}
		
		else if(browser.equalsIgnoreCase("edge"))
		{
		
			WebDriverManager.edgedriver().setup();
			   driver=new EdgeDriver();
	}
		
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
  @Test
  public void test1() {
	  System.out.println("Test1");
	  
		driver.get("https://tutorialsninja.com/demo/index.php?");
	
  }
  @Test
  public void test2() {
	  System.out.println("Test2");
	
		driver.get("https://www.amazon.in/");
	
  }
  @Test
  public void test3() {
	  System.out.println("Test3");
	  
	
		driver.get("https://www.myntra.com/");
	
  }
}
 
 