package PageObjests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultsPage extends BasePage {
	private static final By RESTART_BTN = By.cssSelector("#restart-button");

	public ResultsPage(WebDriver driver) {
		super(driver);
	}

	public Boolean isRestartButtonVisible() {
		return checkElementIsVisible(RESTART_BTN);
	}
}
