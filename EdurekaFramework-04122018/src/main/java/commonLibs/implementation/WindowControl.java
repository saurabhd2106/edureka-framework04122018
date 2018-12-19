package commonLibs.implementation;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import commonLibs.contracts.WindowHandler;

public class WindowControl implements WindowHandler {
	private WebDriver driver;

	public WindowControl(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void switchToAnyWindow(String windowhandle) throws Exception {
		driver.switchTo().window(windowhandle);
	}

	@Override
	public void switchToAnyWindow(int childWindowIndex) throws Exception {

		String windowHandle = driver.getWindowHandles().toArray()[childWindowIndex].toString();

		driver.switchTo().window(windowHandle);
	}

	@Override
	public String getWindowHandle() throws Exception {
		
		return driver.getWindowHandle();
	}

	@Override
	public Set<String> getWindowHandles() throws Exception {
		
		return driver.getWindowHandles();
	}

}
