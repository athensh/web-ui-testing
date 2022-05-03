package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwigEditorPage {

    private WebDriver driver;
    private By textField = By.id("tinymce");
    private String editorIdFrame = "mce_0_ifr";
    private By decreaseIndentation = By.xpath("//button[@title='Increase indent']");

    public WysiwigEditorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clearTextArea() {
        switchToArea(); //entering iframe, must also exit
        driver.findElement(textField).clear();
        switchToMainArea();
    }

    public void setTextArea(String text) {
        switchToArea();
        driver.findElement(textField).sendKeys(text);
        switchToMainArea();
    }

    public void decreaseIndentation() {
        //it's outside of iframe
        driver.findElement(decreaseIndentation).click();
    }

    public String getTextFromArea() {
        switchToArea();
        String text = driver.findElement(textField).getText();
        switchToMainArea();
        return text;
    }

    private void switchToArea() {
        driver.switchTo().frame(editorIdFrame);
    }

    private void switchToMainArea() {
        driver.switchTo().parentFrame();
    }

}
