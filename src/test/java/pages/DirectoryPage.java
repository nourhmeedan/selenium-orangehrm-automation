package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class DirectoryPage extends PageBase {

    private By header = By.tagName("h6");

    public DirectoryPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        return waitAndReturnElement(header).getText();
    }
}
