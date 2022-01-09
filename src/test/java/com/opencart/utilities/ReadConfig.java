package com.opencart.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	public ReadConfig()
	{
		File scr = new File(System.getProperty("user.dir")+"\\Configuration\\config.properties");
		try 
		{
			FileInputStream fis = new FileInputStream(scr);
			pro = new Properties();
			pro.load(fis);
		}
		catch (Exception e)
		{
			System.out.println("Exception found as :" + e.getMessage());
		}
	}	
	
	public String getAppURL()
	{
		return pro.getProperty("baseURL");
	}
	public String Chromepath()
	{
		return pro.getProperty("chromepath");
	}
	public String Firefoxpath()
	{
		return pro.getProperty("firefoxpath");
	}
	public String Edgepath()
	{
		return pro.getProperty("edgepath");
	}
	public String Screenshotpath()
	{
		return pro.getProperty("Screenshotpath");
	}

	public String Firstname()
	{
		return pro.getProperty("firstname");
	}
	
	public String Lastname()
	{
		return pro.getProperty("lastname");
	}
	
	public String Email()
	{
		return pro.getProperty("email");
	}
	
	public String Telephone()
	{return pro.getProperty("telephone");}
	
	public String Password()
	{return pro.getProperty("password");}
	
	public String CnfPassword()
	{return pro.getProperty("confirmpassword");}
	
	public String Protonurl()
	{return pro.getProperty("protonurl");}
	
	public String Protonemail()
	{return pro.getProperty("protonemail");}
	
	public String Protonpassword()
	{return pro.getProperty("protonpassword");}
}
