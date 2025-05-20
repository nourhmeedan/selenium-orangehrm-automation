package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DirectoryPage;
import pages.LoginPage;

import static org.junit.Assert.assertTrue;

public class StaticPageTest {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testStaticDirectoryPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        driver.findElement(By.xpath("//a[@href='/web/index.php/directory/viewDirectory']")).click();
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