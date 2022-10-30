package pages.ticktick;

import controlSelenium.Button;
import controlSelenium.Control;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;
import org.w3c.dom.Text;

public class SignInPage
{
    public TextBox emailTextBox = new TextBox(By.id("emailOrPhone"));
    public TextBox passwordTextBox = new TextBox(By.id("password"));
    public Button signInButton = new Button(By.xpath("//button[@class=\"button__3eXSs \"]"));
    public Label incorrectCredentialsMsg = new Label(By.xpath("//p[text()=\"Incorrect username or password\"]"));


    public void login(String email, String password)
    {
        emailTextBox.waitPresenceOfElement();
        emailTextBox.writeText(email);

        passwordTextBox.waitPresenceOfElement();
        passwordTextBox.writeText(password);

        signInButton.waitClickable();
        signInButton.click();
    }

    public boolean verifyRedirectAfterPasswordChange(String userEmail, String oldPassword, Control previousPage)
    {
        if(emailTextBox.isControlDisplayed())
        {
            previousPage.waitInvisvilityofElement();
            emailTextBox.writeText(userEmail);
            passwordTextBox.writeText(oldPassword);
            signInButton.click();

            return true;
        }else
        {
            return false;
        }

    }


}
