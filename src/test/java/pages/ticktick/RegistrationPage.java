package pages.ticktick;

import controlSelenium.Button;
import controlSelenium.Control;
import controlSelenium.TextBox;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.util.Date;

public class RegistrationPage
{
    public TextBox nickNameTextBox = new TextBox(By.id("name"));
    public TextBox emailTextBox = new TextBox(By.xpath("//*[@placeholder=\"Email\"]"));
    public TextBox passwordTextBox = new TextBox(By.id("password"));
    public Button signUpButton = new Button(By.xpath("//button[@class=\"button__3eXSs \"]"));


    public void registerNewAccount(Control mainPageSignUpButton)
    {
        mainPageSignUpButton.click();

        String nickName = "Fede";
        String randomEmail = getAlphaNumericString(5) + "@mail.com";
        String firstPassword = "123456";

        nickNameTextBox.waitPresenceOfElement();
        Assertions.assertTrue(nickNameTextBox.isControlDisplayed());

        nickNameTextBox.writeText(nickName);
        emailTextBox.writeText(randomEmail);
        passwordTextBox.writeText(firstPassword);
        signUpButton.click();
    }
    
    public void registerNewAccountParam(Control mainPageSignUpButton, String email,String password)
    {
        mainPageSignUpButton.click();

        String nickName = "Fede";

        nickNameTextBox.waitPresenceOfElement();
        Assertions.assertTrue(nickNameTextBox.isControlDisplayed());

        nickNameTextBox.writeText(nickName);
        emailTextBox.writeText(email);
        passwordTextBox.writeText(password);
        signUpButton.click();
    }

    public String getAlphaNumericString(int n)
    {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int)(AlphaNumericString.length() * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
}
