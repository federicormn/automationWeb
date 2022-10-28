package pages.ticktick.profileSettings;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class AccountAndSecurity
{
    public Button changePasswordButton = new Button(By.xpath("//a[text()=\"Change Password\"]"));
    public TextBox currentPasswordTextBox = new TextBox(By.xpath("//div[@style=\"display: block;\"]/span/input[@placeholder=\"Current Password\"]"));
    public TextBox newPasswordTextBox = new TextBox(By.xpath("//div[@style=\"display: block;\"]/span[last()]/input[@placeholder=\"New password\"]"));
    public Button saveNewPassword = new Button(By.xpath("//button[text()=\"Save\"]"));
    public Button deleteAccountButton = new Button(By.xpath("//a[text()=\"Delete Account\"]"));

    public void resetPasswordToDefault(String changedPassword ,String defaultPassword)
    {
        changePasswordButton.waitClickable();
        changePasswordButton.click();

        currentPasswordTextBox.writeText(changedPassword);
        newPasswordTextBox.writeText(defaultPassword);
        saveNewPassword.waitClickable();
        saveNewPassword.click();

        saveNewPassword.waitInvisvilityofElement();
        currentPasswordTextBox.waitInvisvilityofElement();
        newPasswordTextBox.waitInvisvilityofElement();
    }


}
