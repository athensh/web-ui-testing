package contextmenu;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    @Test
    public void testContextMenuAlert() {
        var contextMenu = homePage.clickContextMenu();
        contextMenu.rightClickMenu();
        assertEquals(contextMenu.alert_getText(), "You selected a context menu", "Incorrect alert text");
        contextMenu.alert_clickAccept();
    }

}
