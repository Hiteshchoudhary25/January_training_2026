package SeleniumPack;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;

public class AppiumYouTubeTest {

    @Test
    public void launchYouTubeAndCheckHome() throws Exception {
        AndroidDriver driver = null;
        try {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName("Android")
                    .setAutomationName("UiAutomator2")
                    .setDeviceName("emulator-5554");

            // DO NOT hardcode a wrong platformVersion.
            // Let Appium detect. If you want to set it, make sure it's correct:
            // options.setPlatformVersion("14");

            // Increase ADB exec timeout to avoid the 20s timeout
            options.setAdbExecTimeout(Duration.ofSeconds(120));
            options.setNewCommandTimeout(Duration.ofSeconds(120));

            // Launch YouTube (ensure it's installed on the emulator)
            options.setAppPackage("com.google.android.youtube");
            options.setAppActivity("com.google.android.apps.youtube.app.WatchWhileActivity");

            // If YouTube is not installed, use Settings instead:
            // options.setAppPackage("com.android.settings");
            // options.setAppActivity("com.android.settings.Settings");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            System.out.println("App started");

            WebElement home = driver.findElement(AppiumBy.accessibilityId("Home"));
            if (home.isDisplayed()) {
                System.out.println("Home is displayed");
            } else {
                System.out.println("Home is not displayed");
            }
        } finally {
            if (driver != null) driver.quit();
        }
    }
}
