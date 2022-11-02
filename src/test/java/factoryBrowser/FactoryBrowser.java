package factoryBrowser;

public class FactoryBrowser
{
    public static IBrowser make(String browserType)
    {
        IBrowser browser;

        switch (browserType.toLowerCase())
        {
            case "chrome":
                browser = new Chrome();
                break;
            case "cloud":
                browser = new Cloud();
                break;
            case "headless":
                browser = new Headless();
                break;
            case "edge":
                browser = new Edge();
                break;
            default:
                browser = new FireFox();
                break;
        }
        return browser;
    }

}
