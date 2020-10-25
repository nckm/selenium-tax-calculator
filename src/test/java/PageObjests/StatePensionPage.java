package PageObjests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StatePensionPage extends BasePage {
	private static final By N0_BTN = By.cssSelector("#overStatePensionAge-2 + label");
	private static By CONTINUE_BTN = By.cssSelector("#button-continue");

	public StatePensionPage(WebDriver driver) {
		super(driver);
	}

	public TaxCodePage belowStatePensionAge() {
		clickNo();
		clickContinue();
		return new TaxCodePage(driver);
	}

	private StatePensionPage clickNo() {
		findAndClick(N0_BTN);
		return this;
	}

	private TaxCodePage clickContinue() {
		findAndClick(CONTINUE_BTN);
		return new TaxCodePage(driver);
	}

}
