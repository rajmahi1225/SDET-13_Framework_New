package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class contains methods for reading the data in excel-sheet
 * @author RAJ MAHI
 *
 */
public class ExcelUtility 
{
	/**
	 * This method is used to read the data from excel by specifying sheetName, rowNum, cellNum
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable 
	 */
	public String getExcelData(String sheetName, int rownum, int cellnum) throws Throwable
	{
		System.out.println("1");
		FileInputStream fis= new FileInputStream(IpathConstant.EXCELPATH);
		System.out.println("2");
		Workbook wb = WorkbookFactory.create(fis);
		System.out.println("3");
		Sheet sheet = wb.getSheet(sheetName);
		System.out.println("4");
		Row row = sheet.getRow(rownum);
		System.out.println("5");
		Cell cell = row.getCell(cellnum);
		System.out.println("6");
		String value = cell.getStringCellValue();
		System.out.println("7");
		return value;
	}
	
	public Object[][] getexcelData(String sheetName) throws Throwable
	{
		FileInputStream fis= new FileInputStream(IpathConstant.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		int lastCell = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[lastRow][lastCell];
		for(int i=0; i<lastRow; i++)
		{
			for(int j=0; j<lastCell; j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
	/**
	 * This method will return cell value by giving testcase ID and header value
	 * @param sheetName
	 * @param tcID
	 * @param headerValue
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName, String tcID, String headerValue) throws Throwable
	{
		FileInputStream fis= new FileInputStream(IpathConstant.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int lastRow=sheet.getLastRowNum();
		int expectedRow=0;
		for(int i=0; i<=lastRow; i++)
		{
			String testCaseID = sheet.getRow(i).getCell(0).getStringCellValue();
			if(testCaseID.equalsIgnoreCase(tcID))
			{
				expectedRow=i;
				break;
			}
		}
		expectedRow--;
		int expectedColumn=0;
		int lastCell=sheet.getRow(expectedRow).getLastCellNum();
		for(int j=0; j<lastCell; j++)
		{
			String value = sheet.getRow(expectedRow).getCell(j).getStringCellValue();
			if(value.equalsIgnoreCase(headerValue))
			{
				expectedColumn=j;
				break;
			}
		}
		return sheet.getRow(expectedRow).getCell(expectedColumn).getStringCellValue();
	}
		
		/**
		 * This method is used to write data inside the excel sheet
		 * @param sheetName
		 * @param rownum
		 * @param column
		 * @param value
		 * @throws Throwable
		 */
		public void writeExcelData(String sheetName, int rownum, int column, String value) throws Throwable
		{
			FileInputStream fis= new FileInputStream(IpathConstant.EXCELPATH);
			Workbook wb = WorkbookFactory.create(fis);
		    wb.getSheet(sheetName).createRow(rownum).createCell(column).setCellValue(value);
		    FileOutputStream fout= new FileOutputStream(IpathConstant.EXCELPATH);
		    wb.write(fout);
		}
		
		
		
		
		
		
		
		public String getPropertyKeyValue(String key) throws Throwable
		{
			FileInputStream file= new FileInputStream(IpathConstant.PROPERTY_FILEPATH);
			Properties prop= new Properties();
			prop.load(file);
			return prop.getProperty(key);
		}
		

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
