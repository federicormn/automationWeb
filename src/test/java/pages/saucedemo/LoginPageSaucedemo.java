package pages.saucedemo;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class LoginPageSaucedemo
{
    public TextBox usernameTextBox = new TextBox(By.id("user-name"));
    public TextBox passwordTextBox = new TextBox(By.id("password"));
    public Button loginButton = new Button(By.id("login-button"));

    public void login(String userName, String pwd)
    {
        usernameTextBox.setText(userName);
        passwordTextBox.setText(pwd);
        loginButton.click();
    }
}
