package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class logout_page_objects {

	WebDriver ldriver;
	
	// Constructor
	public logout_page_objects(WebDriver rdriver)
	{
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	@CacheLookup
	WebElement link_logout;
	
	@FindBy(xpath="//i[@class='fa fa-user']")
	@CacheLookup
	WebElement btn_account;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	@CacheLookup
	WebElement btn_logout;
	
	public void Click_linklogout()
	{
		link_logout.click();
	}
	
	public void Click_account_logout()
	{
		btn_account.click();
		btn_logout.click();
	}
	
}
