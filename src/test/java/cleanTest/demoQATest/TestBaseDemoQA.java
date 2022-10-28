package cleanTest.demoQATest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.demoQA.MainPage;
import pages.saucedemo.CartPage;
import pages.saucedemo.CatalogPage;
import pages.saucedemo.LoginPageSaucedemo;
import singletonSession.Session;

public class TestBaseDemoQA
{
    MainPage mainPage = new MainPage();


    @BeforeEach
    public void setup()
    {
        // todo --> create properties file
        Session.getInstance().getBrowser().get("https://demoqa.com/elements");
    }

    @AfterEach
    public void cleanup()
    {
        Session.getInstance().closeBrowser();
    }

}
