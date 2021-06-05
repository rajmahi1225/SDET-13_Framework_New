package com.crm.vtigerTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;

public class CreateOrganizationTestUsingGenericClasses 
{
	@Test
	public void createOrganization() throws Throwable
	{
		JavaUtility jUtil=new JavaUtility();
		
		//ExcelUtility eUtil=new ExcelUtility();
		//String orgName = eUtil.getExcelData("sheet1", 1, 2);
		
		FileUtility fUtil=new FileUtility();
		String browserName = fUtil.getDataFromJson("browser");
		String url = fUtil.getDataFromJson("url");
		String un = fUtil.getDataFromJson("username");
		String pwd = fUtil.getDataFromJson("password");
		
		WebDriver driver=null;
		//launch browser
		if(browserName.equalsIgnoreCase("firefox"))
		{
		    driver=new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else
		{
			System.out.println("Invalid browser Name");
		}
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//get url
		driver.get(url);
		
		//login to application
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to organization
		driver.findElement(By.linkText("Organizations")).click();
		
		//create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("techM"+jUtil.getRandomData());
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//driver.close();       
				
	}

}
