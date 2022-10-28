package cleanTest.ticktickTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.ticktick.*;
import pages.ticktick.profileSettings.AccountAndSecurity;
import pages.ticktick.profileSettings.CalendarAndMail;
import pages.ticktick.profileSettings.DeleteAccountPopUp;
import pages.ticktick.profileSettings.SettingsPage;
import pages.ticktick.userMainPage.InboxPage;
import pages.ticktick.userMainPage.LeftNavBar;
import pages.ticktick.userMainPage.ProfileOptionsMenu;
import pages.ticktick.userMainPage.leftSideMenu.CreateHabitModal;
import pages.ticktick.userMainPage.leftSideMenu.HabitMenu;
import pages.ticktick.userMainPage.leftSideMenu.TasksMenu;
import singletonSession.Session;

public class TestBaseTickTick
{
    MainPageTickTick mainPageTickTick = new MainPageTickTick();
    RegistrationPage registrationPage = new RegistrationPage();
    InboxPage inboxPage = new InboxPage();
    SignInPage signInPage = new SignInPage();
    LeftNavBar leftNavBar = new LeftNavBar();
    TasksMenu tasksMenu = new TasksMenu();
    HabitMenu habitMenu = new HabitMenu();
    ProfileOptionsMenu profileOptionsMenu = new ProfileOptionsMenu();
    SettingsPage settingsPage = new SettingsPage();
    CalendarAndMail calendarAndMail = new CalendarAndMail();
    AccountAndSecurity accountAndSecurity = new AccountAndSecurity();
    DeleteAccountPopUp deleteAccountPopUp = new DeleteAccountPopUp();

    CreateHabitModal createHabitModal = new CreateHabitModal();

    @BeforeEach
    public void setup()
    {
        // todo --> create properties file
        Session.getInstance().getBrowser().get("https://ticktick.com/");
    }

    @AfterEach
    public void cleanup()
    {
        Session.getInstance().closeBrowser();
    }

    static String getAlphaNumericString(int n)
    {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int)(AlphaNumericString.length() * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

}
