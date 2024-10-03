package lib.ui;

import io.appium.java_client.AppiumDriver;

public class WelcomePageObject extends MainPageObject{

    private static final String
    MAIN_TITLE_ID = "id:Свободная энциклопедия",
    NEXT_BUTTON_XPATH = "xpath://XCUIElementTypeStaticText[@name=\"Далее\"]",
    START_BUTTON_XPATH = "xpath://XCUIElementTypeButton[@name=\"Начать\"]",
    HELP_TEXT_ID = "id:Помогите сделать это приложение лучше";

    public WelcomePageObject(AppiumDriver driver) {
        super(driver);
    }

    public void waitForMainTitle() {
        this.waitForElement(MAIN_TITLE_ID, "Cannot find main page description");
    }

    public void clickNextButton() {
        this.waitForElementAndClick(NEXT_BUTTON_XPATH, "Cannot find next button", 10);
    }

    public void clickGetStartedButton() {
        this.waitForElementAndClick(START_BUTTON_XPATH, "Cannot find next button", 10);
    }

    public void waitForHelpText() {
        this.waitForElement(HELP_TEXT_ID, "Cannot find help text");
    }

}
