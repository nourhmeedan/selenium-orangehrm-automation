package tests;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;

import java.net.URL;

public class XPathTest {

    private WebDriver driver;

    @Before
    public void setup() throws Exception {
        
        
        ChromeOptions options = new ChromeOptions();
        String hostname = System.getenv("GITHUB_ACTIONS") != null ? "localhost" : "selenium";
        URL remoteUrl = new URL("http://" + hostname + ":4444/wd/hub");
        System.out.println("Connecting to: " + remoteUrl);
        options.addArguments("--start-maximized");
        driver = new RemoteWebDriver(remoteUrl, options);

    }

    @Test
    public void testTwentyXPaths() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        for (int i = 1; i <= 20; i++) {
            try {
                String xpath = "(//div)[position()=" + i + "]";
                WebElement element = driver.findElement(By.xpath(xpath));
                System.out.println("Found element #" + i + ": " + element.getTagName());
            } catch (Exception e) {
                System.out.println("No element at xpath index " + i);
            }
        }
    }

    @After
    public void teardown() {
        if (driver != null) driver.quit();
    }
}
