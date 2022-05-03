package horizontalslider;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

import static org.testng.Assert.assertEquals;

public class HorizontalSliderTests extends BaseTests {

    @Test
    public void testSliderReaction() {
        HorizontalSliderPage horizontalSliderPage = homePage.clickHorizontalSlider();
        String value = "4";
        horizontalSliderPage.setSliderValue(value);
        assertEquals(horizontalSliderPage.getSliderRange(), value, "Incorrect slider value");
    }
}
