package singletonSession;

import factoryBrowser.FactoryBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Session
{
    private static Session session = null;
    private WebDriver browser;

    private Session()
    {
        // todo --> create properties file - browser
        //SE LLAMA UNA UNICA VEZ -- TO-DO CREATE PROPERTIES FILE (browser) - NO USAR VALORES QUEMADOS
        browser = FactoryBrowser.make("chrome").create();
    }

    public static Session getInstance() //SIN SYNCHRONIZED PARA EJECUCIONES PARALELAS
    {
        if( session == null)
        {
            session = new Session();
        }
        return session;
    }

    public void closeBrowser()
    {
        browser.quit();
        session = null; //MATA EL SINGLETON Y CIERRA LA SESION
    }

    public WebDriver getBrowser() {
        return browser;
    }

    //alertas
    //tabs /wondws /iframes
    //Implementation of iFrames
    public void switchIFrame(String iFrameId)
    {
        getInstance().getBrowser().switchTo().frame(iFrameId);
    }
}


