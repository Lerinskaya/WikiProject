import lib.CoreTestCase;
import lib.ui.*;
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


//    @Test
//    public void testSearchResult() {
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//
//        SearchPageObject.clickSkipButton();
//        SearchPageObject.initSearchInput();
//        SearchPageObject.typeSearchLine("Java");
//        SearchPageObject.waitForSearchResult("Object-oriented programming language");
//    }
//
//    @Test
//    public void testSearchCancel() {
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//
//        SearchPageObject.clickSkipButton();
//        SearchPageObject.initSearchInput();
//        SearchPageObject.typeSearchLine("Java");
//        SearchPageObject.waitForCancelButtonToAppear();
//        SearchPageObject.clickCancelButton();
//        SearchPageObject.waitForCancelButtonToDisappear();
//    }

//    @Test
//    public void testSaveArticle() {
//
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//
//        SearchPageObject.clickSkipButton();
//        SearchPageObject.initSearchInput();
//        SearchPageObject.typeSearchLine("Java");
//        SearchPageObject.clickArticleWithSubstring("Object-oriented programming language");
//
//        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
//
//        ArticlePageObject.waitForArticleDescription();
//        String article_title = ArticlePageObject.getArticleDescription();
//        String folder_name = "Articles";
//        ArticlePageObject.addArticleToList(folder_name);
//        ArticlePageObject.closeArticle();
//
//        NavigationUI NavigationUI = new NavigationUI(driver);
//        NavigationUI.clickMyLists();
//
//        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
//        MyListsPageObject.openFolderByName(folder_name);
//        MyListsPageObject.swipeArticleToDelete(article_title);
//    }


//    @Test
//    public void testCompareArticleTitle() {
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//
//        SearchPageObject.clickSkipButton();
//        SearchPageObject.initSearchInput();
//        SearchPageObject.typeSearchLine("Java");
//        SearchPageObject.clickArticleWithSubstring("Object-oriented programming language");
//
//        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
//
//        ArticlePageObject.waitForArticleDescription();
//        String article_description = ArticlePageObject.getArticleDescription();
//
//        Assert.assertEquals(
//                "Unexpected article description",
//                "Object-oriented programming language",
//                article_description
//        );
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
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//
//        SearchPageObject.clickSkipButton();
//        SearchPageObject.initSearchInput();
//        SearchPageObject.typeSearchLine("Appium");
//        SearchPageObject.clickArticleWithSubstring("Automation for Apps");
//
//        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
//
//        ArticlePageObject.waitForArticleDescription();
//        ArticlePageObject.swipeToFooter();
//    }

//    @Test
//    public void testNotEmptySearch() {
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//
//        SearchPageObject.clickSkipButton();
//        SearchPageObject.initSearchInput();
//        String search_text = "Linkin Park discography";
//        SearchPageObject.typeSearchLine(search_text);
//        int amount_of_results = SearchPageObject.getAmountOfArticles(search_text);
//
//        Assert.assertTrue(
//                "No search results",
//                amount_of_results>0
//        );
//    }

//    @Test
//    public void testEmptySearch() {
//        SearchPageObject SearchPageObject = new SearchPageObject(driver);
//
//        SearchPageObject.clickSkipButton();
//        SearchPageObject.initSearchInput();
//        String search_text = "jnskejnlsjlsk";
//        SearchPageObject.typeSearchLine(search_text);
//        SearchPageObject.waitForEmptyResultsLabel();
//        SearchPageObject.noSearchResults(search_text);
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

    @Test
    public void testChangeScreenOrientation() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.clickSkipButton();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);

        String title_before_rotation = ArticlePageObject.getArticleDescription();
        this.rotateScreenLandscape();
        String title_after_rotation = ArticlePageObject.getArticleDescription();

        Assert.assertEquals(
                "Title descriptions aren't equal after rotation",
                title_before_rotation,
                title_after_rotation
        );

        this.rotateScreenPortrait();
        String title_after_second_rotation = ArticlePageObject.getArticleDescription();

        Assert.assertEquals(
                "Title descriptions aren't equal after rotation",
                title_before_rotation,
                title_after_second_rotation
        );
    }

    @Test
    public void testSearchAfterBackground() throws InterruptedException {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.clickSkipButton();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");

        this.backgroundApp(5);

        SearchPageObject.clickBackButton();
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
    }
}
