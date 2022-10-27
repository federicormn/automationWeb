package pages.OWaspJuiceShop;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class WelcomePopUp
{
    public Button closePopUpButton = new Button(By.xpath("//button[@aria-label=\"Close Welcome Banner\"]"));

    public void closePopUpIfDisplayed()
    {
        if(closePopUpButton.isControlDisplayed())
        {
            closePopUpButton.waitClickable();
            closePopUpButton.click();

        }

    }
}
