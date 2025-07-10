package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility {

    public final static int PAGE_LOAD_TIMEOUT = 80;
    public final static int EXPLICIT_WAIT_TIMEOUT = 80;
    public static WebDriverWait wait;

    public static void waitUntilElementToBeClickable(WebDriver driver, WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void waitUntilElementToBeSelected(WebDriver driver, WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public static void waitUntilElementToBeVisible(WebDriver driver, WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
