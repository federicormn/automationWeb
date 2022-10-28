package pages.ticktick.userMainPage.leftSideMenu;

import controlSelenium.Button;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class TasksMenu
{
    public Button InboxButton = new Button(By.xpath("//p[@class=\"text-s font-normal flex-auto truncate leading-[20px] text-grey\" and text()=\"Inbox\"]"));
    public Button addListButton = new Button(By.xpath("//p[text()=\"Lists\"]/following-sibling::button//*[contains(@class,\"icon-list-add\")]"));

    public TextBox newListNameTextBox = new TextBox(By.id("edit-project-name"));
    public Button saveNewList = new Button(By.xpath("//button[text()=\"Save\"]"));
    public Label duplicatedTestWarning = new Label(By.xpath("//p[@class=\"warn text-alert text-sml mt-[5px] text-warn-red text-[13px]\"]"));


    public Button searchList(String listName)
    {
        return new Button(By.xpath("//p[@class='text-s font-normal flex-auto truncate leading-[20px] text-grey' and text()='" + listName + "']"));
    }
}
