package com.mercuryTravel.pages;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.ElementControl;
import commonLibs.implementation.MouseControl;

public class BaseOperation {

	protected ElementControl elementControl;
	protected DropdownControl dropdownControl;
	protected MouseControl mouseControl;

	public BaseOperation(WebDriver driver) {
		elementControl = new ElementControl();
		dropdownControl = new DropdownControl();
		mouseControl = new MouseControl(driver);
	}

}
