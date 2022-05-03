package keypresses;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.KeyPressesPage;

import static org.testng.Assert.assertEquals;

public class KeyPressTests extends BaseTests {

    @Test
    public void testKeyPress() {
        KeyPressesPage keyPressPage = homePage.clickKeyPresses();
        keyPressPage.enterText("A" + Keys.BACK_SPACE);
        assertEquals(keyPressPage.getResult(), "You entered: BACK_SPACE", "Wrong symbol");
    }

    @Test
    public void testPi() {
        KeyPressesPage keyPressPage = homePage.clickKeyPresses();
        keyPressPage.enterPi();
    }
}
