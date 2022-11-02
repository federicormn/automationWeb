package pages.todo.Ly;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class LoginModal
{
    public TextBox emailTextBox = new TextBox(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail"),"[Email] textbox on login modal");
    public TextBox passwordTextBox = new TextBox(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword"),"[Password] textbox on login modal");
    public Button loginButton = new Button(By.id("ctl00_MainContent_LoginControl1_ButtonLogin"),"[Login] button on login modal");

    public void login(String user, String pwd)
    {
        emailTextBox.setText(user);
        passwordTextBox.setText(pwd);
        loginButton.click();
    }

}
