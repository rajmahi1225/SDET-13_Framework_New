package com.crm.vtigerTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateOrgWithIndustryTestUsingGenericClasses 
{
	@Test
	public void createorgWithIndustry() throws Throwable
	{
		JavaUtility jUtil= new JavaUtility();
		
		WebDriverUtility wUtil=new WebDriverUtility();
		
		ExcelUtility eUtil= new ExcelUtility();
		String orgName = eUtil.getExcelData("Sheet1", 5, 2);
		String industryType = eUtil.getExcelData("Sheet1", 5, 3);
		
		FileUtility fUtil= new FileUtility();
		String browserName = fUtil.getPropertyKeyValue("browser");
		String url = fUtil.getPropertyKeyValue("url");
		String un = fUtil.getPropertyKeyValue("username");
		String pwd = fUtil.getPropertyKeyValue("password");
		
		//launch browser
		WebDriver driver=null;
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
		driver.findElement(By.name("accountname")).sendKeys(orgName+jUtil.getRandomData());
		
		//select finance from industry drop-down
		WebElement industry = driver.findElement(By.name("industry"));
		wUtil.SelectOption(industry, industryType);
		
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//close browser
		//driver.close();
	}

}
