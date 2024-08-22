import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class testSearch extends CoreTestCase {

    private MainPageObject MainPageObject;

    protected void setUp() throws Exception {
        super.setUp();

        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testSearch() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.clickSkipButton();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
    }

    @Test
    public void testSearchCancel() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.clickSkipButton();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelButton();
        SearchPageObject.waitForCancelButtonToDisappear();
    }

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

//    @Test
//    public void testSaveArticles() {
//
//        String folderName = "Articles";
//        String firstArticleTitle = "Java (programming language)";
//        String secondArticleTitle = "JavaScript";
//
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Skip')]"),
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
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_description' and @text='High-level programming language']"),
//                "Can't find this topic",
//                30
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
//                By.xpath("//*[@text='"+ folderName +"']"),
//                folderName + "folder not found",
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
//                By.xpath("//*[@text='"+ firstArticleTitle +"']"),
//                "Article not found"
//        );
//
//        waitForElementAbsence(
//                By.xpath("//*[@text='"+ firstArticleTitle +"']"),
//                "Cannot delete this article",
//                10
//        );
//
//        assertElementPresent(
//                By.xpath("//*[@text='"+ secondArticleTitle +"']"),
//                "List is empty"
//        );
//
//        waitForElementAndClick(
//                By.xpath("//*[@text='"+ secondArticleTitle +"']"),
//                "The article not found",
//                5
//        );
//
//        assertElementPresent(
//                By.xpath("//*[@text='"+ secondArticleTitle +"']"),
//                "Title doesn't match"
//        );
//    }

//    @Test
//    public void testAssertTitle() {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Skip')]"),
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
//        waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_description' and @text='Object-oriented programming language']"),
//                "Can't find this topic",
//                30
//        );
//
//        assertElementPresent(
//                By.id("pcs-edit-section-title-description"),
//                "Title element is not present on the page"
//        );
//    }

//    @Test
//    public void testChangeScreenOrientation() {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Skip')]"),
//                "No button",
//                10);
//
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "No Search input",
//                10);
//
//        String searchText = "Java";
//
//        waitForElementAndSendKeys(
//                By.id("search_src_text"),
//                searchText,
//                "No Search input",
//                10);
//
//        waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_description' and @text='Object-oriented programming language']"),
//                "Can't find this topic: " + searchText,
//                30
//        );
//
//        String title_before_rotation = waitForElementAndGetAttribute(
//                By.id("pcs-edit-section-title-description"),
//                "text",
//                "Cannot find title description",
//                5
//        );
//
//        driver.rotate(ScreenOrientation.LANDSCAPE);
//
//        String title_after_rotation = waitForElementAndGetAttribute(
//                By.id("pcs-edit-section-title-description"),
//                "text",
//                "Cannot find title description",
//                5
//        );
//
//        Assert.assertEquals(
//                "Title descriptions aren't equal after rotation",
//                title_before_rotation,
//                title_after_rotation
//        );
//
//        driver.rotate(ScreenOrientation.PORTRAIT);
//
//        String title_after_second_rotation = waitForElementAndGetAttribute(
//                By.id("pcs-edit-section-title-description"),
//                "text",
//                "Cannot find title description",
//                5
//        );
//
//        Assert.assertEquals(
//                "Title descriptions aren't equal after rotation",
//                title_before_rotation,
//                title_after_second_rotation
//        );
//    }

//    @Test
//    public void testSearchAfterBackground() throws InterruptedException {
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Skip')]"),
//                "No button",
//                10);
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "No Search input",
//                10);
//
//        String searchText = "Java";
//
//        MainPageObject.waitForElementAndSendKeys(
//                By.id("search_src_text"),
//                searchText,
//                "No Search input",
//                10);
//
//        MainPageObject.waitForElement(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_description' and @text='Object-oriented programming language']"),
//                "Can't find this topic: " + searchText,
//                30
//        );
//
//        driver.runAppInBackground(5);
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"),
//                "No back button",
//                10
//        );
//
//        MainPageObject.waitForElement(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_description' and @text='Object-oriented programming language']"),
//                "Can't find this topic: " + searchText + " after background",
//                30
//        );
//    }
}
