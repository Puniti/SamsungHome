package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class browserFactory {



	public static WebDriver GetSession(String browser, String Url) {
		WebDriver driver1;
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "./Drivers/chromedriver.exe");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.acceptInsecureCerts();
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--disable-notifications");
			opt.setAcceptInsecureCerts(true);
			opt.merge(cap);
			driver1 = new ChromeDriver(opt);

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "./Drivers/geckodriver.exe");
			driver1 = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("InternetExplorer")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "./Drivers/IEDriverServer.exe");
			driver1 = new InternetExplorerDriver();

		} else {
			System.out.println("Sorry we don't support this browser, hence launching default chrome broswer");

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "./Drivers/chromedriver.exe");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.acceptInsecureCerts();
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--disable-notifications");
			opt.setAcceptInsecureCerts(true);
			opt.merge(cap);
			driver1 = new ChromeDriver(opt);

		}
		driver1.manage().window().maximize();
		driver1.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver1.get(Url);
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver1;
	}
	
	
	public static void closeSession(WebDriver driver)
	{
		driver.quit();
	}
}
