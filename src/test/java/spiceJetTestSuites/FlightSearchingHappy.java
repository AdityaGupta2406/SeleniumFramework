package spiceJetTestSuites;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;



import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import spiceJetObjects.SpicejetHomepage;
import utilities.AllureReportListener;
import utilities.ConfigurationClass;

@Listeners(AllureReportListener.class)
public class FlightSearchingHappy extends ConfigurationClass {
	private static final Logger logger = LogManager.getLogger(FlightSearchingHappy.class);
	Properties prop = propertyLoader();// initialize prop object.

	private String SPICEJET_URL = prop.getProperty("SpiceJet.Url");
	private String JOURNEY_MONTH = prop.getProperty("Journey.month");
	private String JOURNEY_DAY = prop.getProperty("Journey.day");

	WebDriver driver = invokeSeleniumSetUp();
	SpicejetHomepage homepageObj = new SpicejetHomepage();
	

	@BeforeClass
	public void landSpiceHomepage() throws Exception {
	
		homepageObj.navigateToWebsite(driver, SPICEJET_URL);
		logger.info("spice jet url is opening");
	}
 
	@Test
	public void searchFlightOnCurrentDateHappyPath() throws InterruptedException {

		homepageObj.destinationSelectBox(driver).click();
		logger.info("departure edit box clicked");

		homepageObj.selectDepartureCity(driver).click();
		logger.info("departure location selected");

		homepageObj.selectArrivalCity(driver).click();
		logger.info("arrival location selected");

		homepageObj.selectDateFromCalender(driver, JOURNEY_MONTH, JOURNEY_DAY);
		logger.info("journey date selected");

		homepageObj.searchFlights(driver).click();
		logger.info("searching flights");

		

	}

	@AfterTest
	public void closeBrower() {
		driver.close();
	}

}
