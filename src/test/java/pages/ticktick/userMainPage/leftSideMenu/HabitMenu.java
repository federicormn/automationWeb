package pages.ticktick.userMainPage.leftSideMenu;

import controlSelenium.Button;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

import java.security.PublicKey;

public class HabitMenu
{
    public Label habitHeaderLabel = new Label(By.xpath("//h5[text()=\"Habit\"]"));
    public Button createHabitButton = new Button(By.xpath("//*[@class=\"inline-block w-[18px] h-[18px] mr-[8px] cursor-pointer\"]"));
    public Button deleteHabitButton = new Button(By.xpath("//span[text()=\"Delete\"]"));
    public Button deleteHabitConfirmationButton = new Button(By.xpath("//Button[text()=\"Delete\"]"));

    public Button archiveHabitButton = new Button(By.xpath("//span[text()=\"Archive\"]"));

    public Button archivedHabitsViewButton = new Button(By.xpath("//div[text()=\"Archived\"]"));

    public Button searchHabitByName(String habitName)
    {
        return new Button(By.xpath("//p[@class='ml-[8px] flex-auto text-sm text-grey leading-[20px] truncate' and text()='"+habitName+"']"));
    }


}
