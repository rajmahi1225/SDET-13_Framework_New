package com.crm.SDET_13;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest 
{
	@DataProvider
	public Object[][] getData()
	{
		Object[][] arr= new Object[2][2];
		arr[0][0]= "TestYantra";
		arr[0][1]= "Technology";
		arr[1][0]= "Amazon";
		arr[1][1]= "E-Commerce";
		return arr;
	}
	@Test(dataProvider = "getData")
	public void test(String name, String dropDown)
	{
		System.out.println(name + "\t" + dropDown);
	}
		
	

}
