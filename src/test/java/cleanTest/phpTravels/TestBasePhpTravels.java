package cleanTest.phpTravels;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.phpTravels.LoginPagePHP;
import pages.phpTravels.MainPagePHP;
import pages.phpTravels.RegisterPagePHP;
import pages.phpTravels.UserPage;
import pages.saucedemo.CartPage;
import pages.saucedemo.CatalogPage;
import pages.saucedemo.LoginPageSaucedemo;
import singletonSession.Session;
import utils.GetProperties;

public class TestBasePhpTravels
{
    MainPagePHP mainPagePHP = new MainPagePHP();
    RegisterPagePHP registerPagePHP = new RegisterPagePHP();
    UserPage userPage = new UserPage();

    LoginPagePHP loginPagePHP = new LoginPagePHP();

    @BeforeEach
    public void setup()
    {
        Session.getInstance().getBrowser().get("https://phptravels.com/demo/");
    }

    @AfterEach
    public void cleanup()
    {
        Session.getInstance().closeBrowser();
    }


}
