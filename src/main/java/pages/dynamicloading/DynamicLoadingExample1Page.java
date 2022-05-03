package pages.dynamicloading;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingExample1Page {

    private WebDriver driver;
    private By headerText1 =  By.tagName("h3");
    private By headerText2 =  By.tagName("h4");
    private By startButton = By.cssSelector("#start button");
    private By loadingIndicator = By.id("loading");
    private By loadedText  = By.id("finish");


    public DynamicLoadingExample1Page(WebDriver driver) {
        this.driver = driver;
    }

    public void clickStart() {
        driver.findElement(startButton).click();
       /* WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));*/

        //same thing
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(5)).
                pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));
    }

    public String getLoadedText() {
        return driver.findElement(loadedText).getText();
    }

    public String getHeader1() {
        return driver.findElement(headerText1).getText();
    }

    public boolean isHeader1Displayed() {
        return driver.findElement(headerText1).isDisplayed();
    }

    public String getHeader2() {
        return driver.findElement(headerText2).getText();
    }

    public boolean isHeader2Displayed() {
        return driver.findElement(headerText2).isDisplayed();
    }
}
