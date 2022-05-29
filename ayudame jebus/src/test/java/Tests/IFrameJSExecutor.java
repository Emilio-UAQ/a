package Tests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Poms.GooglePage;
import Poms.W3Schools;

public class IFrameJSExecutor {
	private WebDriver driver;

	private W3Schools w3schools;
	private GooglePage googlePage;

	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void test() throws InterruptedException {
		// Goes to page
		driver.get("https://www.w3schools.com/html/html_iframe.asp");
		// driver.get("https://www.google.com");
		w3schools = new W3Schools(driver);
		googlePage = new GooglePage(driver);
		driver.manage().window().maximize();
		Thread.sleep(10000);
		// assertTrue(w3schools.clickTryYSButton());
		// assertTrue(w3schools.scrollToElement("(//a[text()='Try it Yourself
		// »'])[1]"));
		assertTrue(w3schools.switchToFrame("iframe[title='W3Schools HTML Tutorial']"));
		assertTrue(w3schools.clickCSSTab());
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		assertTrue(w3schools.clickCSSTab());
		assertTrue(w3schools.clickTabByText("R Tutorial"));
		Thread.sleep(5000);
		assertTrue(w3schools.clickTabByText("Bootstrap Tutorial"));
		Thread.sleep(5000);

	}

	@After
	public void teardown() {
		driver.quit();
	}
}