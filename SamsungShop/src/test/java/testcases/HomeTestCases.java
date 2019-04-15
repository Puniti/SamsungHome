package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.HomePart1;

public class HomeTestCases extends BaseClass {
	
	HomePart1 home;
	
// test method to verify page title
	@Test(priority = 0)
	public void VerifyPage() {
		String title = driver.getTitle();
		AssertJUnit.assertTrue(title.contains("Samsung India | Mobile | TV | Home Appliances"));

	}
// test method to verify click function of logo
	@Test(priority = 1)
	public void LogoTest() {
		home = PageFactory.initElements(driver,HomePart1.class);
		home.TestLogoVisibility();
		AssertJUnit.assertTrue(home.TestClickableLogo());
		AssertJUnit.assertTrue(home.TestLogoText());
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
