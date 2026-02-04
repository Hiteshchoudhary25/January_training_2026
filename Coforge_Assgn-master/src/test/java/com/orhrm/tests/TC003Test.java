package com.orhrm.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;

public class TC003Test {
  private WebDriver driver;
  private WebDriverWait wait;
  private Actions actions;

  // ---- Reporting ----
  private static ExtentReports extent;
  private ExtentTest test;
  private static String projectpath;

  @BeforeSuite
  public void initReport() {
    projectpath = System.getProperty("user.dir");

    // Your exact snippet for report creation (file name as requested)
    extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter(projectpath + "\\jan28th_Report.html");
    extent.attachReporter(spark);

    // Ensure Screenshots directory exists
    File ssDir = new File(projectpath + File.separator + "Screenshots");
    if (!ssDir.exists()) {
      ssDir.mkdirs();
    }
  }

  @AfterSuite(alwaysRun = true)
  public void flushReport() {
    if (extent != null) {
      extent.flush();
    }
  }

  @BeforeClass
  public void setUpClass() {
    // With Selenium 4.6+ Selenium Manager auto-resolves drivers (no manual setup required).
    // If you prefer WebDriverManager, uncomment below:
    // io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
  }

  @BeforeMethod
  public void setUp(java.lang.reflect.Method method) {
    // You can switch to Chrome if Firefox remains flaky:
    // driver = new ChromeDriver();
    driver = new FirefoxDriver();

    new HashMap<>();
    actions = new Actions(driver);

    // Larger viewport helps avoid menu wrapping
    driver.manage().window().setSize(new Dimension(1440, 900));

    // Use explicit waits only
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    // Your exact snippet creating a test node title
    test = extent.createTest("Verify the login")
                 .assignCategory("UI")
                 .assignAuthor("Hitesh");
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown(ITestResult result) throws IOException {
    // Screenshot on success and failure (and skip)
    if (result.getStatus() == ITestResult.SUCCESS) {
      String path = takeScreenshot("PASS_" + result.getMethod().getMethodName());
      test.pass("Test passed").addScreenCaptureFromPath(path);
    } else if (result.getStatus() == ITestResult.FAILURE) {
      String path = takeScreenshot("FAIL_" + result.getMethod().getMethodName());
      // Your example fail line (generalized for any failure)
      test.fail("Step unsuccessful").addScreenCaptureFromPath(path);
      test.fail(result.getThrowable());
    } else if (result.getStatus() == ITestResult.SKIP) {
      String path = takeScreenshot("SKIP_" + result.getMethod().getMethodName());
      test.skip("Test skipped").addScreenCaptureFromPath(path);
    }

    if (driver != null) {
      driver.quit();
    }

    // Update the report after each test
    extent.flush();
  }

  @Test
  public void tC003() throws IOException {
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    // --- Login ---
    WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
    WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
    username.clear();
    username.sendKeys("Admin");
    password.clear();
    password.sendKeys("admin123");

    WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
    loginBtn.click();
    test.info("Clicked Login");

    // Wait until dashboard visible and any overlays gone
    wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.cssSelector("aside.oxd-sidepanel, .oxd-topbar-header")));
    waitForNoOverlay();

    // --- Navigate to Time module ---
    WebElement timeMenu = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//span[normalize-space()='Time']/ancestor::a")));
    timeMenu.click();
    test.info("Opened Time module");

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-topbar-body-nav")));
    waitForNoOverlay();

    // ===== Attendance -> Punch In/Out =====
    openTopbarItem("Attendance", "Punch In/Out");
    waitForNoOverlay();
    test.info("Opened Attendance → Punch In/Out");

    // Punch button (handles both Punch In and Punch Out)
    By punchButton = By.xpath("//button[contains(@class,'oxd-button')][contains(normalize-space(),'Punch')]");
    clickWhenClickable(punchButton);
    test.info("Clicked Punch (In/Out) button");
    waitForNoOverlay();

    // ===== Timesheets -> My Timesheets =====
    openTopbarItem("Timesheets", "My Timesheets");
    waitForNoOverlay();
    test.info("Opened Timesheets → My Timesheets");

    // ===== Project Info -> Projects =====
    openTopbarItem("Project Info", "Projects");
    waitForNoOverlay();
    test.info("Opened Project Info → Projects");

