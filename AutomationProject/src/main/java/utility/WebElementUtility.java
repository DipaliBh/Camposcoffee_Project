package utility;

import org.openqa.selenium.WebElement;

public class WebElementUtility {

    public static String getTextOfElement(WebElement element){
        return element.getText();
    }

    public static boolean elementDisplayed(WebElement element){
        return element.isDisplayed();
    }

    public static boolean elementSelected(WebElement element){
        return element.isSelected();
    }

    public static boolean elementEnabled(WebElement element){
        return element.isEnabled();
    }
}
