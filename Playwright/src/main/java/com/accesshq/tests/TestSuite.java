package com.accesshq.tests;

import org.testng.annotations.Test;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Paths;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.accesshq.pages.PG_Books;
import com.accesshq.pages.PG_Checkout;
import com.accesshq.pages.PG_Home;
import com.accesshq.pages.PG_Login;
import com.accesshq.pages.PG_ShoppingCart;
import com.accesshq.pages.PG_ThankYou;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestSuite extends TestFunctions {
	
	@Test
	public void tc_01() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height).setRecordVideoDir(Paths.get("videos/"))
				  .setRecordVideoSize(width, height));
		Page page = browserContext.newPage();
		page.navigate("https://demowebshop.tricentis.com");
		page.getByText("Log in").click();
		page.locator(PG_Login.tf_Username()).fill("kavindudilshan.wackwellagamage@accesshq.com");
		page.locator(PG_Login.tf_Password()).fill("Welcome@123");
		page.locator(PG_Login.btn_Signin()).click();
		System.out.println(page.title());
		
		page.locator(PG_Books.lnk_Books()).click();
		page.locator(PG_Books.btn_AddToCartHealthBook()).click();
		
		page.locator(PG_ShoppingCart.lnk_ShoppingCart()).click();
		page.locator(PG_ShoppingCart.chk_TermsofService()).click();
		page.locator(PG_ShoppingCart.btn_Checkout()).click();
		
		page.click(PG_Checkout.btn_Continue());
		page.click(PG_Checkout.btn_ContinueShipping());
		page.click(PG_Checkout.btn_ContinueShippingMethod());
		page.click(PG_Checkout.btn_ContinuePaymentMethod());
		page.click(PG_Checkout.btn_ContinuePaymentInfo());

		page.locator(PG_Checkout.btn_Confirm()).click();
		
		String lbl_OrderCompleted=  page.locator(PG_ThankYou.lbl_OrderCompleted()).textContent();
		System.out.println("Order Complete Message is = "+ lbl_OrderCompleted);
		
		String lbl_OrderNumber=  page.locator(PG_ThankYou.lbl_OrderNumber()).textContent();
		System.out.println(lbl_OrderNumber.trim());
		
		
		
	}

}
