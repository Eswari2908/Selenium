package Electronics;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import GenericUtility.BaseClass;
import GenericUtility.ListenerUtility;
import ObjectRepository.HomePage;

@Listeners(ListenerUtility.class)
public class TC003_Electronics extends BaseClass{
	
	@Test
	public void ClickOnElectronics() throws IOException {
		
		ExtentTest test = extReport.createTest("ClickOnElectronics");
		HomePage hp = new HomePage(driver);
		hp.getClickOnElectronics();
				
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop.", "Electronics page is not displayed");
		test.log(Status.PASS, "Electronics page is displayed");
		wutil.getPhoto(driver);
		
		
	}
	
	

}
