import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
//        waitForElementAndSendKeys(
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
//                By.xpath("//*[contains(@text, 'Skip')]"),
//                "No button",
//                10);
//
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "No Search input",
//                30);
//
//        waitForElementAndSendKeys(
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


//    @Test
//    public void testSearchClear() {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Skip')]"),
//                "No button",
//                10);
//
//        waitForElementAndClick(
//                By.id("search_container"),
//                "Element is not found",
//                5);
//
//        waitForElementAndSendKeys(
//                By.id("search_src_text"),
//                "Java",
//                "No Search input",
//                30);
//
//        waitForElementAndClear(
//                By.id("org.wikipedia:id/search_src_text"),
//                "No Search input",
//                30);
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
//    public void testInputContainsText() {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Skip')]"),
//                "No button",
//                10);
//
//        assertElementHasText(
//                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/androidx.cardview.widget.CardView/android.widget.TextView"),
//                "Search Wikipedia",
//                "Text was not found",
//                10
//        );
//    }

//    @Test
//    public void testSearchAndCancelResult() {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Skip')]"),
//                "No button",
//                10);
//
//        waitForElementAndClick(
//                By.id("search_container"),
//                "Element is not found",
//                5);
//
//        waitForElementAndSendKeys(
//                By.id("search_src_text"),
//                "Java",
//                "No Search input",
//                30);
//
//        assertElementHasText(
//                By.id("page_list_item_title"),
//                "Java",
//                "Text was not found",
//                10
//        );
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
//    public void testSearchAndVerifyResult() {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Skip')]"),
//                "No Skip button found",
//                10);
//
//        waitForElementAndClick(
//                By.id("search_container"),
//                "Search container not found",
//                5);
//
//        waitForElementAndSendKeys(
//                By.id("search_src_text"),
//                "Java",
//                "Search input not found",
//                30);
//
//        List<WebElement> searchResults = driver.findElements(By.id("page_list_item_title"));
//
//        Assert.assertFalse("Search results not found", searchResults.isEmpty());
//
//        for (WebElement result : searchResults) {
//            String resultText = result.getText().toLowerCase();
//            Assert.assertTrue("Search result does not contain 'Java'", resultText.contains("java"));
//        }
//    }

//    @Test
//    public void testSwipeArticle() {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Skip')]"),
//                "No button",
//                10);
//
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "No Search input",
//                30);
//
//        waitForElementAndSendKeys(
//                By.id("search_src_text"),
//                "Appium",
//                "No Search input",
//                30);
//
//        waitForElementAndClick(
//                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[1]"),
//                "Can't find this topic",
//                10
//        );
//
//        waitForElement(
//                By.xpath("(//android.view.View[@content-desc=\"Appium\"])[1]"),
//                "Can't find this title",
//                100
//        );
//
//        swipeUpToFindElement(
//                By.xpath("//android.view.View[@content-desc=\"View article in browser\"]"),
//                "The end of the article not found",
//                5
//        );
//    }

//    @Test
//    public void saveArticle() {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Skip')]"),
//                "No button",
//                10);
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "No Search input",
//                10);
//
//        waitForElementAndSendKeys(
//                By.id("search_src_text"),
//                "Java",
//                "No Search input",
//                10);
//
//        waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_description' and @text='Object-oriented programming language']"),
//                "Can't find this topic",
//                30
//        );
//
//        waitForElement(
//                By.xpath("//android.view.View[@content-desc=\"Object-oriented programming language\"]"),
//                "Can't find this topic",
//                100
//        );
//
//        waitForElementAndClick(
//                By.id("org.wikipedia:id/page_save"),
//                "Save option not found",
//                5
//        );
//
//        waitForElementAndClick(
//                By.id("org.wikipedia:id/snackbar_action"),
//                "List button not found",
//                5
//        );
//
//        waitForElementAndClick(
//                By.id("org.wikipedia:id/text_input"),
//                "Search input not found",
//                5
//        );
//
//        String folderName = "Articles";
//
//        waitForElementAndSendKeys(
//                By.id("org.wikipedia:id/text_input"),
//                folderName,
//                "Search input not found",
//                10);
//
//        waitForElementAndClick(
//                By.id("android:id/button1"),
//                "Ok button not found",
//                5
//        );
//
//        waitForElementAndClick(
//                By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"),
//                "No back button",
//                10
//        );
//
//        waitForElementAndClick(
//                By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"),
//                "No back button",
//                10
//        );
//
//        waitForElementAndClick(
//                By.id("org.wikipedia:id/nav_tab_reading_lists"),
//                "Save option not found",
//                5
//        );
//
//        waitForElementAndClick(
//                By.xpath("//*[@text='"+ folderName +"']"),
//                "Reading list not found",
//                5
//        );
//
//        swipeElementToLeft(
//                By.xpath("//*[@text='Java (programming language)']"),
//                "Article not found"
//        );
//
//        waitForElementAbsence(
//                By.xpath("//*[@text='Java (programming language)']"),
//                "Cannot delete this article",
//                10
//        );
//    }

//    @Test
//    public void testNotEmptySearch() {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Skip')]"),
//                "No button",
//                10);
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "No Search input",
//                10);
//
//        String searchText = "Linkin Park discography";
//
//        waitForElementAndSendKeys(
//                By.id("search_src_text"),
//                searchText,
//                "No Search input",
//                10);
//
//        String searchTextLocator = "//*[@resource-id='org.wikipedia:id/page_list_item_title' and @text='"+ searchText +"']";
//
//        waitForElement(
//                By.xpath(searchTextLocator),
//                "Cannot find search result",
//                10
//        );
//
//        int amountOfResults = getAmountOfElements(
//                By.xpath(searchTextLocator)
//        );
//
//        Assert.assertTrue(
//                "No search results",
//                amountOfResults>0
//        );
//    }

//    @Test
//    public void testEmptySearch() {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Skip')]"),
//                "No button",
//                10);
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "No Search input",
//                10);
//
//        String searchText = "jnskejnlsjlsk";
//
//        waitForElementAndSendKeys(
//                By.id("search_src_text"),
//                searchText,
//                "No Search input",
//                10);
//
//        String searchTextLocator = "//*[@resource-id='org.wikipedia:id/page_list_item_title' and @text='"+ searchText +"']";
//        String emptyResultPage = "//*[@text='No results']";
//
//        waitForElement(
//                By.xpath(emptyResultPage),
//                "This page is not empty",
//                10
//        );
//
//        assertElementNotPresent(
//                By.xpath(searchTextLocator),
//                "We've found some results by request" + searchText
//        );
//    }

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

    private WebElement waitForElementAndSendKeys(By by, String value, String errorMessage, long timeout){
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

    public WebElement assertElementHasText(By by, String expectedText, String errorMessage, long timeout) {
        WebElement element = waitForElement(by, errorMessage, timeout);
        String actualText = element.getText();
        Assert.assertEquals(errorMessage, expectedText, actualText);
        return element;
    }

    protected void swipeUp(int timeOfSwipe){
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

    protected void swipeUpQuick(){
        swipeUp(200);
    }

    protected void swipeUpToFindElement(By by, String errorMessage, int maxSwipes){
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

    protected void swipeElementToLeft(By by, String errorMessage) {
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

    private int getAmountOfElements(By by) {
        List elements = driver.findElements(by);
        return elements.size();
    }

    private void assertElementNotPresent(By by, String errorMessage) {
        int amountOfElements = getAmountOfElements(by);
        if (amountOfElements>0) {
            String defaultMessage = "An element '" +by.toString() +" ' not suppose to be present";
            throw new AssertionError(defaultMessage + " " + errorMessage);
        }
    }
}
