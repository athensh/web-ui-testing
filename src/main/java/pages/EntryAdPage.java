package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EntryAdPage {

    private WebDriver driver;
    //issue with modal window not appearing
    private By modalWindow = By.cssSelector(".modal");
    private By modalBody = By.className("modal-body");
    private By modalFooter = By.className("modal-footer");

    public EntryAdPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isModalDisplayed() {
        return driver.findElement(modalWindow).isDisplayed();
    }

    public String getModalBody() {
        return driver.findElement(modalBody).getText();

    }

    public void clickModalFooter() {
        driver.switchTo().activeElement().click();
    }


}
