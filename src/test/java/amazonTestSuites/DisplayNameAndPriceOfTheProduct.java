package amazonTestSuites;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import amazonPageObjects.AmazonHomePage;
import amazonPageObjects.AmazonProductListingPage;

import utilities.ConfigurationClass;

public class DisplayNameAndPriceOfTheProduct extends ConfigurationClass {

	private static final Logger logger = LogManager.getLogger(DisplayNameAndPriceOfTheProduct.class);
	Properties prop = propertyLoader();// initialize prop object.
	WebDriver driver = invokeSeleniumSetUp();
	AmazonHomePage homepageObj = new AmazonHomePage();
	AmazonProductListingPage plpObj = new AmazonProductListingPage();

	private String AMAZON_URL = prop.getProperty("amazon.url");
	private String PRODUCT_NAME = prop.getProperty("product.name.amazon");

	By ALL_PRODUCT_NAME = By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']");
	By ALL_PRODUCT_PRICE = By.xpath("//span[@class='a-price-whole']");

	@BeforeClass
	public void landAmazonHomepageTest() {

		homepageObj.navigateToWebsite(driver, AMAZON_URL);
		logger.info("amazon url is opening");

	}

	@Test
	public void getProductNamesALongWithPrices() {

		homepageObj.searchProduct(driver, PRODUCT_NAME);

		nameAndPrice();

	}

	public void nameAndPrice() {
		homepageObj.waitUntillElementLoaded(driver, ALL_PRODUCT_NAME);

		List<WebElement> names = homepageObj.getElements(driver, ALL_PRODUCT_NAME);

		int totalMobile = names.size();
		System.out.println("total no of mobile available = " + totalMobile);

		List<WebElement> prices = homepageObj.getElements(driver, ALL_PRODUCT_PRICE);
		try {
			for (int i = 0; i < totalMobile; i++) {
				Map<String, String> features = new HashMap<String, String>();
				String name = names.get(i).getText();
				String price = prices.get(i).getText();

				features.put(name, price);

				for (Map.Entry m : features.entrySet()) {
					logger.info("MOBILE_NAME : " + m.getKey());
					logger.info("PRICE : " + m.getValue());

				}
			}
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
}
