package controlSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TextBox extends Control
{

    public TextBox(By locator)
    {
        super(locator);
    }

    public void setText(String value)
    {
        this.findControl();
        this.control.clear();
        this.control.sendKeys(value);
    }

    public void setTextWithEnter(String value)
    {
        this.findControl();
        this.control.clear();
        this.control.sendKeys(value + Keys.ENTER);
    }

    public void clearTextBox()
    {
        this.findControl();
        this.control.clear();
    }
    //IMPLEMENT "clearAll" for an array of textboxes

}
