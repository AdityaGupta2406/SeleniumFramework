package amazonTestSuites;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazonPageObjects.AmazonHomePage;
import utilities.AllureReportListener;
import utilities.ConfigurationClass;

@Listeners(AllureReportListener.class)
public class Amazon_OrderPlacingJourneyTest extends ConfigurationClass {

	private static final Logger logger = LogManager.getLogger(Amazon_OrderPlacingJourneyTest.class);

	Properties prop = propertyLoader();// initialize prop object.
	WebDriver driver = invokeSeleniumSetUp();
	AmazonHomePage homepageObj = new AmazonHomePage();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	private String AMAZON_URL = prop.getProperty("amazon.url");
	private String PRODUCT_NAME = prop.getProperty("product.name.amazon");

	@BeforeClass
	public void landAmazonHomepageTest() {

		homepageObj.navigateToWebsite(driver, AMAZON_URL);
		logger.info("amazon url is opening");

	}

	@Test
	public void placeOrderInAmazonTest() {
		
		
		homepageObj
		.searchProduct(driver,PRODUCT_NAME)
		.clickAnyFirstProduct(driver)
		.getProductName(driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
}
