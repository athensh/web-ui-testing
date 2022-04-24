import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class ShiftingContent {

    public void shiftingContent() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com");

        driver.findElement(By.linkText("Shifting Content")).click();
        WebElement exampleOneLink = driver.findElement(By.linkText("Example 1: Menu Element"));
        exampleOneLink.click();

        List<WebElement> menuElements = driver.findElements(By.tagName("li"));
        System.out.println("The menu has " + menuElements.size() + " elements.");

        driver.quit();
    }
}
