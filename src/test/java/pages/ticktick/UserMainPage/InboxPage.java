package pages.ticktick.UserMainPage;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class InboxPage
{
    public Button nextPopUpButton = new Button(By.xpath("//button[text()=\"Next\"]"));
    public Button skipPopUpButton = new Button(By.xpath("//span[text()=\"Skip\"]"));
    public Button profilePictureID = new Button(By.id("tl-bar-user"));

}
