package com.opencart.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobjects.MyAccount_Page_Objects;
import com.opencart.pageobjects.Proton_email_Page_Objects;
import com.opencart.pageobjects.Register_Page_Objects;

public class TC_RF_002 extends baseclass {

	Logger log = (Logger) LogManager.getLogger(TC_RF_002.class);
	
	@Test(priority=1)
	void Register() throws InterruptedException
	{
		MyAccount_Page_Objects myaccount = new MyAccount_Page_Objects(driver);
		
		
		log.info("");
		driver.get(baseURL);
		log.info("opened base url");
		Thread.sleep(1000);
		log.info("Sleeping for 1 sec");
		myaccount.Click_myAccount();		
		log.info("Clicked myaccount btn");
		myaccount.Click_Register();
		log.info("Clicked Register btn under my account");
		
		Register_Page_Objects reg = new Register_Page_Objects(driver);
		reg.Send_first_name(rc.Firstname());
		log.info("Sent First name from prop");
		reg.Send_last_name(rc.Lastname());
		log.info("Sent Last name");
		reg.Send_email(rc.Email());
		log.info("Sent email address");
		reg.Send_telephone(rc.Telephone());
		log.info("Sent telephone");
		reg.Send_password(rc.Password());
		log.info("Sent password");
		reg.Send_confirm_password(rc.CnfPassword());
		log.info("Sent confirm password");
		reg.accept_privacy_policy();
		log.info("Accepted privacy");
		reg.click_submit();
		log.info("Clicked submit");
		
	}
	
	@Test(priority=2)
	void Verifyemailconfirmation() throws InterruptedException
	{
		Proton_email_Page_Objects email = new Proton_email_Page_Objects(driver);
		
		log.info("Verifying Email confirmation sent to mail");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(rc.Protonurl());
		log.info("Opening proton email");
		Thread.sleep(5000);
		email.Send_Email(rc.Protonemail());	
		log.info("Setting email id");
		email.Send_Password(rc.Protonpassword());
		log.info("Setting password");
		email.Click_Submit();
		Thread.sleep(5000);
		log.info("logging in");
		email.Check_Inbox();
		log.info("checking inbox");
		email.Send_searchbox("open cart");
		log.info("searching for open cart email if any");
		
		if(driver.getPageSource().contains("No results found"))
		{
			Assert.fail("TC_RF_002 failed");
			log.info("No email sentto reg email id");
			log.info("TC_RF_002 failed");
		}		
		else
		{
			// To do
		}
	}
	
	
}
