package amazonPageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import actionTemplates.ActionDefination;

import io.qameta.allure.Step;

public class ProductDetailPage {
	WebDriver driver;
	ActionDefination obj = new ActionDefination();
	private static final Logger logger = LogManager.getLogger(ProductDetailPage.class);
	By PRODUCT_NAME = By.xpath("//span[@id='productTitle']");
	
	
	public WebElement productName(WebDriver driver) {
		obj.waitUntillElementLoaded(driver, PRODUCT_NAME);
		return obj.getElement(driver, PRODUCT_NAME);
	}
	
	@Step
	public String getProductName(WebDriver driver) {
		logger.info(productName(driver).getText());
		return productName(driver).getText();
		
	}
}
