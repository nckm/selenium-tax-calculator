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
	public void taxCodeEmpty() {
		payPage.enterAnnualPay("24000");
		statePensionPage.belowStatePensionAge();
		taxCodePage.clickContinue();
		scottishTaxPage.noScottishIncomeTax();
		answerPage.clickGetResults();
		Assertions.assertTrue(resultsPage.isRestartButtonVisible());
	}
}
