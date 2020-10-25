package Tests;

import PageObjests.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JourneyTests {

	public static WebDriver driver = new ChromeDriver();
	private final PayPage payPage = new PayPage(driver);
	private final ResultsPage resultsPage = new ResultsPage(driver);

	@BeforeEach
	public void initialSetup() { payPage.goToURL(); }

	@AfterEach
	public void deleteCookies() { driver.manage().deleteAllCookies(); }

	@AfterAll
	public static void tearDown() { driver.quit(); }

	@Test
	public void navigateToResultsPage() {
		payPage.enterAnnualPay("2400")
				.belowStatePensionAge()
				.enterTaxCode1250L()
				.clickGetResults();

		Assertions.assertTrue(resultsPage.isRestartButtonVisible());
	}

	@Test
	public void navigateToResultsPageWithoutTaxCode() {
		payPage.enterAnnualPay("24000")
				.belowStatePensionAge()
				.continueWithoutTaxCode()
				.noScottishIncomeTax()
				.clickGetResults();

		Assertions.assertTrue(resultsPage.isRestartButtonVisible());
	}

	@Test
	public void enterOver10000000AnnualIncome() {
		enterAnnualPay("10000001");
	}

	@Test
	public void enterLessThanOneAnnualIncome() {
		enterAnnualPay("0");
	}

	@Test
	public void enterStringAnnualIncome() {
		enterAnnualPay("One");
	}

	@Test
	public void leavePayPeriodBlank() {
		payPage.enterPayWithoutPeriod("24000");
		Assertions.assertTrue(payPage.displayPayPeriodError());
	}

	private void enterAnnualPay(String amount) {
		payPage.enterAnnualPay(amount);
		Assertions.assertTrue(payPage.displayAmountError());
	}
}
