package com.mercuryTravel.utils;

import java.util.Properties;

import org.testng.annotations.DataProvider;

import commonLibs.utils.ConfigReader;
import commonLibs.utils.ExcelDriver;

public class TestDataProvider {
	
	
	
	private ExcelDriver excelDriver;
	private String configFileName;
	private String inputFilename;
	private String sheetName;
	private Properties configProperty;
	
	public TestDataProvider() throws Exception{
		configFileName = System.getProperty("user.dir")+"/config/config.properties";
		
		configProperty = ConfigReader.getProperties(configFileName);

		inputFilename = configProperty.getProperty("inputFilename");
		
		sheetName = configProperty.getProperty("sheetName");
		
	}
	
	@DataProvider
	public Object[][] getTestData() throws Exception{
		
		Object[][] data;

		excelDriver = new ExcelDriver();

		excelDriver.openExcelWorkbook(inputFilename);

		int numberOfRows = excelDriver.getRowCountoFSheet(sheetName);

		int numberOfCellInFirstRow = excelDriver.getCellCount(sheetName, 1);

		data = new Object[numberOfRows + 1][numberOfCellInFirstRow];

		for (int iRow = 1; iRow <= numberOfRows + 1; iRow++) {


			for (int iCell = 1; iCell <= numberOfCellInFirstRow; iCell++) {

				data[iRow - 1][iCell - 1] = excelDriver.getCellData(sheetName, iRow, iCell);

			}
		}

		return data;
		
	}

}
