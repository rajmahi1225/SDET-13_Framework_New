package com.crm.vtiger.GenericUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListImpClass implements ITestListener
{
    //@Override
	public void onTestFailure(ITestResult result) 
	{
		String currentDate= new Date().toString().replace(":", "_").replace(" ", "_");
		String failedTestName = result.getMethod().getMethodName();
		
		EventFiringWebDriver ed = new EventFiringWebDriver(BaseClass.sdriver);
		File srcImg = ed.getScreenshotAs(OutputType.FILE);
		File dstImg = new File("./screenshot/"+failedTestName+"_"+currentDate+".png");
		try
		{
			FileUtils.copyFile(srcImg, dstImg);
		}
		catch(IOException e)
		{
			
		}
		
	}
	
	

}










//public void onTestFailure(ITestListener result)
//{
	
//}