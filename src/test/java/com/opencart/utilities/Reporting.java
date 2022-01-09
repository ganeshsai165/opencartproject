package com.opencart.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {

	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testcontext)
	{
		
		String timestamp = new SimpleDateFormat("YYYY.MM.DD.HH.mm.ss").format(new Date());
		String repName = testcontext.getName()+"_"  + timestamp + ".html";
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\test-output\\" + repName);
		htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"\\extent-config.xml");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("HostName", "localHost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester", "Ganesh");
		extent.setSystemInfo("OS", "Windows 10 64 bit");
		extent.setSystemInfo("Browsers : ", "Chrome,Firefox,Edge");
		
		htmlreporter.config().setDocumentTitle("opencart project");
		htmlreporter.config().setReportName("Functionality Test Report");
		htmlreporter.config().setTheme(Theme.DARK);
		
	}

	public void onTestSuccess(ITestResult tr)
	{
		logger = extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr)
	{
		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String scrshtpth = System.getProperty("user.dir") + "\\Screenshots\\" + tr.getName() + ".png";
		
		//String scrshtpth = "D:\\Eclipse\\workspace\\nopecommercev1\\Screenshots\\" +tr.getName()+ ".png";
		
		File f = new File(scrshtpth);
		
		if(f.exists())
		{
			try
			{
				logger.fail("Screenshot is Below : " + logger.addScreenCaptureFromPath(scrshtpth)); 
				
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		logger = extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext itc)
	{
		extent.flush();
	}
}

	

