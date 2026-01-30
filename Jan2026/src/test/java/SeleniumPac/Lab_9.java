package SeleniumPac;
 
import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class Lab_9 {
  WebDriver driver;
  JavascriptExecutor js;
	@Parameters("browser")
	@BeforeMethod
	public void setup(@Optional("chrome") String browser) {
		if(browser.equalsIgnoreCase("chrome"))
		{
		 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
	}
		js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
 
	}
 
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
 
	@Test
	public void f() {
 
		driver.get("https://tutorialsninja.com/demo/index.php?");
		driver.manage().window().setSize(new Dimension(550, 672));
 
		driver.findElement(By.cssSelector(".fa-bars")).click();
		driver.findElement(By.linkText("Desktops")).click();
		driver.findElement(By.linkText("Mac (1)")).click();
 
		driver.findElement(By.cssSelector("#input-sort > option:nth-child(3)")).click();
		driver.findElement(By.cssSelector(".button-group .fa-shopping-cart")).click();
 
		js.executeScript("window.scrollTo(0,577.3333129882812)");
 
		driver.findElement(By.name("search")).click();
		driver.findElement(By.cssSelector(".input-group-btn > .btn")).click();
 
		driver.findElement(By.id("input-search")).click();
		driver.findElement(By.id("input-search")).sendKeys("mobile");
		driver.findElement(By.id("description")).click();
		driver.findElement(By.id("button-search")).click();
 
	}
}