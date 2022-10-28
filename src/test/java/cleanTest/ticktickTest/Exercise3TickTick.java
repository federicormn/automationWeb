package cleanTest.ticktickTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class Exercise3TickTick extends TestBaseTickTick
{
    @Test
    public void registerNewAccountTest()
    {
        registrationPage.registerNewAccount(mainPageTickTick.signUpButton);

        inboxPage.nextPopUpButton.waitClickable();

        Assertions.assertTrue(inboxPage.nextPopUpButton.isControlDisplayed());

    }

    @Test
    public void loginExistingAccountTest() throws InterruptedException
    {
        mainPageTickTick.signInButton.click();
        signInPage.login("fhr@fhr.com","123456");

        Assertions.assertTrue(leftNavBar.profilePictureID.isControlDisplayed());

    }

    @Test
    public void SignOutTest()
    {
        mainPageTickTick.signInButton.click();
        signInPage.login("fhr@fhr.com","123456");

        Assertions.assertTrue(leftNavBar.profilePictureID.isControlDisplayed());

        leftNavBar.profilePictureID.click();
        profileOptionsMenu.signOut.waitClickable();
        profileOptionsMenu.signOut.click();

        Assertions.assertTrue(mainPageTickTick.signInButton.isControlDisplayed());
    }

    @Test
    public void resetUniqueEmail()
    {
        mainPageTickTick.signInButton.click();
        signInPage.login("fhr@fhr.com","123456");

        Assertions.assertTrue(leftNavBar.profilePictureID.isControlDisplayed());

        leftNavBar.profilePictureID.click();
        profileOptionsMenu.settings.click();

        Assertions.assertTrue(settingsPage.settingsHeaderLabel.isControlDisplayed());

        settingsPage.calendarAndMailButton.click();

        calendarAndMail.currentUniqueEmail.waitClickable();
        String firstUniqueEmail = calendarAndMail.currentUniqueEmail.getAttribute("value");

        calendarAndMail.resetUniqueEmailButton.waitClickable();
        calendarAndMail.resetUniqueEmailButton.click();

        calendarAndMail.currentUniqueEmail.waitAttributeNotToBe("value",firstUniqueEmail);
        String changedUniqueEmail = calendarAndMail.currentUniqueEmail.getAttribute("value");

        Assertions.assertNotEquals(firstUniqueEmail, changedUniqueEmail);
    }

    @Test
    public void changePasswordTest()
    {
        String testEmail = registrationPage.getAlphaNumericString(5) + "@mail.com";
        String firstPassword = "123456";
        String newPassword = "1234567";

        registrationPage.registerNewAccountParam(mainPageTickTick.signUpButton, testEmail,firstPassword);

        Assertions.assertTrue(inboxPage.skipPopUpButton.isControlDisplayed());
        inboxPage.skipPopUpButton.click();

        leftNavBar.profilePictureID.click();
        profileOptionsMenu.settings.click();

        Assertions.assertTrue(settingsPage.settingsHeaderLabel.isControlDisplayed());

        settingsPage.accountAndSecurityButton.click();
        accountAndSecurity.changePasswordButton.waitClickable();
        accountAndSecurity.changePasswordButton.click();

        accountAndSecurity.currentPasswordTextBox.writeText(firstPassword);
        accountAndSecurity.newPasswordTextBox.writeText(newPassword);
        accountAndSecurity.saveNewPassword.waitClickable();
        accountAndSecurity.saveNewPassword.click();

        accountAndSecurity.saveNewPassword.waitInvisvilityofElement();
        accountAndSecurity.currentPasswordTextBox.waitInvisvilityofElement();
        accountAndSecurity.newPasswordTextBox.waitInvisvilityofElement();

        settingsPage.doneButton.click();

        leftNavBar.profilePictureID.click();
        profileOptionsMenu.signOut.click();

        mainPageTickTick.signInButton.click();
        signInPage.login(testEmail, firstPassword);

        Assertions.assertTrue(signInPage.incorrectCredentialsMsg.isControlDisplayed());

    }

    @Test
    public void deleteAccountTest()
    {
        String nickName = "Fede";
        String randomEmail = registrationPage.getAlphaNumericString(5) + "@mail.com";
        String firstPassword = "123456";

        mainPageTickTick.signUpButton.click();

        registrationPage.nickNameTextBox.waitPresenceOfElement();
        Assertions.assertTrue(registrationPage.nickNameTextBox.isControlDisplayed());

        registrationPage.nickNameTextBox.writeText(nickName);
        registrationPage.emailTextBox.writeText(randomEmail);
        registrationPage.passwordTextBox.writeText(firstPassword);
        registrationPage.signUpButton.click();

        inboxPage.nextPopUpButton.waitClickable();

        Assertions.assertTrue(inboxPage.nextPopUpButton.isControlDisplayed());

        inboxPage.skipPopUpButton.waitClickable();
        inboxPage.skipPopUpButton.click();

        leftNavBar.profilePictureID.click();
        profileOptionsMenu.settings.click();
        settingsPage.accountAndSecurityButton.click();
        accountAndSecurity.deleteAccountButton.click();

        deleteAccountPopUp.confirmCurrentPasswordTextBox.writeText(firstPassword);
        deleteAccountPopUp.awareDataRemovalCheckbox.check();
        deleteAccountPopUp.sureToDeleteCheckbox.check();
        deleteAccountPopUp.confirmDeleteButton.click();

        mainPageTickTick.signInButton.click();
        signInPage.login(randomEmail,firstPassword);

        Assertions.assertTrue(signInPage.incorrectCredentialsMsg.isControlDisplayed());

    }
    @Test
    public void createNewList() throws InterruptedException
    {
        String newListName = getAlphaNumericString(5);

        mainPageTickTick.signInButton.click();
        signInPage.login("fhr@fhr.com","123456");

        Assertions.assertTrue(leftNavBar.profilePictureID.isControlDisplayed());

        leftNavBar.tasksButton.click();
        tasksMenu.addListButton.click();
        tasksMenu.newListNameTextBox.writeText(newListName);
        tasksMenu.saveNewList.click();
        tasksMenu.saveNewList.waitInvisvilityofElement();

        tasksMenu.searchList(newListName).waitTextToBePresent(newListName);
        Assertions.assertTrue(tasksMenu.searchList(newListName).isControlDisplayed());

    }
    @Test
    public void createNewHabit() throws InterruptedException
    {
        String newHabitName = getAlphaNumericString(5);

        mainPageTickTick.signInButton.click();
        signInPage.login("fhr@fhr.com","123456");

        Assertions.assertTrue(leftNavBar.profilePictureID.isControlDisplayed());

        leftNavBar.habitButton.click();
        habitMenu.createHabitButton.click();
        createHabitModal.dailyCheckInTextBox.writeText(newHabitName);

        createHabitModal.frequencyButton.click();
        createHabitModal.fridayFrequencyButton.click();
        createHabitModal.frequencyOKButton.click();

        createHabitModal.saveNewHabit.click();

        Assertions.assertTrue(habitMenu.searchHabitByName(newHabitName).isControlDisplayed());
        Thread.sleep(1500);
    }
    @Test
    public void deleteHabit() throws InterruptedException {
        String newHabitName = getAlphaNumericString(5);

        mainPageTickTick.signInButton.click();
        signInPage.login("fhr@fhr.com","123456");

        Assertions.assertTrue(leftNavBar.profilePictureID.isControlDisplayed());

        leftNavBar.habitButton.click();
        habitMenu.createHabitButton.click();
        createHabitModal.dailyCheckInTextBox.writeText(newHabitName);

        createHabitModal.frequencyButton.click();
        createHabitModal.fridayFrequencyButton.click();
        createHabitModal.frequencyOKButton.click();

        createHabitModal.saveNewHabit.click();

        Assertions.assertTrue(habitMenu.searchHabitByName(newHabitName).isControlDisplayed());

        habitMenu.searchHabitByName(newHabitName).makeRightClickAction();
        habitMenu.deleteHabitButton.waitClickable();
        habitMenu.deleteHabitButton.click();

        habitMenu.deleteHabitConfirmationButton.waitClickable();
        habitMenu.deleteHabitConfirmationButton.click();
        Assertions.assertFalse(habitMenu.searchHabitByName(newHabitName).isControlDisplayed());
    }

}
