package com.mercuryTravel.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.Status;
import com.mercuryTravel.common.ExtentReport;
import com.mercuryTravel.pages.FlightPage;
import com.mercuryTravel.pages.HomePage;

import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.ScreenshotControl;
import commonLibs.utils.ConfigReader;
import commonLibs.utils.DateUtils;

public class TestSetup {


	CommonDriver cmnDriver;

	HomePage homepage;
	FlightPage flightpage;

	private WebDriver driver;
	public ScreenshotControl screenshotControl;
	
	public Properties configProperty;

	public String currentProjectPath;
	
	public ExtentReport extentReport;

	public String executionStartTime;
	
	@BeforeClass(alwaysRun = true)
	public void setup() throws Exception {
		
		setCurrentDirectoryPath();
		
		uploadConfigProperty();
		
		executionStartTime = DateUtils.getDate();
		extentReport = new ExtentReport();

		String reportFileName = String.format("%s/reports/MercuryTravelTest_%s.html", currentProjectPath, executionStartTime);

		extentReport.initializeReport(reportFileName);

		extentReport.test = extentReport.extent.createTest("Initialize Basic setup");

		cmnDriver = new CommonDriver(configProperty.getProperty("browserType"));

		int pageLoadTimeout = Integer.parseInt(configProperty.getProperty("pageLoadTimeout"));
		int elementDetectionTimeout = Integer.parseInt(configProperty.getProperty("elementDetectionTimeout"));

		cmnDriver.setPageLoadTimeout(pageLoadTimeout);
		cmnDriver.setElementDetectionTimeout(elementDetectionTimeout);

		extentReport.test.log(Status.INFO, "Navigating to Base Url");
		cmnDriver.navigateToFirstUrl(configProperty.getProperty("baseUrl"));

		driver = cmnDriver.getDriver();

		initializeScreenshot();

		homepage = new HomePage(driver);
		flightpage = new FlightPage(driver);
	}

	private void initializeScreenshot() {
		screenshotControl = new ScreenshotControl(driver);
	}

	@AfterClass(alwaysRun = true)
	public void cleanup() throws Exception {
		cmnDriver.closeAllBrowsers();
		extentReport.flushReport();
	}

	@AfterMethod(alwaysRun = true)
	public void afterAMethod(ITestResult result) throws Exception {

		if (result.getStatus() == ITestResult.FAILURE) {

			extentReport.test.fail(result.getName());
			String executionTime = DateUtils.getDate();
			String screenshotPath = String.format("%s/screenshots/%s_%s.jpeg", currentProjectPath, result.getName(),
					executionTime);

			String screenshotFile = screenshotControl.captureAndSaveScreenshot(screenshotPath);

			extentReport.test.addScreenCaptureFromPath(screenshotFile);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentReport.test.pass(result.getName());
		} else {
			extentReport.test.skip(result.getName());
		}

	}
	
	private void setCurrentDirectoryPath() {

		currentProjectPath = System.getProperty("user.dir");
	}

	private void uploadConfigProperty() throws Exception {

		configProperty = ConfigReader.getProperties(currentProjectPath + "/config/config.properties");

	}

}
