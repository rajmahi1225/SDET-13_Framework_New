package com.comcast.crm.organizationTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;

public class CreateOrganizationTest extends BaseClass
{
	@Test(groups="smokeTest")
	public void createOrganizationTest() throws Throwable
	{
		String orgName=eUtil.getExcelData("org", 1, 2);
		
		//navigate to organizations
		driver.findElement(By.linkText("Organization")).click();
		Reporter.log("organization page found",true);
		
		
		//create  organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Reporter.log("click on create organization");
		
		driver.findElement(By.name("accountname")).sendKeys(orgName+JavaUtility.getRandomData());
		Reporter.log("create organization with organization name");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Reporter.log("click on save");
		
		//verification
		wUtil.waitforElementVisibility(driver,driver.findElement(By.xpath("//span[@class='dvHeaderText']")));
		String expData=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		Assert.assertTrue(expData.contains(orgName));

		Reporter.log("the expected data is"+expData,true);
		
		
		
	}
	
	
	 @Test(groups="regressionTest")
     public void createOrgWithIndustry() throws Throwable
     {
		String orgName=eUtil.getExcelData("org", 4, 2);
		String industryType=eUtil.getExcelData("org", 4, 3);
		
		//navigate to organization
		
		driver.findElement(By.linkText("Organization")).click();
		
		//create organization
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName+JavaUtility.getRandomData());
		
		WebElement industry=driver.findElement(By.name("industry"));
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verification
		
		wUtil.waitforElementVisibility(driver,driver.findElement(By.xpath("//span[@class='dvHeaderText']")));
		
		String expData=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(expData.contains(orgName));
		Reporter.log("the expected data is"+expData,true);
		
	
     }
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	


