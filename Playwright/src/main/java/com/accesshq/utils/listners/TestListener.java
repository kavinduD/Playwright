package com.accesshq.utils.listners;

import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Page;
import com.accesshq.config.Base;
import com.accesshq.utils.log.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.nio.file.Paths;
import java.util.Objects;

import static com.accesshq.utils.report.ExtentManager.getExtentReports;
import static com.accesshq.utils.report.ExtentTestManager.getTest;
import static com.accesshq.utils.report.ExtentTestManager.createTest;

public class TestListener extends Base implements ITestListener {
	
	Page page;
	
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        Log.info("I am in onStart method " + iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Log.info("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for ExtentReports reporting!
        getExtentReports().flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is starting.");
        //ExtentReportListener.test.get().pass("Start of Test case" + getTestMethodName(iTestResult));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is succeed.");
        //ExtentReportListener.test.get().pass("End of Test case" + getTestMethodName(iTestResult));
        //ExtentReports log operation for passed tests.
//        getTest().log(Status.PASS, "Test passed");
        //createTest(iTestResult);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is failed.");
        //ExtentReportListener.test.get().pass("End of Test case" + getTestMethodName(iTestResult));
        //page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")));

//        //Get driver from BaseTest and assign to local webdriver variable.
//        Object testClass = iTestResult.getInstance();
//        WebDriver driver = ((SeleniumBase) testClass).getDriver();
//
//        //Take base64Screenshot screenshot for extent reports
//        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull("")).getScreenshotAs(OutputType.BASE64);
//
//        //ExtentReports log and screenshot operations for failed tests.
//        getTest().log(Status.FAIL, "Test Failed",
//                getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.info(getTestMethodName(iTestResult) + " test is skipped.");
        //ExtentReports log operation for skipped tests.
        getTest().log(Status.SKIP, "Test Skipped");
        //ExtentReportListener.test.get().pass("End of Test case" + getTestMethodName(iTestResult));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}
