package cleanTest.demoQATest;

import org.junit.jupiter.api.Test;

public class ExercisesDemoQA extends TestBaseDemoQA
{
    @Test
    public void selectableTest()
    {
        mainPage.interactionsButton.waitClickable();
        mainPage.interactionsButton.waitPresenceOfElement();

        mainPage.interactionsButton.click();

        mainPage.selectableButton.waitClickable();
        mainPage.selectableButton.click();
    }
}
