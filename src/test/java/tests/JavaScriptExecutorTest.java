package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorTest {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
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
