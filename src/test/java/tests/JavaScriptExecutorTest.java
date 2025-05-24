package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class JavaScriptExecutorTest {
    private WebDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        String hostname = System.getenv("GITHUB_ACTIONS") != null ? "localhost" : "selenium";
        URL remoteUrl = new URL("http://" + hostname + ":4444/wd/hub");
        System.out.println("Connecting to: " + remoteUrl);
        driver = new RemoteWebDriver(remoteUrl, options);

        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Test
    public void testScrollWithJavaScriptExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down to the bottom of the page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        System.out.println("JavaScriptExecutor used to scroll down.");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
