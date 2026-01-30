package SeleniumPac;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class TC_JavaScriptExecutor {
 
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
 
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://amazon.in");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert('Hello from selenium');");
		
		
		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
		driver.get("https://amazon.in");
		Thread.sleep(5000);
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		//js.executeScript("alert('Hello from selenium');");
		
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		js1.executeScript("window.scrollBy(0,900)");
		
		
	}
 
}
