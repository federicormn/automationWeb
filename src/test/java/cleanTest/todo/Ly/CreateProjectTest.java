package cleanTest.todo.Ly;

import cleanTest.todo.Ly.TestBaseTodoLy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class CreateProjectTest extends TestBaseTodoLy
{
    @Test
    public void createNewProject()
    {

        mainPage.loginButton.click();

        loginModal.login("fhr@fhr.com","12345");

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(), "Error, login could not be made.");

        int projectCounterBefore = Integer.parseInt(projectsList.mainProjectsList.getAttribute("childElementCount"));
        String randomProjectName ="AUTO"+new Date().getTime();

        projectsList.addNewProjectButton.click();
        projectsList.newProjectNameTextBox.waitClickable();
        projectsList.newProjectNameTextBox.setText(randomProjectName);
        projectsList.addConfirmationButton.click();

        projectsList.mainProjectsList.waitClickable();
        //System.out.println("Before: "+projectCounterBefore + " after: "+ projectCounterAfter);
        //Assertions.assertNotEquals(projectCounterBefore, projectCounterAfter);
        Assertions.assertTrue(projectCounterBefore == projectCounterBefore + 1, "Error.");

    }
}
