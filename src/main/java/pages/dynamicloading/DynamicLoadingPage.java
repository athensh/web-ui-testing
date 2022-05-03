package pages.dynamicloading;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;

public class DynamicLoadingPage {

    private WebDriver driver;
    private String linkXPath_Format = ".//a[contains(text(), '%s')";
    //private By exampleLink1 = By.xpath(String.format(linkXPath_Format, "Example 1"));
    //private By exampleLink2 = By.xpath(String.format(linkXPath_Format, "Example 2"));

    //text is long and can change, therefore it's better to avoid it
    private By exampleLink1 = By.linkText("Example 1: Element on page that is hidden");
    private By exampleLink2 = By.linkText("Example 2: Element rendered after the fact");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public DynamicLoadingExample1Page clickExample1() {
        driver.findElement(exampleLink1).click();
        return new DynamicLoadingExample1Page(driver);
    }

    public DynamicLoadingExample2Page clickExample2() {
        driver.findElement(exampleLink2).click();
        return new DynamicLoadingExample2Page(driver);
    }

    public DynamicLoadingExample2Page rightClickOnExample2() {
        Actions action = new Actions(driver);
        //driver.findElement(exampleLink2).sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
        action.keyDown(Keys.CONTROL).click(driver.findElement(exampleLink2)).keyUp(Keys.CONTROL).perform();
        return new DynamicLoadingExample2Page(driver);
    }
}
