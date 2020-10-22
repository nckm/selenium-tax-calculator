package PageObjests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScottishTaxPage extends BasePage {
	private static final By NO_BTN = By.cssSelector("#payScottishRate-2 + label");

	public ScottishTaxPage(WebDriver driver) {
		super(driver);
	}

	public void noScottishIncomeTax() {
		findAndClick(NO_BTN);
		clickContinue();
	}
}
