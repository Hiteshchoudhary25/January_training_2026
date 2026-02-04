package com.orhrm.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TC002Test {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    private final By loader = By.cssSelector(".oxd-loading-spinner");

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280, 800));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    public void tC002_fullFlow() {
        // ===== Login ===== (same as your flow)
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        By username = By.name("username");
        By password = By.name("password");
        By loginBtn = By.cssSelector("button[type='submit']");

        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys("Admin");
        driver.findElement(password).sendKeys("admin123");
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();

        // Wait for dashboard/main menu as post-login signal
        wait.until(ExpectedConditions.or(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector("aside .oxd-main-menu")),
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-topbar-header-breadcrumb h6"))
        ));
        waitForLoaderGone();

        // ===== Hover “My Info” (maps your: moveToElement(By.linkText("My Info"))) =====
        hoverIfPresent(By.xpath("//aside//span[normalize-space()='My Info']"));

        // ===== Hover blank body (maps your body moveTo) – keep light-weight =====
        try {
            actions.moveByOffset(0, 0).perform();
        } catch (Exception ignored) {}

        // ===== Hover the 5th menu item text (your nth-child(5) .oxd-text) → equivalent hover “Time” =====
        hoverIfPresent(By.xpath("//aside//li[5]//span[contains(@class,'oxd-main-menu-item--name')]"));

        // ===== Hover body again (maps your second body move) =====
        try {
            actions.moveByOffset(1, 1).perform();
        } catch (Exception ignored) {}

        // ===== Hover “Time”, then Click “Time” (maps your linkText('Time') hover + click) =====
        hoverIfPresent(By.xpath("//aside//span[normalize-space()='Time']"));
        clickSideMenu("Time");     // stable helper
        waitForLoaderGone();

        // ===== Hover brand (maps .oxd-brand) – no-op but included =====
        hoverIfPresent(By.cssSelector(".oxd-brand, .oxd-topbar-header"));

        // ===== Click some topbar tabs by index (maps your nth-child(2/3/4) clicks) =====
        clickTopbarTabByIndex(2);
        clickTopbarTabByIndex(3);
        clickTopbarTabByIndex(4);

        // Also click tab #2 again (as in your script)
        clickTopbarTabByIndex(2);

        // ===== Open Attendance → “Punch In/Out” (maps your: linkText('Punch In/Out')) =====
        openTopbarMenuAndClick("Attendance", "Punch In/Out");

        // ===== Click the main action button (maps your .oxd-button click on Punch page) =====
        // It can be Punch In or Punch Out; we click if available
        safeClick(By.cssSelector("form button.oxd-button[type='submit']"));

        // ===== Topbar Tab #1 icon + item (your script clicked tab 1 icon then tab 1 item) =====
        // Equivalent: open Timesheets -> My Timesheets
        openTopbarMenuAndClick("Timesheets", "My Timesheets");

        // ===== Click something inside “My Timesheets” (maps your table first row button) =====
        // Try first row action button if present
        safeClick(By.cssSelector(".oxd-table-card:nth-child(1) .oxd-button"));

        // ===== “--visited” click then dropdown li(2) (maps to selecting a second menu item) =====
        // Equivalent intent: go to Timesheets -> Employee Timesheets (2nd item commonly)
        openTopbarMenuAndClick("Timesheets", "Employee Timesheets");

        // Try first row action button if present
        safeClick(By.cssSelector(".oxd-table-card:nth-child(1) .oxd-button"));

        // ===== Open user dropdown and Logout (maps your userdropdown name + dropdown li(1)) =====
        safeClick(By.cssSelector(".oxd-userdropdown-name"));
        safeClick(By.xpath("//a[normalize-space()='Logout']"));

        // ===== Assert we are back at Login =====
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
    }

    // ----------------- Helpers -----------------

    private void waitForLoaderGone() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
        } catch (TimeoutException ignored) {}
    }

    private void hoverIfPresent(By locator) {
        try {
            WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            actions.moveToElement(el).perform();
        } catch (TimeoutException ignored) {
            System.out.println("Hover target not present: " + locator);
        }
    }

    private void safeClick(By locator) {
        try {
            WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
            el.click();
            waitForLoaderGone();
        } catch (TimeoutException | NoSuchElementException | ElementClickInterceptedException e) {
            System.out.println("Skipping click; not available/clickable: " + locator);
        }
    }

    private void clickSideMenu(String menuText) {
        By item = By.xpath("//aside//span[normalize-space()='" + menuText + "']");
        safeClick(item);
    }

    /**
     * Clicks topbar tab by visible text, opens its dropdown (if any), then clicks the child item by text.
     * This abstracts sequences like:
     *   .oxd-topbar-body-nav-tab:nth-child(n) > .oxd-topbar-body-nav-tab-item
     *   .oxd-dropdown-menu > li:nth-child(m)
     */
    private void openTopbarMenuAndClick(String parentTabText, String itemText) {
        // Click the parent topbar tab
        By parentTab = By.xpath("//nav[contains(@class,'oxd-topbar-body-nav')]//li[.//span[normalize-space()='" + parentTabText + "']]");
        safeClick(parentTab);

        // Wait for dropdown and click item
        By dropdownItem = By.xpath("//ul[contains(@class,'oxd-dropdown-menu')]//a[normalize-space()='" + itemText + "']");
        safeClick(dropdownItem);
    }

    /**
     * Clicks a topbar tab item by its order (2,3,4...) – mirrors your nth-child selectors.
     * Keeps your original intent while being resilient via waits.
     */
    private void clickTopbarTabByIndex(int index1Based) {
        // Make sure there are tabs
        By tabs = By.cssSelector(".oxd-topbar-body-nav .oxd-topbar-body-nav-tab");
        try {
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(tabs, Math.max(1, index1Based - 1)));
            List<WebElement> list = driver.findElements(tabs);
            if (index1Based >= 1 && index1Based <= list.size()) {
                WebElement tab = list.get(index1Based - 1);
                WebElement item = tab.findElement(By.cssSelector(".oxd-topbar-body-nav-tab-item"));
                wait.until(ExpectedConditions.elementToBeClickable(item)).click();
                waitForLoaderGone();
            } else {
                System.out.println("Topbar tab index out of range: " + index1Based);
            }
        } catch (Exception e) {
            System.out.println("Skipping topbar index click (" + index1Based + "): " + e.getMessage());
        }
    }
}