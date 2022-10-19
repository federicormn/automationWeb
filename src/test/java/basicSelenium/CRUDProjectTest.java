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
import java.util.concurrent.TimeUnit;

public class CRUDProjectTest
{
    WebDriver driver;

    @BeforeEach
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://todo.ly/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterEach
    public void cleanup()
    {
        driver.quit();
    }

    @Test
    public void crudTest() throws InterruptedException
    {
        // click login
        driver.findElement(By.xpath("//img[@src='/Images/design/pagelogin.png']")).click();
        // set email
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("selenium@selenium2022.com");
        // set pwd
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        // click login
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        Thread.sleep(2000);
        Assertions.assertTrue(driver.findElement(By.xpath("//a[text()='Logout']")).isDisplayed(),
                "ERROR!! no se pudo iniciar sesion");

        /*
         * CREATE
         * */
        String nameProj="AUTO"+new Date().getTime();

        driver.findElement(By.xpath("//td[text()='Add New Project']")).click();
        driver.findElement(By.id("NewProjNameInput")).sendKeys(nameProj);
        driver.findElement(By.id("NewProjNameButton")).click();

        Thread.sleep(2000);
        String actualResult= driver.findElement(By.xpath("//li[last()]//td[text()='"+nameProj+"']")).getText();
        String expectedResult=nameProj;
        Assertions.assertEquals(expectedResult,actualResult,"ERROR no se creo el project");


        /*
         * UPDATE
         * */
        String newNameProj="UPDATE"+new Date().getTime();
        driver.findElement(By.xpath("//li[last()]//td[text()='"+nameProj+"']")).click();
        driver.findElement(By.xpath("//div[contains(@style,'block')]/img")).click();
        driver.findElement(By.xpath(" //ul[@id=\"projectContextMenu\"]//a[text()='Edit']")).click();
        driver.findElement(By.id("ItemEditTextbox")).clear();
        driver.findElement(By.id("ItemEditTextbox")).sendKeys(newNameProj);
        driver.findElement(By.xpath("//td/div[@id=\"ProjectEditDiv\"]/img[@id='ItemEditSubmit']")).click();
        Thread.sleep(2000);
        actualResult= driver.findElement(By.xpath("//li[last()]//td[text()='"+newNameProj+"']")).getText();
        expectedResult=newNameProj;
        Assertions.assertEquals(expectedResult,actualResult,"ERROR no se actualizo el project");

        /*
         * DELETE
         * */
        driver.findElement(By.xpath("//li[last()]//td[text()='"+newNameProj+"']")).click();
        driver.findElement(By.xpath("//div[contains(@style,'block')]/img")).click();
        driver.findElement(By.id("ProjShareMenuDel")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        actualResult= driver.findElement(By.xpath("//li[last()]//td")).getText();
        expectedResult=newNameProj;
        Assertions.assertNotEquals(expectedResult,actualResult,"ERROR no se elimino el project");
    }

    @Test
    public void createAndVerifyAccount() throws InterruptedException
    {
        //CREATION
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String mailName="mail"+new Date().getTime()+"@mail.com";
        String firstPassword = "12345";

        driver.findElement(By.xpath("//img[@src=\"/Images/design/pagesignup.png\"]")).click();
        driver.findElement(By.id("ctl00_MainContent_SignupControl1_TextBoxFullName")).sendKeys("Fede");
        driver.findElement(By.id("ctl00_MainContent_SignupControl1_TextBoxEmail")).sendKeys(mailName);
        driver.findElement(By.id("ctl00_MainContent_SignupControl1_TextBoxPassword")).sendKeys(firstPassword);
        driver.findElement(By.id("ctl00_MainContent_SignupControl1_CheckBoxTerms")).click();
        driver.findElement(By.id("ctl00_MainContent_SignupControl1_ButtonSignup")).click();

        Assertions.assertTrue(driver.findElement(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).isDisplayed(), "ERROR, account could not be created.");

        //PASSWORD MODIFICATION
        String newPassword = "1234";
        driver.findElement(By.xpath("//a[@href=\"javascript:OpenSettingsDialog();\"]")).click();
        Thread.sleep(1000);

        String currentMail = driver.findElement(By.id("EmailInput")).getAttribute("value");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("EmailInput")));

        driver.findElement(By.id("TextPwOld")).sendKeys(firstPassword);
        driver.findElement(By.id("TextPwNew")).sendKeys(newPassword);
        driver.findElement(By.xpath("//button[@class=\"ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only\"]//span")).click();
        Thread.sleep(1000);

        Assertions.assertFalse(driver.findElement(By.id("settings_tabs")).isDisplayed(),"ERROR, password not changed.");

        //LOGOUT - LOGIN
        driver.findElement(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).click();
        driver.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys(currentMail);
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys(newPassword);
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

        Assertions.assertTrue(driver.findElement(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).isDisplayed(), "ERROR, account could not be logged in with new password.");


    }

}
