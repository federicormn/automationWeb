package basicSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CRUDProjectTest
{
    WebDriver driver;

    @BeforeEach
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://todo.ly/");

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

        driver.findElement(By.xpath("//img[@src=\"/Images/dropdown.png\"]/parent::div[@style=\"display: block;\"]/img")).click();
        driver.findElement(By.cssSelector("#projectContextMenu > li.edit > a")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("ItemEditTextbox")).sendKeys("HOLUS");
        driver.findElement(By.id("ItemEditSubmit")).click();

        Assertions.assertTrue(driver.findElement(By.xpath("//li[last()]//td[text()='HOLUS']")).isDisplayed(), "ERROR, element not found.");




        Thread.sleep(5000);
    }
}
