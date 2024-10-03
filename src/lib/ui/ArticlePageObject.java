package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject{

    private static final String
        ARTICLE_ID = "id:pcs-edit-section-title-description",
        FOOTER_ELEMENT = "xpath://android.view.View[@content-desc=\"View article in browser\"]",
        OPTION_BUTTON_ID = "id:org.wikipedia:id/page_save",
        LIST_BUTTON_ID ="id:org.wikipedia:id/snackbar_action",
        LIST_INPUT_ID = "id:org.wikipedia:id/text_input",
        OK_BUTTON_ID = "id:android:id/button1",
        BACK_BUTTON = "xpath://android.widget.ImageButton[@content-desc=\"Navigate up\"]",
        ARTICLE_DESCRIPTION_ID = "id:pcs-edit-section-title-description",
        SAVE_TAB_ID = "id:org.wikipedia:id/nav_tab_reading_lists";

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForArticleDescription() {
        return this.waitForElement(ARTICLE_ID, "Cannot find an article", 10);
    }

    public String getArticleDescription() {
        WebElement title_description = waitForArticleDescription();
        return title_description.getAttribute("text");
    }

    public void swipeToFooter() {
        this.swipeUpToFindElement(FOOTER_ELEMENT, "Cannot find the end of article", 10);
    }

    public void addArticleToList(String folder_name) {
        this.waitForElementAndClick(
                OPTION_BUTTON_ID,
                "Save option not found",
                5
        );

        this.waitForElementAndClick(
                LIST_BUTTON_ID,
                "List button not found",
                5
        );

        this.waitForElementAndClick(
                LIST_INPUT_ID,
                "Search input not found",
                5
        );

        this.waitForElementAndSendKeys(
                LIST_INPUT_ID,
                folder_name,
                "Search input not found",
                10);

        this.waitForElementAndClick(
                OK_BUTTON_ID,
                "Ok button not found",
                5
        );
    }

    public void addArticleToExistingList(String folder_name) throws InterruptedException {
        Thread.sleep(2000);
        this.waitForElementAndClick(
                OPTION_BUTTON_ID,
                "Save option not found",
                5
        );

        this.waitForElementAndClick(
                LIST_BUTTON_ID,
                "List button not found",
                15
        );

        this.waitForElementAndClick(
                "//*[@text='"+ folder_name +"']",
                folder_name + "folder not found",
                10
        );
    }

    public void closeArticle() {
        this.waitForElementAndClick(
                BACK_BUTTON,
                "No back button",
                10
        );

        this.waitForElementAndClick(
                BACK_BUTTON,
                "No back button",
                10
        );
    }

    public void checkArticleDescription() {
        this.assertElementPresent(
                ARTICLE_DESCRIPTION_ID,
                "Title element is not present on the page"
        );
    }

    public void openList(String folder_name) {
        this.waitForElementAndClick(
                SAVE_TAB_ID,
                "Save option not found",
                5
        );

        this.waitForElementAndClick(
                "//*[@text='"+ folder_name +"']",
                "Reading list not found",
                5
        );
    }
}
