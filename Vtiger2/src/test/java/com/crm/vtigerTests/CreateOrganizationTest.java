package com.crm.vtigerTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateOrganizationTest 
{
	@Test
	public void createOrganization()
	{
		//launch browser
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//get url
		driver.get("http://localhost:8888");
		
		//login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to organization
		driver.findElement(By.linkText("Organizations")).click();
		
		//create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("techM500");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//driver.close();       
				
	}

}
