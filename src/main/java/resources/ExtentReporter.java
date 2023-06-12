package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
static ExtentReports extent;
	
	public static ExtentReports getExtentReporterObject() {
		String path = System.getProperty("user.dir")+"\\\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Spice Jet Test cases");
		reporter.config().setDocumentTitle("Test Results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("IT ANALYST", "YASIN RAZA");
		return extent;
	}

}
