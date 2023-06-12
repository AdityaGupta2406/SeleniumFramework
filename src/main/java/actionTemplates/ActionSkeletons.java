package actionTemplates;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public interface ActionSkeletons {

	public WebElement getElement(WebDriver driver, By element);
	public void waitFor(int seconds);

	public void waitUntillElementLoaded(WebDriver driver, By element);

	public void clickOnWebElement(WebDriver driver, By element);

	public void insertInput(WebDriver driver, By element, String text);

	public Select selectFromDropDown(WebDriver driver, By element);

	public void clearInputFromTextBox(WebDriver driver, By element);

	public String extractTextFromWeb(WebDriver driver, By element);

	public void navigateToWebsite(WebDriver driver, String url);

}
