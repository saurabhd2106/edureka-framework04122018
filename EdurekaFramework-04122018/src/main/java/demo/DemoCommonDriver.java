package demo;

import commonLibs.contracts.Screenshot;
import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.ScreenshotControl;

public class DemoCommonDriver {

	public static void main(String[] args) {

		try {
			CommonDriver cmnDriver = new CommonDriver("chrome");
			ScreenshotControl screenshotControl = new ScreenshotControl(cmnDriver.getDriver());
			cmnDriver.setPageLoadTimeout(40);
			cmnDriver.setElementDetectionTimeout(20);

			cmnDriver.navigateToFirstUrl("http://qatechhub.com");

			String filename = System.getProperty("user.dir") + "/screenshots/testimg.jpeg";
			screenshotControl.captureAndSaveScreenshot(filename);
			System.out.println(cmnDriver.getTitle());

			cmnDriver.closeAllBrowsers();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
