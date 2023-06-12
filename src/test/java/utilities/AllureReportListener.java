package utilities;



import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureReportListener extends ConfigurationClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
}

	public void onTestFailure(ITestResult result) {

		

		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		allureScreenshots(driver);
	}

	public void onTestSkipped(ITestResult result) {
}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
}

	public void onTestFailedWithTimeout(ITestResult result) {
}

	public void onStart(ITestContext context) {
}

	public void onFinish(ITestContext context) {
}
	

}
