package cleanTest.yopmail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.todoist.*;
import pages.yopmail.InboxIFrame;
import pages.yopmail.MainPageYopmail;
import pages.yopmail.NewMessageIFrame;
import singletonSession.Session;

public class TestBaseYopmail
{
    public MainPageYopmail mainPageYopmail = new MainPageYopmail();
    public InboxIFrame inboxIFrame = new InboxIFrame();
    public NewMessageIFrame newMessageIFrame = new NewMessageIFrame();

    @BeforeEach
    public void setup()
    {
        // todo --> create properties file
        Session.getInstance().getBrowser().get("https://yopmail.com/en/");
    }

    @AfterEach
    public void cleanup()
    {
        Session.getInstance().closeBrowser();
    }

}
