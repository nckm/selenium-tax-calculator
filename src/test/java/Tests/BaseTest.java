package Tests;

import PageObjests.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	public static  WebDriver driver = new ChromeDriver();
	private HomePage homepage = new HomePage(driver);

	@BeforeEach
	public void initialSetup() { homepage.goTo(); }
}
