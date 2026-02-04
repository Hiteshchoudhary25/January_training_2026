package com.orhrm.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class LoginTest {
  private WebDriver driver;
  private WebDriverWait wait;
  private Map<String, Object> vars;

  @BeforeMethod
  public void setUp() {
    driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1280, 800));
    wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    vars = new HashMap<>();
  }

  @AfterMethod
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }

  @Test
  public void LoginTest() {
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
    username.sendKeys("Admin");
    driver.findElement(By.name("password")).sendKeys("admin123");
    driver.findElement(By.cssSelector("button[type='submit']")).click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("header.oxd-topbar")));

    WebElement timeMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Time']")));
    timeMenu.click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.oxd-topbar-body")));

    WebElement timesheetsTab = wait.until(
        ExpectedConditions.elementToBeClickable(By.xpath("//nav[contains(@class,'oxd-topbar-body-nav')]/ul/li/a[normalize-space()='Timesheets']"))
    );
    timesheetsTab.click();

    WebElement myTimesheets = wait.until(
        ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='My Timesheets']"))
    );
    myTimesheets.click();

    wait.until(ExpectedConditions.or(
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[contains(.,'My Timesheet')]")),
        ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form.oxd-form"))
    ));

    WebElement attendanceTab = wait.until(
        ExpectedConditions.elementToBeClickable(By.xpath("//nav[contains(@class,'oxd-topbar-body-nav')]/ul/li/a[normalize-space()='Attendance']"))
    );
    attendanceTab.click();

    WebElement employeeRecords = wait.until(
        ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Employee Records']"))
    );
    employeeRecords.click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[contains(.,'Employee Records')]")));

    WebElement empNameInput = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//label[normalize-space()='Employee Name']/parent::div/following-sibling::div//input")
    ));
    empNameInput.click();
    empNameInput.clear();
    empNameInput.sendKeys("manda akhil user");

    try {
      WebElement firstSuggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(
          By.xpath("//div[@role='listbox']//span[contains(@class,'oxd-autocomplete-option')]")
      ));
      firstSuggestion.click();
    } catch (Exception ignored) {
      // ignore if no suggestion appears
    }

    WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//button[@type='submit' and normalize-space()='Search']"))
    );
    searchBtn.click();

    wait.until(ExpectedConditions.or(
        ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.oxd-table-body div.oxd-table-card")),
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='No Records Found']"))
    ));
  }
}