    // --- Assert Projects page ---
    WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//h5[contains(normalize-space(),'Projects')]")));
    Assert.assertTrue(header.isDisplayed(), "Projects header should be visible");
    test.pass("Verified Projects page header is visible");

    // Optional: success screenshot here too
    String successPath = takeScreenshot("Projects_Page_Verified");
    test.pass("Navigation successful").addScreenCaptureFromPath(successPath);
  }

  // ==========================
  // Helpers
  // ==========================

  /**
   * Robustly open a topbar dropdown item:
   * 1) Hover the tab
   * 2) If item still not present, click the tab
   * 3) Wait for the item itself (not the UL) and click (JS fallback if needed)
   */
  private void openTopbarItem(String tabText, String itemText) {
    By tabLocator  = By.xpath("//li[contains(@class,'oxd-topbar-body-nav-tab')][.//span[normalize-space()='" + tabText + "']]");
    By itemLocator = By.xpath("//a[normalize-space()='" + itemText + "']");

    WebElement tab = wait.until(ExpectedConditions.visibilityOfElementLocated(tabLocator));

    // Hover to trigger dropdown
    safeHover(tab);
    sleep(350);

    // If item not present quickly, click the tab (some skins need a click)
    if (!isPresentWithin(itemLocator, 1200)) {
      try {
        tab.click();
      } catch (Exception ignore) {
        // If click fails (intercepted), try JS click
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tab);
      }
      sleep(300);
    }

    // Now wait for the actual item (presence first, then visibility) and click
    wait.until(ExpectedConditions.presenceOfElementLocated(itemLocator));
    WebElement item = wait.until(ExpectedConditions.visibilityOfElementLocated(itemLocator));
    try {
      scrollIntoView(item);
      item.click();
    } catch (Exception e) {
      ((JavascriptExecutor) driver).executeScript("arguments[0].click();", item);
    }
  }

  /** Wait for OrangeHRM overlay/spinner to disappear (common after navigations). */
  private void waitForNoOverlay() {
    By overlay = By.cssSelector("div.oxd-loading-spinner, div.oxd-overlay, div[role='progressbar']");

    // Short probe (does overlay appear?)
    try {
      new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.or(
          ExpectedConditions.presenceOfAllElementsLocatedBy(overlay),
          ExpectedConditions.invisibilityOfElementLocated(overlay)
      ));
    } catch (Exception ignore) {}

    // Ensure it's gone
    new WebDriverWait(driver, Duration.ofSeconds(25))
        .until(ExpectedConditions.invisibilityOfElementLocated(overlay));
  }

  /** Click when clickable with JS fallback to avoid intercepted/overlap issues. */
  private void clickWhenClickable(By locator) {
    try {
      WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
      scrollIntoView(el);
      el.click();
    } catch (TimeoutException te) {
      throw te;
    } catch (Exception e) {
      WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
      scrollIntoView(el);
      ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }
  }

  private void scrollIntoView(WebElement el) {
    try {
      ((JavascriptExecutor) driver).executeScript(
          "arguments[0].scrollIntoView({block:'center', inline:'center'});", el);
    } catch (Exception ignore) {}
  }

  private void safeHover(WebElement el) {
    try {
      actions.moveToElement(el).pause(Duration.ofMillis(250)).perform();
    } catch (Exception ex) {
      try {
        Point p = el.getLocation();
        actions.moveByOffset(p.getX() + 5, p.getY() + 5).pause(Duration.ofMillis(200)).perform();
      } catch (Exception ignore) {}
    }
  }

  /** Presence check within a short time (millis). */
  private boolean isPresentWithin(By locator, long millis) {
    try {
      new WebDriverWait(driver, Duration.ofMillis(millis))
          .until(ExpectedConditions.presenceOfElementLocated(locator));
      return true;
    } catch (TimeoutException te) {
      return false;
    }
  }

  private void sleep(long ms) {
    try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
  }

  /** Take screenshot and return a relative path that Extent can resolve. */
  private String takeScreenshot(String baseName) throws IOException {
    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    String fileName = "Screenshots_" + baseName + "_" + timestamp + ".png";
    String dest = projectpath + File.separator + "Screenshots" + File.separator + fileName;
    File destFile = new File(dest);
    FileUtils.copyFile(src, destFile);
    // Return relative path for Extent report embedding
    return "." + File.separator + "Screenshots" + File.separator + fileName;
  }
}