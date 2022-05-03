package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadsPage {

    private WebDriver driver;
    private By inputField = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedFiles = By.id("uploaded-files");

    public FileUploadsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickUploadButton() {
        driver.findElement(uploadButton).click();
    }

    /**
     * Provides file path to the form and clicks upload button
     * (to not worry about the windows pop up)
     * @param absoluteFilePath The complete path of the file to upload
     */
    public void uploadFile(String absoluteFilePath) {
        driver.findElement(inputField).sendKeys(absoluteFilePath);
        clickUploadButton();
    }

    public String getUploadedFiles() {
        return driver.findElement(uploadedFiles).getText();
    }
}
