package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject{
    private static final String
        SAVE_OPTION_ID = "id:org.wikipedia:id/nav_tab_reading_lists",
            NAVIGATE_BUTTON_XPATH = "xpath://android.widget.ImageButton[@content-desc=\"Navigate up\"]";

    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    public void clickMyLists() {
        this.waitForElementAndClick(
                SAVE_OPTION_ID,
                "Save option not found",
                5
        );
    }

    public void clickBackButton() {
        this.waitForElementAndClick(
                NAVIGATE_BUTTON_XPATH,
                "Cannot find navigation back button",
                10);
    }

    public void backButtonIsAbsent() {
        this.waitForElementAbsence(
                NAVIGATE_BUTTON_XPATH,
                "Returning to the previous page did not occur",
                10);
    }
}
