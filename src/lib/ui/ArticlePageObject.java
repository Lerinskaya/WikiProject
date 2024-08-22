package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject{

    private static final String
        ARTICLE_ID = "pcs-edit-section-title-description",
        FOOTER_ELEMENT = "//android.view.View[@content-desc=\"View article in browser\"]";

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waiForArticleDescription() {
        return this.waitForElement(By.id(ARTICLE_ID), "Cannot find an article", 10);
    }

    public String getArticleDescription() {
        WebElement title_description = waiForArticleDescription();
        return title_description.getAttribute("text");
    }

    public void swipeToFooter() {
        this.swipeUpToFindElement(By.xpath(FOOTER_ELEMENT), "Cannot find the end of article", 10);
    }
}
