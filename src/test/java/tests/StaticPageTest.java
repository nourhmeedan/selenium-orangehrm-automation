package tests;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

import pages.LoginPage;
import pages.DirectoryPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class StaticPageTest {
    private WebDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();

        URL remoteUrl = new URL("http://selenium:4444/wd/hub");


        driver = new RemoteWebDriver(remoteUrl, options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Test
    public void testStaticDirectoryPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        // Wait until Directory menu is clickable
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement directoryMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@href='/web/index.php/directory/viewDirectory']")));
        directoryMenu.click();

        DirectoryPage directoryPage = new DirectoryPage(driver);

        String header = directoryPage.getHeaderText();
        System.out.println("Directory page header: " + header);
        assertTrue(header.contains("Directory"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
