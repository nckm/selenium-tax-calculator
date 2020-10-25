package PageObjests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScottishTaxPage extends BasePage {
	private static final By NO_BTN = By.cssSelector("#payScottishRate-2 + label");
	private static By CONTINUE_BTN = By.cssSelector("#button-continue");

	public ScottishTaxPage(WebDriver driver) {
		super(driver);
	}

	public AnswersPage noScottishIncomeTax() {
		findAndClick(NO_BTN);
		clickContinue();
		return new AnswersPage(driver);
	}

	private AnswersPage clickContinue() {
		findAndClick(CONTINUE_BTN);
		return new AnswersPage(driver);
	}
}
