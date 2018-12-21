package commonLibs.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	public static void waitForSeconds(int timeInSeconds) throws Exception {
		Thread.sleep(timeInSeconds * 1000);
	}

	public static void explicitWait(String waitType, WebDriver driver, WebElement element, int timeoutInSeconds) {

		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);

		switch (waitType) {
		case "visibility":
			wait.until(ExpectedConditions.visibilityOf(element));
			break;
		case "clickable":
			wait.until(ExpectedConditions.elementToBeClickable(element));
			break;

		}
	}

}
