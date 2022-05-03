package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.dynamicloading.DynamicLoadingPage;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //we want this method to not be tested
    private void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public LoginPage clickFormAuthentication() {
        clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    public DropdownPage clickDropdown() {
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    public ForgetPasswordPage forgetPassword() {
        clickLink("Forgot Password");
        return new ForgetPasswordPage(driver);
    }

    public CheckBoxPage clickCheckbox() {
        clickLink("Checkboxes");
        return new CheckBoxPage(driver);
    }

    public HoversPage clickHovers() {
        clickLink("Hovers");
        return new HoversPage(driver);
    }

    public KeyPressesPage clickKeyPresses() {
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }

    public HorizontalSliderPage clickHorizontalSlider() {
        clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }

    public AlertsPage clickJavaScriptAlerts() {
        clickLink("JavaScript Alerts");
        return new AlertsPage(driver);
    }

    public FileUploadsPage clickFileUpload() {
        clickLink("File Upload");
        return new FileUploadsPage(driver);
    }

    public EntryAdPage clickEntryAd() {
        clickLink("Entry Ad");
        return new EntryAdPage(driver);
    }

    public ContextMenuPage clickContextMenu() {
        clickLink("Context Menu");
        return new ContextMenuPage(driver);
    }

    public WysiwigEditorPage clickWysiwigEditor() {
        clickLink("WYSIWYG Editor");
        return new WysiwigEditorPage(driver);
    }

    public NestedFramesPage clickNestedFrames() {
        clickLink("Nested Frames");
        return new NestedFramesPage(driver);
    }

    public DynamicLoadingPage clickDynamicLoading() {
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }

    public LargeAndDeepDomPage clickLargeDeepDom() {
        clickLink("Large & Deep DOM");
        return new LargeAndDeepDomPage(driver);
    }

    public InfiniteScroll clickInfiniteScroll() {
        clickLink("Infinite Scroll");
        return new InfiniteScroll(driver);
    }

    public MultipleWindowsPage clickMultipleWindows() {
        clickLink("Multiple Windows");
        return new MultipleWindowsPage(driver);
    }
}
