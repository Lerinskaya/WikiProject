package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPageObject {

    protected AppiumDriver driver;

    public MainPageObject(AppiumDriver driver) {
    this.driver = driver;
    }

    public WebElement waitForElement(By by, String errorMessage, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElement(By by, String errorMessage) {
        return waitForElement(by, errorMessage, 3);
    }

    public WebElement waitForElementAndClick(By by, String errorMessage, long timeout){
        WebElement element = waitForElement(by, errorMessage, timeout);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(By by, String value, String errorMessage, long timeout){
        WebElement element = waitForElement(by, errorMessage);
        element.sendKeys(value);
        return element;
    }

    public boolean waitForElementAbsence(By by, String errorMessage, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public WebElement waitForElementAndClear(By by, String errorMessage, long timeout){
        WebElement element = waitForElement(by, errorMessage);
        element.clear();
        return element;
    }

    public WebElement assertElementHasText(By by, String expectedText, String errorMessage, long timeout) {
        WebElement element = waitForElement(by, errorMessage, timeout);
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
                .press(x, start_y)
                .waitAction(timeOfSwipe)
                .moveTo(x, end_y)
                .release()
                .perform();
    }

    public void swipeUpQuick(){
        swipeUp(200);
    }

    public void swipeUpToFindElement(By by, String errorMessage, int maxSwipes){
        int swipes = 0;
        while (driver.findElements(by).isEmpty()) {
            if (swipes>maxSwipes) {
                waitForElement(by, "Cannot find element by swiping. " + errorMessage);
                return;
            }
            swipeUpQuick();
            ++swipes;
        }
    }

    public void swipeElementToLeft(By by, String errorMessage) {
        WebElement element = waitForElement(by, errorMessage);
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();

        int upper_y = element.getLocation().getY();
        int lower_x = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_x)/2;

        TouchAction action = new TouchAction(driver);
        action
                .press(right_x, middle_y)
                .waitAction(150)
                .moveTo(left_x, middle_y)
                .release()
                .perform();

    }

    public int getAmountOfElements(By by) {
        List elements = driver.findElements(by);
        return elements.size();
    }

    public void assertElementNotPresent(By by, String errorMessage) {
        int amountOfElements = getAmountOfElements(by);
        if (amountOfElements>0) {
            String defaultMessage = "An element '" +by.toString() +" ' not suppose to be present";
            throw new AssertionError(defaultMessage + " " + errorMessage);
        }
    }

    public void assertElementPresent(By by, String errorMessage) {
        int amountOfElements = getAmountOfElements(by);
        if (amountOfElements == 0) {
            String defaultMessage = "An element '" +by.toString() +" ' suppose to be present";
            throw new AssertionError(defaultMessage + " " + errorMessage);
        }
    }

    public String waitForElementAndGetAttribute(By by, String attribute, String errorMessage, long timeout) {
        WebElement element = waitForElement(by, errorMessage, timeout);
        return element.getAttribute(attribute);
    }
}
