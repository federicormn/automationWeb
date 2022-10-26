package cleanTest.yopmail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.yopmail.NewMessageIFrame;
import singletonSession.Session;

import java.util.Date;

public class CrudMailTest extends TestBaseYopmail
{

    @Test
    public void createEmail() throws InterruptedException {
        String randomEmail = new Date().getTime() + "@yopmail.com";
        String subject = "Hola";

        mainPageYopmail.emailNameTextBox.setText(randomEmail);
        mainPageYopmail.submitEmailButton.click();

        inboxIFrame.newEMailButton.waitClickable();
        inboxIFrame.newEMailButton.click();

        Session.getInstance().switchIFrame("ifmail");
        newMessageIFrame.recipientTextBox.setText(randomEmail);
        newMessageIFrame.subjectTextBox.setText(subject);
        newMessageIFrame.bodyTextBox.setText("Un saludo");
        newMessageIFrame.sendMessageButton.click();

        newMessageIFrame.messageSentPopUp.waitTextToBePresent("Your message has been sent");
        Assertions.assertTrue(newMessageIFrame.messageSentPopUp.isControlDisplayed(), "Error, Popup not displayed.");

        Session.getInstance().getBrowser().switchTo().defaultContent();
        inboxIFrame.refreshButton.waitClickable();
        inboxIFrame.refreshButton.click();

        inboxIFrame.refreshButton.waitTextToDissapear("loading");
        inboxIFrame.inboxListIFrame.waitTextToDissapear("hidden");

        //Session.getInstance().fetchFromIFrame(inboxIFrame.refreshButton, "ifmail", inboxIFrame,randomEmail, 10);

        Session.getInstance().switchIFrame("ifinbox");

        Assertions.assertTrue(inboxIFrame.searchEmailSender(randomEmail) && inboxIFrame.searchSubjectIntoEmail(subject));

        Thread.sleep(3000);


    }
}
