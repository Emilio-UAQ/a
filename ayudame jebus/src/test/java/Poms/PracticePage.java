package Poms;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticePage {
	WebDriver driver;
	private String alertButton = "//button[text()='Alert Box']";
	private String windowButton = "//button[text()='New Browser Window']";
	private String tabButton = "//button[text()='New Browser Tab']";

	public PracticePage(WebDriver driver) {
		super();
		this.driver = driver;
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

	public boolean acceptAlert() {
		boolean flag = false;
		try {
			this.driver.switchTo().alert().accept();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean clickNewWindowButton() {
		boolean flag = false;
		try {
			WebElement button = driver.findElement(By.xpath(windowButton));
			button.click();
			flag = true;
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
			e.printStackTrace();
		}
		return flag;
	}

	public boolean switchToWindowByIndex(int index) {
		boolean flag = false;
		try {
			Set<String> windows = driver.getWindowHandles();
			int totalWin = windows.size();
			String winTitle = null;
			for (int i = 0; i < totalWin; i++) {
				if (i == index) {
					winTitle = windows.toArray()[i].toString();
				}
				// System.out.println(windows.toArray()[i].toString());
			}
			driver.switchTo().window(winTitle);
			flag = true;
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean clickTabWindowButton() {
		boolean flag = false;
		try {
			WebElement button = driver.findElement(By.xpath(tabButton));
			button.click();
			flag = true;
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
			e.printStackTrace();
		}
		return flag;
	}

	
	public boolean switchTabByIndex(int index) {
		boolean flag = false;
		try {
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(index));
			flag = true;
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
			e.printStackTrace();
		}
		return flag;
	}

	public boolean switchWindowByTitle(String title) {
		boolean flag = true;
		int index = 0;
		try {
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			for (int i = 0; i < tabs2.size(); i++) {
				driver.switchTo().window(tabs2.get(i));
				System.out.println(driver.getTitle());
				if (driver.getTitle().equals(title)) {
					System.out.println("Entro");
					break;
				}

			}

			flag = true;
		} catch (Exception e) {
			System.out.println("Something went wrong :(");
			e.printStackTrace();
		}
		return flag;
	}

}