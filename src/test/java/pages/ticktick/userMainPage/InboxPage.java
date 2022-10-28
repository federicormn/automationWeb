package pages.ticktick.userMainPage;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class InboxPage
{
    public Button nextPopUpButton = new Button(By.xpath("//button[text()=\"Next\"]"));
    public Button skipPopUpButton = new Button(By.xpath("//span[text()=\"Skip\"]"));


}
