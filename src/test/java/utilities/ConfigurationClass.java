package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;

public class ConfigurationClass {

	public Properties prop;

	public WebDriver invokeSeleniumSetUp() {
		WebDriver driver = null;
		// System.setProperty("webdriver.chrome.driver", "Y:\\chrome
		// 90\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		return driver;
	}

	public Properties propertyLoader() {

		{
			try {
				System.out.println(System.getProperty("user.dir"));
				FileReader reader = new FileReader(
						"C:\\Users\\hp\\MyWorkspace\\NewSeleniumFramework\\src\\main\\resources\\propertiesFiles\\DataLoader.properties");

				prop = new Properties();
				try {
					prop.load(reader);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}

		return prop;
	}

	public String getScreenshot(String testcaseName, WebDriver driver) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testcaseName + ".png";
		try {
			FileUtils.copyFile(source, new File(destinationFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return destinationFile;
	}

	@Attachment(type = "image/png")
	public byte[] allureScreenshots(WebDriver driver) {

		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
}
