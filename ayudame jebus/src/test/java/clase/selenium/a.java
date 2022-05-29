package clase.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.Thread;

public class a {
	private WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void test() throws InterruptedException {
		// Goes to page
		driver.get("http://automationpractice.com/index.php");
		Thread.sleep(2000);
		WebElement searchInput = driver. findElement(By.id ("search_query_top"));
	}
	
	@After
	public void teardown() {
		//driver.quit();
	}

}
