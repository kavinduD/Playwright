package com.accesshq.pages;

import com.microsoft.playwright.Page;

public class PG_ThankYou {
	
	private Page page;

	public static String lbl_OrderCompleted() {
		return "//div[@class='section order-completed']//strong";
	}
	
	public static String lbl_OrderNumber() {
		return "//ul[@class='details']/li[1]";
	}
}
