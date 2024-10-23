package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.WebElement;

public abstract class ArticlePageObject extends MainPageObject{

    protected static String
        ARTICLE_ID,
        FOOTER_ELEMENT,
        OPTION_BUTTON_ID,
        LIST_BUTTON_ID,
        LIST_INPUT_ID,
        OK_BUTTON_ID,
        BACK_BUTTON,
        ARTICLE_DESCRIPTION_ID,
        SAVE_TAB_ID,
        CREATE_BUTTON,
        CANCEL_BUTTON;

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForArticleDescription() {
        return this.waitForElement(ARTICLE_ID, "Cannot find an article", 10);
    }

    public String getArticleDescription() {
        WebElement title_description = waitForArticleDescription();
        if (Platform.getInstance().isAndroid()) {
            return title_description.getAttribute("text");
        }
        return title_description.getAttribute("name");
    }

    public void swipeToFooter() {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(FOOTER_ELEMENT, "Cannot find the end of article", 20);
        } else {
            this.swipeUpTillElementAppear(FOOTER_ELEMENT, "Cannot find the end of article", 20);
        }
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

    public void addArticlesToMySaved(String folder_name) {
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
                CREATE_BUTTON,
                "Create button not found",
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

        if(Platform.getInstance().isAndroid()){
            this.waitForElementAndClick(
                    BACK_BUTTON,
                    "No back button",
                    10
            );
        } else {
            this.waitForElementAndClick(
                    CANCEL_BUTTON,
                    "No cancel button",
                    10
            );
        }
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
