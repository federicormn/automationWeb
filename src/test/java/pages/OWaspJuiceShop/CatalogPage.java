package pages.OWaspJuiceShop;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class CatalogPage
{
    public Button accountButton = new Button(By.id("navbarAccount"));
    public Button loginButton = new Button(By.id("navbarLoginButton"));
    public Button shoppingCartButton = new Button(By.xpath("//button[@aria-label=\"Show the shopping cart\"]"));
    public Button logOutButton = new Button(By.id("navbarLogoutButton"));

}
