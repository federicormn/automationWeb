package cleanTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class RegisterTest extends TestBaseTodoLy
{
    @Test
    public void registerNewAccount()
    {
        String testName = "Fede";
        String mailName="mail"+ new Date().getTime()+"@mail.com";
        String firstPassword = "12345";

        mainPage.signUpButton.click();
        signUpModal.fullNameTextBox.setText(testName);
        signUpModal.emailTextBox.setText(mailName);
        signUpModal.passwordTextBox.setText(firstPassword);
        signUpModal.termsOfServiceCheckBox.check();
        signUpModal.signUpButton.click();

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(), "Error, register could not be made.");

    }
}
