package com.crm.vtiger.GenericUtils;

import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;

/**
 * This class contains java specific generic libraries
 * @Raj
 * 
 */

public class JavaUtility 
{
	/**
	 * generate random number
	 * @Raj
	 */

	public static String getRandomData()
	{
		Random random=new Random();
		int ran = random.nextInt(1000);
		return ""+ran;
		
	}
	/**
	 * Generate current system date
	 * @Raj
	 */
	public String getCurrentSystemDate()
	{
		Date date=new Date();
		String currentDate=date.toString();
		return currentDate;
	}

}
