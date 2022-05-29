package clase.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class youtube {

    private WebDriver driver;

    private ChromeOptions options = new ChromeOptions();
    @before
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        options.addArguments("--disable-popup-blocking");
        //options.addArguments("--headless");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        driver = new ChromeDriver(options);


    }

    @Test
    public void test() throws InterruptedException{

        Scanner entrada=new Scanner (System.in);
        // Goes to page

        System.out.print("Ingrese la canción");
        String cancion = entrada.next();
        driver.get("http://google.com/");
        Thread.sleep(2500);

        WebElement inputText = driver.findElement(By.xpath("//input[@name = 'q']"));
        Object google;
		assertTrue(google.writeSearch("cancion"));
           inputText.sendKeys("Youtube.com");
        inputText.sendKeys(Keys.ENTER);
        Thread.sleep(2500);
        WebElement inputText1 = driver.findElement(By.xpath("search-container"));
        inputText1.sendKeys("cancion");
        inputText1.sendKeys(Keys.ENTER);

        assertTrue(google.clickFirstResult());
        Thread.sleep(2500);
        System.out.println(driver.getTitle());

    }

}

Enviar mensaje a #general
