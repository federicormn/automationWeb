package pages.oWaspJuiceShop;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class LoginPageJuiceShop
{
    public TextBox emailTextBox = new TextBox(By.id("email"));
    public TextBox passwordTextBox = new TextBox(By.id("password"));
    public Button loginButton = new Button(By.id("loginButton"));
    public Button notYetACustomerButton = new Button(By.xpath("//a[@href=\"#/register\"]"));
}
