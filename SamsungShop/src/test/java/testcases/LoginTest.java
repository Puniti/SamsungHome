package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.ExcelDataProvider;
import factory.browserFactory;
import pages.Login;

public class LoginTest extends BaseClass {
	Login log;
	browserFactory  fact;

  @Test (priority= 1 ,dataProvider="Logindata",dataProviderClass=ExcelDataProvider.class)
  public void Userlogin(String Uname, String Upassword, String name) {
	 
	  logger= report.createTest("Login test");
	  log= PageFactory.initElements(driver, Login.class);
	  logger.info("Login Object Created");
	 
	  log.login(Uname, Upassword);
	  System.out.println(name+ " has logged in.");
	  logger.pass("Login is successful");
	  logger.fail("Test failed");
	  
	  
  }
  

  @AfterMethod
  public void closeDriverWindow()
  {
	  driver.close();
  }
 

}
