package cleanTest.ticktickTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    public void resetUniqueEmailTest()
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

        if(!signInPage.verifyRedirectAfterPasswordChange(testEmail,firstPassword,accountAndSecurity.accountAndSecurityHeader))
        {
            settingsPage.doneButton.click();

            leftNavBar.profilePictureID.click();
            profileOptionsMenu.signOut.click();

            mainPageTickTick.signInButton.click();
            signInPage.login(testEmail, firstPassword);

        }

        Assertions.assertTrue(signInPage.incorrectCredentialsMsg.isControlDisplayed(),"Error, incorrect credentials msg was not displayed.");
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

        Assertions.assertTrue(signInPage.incorrectCredentialsMsg.isControlDisplayed() && !(leftNavBar.profilePictureID.isControlDisplayed()),"Error, incorrect credentials msg was not displayed.");

    }
    @Test
    public void createNewListTest() throws InterruptedException
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
    public void deleteListTest()
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

        tasksMenu.searchList(newListName).makeRightClickAction();
        tasksMenu.deleteListButton.waitClickable();
        tasksMenu.deleteListButton.click();

        tasksMenu.confirmationPopUpDeleteButton.click();
        tasksMenu.confirmationPopUpDeleteButton.waitInvisvilityofElement();

        tasksMenu.searchList(newListName).waitInvisvilityofElement();

        Assertions.assertFalse(tasksMenu.searchList(newListName).isControlDisplayed());
    }
    @Test
    public void createNewHabitTest() throws InterruptedException
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
    public void deleteHabitTest() throws InterruptedException
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

        habitMenu.searchHabitByName(newHabitName).makeRightClickAction();
        habitMenu.deleteHabitButton.waitClickable();
        habitMenu.deleteHabitButton.click();

        habitMenu.deleteHabitConfirmationButton.waitClickable();
        habitMenu.deleteHabitConfirmationButton.click();
        Assertions.assertFalse(habitMenu.searchHabitByName(newHabitName).isControlDisplayed());
    }
    @Test
    public void archiveCreatedHabit()
    {
        //Setting a random name for the habit
        String newHabitName = getAlphaNumericString(5);
//
//        //Click on Sign In button (on main page)
//        mainPageTickTick.signInButton.click();
//        //Sign in with an already created user
//        signInPage.login("fhr@fhr.com","123456");
//
//        //Expected result: Profile picture button is displayed (login was succesfully made).
//        Assertions.assertTrue(leftNavBar.profilePictureID.isControlDisplayed(), "Error, login was not possible.");

        ///////////
        registrationPage.registerNewAccount(mainPageTickTick.signUpButton);
        inboxPage.skipPopUpButton.click();
        Assertions.assertTrue(leftNavBar.profilePictureID.isControlDisplayed(), "Error, login was not possible.");

        //Going to "Habit" section
        leftNavBar.habitButton.click();

        //Settings values for the new habit
        habitMenu.createHabitButton.click();
        createHabitModal.dailyCheckInTextBox.writeText(newHabitName);
        createHabitModal.frequencyButton.click();
        createHabitModal.fridayFrequencyButton.click();
        createHabitModal.frequencyOKButton.click();
        //Confirming new habit creation
        createHabitModal.saveNewHabit.click();
        //Expected result: Habit name should be displayed on habits list
        habitMenu.searchHabitByName(newHabitName).waitVisibilityOfElement();
        Assertions.assertTrue(habitMenu.searchHabitByName(newHabitName).isControlDisplayed(), "Error, habit not created.");

        //Archiving habit
        habitMenu.searchHabitByName(newHabitName).makeRightClickAction();
        habitMenu.archiveHabitButton.waitClickable();
        habitMenu.archiveHabitButton.click();

        //Expected result: habit should not be visible in the main Habit list.
        Assertions.assertFalse(habitMenu.searchHabitByName(newHabitName).isControlDisplayed(),"Error, habit was not archived.");
        /////////

        habitMenu.archivedHabitsViewButton.click();
        //Expected result: habit should be visible in "Archived" section after archiving it from main list.
        habitMenu.searchHabitByName(newHabitName).waitVisibilityOfElement();
        Assertions.assertTrue(habitMenu.searchHabitByName(newHabitName).isControlDisplayed(),"Error, habit is not present in archived elements.");
    }

}
