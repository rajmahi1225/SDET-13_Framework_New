package com.crm.vtiger.GenericUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.comcast.objectrepositorylib.Login;

public class BaseClass 
{
	public WebDriver driver;
	public static WebDriver sdriver;             //(to use listeners class)
	public JavaUtility jUtil=new JavaUtility();
	public ExcelUtility eUtil= new ExcelUtility();
	public FileUtility fUtil= new FileUtility();
	public WebDriverUtility wUtil= new WebDriverUtility();
	
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configBS() throws Throwable
	{
		System.out.println("execute @BeforeSuite");
		//connect to DB
		String value = eUtil.getPropertyKeyValue("browser");
		System.out.println(value);
		String value1 = eUtil.getExcelData("contact", 1, 2);
		
		System.out.println(value1);
	}
	
	@BeforeTest(groups= {"smokeTest","regressionTest"})
	public void configBT()
	{
		System.out.println("execute @BeforeTest");
		//launch browser in parallel mode
	}
	
	@Parameters("browser")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configBC() throws Throwable
	{
		System.out.println("execute @BeforeClass");
		
		String browserName = fUtil.getPropertyKeyValue("browser");
		if(browserName.equalsIgnoreCase("firefox"))
		{
		    driver=new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("IE"))
		{
			driver=new InternetExplorerDriver();
		}
		sdriver= driver;                                //(to use listeners class)
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void setUp() throws Throwable
	{
		System.out.println("execute @BeforeMethod");
		
		String url= fUtil.getPropertyKeyValue("url");
		String un= fUtil.getPropertyKeyValue("username");
		String pwd= fUtil.getPropertyKeyValue("password");
       
		driver.get(url);
		//driver.findElement(By.name("user_name")).sendKeys(un);
		//driver.findElement(By.name("user_password")).sendKeys(pwd);
		//driver.findElement(By.id("submitButton")).click();
		
		Login loginPage= new Login(driver);      //85 and 86 line (we have used pom class for login page)
		loginPage.login("admin", "admin");
	}
	
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void tearDown() throws Throwable
	{
		System.out.println("execute @AfterMethod");
		
		WebElement administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseOver(driver, administrator);
		wUtil.waitAndClick(driver.findElement(By.xpath("//a[text()='Sign Out']")));
	}
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAC()
	{
		System.out.println("execute @AfterClass");
		
		driver.quit();
	}
	
	@AfterTest(groups= {"smokeTest","regressionTest"})
	public void configAT()
	{
		System.out.println("execute @AfterTest");
		//close driver ref in parallel mode
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void configAS()
	{
		System.out.println("execute @AfterSuite");
		//close DB connection
	}

}
