package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtility {

    public static Actions actions;

    public static void mouseHover(WebDriver driver, WebElement element){
        actions = new Actions(driver);
        actions.moveToElement(element)
                .perform();
    }

    public static void doubleClick(WebDriver driver, WebElement element){
        actions = new Actions(driver);
        actions.contextClick(element)
                .perform();
    }

    public static void dragAndDropElement(WebDriver driver, WebElement element1, WebElement element2){
        actions = new Actions(driver);
        actions.dragAndDrop(element1, element2)
                .perform();
    }
}
