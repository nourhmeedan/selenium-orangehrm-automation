package tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.LoginPage;
import pages.ApplyLeavePage;

import java.net.URL;
import java.net.URI;



public class DropdownTest {

    public WebDriver driver;

    @Before
    public void setup() throws Exception {
        ChromeOptions options = new ChromeOptions();
       URL seleniumHubUrl = URI.create("http://selenium:4444/wd/hub").toURL();
       driver = new RemoteWebDriver(seleniumHubUrl, options);
        driver.manage().window().maximize();
    }
    

    @Test
    public void testLeaveTypeDropdown() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/leave/applyLeave");

        ApplyLeavePage applyLeavePage = new ApplyLeavePage(driver);
        applyLeavePage.selectLeaveType("CAN - Vacation");
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
