package testclasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.OnboardingPage;
import testbase.WebTestBase;

public class OnboardingTest extends WebTestBase {

    public HomePage homePage;
    public OnboardingPage onboardingPage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;

    public OnboardingTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();
        homePage = new HomePage(driver);
        onboardingPage = new OnboardingPage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);

    }

    @Test(description = "Verify user able to create a new account using valid credential")
    public void verifyAccountCreationWithValidCredentials() throws InterruptedException {
        SoftAssert soft = new SoftAssert();

        homePage.clickOnAcceptCookies();
        homePage.clickOnCloseAd();
        homePage.clickOnUserLogo();
        onboardingPage.clickOnCreateAccountLink();

        onboardingPage.createNewAccount(
                prop.getProperty("firstName"),
                prop.getProperty("lastName"),
                prop.getProperty("email"),
                prop.getProperty("createPassword"),
                prop.getProperty("confirmPassword")
        );
        onboardingPage.clickOnCheckMark();
        onboardingPage.clickOnRegisterButton();
        Thread.sleep(5000);
        homePage.clickOnUserLogo();
        soft.assertEquals(myAccountPage.getTextOfMyProfile(), "MY PROFILE" ,"MY PROFILE text should be matched");
        soft.assertAll();
    }

    @Test(description = "Verify user logout successfully")
    public void verifyUserLogOut(){
        SoftAssert soft = new SoftAssert();
        homePage.clickOnAcceptCookies();
        homePage.clickOnCloseAd();
        homePage.clickOnUserLogo();
        loginPage.setLogin(prop.getProperty("username"), prop.getProperty("password"));
        homePage.clickOnUserLogo();
        myAccountPage.clickOnLogOutBtn();
        soft.assertTrue(homePage.isLogInVisible(),"User redirected to the Login Page");
        soft.assertAll();
    }


    @Test(description = "Verify user not able to create account using invalid emailId")
    public void verifyNoAccountCreationWithInvalidEmail() {
        SoftAssert soft = new SoftAssert();

        homePage.clickOnAcceptCookies();
        homePage.clickOnCloseAd();
        homePage.clickOnUserLogo();
        onboardingPage.clickOnCreateAccountLink();

        onboardingPage.createNewAccount(
                prop.getProperty("firstName"),
                prop.getProperty("lastName"),
                prop.getProperty("username1"),
                prop.getProperty("createPassword"),
                prop.getProperty("confirmPassword")
        );
        onboardingPage.clickOnCheckMark();
        onboardingPage.clickOnRegisterButton();
        soft.assertEquals(onboardingPage.getInvalidEmailInputError(), "Please enter a valid email address" ,"Invalid Email address error should be displayed");
        soft.assertAll();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
