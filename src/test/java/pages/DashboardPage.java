package pages;
import org.openqa.selenium.*;

public class DashboardPage extends PageBase {
    private By profileIcon = By.className("oxd-userdropdown-name");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProfileVisible() {
        return waitAndReturnElement(profileIcon).isDisplayed();
    }
}