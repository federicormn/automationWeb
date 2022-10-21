package cleanTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.todo.Ly.LoginModal;
import pages.todo.Ly.MainPage;
import pages.todo.Ly.MenuSection;
import pages.todo.Ly.SettingsMenu;
import singletonSession.Session;

public class TestBaseTodoLy
{
    public MainPage mainPage = new MainPage();
    public LoginModal loginModal = new LoginModal();
    public MenuSection menuSection = new MenuSection();

    public SettingsMenu settingsMenu = new SettingsMenu();

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
