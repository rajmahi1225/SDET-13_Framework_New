package com.comcast.crm.contactTest;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;

public class CreateContactTest extends BaseClass
{
	@Test(groups="smokeTest")
	public void createContact() throws Throwable
	{
		String lastName=eUtil.getExcelData("contact", 1, 2)+"_"+JavaUtility.getRandomData();
		
		//navigate to contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		//create contact with organization
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
	
	
	
	@Test(groups="regressionTest")
	public void createContactWithOrg() throws Throwable
	{
		String orgName=eUtil.getExcelData("contact", "TC_02", "organizationName");
		String lastName=eUtil.getExcelData("contact", "TC_02", "lastName")+"_"+JavaUtility.getRandomData();
		
		//navigate to contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		
		//create contact with organization
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);		
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();
		wUtil.switchToWindow(driver, "Accounts");
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(orgName)).click();
		wUtil.switchToWindow(driver, "Contacts");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				

		
		
		
	}

}
