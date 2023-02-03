package com.accesshq.pages;

import com.microsoft.playwright.Page;

public class PG_Checkout {
	
	private Page page;

	public static String btn_Continue() {
		return "//li[@class='tab-section allow active']//div[@class='step a-item' and @style]//input[@value='Continue']";
	}
	
	public static String btn_Confirm() {
		return "[value='Confirm']";
	}
	
	public static String btn_ContinueShipping() {
		return "//input[@onclick='Shipping.save()']";
	}
	
	public static String btn_ContinueShippingMethod() {
		return "//input[@onclick='ShippingMethod.save()']";
	}
	
	public static String btn_ContinuePaymentMethod() {
		return "//input[@onclick='PaymentMethod.save()']";
	}
	
	public static String btn_ContinuePaymentInfo() {
		return "//input[@onclick='PaymentInfo.save()']";
	}
}
