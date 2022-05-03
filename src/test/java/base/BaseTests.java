package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.CookieManager;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    private EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        //driver.get("https://the-internet.herokuapp.com/");
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //this is on project level, not on method
        goHome();
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    /*@AfterClass
    public void tearDown() {
        driver.quit();
    }*/

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if(ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            //System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @return  Window manager handle for all tests
     */
    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }


    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        //options.setHeadless(true); //chrome window doesn't appear
        return options;
    }

    public CookieManager getCookieManager() {
        return new CookieManager(driver);
    }
}

       /*//window size options
        driver.manage().window().setSize(new Dimension(375, 812)); //maximize(),fullscreen();

        List<WebElement> links = driver.findElements(By.tagName("a")); // <a></a>
        System.out.println(links.size());

        //finds and clicks element
        WebElement inputsLink = driver.findElement(By.linkText("Inputs")); //returns the first element called inputs
        inputsLink.click();


        WebElement inputsLink = driver.findElement(By.linkText("Extras")); //throws exception
        inputsLink.click();

        System.out.println(driver.getTitle()); //gets the title of the application
        driver.quit(); //quits the browser session
        driver.close(); // closes the window, not necessarily the session*/