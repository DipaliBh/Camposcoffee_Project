package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtility {

    public static Select select;

    public static void selectBy(WebDriver driver, WebElement element, String value){
        select = new Select(element);
        select.selectByValue(value);
    }

    public static void selectBy(WebDriver driver, WebElement element, int index){
        select = new Select(element);
        select.selectByIndex(index);
    }

    public static void selectByVisibleText(WebDriver driver, WebElement element, String text){
        select = new Select(element);
        select.selectByVisibleText(text);
    }
}
