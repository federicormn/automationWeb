package singletonSession;

import controlSelenium.Control;
import factoryBrowser.FactoryBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.yopmail.InboxIFrame;
import utils.GetProperties;

public class Session
{
    private static Session session = null;
    private WebDriver browser;

    private Session()
    {
        // todo --> create properties file - browser
        //SE LLAMA UNA UNICA VEZ -- TO-DO CREATE PROPERTIES FILE (browser) - NO USAR VALORES QUEMADOS
        browser = FactoryBrowser.make(GetProperties.getInstance().getBrowser()).create();
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

    public void switchToDefault()
    {
        getInstance().getBrowser().switchTo().defaultContent();
    }

    public void fetchFromIFrame(Control asd, String IFrameId, InboxIFrame inboxIFrame,String email, int timeOut) throws InterruptedException
    {
        int i= 0;
        do
        {
            //ME MUEVO AL IFRAME DEFAULT
            getInstance().getBrowser().switchTo().defaultContent();
            //Click al control ANTES DE moverme de IFrame
            asd.click();
            //ESPERO UN SEGUNDO ANTES DE MOVERME DE IFRAME
            Thread.sleep(1000);
            //ME MUEVO AL IFRAME PARA CORROBORAR
            getInstance().getBrowser().switchTo().frame(IFrameId);
            //SI SE CUMPLE LA CONDICION ENTRO
            if(inboxIFrame.searchSubjectIntoEmail(email))
            {
                //VUELVO AL DEFAULT IFRAME Y ROMPO
                getInstance().getBrowser().switchTo().defaultContent();
                break;
            }
            //SI NO SE CUMPLE MUEVO LA I Y VUELVO A ITERAR
            i++;

        }while(i <= timeOut);

    }
}


