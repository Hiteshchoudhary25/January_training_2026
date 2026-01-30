package SeleniumPac;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

import java.io.FileInputStream;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

/**
 * Lab 12: Advance Selenium (Object Repository using Properties File)
 * - Re-implements Lab 4 steps using Java + Selenium WebDriver (Chrome)
 * - Uses a single properties file as the Object Repository (locators + config)
 *
 * Project layout (suggested):
 *   configuration/config.properties
 *   src/test/java/Lab12Test.java
 *
 * How to run:
 *   - Ensure Chrome is installed and chromedriver is available on PATH.
 *   - If not, uncomment System.setProperty line below and provide absolute path to chromedriver.
 *   - Run as JUnit Test.
 */
public class Lab_12 {

    private static Properties cfg;
    private WebDriver driver;
    private WebDriverWait wait;

    // ---------------------- Test lifecycle ----------------------

    @BeforeClass
    public static void loadConfig() throws Exception {
        cfg = new Properties();
        String path = Paths.get("configuration", "config.properties").toString();
        try (FileInputStream fis = new FileInputStream(path)) {
            cfg.load(fis);
        }
    }

    @BeforeClass
    public void setUp() {
        // If chromedriver isn't on PATH, specify it explicitly:
        // System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(getInt("implicit.wait.seconds", 8)));
        wait = new WebDriverWait(driver, Duration.ofSeconds(getInt("explicit.wait.seconds", 15)));
        driver.manage().window().maximize();

        driver.get(get("base.url"));
        Assert.assertTrue("Unexpected title: " + driver.getTitle(),
                driver.getTitle().contains(get("home.title")));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    // ---------------------- Helper methods ----------------------

    private static String get(String key) {
        String v = cfg.getProperty(key);
        if (v == null) throw new IllegalArgumentException("Missing key in properties: " + key);
        return v.trim();
    }

    private static int getInt(String key, int def) {
        try { return Integer.parseInt(get(key)); } catch (Exception e) { return def; }
    }

    /** Parse "kind=value" into a Selenium By. Supports: id, name, css, xpath, linkText, partialLinkText */
    private By by(String key) {
        String raw = get(key);
        String[] parts = raw.split("=", 2);
        if (parts.length != 2) throw new IllegalArgumentException("Invalid locator format: " + raw);
        String kind = parts[0].trim();
        String val  = parts[1].trim();

        switch (kind) {
            case "id": return By.id(val);
            case "name": return By.name(val);
            case "css": return By.cssSelector(val);
            case "xpath": return By.xpath(val);
            case "linkText": return By.linkText(val);
            case "partialLinkText": return By.partialLinkText(val);
            default: throw new IllegalArgumentException("Unsupported locator type: " + kind);
        }
    }

    private WebElement el(String key) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by(key)));
    }

    private WebElement vel(String key) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by(key)));
    }

    private void click(String key) {
        wait.until(ExpectedConditions.elementToBeClickable(by(key))).click();
    }

    private void type(String key, String text) {
        WebElement e = vel(key);
        e.clear();
        e.sendKeys(text);
    }

    private void selectVisibleText(String selectKey, String visibleText) {
        new Select(vel(selectKey)).selectByVisibleText(visibleText);
    }

    // ---------------------- The actual test (Lab 4 flow) ----------------------

    @Test
    public void lab4Flow_UsingPropertiesOR_Chrome() {
        // Step 4: Go to 'Desktops' tab (hover helps themes that open submenu on hover)
        new Actions(driver)
                .moveToElement(vel("menu.desktops"))
                .pause(Duration.ofMillis(350))
                .perform();

        // Step 5: Click on 'Mac'
        click("cat.mac");

        // Step 13/18: Verify the 'Mac' heading
        vel("heading.mac");

        // Step 6: Select 'Name (A - Z)' from 'Sort By' dropdown
        selectVisibleText("sort.dropdown", get("sort.az.text"));

        // Step 7: Click 'Add to Cart' button (first product)
        click("product.addtocart.first");

        // Optional: Wait for success alert if it appears (demo environments reset frequently)
        try { vel("alert.success.css"); } catch (TimeoutException ignored) { }

        // Step 8 & 14: Enter ‘Monitors’ (changed from 'Mobile') in global Search and click Search
        type("global.search.box", "Monitors");
        click("global.search.button");

        // Step 9: Wait for page to load (content container visible)
        vel("content.container");

        // Step 10: Clear text from 'Search Criteria' on the search page
        type("search.criteria.box", "");

        // Step 11: Click 'Search in product descriptions' and click 'Search'
        WebElement desc = vel("search.description.checkbox");
        if (!desc.isSelected()) desc.click();
        click("search.button");

        // Final sync to ensure results rendered
        vel("content.container");
    }
}
