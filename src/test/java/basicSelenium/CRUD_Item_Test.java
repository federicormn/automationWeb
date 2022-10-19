package basicSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

public class CRUD_Item_Test
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
    public void crudItemTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        //LOGIN
        String userMail = "fhr@fhr.com";
        String password = "12345";

        driver.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys(userMail);
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys(password);
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

        Assertions.assertTrue(driver.findElement(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).isDisplayed(), "ERROR, login not resolved.");

        //CREATING A NEW PROJECT

        String randomTime = ""+ new Date().getTime();
        String nameProj="AUTO"+ randomTime;
        String itemName = randomTime;
        String editedItemName = "EDIT " + randomTime;

        driver.findElement(By.xpath("//td[text()='Add New Project']")).click();
        driver.findElement(By.id("NewProjNameInput")).sendKeys(nameProj);
        driver.findElement(By.id("NewProjNameButton")).click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//li[last()]//td[text()='"+nameProj+"']"),nameProj));
        String actualResult= driver.findElement(By.xpath("//li[last()]//td[text()='"+nameProj+"']")).getText();
        String expectedResult = nameProj;

        Assertions.assertEquals(expectedResult,actualResult,"Error, project not created.");
        //Assertions.assertEquals(driver.findElement(By.xpath("//div[@id=\"CurrentProjectTitle\"]")).getAttribute("textContent"), nameProj, "Project created is not in focus.");

        //CREATING ITEM INSIDE PROJECT
        driver.findElement(By.id("NewItemContentInput")).sendKeys(itemName + Keys.ENTER);

        //EDITING ITEM

        wait.until(textToBePresentInElementLocated(By.xpath("//ul[@id=\"mainItemList\"]/li[last()]//div[@class=\"ItemContentDiv\"]"), randomTime));
        driver.findElement(By.xpath("//ul[@id=\"mainItemList\"]/li[last()]//div[@class=\"ItemContentDiv\"]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='ItemEditTextbox']")));
        driver.findElement(By.xpath("//textarea[@id='ItemEditTextbox']")).clear();
        driver.findElement(By.xpath("//textarea[@id='ItemEditTextbox']")).sendKeys(editedItemName + Keys.ENTER);

        Assertions.assertNotEquals(itemName, editedItemName, "Error, item not edited.");

        //DELETING PROJECT
        driver.findElement(By.xpath("//img[@style= \"display: inline;\"]")).click();
        driver.findElement(By.xpath("//ul[@id=\"itemContextMenu\"]//a[@href=\"#delete\"]")).click();

        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id=\"mainItemList\"]/li[last()]//div[@class=\"ItemContentDiv\"]"))));
        // [ISEMPTY?] --> Assertions.assertFalse(driver.findElement(By.xpath("//ul[@id=\"mainItemList\"]/li[last()]//div[@class=\"ItemContentDiv\"]")).isDisplayed(), "Error, Item was not deleted.");

        Assertions.assertTrue(driver.findElement(By.id("InfoMessageText")).isDisplayed());
        Thread.sleep(10000);

    }
}
