package SeleniumPack;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab12 {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    Properties prop;

    private String requireProp(String key) {
        String val = prop.getProperty(key);
        if (val == null || val.trim().isEmpty()) {
            throw new IllegalStateException("Missing or empty property: " + key);
        }
        return val.trim();
    }

    private By by(String key) {
        String loc = requireProp(key);
        String[] parts = loc.split("=", 2);
        if (parts.length < 2) {
            throw new IllegalArgumentException("Invalid locator format for key '" + key + "': " + loc);
        }
        switch (parts[0].toLowerCase()) {
            case "id": return By.id(parts[1]);
            case "name": return By.name(parts[1]);
            case "css": return By.cssSelector(parts[1]);
            case "xpath": return By.xpath(parts[1]);
            case "linktext": return By.linkText(parts[1]);
            case "partiallinktext": return By.partialLinkText(parts[1]);
            default: throw new RuntimeException("Invalid locator type for key '" + key + "': " + parts[0]);
        }
    }

    @BeforeClass
    public void setUp() throws Exception {
        prop = new Properties();
        try (FileInputStream fis = new FileInputStream("configure.properties")) {
            prop.load(fis);
        }

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
    }

    @Test
    public void lab4() {
        driver.get(requireProp("base.url"));

        Assert.assertTrue(
            wait.until(ExpectedConditions.titleContains(requireProp("title.contains"))),
            "Title did not contain expected text."
        );

        WebElement desktops = wait.until(
            ExpectedConditions.visibilityOfElementLocated(by("desktops.menu"))
        );
        actions.moveToElement(desktops).pause(Duration.ofMillis(500)).perform();

        wait.until(ExpectedConditions.elementToBeClickable(by("desktops.showAll"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(by("mac.link"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(by("mac.heading")));

        Select select = new Select(wait.until(
            ExpectedConditions.visibilityOfElementLocated(by("sort.dropdown"))));
        String sortText = requireProp("sort.visible.text");
        boolean optionExists = select.getOptions().stream()
            .anyMatch(o -> o.getText().trim().equals(sortText));
        Assert.assertTrue(optionExists, "Sort option not present: " + sortText);
        select.selectByVisibleText(sortText);

        WebElement add = wait.until(
            ExpectedConditions.elementToBeClickable(by("addToCart.first")));
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});arguments[0].click();", add);

        WebElement search = wait.until(
            ExpectedConditions.elementToBeClickable(by("top.search.box")));
        search.clear();
        search.sendKeys(requireProp("search.term"));

        wait.until(ExpectedConditions.elementToBeClickable(by("top.search.button"))).click();

        WebElement criteria = wait.until(
            ExpectedConditions.visibilityOfElementLocated(by("search.criteria")));
        criteria.clear();

        WebElement desc = wait.until(
            ExpectedConditions.elementToBeClickable(by("search.in.description")));
        if (!desc.isSelected()) desc.click();

        wait.until(ExpectedConditions.elementToBeClickable(by("search.submit"))).click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}