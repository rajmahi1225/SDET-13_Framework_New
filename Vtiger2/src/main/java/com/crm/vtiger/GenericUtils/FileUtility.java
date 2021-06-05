package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 * 
 * @author RAJ MAHI
 *
 */
public class FileUtility 
{
	/**
	 * This method is used to read data from properties and return the value based on key specified
	 * @param key
	 * @return
	 * @throws Throwable 
	 */
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream file= new FileInputStream(IpathConstant.PROPERTY_FILEPATH);
		Properties prop= new Properties();
		prop.load(file);
		return prop.getProperty(key);
	}
	
	/**
	 * This method will return json value based on json key
	 * @param jsonKey
	 * @return
	 * @throws Throwable 
	 */
	public String getDataFromJson(String jsonKey) throws Throwable
	{
		FileReader reader=new FileReader(IpathConstant.JSONFILEPATH);
		JSONParser j = new JSONParser();
		Object obj = j.parse(reader);
		JSONObject jObj=(JSONObject)obj;
		String value=jObj.get(jsonKey).toString();
		return value;
	}

}
