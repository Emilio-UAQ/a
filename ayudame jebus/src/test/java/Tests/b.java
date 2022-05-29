package Tests;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Poms.GooglePage;

public class b {
	private WebDriver driver;
	private GooglePage google;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void test() throws InterruptedException {
		// Goes to page
		google = new GooglePage(driver);
		driver.get("http://google.com");
		google.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Searchs for desired item
		assertTrue(google.writeSearch("Selenium framework practice form"));
		// Clicks first result
		assertTrue(google.clickFirstResult());

	}

	@After
	public void teardown() {
		driver.quit();
	}

}
