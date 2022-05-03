package window;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class WindowTests extends BaseTests {

    @Test
    public void testNavigation() {
        homePage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().goForward();
        getWindowManager().refreshPage();
        getWindowManager().navigateToPage("https://2050.earth");
    }

    @Test
    public void testMultipleWindows() {
        String tabTitle = "New Window";
        homePage.clickMultipleWindows().clickHere();
        getWindowManager().switchToTab(tabTitle);
    }

    @Test
    public void testNewTabDynamicLoading2() {
        var exampleButton2 = homePage.clickDynamicLoading().rightClickOnExample2();
        getWindowManager().switchToTab();
        assertTrue(exampleButton2.isStartButtonDisplayed(), "Start button isn not displayed");

    }
}
