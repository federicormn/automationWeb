package basicSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Date;

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
    public void createProject() throws InterruptedException
    {
        //Click en el boton login (main page)
        driver.findElement(By.xpath("//img[@src='/Images/design/pagelogin.png']")).click();
        //Set email
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("fhr@fhr.com");
        //Set pwd
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        //click login
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

        Thread.sleep(2000);

        Assertions.assertTrue(driver.findElement(By.xpath("//a[text()='Logout']")).isDisplayed(),"ERROR");

        driver.findElement(By.cssSelector("#MainTable > tbody > tr > td.MainTableLeft > div:nth-child(6) > div > table > tbody > tr > td.ProjItemContent")).click();
        //driver.findElement(By.id("NewProjNameInput")).sendKeys("HOLIS");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"NewProjNameInput\"]")).sendKeys("HOLIS");
        driver.findElement(By.id("NewProjNameButton")).click();

        Assertions.assertTrue(driver.findElement(By.xpath("//li[last()]//td[text()='HOLIS']")).isDisplayed(), "ERROR, element not found.");

        driver.findElement(By.xpath("//li[last()]//td[text()='HOLIS']")).click();
        driver.findElement(By.xpath("//img[@src=\"/Images/dropdown.png\"]/parent::div[@style=\"display: block;\"]/img")).click();
        driver.findElement(By.cssSelector("#projectContextMenu > li.edit > a")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("ItemEditTextbox")).clear();
        driver.findElement(By.id("ItemEditTextbox")).sendKeys("HOLUS");
        driver.findElement(By.id("ItemEditSubmit")).click();

        Assertions.assertTrue(driver.findElement(By.xpath("//li[last()]//td[text()='HOLUS']")).isDisplayed(), "ERROR, element not found.");




        Thread.sleep(5000);
    }

    @Test
    public void createAndVerifyAccount() throws InterruptedException
    {
        //CREATION

        String mailName="mail"+new Date().getTime()+"@mail.com";
        String firstPassword = "12345";

        driver.findElement(By.cssSelector("#ctl00_MainContent_PanelNotAuth > div.HomePageTop2 > div.HPHeaderRight > div.HPHeaderSignup > a > img")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("ctl00_MainContent_SignupControl1_TextBoxFullName")).sendKeys("Fede");
        driver.findElement(By.id("ctl00_MainContent_SignupControl1_TextBoxEmail")).sendKeys(mailName);
        driver.findElement(By.id("ctl00_MainContent_SignupControl1_TextBoxPassword")).sendKeys(firstPassword);
        driver.findElement(By.id("ctl00_MainContent_SignupControl1_CheckBoxTerms")).click();
        driver.findElement(By.id("ctl00_MainContent_SignupControl1_ButtonSignup")).click();
        Thread.sleep(3000);
        Assertions.assertTrue(driver.findElement(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).isDisplayed(), "ERROR, account could not be created.");

        //PASSWORD MODIFICATION
        String newPassword = "1234";

        driver.findElement(By.xpath("//*[@id=\"ctl00_HeaderTopControl1_PanelHeaderButtons\"]/a[1]")).click();
        Thread.sleep(3000);

        //.getAttribute() se copia cualquier propiedad del elemento, en este caso el "value"
        String currentMail = driver.findElement(By.id("EmailInput")).getAttribute("value");

        driver.findElement(By.id("TextPwOld")).sendKeys(firstPassword);
        driver.findElement(By.id("TextPwNew")).sendKeys(newPassword);
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/button[1]/span")).click();
        Thread.sleep(3000);
        Assertions.assertFalse(driver.findElement(By.id("settings_tabs")).isDisplayed(),"ERROR, password not changed.");

        //LOGOUT - LOGIN
        driver.findElement(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).click();
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_PanelNotAuth\"]/div[2]/div[1]/div[2]/a/img")).click();
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys(currentMail);
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys(newPassword);
        Thread.sleep(3000);
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        Thread.sleep(3000);

        Assertions.assertTrue(driver.findElement(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).isDisplayed(), "ERROR, account could not be logged in with new password.");


    }
}
