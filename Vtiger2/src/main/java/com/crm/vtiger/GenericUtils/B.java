package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class B 
{
   public static void main(String[] args) throws Throwable 
   {
     System.out.println("start of java code");
	   //FileUtility fUtil= new FileUtility();
	   FileInputStream fis= new FileInputStream("./Data/testdata.xlsx");
	   System.out.println("1");
	  // String value=fUtil.getDataFromJson("browser");
	  // Properties p=new Properties();
       Workbook wb = WorkbookFactory.create(fis);
	   System.out.println("2");
	 //  p.load(fis);
	   System.out.println("3");
	  //String value = p.getProperty("browser");
	   String value = wb.getSheet("contact").getRow(0).getCell(2).getStringCellValue();
	    System.out.println(value);
	   System.out.println("end of java code");
	
   }

}
