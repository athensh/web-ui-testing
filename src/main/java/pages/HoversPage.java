package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HoversPage {

    private WebDriver driver;
    private By figureBox = By.className("figure");
    private By figCaption = By.className("figcaption");

    public HoversPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     *
     * @param index starts from 1
     */
    public FigureCaption hoverOverFigure(int index) {
        Actions actions = new Actions(driver);
        WebElement figure =  driver.findElements(figureBox).get(index - 1);

        actions.moveToElement(figure).perform();
        return new FigureCaption(figure.findElement(figCaption));
    }

    public class FigureCaption {

        private WebElement caption;
        private By header = By.tagName("h5");
        private By link = By.tagName("a");

        public FigureCaption(WebElement caption) {
            this.caption = caption;
        }

        public boolean isCaptionDisplayed() {
            return caption.isDisplayed();
        }

        public String getHeader() {
            return caption.findElement(header).getText();
        }

        //returns the link of the /users/1
        public String getLink() {
            return caption.findElement(link).getAttribute("href");
        }

        public String getLinkText() {
            return caption.findElement(link).getText();
        }
    }
}
