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

public class LogoutPage extends PageBase {

    private By userDropdown = By.className("oxd-userdropdown-name");
    private By logoutButton = By.xpath("//a[text()='Logout']");

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        waitAndReturnElement(userDropdown).click();
        waitAndReturnElement(logoutButton).click();
    }
}