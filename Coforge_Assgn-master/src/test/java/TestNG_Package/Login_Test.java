
package TestNG_Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Test {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        Reporter.log("BeforeMethod: Launching Chrome", true);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();  // ✅ initialize class-level driver (NOT local)

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    public void validLogin_shouldNavigateToDashboard() throws InterruptedException {
        Reporter.log("Test: Valid Login", true);

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");

        // ✅ Correct locator (XPath, not name)
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(2000);

        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),
                "After valid login, URL should contain dashboard");
    }

    @Test
    public void invalidLogin_shouldShowErrorMessage() throws InterruptedException {
        Reporter.log("Test: Invalid Login", true);

        driver.findElement(By.name("username")).sendKeys("wrongUser");
        driver.findElement(By.name("password")).sendKeys("wrongPass");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(2000);

        String errorText = driver.findElement(By.xpath("//p[contains(@class,'oxd-alert-content-text')]"))
                                 .getText().trim();

        Assert.assertEquals(errorText, "Invalid credentials",
                "Invalid login should show 'Invalid credentials'");
    }

    @AfterMethod
    public void tearDown() {
        Reporter.log("AfterMethod: Closing browser", true);
        if (driver != null) {
            driver.quit();
        }
    }
}
