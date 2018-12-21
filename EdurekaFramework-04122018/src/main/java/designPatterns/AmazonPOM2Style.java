package designPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.ElementControl;

public class AmazonPOM2Style {

	private WebElement searchBox;

	private WebElement searchCategory;

	private WebElement searchButton;
	private WebElement result;

	private ElementControl elementControl;
	private DropdownControl dropdownControl;

	public AmazonPOM2Style(WebDriver driver) {
		elementControl = new ElementControl();
		dropdownControl = new DropdownControl();

		searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchCategory = driver.findElement(By.id("searchDropdownBox"));

		searchButton = driver.findElement(By.xpath("//input[@value='Go']"));

		result = driver.findElement(By.id("s-result-count"));
	}

	public void searchProduct(String product, String category) throws Exception {
		elementControl.setText(searchBox, "Rado Watch");
		dropdownControl.selectViaVisibleText(searchCategory, "Watches");

		elementControl.clickElement(searchButton);
		
		System.out.println(result.getText());
	}

}
