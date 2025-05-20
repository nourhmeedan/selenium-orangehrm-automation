package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    protected WebElement waitAndReturnElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public String getBodyText() {
        return waitAndReturnElement(By.tagName("body")).getText();
    }
}