package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.WaitUtility;
import utility.WebElementUtility;

public class OnboardingPage {

    WebDriver driver;

    @FindBy(xpath = "//a[@class='register-text']")
    WebElement createAccountLink;

    @FindBy(xpath = "//input[@data-id='firstName']")
    WebElement fNameTextBox;

    @FindBy(xpath = "//input[@data-id='lastName']")
    WebElement lNameTextBox;

    @FindBy(xpath = "//input[@data-id='email']")
    WebElement eMailTextBox;

    @FindBy(xpath = "//input[@data-id='password']")
    WebElement createPasswordTextBox;

    @FindBy(xpath = "//input[@data-id='confirmPassword']")
    WebElement confirmPasswordTextBox;

    @FindBy(xpath = "//span[@class='checkmark']")
    WebElement checkMark;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement registerBtn;

    @FindBy(xpath = "//div[text()='Please enter a valid email address']")
    WebElement invalidEmailInput;

    public OnboardingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnCreateAccountLink(){
        WaitUtility.waitUntilElementToBeClickable(driver, createAccountLink);
    }

    public void createNewAccount(String firstName, String lastName, String emailId, String createPassword, String confirmPassword){
        WaitUtility.waitUntilElementToBeClickable(driver, fNameTextBox);
        fNameTextBox.sendKeys(firstName);
        WaitUtility.waitUntilElementToBeClickable(driver, lNameTextBox);
        lNameTextBox.sendKeys(lastName);
        WaitUtility.waitUntilElementToBeClickable(driver, eMailTextBox);
        eMailTextBox.sendKeys(emailId);
        WaitUtility.waitUntilElementToBeClickable(driver, createPasswordTextBox);
        createPasswordTextBox.sendKeys(createPassword);
        WaitUtility.waitUntilElementToBeClickable(driver, confirmPasswordTextBox);
        confirmPasswordTextBox.sendKeys(confirmPassword);
    }

    public void clickOnCheckMark(){
        WaitUtility.waitUntilElementToBeClickable(driver, checkMark);
    }

    public void clickOnRegisterButton(){
        WaitUtility.waitUntilElementToBeClickable(driver, registerBtn);
    }

    public String  getInvalidEmailInputError(){
        WaitUtility.waitUntilElementToBeVisible(driver, invalidEmailInput);

        return WebElementUtility.getTextOfElement(invalidEmailInput);
    }









}
