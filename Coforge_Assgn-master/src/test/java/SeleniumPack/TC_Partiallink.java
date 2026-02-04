package SeleniumPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Partiallink {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		Thread.sleep(5000);
		WebElement myaacount=	driver.findElement(By.partialLinkText("Account"));
		if(myaacount.isDisplayed())
		{
			System.out.println("My account is displayed");
			myaacount.click();
		}
		else
		{
			System.out.println("My account is not displayed");
		}
		driver.close();
	}
		
		
}


