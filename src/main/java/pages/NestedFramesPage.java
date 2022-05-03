package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {

    private WebDriver driver;
    private String initialFrame = "frame-top";
    private String leftFrame = "frame-left";
    private String bottomFrame = "frame-bottom";
    private By body = By.tagName("body");

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLeftFrameText() {
        switchToFrame(initialFrame);
        switchToFrame(leftFrame);
        String frameText = getTextFromBody();
        switchToMainFrame();
        switchToMainFrame();
        return frameText;
    }

    public String getBottomFrameText() {
        switchToFrame(bottomFrame);
        String frameText = getTextFromBody();
        switchToMainFrame();
        return frameText;
    }

    private void switchToFrame(String frame) {
        driver.switchTo().frame(frame);
    }

    public void switchToMainFrame() {
        driver.switchTo().parentFrame();
    }

    public String getTextFromBody() {
        return driver.findElement(body).getText();
    }
}
