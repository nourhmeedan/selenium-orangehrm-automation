package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverConfigTest {

    private WebDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        // ✅ Advanced WebDriver Configuration
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");

        URL remoteUrl = new URL("http://selenium:4444/wd/hub");
          // 🔍 Add this line to confirm the URL used
    System.out.println("Connecting to: " + remoteUrl);

        driver = new RemoteWebDriver(remoteUrl, options);
        driver.manage().window().maximize();
    }

    @Test
    public void testWebDriverConfiguration() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        System.out.println("Title with custom config: " + driver.getTitle());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
