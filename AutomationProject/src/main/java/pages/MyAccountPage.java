package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.WaitUtility;
import utility.WebElementUtility;

public class MyAccountPage {

    WebDriver driver;

    @FindBy(xpath = "//h2[text()='My Profile']")
    WebElement myProfile;

    @FindBy(xpath = "//a[text()='Log Out']")
    WebElement logOutBtn;

    @FindBy(xpath = "//a[text()='Order History']")
    WebElement orderHistory;

    @FindBy(xpath = "//h2[text()='Order History']")
    WebElement historyList;


    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTextOfMyProfile() {
        WaitUtility.waitUntilElementToBeVisible(driver, myProfile);

        return WebElementUtility.getTextOfElement(myProfile);
    }

    public void clickOnLogOutBtn() {
        WaitUtility.waitUntilElementToBeClickable(driver, logOutBtn);
    }

    public void clickOnOrderHistory(){
        WaitUtility.waitUntilElementToBeClickable(driver, orderHistory);
    }

    public String  getOrderHistory(){
        WaitUtility.waitUntilElementToBeVisible(driver,historyList);

        return WebElementUtility.getTextOfElement(historyList);
    }



}

