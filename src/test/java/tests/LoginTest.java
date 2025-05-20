package tests;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.DashboardPage;
import pages.LoginPage;
import pages.LogoutPage;

public class LoginTest {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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
        if (driver != null) driver.quit();
    }
}