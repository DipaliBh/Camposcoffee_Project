package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.WaitUtility;
import utility.WebElementUtility;

public class ProductPage {

    WebDriver driver;

    @FindBy(xpath = "//img[@alt='search']")
    WebElement search;

    @FindBy(xpath = "//input[@class='search-input']")
    WebElement searchProducts;

    @FindBy(xpath = "//h2[text()='SEARCH RESULTS']")
    WebElement searchResult;

    @FindBy(xpath = "//img[@alt='Dark City']")
    WebElement darkCity;

    @FindBy(xpath = "//select[@name='Bag_size__c']")
    WebElement bagSize;

    @FindBy(xpath = "//select[@name='Grind__c']")
    WebElement grid;

    @FindBy(xpath = "//span[text()='Add to Cart']")
    WebElement addToCart;

    @FindBy(xpath = "//button[text()='Checkout Now']")
    WebElement checkOutNow;

    @FindBy(xpath = "//button[text()='Checkout']")
    WebElement checkOut;

    @FindBy(xpath = "//input[@name='phonenumber']")
    WebElement phoneNumber;

    @FindBy(xpath = "//button[@class='lwc-76nnmqsstjk slds-button slds-button_brand']")
    WebElement continueBooking;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnSearchLogo(){
        WaitUtility.waitUntilElementToBeClickable(driver, search);
    }

    public void searchForProducts(String prodName){
        WaitUtility.waitUntilElementToBeClickable(driver, searchProducts);

        WaitUtility.waitUntilElementToBeClickable(driver, searchProducts);
        searchProducts.sendKeys(prodName);
        searchProducts.sendKeys(Keys.ENTER);

    }

    public String  getSearchResultText(){
        WaitUtility.waitUntilElementToBeVisible(driver, searchResult);

        return WebElementUtility.getTextOfElement(searchResult);
    }
}
