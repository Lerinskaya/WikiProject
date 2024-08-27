package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject{
    private static final String
        SAVE_OPTION_ID = "org.wikipedia:id/nav_tab_reading_lists";

    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    public void clickMyLists() {
        this.waitForElementAndClick(
                By.id(SAVE_OPTION_ID),
                "Save option not found",
                5
        );
    }
}
