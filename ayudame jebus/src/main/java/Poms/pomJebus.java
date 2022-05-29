package Poms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pomJebus {
	private String inputTextLoc = "//input[@name = 'q']";
	private String inputTextLoc2 = "//input[@name = 'search_query']";
	private String firstResultLoc = "//h3[@class='LC20lb MBeuO DKV0Md']";
	private String firstResultLoc2 = "//div[@class='style-scope ytd-video-renderer']";
	public WebDriver driver;

	public pomJebus(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean writeSearch(String searchValue) {
		boolean flag = false;
		try {
			WebElement inputText = driver.findElement(By.xpath(inputTextLoc));// Se identifica el elemento
			inputText.sendKeys(searchValue);
			inputText.sendKeys(Keys.ENTER);
			flag = true;
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
			e.printStackTrace();
		}
		return flag;
	}

	public boolean writeSearch2(String searchValue) {
		boolean flag = false;
		try {
			WebElement inputText2 = driver.findElement(By.xpath(inputTextLoc2));// Se identifica el elemento
			inputText2.sendKeys(searchValue);
			inputText2.sendKeys(Keys.ENTER);
			flag = true;
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
			e.printStackTrace();
		}
		return flag;
	}

	public boolean clickFirstResult() {
		boolean flag = false;
		try {
			WebElement firstResult = driver.findElement(By.xpath(firstResultLoc));
			firstResult.click();
			flag = true;
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
			e.printStackTrace();
		}
		return flag;
	}

	public boolean clickFirstResult2() {
		boolean flag = false;
		try {
			WebElement firstResult = driver.findElement(By.xpath(firstResultLoc2));
			firstResult.click();
			flag = true;
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
			e.printStackTrace();
		}
		return flag;
	}

	public boolean closeAnnoyingPopUp() {
		boolean flag = false;
		try {
			//Se identifica el elemento 
	      	WebElement firstResult = driver.findElement(By.xpath("//div[text()='Acepto']"));
	      	//Se le da click al elemento
	      	firstResult.click();
			flag = true;
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
			e.printStackTrace();
		}
		return flag;
	}
	
}
