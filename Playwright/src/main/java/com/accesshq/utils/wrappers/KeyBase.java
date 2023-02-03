package com.accesshq.utils.wrappers;

import com.aventstack.extentreports.Status;
import com.accesshq.config.Base;
import com.accesshq.pages.PG_Login;
import com.accesshq.utils.listners.ExtentReportListener;
import com.accesshq.utils.report.ExtentTestManager;
import java.time.Duration;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.testng.Assert;

public class KeyBase extends Base {

	public static void click(final String objectLocator) {

		try {
			page.locator(objectLocator).click();
			ExtentReportListener.test.get().log(Status.PASS, "Clicked on Locator: " + objectLocator);
		} catch (Exception ex) {
			ex.printStackTrace();
//			ExtentReportListener.test.get().log(Status.FAIL, "Tried to Click on Locator: " + objectLocator);
//			ExtentReportListener.test.get().log(Status.FAIL, "Exception: " + ex);
			Assert.fail("Failed to Click on: " + objectLocator);
		}
	}

	public static void clickByText(final String text) {
		try {
			page.getByText(text).click();
			ExtentReportListener.test.get().log(Status.PASS, "Clicked on Locator: " + text);
		} catch (Exception ex) {
			ex.printStackTrace();
//			ExtentReportListener.test.get().log(Status.FAIL, "Tried to Click on Locator: " + text);
			Assert.fail("Failed to Click on: " + text);
		}
	}

	public static void type(final String objectLocator, final String text) {

		try {
			page.locator(objectLocator).fill(text);
			ExtentReportListener.test.get().log(Status.PASS, "Typed Text: " + text + " on Locator: " + objectLocator);
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail("Failed to Type on: " + objectLocator);
		}
		
	}

	public static void navigateToUrl(final String url) {

		try {
			page.navigate(url);
			ExtentReportListener.test.get().log(Status.PASS, "Navigated Url : " + url );
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail("Failed to navigate to : " + url);
		}

	}

	public static int getObjectCount(String locator) {
//        ArrayList<WebElement> a = new ArrayList();
//        a = (ArrayList<WebElement>) new ArrayList<WebElement>(driver.findElements(By.xpath(locator)));
//        return a.size();
		return 0;
	}

	public static String getText(final String objectLocator) {
//        WebElement element = driver.findElement(By.xpath(objectLocator));
//        String text = null;
//        try {
//            text = element.getText();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        ExtentTestManager.getTest().log(Status.PASS, "Retrieved Text: "+text +" from Locator: "+objectLocator);
		return "";
	}

	public static void pause(int pauseTime) {
		try {
			Thread.sleep(pauseTime);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		ExtentTestManager.getTest().log(Status.PASS, "Paused for: " + pauseTime);
	}

	public static String getValue(final String objectLocator) {
//        WebElement element = driver.findElement(By.xpath(objectLocator));
//        String text = null;
//        try {
//            text = element.getAttribute("value");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        ExtentTestManager.getTest().log(Status.PASS, "Retrieved Text: "+text +" from Locator: "+objectLocator);
		return "";
	}

	public static void navigateToURL(String url) {
//        driver.get(url);
		ExtentTestManager.getTest().log(Status.PASS, "Navigated to URL: " + url);
	}

	public static void writeToReport(String comment) {
		ExtentTestManager.getTest().log(Status.INFO, comment);
	}

	public static void isDisplayed(String objectLocator) {
//        WebDriverWait wait = new WebDriverWait(driver, 20);
//        WebElement radioElem = driver.findElement(By.xpath(objectLocator));
//        By locator = By.xpath(objectLocator);
//        radioElem = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//
//        try {
//            boolean sel = radioElem.isDisplayed();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
		ExtentTestManager.getTest().log(Status.PASS, "Object locator found: " + objectLocator);
	}

	public static void pageRefresh() {
//        pause(5000);
//        try {
//            driver.navigate().refresh();
//            ExtentTestManager.getTest().log(Status.PASS, "Page Refreshed: "+ driver.getTitle());
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        pause(5000);
	}

	public static void selectByVisibleText(final String objectLocator, final String text) {
//        WebDriverWait wait = new WebDriverWait(driver, 20);
//        By locator = By.xpath(objectLocator);
//        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//
//        try {
//            Select select = new Select(element);
//            select.selectByVisibleText(text);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

		ExtentTestManager.getTest().log(Status.PASS, "Typed Text: " + text + " on Locator: " + objectLocator);
	}
}
