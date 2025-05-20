import org.openqa.selenium.*;

public class LoginPage extends PageBase {

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    public void login(String username, String password) {
        waitAndReturnElement(usernameField).sendKeys(username);
        waitAndReturnElement(passwordField).sendKeys(password);
        waitAndReturnElement(loginButton).click();
    }
}