package pages;

import java.util.List;
import utility.Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class HomePart1 {

	WebDriver driver1;
	Helper help;

	public HomePart1(WebDriver driver) {
		this.driver1 = driver;
	}

	// Locators to be used in home page tests

	@FindBy(xpath = "//div[@class='s-nav-text' and text()='Galaxy S10+']")
	WebElement GalaxyS10;
	@FindBy(xpath = "//div[@class='s-nav-text' and text()='Galaxy M']")
	WebElement GalaxyM;
	@FindBy(xpath = "//div[@class='s-nav-text' and text()='Galaxy A']")
	WebElement GalaxyA;
	@FindBy(xpath = "//div[@class='s-nav-text' and text()='QLED TV']")
	WebElement QLED;
	@FindBy(xpath = "//div[@class='s-nav-text' and text()='Family Hub™']")
	WebElement FamilyHub;
	@FindBy(xpath = "//h2[text()='Discover the Galaxy']")
	WebElement DiscoverGalaxyText;
	@FindBy(xpath = "(//button[@type='button' and @class='ho-product-3column-group__btn-play js-video js-pop-btn'])[1]")
	WebElement S10Video;
	@FindBy(xpath = "//button[text()='Close']")
	WebElement S10CloseButton;

	@FindBy(xpath = "//a[@href='/in/']")
	WebElement samsungLogo;
	@FindBy(xpath = "(//a[@href='#' and text()='MOBILE'])[1]")
	WebElement Mobile1;
	@FindBy(xpath = "(//div[@class='gb-gnb__drop-desktop'])[1]//a")
	List<WebElement> MobileLinks;
	@FindBy(xpath = "(//a[@href='#' and text()='TV & AV'])[1]")
	WebElement TV1;
	@FindBy(xpath = "(//div[@class='gb-gnb__drop-colgroup'])[2]//a")
	List<WebElement> TVLinks;
	@FindBy(xpath = "(//a[@href='#' and text()='APPLIANCES'])[1]")
	WebElement Appliance1;
	@FindBy(xpath = "(//div[@class='gb-gnb__drop-colgroup'])[3]//a")
	List<WebElement> AppliancesLink;
	@FindBy(xpath = "(//a[@href='#' and text()='COMPUTING'])[1]")
	WebElement Computing1;
	@FindBy(xpath = "(//div[@class='gb-gnb__drop-colgroup'])[4]//a")
	List<WebElement> ComputingLink;
	@FindBy(xpath = "(//a[@href='#' and text()='SUPPORT'])[2]")
	WebElement Support1;
	@FindBy(xpath = "(//div[@class='gb-gnb__drop-colgroup'])[5]//a")
	List<WebElement> SupportLink;
	@FindBy(xpath = "//button[@type='button' and @title='Login']")
	WebElement LoginIcon;
	@FindBy(xpath = "(//div[@class='gb-gnb__drop-colgroup'])[6]//a")
	List<WebElement> LoginLink;

	// Methods

	// This method tests the logo visibility
	public void TestLogoVisibility() {
		Assert.assertTrue(samsungLogo.isDisplayed());

	}

	// This method will test click of Logo
	public boolean TestClickableLogo() {
		WebDriverWait wait = new WebDriverWait(driver1, 20);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(samsungLogo));
			samsungLogo.click();
			if (driver1.getTitle().equalsIgnoreCase("Samsung India | Mobile | TV | Home Appliances")) {
				return true;
			} 
			else {
				return false;
			    }
		     }

		catch (Exception e) {
			return false;
		}

	}

	// This method will the text of logo
	public boolean TestLogoText() {
		if (samsungLogo.getText().equals("Samsung")) {
			return true;

		} else {
			return false;
		}
	}
   // This method checks the display of Mobile tab
	public boolean TestMobileModule() {
		return (Mobile1.isDisplayed());
	}

	//Info retrieve methods 
	public List getMobileLinks() {
		return MobileLinks;
	}

	public List getTVLinks() {
		return TVLinks;
	}

	public List getApplianceLinks() {
		return AppliancesLink;
	}

	public List getComputingLink() {
		return ComputingLink;
	}

	public List getSupportLink() {
		return SupportLink;
	}

	public List getLoginLink() {
		return LoginLink;
	}

	public WebElement getMobile() {
		return Mobile1;
	}

	public WebElement getTV() {
		return TV1;
	}

	public WebElement getAppliance() {
		return Appliance1;
	}

	public WebElement getComputing() {
		return Computing1;
	}

	public WebElement getSupport() {
		return Support1;
	}

	public WebElement getLogin() {
		return LoginIcon;
	}

	// This method checks all options and highlights them 
	public void TestMobileLinks(List <WebElement> lst, WebElement ele) {
			Actions act = new Actions(driver1);
			JavascriptExecutor js = (JavascriptExecutor) driver1;
			for (WebElement webElement : lst) {
				act.moveToElement(ele).moveToElement(webElement).build().perform();
				js.executeScript("arguments[0].setAttribute('style', 'background: pink; border: 2px solid black;');",
						webElement);

			}
			}
		
		// this method will test the slideshow part of homepage
		public void TestHome1() throws InterruptedException
		{
			GalaxyS10.click();
			Thread.sleep(1000);
			Helper.GetScreenshot(driver1);
			GalaxyM.click();
			Thread.sleep(1000);
			Helper.GetScreenshot(driver1);
			GalaxyA.click();
			Thread.sleep(1000);
			Helper.GetScreenshot(driver1);
			QLED.click();
			Thread.sleep(1000);
			Helper.GetScreenshot(driver1);
			FamilyHub.click();
			Thread.sleep(1000);
			Helper.GetScreenshot(driver1);
			
		}
		
		//this method will test the "Test Discover" portion 		
		public void TestDiscover() throws InterruptedException
		{
			JavascriptExecutor js= (JavascriptExecutor)driver1;
			js.executeScript("arguments[0].setAttribute('style', 'background: pink; border: 2px solid black;');", DiscoverGalaxyText);
			S10Video.click();
			Thread.sleep(2000);
			Helper.GetScreenshot(driver1);
			WebDriverWait wait = new WebDriverWait(driver1,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Close']")));
			driver1.switchTo().defaultContent();
			S10CloseButton.click();
			
			
		}
		
	

}
