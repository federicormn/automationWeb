package pages.phpTravels;

import controlSelenium.Button;
import controlSelenium.Label;
import org.openqa.selenium.By;

public class UserPage
{
    public Button accountSettingsButton = new Button(By.xpath("//li[@id=\"Secondary_Navbar-Account\"]/a"),"[Account Settings] Button on User page");
    public Button logoutButton = new Button(By.xpath("//a[contains(text(), 'Logout')]"), "[Logout] Button in [Account Settings] menu");


    public Label getYourInfoName(String nameToSearch)
    {
        return new Label(By.xpath("//div[@class=\"card-body\"]/em[contains(text(),'" +nameToSearch+ "')]"));
    }

    public boolean verifyIfNameExists(String nameToSearch)
    {
        if(getYourInfoName(nameToSearch).isControlDisplayed())
        {
            return true;
        }else
        {
            return false;
        }
    }
}
