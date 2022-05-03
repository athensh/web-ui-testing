package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;

import java.awt.event.MouseEvent;

public class ContextMenuPage {

    private WebDriver driver;
    private By contentBox = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void rightClickMenu() {
        Actions action = new Actions(driver);
        action.contextClick(driver.findElement(contentBox)).perform();
    }

    public void alert_clickAccept() {
        driver.switchTo().alert().accept();
    }

    public String alert_getText() {
        return driver.switchTo().alert().getText();
    }
}
