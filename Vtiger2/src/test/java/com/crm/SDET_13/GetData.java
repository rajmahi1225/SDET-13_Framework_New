package com.crm.SDET_13;

import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.ExcelUtility;

public class GetData 
{
	@Test
	public void getData() throws Throwable
	{
		ExcelUtility eUtil= new ExcelUtility();
		String value = eUtil.getExcelData("sheet1", "TC_02", "organizationName");
		System.out.println(value);
	}

}
