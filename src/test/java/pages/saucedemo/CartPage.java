package pages.saucedemo;

import controlSelenium.Button;
import controlSelenium.Label;
import org.openqa.selenium.By;

import java.security.PublicKey;

public class CartPage
{
    //PASAR A METODO
    public Button addedItem = new Button(By.xpath("//div[text()=\"Sauce Labs Onesie\"]"));


    public boolean searchItemName(String itemName)
    {
        Label item = new Label(By.xpath("//div[text()='"+itemName+"']"));
        return item.isControlDisplayed();
    }
}
