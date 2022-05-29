package Tests;

import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import Poms.GooglePage;
import Poms.PracticePage;

public class WindowManager {
	private WebDriver driver;
	private GooglePage google;
	private PracticePage practicePage;
	private ChromeOptions options1 = new ChromeOptions();
	private String[] pages = {"a", "www.google.com.mx", "www.facebook.com", "www.twitter.com", "www.reddit.com", "www.netflix.com"};

	@Before
	public void setup() {
		options1.addArguments("--disable-popup-blocking");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options1);
		options1.merge(capabilities);
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		driver = new ChromeDriver(options1);
	}

	@Test
	public void test() throws InterruptedException {
		// Goes to page
		google = new GooglePage(driver);
		practicePage = new PracticePage(driver);
		driver.get("http://google.com");
		google.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Se identifica el elemento 
		//WebElement firstResult = driver.findElement(By.xpath("//div[text()='Acepto']"));
		//Se le da click al elemento
		//firstResult.click();
		// Searchs for desired item
		assertTrue(google.writeSearch("Selenium framework practice form"));
		// Clicks first result
		assertTrue(google.clickSeleniumPage());
		// Clicks button
		assertTrue(practicePage.clickAlertButton());
		Thread.sleep(1000);
		// accepts alert
		assertTrue(practicePage.acceptAlert());
		Thread.sleep(5000);
		for (int i = 1;i < 5;i++) {
			String open = pages[i];
			assertTrue(practicePage.switchToWindowByIndex(0)); 
			// clicks new window button
			assertTrue(practicePage.clickNewWindowButton());
			// Switches to window
			Thread.sleep(3000);
			assertTrue(practicePage.switchToWindowByIndex(i));
			// Goes to google on second page
			driver.get(open);
			System.out.println(open);
			Thread.sleep(3000);
			System.out.println(driver.getTitle());
			assertTrue(practicePage.switchToWindowByIndex(0)); 
			Thread.sleep(3000);
			assertTrue(practicePage.clickTabWindowButton());
			// Changes to new tab
			assertTrue(practicePage.switchToWindowByIndex(i)); 
			Thread.sleep(2000);
			driver.get(pages[i]);
			System.out.println(driver.getTitle());
			System.out.println(pages[i]);
		}
		Thread.sleep(10000);
	}

	@After
	public void teardown() {
		driver.quit();
	}

}