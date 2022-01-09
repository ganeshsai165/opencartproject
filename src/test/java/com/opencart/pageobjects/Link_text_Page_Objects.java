package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Link_text_Page_Objects {

	WebDriver ldriver;
	
	// Constructor
	public Link_text_Page_Objects(WebDriver rdriver)
	{
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}

	
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Register']")
	@CacheLookup
	WebElement register_link_text;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Login']")
	@CacheLookup
	WebElement login_link_text;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Forgotten Password']")
	@CacheLookup
	WebElement forgot_password_link;
	
	public void click_register_link() 
	{
		register_link_text.click();
	}
	
	public void click_login_link()
	{
		login_link_text.click();
	}
	
	public void click_forgot_password()
	{
		forgot_password_link.click();
	}
}
