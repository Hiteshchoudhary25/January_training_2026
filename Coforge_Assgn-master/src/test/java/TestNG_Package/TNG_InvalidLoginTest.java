
package TestNG_Package;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TNG_InvalidLoginTest {

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

    @Test(dataProvider = "invalidUsers")
    public void invalidLoginTest(String username, String password) throws InterruptedException {
        Reporter.log("Executing Invalid Login Test for user: " + username, true);

        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(2000);

        WebElement errorMsg = driver.findElement(By.xpath("//p[contains(@class,'oxd-alert-content-text')]"));

        // TestNG Assertions
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message should be displayed");
        Assert.assertEquals(errorMsg.getText().trim(), "Invalid credentials", "Error text should match");

        Reporter.log("Invalid login validation passed for user: " + username, true);
    }

    @DataProvider(name = "invalidUsers")
    public Object[][] invalidUsers() {
        return new Object[][] {
                { "pooja", "welcome" },
                { "test", "12345" }
        };
    }

    @AfterMethod
    public void afterMethod() {
        Reporter.log("Closing browser", true);
        if (driver != null) driver.quit();
    }
}
