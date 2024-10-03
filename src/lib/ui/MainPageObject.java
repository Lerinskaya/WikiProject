package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

public class MainPageObject {

    protected AppiumDriver driver;

    public MainPageObject(AppiumDriver driver) {
    this.driver = driver;
    }

    public WebElement waitForElement(String locator, String errorMessage, long timeout) {

        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElement(String locator, String errorMessage) {
        return waitForElement(locator, errorMessage, 20);
    }

    public WebElement waitForElementAndClick(String locator, String errorMessage, long timeout){
        WebElement element = waitForElement(locator, errorMessage, timeout);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(String locator, String value, String errorMessage, long timeout){
        WebElement element = waitForElement(locator, errorMessage);
        element.sendKeys(value);
        return element;
    }

    public boolean waitForElementAbsence(String locator, String errorMessage, long timeout) {

        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public WebElement waitForElementAndClear(String locator, String errorMessage, long timeout){
        WebElement element = waitForElement(locator, errorMessage);
        element.clear();
        return element;
    }

    public WebElement assertElementHasText(String locator, String expectedText, String errorMessage, long timeout) {
        WebElement element = waitForElement(locator, errorMessage, timeout);
        String actualText = element.getText();
        Assert.assertEquals(errorMessage, expectedText, actualText);
        return element;
    }

    public void swipeUp(int timeOfSwipe){
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width/2;
        int start_y = (int) (size.height*0.7);
        int end_y = (int) (size.height*0.3);
        action
                .press(PointOption.point(x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
                .moveTo(PointOption.point(x, end_y))
                .release()
                .perform();
    }

    public void swipeUpQuick(){
        swipeUp(200);
    }

    public void swipeUpToFindElement(String locator, String errorMessage, int maxSwipes){

        By by = this.getLocatorByString(locator);
        int swipes = 0;
        while (driver.findElements(by).isEmpty()) {
            if (swipes>maxSwipes) {
                waitForElement(locator, "Cannot find element by swiping. " + errorMessage);
                return;
            }
            swipeUpQuick();
            ++swipes;
        }
    }

    public void swipeElementToLeft(String locator, String errorMessage) {
        WebElement element = waitForElement(locator, errorMessage);
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();

        int upper_y = element.getLocation().getY();
        int lower_x = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_x)/2;

        TouchAction action = new TouchAction(driver);
        action
                .press(PointOption.point(right_x, middle_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                .moveTo(PointOption.point(right_x, middle_y))
                .release()
                .perform();

    }

    public int getAmountOfElements(String locator) {

        By by = this.getLocatorByString(locator);
        List elements = driver.findElements(by);
        return elements.size();
    }

    public void assertElementNotPresent(String locator, String errorMessage) {

        int amountOfElements = getAmountOfElements(locator);
        if (amountOfElements>0) {
            String defaultMessage = "An element '" + locator +" ' not suppose to be present";
            throw new AssertionError(defaultMessage + " " + errorMessage);
        }
    }

    public void assertElementPresent(String locator, String errorMessage) {
        int amountOfElements = getAmountOfElements(locator);
        if (amountOfElements == 0) {
            String defaultMessage = "An element '" + locator +" ' suppose to be present";
            throw new AssertionError(defaultMessage + " " + errorMessage);
        }
    }

    public String waitForElementAndGetAttribute(String locator, String attribute, String errorMessage, long timeout) {
        WebElement element = waitForElement(locator, errorMessage, timeout);
        return element.getAttribute(attribute);
    }

    private By getLocatorByString(String locator_with_type) {
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"), 2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];

        if(by_type.equals("xpath")) {
            return By.xpath(locator);
        } else if (by_type.equals("id")) {
            return By.id(locator);
        } else {
            throw new IllegalArgumentException("Wrong locator type: " + locator_with_type);
        }
    }

}
