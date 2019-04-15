package factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class ConfigDataProvider {

	Properties pro;

	public ConfigDataProvider() throws FileNotFoundException, IOException {
		pro = new Properties();
		pro.load(new FileInputStream(
				new File(System.getProperty("user.dir") + "./ConfigurationFile/config.properties")));
		}
	
	public String getConfigValue(String key)
	{
		return pro.getProperty(key);
	}
	
	

	public String getBrowser()
	{
		return pro.getProperty("browser");
	}
	
	public String getURL()
	{
		return pro.getProperty("StagingURL");
	}
	
	public String gettestConfigFile()
	{
		return pro.getProperty("testConfig");
	}
}
