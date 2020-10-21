package PageObjests;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) { super(driver); }

	private static String URL = "URL_GOES_HERE";

	public void goTo() { driver.get(URL); }
}
