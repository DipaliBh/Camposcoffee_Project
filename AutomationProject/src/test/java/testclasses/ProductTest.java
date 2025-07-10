package testclasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.ProductPage;
import testbase.WebTestBase;

public class ProductTest extends WebTestBase {
    public HomePage homePage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;
    public ProductPage productPage;

    public ProductTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
        productPage = new ProductPage(driver);

    }

    @Test(description = "Verify search functionality for product 'superior'")
    public void verifyProduct() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        homePage.clickOnAcceptCookies();
        homePage.clickOnCloseAd();
        homePage.clickOnUserLogo();
        loginPage.setLogin(prop.getProperty("username"), prop.getProperty("password"));
        Thread.sleep(5000);
        productPage.clickOnSearchLogo();
        productPage.searchForProducts(prop.getProperty("productN"));
        soft.assertEquals(productPage.getSearchResultText(), "SEARCH RESULTS" ,"Search result message should be displayed");
        soft.assertAll();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
