package SeleniumPack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Lab_6 {

    static WebDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php?");

        click(By.linkText("My Account"));
        click(By.linkText("Login"));

        type(By.id("input-email"), "moti@gmail.com");
        type(By.id("input-password"), "Dipu@1234");
        click(By.cssSelector("input.btn.btn-primary"));

        System.out.println("Login completed");

        click(By.linkText("Components"));
        click(By.linkText("Monitors (2)"));

        WebElement limit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-limit")));
        new Select(limit).selectByVisibleText("25");

        click(By.linkText("Apple Cinema 30\""));

        clickJs(By.cssSelector("a[href='#tab-specification']"));
        boolean specAvailable = driver.findElements(By.cssSelector("#tab-specification table")).size() > 0;
        System.out.println("Specification available: " + specAvailable);

        clickJs(By.cssSelector("button[onclick*='wishlist.add']"));
        String wishMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-success"))).getText();
        System.out.println(wishMsg);

        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));
        searchBox.clear();
        searchBox.sendKeys("Mobile");
        click(By.cssSelector("button.btn.btn-default.btn-lg"));

        WebElement desc = wait.until(ExpectedConditions.elementToBeClickable(By.id("description")));
        if (!desc.isSelected()) desc.click();
        click(By.id("button-search"));

        click(By.linkText("HTC Touch HD"));

        WebElement qty = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-quantity")));
        qty.clear();
        qty.sendKeys("3");

        click(By.id("button-cart"));

        String cartMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-success"))).getText();
        System.out.println(cartMsg);

        safeOpenCartAndViewCart();

        boolean productAdded = isPresent(By.xpath("//div[@id='content']//table[contains(@class,'table')]//a[normalize-space()='HTC Touch HD']"));
        System.out.println("HTC Touch HD present in cart: " + productAdded);

        click(By.linkText("Checkout"));

        click(By.linkText("My Account"));
        click(By.linkText("Logout"));

        String logoutHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content h1"))).getText();
        System.out.println("Logout heading: " + logoutHeading);

        driver.quit();
    }

    static void safeOpenCartAndViewCart() {
        try {
            click(By.id("cart-total"));
            click(By.linkText("View Cart"));
            return;
        } catch (Exception ignored) {
        }

        try {
            WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-success")));
            WebElement shoppingCartLink = alert.findElement(By.partialLinkText("shopping cart"));
            clickElement(shoppingCartLink);
        } catch (Exception e) {
            clickJs(By.id("cart-total"));
            clickJs(By.linkText("View Cart"));
        }
    }

    static void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    static void clickJs(By locator) {
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
        wait.until(ExpectedConditions.visibilityOf(el));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }

    static void clickElement(WebElement el) {
        wait.until(ExpectedConditions.elementToBeClickable(el)).click();
    }

    static void type(By locator, String value) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        el.clear();
        el.sendKeys(value);
    }

    static boolean isPresent(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
