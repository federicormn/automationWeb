package pages.todo.Ly;

import controlSelenium.Button;
import controlSelenium.Checkbox;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class SignUpModal
{
    public TextBox fullNameTextBox = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxFullName"));
    public TextBox emailTextBox = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxEmail"));
    public TextBox passwordTextBox = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxPassword"));
    public Checkbox termsOfServiceCheckBox = new Checkbox(By.id("ctl00_MainContent_SignupControl1_CheckBoxTerms"));
    public Button signUpButton = new Button(By.id("ctl00_MainContent_SignupControl1_ButtonSignup"));
}
