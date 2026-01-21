package SeleniumPac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Navigate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		
		driver.navigate().to("https://www.amazon.in/");
		System.out.println("Title :" + driver.getTitle());
		
		System.out.println("URL :" + driver.getCurrentUrl());
		
		System.out.println("Page Source :" + driver.getPageSource());
		driver.navigate().back();
		System.out.println("Title after back :" + driver.getTitle());
		
		driver.navigate().forward();
		System.out.println("Title after forward :" + driver.getTitle());

	}

}
