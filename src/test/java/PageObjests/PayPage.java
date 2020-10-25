package PageObjests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PayPage extends BasePage {

	private static final String URL = "https://www.tax.service.gov.uk/estimate-paye-take-home-pay/your-pay";

	private static final By PAY_INPUT = By.cssSelector("#amount");
	private static final By ANNUAL_RADIO_BTN = By.cssSelector("#period-5 + label");
	private static final By AMOUNT_PAID_ERROR = By.cssSelector("#amount-error");
	private static final By PAY_PERIOD_ERROR = By.cssSelector("#period-error");
	private static By CONTINUE_BTN = By.cssSelector("#button-continue");

	public PayPage(WebDriver driver) {
		super(driver);
	}

	public void goToURL() {
		driver.get(URL);
		driver.manage().window().maximize();
	}

	public StatePensionPage enterAnnualPay(String amount) {
		enterPayAmount(amount);
		clickAnnually();
		clickContinue();
		return new StatePensionPage(driver);
	}

	private PayPage enterPayAmount(String amount) {
		findAndSendKeys(PAY_INPUT, amount);
		return this;
	}

	private PayPage clickAnnually() {
		findAndClick(ANNUAL_RADIO_BTN);
		return this;
	}

	private StatePensionPage clickContinue() {
		findAndClick(CONTINUE_BTN);
		return new StatePensionPage(driver);
	}

	public boolean displayAmountError() { return checkElementIsVisible(AMOUNT_PAID_ERROR); }

	public void enterPayWithoutPeriod(String amount) {
		enterPayAmount(amount);
		clickContinue();
	}

	public boolean displayPayPeriodError() { return checkElementIsVisible(PAY_PERIOD_ERROR); }
}
