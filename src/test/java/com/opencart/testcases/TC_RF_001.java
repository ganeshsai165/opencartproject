package com.opencart.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobjects.MyAccount_Page_Objects;
import com.opencart.pageobjects.Register_Page_Objects;

public class TC_RF_001 extends baseclass {

	
	Logger log = (Logger) LogManager.getLogger(TC_RF_001.class);
	
	@Test(priority=1)
	void Reg_mandatory() throws InterruptedException
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
		
		
	}
	
	@Test(priority =2 , dependsOnMethods = "Reg_mandatory")
	void Send_mandatory_fields_data()
	{
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
	
	@Test(priority =3 , dependsOnMethods ="Send_mandatory_fields_data" )
	void Validate_TC() throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		String Current_Title = driver.getTitle();
		String Expected_title = "Your Account Has Been Created!";
		//Assert.assertEquals(Current_Title, "Your Account Has Been Created!");
		boolean status = Current_Title.equals(Expected_title);
		System.out.println(status);
		if(status)
		{			
			Assert.assertTrue(true);
			log.info("TC_RF_001 Passed");
		}
		else
		{
			Thread.sleep(2000);
			Assert.assertTrue(false);
			log.info("TC_RF_001 Failed");
			CaptureScreen(driver, "TC_RF_001");
		}
	}
	
}
