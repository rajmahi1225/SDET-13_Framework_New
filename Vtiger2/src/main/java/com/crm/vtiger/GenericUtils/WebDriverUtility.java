package com.crm.vtiger.GenericUtils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * this class contains webDriver specific generic methods
 * @Raj
 *
 */

public class WebDriverUtility 
{
	/**
	 * this method wait for20 seconds for page loading
	 * @param driver
	 */
	public void waitUntilPageLaod(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	/**
	 * this method wait for the element to be visible
	 * @param driver
	 * @param element
	 * 
	 */
	public void waitforElementVisibility(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/**
	 *this method wait for the element to be clicked 
	 * @param element
	 * @throws throwable
	 */
	
	public void waitAndClick(WebElement element) throws InterruptedException 
	{
		int count=0;
				while(count<40)
				{
					try 
					{
					element.click();
					break;
					}
					catch(Throwable e)
					{
						Thread.sleep(5000);
						count++;
					}		
	           }
       }
	
	
	/**
	 * this methods enables users to handle drop down using visible text
	 *@param element
	 *@param option 
	 */

	public void SelectOption(WebElement element,String option)
	{
		Select s=new Select(element);
		s.selectByVisibleText(option);
	}
	
	/**
	 * this methods enables users to handle drop down using index
	 *@param element
	 *@param index 
	 */
	public void SelectOption(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	
	/**
	 * this method will perform mouseover action
	 * @param driver
	 * @param element
	 */
	
	public void mouseOver(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	
	/**
	 * this method perform right click operation
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	
	/**
	 * this method helps us to switch from one window to another
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it=window.iterator();
		while(it.hasNext())
		{
			
		  String winId=it.next();
		  String title=driver.switchTo().window(winId).getTitle();
		  if(title.contains(partialWinTitle))
		   {
			 break;
		   }
		
	   }
	}
	
	/**
	 * Accept alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * Cancel alert
	 * @param driver
	 */
	 public void cancelAlert(WebDriver driver)
	 {
		 driver.switchTo().alert().dismiss();
	 }
     
     /**
      * this method  used for scrolling action in a webpage
      * @param driver
      * @param element
      */
      public void scrollToWebElement(WebDriver driver,WebElement element)
      {
    	  JavascriptExecutor js=(JavascriptExecutor)driver;
          int y=element.getLocation().getY();
          js.executeScript("window.scrollBy(0,"+y+")",element); 
      }
      
       /**
        * this method is used to switch the frame using index
        * @param driver
        * @param index
        */
     	public void switchFrame(WebDriver driver,int index)
     	{
     	  driver.switchTo().frame(index);
     	}
     	
     	/**
     	 * this method is used to switch the frame using webelement
     	 * @param driver
     	 * @param element
     	 */
     	public void switchFrame(WebDriver driver,WebElement element)
     	{
     	  driver.switchTo().frame(element);
     	}
     	
     	/**
     	 * this method is used to switch the frame using id or name
     	 * @param driver
     	 * @param idOrName
     	 */
     	public void switchFrame(WebDriver driver,String idOrName)
     	{
     	  driver.switchTo().frame(idOrName);
     	}
     	
     	/**
     	 * this method is used to take the screenshots
     	 * @param driver
     	 * @param screenshotName
     	 * @throws Throwable
     	 */
     	public void takeScreenshot(WebDriver driver,String screenshotName) throws Throwable 
     	{
     		TakesScreenshot ts=(TakesScreenshot)driver;
     		File src = ts.getScreenshotAs(OutputType.FILE);
     	    File dest=new File("./screenshot/"+screenshotName+".PNG");
     	    Files.copy(src, dest);
     	}
     	
     	/**
     	 * this method is used for robot class
     	 * @param key
     	 * @throws Throwable
     	 */
     	public void pressEnterKey(KeyEvent key)throws Throwable
     	{
     		Robot rc=new Robot();
     		rc.keyPress(KeyEvent.VK_ENTER);
     		rc.keyRelease(KeyEvent.VK_ENTER);
     	}
}
