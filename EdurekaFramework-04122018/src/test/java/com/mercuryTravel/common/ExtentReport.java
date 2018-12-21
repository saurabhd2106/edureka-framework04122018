package com.mercuryTravel.common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import commonLibs.utils.DateUtils;

public class ExtentReport extends ParameterInit{
	public ExtentReport() throws Exception {
		super();
	}


	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	

	public void initializeReport(){
		String executionTime = DateUtils.getDate();
		
		
		String filename = String.format("%s/reports/MercuryTravelTest_%s.html", currentProjectPath, executionTime);

		htmlReporter = new ExtentHtmlReporter(filename);
		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);

		
	}
	
	
	public void flushReport(){
		extent.flush();
	}
}
