package cleanTest.todo.Ly;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import utils.GetProperties;

public class LoginTest extends TestBaseTodoLy
{
    @Test
    @Order(1)
    @DisplayName("Verify login is successfully")
    @Description("this test case is to verify the login using valid credentials with any role")
    @Owner("Fede R")
    @Link("www.jira.com/doc01")
    @Issue("www.jira.com/bug0005")
    @Lead("Testttt")
    @Epic("Login")
    @Feature("Authentication")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Story Login")
    public void verifyLoginSuccesfully()
    {
        mainPage.loginButton.click();

        loginModal.login(GetProperties.getInstance().getUser(), GetProperties.getInstance().getPwd());

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(), "Error, login could not be made.");

    }

}
