package SeleniumPac;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
public class Lab_8_2{
	WebDriver driver;
	JavascriptExecutor js;
  @Test(dataProvider = "dp")
  public void f(String n, String s) throws InterruptedException {
driver.get("https://tutorialsninja.com/demo/index.php?");
driver.manage().window().setSize(new Dimension(550, 672));
driver.findElement(By.cssSelector(".fa-bars")).click();
driver.findElement(By.linkText("Desktops")).click();
boolean exists = !driver.findElements(By.linkText("Mac (1)")).isEmpty();
if (exists) {
    System.out.println("Present");
    Assert.assertEquals(exists, true);
}else {
	System.out.println("Absent");
	 Assert.assertEquals(exists, false);
}
driver.findElement(By.linkText("Mac (1)")).click();
driver.findElement(By.cssSelector("#input-sort > option:nth-child(3)")).click();
driver.findElement(By.cssSelector(".button-group .fa-shopping-cart")).click();
js.executeScript("window.scrollTo(0,577.3333129882812)");
driver.findElement(By.name("search")).click();
driver.findElement(By.cssSelector(".input-group-btn > .btn")).click();
driver.findElement(By.id("input-search")).click();
driver.findElement(By.id("input-search")).sendKeys("mobile"+ Keys.CONTROL,"a" + Keys.BACK_SPACE + "Monitor");
driver.findElement(By.id("description")).click();
driver.findElement(By.id("button-search")).click();

  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  js = (JavascriptExecutor) driver;
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  }
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Admin", "admin123"},
      new Object[] {"Ritika", "welcome"},
    };
  }
  @BeforeClass
  public void beforeClass() {
  }
  @AfterClass
  public void afterClass() {
  }
  @BeforeTest
  public void beforeTest() {
  }
  @AfterTest
  public void afterTest() {
  }
  @BeforeSuite
  public void beforeSuite() {
  }
  @AfterSuite
  public void afterSuite() {
  }
}
