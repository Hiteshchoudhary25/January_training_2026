package TEST;

import java.time.Duration;
 
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class TC_ValidLoginTest {
 
    WebDriver driver;
 
    @BeforeMethod
    public void beforeMethod() {
        Reporter.log("Launching browser", true);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
 
    @Test(dataProvider = "validUsers")
    public void validLoginTest(String username, String password) throws InterruptedException {
        Reporter.log("Executing Valid Login Test for user: " + username, true);
 
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
 
        Thread.sleep(2000);
 
        // TestNG Assertion
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),
                "Valid login should redirect to dashboard");
 
        Reporter.log("Valid login passed for user: " + username, true);
    }
 
    @DataProvider(name = "validUsers")
    public Object[][] validUsers() {
        return new Object[][] {
                { "Admin", "admin123" }
        };
    }
 
    @AfterMethod
    public void afterMethod() {
        Reporter.log("Closing browser", true);
        if (driver != null) driver.quit();
    }
}