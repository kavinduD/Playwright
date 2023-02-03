package com.accesshq.pages;

import com.microsoft.playwright.Page;

public class PG_Home {
	
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

}
