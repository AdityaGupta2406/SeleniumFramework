package actionTemplates;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionDefination implements ActionSkeletons {

	public void waitFor(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			throw new RuntimeException("TODO - Handle this exception better", e);
		}

	}

	public void waitUntillElementLoaded(WebDriver driver, By element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));

	}

	public void clickOnWebElement(WebDriver driver, By element) {
		waitUntillElementLoaded(driver, element);
		getElement(driver, element).click();

	}

	public void insertInput(WebDriver driver, By element, String text) {
		waitUntillElementLoaded(driver, element);

		getElement(driver, element).sendKeys(text);

	}

	public Select selectFromDropDown(WebDriver driver, By element) {
		waitUntillElementLoaded(driver, element);
		Select drpdown = new Select(getElement(driver, element));

		return drpdown;
	}

	public void clearInputFromTextBox(WebDriver driver, By element) {

		waitUntillElementLoaded(driver, element);
		getElement(driver, element).clear();
	}

	public String extractTextFromWeb(WebDriver driver, By element) {
		waitUntillElementLoaded(driver, element);
		String text = getElement(driver, element).getText();
		return text;
	}

	public void navigateToWebsite(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public WebElement getElement(WebDriver driver, By element) {

		WebElement elements = driver.findElement(element);
		return elements;

	}

	public List<WebElement> getElements(WebDriver driver, By element) {
		List<WebElement> elements = driver.findElements(element);
		return elements;

	}

}
