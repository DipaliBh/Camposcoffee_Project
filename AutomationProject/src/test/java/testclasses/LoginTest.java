package testclasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import testbase.WebTestBase;

public class LoginTest extends WebTestBase {

    public HomePage homePage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;

    public LoginTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
    }

    @Test(description = "Verify login with valid username and valid password")
    public void verifyLoginWithValidCredential(){
        SoftAssert soft = new SoftAssert();
        homePage.clickOnAcceptCookies();
        homePage.clickOnCloseAd();
        homePage.clickOnUserLogo();
        loginPage.setLogin(prop.getProperty("username"), prop.getProperty("password"));
        homePage.clickOnUserLogo();
        soft.assertEquals(myAccountPage.getTextOfMyProfile(), "MY PROFILE" ,"MY PROFILE text should be matched");
        soft.assertAll();
    }

    @Test(description = "Verify login with valid username and invalid password")
    public void verifyLoginWithInValidPassword() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        homePage.clickOnAcceptCookies();
        homePage.clickOnCloseAd();
        homePage.clickOnUserLogo();
        loginPage.setLogin(prop.getProperty("username"), prop.getProperty("password1"));
        soft.assertEquals(loginPage.getAlert(), "Incorrect email or password. Please try again" ,"Error message should be displayed");
        soft.assertAll();
    }

    @Test(description = "Verify login with invalid username and valid password")
    public void verifyLoginWithInValidUsername() {
        SoftAssert soft = new SoftAssert();
        homePage.clickOnAcceptCookies();
        homePage.clickOnCloseAd();
        homePage.clickOnUserLogo();
        loginPage.setLogin(prop.getProperty("username1"), prop.getProperty("password"));
        soft.assertEquals(loginPage.getInvalidEmailError(), "Invalid email address" ,"Invalid email message should be displayed");
        soft.assertAll();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
