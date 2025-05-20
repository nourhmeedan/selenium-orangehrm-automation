package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ApplyLeavePage extends PageBase {

    private final By leaveTypeDropdown = By.id("applyleave_txtLeaveType");

    public ApplyLeavePage(WebDriver driver) {
        super(driver);
    }

    public void selectLeaveType(String leaveType) {
        Select dropdown = new Select(waitAndReturnElement(leaveTypeDropdown));
        dropdown.selectByVisibleText(leaveType); // ex: "CAN - Vacation"
    }
}
