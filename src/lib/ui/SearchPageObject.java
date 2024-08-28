package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject{

    private static final String
            SKIP_BUTTON_XPATH = "//*[contains(@text, 'Skip')]",
            SEARCH_INIT_ELEMENT = "//*[contains(@text, 'Search Wikipedia')]",
            SEARCH_INPUT = "search_src_text",
            SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn",
            NAVIGATE_BUTTON_XPATH = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_description' and @text='{SUBSTRING}']",
            EMPTY_RESULT_ID ="//*[@text='No results']";

    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static String getResultSearchElement(String substring){
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    };

    public void clickSkipButton() {
        this.waitForElementAndClick(By.xpath(SKIP_BUTTON_XPATH),"Cannot find skip button", 10);
    }

    public void clickBackButton() {
        this.waitForElementAndClick(By.xpath(NAVIGATE_BUTTON_XPATH),"Cannot find navigation back button", 10);
    }

    public void initSearchInput() {
        this.waitForElement(By.xpath(SEARCH_INIT_ELEMENT),"Cannot find search input", 10);
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT),"Cannot find search input", 10);
    }

    public void typeSearchLine(String search_line) {
        this.waitForElementAndSendKeys(By.id(SEARCH_INPUT), search_line,"Cannot find and type into the search input", 10);
    }

    public void waitForSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElement(By.xpath(search_result_xpath),"Cannot find search result with " + substring, 10);
    }

    public void waitForCancelButtonToAppear() {
        this.waitForElement(By.id(SEARCH_CANCEL_BUTTON), "Cannot find search cancel button", 10);
    }

    public void waitForCancelButtonToDisappear() {
        this.waitForElementAbsence(By.id(SEARCH_CANCEL_BUTTON), "Search cancel button is still present", 10);
    }

    public void clickCancelButton() {
        this.waitForElementAndClick(By.id(SEARCH_CANCEL_BUTTON), "Cannot find search cancel button", 10);
    }

    public void clickArticleWithSubstring(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath),"Cannot find and click search result with " + substring, 10);
    }

    public int getAmountOfArticles(String searchText) {
        String searchTextLocator = "//*[@resource-id='org.wikipedia:id/page_list_item_title' and @text='"+ searchText +"']";

        this.waitForElement(
                By.xpath(searchTextLocator),
                "Cannot find search result",
                10
        );
        return this.getAmountOfElements(By.xpath(searchTextLocator));
    }

    public void waitForEmptyResultsLabel(){
        this.waitForElement(
                By.xpath(EMPTY_RESULT_ID),
                "The result is not empty",
                10
                );
    }

    public void noSearchResults(String searchText){
        String searchTextLocator = "//*[@resource-id='org.wikipedia:id/page_list_item_title' and @text='"+ searchText +"']";
        this.assertElementNotPresent(
                By.xpath(searchTextLocator),
                "There are should be no results"
        );
    }

}
