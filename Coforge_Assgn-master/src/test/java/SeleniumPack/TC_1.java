package SeleniumPack;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class TC_1 {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://www.google.com/");
WebElement search=driver.findElement(By.id("APjFqb"));
search.sendKeys("Test methods");
search.submit();
System.out.println("Title is:"+driver.getTitle());

driver.close();
	}
 
}