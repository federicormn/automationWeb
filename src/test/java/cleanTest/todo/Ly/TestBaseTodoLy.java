package cleanTest.todo.Ly;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.todo.Ly.*;
import singletonSession.Session;

public class TestBaseTodoLy
{
    public MainPage mainPage = new MainPage();
    public LoginModal loginModal = new LoginModal();
    public MenuSection menuSection = new MenuSection();
    public SettingsMenu settingsMenu = new SettingsMenu();

    public SignUpModal signUpModal = new SignUpModal();
    public  ProjectsList projectsList = new ProjectsList();


    @BeforeEach
    public void setup()
    {
        // todo --> create properties file
        Session.getInstance().getBrowser().get("https://todo.ly/");
    }

    @AfterEach
    public void cleanup()
    {
        Session.getInstance().closeBrowser();
    }
}
