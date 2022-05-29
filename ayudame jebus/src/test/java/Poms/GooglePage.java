package Poms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {
	private String pageLoc = "//h3[text()='Practiceform - Selenium Framework']";
	private String inputTextLoc = "//input[@name = 'q']";
	private String firstResultLoc = "//h3[@class='LC20lb MBeuO DKV0Md']";
	private String alertButton = "//button[text()='Alert Box']";
	public WebDriver driver;

	public GooglePage(WebDriver driver) {
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
	
	public boolean clickSeleniumPage() {
		boolean flag = false;
		try {
			WebElement firstResult = driver.findElement(By.xpath(pageLoc));
			firstResult.click();
			flag = true;
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean clickAlertButton() {
		boolean flag = false;
		try {
			WebElement button = driver.findElement(By.xpath(alertButton));
			button.click();
			flag = true;
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
			e.printStackTrace();
		}
		return flag;
	}
}