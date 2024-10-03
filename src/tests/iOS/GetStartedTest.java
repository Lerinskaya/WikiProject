package tests.iOS;

import lib.CoreTestCaseIos;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class GetStartedTest extends CoreTestCaseIos {
    @Test
    public void testPassThroughWelcome() {
        WelcomePageObject WelcomePage = new WelcomePageObject(driver);

        WelcomePage.waitForMainTitle();
        WelcomePage.clickNextButton();
        WelcomePage.clickNextButton();
        WelcomePage.clickNextButton();
        WelcomePage.waitForHelpText();
    }
}
