package pages.todo.Ly;

import controlSelenium.Button;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class ProjectsList
{
    public Button addNewProjectButton = new Button(By.xpath("//td[text()='Add New Project']"));
    public TextBox newProjectNameTextBox = new TextBox(By.id("NewProjNameInput"));
    public Button addConfirmationButton = new Button(By.id("NewProjNameButton"));
    public Label mainProjectsList = new Label(By.id("mainProjectList"));

}
