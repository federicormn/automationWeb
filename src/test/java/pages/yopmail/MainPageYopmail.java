package pages.yopmail;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class MainPageYopmail
{
    public TextBox emailNameTextBox = new TextBox(By.id("login"));
    public Button submitEmailButton = new Button(By.xpath("//button[@title=\"Check Inbox @yopmail.com\"]"));
}
