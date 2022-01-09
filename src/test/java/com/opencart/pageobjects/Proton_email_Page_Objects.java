package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Proton_email_Page_Objects {

	WebDriver ldriver;
	public Proton_email_Page_Objects(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="username")
	@CacheLookup
	WebElement txt_email;
	
	@FindBy(id="password")
	@CacheLookup
	WebElement txt_password;
	
	@FindBy(xpath="//button[@type='submit']")
	@CacheLookup
	WebElement btn_submit;
	
	@FindBy(xpath="//span[normalize-space()='Inbox']")
	@CacheLookup
	WebElement btn_inbox;
	
	@FindBy(xpath="//button[normalize-space()='Unread']")
	@CacheLookup
	WebElement btn_unread;
	
	@FindBy(id="global_search")
	@CacheLookup
	WebElement txt_search;
	
	@FindBy(xpath="//button[@title='Search']")
	@CacheLookup
	WebElement btn_search;
	
	public void Send_Email(String emailid)
	{
		txt_email.sendKeys(emailid);
	}
	
	public void Send_Password(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	
	public void Click_Submit()
	{
		btn_submit.click();
	}
	
	public void Check_Inbox()
	{
		btn_inbox.click();
		btn_unread.click();
		
	}
	
	public void Send_searchbox(String msg)
	{
		txt_search.sendKeys(msg);
		btn_search.click();
	}
	
}
