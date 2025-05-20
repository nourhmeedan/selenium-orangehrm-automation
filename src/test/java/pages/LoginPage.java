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

public class LoginPage extends PageBase {

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    public void login(String username, String password) {
        waitAndReturnElement(usernameField).sendKeys(username);
        waitAndReturnElement(passwordField).sendKeys(password);
        waitAndReturnElement(loginButton).click();
    }
}