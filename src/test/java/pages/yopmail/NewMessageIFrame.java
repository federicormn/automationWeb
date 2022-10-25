package pages.yopmail;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class NewMessageIFrame
{
    public TextBox recipientTextBox = new TextBox(By.id("msgto"));
    public TextBox subjectTextBox = new TextBox(By.id("msgsubject"));
    public TextBox bodyTextBox = new TextBox(By.id("msgbody"));
    public Button sendMessageButton = new Button(By.id("msgsend"));
}
