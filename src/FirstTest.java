import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;

public class FirstTest {

    private AppiumDriver<WebElement> driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "D:/AppiumWiki/WikiProject/apks/org.wikipedia.apk");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

//    @Test
//    public void firstTest() {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Continue')]"),
//                "No button",
//                10);
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Continue')]"),
//                "No button",
//                10);
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Continue')]"),
//                "No button",
//                10);
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Get started')]"),
//                "No button",
//                10);
//
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "No Search input",
//                10);
//
//        waitForElemenAndSendKeys(
//                By.id("search_src_text"),
//                "Java",
//                "No Search input",
//                10);
//
//        waitForElement(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_description' and @text='Object-oriented programming language']"),
//                "Can't find this topic",
//                30
//        );
//    }

//    @Test
//    public void testSearchCancel() {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Continue')]"),
//                "No button",
//                10);
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Continue')]"),
//                "No button",
//                10);
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Continue')]"),
//                "No button",
//                10);
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Get started')]"),
//                "No button",
//                10);
//
//        waitForElementAndClick(
//                By.id("search_container"),
//                "Element is not found",
//                5);
//
//        waitForElementAndClick(
//                By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"),
//                "No back button",
//                10);
//
//        waitForElementAbsence(
//                By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"),
//                "Returning to the previous page did not occur",
//                10);
//    }

//    @Test
//    public void testCompareArticleTitle() {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Continue')]"),
//                "No button",
//                10);
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Continue')]"),
//                "No button",
//                10);
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Continue')]"),
//                "No button",
//                10);
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Get started')]"),
//                "No button",
//                10);
//
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "No Search input",
//                30);
//
//        waitForElemenAndSendKeys(
//                By.id("search_src_text"),
//                "Java",
//                "No Search input",
//                30);
//
//        waitForElementAndClick(
//                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[1]"),
//                "Can't find this topic",
//                10
//        );
//
//        WebElement title = waitForElement(
//                By.xpath("//android.view.View[@content-desc=\"Object-oriented programming language\"]"),
//                "Can't find this topic",
//                100
//        );
//
//        //String article_description = title.getAttribute("resource-id");
//
//        //Assert.assertEquals(
//                //"Unexpected title",
//                //"pcs-edit-section-title-description",
//                //article_description
//        //);
//
//    }


    @Test
    public void testSearchClear() {
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Continue')]"),
                "No button",
                10);
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Continue')]"),
                "No button",
                10);
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Continue')]"),
                "No button",
                10);
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Get started')]"),
                "No button",
                10);

        waitForElementAndClick(
                By.id("search_container"),
                "Element is not found",
                5);

        waitForElemenAndSendKeys(
                By.id("search_src_text"),
                "Java",
                "No Search input",
                30);

        waitForElementAndClear(
                By.id("org.wikipedia:id/search_src_text"),
                "No Search input",
                30);

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"),
                "No back button",
                10);

        waitForElementAbsence(
                By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"),
                "Returning to the previous page did not occur",
                10);
    }


    private WebElement waitForElement(By by, String errorMessage, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitForElement(By by, String errorMessage) {
        return waitForElement(by, errorMessage, 3);
    }

    private WebElement waitForElementAndClick(By by, String errorMessage, long timeout){
        WebElement element = waitForElement(by, errorMessage, timeout);
        element.click();
        return element;
    }

    private WebElement waitForElemenAndSendKeys(By by, String value, String errorMessage, long timeout){
        WebElement element = waitForElement(by, errorMessage);
        element.sendKeys(value);
        return element;
    }

    private boolean waitForElementAbsence(By by, String errorMessage, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    private WebElement waitForElementAndClear(By by, String errorMessage, long timeout){
        WebElement element = waitForElement(by, errorMessage);
        element.clear();
        return element;
    }
}
