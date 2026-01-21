package SeleniumPac;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_FindElement {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.in");
		Thread.sleep(5000);
		
//		List<WebElement> links = driver.findElements(By.tagName("a"));
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		for(WebElement link : links) {
			System.out.println(link.getText());
		}
		

	}

}
