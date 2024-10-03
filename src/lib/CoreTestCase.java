package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class CoreTestCase extends TestCase {

    private static final String
    PLATFORM_IOS = "ios",
    PLATFORM_ANDROID = "android";

    protected AppiumDriver<WebElement> driver;
    private static String AppiumURL = "http://localhost:4723";

    @Override
    protected void setUp() throws Exception {

        super.setUp();

        initializeDriver();
        this.rotateScreenPortrait();
    }

    @Override
    protected void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }

        super.tearDown();
    }

    protected void rotateScreenPortrait(){
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void rotateScreenLandscape(){
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void backgroundApp(int seconds){
        driver.runAppInBackground(Duration.ofSeconds(seconds));
    }

    private void initializeDriver() throws Exception {
        String platform = System.getenv("PLATFORM");

        if (platform == null) {
            throw new Exception("Cannot get platform from environment variable. Make sure PLATFORM is set.");
        }

        System.out.println("Platform: " + platform);

        DesiredCapabilities capabilities = this.getCapabilitiesByPlatformEnv();

        if (platform.equals(PLATFORM_ANDROID)) {
            driver = new AndroidDriver<>(new URL(AppiumURL), capabilities);
        } else if (platform.equals(PLATFORM_IOS)) {
            driver = new IOSDriver<>(new URL(AppiumURL), capabilities);
        } else {
            throw new Exception("Unsupported platform: " + platform);
        }
    }

    private DesiredCapabilities getCapabilitiesByPlatformEnv() throws Exception {
        String platform = System.getenv("PLATFORM");

        if (platform == null || platform.isEmpty()) {
            throw new Exception("Cannot get platform from environment variable. Make sure PLATFORM is set.");
        }

        System.out.println("Platform: " + platform);

        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (platform.equals(PLATFORM_ANDROID)) {
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "AndroidTestDevice");
            capabilities.setCapability("platformVersion", "8.1");
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability("appPackage", "org.wikipedia");
            capabilities.setCapability("appActivity", ".main.MainActivity");
            capabilities.setCapability("app", "/Users/dzmitrypadolski/Desktop/Tests/apks/org.wikipedia.apk");
        } else if (platform.equals(PLATFORM_IOS)) {
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("deviceName", "iPhone 15");
            capabilities.setCapability("platformVersion", "18.0");
            capabilities.setCapability("app", "/Users/dzmitrypadolski/Desktop/Tests/apks/Wikipedia693.app");
            capabilities.setCapability("automationName", "XCUITest");
        } else {
            throw new Exception("Unsupported platform: " + platform);
        }

        return capabilities;
    }


}
