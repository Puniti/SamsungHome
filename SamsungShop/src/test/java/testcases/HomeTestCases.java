package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import factory.browserFactory;
import pages.HomePart1;
import utility.BaseClass;

public class HomeTestCases {
	WebDriver driver;
	browserFactory fact;
	HomePart1 home;
	
	
	
	@BeforeClass
    public void setSession() {
      fact= new browserFactory(driver);
      driver=fact.GetSession("chrome", "https://www.samsung.com ");
      home= PageFactory.initElements(driver, HomePart1.class);
      
	}

	
// test method to verify page title
	@Test(priority = 0)
	public void VerifyPage() {
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Samsung India | Mobile | TV | Home Appliances"));

	}
// test method to verify click function of logo
	@Test(priority = 1)
	public void LogoTest() {
		home.TestLogoVisibility();
		Assert.assertTrue(home.TestClickableLogo());
		Assert.assertTrue(home.TestLogoText());
	}

	//test method to check the options under first tab
	@Test(priority = 2)
	public void Link() {
		home.TestMobileLinks(home.getMobileLinks(), home.getMobile());
		home.TestMobileLinks(home.getTVLinks(), home.getTV());
		home.TestMobileLinks(home.getApplianceLinks(), home.getAppliance());
		home.TestMobileLinks(home.getComputingLink(), home.getComputing());
		home.TestMobileLinks(home.getSupportLink(), home.getSupport());
		home.TestMobileLinks(home.getLoginLink(), home.getLogin());
	}
	
	// Test method to test slide images
	@Test(priority=3)
	public void Home1Test() throws InterruptedException
	{
		home.TestHome1();
		
	}
	//Test method to test Discover part 
	@Test (priority=4)
	public void DiscoverTest() throws InterruptedException
	{
		home.TestDiscover();
		
	}
	

}
