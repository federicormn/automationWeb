package cleanTest.phpTravels;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import singletonSession.Session;
import utils.GenericMethods;

public class PhpExercise extends TestBasePhpTravels
{
    GenericMethods genericMethods = new GenericMethods();


    @Test
    @Tag("PHP")
    public void registerAndLoginTest() throws InterruptedException
    {
        String testPassword = "123456";
        String testName = "Fede";
        String testEmail = genericMethods.getAlphaNumericString(4)+"@mail.com";
        String currentTab = Session.getInstance().getBrowser().getWindowHandle();

        mainPagePHP.signUpButton.click();
        //Session.getInstance().moveToTab("https://phptravels.org/register.php");
        Session.getInstance().switchTab(currentTab);

        registerPagePHP.firstNameTextBox.writeText(testName);
        registerPagePHP.lastNameTextBox.writeText(genericMethods.getAlphaNumericString(4));
        registerPagePHP.emailTextBox.writeText(testEmail);
        registerPagePHP.phoneNumberTextBox.writeText("12345678");

        registerPagePHP.companyNameTextBox.writeText(genericMethods.getAlphaNumericString(5));
        registerPagePHP.streetAddressTextBox.writeText(genericMethods.getAlphaNumericString(5)+" 123");
        registerPagePHP.streetAddress2TextBox.writeText(genericMethods.getAlphaNumericString(4)+" 123");
        registerPagePHP.cityTextBox.writeText(genericMethods.getAlphaNumericString(4));
        registerPagePHP.stateTextBox.writeText(genericMethods.getAlphaNumericString(4));
        registerPagePHP.postcodeTextBox.writeText("1234");
        registerPagePHP.countryListBox.click();
        registerPagePHP.argentinaOptionButton.waitClickable();
        registerPagePHP.argentinaOptionButton.click();


        registerPagePHP.mobileTextBox.writeText("123456789");

        registerPagePHP.passwordTextBox.writeText(testPassword);
        registerPagePHP.confirmPasswordTextBox.writeText(testPassword);

        //Session.getInstance().switchIFrameByIndex(0);
        Session.getInstance().switchIFrame(registerPagePHP.captchaFrame.getAttribute("name"));

        registerPagePHP.captchaCheckbox.waitVisibilityOfElement();
        registerPagePHP.captchaCheckbox.waitClickable();
        registerPagePHP.captchaCheckbox.check();
        Thread.sleep(8000);
        Session.getInstance().switchToDefault();
        registerPagePHP.registerButton.waitClickable();
        registerPagePHP.registerButton.click();

        //Session.getInstance().moveToTab("https://phptravels.com/demo/");
        Session.getInstance().closeTabAndReturnToCurrent(currentTab);

        mainPagePHP.loginButton.click();

        Session.getInstance().moveToTab("https://phptravels.org/clientarea.php");
        currentTab = Session.getInstance().getBrowser().getWindowHandle();
        Session.getInstance().switchTab(currentTab);

        userPage.accountSettingsButton.waitClickable();
        Assertions.assertTrue(userPage.accountSettingsButton.isControlDisplayed() && userPage.verifyIfNameExists(testName));

        userPage.accountSettingsButton.click();
        userPage.logoutButton.waitClickable();
        userPage.logoutButton.click();

        Assertions.assertTrue(loginPagePHP.loginButton.isControlDisplayed());
        Session.getInstance().closeTabAndReturnToCurrent(currentTab);

        userPage.accountSettingsButton.click();
        userPage.logoutButton.click();

        Thread.sleep(4000);


    }
}
