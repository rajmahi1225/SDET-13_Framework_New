package com.comcast.crm.contactTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;

@Listeners(com.crm.vtiger.GenericUtils.ListImpClass.class)
public class Practice extends BaseClass
{
	@Test
	public void create1()
	{
		System.out.println("start of java code");
		System.out.println(10/0);
		System.out.println("end of java code");
	}

}
