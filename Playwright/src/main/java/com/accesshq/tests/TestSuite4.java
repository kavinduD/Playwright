package com.accesshq.tests;

import com.accesshq.pages.*;
import com.accesshq.utils.data.DataReader;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.nio.file.Paths;

public class TestSuite4 extends TestFunctions {

    @Test
    public void tc_01() {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://demowebshop.tricentis.com/register");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Log in")).click();
        page.getByLabel("Email:").click();
        page.getByLabel("Email:").fill("kavindudilshan.wackwellagamage@accesshq.com");
        page.getByLabel("Password:").click();
        page.getByLabel("Password:").fill("Welcome@123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();

//        page.getByRole(AriaRole.LIST).filter().getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Books")).click();
//        page.getByRole(AriaRole.LISTITEM).filter().getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Computers")).click();
//        page.getByRole(AriaRole.LIST).filter().getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Apparel & Shoes")).click();
//        page.getByRole(AriaRole.LIST).filter().getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Digital downloads")).click();

    }
}
