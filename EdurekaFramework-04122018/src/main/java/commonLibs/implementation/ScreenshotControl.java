package commonLibs.implementation;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.Screenshot;

public class ScreenshotControl implements Screenshot{
	
	WebDriver driver;
	
	public ScreenshotControl(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public String captureAndSaveScreenshot(String fileName) throws Exception {
		fileName = fileName.trim();
		
		File imgFile, tmpFile;
		
		imgFile = new File(fileName);
		
		if(imgFile.exists()){
			throw new Exception("Duplicate file name..");
		}
		
		TakesScreenshot camera;
		
		camera = (TakesScreenshot) driver;
		
		tmpFile = camera.getScreenshotAs(OutputType.FILE);
		
		FileUtils.moveFile(tmpFile, imgFile);
		
		return imgFile.getAbsolutePath();
	}

}
