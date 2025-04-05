package Books;

import java.io.IOException;

import org.apache.commons.codec.binary.Base16;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import GenericUtility.BaseClass;
import ObjectRepository.HomePage;

public class TC001_Books extends BaseClass {
	
	@Test
	public void ClickOnBooks() throws IOException {
		
		//step 4 & 5 of Extent report : Create extent test object & call log method
		
		ExtentTest test = extReport.createTest("clickOnBooks");
		HomePage hp = new HomePage(driver);
		hp.getClickOnBooks().click();
		
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Books", "Books page is not displayed");
		test.log(Status.PASS, "Books page is displayed");
		wutil.getPhoto(driver);

	
	}

}
