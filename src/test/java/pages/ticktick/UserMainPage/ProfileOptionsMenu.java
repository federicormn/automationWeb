package pages.ticktick.UserMainPage;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class ProfileOptionsMenu
{
    public Button settings = new Button(By.xpath("//span[text()=\"Settings\"]"));
    public Button statistics = new Button(By.xpath("//span[text()=\"Statistics\"]"));
    public Button premiumAccount = new Button(By.xpath("//span[text()=\"Premium Account\"]"));
    public Button signOut = new Button(By.xpath("//span[text()=\"Sign Out\"]"));

}
