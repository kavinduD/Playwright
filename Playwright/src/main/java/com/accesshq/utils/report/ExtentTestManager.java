package com.accesshq.utils.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

import org.testng.ITestResult;

public class ExtentTestManager {
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentReports extent = ExtentManager.getExtentReports();
    
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>(); 
    
    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }
    
//    public static synchronized ExtentTest getTest_1(ITestResult iTestResult) {
//        return test.get().getModel().getStatus().toString();
//    }
    
    public static synchronized ExtentTest createTest(ITestResult iTestResult) {
//      return extentTestMap.get((int) Thread.currentThread().getId());
  	return extent.createTest(iTestResult.getMethod().getConstructorOrMethod().getName());
  }
    
    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.createTest(testName, desc);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }
}
