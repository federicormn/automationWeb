package pages.ticktick;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class MainPageTickTick
{
    public Button signInButton = new Button(By.xpath("//div[@class=\"navRow_236y3 container\"]/ul//a[@href=\"/signin\"]"));
    public Button signUpButton = new Button(By.xpath("//div[@class=\"navRow_236y3 container\"]/ul//a[@href=\"/signup\"]"));


}
