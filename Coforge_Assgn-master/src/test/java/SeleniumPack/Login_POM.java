package SeleniumPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login_POM {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By username = By.name("username");
    private final By password = By.name("password");
    private final By submitbutton = By.cssSelector("button[type='submit']");
    private final By dashboard = By.xpath("//h6[normalize-space()='Dashboard']");

    public Login_POM(WebDriver driver) {
        this.driver = driver;
        // You can tweak the timeout if needed
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterusername(String uname) {
        WebElement userEl = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        userEl.clear();
        userEl.sendKeys(uname);
    }

    public void enterpassword(String pword) {
        WebElement passEl = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        passEl.clear();
        passEl.sendKeys(pword);
    }

    public void clickonsubmit() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(submitbutton));
        btn.click();
    }

    public boolean dashboarddisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}