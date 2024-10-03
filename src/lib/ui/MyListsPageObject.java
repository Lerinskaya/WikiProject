package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListsPageObject extends MainPageObject{

    private static final String
            FOLDER_NAME_TPL = "xpath://*[@text='{FOLDER_NAME}']",
            ARTICLE_TITLE_TPL = "xpath://*[@text='{TITLE}']";

    private static String getFolderXpathByName(String folder_name){
        return FOLDER_NAME_TPL.replace("{FOLDER_NAME}", folder_name);
    }

    private static String getArticleXpathByTitle(String article_title){
        return ARTICLE_TITLE_TPL.replace("{TITLE}", article_title);
    }

    public MyListsPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void openFolderByName(String folder_name) {

        String folder_name_xpath = getFolderXpathByName(folder_name);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Reading list not found",
                5
        );
    }

    public void waitForArticleToAppear(String article_title){
        String article_xpath = getFolderXpathByName(article_title);
        this.waitForElement(
                article_xpath,
                "Cannot find saved article",
                10
        );
    }

    public void swipeArticleToDelete(String article_title) {
        this.waitForArticleToAppear(article_title);
        String article_xpath = getFolderXpathByName(article_title);
        this.swipeElementToLeft(
                article_xpath,
                "Article not found"
        );

        this.waitForElementAbsence(
                article_xpath,
                "Cannot delete this article",
                10
        );
    }

    public void waitForArticlePresent(String article_title) {
        this.assertElementPresent(
                "//*[@text='"+ article_title +"']",
                "List is empty"
        );

        this.waitForElementAndClick(
                "//*[@text='"+ article_title +"']",
                "The article not found",
                5
        );

        this.assertElementPresent(
                "//*[@text='"+ article_title +"']",
                "Title doesn't match"
        );
    }
}
