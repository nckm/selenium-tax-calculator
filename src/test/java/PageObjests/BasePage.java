package PageObjests;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;

	private static By CONTINUE_BTN = By.cssSelector("#button-continue");

	BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
	}

//	public void clickContinue() {
//		findAndClick(CONTINUE_BTN);
//	}

	protected void findAndSendKeys(By selector, String inputString) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selector));
		element.clear();
		element.sendKeys(inputString);
	}

	protected void findAndClick(By selector) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selector));
		element.click();
	}

	protected Boolean checkElementIsVisible(By selector) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
			return true;
		} catch (ElementNotVisibleException e) {
			return false;
		}
	}
}
