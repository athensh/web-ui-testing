package javascript;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LargeAndDeepDomPage;

public class JavascriptTests extends BaseTests {

    @Test
    public void testScroll() {
        homePage.clickLargeDeepDom().scrollToTable();
    }

    @Test
    public void testInfiniteScroll() {
        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }
}
