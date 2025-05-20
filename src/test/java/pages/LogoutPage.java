package pages;
import org.openqa.selenium.*;

public class LogoutPage extends PageBase {

    private By userDropdown = By.className("oxd-userdropdown-name");
    private By logoutButton = By.xpath("//a[text()='Logout']");

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        waitAndReturnElement(userDropdown).click();
        waitAndReturnElement(logoutButton).click();
    }
}