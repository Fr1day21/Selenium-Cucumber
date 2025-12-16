package helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionHelper {
    private WebDriver driver;
    private Actions actions;


    //Constructor
    public ActionHelper(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    //Hover over element
    public void hoverOver(WebElement element){
        actions.moveToElement(element).click().perform();
    }

    //Hover and click
    public void hoverAndClick(WebElement element){
        actions.moveToElement(element).click().perform();
    }

    //Hover from one element to other element
    public void hoverFromTo(WebElement element, WebElement toElement){
        actions.moveToElement(element).moveToElement(toElement).perform();
    }

    //Scroll to element
    public void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //Scroll to bottom
    public void scrollToBottom(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }





}
