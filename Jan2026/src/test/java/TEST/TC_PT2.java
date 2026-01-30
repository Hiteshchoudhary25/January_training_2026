package TEST;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class TC_PT2 {
	public void test4() {
		  System.out.println("test4");
		  WebDriverManager.firefoxdriver().setup();
		  WebDriver driver=new FirefoxDriver();
			driver.get("https://www.yahoo.com/");
			driver.quit();
	  }
	  @Test
	  public void test5() {
		  System.out.println("test5");
		  WebDriverManager.firefoxdriver().setup();
		  WebDriver driver=new FirefoxDriver();
			driver.get("https://www.rediffmail.com/");
			driver.quit();
  }
  
}