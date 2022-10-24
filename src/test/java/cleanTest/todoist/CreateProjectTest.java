package cleanTest.todoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class CreateProjectTest extends TestBaseTodoist
{
    @Test
    public void createProject() throws InterruptedException {
        mainPageTodoist.logInButton.click();
        loginPage.login("fhr@fhr.com","todoistpassword123");
        homePage.addProjectButton.click();

        Assertions.assertTrue(addProjectModal.addProjectLabel.isControlDisplayed());

        String randomProjectName = "PROJECT " + new Date().getTime();
        addProjectModal.projectNameTextBox.setText(randomProjectName);
        addProjectModal.addProjectButton.click();
        Assertions.assertEquals(randomProjectName, leftSideMenu.lastProject.getAttribute("textContent"));

    }

    @Test
    public void editProjectTest() throws InterruptedException
    {
        mainPageTodoist.logInButton.click();
        loginPage.login("fhr@fhr.com","todoistpassword123");

        leftSideMenu.lastProjectActionsButton.click();
        projectActionsMenu.editProjectButton.click();

        String randomProjectNameUpdate = "UPDATE " + new Date().getTime();
        editProjectModal.editProjectNameTextBox.setText(randomProjectNameUpdate);
        Thread.sleep(3000);
        editProjectModal.saveEditButton.click();
        Thread.sleep(3000);
        Assertions.assertEquals(randomProjectNameUpdate, leftSideMenu.lastProject.getAttribute("textContent"));

    }

    @Test
    public void deleteProject()
    {
        mainPageTodoist.logInButton.click();
        loginPage.login("fhr@fhr.com","todoistpassword123");

        int projectCounterBefore = Integer.parseInt(leftSideMenu.projectList.getAttribute("childElementCount"));
        leftSideMenu.lastProjectActionsButton.click();
        projectActionsMenu.deleteProjectButton.click();
        deleteProjectWindow.confirmDeleteButton.click();
        leftSideMenu.lastProject.waitPresenceOfElement();
        int projectCounterAfter = Integer.parseInt(leftSideMenu.projectList.getAttribute("childElementCount"));

        Assertions.assertTrue(projectCounterBefore != projectCounterAfter);



    }
}
