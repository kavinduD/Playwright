package com.accesshq.tests;

import org.testng.annotations.Test;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Paths;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.accesshq.pages.PG_Books;
import com.accesshq.pages.PG_Checkout;
import com.accesshq.pages.PG_Home;
import com.accesshq.pages.PG_Login;
import com.accesshq.pages.PG_ShoppingCart;
import com.accesshq.pages.PG_ThankYou;
import com.accesshq.utils.data.DataReader;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestSuite3 extends TestFunctions {

	@DataProvider(name = "dt_01")
    public Object[][] dataTable_tc_01() {
        return DataReader.readExcel("tc_01");
    }

	@Test(dataProvider = "dt_01")
	public void tc_02(String tc_ID) {
		bf_Login("https://demowebshop.tricentis.com", "kavindudilshan.wackwellagamage@accesshq.com", "Welcome@123");
		bf_AddToCartHealthBook();
		bf_CheckoutShoppingCart();
		bf_ConfirmDetails();
		bf_VerifyOrderConfirmation();
	}

}
