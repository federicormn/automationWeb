package pages.OWaspJuiceShop;

import controlSelenium.Button;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;
import org.w3c.dom.Text;

import java.security.PublicKey;

public class UserRegistrationPage
{
    public Label RegistrationHeader = new Label(By.xpath("//h1[text()=\"User Registration\"]"));
    public TextBox newEmailTextBox = new TextBox(By.id("emailControl"));
    public TextBox newPasswordTextBox = new TextBox(By.id("passwordControl"));
    public TextBox repeatPasswordTextBox = new TextBox(By.id("repeatPasswordControl"));
    public Button passwordAdviceRadioButton = new Button(By.xpath("//span[@class=\"mat-slide-toggle-bar\"]"));

    public Label minimumCharactersSuggestionLabel = new Label(By.xpath("//span[@class=\"ng-tns-c128-15\" and text()=\"contains at least one lower character\"]"));
    public Button securityQuestionMenu = new Button(By.xpath("//mat-select[@aria-label=\"Selection list for the security question\"]"));

    public Button eldestSiblingOption = new Button(By.xpath("//span[@class=\"mat-option-text\" and contains(text(),'eldest')]"));

    public TextBox securityAnswerTextBox = new TextBox(By.id("securityAnswerControl"));
    public Button registerButton = new Button(By.xpath("//*[@id=\"registerButton\"]"));
    public Button registerButtonID = new Button(By.id("registerButton"));
}
