package com.mercuryTravel.common;

import java.util.Properties;

import commonLibs.utils.ConfigReader;

public class ParameterInit {

	public Properties configProperty;

	public String currentProjectPath;

	public ParameterInit() throws Exception {
		setCurrentDirectoryPath();
		uploadConfigProperty();

	}

	private void setCurrentDirectoryPath() {

		currentProjectPath = System.getProperty("user.dir");
	}

	private void uploadConfigProperty() throws Exception {

		configProperty = ConfigReader.getProperties(currentProjectPath + "/config/config.properties");

	}

}
