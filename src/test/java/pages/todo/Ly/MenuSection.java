package pages.todo.Ly;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class MenuSection
{
    public Button logoutButton = new Button(By.xpath("//a[text()='Logout']"),"[Log out] button on Menu Section");
    public Button settingsButton = new Button(By.xpath("//a[@href=\"javascript:OpenSettingsDialog();\"]"));
}
