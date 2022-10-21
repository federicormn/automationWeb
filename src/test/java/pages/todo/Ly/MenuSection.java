package pages.todo.Ly;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class MenuSection
{
    public Button logoutButton = new Button(By.xpath("//a[text()='Logout']"));
    public Button settingsButton = new Button(By.xpath("//a[@href=\"javascript:OpenSettingsDialog();\"]"));
}
