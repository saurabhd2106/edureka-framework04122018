package designPatterns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.ElementControl;

public class AmazonPOM3Style {

	@CacheLookup
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBox;

	@CacheLookup
	@FindBy(id = "searchDropdownBox")
	private WebElement searchCategory;

	@CacheLookup
	@FindBy(xpath = "//input[@value='Go']")
	private WebElement searchButton;

	@FindBy(id = "s-result-count")
	private WebElement result;

	private ElementControl elementControl;
	private DropdownControl dropdownControl;

	public AmazonPOM3Style(WebDriver driver) {
		elementControl = new ElementControl();
		dropdownControl = new DropdownControl();

		PageFactory.initElements(driver, this);
	}

	public void searchProduct(String product, String category) throws Exception {
		elementControl.setText(searchBox, "Rado Watch");
		dropdownControl.selectViaVisibleText(searchCategory, "Watches");

		elementControl.clickElement(searchButton);

		System.out.println(result.getText());
	}

}
