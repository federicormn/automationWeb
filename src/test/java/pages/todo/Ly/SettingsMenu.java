package pages.todo.Ly;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SettingsMenu
{
    public TextBox fullNameTextBox = new TextBox(By.id("FullNameInput"));
    public Button okButton = new Button(By.xpath("//button[@class=\"ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only\"]//span"));

    public void changeFullName(String name)
    {


    }
}
