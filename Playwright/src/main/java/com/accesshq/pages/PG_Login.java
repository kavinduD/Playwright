package com.accesshq.pages;

import com.microsoft.playwright.Page;

public class PG_Login {
	
	public static String tf_Username() {
		return "[name='Email']";
	}

	public static String tf_Password() {
		return "[name='Password']";
	}

	public static String btn_Signin() {
		return "[value='Log in']";
	}
	
	public static String lnk_Login() {
		return "'Log in'";
	}

}
