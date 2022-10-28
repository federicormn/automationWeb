package cleanTest.ticktickTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.ticktick.*;
import pages.ticktick.ProfileSettings.AccountAndSecurity;
import pages.ticktick.ProfileSettings.CalendarAndMail;
import pages.ticktick.ProfileSettings.DeleteAccountPopUp;
import pages.ticktick.ProfileSettings.SettingsPage;
import pages.ticktick.UserMainPage.InboxPage;
import pages.ticktick.UserMainPage.ProfileOptionsMenu;
import singletonSession.Session;

public class TestBaseTickTick
{
    MainPageTickTick mainPageTickTick = new MainPageTickTick();
    RegistrationPage registrationPage = new RegistrationPage();
    InboxPage inboxPage = new InboxPage();
    SignInPage signInPage = new SignInPage();
    ProfileOptionsMenu profileOptionsMenu = new ProfileOptionsMenu();
    SettingsPage settingsPage = new SettingsPage();
    CalendarAndMail calendarAndMail = new CalendarAndMail();
    AccountAndSecurity accountAndSecurity = new AccountAndSecurity();
    DeleteAccountPopUp deleteAccountPopUp = new DeleteAccountPopUp();

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

}
