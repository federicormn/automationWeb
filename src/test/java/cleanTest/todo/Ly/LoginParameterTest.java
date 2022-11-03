package cleanTest.todo.Ly;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.testng.annotations.Listeners;
import utils.GetProperties;

@Listeners(utils.TestAllureListeners.class)
public class LoginParameterTest extends TestBaseTodoLy
{
    @ParameterizedTest
    @CsvSource(
            {
                    "ngroup001@ng.com,12345",
                    "fhr@fhr.com,12345",
                    "usertodoly@gmail.com,danger1234",
                    "enzo222@gmail.com,enzo222"
            }
    )
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
    @ExtendWith(TestBaseTodoLy.class)
    public void verifyLoginSuccesfully(String user, String pwd)
    {
        mainPage.loginButton.click();

        //loginModal.login(GetProperties.getInstance().getUser(), GetProperties.getInstance().getPwd());
        loginModal.login(user, pwd);
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(), "Error, login could not be made.");

    }

}
