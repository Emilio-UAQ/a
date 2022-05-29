package clase.selenium;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.lang.Thread;
import static org.junit.Assert.assertTrue;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import Poms.pomJebus;

public class ayudameJebus {
	
	private String rolón;
	private WebDriver driver;
	private pomJebus google;
	private ChromeOptions options = new ChromeOptions();
	
	@Before
	public void setup() {

		//Se añaden argumentos a las opciones de ChromeDriver
		options.addArguments("--disable-popup-blocking");
		//options.addArguments("--headless");
		//Se declaran las capabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
		driver = new ChromeDriver(options);
		
	}
	
	@Test
	public void test() throws InterruptedException {
		
		//Se declara el scanner
		Scanner leer = new Scanner (System.in);
		//Se imprime texto en consola
		System.out.print("Ingrese la canción");
		//Se lee la siguiente línea
		String rolon = leer.next();
		//Espera 10 segundos
		Thread.sleep(10000);
        google = new pomJebus(driver);
       	//Se va a Google
        driver.get("http://google.com");
        //Se agrega un timeout
        google.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      	//Se busca Youtube
        assertTrue(google.writeSearch("Youtube"));
        //Clickea primer resultado
        assertTrue(google.clickFirstResult());
        //Espera 2 segundos
        Thread.sleep(2000);
        //Se realiza la búsqueda de la canción
        assertTrue(google.writeSearch2(rolon));
        //Espera 2 segundos
    	Thread.sleep(2000);
    	//Se mete al primer resultado de la búsqueda
		assertTrue(google.clickFirstResult2());
        //Espera 4 segundos
    	Thread.sleep(4000);
    	//Se imprime en consola el título de la pestaña
    	System.out.println(driver.getTitle());
        //Espera 10 segundos
    	Thread.sleep(10000);
		
	}

	@After
	public void teardown() throws InterruptedException {
		
		Thread.sleep(20000);//Espera 20 segundos
		driver.quit();
		
	}

}
