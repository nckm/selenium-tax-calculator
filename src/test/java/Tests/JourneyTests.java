package Tests;

import PageObjests.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JourneyTests {

	public static  WebDriver driver = new ChromeDriver();
	private PayPage payPage = new PayPage(driver);
	private StatePensionPage statePensionPage = new StatePensionPage(driver);
	private TaxCodePage taxCodePage = new TaxCodePage(driver);
	private AnswersPage answerPage = new AnswersPage(driver);
	private ResultsPage resultsPage = new ResultsPage(driver);
	private ScottishTaxPage scottishTaxPage = new ScottishTaxPage(driver);

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
		Assertions.assertTrue(resultsPage.isRestartButtonVisible(), "Successfully navigated through each page ending on the results page.");
	}

	@Test
	public void navigateToResultsPageWithoutTaxCode() {
		payPage.enterAnnualPay("24000");
		statePensionPage.belowStatePensionAge();
		taxCodePage.clickContinue();
		scottishTaxPage.noScottishIncomeTax();
		answerPage.clickGetResults();
		Assertions.assertTrue(resultsPage.isRestartButtonVisible(), "Successfully navigated to the results page without entering a tax code.");
	}

	@Test
	public void enterOver10000000AnnualIncome() {
		enterAnnualPay("10000001", "Error displayed when entered over 10000000 in amount paid.");
	}

	@Test
	public void enterLessThanOneAnnualIncome() {
		enterAnnualPay("0", "Error displayed when entered less than 1 in amount paid.");
	}

	@Test
	public void enterStringAnnualIncome() {
		enterAnnualPay("One", "Error displayed when a String that isn't a number is entered in amount paid.");
	}

	@Test
	public void leavePayPeriodBlank() {
		payPage.enterPayWithoutPeriod("24000");
		Assertions.assertTrue(payPage.displayPayPeriodError(), "Error displayed when pay period left blank.");
	}

	private void enterAnnualPay(String amount, String message) {
		payPage.enterAnnualPay(amount);
		Assertions.assertTrue(payPage.displayAmountError(), message);
	}
}
