package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;

import pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;

public class DropdownTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup() throws MalformedURLException {
        // Connect to the Selenium container by its service/container name (inside Docker network)
        ChromeOptions options = new ChromeOptions();
        URL remoteUrl = new URL("http://selenium:4444/wd/hub"); // "selenium" is the container name

        driver = new RemoteWebDriver(remoteUrl, options);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testLeaveTypeDropdown() {
        driver.get("https://opensource-demo.orangehrmlive.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        WebElement leaveMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Leave']/ancestor::a")));
        leaveMenu.click();

        WebElement applyMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href, 'applyLeave')]")));
        applyMenu.click();

        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[text()='Leave Type']/following::div[@class='oxd-select-text'][1]")));
        dropdown.click();

        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@role='option']/span[text()='CAN - Vacation']")));
        option.click();

        System.out.println("Dropdown test passed!");
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
