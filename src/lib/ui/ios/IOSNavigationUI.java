package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;

public class IOSNavigationUI extends NavigationUI {
    static {
        SAVE_OPTION_ID = "id:tabbar-save";
        CLOSE_BUTTON = "id:Close";
        NAVIGATE_BUTTON_XPATH = "xpath://android.widget.ImageButton[@content-desc=\"Navigate up\"]";
    }

    public IOSNavigationUI(AppiumDriver driver) {
        super(driver);
    }
}
