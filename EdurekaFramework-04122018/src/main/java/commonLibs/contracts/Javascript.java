package commonLibs.contracts;

public interface Javascript {
	
	public void executeJavaScript(String scriptToExecute) throws Exception;

	public void scrollDown(int x, int y) throws Exception;

	public String executeJavaScriptWithReturnValue(String scriptToExecute) throws Exception;

}
