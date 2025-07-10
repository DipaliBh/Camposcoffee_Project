package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.WaitUtility;
import utility.WebElementUtility;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@data-id='inputUsername']")
    WebElement userNameTextbox;

    @FindBy(xpath = "//input[@data-id='inputPassword']")
    WebElement passwordTextbox;

    @FindBy(xpath = "//button[@class='login-button slds-button']")
    WebElement loginBtn;

    @FindBy(xpath = "//span[contains(text(),'Incorrect email or password')]")
    WebElement errorMsg;

    @FindBy(xpath = "//div[text()='Invalid email address']")
    WebElement invalidEmail;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setLogin(String userName, String password) {
        WaitUtility.waitUntilElementToBeClickable(driver, userNameTextbox);
        userNameTextbox.sendKeys(userName);
        WaitUtility.waitUntilElementToBeClickable(driver, passwordTextbox);
        passwordTextbox.sendKeys(password);
        WaitUtility.waitUntilElementToBeClickable(driver, loginBtn);
        loginBtn.click();
    }

    public String  getAlert(){
        WaitUtility.waitUntilElementToBeVisible(driver, errorMsg);

        return WebElementUtility.getTextOfElement(errorMsg);
    }

    public String  getInvalidEmailError(){
        WaitUtility.waitUntilElementToBeVisible(driver, invalidEmail);

        return WebElementUtility.getTextOfElement(invalidEmail);
    }
}
