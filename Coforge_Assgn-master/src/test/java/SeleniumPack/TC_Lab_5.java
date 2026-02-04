package SeleniumPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Lab_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		String title=driver.getTitle();
		System.out.println("title is:"+title);
	driver.findElement(By.linkText("My Account")).click();
	
	driver.findElement(By.linkText("Register")).click();
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	String Warningmsg=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
	System.out.println("Warning Message:"+Warningmsg);
	
	}

}
