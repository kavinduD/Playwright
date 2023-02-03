package com.accesshq.config;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Paths;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Base {

	public static Playwright playwright;
	public static Browser browser;
	public static BrowserContext browserContext;
	public static Page page;

	//public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	
	@BeforeTest
	public void setUp() {
		playwright = Playwright.create();
		BrowserType chromium = playwright.chromium();
		/*
		 * To run the tests, you must initiate the browser.
		 * Using Playwright, you can use the object of the Browser class, an instance of Chromium, Firefox, or Webkit.
		 */
		browser = chromium.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		/*
		 * The Playwright framework achieves parallelization using browser contexts.
		 * The browser contexts are like incognito-like profiles isolated within a browser instance.
		 */
		browserContext = browser.newContext();
		/*
		 * It is a new tab (or pop window) within a browser context.
		 * Every action on the test will be performed on the page.
		 */
		page = browserContext.newPage();
		//test.get().pass("Hello from setUp");

	}
	
	@AfterTest
	public void closeUp() {
		browserContext.close();
		page.close();
	}
	
	
}
