package com.opencart.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.opencart.utilities.ReadConfig;

public class baseclass {

	protected WebDriver driver;
	ReadConfig rc;
	
	public Logger logger;
	
	
	public String baseURL ;
	String screenshotpath ;
	
	@BeforeClass 
	@Parameters("browser")
	public void SetUp(String br)
	{
		logger = (Logger) LogManager.getLogger(baseclass.class);
		
		rc = new ReadConfig();
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+rc.Chromepath());
			driver = new ChromeDriver();
			logger.info("Invoking Chrome");
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+rc.Firefoxpath());
			driver = new FirefoxDriver();
			logger.info("invoking Firefox");
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+rc.Edgepath());
			driver = new EdgeDriver();
			logger.info("invoking Egde");
		}
		
		driver.manage().window().maximize();
		logger.info("Maximizing browser window");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		baseURL = rc.getAppURL(); 
		logger.info("getting base url");
		logger.info("Opening base URL of Application");
				
		
	}
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
		logger.info("Closing Browser/Application");
	}
	
	public void CaptureScreen(WebDriver dr ,String fname) throws IOException
	{
		screenshotpath = System.getProperty("user.dir") + rc.Screenshotpath();
		TakesScreenshot ts  = (TakesScreenshot) dr;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(screenshotpath + fname + ".png");
		FileUtils.copyFile(source, target);
		logger.info("Screenshot Taken and saved");
		System.out.println("Screenshot Taken");
		
	}


	
}
