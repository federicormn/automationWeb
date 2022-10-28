package pages.ticktick.userMainPage;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class LeftNavBar
{
    public Button profilePictureID = new Button(By.id("tl-bar-user"));
    public Button tasksButton = new Button(By.xpath("//a[@href=\"#p/inbox/tasks\"]"));

    public Button habitButton = new Button(By.xpath("//a[@class=\"block w-[24px] h-[24px] relative\"]"));
}
