package com.accesshq.pages;

import com.microsoft.playwright.Page;

public class PG_Books {
	
	private Page page;

	public static String lnk_Books() {
		return "//div[@class='header-menu']/ul[@class='top-menu']//a[contains(text(),'Books')]";
	}

	public static String btn_AddToCartHealthBook() {
		return "//a[text()='Health Book']/../following-sibling::div[@class='add-info']//input";
	}

	
}
