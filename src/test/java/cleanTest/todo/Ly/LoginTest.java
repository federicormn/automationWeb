package cleanTest.todo.Ly;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends TestBaseTodoLy
{
    @Test
    public void verifyLoginSuccesfully()
    {
        mainPage.loginButton.click();

        loginModal.login("fhr@fhr.com","12345");

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(), "Error, login could not be made.");

    }

}
