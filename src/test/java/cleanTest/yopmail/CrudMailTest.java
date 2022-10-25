package cleanTest.yopmail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.yopmail.NewMessageIFrame;
import singletonSession.Session;

import java.util.Date;

public class CrudMailTest extends TestBaseYopmail
{

    @Test
    public void createEmail() throws InterruptedException {
        String randomEmail = new Date().getTime() + "@yopmail.com";

        mainPageYopmail.emailNameTextBox.setText(randomEmail);
        mainPageYopmail.submitEmailButton.click();
        Thread.sleep(2000);

        inboxIFrame.newEMailButton.waitClickable();
        inboxIFrame.newEMailButton.click();
        //Session.getInstance().switchIFrame("ifinbox");

        //Session.getInstance().getBrowser().switchTo().frame("ifmail");
        Session.getInstance().switchIFrame("ifmail");
        newMessageIFrame.recipientTextBox.setText(randomEmail);
        newMessageIFrame.subjectTextBox.setText("Hola");
        newMessageIFrame.bodyTextBox.setText("Un saludo");
        newMessageIFrame.sendMessageButton.click();

        Thread.sleep(3000);


        Session.getInstance().getBrowser().switchTo().defaultContent();
        inboxIFrame.refreshButton.click();

        Session.getInstance().switchIFrame("ifinbox");

        Assertions.assertTrue(inboxIFrame.searchEmailSender(randomEmail));


    }
}
