package SeleniumPac;
 
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
 
import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
 
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
 
public class Lab_8_1{
    WebDriver driver;
    JavascriptExecutor js;
 
    @Test(dataProvider = "dp")
    public void f(String username, String password) {
 
        System.out.println("This is test");
 
 
driver.get("https://tutorialsninja.com/demo/index.php?");
driver.manage().window().setSize(new Dimension(1138, 672));
 
        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Mac (1)")).click();
 
        WebElement sortDropdown = driver.findElement(By.id("input-sort"));
        Actions actions = new Actions(driver);
 
        actions.moveToElement(sortDropdown).clickAndHold().perform();
        actions.moveToElement(sortDropdown).perform();
        actions.moveToElement(sortDropdown).release().perform();
 
        driver.findElement(By.id("input-sort")).click();
        sortDropdown.findElement(By.xpath("//option[.='Name (A - Z)']")).click();
 
        driver.findElement(By.cssSelector("#input-sort > option:nth-child(2)")).click();
 
        WebElement addToCartHover = driver.findElement(By.cssSelector(".button-group > button:nth-child(2)"));
        actions.moveToElement(addToCartHover).perform();
 
        actions.moveToElement(driver.findElement(By.tagName("body")), 0, 0).perform();
 
        driver.findElement(By.cssSelector(".button-group > button:nth-child(1)")).click();
 
        js.executeScript("window.scrollTo(0,432)");
    }
 
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This is Before Method");
 
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
 
    @AfterMethod
    public void afterMethod() {
        System.out.println("This is After Method");
        driver.quit();
    }
 
    @DataProvider
    public Object[][] dp() {
        return new Object[][] {
            new Object[] { "Admin", "admin123" },
            new Object[] { "Ritika", "welcome" },
        };
    }
 
    @BeforeClass
    public void beforeClass() {
        System.out.println("This is Before Class");
    }
 
    @AfterClass
    public void afterClass() {
        System.out.println("This is After Class");
    }
 
    @BeforeTest
    public void beforeTest() {
        System.out.println("This is Before test");
    }
 
    @AfterTest
    public void afterTest() {
        System.out.println("This is after test");
    }
 
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This is Before suite");
    }
 
    @AfterSuite
    public void afterSuite() {
        System.out.println("This is after suite");
    }
}