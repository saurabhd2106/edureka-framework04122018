package demo;

import commonLibs.utils.ExcelDriver;

public class DemoExcelDriver {

	public static void main(String[] args) {
		try {
			ExcelDriver excelDriver = new ExcelDriver();
			String sheetname="Test Data";
			String filename = System.getProperty("user.dir")+"/outputFiles/testData.xlsx";
			excelDriver.createExcelWorkbook(filename);
			
			excelDriver.openExcelWorkbook(filename);
			excelDriver.createSheet(sheetname);
			
			excelDriver.setCellData(sheetname, 1, 1, "Saurabh");
			excelDriver.setCellData(sheetname, 1, 2, "Gaurav");
			excelDriver.setCellData(sheetname, 1, 3, "Aditi");
			excelDriver.setCellData(sheetname, 1, 4, "Parul");
			
			excelDriver.save();
			excelDriver.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
