package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import factory.ExcelDataProvider;
import factory.browserFactory;
import pages.Login;

public class LoginTest {
	Login log;
	WebDriver driver;
	browserFactory  fact;
	
	@BeforeClass
    public void setSession() {
     
      driver=browserFactory.GetSession("chrome", "https://www.samsung.com ");
      log= PageFactory.initElements(driver, Login.class);
      
	}
	
	
	
	
  @Test (priority= 1 ,dataProvider="Logindata",dataProviderClass=ExcelDataProvider.class)
  public void Userlogin(String Uname, String Upassword, String name) {
	 
	  log= PageFactory.initElements(driver, Login.class);
	  log.login(Uname, Upassword);
	  System.out.println(name+ " has logged in.");
  }
  

  
  @AfterMethod
  public void tearDown()
  {
	  driver.quit();
	  
  }

}
