package spiceJetObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.WebDriverWait;

import actionTemplates.ActionDefination;
import io.qameta.allure.Step;

public class SpicejetHomepage extends ActionDefination {
	public static Logger logger = LogManager.getLogger(SpicejetHomepage.class.getName());
	ActionDefination obj = new ActionDefination();

	WebDriver driver;
	//WebDriverWait wait;
	// By = By.xpath("");
	By departureCityBox = By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']");
	By departureCity = By.xpath("//a[text()=' Aurangabad (IXU)']");

	By destinationCity = By.xpath("(//a[text()=' Durgapur (RDP)'])[2]");
	By currentDate = By
			.xpath(("(//a[text()='20'])[1]|//a[@class='ui-state-default ui-state-highlight ui-state-active']"));

	By search = By.xpath("//input[@name='ctl00$mainContent$btn_FindFlights']");

	By calenderMonths = By.xpath(
			"//div[@class='ui-datepicker-group ui-datepicker-group-first']//span[@class='ui-datepicker-month'] | //div[@class='ui-datepicker-group ui-datepicker-group-last']//span[@class='ui-datepicker-month']");

	By firstBlockDates = By
			.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//table//tbody/tr/td/a");
	By lastBlockDates = By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']//table//tbody/tr/td/a");
	By calenderNextPage = By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']");

	@Step
	public WebElement destinationSelectBox(WebDriver driver) {
		obj.waitUntillElementLoaded(driver, departureCityBox);
		return obj.getElement(driver, departureCityBox);

	}

	@Step
	public WebElement selectDepartureCity(WebDriver driver) {
		obj.waitUntillElementLoaded(driver, departureCity);
		return obj.getElement(driver, departureCity);

	}

	@Step
	public WebElement selectArrivalCity(WebDriver driver) {
		obj.waitUntillElementLoaded(driver, destinationCity);
		return obj.getElement(driver, destinationCity);

	}

	@Step
	public WebElement selectDateOfJourney(WebDriver driver) {
		obj.waitUntillElementLoaded(driver, currentDate);
		return obj.getElement(driver, currentDate);

	}

	@Step
	public WebElement searchFlights(WebDriver driver) {
		obj.waitUntillElementLoaded(driver, search);
		return obj.getElement(driver, search);

	}

	@Step
	public void selectDateFromCalender(WebDriver driver, String monthOfJourney, String dateOfJourney)
			throws InterruptedException {
		int i = 0;
		while (i < 8) {
			try {
				List<WebElement> months = driver.findElements(calenderMonths);

				String MONTH_BLOCK_FIRST = months.get(0).getText();
				String MONTH_BLOCK_LAST = months.get(1).getText();
				logger.info("month of current first block : " + MONTH_BLOCK_FIRST);
				logger.info("month of current last block : " + MONTH_BLOCK_LAST);

				if (MONTH_BLOCK_FIRST.equalsIgnoreCase(monthOfJourney)) {
					logger.info("found in 1st block");
					obj.waitUntillElementLoaded(driver, lastBlockDates);
					try {
						List<WebElement> dates = driver.findElements(firstBlockDates);

						for (WebElement date : dates) {
							String ALL_DATES = date.getText();
							logger.info("dates are : " + ALL_DATES);
							if (ALL_DATES.equalsIgnoreCase(dateOfJourney)) {
								date.click();

								break;
							}

						}
					} catch (ElementNotInteractableException e) {
						e.printStackTrace();
					}

				}

				if (MONTH_BLOCK_LAST.equalsIgnoreCase(monthOfJourney))

				{
					logger.info("found in 2nd block");
					obj.waitUntillElementLoaded(driver, lastBlockDates);
					List<WebElement> dates = driver.findElements(lastBlockDates);
					try {
						for (WebElement date : dates) {
							String ALL_DATES = date.getText();
							logger.info("dates are : " + ALL_DATES);
							if (ALL_DATES.equalsIgnoreCase(dateOfJourney)) {
								date.click();

								break;
							}

						}
					} catch (ElementNotInteractableException e) {
						e.printStackTrace();
					}

				} else if (driver.findElement(calenderNextPage).isDisplayed()) {

					driver.findElement(calenderNextPage).click();
				}
				i++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}