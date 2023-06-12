package amazonPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import actionTemplates.ActionDefination;

import io.qameta.allure.Step;

public class AmazonHomePage extends ActionDefination{
	ActionDefination obj = new ActionDefination();
	WebDriver driver;
	By PRODUCT_SEARCH_BOX = By.xpath("//input[@id='twotabsearchtextbox']");
	By SUBMIT_SEARCH_BUTTON =By.xpath("//span[@id='nav-search-submit-text']");
	
	
	
	public WebElement productSearchBox(WebDriver driver) {
		obj.waitUntillElementLoaded(driver, PRODUCT_SEARCH_BOX);
		return obj.getElement(driver, PRODUCT_SEARCH_BOX);

	}
	

	public WebElement submitSearchButton(WebDriver driver) {
		obj.waitUntillElementLoaded(driver, SUBMIT_SEARCH_BUTTON);
		return obj.getElement(driver, SUBMIT_SEARCH_BUTTON);

	}
	
	@Step
	public AmazonProductListingPage searchProduct(WebDriver driver,String product_Name) {
		productSearchBox(driver).click();
		productSearchBox(driver).sendKeys(product_Name);
		submitSearchButton(driver).click();
		return new AmazonProductListingPage();
		
	}

}
