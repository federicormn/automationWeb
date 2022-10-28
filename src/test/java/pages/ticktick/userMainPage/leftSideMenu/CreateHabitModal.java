package pages.ticktick.userMainPage.leftSideMenu;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class CreateHabitModal
{
    public TextBox dailyCheckInTextBox = new TextBox(By.xpath("//input[@placeholder=\"Daily Check-in\"]"));

    public Button frequencyButton = new Button(By.xpath("//div[text()=\"Daily\"]"));
    public Button sundayFrequencyButton = new Button(By.xpath("//div[text()=\"Su\"]"));
    public Button mondayFrequencyButton = new Button(By.xpath("//div[text()=\"Mo\"]"));
    public Button tuesdayFrequencyButton = new Button(By.xpath("//div[text()=\"Tu\"]"));
    public Button wednesdayFrequencyButton = new Button(By.xpath("//div[text()=\"We\"]"));
    public Button thursdayFrequencyButton = new Button(By.xpath("//div[text()=\"Th\"]"));
    public Button fridayFrequencyButton = new Button(By.xpath("//div[text()=\"Fr\"]"));
    public Button saturdayFrequencyButton = new Button(By.xpath("//div[text()=\"Sa\"]"));

    public Button frequencyOKButton = new Button(By.xpath("//button[text()=\"OK\"]"));
    public Button saveNewHabit = new Button(By.xpath("//button[text()=\"Save\"]"));

}
