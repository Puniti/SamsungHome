package testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import factory.ConfigDataProvider;
import factory.DataProvider;
import factory.browserFactory;

public class BaseClass {

	public WebDriver driver;
//	
//	public ExtentReports report;
//	
//	public ExtentTest logger;
	
	
	// This will generate reports for all the test methods in this test suite
//	
//	@BeforeSuite
//	public void SetUpTestSuit()
//	{
//		ExtentHtmlReporter  htmlReporter= new ExtentHtmlReporter(System.getProperties("user.dir"+"./Reports/samsung.html"));
//		report= new ExtentReports();
//		report.attachReporter(htmlReporter);
//	}

	@BeforeClass
	public void setSession() throws FileNotFoundException, IOException {

		driver = browserFactory.GetSession(DataProvider.getConfigData().getBrowser(),
				DataProvider.getConfigData().getURL());
		
		}
	
//	@AfterClass
//	public void TearDown()
//	{
//	 System.out.println("fghjj");
//		browserFactory.closeSession(driver);
//	}
	
//	@AfterMethod
//	public void FlushReports()
//	{
//		report.flush();  // This will add the reports of all methods
//	}
}
