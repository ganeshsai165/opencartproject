package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register_Page_Objects {

	WebDriver ldriver;
	
	// Constructor
	public Register_Page_Objects(WebDriver rdriver)
	{
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	
	@FindBy(name="firstname")
	@CacheLookup
	WebElement txt_first_name ;
	
	@FindBy(name="lastname")
	@CacheLookup
	WebElement txt_last_name;
	
	@FindBy(name="email")
	@CacheLookup
	WebElement txt_email;
	
	@FindBy(name="telephone")
	@CacheLookup
	WebElement txt_telephone;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txt_password;
	
	@FindBy(name="confirm")
	@CacheLookup
	WebElement txt_confirm_password;
	
	@FindBy(name="agree")
	@CacheLookup
	WebElement chckbx_privacy_policy;
	
	@FindBy(xpath="//label[normalize-space()='Yes']//input[@name='newsletter']")
	@CacheLookup
	WebElement radio_btn_subscribe_yes;
	
	@FindBy(xpath="//input[@value='0']")
	@CacheLookup
	WebElement radio_btn_subscribe_no;
	
	@FindBy(xpath="//input[@value='Continue']")
	@CacheLookup
	WebElement btn_submit;
	
	
	
	public void Send_first_name(String fname)
	{
		txt_first_name.sendKeys(fname);
	}
	
	public void Send_last_name(String lname)
	{
		txt_last_name.sendKeys(lname);
	}
	
	public void Send_email(String emailid)
	{
		txt_email.sendKeys(emailid);
	}
	
	public void Send_telephone(String phnenumber)
	{
		txt_telephone.sendKeys(phnenumber);
	}
	
	public void Send_password(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	
	public void Send_confirm_password(String pwd)
	{
		txt_confirm_password.sendKeys(pwd);
	}
	
	public void accept_privacy_policy()
	{
		chckbx_privacy_policy.click();
	}
	
	public void subscribe_yes()
	{
		radio_btn_subscribe_yes.click();
	}
	
	public void subscribe_no()
	{
		radio_btn_subscribe_no.click();		
	}
	
	public void click_submit()
	{
		btn_submit.click();
	}
	
	
}
