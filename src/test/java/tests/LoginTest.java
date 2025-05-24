package tests;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.DashboardPage;
import pages.LoginPage;
import pages.LogoutPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    private WebDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        // Use RemoteWebDriver with Dockerized Selenium Grid
        ChromeOptions options = new ChromeOptions();

        URL remoteUrl = new URL("http://selenium-grid:4444/wd/hub");
        driver = new RemoteWebDriver(remoteUrl, options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Navigate to OrangeHRM demo site
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Test
    public void testLoginAndLogout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        System.out.println("Page Title: " + loginPage.getPageTitle());
        Assert.assertTrue(loginPage.getPageTitle().contains("OrangeHRM"));

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isProfileVisible());

        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.logout();

        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
