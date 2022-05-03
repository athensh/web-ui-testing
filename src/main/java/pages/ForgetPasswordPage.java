package pages;

import jdk.jshell.execution.StreamingExecutionControl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgetPasswordPage {

    private WebDriver driver;
    private By emailField = By.id("email");
    private By retrievePasswordButton = By.id("form_submit");

    public ForgetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public EmailSentPage clickRetrievePasswordButton() {
        driver.findElement(retrievePasswordButton).click();
        return new EmailSentPage(driver);
    }

    public EmailSentPage retrievePassword(String email) {
        setEmail(email);
        return clickRetrievePasswordButton();
    }

}
