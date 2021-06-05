package com.crm.vtigerTests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateContactWithOrganizationTestUsingGeneric 
{
	@Test
	public void createContact()
	{
		WebDriverUtility wu=new WebDriverUtility();
	  
		//launch browser
		WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//get url
		driver.get("http://localhost:8888");
		
		//login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to contact
	     driver.findElement(By.linkText("Contacts")).click();
	     
	     //create contact with organization
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("mahto");
		
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();
		Set<String> window = driver.getWindowHandles();
		
		String orgName= "qspider3";
		wu.switchToWindow(driver, "Accounts");
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(orgName)).click();
		wu.switchToWindow(driver, "Contacts");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		driver.close();
	}
		

}
