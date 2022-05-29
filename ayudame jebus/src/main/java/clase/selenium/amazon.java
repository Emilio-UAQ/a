package clase.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.lang.Thread;

public class amazon {
	private WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void test() throws InterruptedException {	
		// Goes to page
		driver.get("http://amazon.com.mx");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);//Espera 2 segundos
		WebElement inputText = driver.findElement(By.xpath("//input[@name = 'field-keywords']"));//Se identifica el elemento 
		inputText.sendKeys("Samsung");//Se le manda el texto a escribir
		inputText.sendKeys(Keys.ENTER); //Simula un enter 
		Thread.sleep(2000);//Espera 2 segundos
		WebElement firstResult = driver.findElement(By.xpath("//span[text()='Celulares y Smartphones Desbloqueados']"));//Se identifica el elemento 
		firstResult.click();//Se le da click al elemento
		List<WebElement> list = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		for (int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i).getText()); if (list.get(i).getText().equals("SAMSUNG")) {
			list.get(i).click(); System.out.println(i);
			}
		}
	}
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(20000);//Espera 20 segundos
		//driver.quit();
	}
}
