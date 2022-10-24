package cleanTest.todo.Ly;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class ChangeFullNameTest extends TestBaseTodoLy
{

    @Test
    public void changeFullName()
    {
        String randomDate= " " +new Date().getTime();

        mainPage.loginButton.click();

        loginModal.login("fhr@fhr.com","12345");

        menuSection.settingsButton.click();
        settingsMenu.fullNameTextBox.waitClickable();
        String currentFullName = settingsMenu.fullNameTextBox.getAttribute("value");

        settingsMenu.fullNameTextBox.setText(currentFullName + randomDate);
        settingsMenu.okButton.click();

        menuSection.settingsButton.click();
        settingsMenu.fullNameTextBox.waitClickable();
        String newFullName = settingsMenu.fullNameTextBox.getAttribute("value");

        Assertions.assertNotEquals(currentFullName, newFullName);

    }
}
