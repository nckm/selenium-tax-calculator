package Tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	@Test
	public void openBrowser() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.trainline.com");

		
	}
}
