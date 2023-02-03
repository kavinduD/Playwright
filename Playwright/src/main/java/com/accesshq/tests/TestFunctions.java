package com.accesshq.tests;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Paths;

import com.accesshq.config.Base;
import com.accesshq.pages.PG_Books;
import com.accesshq.pages.PG_Checkout;
import com.accesshq.pages.PG_Login;
import com.accesshq.pages.PG_ShoppingCart;
import com.accesshq.pages.PG_ThankYou;
import com.accesshq.utils.listners.ExtentReportListener;
import com.accesshq.utils.report.ExtentTestManager;
import com.accesshq.utils.wrappers.KeyBase;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Page;

public class TestFunctions extends KeyBase{
	
	
	public void bf_Login(String url, String Username, String Password) {
		ExtentReportListener.test.get().log(Status.PASS, "Start of bf_Login function");
		navigateToUrl(url);
		clickByText("Log in");
		type(PG_Login.tf_Username(),Username);
		type(PG_Login.tf_Password(),Password);
		click(PG_Login.btn_Signin());
		System.out.println(page.title());
		ExtentReportListener.test.get().log(Status.PASS, "End of bf_Login function");
	}

	public void bf_AddToCartHealthBook() {
		ExtentReportListener.test.get().log(Status.PASS, "Start of bf_AddToCartHealthBook function");
		click(PG_Books.lnk_Books());
		page.locator(PG_Books.btn_AddToCartHealthBook()).waitFor();
		click(PG_Books.btn_AddToCartHealthBook());
		ExtentReportListener.test.get().log(Status.PASS, "End of bf_AddToCartHealthBook function");
	}
	
	public void bf_CheckoutShoppingCart() {
		ExtentReportListener.test.get().log(Status.PASS, "Start of bf_CheckoutShoppingCart function");
		page.locator(PG_ShoppingCart.ele_BarNotification()).waitFor();
		click(PG_ShoppingCart.lnk_ShoppingCart());
		page.locator(PG_ShoppingCart.chk_TermsofService()).waitFor();
		click(PG_ShoppingCart.chk_TermsofService());
		click(PG_ShoppingCart.btn_Checkout());
		ExtentReportListener.test.get().log(Status.PASS, "End of bf_CheckoutShoppingCart function");
	}
	
	public void bf_ConfirmDetails() {
		ExtentReportListener.test.get().log(Status.PASS, "Start of bf_ConfirmDetails function");
		page.click(PG_Checkout.btn_Continue());
		page.click(PG_Checkout.btn_ContinueShipping());
		page.click(PG_Checkout.btn_ContinueShippingMethod());
		page.click(PG_Checkout.btn_ContinuePaymentMethod());
		page.click(PG_Checkout.btn_ContinuePaymentInfo());

		page.locator(PG_Checkout.btn_Confirm()).click();

		ExtentReportListener.test.get().log(Status.PASS, "End of bf_ConfirmDetails function");
	}
	
	public void bf_VerifyOrderConfirmation() {
		ExtentReportListener.test.get().log(Status.PASS, "Start of bf_VerifyOrderConfirmation function");
		String lbl_OrderCompleted=  page.locator(PG_ThankYou.lbl_OrderCompleted()).textContent();
		System.out.println("Order Complete Message is = "+ lbl_OrderCompleted);
			
		String lbl_OrderNumber=  page.locator(PG_ThankYou.lbl_OrderNumber()).textContent();
		System.out.println(lbl_OrderNumber.trim());
		ExtentReportListener.test.get().log(Status.PASS, "End of bf_VerifyOrderConfirmation function");
	}
	
	public void bf_Login_1(String url, String Username, String Password) {		
		ExtentReportListener.test.get().log(Status.PASS, "bf_Login Started");
		navigateToUrl(url);
		//page.navigate(url);
		clickByText("Log in");
		type(PG_Login.tf_Username(), Username);
		type(PG_Login.tf_Password(), Password);
		click(PG_Login.btn_Signin());		
		System.out.println(page.title());
		ExtentReportListener.test.get().log(Status.PASS, "bf_Login Ended");
	}

}
