package factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	XSSFWorkbook wb;

	public ExcelDataProvider() throws IOException {

		wb = new XSSFWorkbook(new FileInputStream(new File("./TestData/EmailInfo.xlsx")));

	}

	public ExcelDataProvider(String path) throws FileNotFoundException, IOException {
		wb = new XSSFWorkbook(new FileInputStream(new File(path)));
	}

	public String getStringData(String sheetName, int row, int col) {
		String str = wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
		return str;
	}

	public int getIntData(String sheetName, int row, int col) {
		int value = (int) wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
		return value;
	}

	public double getDoubleValue(String sheetName, int row, int col) {
		double value = wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
		return value;
	}

	@DataProvider(name = "Logindata")
	public Object[][] data() throws IOException {

		XSSFSheet sheet = wb.getSheet("Credentials");

		int Row = sheet.getPhysicalNumberOfRows(); // to get the number of rows
		int Col = sheet.getRow(0).getPhysicalNumberOfCells(); // to get the number of columns

		Object[][] obj = new Object[Row][Col];
		for (int i = 0; i < Row; i++) {
			for (int j = 0; j < Col; j++) {
				obj[i][j] = getStringData("Credentials",i,j);
			}
		}

		return obj;

	}

}