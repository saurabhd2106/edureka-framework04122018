package demo;

import commonLibs.implementation.CommonDriver;

public class DemoCommonDriver {

	public static void main(String[] args) {
		
		try {
			CommonDriver cmnDriver = new CommonDriver("chrome");
			
			cmnDriver.setPageLoadTimeout(40);
			cmnDriver.setElementDetectionTimeout(20);
			
			cmnDriver.navigateToFirstUrl("http://qatechhub.com");

			System.out.println(cmnDriver.getTitle());
			
			cmnDriver.closeAllBrowsers();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
