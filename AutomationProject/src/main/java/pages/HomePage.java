package pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.WaitUtility;
import utility.WebElementUtility;

public class HomePage {

    WebDriver driver;

    @FindBy(id = "onetrust-accept-btn-handler")
    WebElement acceptAllCookies;

    @FindBy(xpath = "//button[@title='Close']")
    WebElement closeAd;

    @FindBy(xpath = "//img[@alt='user avatar']")
    WebElement userLogo;

    @FindBy(xpath = "//h1[text()='Log In']")
    WebElement logIn;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnAcceptCookies(){
        try {
            WaitUtility.waitUntilElementToBeClickable(driver, acceptAllCookies);
            acceptAllCookies.click();
        } catch (Exception ignored) {}
    }

    public void clickOnCloseAd(){
        try {
            WaitUtility.waitUntilElementToBeClickable(driver, closeAd);
            closeAd.click();
        } catch (Exception ignored) {}
    }

    public void clickOnUserLogo(){
        try {
            WaitUtility.waitUntilElementToBeClickable(driver, userLogo);
            userLogo.click(); // <== This was missing
        } catch (StaleElementReferenceException e){
            driver.navigate().refresh();
            WaitUtility.waitUntilElementToBeClickable(driver, userLogo);
            userLogo.click(); // <== This too
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean isLogInVisible(){
        try {
            WaitUtility.waitUntilElementToBeVisible(driver, logIn);
            return WebElementUtility.elementDisplayed(logIn);
        } catch (Exception e) {
            return false;
        }
    }
}
