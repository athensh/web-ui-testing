package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {

    private WebDriver driver;
    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFromDropdown(String option) {
        //select is not a WebElement, we add selenium-support dependency
        findDropdownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions() {
        List<WebElement> selectedElements = findDropdownElement().getAllSelectedOptions();
        //all the selected options, for the test to make sure the only thing selected is what it's expecting to be selected.
        //i want them to be list of strings and not web elements
        return selectedElements.stream().map(e -> e.getText()).collect(Collectors.toList());
        //return selectedElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    private Select findDropdownElement() {
        //Select allows you to select/deselect
        return new Select(driver.findElement(dropdown));
    }
}