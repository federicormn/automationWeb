package basicSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest
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

    // TESTS
    @Test
    public void loginTodoLyTest() throws InterruptedException {

        //Click en el boton login (main page)
        driver.findElement(By.xpath("//img[@src='/Images/design/pagelogin.png']")).click();
        //Set email
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("selenium@selenium2022.com");
        //Set pwd
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        //click login
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

        Thread.sleep(2000);
        //verificacion --> SIEMPRE TIENE QUE ESTAR

        Assertions.assertTrue(driver.findElement(By.xpath("//a[text()='Logout']")).isDisplayed(),"ERROR");



//        click boton login --> //img[@src='/Images/design/pagelogin.png']
//                email ---> ctl00_MainContent_LoginControl1_TextBoxEmail
//        pwd ---> ctl00_MainContent_LoginControl1_TextBoxPassword
//        login --> ctl00_MainContent_LoginControl1_ButtonLogin
//
//        logout --> //a[text()='Logout']   ---> Assertions
//
//        selenium@selenium2022.com
//        12345

    }
}
