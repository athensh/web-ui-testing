package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {

    private WebDriver driver;
    private By slider = By.cssSelector(".sliderContainer input");
    private By rangeText = By.id("range");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setSliderValue(String value) {
        while(!getSliderRange().equals(value))
        driver.findElement(slider).sendKeys(Keys.chord(Keys.ARROW_RIGHT));
    }

    public String getSliderRange() {
        return driver.findElement(rangeText).getText();
    }

}
