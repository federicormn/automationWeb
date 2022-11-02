package pages.todo.Ly;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class MainPage
{
    public Button loginButton= new Button(By.xpath("//img[@src='/Images/design/pagelogin.png']"),"[Login] button on main page");
    public Button signUpButton = new Button(By.xpath("//img[@src=\"/Images/design/pagesignup.png\"]"),"[Sign up] button on main page");
}
