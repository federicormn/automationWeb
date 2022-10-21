package controlSelenium;

import org.openqa.selenium.By;

public class Checkbox extends Control
{

    public Checkbox(By locator)
    {
        super(locator);
    }

    public void check()
    {
        this.findControl();

        if(!this.control.isSelected())
        {
            control.click();
        }
    }

    public void uncheck()
    {
        this.findControl();
        if(this.control.isSelected())
        {
            control.click();
        }
    }

}
