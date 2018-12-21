package com.mercuryTravel.tests;

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
import commonLibs.utils.DateUtils;

public class TestSetup extends ExtentReport {

	public TestSetup() throws Exception {
		super();
	}

	CommonDriver cmnDriver;

	HomePage homepage;
	FlightPage flightpage;

	private WebDriver driver;
	public ScreenshotControl screenshotControl;

	@BeforeClass(alwaysRun = true)
	public void setup() throws Exception {

		initializeReport();

		test = extent.createTest("Initialize Basic setup");

		cmnDriver = new CommonDriver(configProperty.getProperty("browserType"));

		int pageLoadTimeout = Integer.parseInt(configProperty.getProperty("pageLoadTimeout"));
		int elementDetectionTimeout = Integer.parseInt(configProperty.getProperty("elementDetectionTimeout"));

		cmnDriver.setPageLoadTimeout(pageLoadTimeout);
		cmnDriver.setElementDetectionTimeout(elementDetectionTimeout);

		test.log(Status.INFO, "Navigating to Base Url");
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
		flushReport();
	}

	@AfterMethod(alwaysRun = true)
	public void afterAMethod(ITestResult result) throws Exception {

		if (result.getStatus() == ITestResult.FAILURE) {

			test.fail(result.getName());
			String executionTime = DateUtils.getDate();
			String screenshotPath = String.format("%s/screenshots/%s_%s.jpeg", currentProjectPath, result.getName(),
					executionTime);

			String screenshotFile = screenshotControl.captureAndSaveScreenshot(screenshotPath);

			test.addScreenCaptureFromPath(screenshotFile);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.pass(result.getName());
		} else {
			test.skip(result.getName());
		}

	}

}
