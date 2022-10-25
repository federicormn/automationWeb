package pages.yopmail;

import controlSelenium.Button;
import controlSelenium.Label;
import org.openqa.selenium.By;

public class InboxIFrame
{
    public Label inboxListIFrame = new Label(By.id("ifinbox"));
    public Button newEMailButton = new Button(By.id("newmail"));

    public Button refreshButton = new Button(By.id("refresh"));


    public boolean searchEmailSender(String emailName)
    {
        Button mailToFind = new Button(By.xpath("//span[@class='lmf' and text()='" + emailName +"']"));
        return mailToFind.isControlDisplayed();

    }
}

