package unittestcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import factory.ConfigDataProvider;

public class ConfigFileTest {

	
	ConfigDataProvider config ;
	
	
	@Test
	public void testConfigFile() throws FileNotFoundException, IOException
	
	{
	config = new ConfigDataProvider();
	String str=	config.gettestConfigFile();
	Assert.assertEquals(str, "TestingConfigFile");
	
	}
}
