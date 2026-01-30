package SeleniumPac;
 
import org.testng.annotations.Test;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
 
import static org.testng.Assert.*;
 
 
import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
 
public class TC_TestNGTest_PageFactory {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(String username, String password) {
	  System.out.println("This is test");
	  Login_PageFactory obj=PageFactory.initElements(driver, Login_PageFactory.class);
	  		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  	/*
	  		driver.findElement(By.name("username")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			boolean dashborad=driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed();
			*/
	  		obj.enterusername(username);
	  		obj.enterpassword(password);
	  		obj.clickonsubmit();
	  		boolean dashboard=obj.dashboardisplayed();

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
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Admin", "admin123" },
      new Object[] { "Admin", "admin123" },
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