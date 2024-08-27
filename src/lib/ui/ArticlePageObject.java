package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject{

    private static final String
        ARTICLE_ID = "pcs-edit-section-title-description",
        FOOTER_ELEMENT = "//android.view.View[@content-desc=\"View article in browser\"]",
        OPTION_BUTTON_ID = "org.wikipedia:id/page_save",
        LIST_BUTTON_ID ="org.wikipedia:id/snackbar_action",
        LIST_INPUT_ID = "org.wikipedia:id/text_input",
        OK_BUTTON_ID = "android:id/button1",
        BACK_BUTTON = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]";

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForArticleDescription() {
        return this.waitForElement(By.id(ARTICLE_ID), "Cannot find an article", 10);
    }

    public String getArticleDescription() {
        WebElement title_description = waitForArticleDescription();
        return title_description.getAttribute("text");
    }

    public void swipeToFooter() {
        this.swipeUpToFindElement(By.xpath(FOOTER_ELEMENT), "Cannot find the end of article", 10);
    }

    public void addArticleToList(String folder_name) {
        this.waitForElementAndClick(
                By.id(OPTION_BUTTON_ID),
                "Save option not found",
                5
        );

        this.waitForElementAndClick(
                By.id(LIST_BUTTON_ID),
                "List button not found",
                5
        );

        this.waitForElementAndClick(
                By.id(LIST_INPUT_ID),
                "Search input not found",
                5
        );

        this.waitForElementAndSendKeys(
                By.id(LIST_INPUT_ID),
                folder_name,
                "Search input not found",
                10);

        this.waitForElementAndClick(
                By.id(OK_BUTTON_ID),
                "Ok button not found",
                5
        );
    }

    public void closeArticle() {
        this.waitForElementAndClick(
                By.xpath(BACK_BUTTON),
                "No back button",
                10
        );

        this.waitForElementAndClick(
                By.xpath(BACK_BUTTON),
                "No back button",
                10
        );
    }
}
