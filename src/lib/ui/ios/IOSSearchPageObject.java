package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class IOSSearchPageObject extends SearchPageObject{
    static{
        SKIP_BUTTON_XPATH = "xpath://*[contains(@name, 'Skip')]";
        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_INPUT = "xpath://XCUIElementTypeSearchField[@value='Search Wikipedia']";
        SEARCH_CANCEL_BUTTON = "id:Clear text";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeStaticText[@name='{SUBSTRING}']";
        //XCUIElementTypeStaticText[@name="Object-oriented programming language"]
//        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_description' and @text='{SUBSTRING}']";
        EMPTY_RESULT ="id:No results found";
        LIST_ITEM_ID = "//XCUIElementTypeCell";
    }

    public IOSSearchPageObject(AppiumDriver driver) {
        super(driver);
    }
}
