package pages;

import org.openqa.selenium.*;

import java.util.List;

public class LargeAndDeepDomPage {

    private WebDriver driver;
    private By table = By.id("large-table");

    public LargeAndDeepDomPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToTable() {
        WebElement tableElement = driver.findElement(table);

        //to do some js commands, scroll -> js
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script, tableElement);

    }
}
