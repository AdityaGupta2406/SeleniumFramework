package amazonPageObjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import actionTemplates.ActionDefination;
import io.qameta.allure.Step;

public class AmazonProductListingPage extends ActionDefination {
	ActionDefination obj = new ActionDefination();
	WebDriver driver;
	By FIRST_PRODUCT = By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]//parent::a");

	public WebElement anyFirstProduct(WebDriver driver) {
		obj.waitUntillElementLoaded(driver, FIRST_PRODUCT);
		return obj.getElement(driver, FIRST_PRODUCT);

	}

	@Step
	public ProductDetailPage clickAnyFirstProduct(WebDriver driver) {
		anyFirstProduct(driver).click();
		return new ProductDetailPage();
	}

}
