package unittestcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import factory.ExcelDataProvider;

public class DataProviderTest {
	
  @Test
  public void getStringData() throws IOException {
	  
	  ExcelDataProvider data= new ExcelDataProvider();
	 String value=  data.getStringData("Credentials", 0, 0);
	Assert.assertEquals(value, "chunmun.testing@gmail.com");
	System.out.println(value);
	  
  }
  
  
}
