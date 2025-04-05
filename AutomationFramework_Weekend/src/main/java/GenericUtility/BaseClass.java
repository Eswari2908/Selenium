package GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.WelcomePage;

/**In Base class we use preconditions, postconditions
 * 
 * @BS - Report configuration (Extent report - only 1st 3 steps)
 * @BC - Open Browser
 * @BM - Login
 * @AM - Logout
 * @AC - Quit driver
 * @AS - Report backup (flush)
 *
 */
public class BaseClass {
	
	public static ExtentReports extReport;
	public static WebDriver driver;
	public static ExtentTest test;
	
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wutil = new WebDriverUtility();
	public FileUtility futil = new FileUtility();
	
	@BeforeSuite
	public void reportConfig() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_Reports/extentReport_" + jUtil.getSystemTime() + ".html");
		extReport = new ExtentReports();
		extReport.attachReporter(spark);
	}
	
	@BeforeClass
	public void openBrowser() throws IOException {
		driver = new ChromeDriver();
		wutil.maximize(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(futil.getDataFromProperty("url"));
	}
	
	@BeforeMethod
	public void login() throws IOException {
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.getEmailTxtfield().sendKeys(futil.getDataFromProperty("email"));
		lp.getPasswordTxtfield().sendKeys(futil.getDataFromProperty("password"));
		lp.getLoginBtn().click();
	}
	
	@AfterMethod	
	public void logout() {
		HomePage hp = new HomePage(driver);
		hp.getLogoutLink().click();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterSuite
	
	public void reportBackup() {
		extReport.flush();
	}

}
