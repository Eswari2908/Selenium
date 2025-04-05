package Books;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import GenericUtility.BaseClass;
import GenericUtility.JavaUtility;
import GenericUtility.ListenerUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository.HomePage;

@Listeners(ListenerUtility.class)
public class TC002_Computers extends BaseClass{
	
	@Test
	public void ClickOnComputers() throws IOException {
		
		ExtentTest test = extReport.createTest("ClickOnComputers");
		HomePage hp = new HomePage(driver);
		hp.getClickOnComputers().click();
		
		Assert.assertEquals(driver.getTitle(), "Demo Web. ", "Computer page is not displayed");
		test.log(Status.PASS, "Computer page is displayed");
		wutil.getPhoto(driver);
		
	}

}
