package factory;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DataProvider {

	public static ExcelDataProvider getExcel() throws IOException {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel;

	}

	public static ConfigDataProvider getConfigData() throws FileNotFoundException, IOException {
		ConfigDataProvider configg = new ConfigDataProvider();
		return configg;
	}

}
