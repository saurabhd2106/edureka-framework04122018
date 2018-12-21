package com.mercuryTravel.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class HomePageTests extends TestSetup {

	public HomePageTests() throws Exception {
		super();
	}

	@Parameters({"sUserEmailId","sUserPassword"})
	@Test
	public void verifyLoginToApplication(String sUserEmailId, String sUserPassword) throws Exception {

		test = extent.createTest("TC - 121 - Verify Login to Mercury Travel with paramters : "+ sUserEmailId + " "+ sUserPassword);
		homepage.userLogin(sUserEmailId, sUserPassword);

		String actualWelcomeText = "Welcome, Saurabh 1";

		String expectedWelcomeText = homepage.getWelcomeText();
		
		Assert.assertEquals(actualWelcomeText, expectedWelcomeText);

		test.log(Status.INFO, "Both Actual and Welcome text match");
	}

}
