package Tests;

import PageObjests.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JourneyTests {

	public static  WebDriver driver = new ChromeDriver();
	private PayPage payPage = new PayPage(driver);
	private StatePensionPage statePensionPage = new StatePensionPage(driver);
	private TaxCodePage taxCodePage = new TaxCodePage(driver);
	private AnswersPage answerPage = new AnswersPage(driver);
	private ResultsPage resultsPage = new ResultsPage(driver);

	@BeforeEach
	public void initialSetup() { payPage.goToURL(); }

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


}
