package testclasses;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.OnboardingPage;
import testbase.WebTestBase;


public class HomeTest extends WebTestBase
{

    public HomePage homePage;
    public OnboardingPage onboardingPage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;

    public HomeTest()

    {
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
    }

    @Test(description = "Verify Explore button is clickable")
    public void verifyUserLogo() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        homePage.clickOnAcceptCookies();
        homePage.clickOnCloseAd();
        homePage.clickOnUserLogo();
        boolean loginVisible = homePage.isLogInVisible();
        Assert.assertTrue(loginVisible, "'Log In' text is not visible after clicking user logo.");
        /*loginPage.setLogin(prop.getProperty("username"), prop.getProperty("password"));
        homePage.clickOnUserLogo();
        Thread.sleep(5000);
        myAccountPage.clickOnOrderHistory();
        soft.assertEquals(myAccountPage.getOrderHistory(), "ORDER HISTORY" ,"History of orders should be matched");
        soft.assertAll();*/
    }

    @AfterMethod
    public void tearDown()
    {
        if (driver != null) {
            driver.quit();
        }
    }
}
