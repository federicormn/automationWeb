package cleanTest.saucedemo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.saucedemo.CartPage;
import pages.saucedemo.CatalogPage;
import pages.saucedemo.LoginPageSaucedemo;
import pages.yopmail.InboxIFrame;
import pages.yopmail.MainPageYopmail;
import pages.yopmail.NewMessageIFrame;
import singletonSession.Session;

public class TestBaseSaucedemo
{
    LoginPageSaucedemo loginPageSaucedemo = new LoginPageSaucedemo();
    CatalogPage catalogPage = new CatalogPage();
    CartPage cartPage = new CartPage();

    @BeforeEach
    public void setup()
    {
        // todo --> create properties file
        Session.getInstance().getBrowser().get("https://www.saucedemo.com/ ");
    }

    @AfterEach
    public void cleanup()
    {
        Session.getInstance().closeBrowser();
    }

}
