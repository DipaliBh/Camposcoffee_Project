package testclasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import testbase.WebTestBase;

public class MyAccountTest extends WebTestBase {

    public HomePage homePage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;

    public MyAccountTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
    }

    @Test(description = "Verify history of orders is visible")
    public void verifyLoginWithValidCredential() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        homePage.clickOnAcceptCookies();
        homePage.clickOnCloseAd();
        homePage.clickOnUserLogo();
        loginPage.setLogin(prop.getProperty("username"), prop.getProperty("password"));
        homePage.clickOnUserLogo();
        Thread.sleep(5000);
        myAccountPage.clickOnOrderHistory();
        soft.assertEquals(myAccountPage.getOrderHistory(), "ORDER HISTORY" ,"History of orders should be matched");
        soft.assertAll();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
