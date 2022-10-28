package pages.ticktick.profileSettings;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class CalendarAndMail
{
    public TextBox currentUniqueEmail = new TextBox(By.xpath("//div[@class=\"my-[10px] flex items-center\"]/input"));
    public Button resetUniqueEmailButton = new Button(By.xpath("//a[text()=\"Reset\"]"));
}
