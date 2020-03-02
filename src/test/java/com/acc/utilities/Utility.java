package com.acc.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.acc.driverfactory.BaseClass;

public class Utility {

	BaseClass baseClass;
	WebDriver driver;
	static Logger log = LogManager.getLogger(Utility.class.getName());

	public Utility(WebDriver _driver) {
		driver = _driver;
	}

	public static void waitForPageLoaded(WebDriver driver) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {

		}
	}

	/**
	 * Java Script Click on the Web element
	 * 
	 * @param By
	 *            element Locator
	 * @param String
	 *            Text
	 *
	 */
	public void Jsclick(WebElement elementLocator, String value) throws Throwable {
		boolean status = false;
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementLocator);
			status = true;
		} catch (Exception e) {
			status = false;
			throw e;
		} finally {
			if (!status) {
				Log.logError(log, "User is Unable to click on " + "\"" + value + "\"" + " locator ");
			} else if (status) {
				Log.logInfo(log, "User has clicked on " + "\"" + value + "\"" + " Locator Successfully");
			}
		}
	}

	/**
	 * Click on the Web element
	 * 
	 * @param By
	 *            element Locator
	 * @param String
	 *            text
	 *
	 */

	public void click(WebElement elementLocator, String value) throws Throwable {
		boolean status = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
			elementLocator.click();
			status = true;
		} catch (Exception e) {
			status = false;
			throw e;
		} finally {
			if (!status) {
				Log.logError(log, "User is Unable to click on " + "\"" + value + "\"" + " locator ");
			} else if (status) {
				Log.logInfo(log, "User has clicked on " + "\"" + value + "\"" + " Locator Successfully");
			}
		}
	}

	/**
	 * Validating WebElement text is matching with the expected text value
	 *
	 * @param actual
	 *            Text
	 * @param expected
	 *            Text
	 */
	public boolean verifyWebElementTextMatches(WebElement element, String expectedText) throws Throwable {
		boolean flag = false;
		String actualtext = null;
		try {
			actualtext = element.getText().trim();
			if (actualtext.equalsIgnoreCase(expectedText)) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			flag = false;
			throw e;
		} finally {
			if (flag == false) {
				Log.logError(log, "Given Actual text " + actualtext + " doesn't matches with the expected text");
			} else if (flag == true) {
				Log.logInfo(log, "Given Actual text " + actualtext + " matches with the expected text " + expectedText);
			}
		}
		return flag;
	}

	public void waitUntilClickable(WebElement el) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}
	
	
	public void waitUntilClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void waitUntilVisible(WebElement el) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(el));
	}

	public void scrollWithOffset(WebElement element, int x, int y) {
		try {

			String code = "window.scroll(" + (element.getLocation().x + x) + "," + (element.getLocation().y + y) + ");";
			((JavascriptExecutor) driver).executeScript(code, element, x, y);

		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Select the dropdown value by visible text
	 * 
	 * @param Web
	 *            Element
	 * @param String
	 *            text
	 * @return
	 * @throws Throwable 
	 */

	public boolean SelectByVisibleText(WebElement element, String indexValue) throws Throwable {
		boolean flag = false;
		try {
			Select sel = new Select(element);
			sel.selectByVisibleText(indexValue);
			flag = true;
		} catch (final Exception e) {
			flag = false;
			throw e;
		} finally {
			if (flag == false) {
				Log.logError(log, "Unable to select the dropdown value " + indexValue);
			} else if (flag == true) {
				Log.logInfo(log, "successfully selected the dropdown value- " + indexValue);

			}
		}
		return flag;
	}

	/**
	 * SendKeys on the Web element
	 * 
	 * @param By
	 *            element Locator
	 * @param String
	 *            text
	 *
	 */

	public boolean SendKeys(WebElement elementLocator, String value) throws Throwable {
		boolean status = false;
		try {
			final WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
			elementLocator.sendKeys(value);
			status = true;
		} catch (final Exception e) {
			status = false;
			throw e;
		} finally {
			if (!status) {
				Log.logError(log, "Unable to pass " + "\"" + value + "\"" + " text on the given locator.");
			} else if (status) {
				Log.logInfo(log,
						"User has successfully passed  " + "\"" + value + "\"" + " text on the given locator ");
			}
		}
		return status;
	}

}
