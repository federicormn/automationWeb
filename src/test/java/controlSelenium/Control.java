package controlSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import singletonSession.Session;

import java.time.Duration;

public class Control
{
    protected By locator;
    protected WebElement control;

    public Control(By locator)
    {
        this.locator = locator;
    }

    protected void findControl()
    {
        control = Session.getInstance().getBrowser().findElement(this.locator);
        //explicit wait/s (clickable/visible/isDisplaye)
    }

    public void click()
    {
        this.findControl();
        control.click();
    }

    public boolean isControlDisplayed()
    {
        try {
            this.findControl();
            return control.isDisplayed();
        }catch(Exception e)
        {
            return false;
        }
    }

    public String getText()
    {
        this.findControl();
        return control.getText();
    }

    public String getAttribute(String attribute)
    {
        this.findControl();
        return this.control.getAttribute(attribute);
    }

    public void waitClickable()
    {
        // todo --> factory para instanciar el wait una sola vez
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(this.locator));
    }

    public void waitPresenceOfElement()
    {
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(this.locator));
    }

    public void waitTextToBePresent(String value)
    {
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(this.locator, value));
    }

    public void waitAttributeToBe(String attribute, String value)
    {
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(this.locator, attribute, value));
    }



}
