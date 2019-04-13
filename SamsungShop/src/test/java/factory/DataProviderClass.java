package factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderClass {

	
	@DataProvider (name="Logindata")
	public Object[][] data() throws IOException{
		
		
		File src= new File("./TestData/EmailInfo.xlsx");
		FileInputStream fis= new FileInputStream(src);
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Credentials");
	
		int Row= sheet.getPhysicalNumberOfRows();   // to get the number of rows
		int Col= sheet.getRow(0).getPhysicalNumberOfCells();   //to  get the number of columns
		  
		Object[][] obj= new Object[Row][Col];
		for(int i=0; i<Row; i++)
		{
			for(int j=0;j<Col;j++)
			{
			obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
		
			
		}}
		
		
		return obj;
		
}
}