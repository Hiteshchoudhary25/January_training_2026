package TestNG_Package;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.beust.jcommander.Parameterized;

import junit.framework.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Lab_9_1_AdvanceSelenium_Chrome_IE {

    private WebDriver driver;
    private String browser;

   
    @Parameterized.Parameters(name = "Run on: {0}")
    public static Collection<Object[]> browsers() {
        return Arrays.asList(new Object[][] {
                { "chrome" },
                { "ie" }
        });
    }

    public Lab_9_1_AdvanceSelenium_Chrome_IE(String browser) {
        this.browser = browser;
    }

   
    @Before
    public void setUp() {
        if (browser.equalsIgnoreCase("chrome")) {
            // IMPORTANT: Set your ChromeDriver path OR use WebDriverManager (if allowed)
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);
        }
        else if (browser.equalsIgnoreCase("ie")) {
            // IMPORTANT: Set your IEDriverServer path
            System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");

            InternetExplorerOptions ieOptions = new InternetExplorerOptions();
            // Common stable settings for IE
            ieOptions.ignoreZoomSettings();
            ieOptions.introduceFlakinessByIgnoringSecurityDomains();
            ieOptions.requireWindowFocus(); // sometimes helps with IE click issues

            driver = new InternetExplorerDriver(ieOptions);
            driver.manage().window().maximize();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

  
    @Test
    public void lab9_executeSameFlowOnChromeAndIE() {

        
        driver.get("https://example.com"); 
        String title = driver.getTitle();
        Assert.assertTrue("Title should not be empty", title != null && title.trim().length() > 0);
    }
       
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
