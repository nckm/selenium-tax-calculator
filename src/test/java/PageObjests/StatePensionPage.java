package PageObjests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StatePensionPage extends BasePage {
	private static final By N0_BTN = By.cssSelector("#overStatePensionAge-2 + label");

	public StatePensionPage(WebDriver driver) {
		super(driver);
	}

	public void belowStatePensionAge() {
		clickNo();
		clickContinue();
	}

	private void clickNo() {
		findAndClick(N0_BTN);
	}


}
