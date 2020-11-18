/**
 * 
 */
package dataProviders;

import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author madhubabu
 * @date 12-Mar-2020
 */
public class ExcelFileReader 
{
	static HashMap<String, String> exelReadHash;
	
	public static HashMap<String, String> readExcel(String xlFilePath, String sheetName) throws Exception
	{
		Workbook book = null;
		try {
			exelReadHash = new HashMap<String, String>();
			FileInputStream file = new FileInputStream(xlFilePath);
			book = WorkbookFactory.create(file);
			Sheet sheet = book.getSheet(sheetName);
			DataFormatter formatter = new DataFormatter();
			
			int rowcount = sheet.getLastRowNum() + 1;
			
			for (int i = 0; i < rowcount; i++) 
			{
				Row firstRow = sheet.getRow(i);
				String key = firstRow.getCell(0).toString();
				String value = formatter.formatCellValue(firstRow.getCell(1));
				exelReadHash.put(key, value);
			}
			
			System.out.println("Total Keys " + exelReadHash.size());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		book.close();
		
		return exelReadHash;
	}

	/**
	 * @param xlFilePath
	 * @param sheetName
	 * @param testDataIndex
	 * @return
	 */
	public static HashMap<String, String> readExcel(String xlFilePath, String sheetName, int testDataIndex) throws Exception
	{
		
		Workbook book = null;
		try {
			exelReadHash = new HashMap<String, String>();
			FileInputStream file = new FileInputStream(xlFilePath);
			book = WorkbookFactory.create(file);
			Sheet sheet = book.getSheet(sheetName);
			DataFormatter formatter = new DataFormatter();
			
			int rowcount = sheet.getLastRowNum() + 1;
			
			for (int i = 0; i < rowcount; i++) 
			{
				Row firstRow = sheet.getRow(i);
				String key = firstRow.getCell(0).toString();
				String value = formatter.formatCellValue(firstRow.getCell(testDataIndex));
				exelReadHash.put(key, value);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			book.close();
		}
		
		return exelReadHash;
	}

}
