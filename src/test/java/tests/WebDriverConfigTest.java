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
       String hostname = System.getenv("GITHUB_ACTIONS") != null ? "localhost" : "selenium";
       URL remoteUrl = new URL("http://" + hostname + ":4444/wd/hub");
       System.out.println("Connecting to: " + remoteUrl);
       driver = new RemoteWebDriver(remoteUrl, options);

        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");

       
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
