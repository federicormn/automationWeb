package cleanTest.TestBaseJuiceShop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.oWaspJuiceShop.CatalogPage;
import pages.oWaspJuiceShop.LoginPageJuiceShop;
import pages.oWaspJuiceShop.UserRegistrationPage;
import pages.oWaspJuiceShop.WelcomePopUp;
import singletonSession.Session;

public class TestBaseJuiceShop
{
    WelcomePopUp welcomePopUp = new WelcomePopUp();
    CatalogPage catalogPage = new CatalogPage();
    LoginPageJuiceShop loginPageJuiceShop = new LoginPageJuiceShop();
    UserRegistrationPage userRegistrationPage = new UserRegistrationPage();

    @BeforeEach
    public void setup()
    {
        // todo --> create properties file
        //Session.getInstance().getBrowser().get("https://juice-shop.herokuapp.com/#/");// --> webpage
        Session.getInstance().getBrowser().get("http://192.168.100.26:3000/#/");// --> Docker on linux
    }

    @AfterEach
    public void cleanup()
    {
        Session.getInstance().closeBrowser();
    }

}
