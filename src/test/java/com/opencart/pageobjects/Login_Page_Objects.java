package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page_Objects {

	WebDriver ldriver;
	
	// Constructor
	public Login_Page_Objects(WebDriver rdriver)
	{
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	
	@FindBy(name="email")
	@CacheLookup
	WebElement txt_email_address;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txt_password;
	
	@FindBy(xpath="//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
	@CacheLookup
	WebElement link_forgot_password;
	
	@FindBy(xpath="//input[@value='Login']")
	@CacheLookup
	WebElement btn_login;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	@CacheLookup
	WebElement btn_register_continue;
	
	public void Send_email_address(String emailid)
	{
		txt_email_address.sendKeys(emailid);
	}
	
	public void Send_password(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	
	public void Click_forgot_password()
	{
		link_forgot_password.click();
	}
	
	public void Click_Login_Btn()
	{
		btn_login.click();
	}
	
	public void Click_register_continue()
	{
		btn_register_continue.click();
	}
}
