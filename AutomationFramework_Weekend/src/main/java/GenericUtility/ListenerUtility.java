package GenericUtility;

import javax.naming.spi.DirStateFactory.Result;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ListenerUtility extends BaseClass implements ITestListener {

	
	
	

	@Override
	public void onTestStart(ITestResult result) {
	test = extReport.createTest(result.getName());
	test.log(Status.INFO, "Test Execution started");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		String screenshot = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(screenshot);
		test.log(Status.FAIL, "Test Execution failed");

		try {
			wutil.getPhoto(driver);
		} catch (Exception e) {
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		try {
	wutil.getPhoto(driver);
}	 catch (Exception e) {
}
		
	}
	

	
}
