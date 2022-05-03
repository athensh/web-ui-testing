package cookies;

import base.BaseTests;
import org.testng.annotations.Test;
import utils.CookieManager;

import static org.testng.Assert.*;

public class CookieTests extends BaseTests {

    @Test
    public void testAddCookie() {
        var cookie = getCookieManager().buildCookie("internet", "007");
        getCookieManager().addCookie(cookie);
        assertTrue(getCookieManager().isCookieDisplayed(cookie), "Cookie was not added");
    }

    @Test
    public void testDeleteCookie() {
        var cookie = getCookieManager().buildCookie("optimizelyBuckets", "%7B%22298349752%22%3A%22298343790%22%7D");
        getCookieManager().deleteCookie(cookie);
        assertFalse(getCookieManager().isCookieDisplayed(cookie), "Cookie was not deleted");
    }


}
