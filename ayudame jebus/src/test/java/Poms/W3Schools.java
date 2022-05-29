package Poms;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class W3Schools {
	private WebDriver driver;
	private JavascriptExecutor js;
	private String buttonLoc = "(//a[text()='Try it Yourself »'])[1]";
	private String cssTabLoc = "(//a[@title='CSS Tutorial'])[1]";
	private String tabsLoc = "//a[@class='w3-bar-item w3-button']";

	public W3Schools(WebDriver driver) {
		super();
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
	}

	public boolean clickTryYSButton() {
		boolean flag = false;
		try {
			WebElement button = driver.findElement(By.xpath(buttonLoc));
			button.click();
			flag = true;
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
			e.printStackTrace();
		}
		return flag;

	}

	public boolean scrollToElement(String xpath) {
		boolean flag = false;
		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			js.executeScript("arguments[0].scrollIntoView();", element);
			flag = true;
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
			e.printStackTrace();
		}
		return flag;
	}

	public boolean clickCSSTab() {
		boolean flag = false;
		try {
			WebElement button = driver.findElement(By.xpath(cssTabLoc));
			button.click();
			flag = true;
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
			e.printStackTrace();
		}
		return flag;
	}

	public boolean switchToFrame(String xpath) {
		boolean flag = false;
		try {
			driver.switchTo().frame(driver.findElement(By.cssSelector(xpath)));
			flag = true;

		} catch (Exception e) {
			System.out.println("Something went wrong :(");
			e.printStackTrace();
		}
		return flag;

	}

	public boolean clickTabByText(String value) {
		boolean flag = false;
		String text = null;
		try {
			ArrayList<WebElement> tabs = new ArrayList<WebElement>(driver.findElements(By.xpath(tabsLoc)));
			/*
			 * for(int i=0; i<tabs.length(); i++){ WebElement aux = tabs.getByIndex(i);
			 * System.out.println(aux.getAttribute("Tittle") if(aux.equals........){
			 * aux.clicl(); flag = true; break;
			 * 
			 * }
			 * 
			 */
			for (WebElement aux : tabs) {
				text = aux.getAttribute("Title");
				System.out.println(text);
				if (text.equals(value)) {
					aux.click();
					flag = true;
					break;
				}

			}
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
			e.printStackTrace();
		}

		return flag;
	}
}