package cleanTest.todo.Ly;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.todo.Ly.*;
import singletonSession.Session;
import utils.GetProperties;

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
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
    }

    @AfterEach
    public void cleanup()
    {
        attach();
        Session.getInstance().closeBrowser();
    }
    @Attachment(value = "screenshot",type = "image/png")
    private byte[] attach()
    {
        //todo --> Ej1
        //tomar screenshot
        return ((TakesScreenshot)Session.getInstance().getBrowser()).getScreenshotAs(OutputType.BYTES);
    }
}
