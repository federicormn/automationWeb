package pages.ticktick;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class RegistrationPage
{
    public TextBox nickNameTextBox = new TextBox(By.id("name"));
    public TextBox emailTextBox = new TextBox(By.xpath("//*[@placeholder=\"Email\"]"));
    public TextBox passwordTextBox = new TextBox(By.id("password"));
    public Button signUpButton = new Button(By.xpath("//button[@class=\"button__3eXSs \"]"));

}
