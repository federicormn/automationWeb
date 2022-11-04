package pages.phpTravels;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class MainPagePHP
{
    public Button signUpButton = new Button(By.xpath("//a[@class=\"jfHeader-menuListLink jfHeader-dynamicLink jfHeader-signup-action\"]"),"[Sign Up] Button on main page");
    public Button loginButton = new Button(By.xpath("//a[@class=\"jfHeader-menuListLink jfHeader-dynamicLink jfHeader-login-action\"]"), "[Login] Button on main page");

}
