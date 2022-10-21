package basicSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;

public class ChangeFullName
{

    WebDriver driver;

    @BeforeEach
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://todo.ly/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

    }

    @AfterEach
    public void cleanup()
    {
        driver.quit();
    }

    ////////////////////////////
    @Test
    public void changeFullName() throws InterruptedException
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        String randomDate = ""+ new Date().getTime();

        //LOGIN
        String userMail = "fhr@fhr.com";
        String password = "12345";

        driver.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys(userMail);
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys(password);
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

        Assertions.assertTrue(driver.findElement(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).isDisplayed(), "ERROR, login not resolved.");

        //ENTER SETTINGS
        driver.findElement(By.xpath("//a[@href=\"javascript:OpenSettingsDialog();\"]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("settings_tabs")));

        //Assertions.assertTrue(driver.findElement(By.id("settings_tabs")).isDisplayed(), "Error, Settings tab not opened.");

        //CHANGE FULL NAME
        wait.until(ExpectedConditions.elementToBeClickable(By.id("FullNameInput")));
        String currentName = driver.findElement(By.id("FullNameInput")).getAttribute("value");

        driver.findElement(By.id("FullNameInput")).clear();
        driver.findElement(By.id("FullNameInput")).sendKeys(currentName + randomDate);
        driver.findElement(By.xpath("//button[@class=\"ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only\"]//span")).click();

        //VERIFY CHANGE
        driver.findElement(By.xpath("//a[@href=\"javascript:OpenSettingsDialog();\"]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("settings_tabs")));
        String newName = driver.findElement(By.id("FullNameInput")).getAttribute("value");

        Assertions.assertNotEquals(currentName, newName, "Error, Fullname was NOT changed.");
        Thread.sleep(5000);
    }
}
