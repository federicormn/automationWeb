package cleanTest.TestBaseJuiceShop;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.OWaspJuiceShop.CatalogPage;
import pages.OWaspJuiceShop.LoginPageJuiceShop;
import pages.OWaspJuiceShop.UserRegistrationPage;
import pages.OWaspJuiceShop.WelcomePopUp;
import pages.saucedemo.CartPage;
import pages.saucedemo.LoginPageSaucedemo;
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
        //Session.getInstance().getBrowser().get("https://juice-shop.herokuapp.com/#/");
        Session.getInstance().getBrowser().get("http://192.168.100.26:3000/#/");//http://192.168.100.26:3000/#/
    }

    @AfterEach
    public void cleanup()
    {
        Session.getInstance().closeBrowser();
    }

}
