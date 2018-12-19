package commonLibs.implementation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.Javascript;

public class JavascriptControl implements Javascript {

	private WebDriver driver;

	public JavascriptControl(WebDriver driver) {
		this.driver = driver;
	}

	private JavascriptExecutor getJSEngine() {
		JavascriptExecutor jsEngine = (JavascriptExecutor) driver;

		return jsEngine;
	}

	@Override
	public void executeJavaScript(String scriptToExecute) throws Exception {

		getJSEngine().executeScript(scriptToExecute);
	}

	@Override
	public void scrollDown(int x, int y) throws Exception {

		String jsCommand = String.format("window.scrollBy(%d, %d)", x, y);

		getJSEngine().executeScript(jsCommand);

	}

	@Override
	public String executeJavaScriptWithReturnValue(String scriptToExecute) throws Exception {

		return getJSEngine().executeScript(scriptToExecute).toString();
	}

}
