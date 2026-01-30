package SeleniumPac;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class TC_PT02 {
  @Test
  public void test4() {
	  WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://letcode.in/alert");
		driver.quit();
 
	  System.out.println("Test 4");
  }
  @Test
  public void test5() {
	  System.out.println("Test 5");
	  WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.quit();
  }
}