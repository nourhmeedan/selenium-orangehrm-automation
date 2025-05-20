package pages;
import org.openqa.selenium.*;


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

public class DashboardPage extends PageBase {
    private By profileIcon = By.className("oxd-userdropdown-name");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProfileVisible() {
        return waitAndReturnElement(profileIcon).isDisplayed();
    }
}