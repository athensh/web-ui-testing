package hover;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HoversPage;

import static org.testng.Assert.*;

public class HoverTests extends BaseTests {

    @Test
    public void testHoverUser1() {
        HoversPage hoversPage = homePage.clickHovers();
        var caption = hoversPage.hoverOverFigure(1);
        String user = "User 1";
        assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        assertEquals(caption.getHeader(), "name: user1", "Caption header incorrect");
        assertEquals(caption.getLinkText(), "View profile", "Caption link text incorrect");
        //the site may change from http to https at some point
        assertTrue(caption.getLink().endsWith("/users/1"), "Link is wrong");
    }
}
