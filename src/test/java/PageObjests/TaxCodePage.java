package PageObjests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TaxCodePage extends BasePage {
	private static final By TAXCODE_INPUT = By.cssSelector("#taxCode");

	public TaxCodePage(WebDriver driver) {
		super(driver);
	}

	public void enterTaxCode1250L() {
		enterTaxCode("1250L");
		clickContinue();
	}

	private void enterTaxCode(String taxCode) {
		findAndSendKeys(TAXCODE_INPUT, taxCode);
	}
}
