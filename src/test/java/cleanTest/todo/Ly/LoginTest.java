package cleanTest.todo.Ly;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testng.annotations.Listeners;
import utils.GetProperties;

@Listeners(utils.TestAllureListeners.class)
public class LoginTest extends TestBaseTodoLy
{
    @Test
    @Order(1)
    @DisplayName("Verify login is successful")
    @Description("this test case is to verify the login using valid credentials with any role")
    @Owner("Fede R")
    @Link("www.jira.com/doc01")
    @Issue("www.jira.com/bug0005")
    @Lead("Testttt")
    @Epic("Login")
    @Feature("Authentication")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Story Login")
    @Tag("SmokeTest")
    @ExtendWith(TestBaseTodoLy.class)
    public void verifyLoginSuccesfully()
    {
        mainPage.loginButton.click();

        loginModal.login(GetProperties.getInstance().getUser(), GetProperties.getInstance().getPwd());

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(), "Error, login could not be made.");

    }

}
