package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount_Page_Objects {

	 	WebDriver ldriver;
		
		// Constructor
		public MyAccount_Page_Objects(WebDriver rdriver)
		{
			
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
			
		}

	
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	@CacheLookup
	WebElement btn_my_Account;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
	@CacheLookup
	WebElement btn_Register;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	@CacheLookup
	WebElement btn_Login;
	
	@FindBy(name="search")
	@CacheLookup
	WebElement txt_search;
	
	@FindBy(xpath="//*[@id=\"search\"]/span/button")
	@CacheLookup
	WebElement btn_search;
	
	
	
	public void Click_myAccount()
	{				
		btn_my_Account.click();					
	}
	
	public void Click_Register()
	{
		btn_Register.click();
	}
	
	public void Click_Login()
	{
		btn_Login.click();
	}
	
}
