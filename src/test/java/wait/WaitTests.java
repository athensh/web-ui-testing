package wait;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.dynamicloading.DynamicLoadingExample1Page;
import pages.dynamicloading.DynamicLoadingExample2Page;

import static org.testng.Assert.*;

public class WaitTests extends BaseTests {

    @Test
    public void testWaitUntilHidden() {
        DynamicLoadingExample1Page dynamicLoadingPage = homePage.clickDynamicLoading().clickExample1();

        assertTrue(dynamicLoadingPage.isHeader1Displayed(), "Header 1 one is not displayed in example 1");
        assertTrue(dynamicLoadingPage.isHeader2Displayed(), "Header 2 one is not displayed in example 1");
        assertEquals(dynamicLoadingPage.getHeader1(), "Dynamically Loaded Page Elements", "Header 1 is incorrect in example 1");
        assertEquals(dynamicLoadingPage.getHeader2(), "Example 1: Element on page that is hidden", "Header 2 is incorrect in example 1");
        dynamicLoadingPage.clickStart();
        assertEquals(dynamicLoadingPage.getLoadedText(), "Hello World!", "Incorrect loaded text in example 1");
    }

    @Test
    public void testWaitUntilDisplayed() {
        DynamicLoadingExample2Page dynamicLoadingPage = homePage.clickDynamicLoading().clickExample2();
        dynamicLoadingPage.clickStart();
        assertEquals(dynamicLoadingPage.getDisplayedText(), "Hello World!", "Incorrect displayed text");
    }
}
