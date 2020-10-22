package PageObjests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AnswersPage extends BasePage {
	private static final By GET_RESULTS_BTN = By.cssSelector("#button-get-results");

	public AnswersPage(WebDriver driver) {
		super(driver);
	}

	public void clickGetResults() {
		findAndClick(GET_RESULTS_BTN);
	}
}
