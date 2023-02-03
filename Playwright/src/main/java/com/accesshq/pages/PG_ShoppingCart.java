package com.accesshq.pages;

import com.microsoft.playwright.Page;

public class PG_ShoppingCart {
	
	private Page page;

	public static String lnk_Computers() {
		return "//div[@class='header-menu']/ul[@class='top-menu']//a[contains(text(),'Computers')]";
	}

	public static String lnk_Science() {
		return "//a[text()='Science']";
	}

	public static String btn_Signin() {
		return "[value='Log in']";
	}
	
	public static String lnk_Login() {
		return "'Log in'";
	}
	
	public static String lnk_ShoppingCart() {
		return "//span[text()='Shopping cart']";
	}

	public static String chk_TermsofService() {
		return "//div[@class='terms-of-service']//input[@name='termsofservice']";
	}
	
	public static String btn_Checkout() {
		return "[value='checkout']";
	}

	//p[text()='The product has been added to your ']/a
	public static String ele_BarNotification() {
		return "//p[text()='The product has been added to your ']/a";
	}
}
