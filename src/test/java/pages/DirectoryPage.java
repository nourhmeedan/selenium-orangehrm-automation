package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DirectoryPage extends PageBase {

    private By header = By.tagName("h6");

    public DirectoryPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        return waitAndReturnElement(header).getText();
    }
}
