package base;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePageObjects {
	
	public static void postUrl(WebDriver driver, String baseUrl) {
		try {
			driver.get(baseUrl);
			driver.manage().window().maximize();
		} catch (WebDriverException e) {
			System.out.println("Cannot get the requested url" + baseUrl);
		}
	}

	protected static String getElementText(WebDriver driver, By by) {
		return getElementText( driver.findElement(by));
	}

	protected static String getElementText( WebElement element) {
		return element.getText();
	}

	protected static String getTextboxText( WebDriver driver, By by) {
		return getTextboxText( driver.findElement(by));
	}

	protected static String getTextboxText( WebElement element) {
		return element.getAttribute("value");
	}

	protected static void selectInput( WebDriver driver, By by,
			String value) {
		selectInput( driver.findElement(by), value);
	}

	protected static void selectInput( WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	protected static void enterValueIntoTextBox( WebDriver driver,
			By by, String str, boolean clear) {
		enterValueIntoTextBox( driver.findElement(by), str, clear);
	}

	protected static void enterValueIntoTextBox( WebElement element,
			String str, boolean clear) {
		if (clear)
			element.clear();
		element.sendKeys(str);
	}

	protected static void clickElement( WebDriver driver, By by) {
		clickElement( driver, driver.findElement(by));
	}

	protected static void clickElement( WebDriver driver,
			WebElement element) {
		waitForClickable( driver, element, 5);
		element.click();
	}

	protected static void waitForFrame( WebDriver driver, By by,
			int duration) {
		try {
			new WebDriverWait(driver, duration).until(ExpectedConditions
					.frameToBeAvailableAndSwitchToIt(by));
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
		}
	}

	protected static void containsText( WebDriver driver, By by,
			String str, boolean caseSensitive) {
		containsText( driver.findElement(by), str, caseSensitive);
	}

	protected static void containsText( WebElement element, String str,
			boolean caseSensitive) {
		
		if (caseSensitive)
			Assert.assertTrue(element.getText().contains(str));
		else
			Assert.assertTrue(element.getText().toLowerCase()
					.contains(str.toLowerCase()));
	}

	protected static void assertText( WebDriver driver, By by,
			String str, boolean caseSensitive) {
		assertText( driver.findElement(by), str, caseSensitive);
	}

	protected static void assertText( WebElement element, String str,
			boolean caseSensitive) {
		if (caseSensitive)
			Assert.assertEquals(element.getText().trim(), str.trim());
		else
			Assert.assertEquals(element.getText().toLowerCase().trim(), str
					.toLowerCase().trim());
	}

	protected static void assertExists( WebDriver driver, By by) {
		assertExists( driver, driver.findElement(by));
	}

	protected static void assertExists( WebDriver driver,
			WebElement element) {
		waitForElementVisible( driver, element, 10);
		Assert.assertTrue(element.isDisplayed());
	}

	protected static void mouseOver( WebDriver driver, By by) {
		mouseOver( new Actions(driver), driver.findElement(by));
	}

	protected static void mouseOver( Actions actions, WebElement element) {
		actions.moveToElement(element).perform();
	}

	
	protected static void waitForClickable( WebDriver driver, By by,
			int duration) {
		for (int x = 0; x <= 5; x++) {
			try {
				new WebDriverWait(driver, duration).until(ExpectedConditions
						.elementToBeClickable(by));
				break;
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}
		}
	}

	protected static void waitForClickable( WebDriver driver,
			WebElement element, int duration) {
		for (int x = 0; x <= 5; x++) {
			try {
				new WebDriverWait(driver, duration).until(ExpectedConditions
						.elementToBeClickable(element));
				break;
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}
		}
	}

	protected static void waitForElementVisible( WebDriver driver,
			By by, int duration) {
		for (int x = 0; x <= 5; x++) {
			try {
				new WebDriverWait(driver, duration).until(ExpectedConditions
						.visibilityOfElementLocated(by));
				break;
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}
		}
	}

	protected static void waitForElementVisible( WebDriver driver,
			WebElement element, int duration) {
		for (int x = 0; x <= 5; x++) {
			try {
				new WebDriverWait(driver, duration).until(ExpectedConditions
						.visibilityOf(element));
				break;
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected static void wait(WebDriver driver, int w) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(w, TimeUnit.SECONDS);
	}

	public static void waitForPageLoad() {
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}