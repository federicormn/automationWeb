package pages.ticktick.ProfileSettings;

import controlSelenium.Button;
import controlSelenium.Checkbox;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class DeleteAccountPopUp
{
    public TextBox confirmCurrentPasswordTextBox = new TextBox(By.id("password-input"));
    public Checkbox awareDataRemovalCheckbox = new Checkbox(By.id("check-data"));
    public Checkbox sureToDeleteCheckbox = new Checkbox(By.id("check-account"));
    public Button confirmDeleteButton = new Button(By.xpath("//button[text()=\"Confirm\"]"));
    public Button cancelDeleteButton = new Button(By.xpath("//div[@class=\"popup-footer\"]//button[text()=\"Cancel\"]"));
}
