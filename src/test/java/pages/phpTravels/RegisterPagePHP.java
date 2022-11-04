package pages.phpTravels;

import controlSelenium.*;
import org.openqa.selenium.By;

public class RegisterPagePHP
{
    public TextBox firstNameTextBox = new TextBox (By.id("inputFirstName"),"[First Name] Textbox on registration page");
    public TextBox lastNameTextBox = new TextBox (By.id("inputLastName"),"[Last Name] Textbox on registration page");
    public TextBox emailTextBox = new TextBox (By.id("inputEmail"),"[Email Address] Textbox on registration page");
    public TextBox phoneNumberTextBox = new TextBox (By.id("inputPhone"),"[Phone Number] Textbox on registration page");

    public TextBox companyNameTextBox = new TextBox (By.id("inputCompanyName"),"[Company Name] Textbox on registration page");
    public TextBox streetAddressTextBox = new TextBox (By.id("inputAddress1"),"[Street Address] Textbox on registration page");
    public TextBox streetAddress2TextBox = new TextBox (By.id("inputAddress2"),"[Street Address 2] Textbox on registration page");
    public TextBox cityTextBox = new TextBox (By.id("inputCity"),"[City] Textbox on registration page");
    public TextBox stateTextBox = new TextBox (By.id("stateinput"),"[State] Textbox on registration page");
    public TextBox postcodeTextBox = new TextBox (By.id("inputPostcode"),"[State] Textbox on registration page");
    public TextBox countryListBox = new TextBox(By.id("inputCountry"),"[Country] Listbox on registration page");
    public Button argentinaOptionButton = new Button(By.xpath("//select/option[@value=\"AR\"]"),"[Argentina] Option on [Country] Listbox");
    //PASAR A METODO QUE BUSQUE CON UNA LISTA DE VALUES PARA LA ETIQUETA "OPTION"

    public TextBox mobileTextBox = new TextBox (By.id("customfield2"),"[Mobile Number] Textbox on registration page");
    public TextBox passwordTextBox = new TextBox (By.id("inputNewPassword1"),"[Password] Textbox on registration page");
    public TextBox confirmPasswordTextBox = new TextBox (By.id("inputNewPassword2"),"[Confirm Password] Textbox on registration page");
    public Button generatePasswordButton = new Button(By.xpath("//button[@class=\"btn btn-default btn-sm btn-sm-block generate-password\"]"), "[Generate Password] Button on registration page");

    public Button mailingListRadioButton = new Button(By.xpath("//span[@class=\"bootstrap-switch-handle-on bootstrap-switch-success\"]"),"[Mailing List] Radiobutton on registration page");

    public Control captchaFrame = new Control(By.xpath("//iframe[@title=\"reCAPTCHA\"]"), "captchaFrame");
    public Checkbox captchaCheckbox = new Checkbox(By.xpath("//div[@class=\"recaptcha-checkbox-border\"]"), "[Captcha] Button on registration page");
    public Button registerButton = new Button(By.xpath("//input[@class=\"btn btn-large btn-primary btn-recaptcha\"]"),"[Register] Button on registration page");

}
