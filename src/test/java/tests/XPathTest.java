package tests;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginPage;

public class XPathTest {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testTwentyXPaths() {
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