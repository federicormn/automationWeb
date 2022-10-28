package pages.ticktick.profileSettings;

import controlSelenium.Button;
import controlSelenium.Label;
import org.openqa.selenium.By;

public class SettingsPage
{
    public Label settingsHeaderLabel = new Label(By.xpath("//h5[text()=\"Settings\"]"));
    public Button doneButton = new Button(By.xpath("//button[text()=\"Done\"]"));
    public Button accountAndSecurityButton = new Button(By.xpath("//span[text()=\"Account and Security\"]"));
    public Button calendarAndMailButton = new Button(By.xpath("//span[text()=\"Calendar & Mail\"]"));



}
