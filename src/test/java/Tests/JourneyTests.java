package Tests;

import PageObjests.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JourneyTests {

	public static  WebDriver driver = new ChromeDriver();
	private final PayPage payPage = new PayPage(driver);
	private final StatePensionPage statePensionPage = new StatePensionPage(driver);
	private final TaxCodePage taxCodePage = new TaxCodePage(driver);
	private final AnswersPage answerPage = new AnswersPage(driver);
	private final ResultsPage resultsPage = new ResultsPage(driver);
	private final ScottishTaxPage scottishTaxPage = new ScottishTaxPage(driver);

	@BeforeEach
	public void initialSetup() { payPage.goToURL(); }

	@AfterEach
	public void deleteCookies() { driver.manage().deleteAllCookies(); }

	@AfterAll
	public static void tearDown() { driver.quit(); }

	@Test
	public void navigateToResultsPage() {
		payPage.enterAnnualPay("24000");
		statePensionPage.belowStatePensionAge();
		taxCodePage.enterTaxCode1250L();
		answerPage.clickGetResults();
		Assertions.assertTrue(resultsPage.isRestartButtonVisible());
	}

	@Test
	public void navigateToResultsPageWithoutTaxCode() {
		payPage.enterAnnualPay("24000");
		statePensionPage.belowStatePensionAge();
		taxCodePage.clickContinue();
		scottishTaxPage.noScottishIncomeTax();
		answerPage.clickGetResults();
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
