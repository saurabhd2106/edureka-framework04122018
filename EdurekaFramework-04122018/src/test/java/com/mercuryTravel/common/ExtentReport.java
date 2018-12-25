package com.mercuryTravel.common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	public void initializeReport(String reportFileName) {

		htmlReporter = new ExtentHtmlReporter(reportFileName);
		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);

	}

	public void flushReport() {
		extent.flush();
	}
}
