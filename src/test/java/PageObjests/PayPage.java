package PageObjests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PayPage extends BasePage {

	private static final String URL = "https://www.tax.service.gov.uk/estimate-paye-take-home-pay/your-pay";

	private static final By PAY_INPUT = By.cssSelector("#amount");
	private static final By ANNUAL_RADIO_BTN = By.cssSelector("#period-5 + label");
	private static final By AMOUNT_PAID_ERROR = By.cssSelector("#amount-error");

	public PayPage(WebDriver driver) {
		super(driver);
	}

	public void goToURL() {
		driver.get(URL);
		driver.manage().window().maximize();
	}

	public void enterAnnualPay(String amount) {
		enterPayAmount(amount);
		clickAnnually();
		clickContinue();
	}

	private void enterPayAmount(String amount) {
		findAndSendKeys(PAY_INPUT, amount);
	}

	private void clickAnnually() {
		findAndClick(ANNUAL_RADIO_BTN);
	}

	public boolean displayAmountError() {
		return checkElementIsVisible(AMOUNT_PAID_ERROR);
	}
}
