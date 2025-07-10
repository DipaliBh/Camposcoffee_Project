package testbase;

import constants.Browser;
import customexception.InvalidBrowserSelection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utility.WaitUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class WebTestBase {

    public WebDriver driver;
    public Properties prop;

    public WebTestBase(){

        FileInputStream fp = null;

        try {
            fp = new FileInputStream( System.getProperty("user.dir") + "/src/main/resources/properties/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        prop = new Properties();
        try {
            prop.load(fp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void initialization(){  // Used for driver initialization
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase(Browser.CHROME.toString())){
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase(Browser.EDGE.toString())) {
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase(Browser.FIREFOX.toString())) {
            driver = new FirefoxDriver();
        } else {
            throw new InvalidBrowserSelection("Please select correct browser");
        }

        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WaitUtility.PAGE_LOAD_TIMEOUT));
        driver.manage().deleteAllCookies();
    }
}
