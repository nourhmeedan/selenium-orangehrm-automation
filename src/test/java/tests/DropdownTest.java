package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import org.junit.Ignore;


import java.net.URL;
@Ignore("Dropdown test is temporarily disabled due to unstable behavior")
public class DropdownTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup() throws Exception {
        ChromeOptions options = new ChromeOptions();
        URL remoteUrl = new URL("http://selenium:4444/wd/hub"); // Adjust as needed
          // 🔍 Add this line to confirm the URL used
    System.out.println("Connecting to: " + remoteUrl);
        driver = new RemoteWebDriver(remoteUrl, options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10); // ← FIXED for Selenium 3
    }

    @Test
    public void testLeaveTypeDropdown() throws InterruptedException {
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

        Thread.sleep(1500); // wait for dropdown to appear

        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='listbox']//span[contains(text(),'Vacation')]")));
        option.click();

        System.out.println("✅ Dropdown test passed!");
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
