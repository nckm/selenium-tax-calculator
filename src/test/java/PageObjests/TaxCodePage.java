package PageObjests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TaxCodePage extends BasePage {
	private static final By TAXCODE_INPUT = By.cssSelector("#taxCode");
	private static By CONTINUE_BTN = By.cssSelector("#button-continue");

	public TaxCodePage(WebDriver driver) {
		super(driver);
	}

	public AnswersPage enterTaxCode1250L() {
		enterTaxCode("1250L");
		clickContinueToAnswerPage();
		return new AnswersPage(driver);
	}

	public ScottishTaxPage continueWithoutTaxCode() {
		clickContinueToScottishTaxPage();
		return new ScottishTaxPage(driver);
	}

	private TaxCodePage enterTaxCode(String taxCode) {
		findAndSendKeys(TAXCODE_INPUT, taxCode);
		return this;
	}

	private AnswersPage clickContinueToAnswerPage() {
		findAndClick(CONTINUE_BTN);
		return new AnswersPage(driver);
	}

	private ScottishTaxPage clickContinueToScottishTaxPage() {
		findAndClick(CONTINUE_BTN);
		return new ScottishTaxPage(driver);
	}
}
