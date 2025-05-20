package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ApplyLeavePage extends PageBase {

    // Modern OrangeHRM uses custom dropdowns (not <select>), so no Select class
    private final By leaveTypeDropdown = By.xpath("//label[text()='Leave Type']/following::div[@class='oxd-select-text-input'][1]");
    private final By dropdownOption = By.xpath("//div[@role='listbox']//span[text()='CAN - Vacation']");

    public ApplyLeavePage(WebDriver driver) {
        super(driver);
    }

 public void selectLeaveType(String leaveType) {
    By optionToSelect = By.xpath("//div[@role='listbox']//span[text()='" + leaveType + "']");
    waitAndReturnElement(optionToSelect).click();
}


}
