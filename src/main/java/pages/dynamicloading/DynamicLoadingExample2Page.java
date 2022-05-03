package pages.dynamicloading;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingExample2Page {

    private WebDriver driver;
    private By startButton = By.cssSelector("#start button");
    //private By loadingText = By.id("loading");
    private By displayedText = By.id("finish");

    public DynamicLoadingExample2Page(WebDriver driver) {
        this.driver = driver;
    }

    public void clickStart() {
        driver.findElement(startButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(displayedText));
    }

    public String getDisplayedText() {
        return driver.findElement(displayedText).getText();
    }

    public boolean isStartButtonDisplayed() {
        return driver.findElement(startButton).isDisplayed();
    }

}
