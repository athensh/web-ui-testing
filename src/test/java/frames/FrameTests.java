package frames;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.NestedFramesPage;
import pages.WysiwigEditorPage;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {

    @Test
    public void testWysiwigEditor() {
        WysiwigEditorPage wysiwigEditorPage = homePage.clickWysiwigEditor();
        String text1 = "These aren't the droids you're looking for.";
        String text2 = " I am your father";
        wysiwigEditorPage.clearTextArea();
        wysiwigEditorPage.setTextArea(text1);
        wysiwigEditorPage.decreaseIndentation();
        wysiwigEditorPage.setTextArea(text2);
        assertEquals(wysiwigEditorPage.getTextFromArea(), text1 + text2, "Incorrect text from the editor");
    }


    @Test
    public void testNestedFrames() {
        NestedFramesPage nestedFramesPage = homePage.clickNestedFrames();
       // assertEquals(nestedFramesPage.getTextFromLeftFrame(frameLeft, 2), "LEFT", "Incorrect frame text");
        assertEquals(nestedFramesPage.getBottomFrameText(), "BOTTOM", "Incorrect frame text");
    }
}
