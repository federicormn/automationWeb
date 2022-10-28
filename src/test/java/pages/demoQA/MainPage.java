package pages.demoQA;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class MainPage
{
    public Button interactionsButton = new Button(By.xpath("//*[text()=\"Interactions\"]"));
    public Button selectableButton = new Button(By.xpath("//*[text()=\"Selectable\" and @class=\"text\"]"));

}
